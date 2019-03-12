package bbro.iut_book_v01.staff.groupSection;

import bbro.iut_book_v01.group.Group_;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupSectionRepo extends JpaRepository<GroupSection,Long> {
    List<GroupSection> findAllByCourseName(String courseName);
    boolean existsByCourseName(String courseName);
    List<GroupSection> findAllByResponsibleStaff_StaffId(long uuid);

    GroupSection findByGroupSectionId(long groupSectionId);
 }
