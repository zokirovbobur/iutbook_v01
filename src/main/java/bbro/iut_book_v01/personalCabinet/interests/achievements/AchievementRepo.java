package bbro.iut_book_v01.personalCabinet.interests.achievements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepo extends JpaRepository<Achievement,Long> {
    List<Achievement> findAllByStudent_Uuid(long uuid);
    List<Achievement> findAllByStudent_UserId(String userId);
    List<Achievement> findAllByInterest_InterestId(long interestId);
}
