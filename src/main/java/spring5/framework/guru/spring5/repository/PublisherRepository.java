package spring5.framework.guru.spring5.repository;

import org.springframework.data.repository.CrudRepository;
import spring5.framework.guru.spring5.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
