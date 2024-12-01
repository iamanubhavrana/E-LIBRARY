package com.book.api.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.book.api.bootrestbook.entities.Books;

public interface BookRepo extends CrudRepository<Books, Long>
{

    
}