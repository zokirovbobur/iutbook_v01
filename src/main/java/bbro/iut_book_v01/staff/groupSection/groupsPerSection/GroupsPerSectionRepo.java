package bbro.iut_book_v01.staff.groupSection.groupsPerSection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupsPerSectionRepo extends JpaRepository<GroupsPerSection,Long> {
    List<GroupsPerSection> findAllByGroupSection_GroupSectionId(long id);
    List<GroupsPerSection> findAllByGroupSection_ResponsibleStaff_StaffId(long uuid);
}
