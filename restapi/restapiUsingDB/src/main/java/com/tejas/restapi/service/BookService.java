package com.tejas.restapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import com.tejas.restapi.dao.BookRepository;
import com.tejas.restapi.entities.Book;

import org.springframework.stereotype.Component;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//import java.util.ArrayList;

@Component
//@Service
public class BookService {
    // private static List<Book> list = new ArrayList<>();

    // static{

    //     list.add(new Book(101, "The God of Small Things", "Arundhati Roy"));
    //     list.add(new Book(102, "A Suitable Boy", "Vikram Seth"));
    //     list.add(new Book(103, "Midnight's Children", "Salman Rushdie"));
    //     list.add(new Book(104, "The Namesake", "Jhumpa Lahiri"));
    //     list.add(new Book(105, "Train to Pakistan", "Khushwant Singh"));
    //     list.add(new Book(106, "The White Tiger", "Aravind Adiga"));
    //     list.add(new Book(107, "The Discovery of India", "Jawaharlal Nehru"));
    //     list.add(new Book(108, "The Inheritance of Loss", "Kiran Desai")); 
    //     list.add(new Book(109, "Doglapan", "Ashneer Grover")); 
    // }

    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>)bookRepository.findAll();
        return list;
    }
    public Optional<Book>  getBookById(int id){
        
        Optional<Book> book = null;
        
        try {
            
           book = bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
          
    }
    public Book addBook(Book book){
        
        return bookRepository.save(book);
    }

    public void deleteBook(int id){
        //Book book = list.stream().filter(e->e.getId() == id).findFirst().get();
        //list.remove(book);
        bookRepository.deleteById(id);
    }

    // // way-1
    // public Book updateBook(Book book,int id){
    //     deleteBook(id);
    //     addBook(book); 
    //     return book;
    // }

    // way-2
    public void updateBook(Book book,int id){
        
        // list.stream().map(b->{
        //     if(b.getId() == id){
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        bookRepository.save(book);
    }
    
}
 
