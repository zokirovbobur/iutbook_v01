package bbro.iut_book_v01.book;

import bbro.iut_book_v01.subject.Subject;
import bbro.iut_book_v01.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private SubjectService subjectService;

    public ResponseEntity<String> save(Book book){

        if(book.getBookName()==null
                ){
            return ResponseEntity.badRequest().body(
                    "required book fields: bookName"
            );
        }else if(bookRepo.findByBookName(book.getBookName())!=null){
            return ResponseEntity.badRequest().body(
                    "there is already book with name "+book.getBookName());
        }else {
            int res= smartSave(book);
            if (res==1){
                return ResponseEntity.ok("book has been added successfully");
            }
            else {
                return ResponseEntity.ok("book has been edited successfully");
            }
        }




    }

    public ResponseEntity<String> saveAll(List<Book> books){
        books.forEach(this::smartSave);
        return ResponseEntity.ok("all books are saved (or edited) successfully");
    }

    //function recognizes if book exists or not
    //and saves with subject even if subject doesn't exist
    public int smartSave(Book book){

        System.out.println("bookId "+book.getBookId());
        int res = 0;
        if(book.getBookId()==0L){
            System.out.println("inside if");
            res = 1;
        }else {
            res = 2;
        }
        Subject subjectFromBase;
        try {
            //finding if subject exists of not, if exists it will take id of subject
            subjectFromBase = subjectService.findBySubjectName(book.getSubject());
            subjectFromBase.getSubjectName().charAt(0);
            System.out.println("inside smartSave try if");

        }catch (NullPointerException e){
            //if not exists, service will createTeam subject
            System.out.println("catch null book");

            subjectService.save(book.getSubject());


            //and will get id of subject which is saved above
            subjectFromBase = subjectService.findBySubjectName(book.getSubject());
            System.out.println(subjectFromBase.toString());
        }
        //in both cases service will get id of subject and saves it with id
        System.out.println(book.toString());
        book.setSubject(subjectFromBase);

        bookRepo.save(book);
        return res;

    }

    public ResponseEntity<String> delete(Book book){
        bookRepo.delete(book);
        return ResponseEntity.ok("book deleted successfully");
    }

    public List<Book> findAllByFS(int fs){return bookRepo.findBySubjectFs(fs);}

    public List<Book> findAllBySubject(Book book){
        return bookRepo.findBySubject(book.getSubject());
    }

    public List<Book> findAll(){return bookRepo.findAll();}



}
