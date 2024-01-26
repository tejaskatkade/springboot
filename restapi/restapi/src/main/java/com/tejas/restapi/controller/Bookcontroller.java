package com.tejas.restapi.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tejas.restapi.entities.Book;
import com.tejas.restapi.service.BookService;

// import java.util.Scanner;
// import org.springframework.stereotype.Controller;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;


// @Controller
// public class Bookcontroller {

//     //Handler method to create url

//     @RequestMapping(value = "/book", method = RequestMethod.GET)
//     @ResponseBody
//     public String getBook(){
//         return "This is testing book";
//     }  
//}


// for rest API

@RestController

public class Bookcontroller {

    @Autowired
    private BookService bookService;
    //Handler method to create url

// To get all books
    @GetMapping("/books")
    // simple way 
    // public List<Book> getBooks(){
    //     return bookService.getAllBooks();    
    // }  

    // Error handled way
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list = bookService.getAllBooks();

        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.of(Optional.of(list));
    } 
    

// To get book by its Id

    // simple way

    // @GetMapping("/book")
    // public Book getBook(){
    //     System.out.println("Enter book Id");
    //     Scanner sc = new Scanner(System.in);
    //     int id = sc.nextInt();
    //     return bookService.getBookById(id);
    // }

    // OR

    // @GetMapping("/book/{id}")
    // public Book getBook(@PathVariable("id") int id){
        
    //     return bookService.getBookById(id);
    // }


    //Error handled way

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){        
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(book));
    }



// To create or add new Book

    @PostMapping("/book")
    // public Book addBook(@RequestBody Book book){
    //     return bookService.addBook(book);
    // }

    public ResponseEntity<Book> addBook(@RequestBody Book book){
        try {
            Book book1 = bookService.addBook(book);
            //return ResponseEntity.status(HttpStatus.CREATED).build();
            return ResponseEntity.of(Optional.of(book1));        
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
.build();        }
    
        
    }

// To delete  book
    @DeleteMapping("/book/{id}")
    // public Book deleteBook(@PathVariable("id") int id){
    //     return bookService.deleteBook(id);   
    // }
    

    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        
        try {
            bookService.deleteBook(id); 
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }  
    }


// To update book
    @PutMapping("/book/{id}")
    // //way-1
    // public Book updateBook(@RequestBody Book book , @PathVariable("id") int id){
    //     return bookService.updateBook(book, id);
    // }

    // way-2 
    // public void updateBook(@RequestBody Book book , @PathVariable("id") int id){
    //     bookService.updateBook(book, id);
    // }

    public ResponseEntity<Book> updateBook(@RequestBody Book book , @PathVariable("id") int id){
        try {
            bookService.updateBook(book, id);    
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

