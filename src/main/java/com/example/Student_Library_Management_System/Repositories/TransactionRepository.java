package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "select * from  transaction t where " +
            "t.book_id:bookID and t.card_id : cardID and " +
            "is_issue_operation = true and nativeQuery = true")
    List<Transaction> getTransactionListForBookAndCard(int bookID, int cardID);
}
