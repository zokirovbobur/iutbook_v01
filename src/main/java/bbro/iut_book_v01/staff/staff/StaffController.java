package bbro.iut_book_v01.staff.staff;

import bbro.iut_book_v01.staff.staff.staffType.StaffType;
import bbro.iut_book_v01.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @GetMapping
    public Staff sample(){return new Staff();}

    @PostMapping("login")
    public ResponseEntity<Staff> save(@RequestBody Staff staff){
        return staffService.login(staff);
    }
    @GetMapping("all")
    public List<Staff> findAll(){
        return staffService.findAll();
    }
    @PostMapping("allByType")
    public List<Staff> findAllByType(@RequestBody StaffType staffType){
        return staffService.findAllByType(staffType);
    }
    @PostMapping("byName")
    public ResponseEntity<Staff> findByName(@RequestBody Staff staff){
        return staffService.findByFullName(staff);
    }
    @PostMapping("bySubject")
    public List<Staff> bySubject(@RequestBody Subject subject){
        return staffService.findAllBySubject(subject);
    }


}
