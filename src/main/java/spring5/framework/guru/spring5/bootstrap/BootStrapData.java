package spring5.framework.guru.spring5.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring5.framework.guru.spring5.domain.Author;
import spring5.framework.guru.spring5.domain.Book;
import spring5.framework.guru.spring5.repository.AuthorRepository;
import spring5.framework.guru.spring5.repository.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("Spring in Action","123123");
        Book book2 = new Book("Hibernate in Action","546987");

        Author author1 = new Author("Eric","Evans");
        Author author2 = new Author("Kally","Berts");

        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);

        System.out.println("Started In Bootstrap");
        System.out.println("Numbers of Book: "+bookRepository.count());
    }
}
