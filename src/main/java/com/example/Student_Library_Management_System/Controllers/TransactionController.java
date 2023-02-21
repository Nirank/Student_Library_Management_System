package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTOs.IssuedBookRequestDTO;
import com.example.Student_Library_Management_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public  String issueBook(@RequestBody IssuedBookRequestDTO issuedBookRequestDTO) throws Exception {
        return transactionService.issueBook(issuedBookRequestDTO);
    }
    @GetMapping("/get_txns_info")
    public  String getTransactionInfo( @RequestParam int bookID, @RequestParam int cardID){
        return transactionService.getTransaction(bookID, cardID);
    }
}
