package bbro.iut_book_v01.team;

import bbro.iut_book_v01.student.Student;
import bbro.iut_book_v01.subject.Subject;
import bbro.iut_book_v01.team.teamResponse.TeamResponseStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public Team sample(){return new Team();}

    @PostMapping("new")
    public ResponseEntity<String> save(@RequestBody Team team){
        return teamService.createTeam(team);
    }
    @PostMapping("{teamId}/addMember")
    public ResponseEntity<String> addMember(@PathVariable long teamId, @RequestBody Student student) {
        return teamService.addResponseStudent(teamId,student);
    }

    @GetMapping("all")
    public List<Team> getAll(){
        return teamService.findAll();
    }
    @PostMapping("allByTeamId")//return can be changed to List of student objects
    public List<Student> byTeamId(@RequestBody Team team){
        return teamService.findAllByTeamId(team);
    }

    @PostMapping("byFS")
    public List<Team> findAllByFs(@RequestBody Subject subject){
        return teamService.findAllByFS(subject);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Team team){
        return ResponseEntity.badRequest().body("delete function allowed only for admin only");
    }


}
