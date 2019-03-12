package bbro.iut_book_v01.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public Subject subject(){return new Subject();}

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Subject subject){
       return subjectService.save(subject);
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Subject subject){
        return ResponseEntity.badRequest().body("delete function allowed only for admin only");
    }
    @GetMapping("all")
    public List<Subject> getAll(){
        return subjectService.findAll();
    }
    @PostMapping("byFS")
    public List<Subject> getAllByFS(@RequestBody Subject subject){
        return subjectService.findAllByFS(subject);}
    @PostMapping("bySubjectName")
    public Subject getAllBySubjectName(@RequestBody Subject subject){return subjectService.findBySubjectName(subject);}

}
