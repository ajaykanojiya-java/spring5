package spring5.framework.guru.spring5.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring5.framework.guru.spring5.domain.Author;
import spring5.framework.guru.spring5.domain.Book;
import spring5.framework.guru.spring5.domain.Publisher;
import spring5.framework.guru.spring5.repository.AuthorRepository;
import spring5.framework.guru.spring5.repository.BookRepository;
import spring5.framework.guru.spring5.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG");
        publisher.setAddressLine("123 SFG Line");
        publisher.setCity("Indore");
        publisher.setState("MP");
        publisher.setZip("452010");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Book book1 = new Book("Spring in Action","123123");
        Book book2 = new Book("Hibernate in Action","546987");
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);


        Author author1 = new Author("Eric","Evans");
        Author author2 = new Author("Kally","Berts");

        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        publisher.getBooks().add(book2);
        book2.setPublisher(publisher);

        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Started In Bootstrap");
        System.out.println("Numbers of Book: "+bookRepository.count());
        System.out.println("Publisher has no of Book "+publisherRepository.count()+" "+publisher.getBooks().size());
    }
}
