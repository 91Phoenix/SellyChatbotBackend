package com.reply.hackaton.configuration;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.reply.hackaton.model.Geneder;
import com.reply.hackaton.model.PersonalInformation;
import com.reply.hackaton.model.TransactionHistory;
import com.reply.hackaton.model.User;

@Component
public class modelMockUpConfiguration {

	private static final String TRANSACTION_FILE = "TransactionHystory.csv";
	private static final String USER_FILE = "User.csv";
	private static final String POPULATE_TRANSACTION_METHOD = "transactionHistoryPopulation";
	private static final String POPULATE_USER_METHOD = "userPopulation";

	private static List<User> users;
	private static List<TransactionHistory> transactions;
	
	public static final Logger logger = Logger.getLogger(modelMockUpConfiguration.class);

	public modelMockUpConfiguration() throws IllegalAccessException, IllegalArgumentException,
					InvocationTargetException, IOException, NoSuchMethodException, SecurityException {
		
		setUsers(new ArrayList<User>());
		setTransactions(new ArrayList<TransactionHistory>());
		Method method = this.getClass().getMethod(POPULATE_TRANSACTION_METHOD, CSVReader.class);
		populateMock(TRANSACTION_FILE,  method);
		logger.info("transaction history populated: ");
		//transactions.forEach(t->logger.info(t.toString()));
		method = this.getClass().getMethod(POPULATE_USER_METHOD, CSVReader.class);
		populateMock(USER_FILE, method);
		logger.info("list of users populated: ");
		//users.forEach(t->logger.info(t.toString()));
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		modelMockUpConfiguration.users = users;
	}

	public List<TransactionHistory> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionHistory> transactions) {
		modelMockUpConfiguration.transactions = transactions;
	}

	private void populateMock(String file, Method m)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(file).getFile()));
		// jump directly to the second line to collect the data
		reader.readNext();
		m.invoke(this, reader);

	}

	public static void transactionHistoryPopulation(CSVReader reader) throws IOException {
		String[] line;
		while ((line = reader.readNext()) != null) {
			transactions.add(new TransactionHistory(line[0], Double.valueOf(line[1].replace(",", ".")), Boolean.valueOf(line[2]), line[3],
					line[4], line[5], line[6], Boolean.valueOf(line[7]), Boolean.valueOf(line[8]), line[9],
					Integer.valueOf(line[10])));
		}
	}
	
	public static void userPopulation(CSVReader reader) throws IOException {
		String[] line;
		while ((line = reader.readNext()) != null) {
			LocalDate birth_date = dateFormatting(line[17]);
			LocalDate expirationDate = dateFormatting(line[1]);
			PersonalInformation pi= new PersonalInformation(line[16], birth_date, line[18], line[19], line[20], Geneder.valueOf(line[21]), line[22], line[23]);
			users.add(new User(line[0], expirationDate, Integer.valueOf(line[2]), line[3],
					Integer.valueOf(line[4]), line[5], Integer.valueOf(line[6]), line[7], Integer.valueOf(line[8]), line[9],
					Boolean.valueOf(line[10]),Boolean.valueOf(line[11]),Boolean.valueOf(line[12]),Boolean.valueOf(line[13]),
							Boolean.valueOf(line[14]),Boolean.valueOf(line[15]),pi));
		}
	}
	
	private static LocalDate dateFormatting(String date){
		return LocalDate.of(Integer.valueOf(date.substring(5,8)), getMonth(date.substring(2,4)), Integer.valueOf(date.substring(0, 1)));
	}

	private static Month getMonth(String date) {
		for(Month m: Month.values()){
			if(m.name().toLowerCase().contains(date.toLowerCase()))
				return m;
		}
		return null;
	}

}
