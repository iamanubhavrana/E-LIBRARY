package com.book.api.bootrestbook.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.api.bootrestbook.entities.Books;
import com.book.api.bootrestbook.services.BookService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class bookcontroller
 {
   @Autowired
   private BookService bookService;

@GetMapping("/books")
public List<Books> getbooks()
{
return this.bookService.getAllBooks();

}
@GetMapping("/books/{id}")
public ResponseEntity<Books> getbook(@PathVariable Long id)
{
   Optional<Books> books=bookService.getBookbyid(id);

return books.map(ResponseEntity::ok)
.orElseGet(()->ResponseEntity.notFound().build());

}
// adding book
@PostMapping("/addabook")
public ResponseEntity<Books> addbooks(@RequestBody Books books)
{
   Books savedBook = bookService.addbook(books);
   return ResponseEntity.ok(savedBook);
}
// update a book
@PutMapping("/updateabook/{id}")
public ResponseEntity<Books> updatebook(@PathVariable Long id,@RequestBody Books updatedbooks)
{
   Optional<Books> books=bookService.updatebooks(id, updatedbooks);
return books.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
}

// Delete a book by ID
    @DeleteMapping("/deleteabook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
