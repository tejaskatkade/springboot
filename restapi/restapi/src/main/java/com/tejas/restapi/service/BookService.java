package com.tejas.restapi.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.tejas.restapi.entities.Book;

//@Component
@Service
public class BookService {
    private static List<Book> list = new ArrayList<>();

    static{

        list.add(new Book(101, "The God of Small Things", "Arundhati Roy"));
        list.add(new Book(102, "A Suitable Boy", "Vikram Seth"));
        list.add(new Book(103, "Midnight's Children", "Salman Rushdie"));
        list.add(new Book(104, "The Namesake", "Jhumpa Lahiri"));
        list.add(new Book(105, "Train to Pakistan", "Khushwant Singh"));
        list.add(new Book(106, "The White Tiger", "Aravind Adiga"));
        list.add(new Book(107, "The Discovery of India", "Jawaharlal Nehru"));
        list.add(new Book(108, "The Inheritance of Loss", "Kiran Desai")); 
        list.add(new Book(109, "Doglapan", "Ashneer Grover")); 
    }

   
    public List<Book> getAllBooks(){
        return list;
    }
    public Book  getBookById(int id){
        //way-1
        // for (Book book : list) {
        //     if(id == book.getId())  {
        //         return book;
        //     }                 
        // }
        // return null;
        
        // way-2 
        Book book = null;
        try {
            book = list.stream().filter(e->e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
          
    }
    public Book addBook(Book book){
        list.add(book);
        return book;
    }

    public Book deleteBook(int id){
        Book book = list.stream().filter(e->e.getId() == id).findFirst().get();
        list.remove(book);
        //System.out.println(book);
        return book;
    }

    // // way-1
    // public Book updateBook(Book book,int id){
    //     deleteBook(id);
    //     addBook(book); 
    //     return book;
    // }

    // way-2
    public void updateBook(Book book,int id){
        
        list.stream().map(b->{
            if(b.getId() == id){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
    
}
 
