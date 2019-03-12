package bbro.iut_book_v01.book;

import bbro.iut_book_v01.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Book book(){return new Book();}
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Book book){return bookService.save(book);}
    @PostMapping("saveAll")
    public ResponseEntity<String> saveAll(@RequestBody List<Book> books){return bookService.saveAll(books);}
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Book book){return ResponseEntity.badRequest().body("delete function is allowed for admin only");}

    @GetMapping("bySubject")
    public List<Book> getAllBySubject(@RequestBody Book book){
        return bookService.findAllBySubject(book);
    }

    @PostMapping("byFS")
    public List<Book> getAllByFs(@RequestBody Subject subject){return bookService.findAllByFS(subject.getFs());}

    @GetMapping("all")
    public List<Book> all(){return bookService.findAll();}

}
