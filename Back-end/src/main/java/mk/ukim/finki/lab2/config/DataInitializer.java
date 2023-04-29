package mk.ukim.finki.lab2.config;

import mk.ukim.finki.lab2.model.Author;
import mk.ukim.finki.lab2.model.Country;
import mk.ukim.finki.lab2.service.AuthorService;
import mk.ukim.finki.lab2.service.BookService;
import mk.ukim.finki.lab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static mk.ukim.finki.lab2.model.enumerations.Category.*;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;

    public DataInitializer(AuthorService authorService, CountryService countryService, BookService bookService) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {
        Country country = new Country("Macedonia", "Europe");
        Country country1 = new Country("Portugal", "Europe");
        Country country2 = new Country("Slovenia", "Europe");
        Country country3 = new Country("Spain", "Europe");

        countryService.create(country);
        countryService.create(country1);
        countryService.create(country2);
        countryService.create(country3);

        Author author1 = new Author("Кочо ", "Рацин", country);
        Author author2 = new Author("J. K. ", "Rowling", country1);
        Author author3 = new Author("J. R. R. ", "Tolkien", country2);
        Author author4 = new Author("Charles ", "River", country);
        Author author5 = new Author("Susan ", "Aberth ", country1);
        Author author6 = new Author("Victoria ", "Aveyard", country2);
        Author author7 = new Author("Ian ", "Worthington", country3);


        authorService.create(author1);
        authorService.create(author2);
        authorService.create(author3);
        authorService.create(author4);
        authorService.create(author5);
        authorService.create(author6);
        authorService.create(author7);

        this.bookService.create("Harry Potter", FANTASY, author2.getId(), 2);
        this.bookService.create(" THE LORD OF THE RINGS BY JRR TOLKIEN", FANTASY, author3.getId(), 4);
        this.bookService.create("Guns, Germs, and Steel", HISTORY, author4.getId(), 1);
        this.bookService.create("Leonora Carrington: Surrealism", SURREALISM, author5.getId(), 1);
        this.bookService.create("Red Queen", FANTASY, author6.getId(), 1);
        this.bookService.create("The Queen's Speech", HISTORY, author7.getId(), 1);
    }
}
