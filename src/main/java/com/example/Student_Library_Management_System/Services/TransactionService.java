package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.IssuedBookRequestDTO;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transaction;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public String issueBook(IssuedBookRequestDTO issuedBookRequestDTO) throws Exception {

        int bookID = issuedBookRequestDTO.getBookID();
        int cardID = issuedBookRequestDTO.getCardID();

        Book book = bookRepository.findById(bookID).get();

        Card card = cardRepository.findById(cardID).get();


        // make a txn entity

        Transaction transaction = new Transaction();
        //setting Attribute
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionID(UUID.randomUUID().toString());
        transaction.setIssuedOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        //attribute left is success / Failure
       if( book == null || book.isIssued()){
           transaction.setTransactionStatus(TransactionStatus.FAILED);
           transactionRepository.save(transaction);
           throw new Exception("Book is Not Available. ");
       }
        if( card == null || card.getCardStatus() != CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is Not Valid. ");
        }


        //reach to success
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        // do some validation
        //set Attribution for books
        book.setIssued(true);
        // book and Trnx : Bidirectional
        List<Transaction> transactionListForBook = book.getListOfTransaction();
        transactionListForBook.add(transaction);
        book.setListOfTransaction(transactionListForBook);

        // Make change in the card
        // BOOk and Card
        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);
        //card an trnx bidirectional
        List<Transaction> transactionListForCard = card.getTransactionList();
        transactionListForCard.add(transaction);
        card.setTransactionList(transactionListForCard);

        // set FK and bidirectional mapping



        //save the parent
        // and child are automatically got saved
        cardRepository.save(card);


        return "Book Issued SuccessFully";
    }

    public String getTransaction( int bookID, int cardID){
        List<Transaction> transactionList = transactionRepository.getTransactionListForBookAndCard(bookID, cardID);
        String transactionID = transactionList.get(0).getTransactionID();
        return  transactionID;

    }

}
