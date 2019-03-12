package bbro.iut_book_v01.transfer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransferRepo extends JpaRepository<Transfer, Long> {
    Transfer findByTransferId(Long transferId);
    List<Transfer> findAllByToGroupGroupId(Long groupId);
    boolean existsByStudentRequestUuidAndToGroupGroupId(long uuid, Long groupId);

    boolean existsByStudentRequestUuidAndToGroup_NoOfGroupAndToGroup_Department(long uuid,String noOfGroup, String dep );
}
