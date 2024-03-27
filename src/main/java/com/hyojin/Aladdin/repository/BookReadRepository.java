package com.hyojin.Aladdin.repository;
import com.hyojin.Aladdin.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReadRepository  extends JpaRepository<Book,Long> {

}
