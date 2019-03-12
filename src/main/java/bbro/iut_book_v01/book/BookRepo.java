package bbro.iut_book_v01.book;

import bbro.iut_book_v01.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findBySubject(Subject subject);
    List<Book> findBySubjectFs(int fs);
    Book findByBookName(String bookName);
    Book findByBookId(long id);

}
