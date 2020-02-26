package spring5.framework.guru.spring5.repository;

import org.springframework.data.repository.CrudRepository;
import spring5.framework.guru.spring5.domain.Author;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
