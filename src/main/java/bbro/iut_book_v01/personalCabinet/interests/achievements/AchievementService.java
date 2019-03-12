package bbro.iut_book_v01.personalCabinet.interests.achievements;

import bbro.iut_book_v01.personalCabinet.interests.Interest.Interest;
import bbro.iut_book_v01.personalCabinet.interests.Interest.InterestRepo;
import bbro.iut_book_v01.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementService {
    @Autowired
    private AchievementRepo achievementRepo;

    @Autowired
    private InterestRepo interestRepo;

    public ResponseEntity<String> save(Achievement achievement){
        if (achievement.getInterest()==null){
            return ResponseEntity.badRequest().body("interest is missing");
        }else if (achievement.getStudent()==null){
            return ResponseEntity
                    .badRequest().body("student is missing");
        }else if (!interestRepo.existsByInterestId(achievement.getInterest().getInterestId())){
            return ResponseEntity.badRequest().body("interest is not exists");
        }else {
            achievementRepo.save(achievement);
            return ResponseEntity.ok("saved");
        }

    }
    public List<Achievement> findAll(){
        return achievementRepo.findAll();
    }
    public List<Achievement> findAllStudentsByAchievement(Interest interest){
        return achievementRepo.findAllByInterest_InterestId(interest.getInterestId());
    }
    public List<Achievement> findAllAchievementsOfStudentUuid(Student student){
        return achievementRepo.findAllByStudent_Uuid(student.getUuid());
    }
    public List<Achievement> findAllAchievementsOfStudentUserId(Student student){
        return achievementRepo.findAllByStudent_UserId(student.getUserId());
    }
}
