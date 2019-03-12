package bbro.iut_book_v01.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public Group_ sample(){return new Group_();}

    @GetMapping("add")
    public GroupAdd sampleAdd(){return new GroupAdd();}

    @PostMapping("add")
    public ResponseEntity<String> addAll(@RequestBody GroupAdd groupAdd){
        return groupService.saveAll(groupAdd);
    }

    @GetMapping("all")
    public List<Group_> getAll(){return groupService.findAll();}

    @PostMapping("allByDep")
    public List<Group_> getAllByDep(@RequestBody Group_ group_){return groupService.findAllByDep(group_);}
    @PostMapping("allByEY")
    public List<Group_> getAllByEY(@RequestBody Group_ group_){return groupService.findAllByEnteredYear(group_);}
    @PostMapping("allByEYAndDep")
    public List<Group_> getAllByEyAndDep(@RequestBody Group_ group_){
        return groupService.findAllByEnteredYearAndDepartment(group_);
    }

}
