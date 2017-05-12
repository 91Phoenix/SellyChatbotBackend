package com.reply.hackaton.configuration;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.StringTokenizer;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.reply.hackaton.model.Geneder;
import com.reply.hackaton.model.TransactionHistory;
import com.reply.hackaton.model.User;
import com.reply.hackaton.repository.TransactionHistoryRepository;
import com.reply.hackaton.repository.UserRepository;

@Component
public class modelMockUpConfiguration {

	private static final String TRANSACTION_FILE = "TransactionHystory.csv";
	private static final String USER_FILE = "User.csv";
	public static final Logger logger = Logger.getLogger(modelMockUpConfiguration.class);
	private TransactionHistoryRepository transactionHistoryRepository;
	private UserRepository userRepository;

	@Autowired
	public modelMockUpConfiguration(TransactionHistoryRepository transactionHistoryRepository,
			UserRepository userRepository) throws IOException {
		this.transactionHistoryRepository = transactionHistoryRepository;
		this.userRepository = userRepository;
	}

	@PostConstruct
	@Transactional
	public void init() throws IOException {
		
		populateMock(USER_FILE, reader -> {this.userPopulation(reader, userRepository);});
		populateMock(TRANSACTION_FILE, reader -> {this.transactionHistoryPopulation(reader, transactionHistoryRepository);});
		logger.info("transaction history populated: ");
		transactionHistoryRepository.findAll().forEach(t -> logger.info(t.toString()));
		logger.info("list of users populated: ");
		userRepository.findAll().forEach(t -> logger.info(t.toString()));
	}

	private void populateMock(String file, Consumer<CSVReader> c) throws IOException {
		// FileReader("C:\\Users\\r.rotella\\git\\Selly\\Selly\\target\\raffa\\BOOT-INF\\classes\\"+file));
		CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(file).getFile()));
		// jumps directly to the second line to collect the data
		reader.readNext();
		c.accept(reader);
	}

	public void transactionHistoryPopulation(CSVReader reader,
			TransactionHistoryRepository transactionHistoryRepository) {
		String[] line;
		try {
			while ((line = reader.readNext()) != null) {
				LocalDate date = secondDateFormatting(line[10]);
				StringTokenizer tkn = new StringTokenizer(line[11], ".");
				TransactionHistory currentTransaction = new TransactionHistory(line[0],Double.valueOf(line[1].replace(",", ".")), Boolean.valueOf(line[2]),
						line[3], line[4], line[5], line[6], Boolean.valueOf(line[7]), Boolean.valueOf(line[8]),
						line[9], date, timeFormatter(tkn), Integer.valueOf(line[12]), line[13]);
				transactionHistoryRepository.save(currentTransaction);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private LocalTime timeFormatter(StringTokenizer tkn) {
		return LocalTime.of(Integer.valueOf(tkn.nextToken()), Integer.valueOf(tkn.nextToken()));
	}

	private LocalDate secondDateFormatting(String string) {
		StringTokenizer tokenizer = new StringTokenizer(string, "/");
		int day = Integer.valueOf(tokenizer.nextToken());
		Month month = Month.of(Integer.valueOf(tokenizer.nextToken()));
		int year = Integer.valueOf(tokenizer.nextToken());
		return LocalDate.of(year, month, day);
	}

	public void userPopulation(CSVReader reader, UserRepository userRepository) {
		String[] line;
		try {
			while ((line = reader.readNext()) != null) {
				LocalDate birth_date = dateFormatting(line[17]);
				LocalDate expirationDate = dateFormatting(line[1]);
				User currentUser = new User(line[0], expirationDate, Integer.valueOf(line[2]), line[3],
						Integer.valueOf(line[4]), line[5], Integer.valueOf(line[6]), line[7], Integer.valueOf(line[8]),
						line[9], Boolean.valueOf(line[10]), Boolean.valueOf(line[11]), Boolean.valueOf(line[12]),
						Boolean.valueOf(line[13]), Boolean.valueOf(line[14]), Boolean.valueOf(line[15]), line[16],
						birth_date, line[18], line[19], line[20], Geneder.valueOf(line[21]), line[22], line[23], line[24]);
				userRepository.save(currentUser);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private LocalDate dateFormatting(String date) {
		return LocalDate.of(Integer.valueOf(date.substring(5, 9)), getMonth(date.substring(2, 5)),
				Integer.valueOf(date.substring(0, 2)));
	}

	private Month getMonth(String date) {
		for (Month m : Month.values()) {
			if (m.name().toLowerCase().contains(date.toLowerCase()))
				return m;
		}
		return null;
	}

}
