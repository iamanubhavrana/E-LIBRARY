package com.book.api.bootrestbook.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.book.api.bootrestbook.dao.BookRepo;
import com.book.api.bootrestbook.entities.Books;


@Service
public class BookService
 {
    
     private final BookRepo bookRepo;  
    
     
    public BookService(BookRepo bookRepo)
    {
        this.bookRepo=bookRepo;
        
    }    
//get  all books
public List<Books> getAllBooks()
{
    

return  (List<Books>) bookRepo.findAll();
}

// get single book by id
 public Optional<Books> getBookbyid( Long id)
 {

   return bookRepo.findById(id);
}

// add new book
public Books addbook(Books books)
{
    return bookRepo.save(books);
}
// update book data
public Optional<Books> updatebooks(Long id,Books updatedBooks)
{

    return bookRepo.findById(id).map(books->{
    
        books.setAuthor(updatedBooks.getAuthor());
        books.setTitle(updatedBooks.getTitle());
        return bookRepo.save(books);
    });
}
// delete book data
public boolean deleteBook(Long id) {
    if (bookRepo.existsById(id))
     {
        bookRepo.deleteById(id);
        return true;
    }
    return false;
}
 }