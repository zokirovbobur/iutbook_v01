package bbro.iut_book_v01.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.SubjectDelegationPermission;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public StudentSample sample(){
        System.out.println("get");
        return new StudentSample();
    }
    @PutMapping
    public ResponseEntity<String> put(@RequestBody Student student){
        System.out.println("put");
        return studentService.update(student);
    }
    @GetMapping("all")
    public List<Student> getAll() {
        System.out.println("all");
        return studentService.findAll();
    }

    @GetMapping("login")
    public ResponseEntity<StudentLogin> login(){
        return ResponseEntity.ok(new StudentLogin());
    }

    @PostMapping("login")
    public ResponseEntity<Student> login(@RequestBody StudentLogin student){
        System.out.println("login");
        return studentService.login(student);
    }
    @PostMapping("directSave")
    public ResponseEntity<Student> directSave(@RequestBody Student student){
        return studentService.save(student);
    }

    @PostMapping("testLogin")
    public boolean testLogin(@RequestBody StudentLogin studentLogin){
        return studentService.checkPasswordTesting(studentLogin);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Student student){
        System.out.println("delete");
        return ResponseEntity.badRequest().body("delete function allowed only for admin only");
    }
    @PostMapping("byUserId")
    public ResponseEntity<Student> byUserId(@RequestBody StudentSample studentSample){
        System.out.println(studentSample.toString());
        return studentService.findByUserId(studentSample);
    }
    @PostMapping("byName")
    public ResponseEntity<Student> byName(@RequestBody Student student){
        return studentService.findByName(student);
    }

    @PostMapping("retrieveFromXLSX/{docName}")
    public ResponseEntity<String> retrieve(@PathVariable String docName){
        return studentService.updateAllStudentsGroupsUsingXSLX(docName);
    }
    @PostMapping("retrieveFromInitXLSX")
    public ResponseEntity<String> initRetrieve(){
        return studentService.updateAllStudentsGroupsUsingXSLX("StudentList.xlsx");
    }
}
