package com.testtask.rest_service.repositories;

import com.testtask.rest_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    @Query("select h from author a inner join book_author ba on a.id = ba.author_id  inner join book b on b.id = ba.book_id and b.id=?1")
//    public List<Author> findAuthorByBookId(long id);
}
