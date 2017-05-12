package com.reply.hackaton.executors;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.hackaton.Utilities.Utility;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import com.reply.hackaton.model.TransactionHistory;
import com.reply.hackaton.repository.TransactionHistoryRepository;

@Service("Statement_Inquiry")
public class StatemenetInquiry implements IntentExecutor {

	private static final String CARD = "Card";
	private static final String MONTH = "Month";

	@Autowired
	TransactionHistoryRepository transactions;

	@Override
	public String execute(Response ApiAIResponse) {
		if (ApiAIResponse.getResult().isActionIncomplete()) {
			return ApiAIResponse.getResult().getFulfillment().getSpeech();
		}

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
		StringBuilder sb = new StringBuilder();
		double totalExpense = 0;

		for (TransactionHistory tr : resultTransaction) {
			totalExpense += tr.getAmount();
		}
		sb.append("L’ultimo estratto conto che ti è stato addebitato di " + totalExpense + " € è relativo" + ""
				+ " alle spese che hai sostenuto dal 1° " + month + " al 31 " + month
				+ ". Hai bisogno di maggiori dettagli sulle tue spese?");

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
