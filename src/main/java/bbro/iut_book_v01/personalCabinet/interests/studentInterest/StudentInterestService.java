package bbro.iut_book_v01.personalCabinet.interests.studentInterest;

import bbro.iut_book_v01.personalCabinet.interests.InterestCategory.InterestCategory;
import bbro.iut_book_v01.personalCabinet.interests.InterestCategory.InterestCategoryRepo;
import bbro.iut_book_v01.personalCabinet.interests.Interest.Interest;
import bbro.iut_book_v01.personalCabinet.interests.Interest.InterestRepo;
import bbro.iut_book_v01.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentInterestService {
    @Autowired
    private StudentInterestRepo studentInterestRepo;
    @Autowired
    private InterestRepo interestRepo;
    @Autowired
    private InterestCategoryRepo categoryRepo;

    //all createTeam methods should be checked by format string 'String' is equal to 'string'

    public ResponseEntity<String> save(StudentInterest studentInterest){
        if (studentInterest.getInterest()==null){
            return ResponseEntity.badRequest().body("interest is missing");
        }else if(studentInterest.getStudent()==null){
            return ResponseEntity.badRequest().body("student is missing");
        }else if (studentInterest.getInterest().getInterestId()==0){
            return ResponseEntity.ok("saved");
        }else if(!interestRepo.existsByInterestId(studentInterest.getInterest().getInterestId())){
            return ResponseEntity.badRequest().body("Interest is incorrect");
        }else if(!categoryRepo.existsByInterestCategoryId(studentInterest.getInterest()
        .getInterestCategory().getInterestCategoryId()
        )){
            return ResponseEntity.badRequest().body("Interest category is incorrect");
        }
        else {
            studentInterestRepo.save(studentInterest);
            return ResponseEntity.ok("saved");
        }
    }

    public ResponseEntity<String> saveInterest(Interest interest){
        if (interest.getInterestCategory()==null){
            return ResponseEntity.badRequest().body("interest category is missing");
        }else if(!categoryRepo.existsByInterestCategoryId(interest.getInterestCategory().getInterestCategoryId())){
            return ResponseEntity.badRequest().body("Interest category is incorrect");
        }else if (interestRepo.existsByInterestValue(interest.getInterestValue())){
            return ResponseEntity.badRequest().body("interest with this name is already exists");
        }

        else {
            interestRepo.save(interest);
            return ResponseEntity.ok("saved");
        }
    }

    public ResponseEntity<String> saveCategory(InterestCategory category){
        if (categoryRepo.existsByInterestCategoryValue(category.getInterestCategoryValue())){
            return ResponseEntity.badRequest().body("interest category with this name is already exists");
        }else {
            categoryRepo.save(category);
            return ResponseEntity.ok("saved");
        }
    }

    public List<StudentInterest> findAll(){
        return studentInterestRepo.findAll();
    }
    public List<Interest> findAllInterest(){
        return interestRepo.findAll();
    }
    public List<InterestCategory> findAllCategory(){
        return categoryRepo.findAll();
    }

    public List<Student> findAllStudentsByInterest(Interest interest){
        List <StudentInterest> studentInterests = studentInterestRepo.findAllByInterest_InterestId(interest.getInterestId());
        List <Student> students = new ArrayList<>();
        studentInterests.forEach(studentInterest -> students.add(studentInterest.getStudent()));
        return students;
    }
    public List<StudentInterest> findAllByStudent(Student student){
        return studentInterestRepo.findAllByStudent_Uuid(student.getUuid());
    }
    public Interest findAllByInterestOrInterestCategory(String keyWord){
        List<Interest> interests = interestRepo.findAllByInterestValueOrInterestCategory_InterestCategoryValue(keyWord,keyWord);
        return interests.get(0);
    }



}
