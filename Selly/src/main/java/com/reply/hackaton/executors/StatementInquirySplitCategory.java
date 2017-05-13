package com.reply.hackaton.executors;

import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.reply.hackaton.model.AndroidClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.hackaton.Utilities.Utility;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import com.reply.hackaton.model.TransactionHistory;
import com.reply.hackaton.repository.TransactionHistoryRepository;

@Service("Statement_Inquiry_Split_Category")
public class StatementInquirySplitCategory implements IntentExecutor {

	private static final String CARD = "Card";
	private static final String MONTH = "Month";
	private static final String CATEGORY = "Category";

	@Autowired
	TransactionHistoryRepository transactions;

	@Override
	public String execute(Response ApiAIResponse, AndroidClientResponse androidClientResponse) {
		if (ApiAIResponse.getResult().isActionIncomplete()) {
			return ApiAIResponse.getResult().getFulfillment().getSpeech();
		}
		String channel = ApiAIResponse.getResult().getParameters().get(CATEGORY);
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
			if (th.getDate().getMonth().equals(javaMonth) && th.getReadableCategory().equalsIgnoreCase(channel))
				resultTransaction.add(th);
		}
		Map<String, Double> transactionsMap = new HashMap<String, Double>();
		for (TransactionHistory th : resultTransaction) {
			String key = th.getMerchant_name()+"#"+th.getCity();
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
		sb.append("Questi I primi 5 ristornati in cui hai speso:");
		int count = 1;
		StringTokenizer tkn=null; 
		for (Entry<Double, String> entry : orderedMap.entrySet()) {
			if(count==6) break;
			tkn= new StringTokenizer(entry.getValue(),"#");
			sb.append(count + ")  "+ entry.getKey() + " € da "+tkn.nextToken() +" a " +tkn.nextToken());
			sb.append(System.getProperty("line.separator"));
		count++;
		
		}
		sb.append("Per altri dettagli posso mandarti l’estratto conto ecco il link all’estratto conto URL (estratto conto mese)");
		sb.append(System.getProperty("line.separator"));
		sb.append("Posso fare altro per te?");

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
