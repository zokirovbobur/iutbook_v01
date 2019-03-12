package bbro.iut_book_v01.personalCabinet.interests.Interest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepo extends JpaRepository<Interest,Long> {
    boolean existsByInterestId(long id);
    boolean existsByInterestValue(String type);
    List<Interest> findAllByInterestValueOrInterestCategory_InterestCategoryValue(String interest, String category);
}
