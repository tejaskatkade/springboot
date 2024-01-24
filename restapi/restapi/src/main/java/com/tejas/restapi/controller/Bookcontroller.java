package com.tejas.restapi.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/books")
    public List<Book> getBooks(){
        
        return bookService.getAllBooks();
        
    }  
    // @GetMapping("/book")
    // public Book getBook(){
    //     System.out.println("Enter book Id");
    //     Scanner sc = new Scanner(System.in);
    //     int id = sc.nextInt();
    //     return bookService.getBookById(id);
    // }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id){
        
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @DeleteMapping("/book/{id}")
    public Book deleteBook(@PathVariable("id") int id){
        return bookService.deleteBook(id);   
    }

    @PutMapping("/book/{id}")
    // //way-1
    // public Book updateBook(@RequestBody Book book , @PathVariable("id") int id){
    //     return bookService.updateBook(book, id);
    // }

    // way-2 
    public void updateBook(@RequestBody Book book , @PathVariable("id") int id){
        bookService.updateBook(book, id);
    }
}

