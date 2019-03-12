package bbro.iut_book_v01.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;


    public ResponseEntity<String> saveAll(GroupAdd groupAdd){
        groupAdd.setCourseYearNumber(groupAdd.getCourseYearNumber()%100);
        int currentYear_last2digits = Calendar.getInstance().get(Calendar.YEAR)%100;
        System.out.println(groupAdd.getCourseYearNumber()+">"+currentYear_last2digits);

        if(groupAdd.getCourseYearNumber()<=0
                || groupAdd.getCourseYearNumber()>currentYear_last2digits
                || groupAdd.getMaxNoOfGroups()<=0
                || groupAdd.getDepartment()==null
                ){
            return ResponseEntity.badRequest().body("all fields are " +
                    "required and should be properly");
        }
        else {
            List<Group_> groups = groupAdd.calculateAll();
            groups.forEach(group -> {
                group.setDepartment(group.getDepartment().toUpperCase());
                System.out.println(group.toString());
            });
            groupRepo.saveAll(groups);

            return ResponseEntity.ok("all "+groupAdd.getMaxNoOfGroups()
                    +" of "+groupAdd.getDepartment()
                    +" groups has been created and available to use"
            );
        }

    }
    public List<Group_> findAll (){
        return groupRepo.findAll();
    }
    public List<Group_> findAllByDep(Group_ group){
        group.setDepartment(group.getDepartment().toUpperCase());
        return groupRepo.findAllByDepartment(group.getDepartment());
    }
    public List<Group_> findAllByEnteredYear(Group_ group){
        System.out.println(group.getNoOfGroup().substring(0,2));
        return groupRepo.findAllByNoOfGroupIsStartingWith(group.getNoOfGroup().substring(0,2));
    }
    public List<Group_> findAllByEnteredYearAndDepartment(Group_ group){
        group.setDepartment(group.getDepartment().toUpperCase());
        return groupRepo.findAllByNoOfGroupIsStartingWithAndDepartment(group.getNoOfGroup().substring(0,2),group.getDepartment());
    }


}
