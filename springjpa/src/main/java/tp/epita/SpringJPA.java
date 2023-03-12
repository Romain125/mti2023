package tp.epita;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public class SpringJPA {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJPA.class, args);
        Repo repo = context.getBean(Repo.class);
        repo.save(new Book("Romain", new Title("Awesome book", "Un livre génial"), Type.adventure));
        System.out.println(repo.findAll());
        System.out.println(repo.findAllByTitle_OriginalTitleContaining("Awesome"));
    }
}

@Entity
class Book{

    public Book() {}

    public Book(String author, Title title, Type type) {
        this.author = author;
        this.title = title;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    String author;

    @Embedded
    Title title;

    Type type;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title=" + title +
                ", type=" + type +
                '}';
    }
}

class Title{

    public Title() {
    }

    public Title(String originalTitle, String frenchTitle) {
        this.originalTitle = originalTitle;
        this.frenchTitle = frenchTitle;
    }

    String originalTitle;
    String frenchTitle;

    @Override
    public String toString() {
        return "Title{" +
                "originalTitle='" + originalTitle + '\'' +
                ", frenchTitle='" + frenchTitle + '\'' +
                '}';
    }
}

enum Type{
    adventure,
    horror
}

interface Repo extends JpaRepository<Book, Long> {

    List<Book> findTop3ByTypeOrderById(Type type);
    List<Book> findAllByTitle_OriginalTitleContaining(String originalTitle);

}
