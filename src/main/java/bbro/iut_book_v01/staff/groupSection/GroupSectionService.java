package bbro.iut_book_v01.staff.groupSection;

import bbro.iut_book_v01.staff.groupSection.groupsPerSection.GroupsPerSection;
import bbro.iut_book_v01.staff.groupSection.groupsPerSection.GroupsPerSectionRepo;
import bbro.iut_book_v01.staff.staff.Staff;
import bbro.iut_book_v01.staff.staff.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupSectionService {
    @Autowired
    private GroupSectionRepo sectionRepo;
    @Autowired
    private GroupsPerSectionRepo perSectionRepo;
    @Autowired
    private StaffRepo staffRepo;

    public ResponseEntity<String> save(GroupSection groupSection){
        if (staffRepo.existsByStaffId(groupSection.getResponsibleStaff().getStaffId())){
            sectionRepo.save(groupSection);
            return ResponseEntity.ok("done");
        }else {
            return ResponseEntity.badRequest().body("Responsible professor is not available in our base");
        }

    }
    public List<GroupsPerSection> findGroupsPerSectionId(GroupSection groupSection){
        return perSectionRepo.findAllByGroupSection_GroupSectionId(groupSection.getGroupSectionId());
    }

    public List<GroupSection> findAll(){
        return sectionRepo.findAll();
    }
    public List<GroupSection> findAllByCourseName(GroupSection groupSection){
        return sectionRepo.findAllByCourseName(groupSection.getCourseName());
    }
    public List<GroupsPerSection> finAllByResponsibleProfessor(Staff staff){
        return perSectionRepo.findAllByGroupSection_ResponsibleStaff_StaffId(staff.getStaffId());
    }
}
