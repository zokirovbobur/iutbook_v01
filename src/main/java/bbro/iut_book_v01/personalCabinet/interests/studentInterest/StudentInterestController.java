package bbro.iut_book_v01.personalCabinet.interests.studentInterest;

import bbro.iut_book_v01.personalCabinet.interests.Interest.Interest;
import bbro.iut_book_v01.personalCabinet.interests.Interest.InterestRepo;
import bbro.iut_book_v01.personalCabinet.interests.InterestCategory.InterestCategory;
import bbro.iut_book_v01.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("interest")
public class StudentInterestController {
    @Autowired
    private StudentInterestService studentInterestService;

    @Autowired
    private InterestRepo interestRepo;

    //using list of interests
    @GetMapping("studentInterestList")
    public StudentInterestList studentInterestList(){
        return new StudentInterestList();
    }
    @PostMapping("studentInterestList")
    public ResponseEntity<String> saveStudentInterestList(@RequestBody StudentInterestList studentInterestList){
        return studentInterestService.saveUsingList(studentInterestList);
    }

    //list of students by interest
    @PostMapping("byInterest")
    public List<Student> findAllType(@RequestBody Interest interest){
        return studentInterestService.findAllStudentsByInterest(interest);
    }

    @GetMapping("keyword/{keyword}")
    public Interest findInterest(@PathVariable String keyword){
        return studentInterestService.findAllByInterestOrInterestCategory(keyword);
    }

    //list of interests of one student
    @PostMapping("byStudent")
    public List<StudentInterest> findAllInterests(@RequestBody Student student){
        return studentInterestService.findAllByStudent(student);
    }

    //work with interest
    @GetMapping
    public StudentInterest sampleInterest(){
        return new StudentInterest();
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody StudentInterest studentInterest){
        if (!interestRepo.existsByInterestValue(studentInterest.getInterest().getInterestValue())){

        }
        return studentInterestService.save(studentInterest);
    }

    @GetMapping("all")
    public List<StudentInterest> findAll(){
        return studentInterestService.findAll();
    }

    // work with interest types

    @GetMapping("type")
    public Interest sampleType(){
        return new Interest();
    }

    @PostMapping("type")
    public ResponseEntity<String> saveType(@RequestBody Interest type){
        return studentInterestService.saveInterest(type);
    }

    @GetMapping("type/all")
    public List<Interest> findAllType(){
        return studentInterestService.findAllInterest();
    }

    // work with interest categories

    @GetMapping("category")
    public InterestCategory sampleCategory(){
        return new InterestCategory();
    }

    @PostMapping("category")
    public ResponseEntity<String> saveCategory(@RequestBody InterestCategory interestCategory){
        interestCategory.setInterestCategoryValue(interestCategory.getInterestCategoryValue());
        return studentInterestService.saveCategory(interestCategory);
    }

    @GetMapping("category/all")
    public List<InterestCategory> findAllCategories(){
        return studentInterestService.findAllCategory();
    }
}
