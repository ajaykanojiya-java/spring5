package spring5.framework.guru.spring5.repository;

import org.springframework.data.repository.CrudRepository;
import spring5.framework.guru.spring5.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
