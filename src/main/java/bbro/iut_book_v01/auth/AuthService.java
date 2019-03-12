package bbro.iut_book_v01.auth;

import bbro.iut_book_v01.student.Student;
import bbro.iut_book_v01.student.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    StudentRepo studentRepo;

    public ResponseEntity<Student> login(Student student){
//        System.out.println("in: " + student.toString());
//
//            try{
//                Student studentFromBase = studentRepo.findByUserId(student.getUserId());
//
//                System.out.println("out: " + studentFromBase.toString());
//
//                if(student.matchesPassword(studentFromBase)){
//
//                return ResponseEntity.ok(studentFromBase);
//            }
//            else {
//                return ResponseEntity.badRequest().body(new Student());
//
//            }
//        }catch (NullPointerException e){
//            return ResponseEntity.badRequest().body(new Student());
//        }
        return ResponseEntity.badRequest().body(student);
    }


}
