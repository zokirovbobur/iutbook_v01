package bbro.iut_book_v01.book;

import bbro.iut_book_v01.subject.Subject;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long bookId;
    @Column(unique = true)
    private String bookName;

    private String author;

    @ManyToOne
    private Subject subject;

    private String bookPicUrl;
    private String bookUrl;
    private String bookSize;

    public Book() {
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPicUrl() {
        return bookPicUrl;
    }

    public void setBookPicUrl(String bookPicUrl) {
        this.bookPicUrl = bookPicUrl;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", subject='" + subject + '\'' +
                ", bookPicUrl='" + bookPicUrl + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                ", bookSize='" + bookSize + '\'' +
                '}';
    }
}
