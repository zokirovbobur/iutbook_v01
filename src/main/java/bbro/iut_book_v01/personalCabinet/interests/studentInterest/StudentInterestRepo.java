package bbro.iut_book_v01.personalCabinet.interests.studentInterest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentInterestRepo extends JpaRepository<StudentInterest,Long> {
    List<StudentInterest> findAllByInterest_InterestId(long id);
    List<StudentInterest> findAllByStudent_Uuid(long uuid);
}
