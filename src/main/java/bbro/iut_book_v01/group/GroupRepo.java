package bbro.iut_book_v01.group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepo extends JpaRepository<Group_,Long> {
    List<Group_> findAllByDepartment(String department);
    List<Group_> findAllByNoOfGroupIsStartingWith(String enteredYear);
    List<Group_> findAllByNoOfGroupIsStartingWithAndDepartment(String enteredYear, String department);
    boolean existsByGroupId(long groupId);
    boolean existsByDepartmentAndNoOfGroup(String dep, String noOfGroup);
    Group_ findByDepartmentAndNoOfGroup(String dep, String noOfGroup);

}
