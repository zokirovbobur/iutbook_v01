package bbro.iut_book_v01.auth;

import bbro.iut_book_v01.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("login")
    public ResponseEntity<Student> login(@RequestBody Student student){
        return authService.login(student);
    }
}
