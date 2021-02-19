package com.codesimple.bookstore.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codesimple.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop, String bookType);

    Long countByBookType(String bookType);

    String rawQuery = "select * from book where year_of_publication IN ?1";

    @Query(nativeQuery = true, value = rawQuery)
    List<Book> findAllByYearOfPublicationIn( Set<Integer> yop);
}
