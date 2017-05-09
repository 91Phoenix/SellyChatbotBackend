package com.reply.hackaton.configuration;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.StringTokenizer;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.reply.hackaton.model.Geneder;
import com.reply.hackaton.model.PersonalInformation;
import com.reply.hackaton.model.TransactionHistory;
import com.reply.hackaton.model.User;
import com.reply.hackaton.repository.PersonalInfoRepository;
import com.reply.hackaton.repository.TransactionHistoryRepository;
import com.reply.hackaton.repository.UserRepository;

@Component
public class modelMockUpConfiguration {

	private static final String TRANSACTION_FILE = "TransactionHystory.csv";
	private static final String USER_FILE = "User.csv";
	public static final Logger logger = Logger.getLogger(modelMockUpConfiguration.class);
	private TransactionHistoryRepository transactionHistoryRepository;
	private PersonalInfoRepository personalInfoRepository;
	private UserRepository userRepository;

	@Autowired
	public modelMockUpConfiguration(TransactionHistoryRepository transactionHistoryRepository,
			PersonalInfoRepository personalInfoRepository, UserRepository userRepository) throws IOException {
		this.transactionHistoryRepository = transactionHistoryRepository;
		this.personalInfoRepository = personalInfoRepository;
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void init() throws IOException {
		populateMock(TRANSACTION_FILE, reader -> {
			this.transactionHistoryPopulation(reader, transactionHistoryRepository);
		});
		logger.info("transaction history populated: ");
		transactionHistoryRepository.findAll().forEach(t -> logger.info(t.toString()));
		populateMock(USER_FILE, reader -> {
			this.userPopulation(reader, userRepository);
		});
		logger.info("list of users populated: ");
		// userRepository.findAll().forEach(t->logger.info(t.toString()));

	}

	private void populateMock(String file, Consumer<CSVReader> c) throws IOException {
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\r.rotella\\git\\Selly\\Selly\\target\\raffa\\BOOT-INF\\classes\\"+file));
		//CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(file).getFile()));
		// jump directly to the second line to collect the data
		reader.readNext();
		c.accept(reader);
	}

	public void transactionHistoryPopulation(CSVReader reader,
			TransactionHistoryRepository transactionHistoryRepository) {
		String[] line;
		try {
			while ((line = reader.readNext()) != null) {
				LocalDate date = secondDateFormatting(line[10]);
				transactionHistoryRepository
						.save(new TransactionHistory(line[0], Double.valueOf(line[1].replace(",", ".")),
								Boolean.valueOf(line[2]), line[3], line[4], line[5], line[6], Boolean.valueOf(line[7]),
								Boolean.valueOf(line[8]), line[9], date, Integer.valueOf(line[11]), line[12]));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
				PersonalInformation pi = new PersonalInformation(line[16], birth_date, line[18], line[19], line[20],
						Geneder.valueOf(line[21]), line[22], line[23]);
				personalInfoRepository.save(pi);
				userRepository.save(new User(line[0], expirationDate, Integer.valueOf(line[2]), line[3],
						Integer.valueOf(line[4]), line[5], Integer.valueOf(line[6]), line[7], Integer.valueOf(line[8]),
						line[9], Boolean.valueOf(line[10]), Boolean.valueOf(line[11]), Boolean.valueOf(line[12]),
						Boolean.valueOf(line[13]), Boolean.valueOf(line[14]), Boolean.valueOf(line[15]), pi));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private LocalDate dateFormatting(String date) {
		return LocalDate.of(Integer.valueOf(date.substring(5, 8)), getMonth(date.substring(2, 4)),
				Integer.valueOf(date.substring(0, 1)));
	}

	private Month getMonth(String date) {
		for (Month m : Month.values()) {
			if (m.name().toLowerCase().contains(date.toLowerCase()))
				return m;
		}
		return null;
	}

}
