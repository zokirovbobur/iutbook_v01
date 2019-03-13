package bbro.iut_book_v01.subject;

import bbro.iut_book_v01.staff.staff.Staff;
import bbro.iut_book_v01.staff.staff.StaffRepo;
import bbro.iut_book_v01.subject.subjectProfessor.SubjectProfessor;
import bbro.iut_book_v01.subject.subjectProfessor.SubjectProfessorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepo repo;
    @Autowired
    private SubjectProfessorRepo subjectProfessorRepo;
    @Autowired
    private StaffRepo staffRepo;

    public ResponseEntity<String> save(Subject subject){
        subject.setSubjectName(subject.getSubjectName().toLowerCase());
        if(subject.getSubjectName()==null || subject.getFs()==0){
            return ResponseEntity.badRequest().body(
                    "required data: subjectName, fs");
        }else {
            try{
                repo.findBySubjectName(subject.getSubjectName())
                        .getSubjectId();
                return ResponseEntity.badRequest().body("subject with name '" +
                        subject.getSubjectName()+"' is already exists"
                );
            }catch (NullPointerException e){
                repo.save(subject);
                return ResponseEntity.ok("subject has been added successfully");
            }

        }


    }
    public ResponseEntity<String> delete(Subject subject){
        try {
            repo.delete(subject);
            return ResponseEntity.ok("subject has been deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("something wrong with subject, maybe subject connected to other data objects");
        }

    }
    public List<Subject> findAll(){return repo.findAll();}

    public List<Subject> findAllByFS(Subject subject){

        return repo.findAllByFs(subject.getFs());
    }

    public Subject findBySubjectName(Subject subject){
        return repo.findBySubjectName(subject.getSubjectName());
    }

    public ResponseEntity<String> saveSubjectProfessor(SubjectProfessor subjectProfessor){

        Staff staff = staffRepo.findByStaffId(subjectProfessor.getStaff().getStaffId());

        if (subjectProfessor.getStaff()==null){
            return ResponseEntity.badRequest().body("staff is missing");
        }else if (subjectProfessor.getSubject()==null){
            return ResponseEntity.badRequest().body("subject is missing");
        }else if (!subjectProfessorRepo.existsByStaff_StaffIdAndSubject_SubjectId(
                subjectProfessor.getStaff().getStaffId(),
                subjectProfessor.getSubject().getSubjectId()
                )){
            return ResponseEntity.badRequest().body("such record is already exists");
        }else if (staff.getStaffType().equals("professor")){
            return ResponseEntity.badRequest().body("staff type not correct");
        }else {
            subjectProfessorRepo.save(subjectProfessor);
            return ResponseEntity.ok("saved");
        }


    }
}
