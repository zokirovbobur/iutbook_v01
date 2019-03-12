package bbro.iut_book_v01.personalCabinet.interests.achievements;

import bbro.iut_book_v01.personalCabinet.interests.Interest.Interest;
import bbro.iut_book_v01.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("achievement")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @GetMapping
    public Achievement sample(){
        return new Achievement();
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Achievement achievement){
        return achievementService.save(achievement);
    }
    @GetMapping("all")
    public List<Achievement> findAll(){
        return achievementService.findAll();
    }
    @PostMapping("byAchievement")
    public List<Achievement> findAllStudentsByInterestType(@RequestBody Interest interest){
        return achievementService.findAllStudentsByAchievement(interest);
    }
    @PostMapping("allByStudent")
    public List<Achievement> findAllAchievementsByStudent(@RequestBody Student student){
        return achievementService.findAllAchievementsOfStudentUserId(student);
    }
}
