package bbro.iut_book_v01.personalCabinet.interests.InterestCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestCategoryRepo extends JpaRepository<InterestCategory, Long> {
    boolean existsByInterestCategoryId(long id);
    boolean existsByInterestCategoryValue(String category);
}
