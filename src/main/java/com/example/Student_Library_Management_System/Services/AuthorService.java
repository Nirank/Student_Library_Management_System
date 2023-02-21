package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDTO;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDTO;
import com.example.Student_Library_Management_System.DTOs.BookRequestDTO;
import com.example.Student_Library_Management_System.DTOs.BookResponseDTO;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDTO authorEntryDTO){


        //convert authorEntryDto into author entity
        Author author = new Author();
        author.setName(authorEntryDTO.getName());
        author.setAge(authorEntryDTO.getAge());
        author.setCountry(authorEntryDTO.getCountry());
        author.setRating(authorEntryDTO.getRating());

        authorRepository.save(author);
        return "Author Added Successfully";
    }
    public AuthorResponseDTO getAuthor(Integer authorID){
        Author author =  authorRepository.findById(authorID).get();
        AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO();

        // Set its attribute
        List<Book> bookList = author.getBooksWritten();
        List<BookResponseDTO> booksWrittenDTO = new ArrayList<>();

        for( Book book : bookList){
            BookResponseDTO bookResponseDTO = new BookResponseDTO();
            bookResponseDTO.setName(book.getName());
            bookResponseDTO.setPages(book.getPages());
            bookResponseDTO.setGenre(book.getGenre());
            booksWrittenDTO.add(bookResponseDTO);
        }
        //set attribute for author Response DTO

        authorResponseDTO.setAge((author.getAge()));
        authorResponseDTO.setName(author.getName());
        authorResponseDTO.setRating(author.getRating());
        authorResponseDTO.setCountry(author.getCountry());
        authorResponseDTO.setBooksWritten(booksWrittenDTO);

        return authorResponseDTO;



    }
}
