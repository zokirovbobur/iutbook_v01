package bbro.iut_book_v01.staff.groupSection;

import bbro.iut_book_v01.staff.groupSection.groupsPerSection.GroupsPerSection;
import bbro.iut_book_v01.staff.staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("section")
public class GroupSectionController {
    @Autowired
    private GroupSectionService sectionService;

    @GetMapping
    public GroupSection sample(){return new GroupSection();}

    @PostMapping
    public ResponseEntity<String> save(@RequestBody GroupSection groupSection){
        return sectionService.save(groupSection);
    }
    @GetMapping("all")
    public List<GroupSection> findAll(){
        return sectionService.findAll();
    }
    @PostMapping("byProfessor")
    public List<GroupsPerSection> findAllByProfessorUUID(@RequestBody Staff staff){
        return sectionService.finAllByResponsibleProfessor(staff);
    }
    @PostMapping("byCourseName")
    public List<GroupSection> findAllByCourseName(@RequestBody GroupSection groupSection){
        return sectionService.findAllByCourseName(groupSection);
    }
    @PostMapping("groupsBySectionId")
    public List<GroupsPerSection> bySectionId(GroupSection groupSection){
        return sectionService.findGroupsPerSectionId(groupSection);
    }


}
