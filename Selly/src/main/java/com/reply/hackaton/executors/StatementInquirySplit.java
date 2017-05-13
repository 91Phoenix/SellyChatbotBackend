package com.reply.hackaton.executors;

import java.text.DecimalFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.reply.hackaton.model.AndroidClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.hackaton.Utilities.Utility;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import com.reply.hackaton.model.TransactionHistory;
import com.reply.hackaton.repository.TransactionHistoryRepository;

@Service("Statement_Inquiry_Split")
public class StatementInquirySplit implements IntentExecutor {

	private static final String CARD = "Card";
	private static final String MONTH = "Month";

	@Autowired
	TransactionHistoryRepository transactions;

	@Override
	public String execute(Response ApiAIResponse, AndroidClientResponse androidClientResponse) {

		String card = ApiAIResponse.getResult().getParameters().get(CARD);
		if (card != null && card.equalsIgnoreCase("Allianz")) {
			card = "525500******9045";
		}
		// allo stato atuale non filtriamo veramente per carta
		String month = ApiAIResponse.getResult().getParameters().get(MONTH);
		Month javaMonth = getMonth(month);

		Iterable<TransactionHistory> iterable = transactions.findAll();
		List<TransactionHistory> resultTransaction = new ArrayList<TransactionHistory>();
		for (TransactionHistory th : iterable) {
			if (th.getDate().getMonth().equals(javaMonth))
				resultTransaction.add(th);
		}
		Map<String, Double> transactionsMap = new HashMap<String, Double>();
		for (TransactionHistory th : resultTransaction) {
			String key = th.getReadableCategory();
			if (transactionsMap.containsKey(key)) {
				double expense = transactionsMap.get(key);
				expense += th.getAmount();
				transactionsMap.replace(key, expense);
			} else {
				transactionsMap.put(key, th.getAmount());
			}
		}
		Map<Double, String> orderedMap = new TreeMap<Double, String>(Collections.reverseOrder());
		for (Entry<String, Double> e : transactionsMap.entrySet()) {
			orderedMap.put((Double) e.getValue(), (String) e.getKey());
		}

		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("line.separator"));
		sb.append("Queste sono le prime 5 categorie di spesa:");
		sb.append(System.getProperty("line.separator"));
		int count = 1;
		for (Entry<Double, String> entry : orderedMap.entrySet()) {
			if(count==6) break;
			sb.append(count + ")  " + entry.getKey() + " € in " +
					entry.getValue());
			sb.append(System.getProperty("line.separator"));
			count++;
		}
		return sb.toString();
	}

	private Month getMonth(String date) {
		for (Month m : Month.values()) {
			if (m.name().toLowerCase().contains(Utility.transformItalianInEnglishMonths(date.toLowerCase())))
				return m;
		}
		return null;
	}

}
