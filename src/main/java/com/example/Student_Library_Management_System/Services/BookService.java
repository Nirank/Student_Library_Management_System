package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDTO;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDTO bookRequestDTO){
        //get the author entity using author id
         int authorId = bookRequestDTO.getAuthorId();

         //fetch author entity using author ID
         Author author = authorRepository.findById(authorId).get();


         Book book = new Book();
         book.setGenre(bookRequestDTO.getGenre());
         book.setIssued(false);
         book.setName(bookRequestDTO.getName());
         book.setPages(bookRequestDTO.getPages());


         //setting foreign key attribute in child class
         book.setAuthor(author);


         List<Book> currentBookWritten = author.getBooksWritten();
         currentBookWritten.add(book);
         author.setBooksWritten(currentBookWritten);


         authorRepository.save(author);

        return "Book added Successfully.";
    }
}
