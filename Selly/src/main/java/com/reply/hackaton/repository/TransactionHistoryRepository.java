package com.reply.hackaton.repository;

import org.springframework.data.repository.CrudRepository;
import com.reply.hackaton.model.TransactionHistory;

public interface TransactionHistoryRepository  extends CrudRepository<TransactionHistory, String> {

}
