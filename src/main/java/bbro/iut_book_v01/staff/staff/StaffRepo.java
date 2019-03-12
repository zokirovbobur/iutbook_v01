package bbro.iut_book_v01.staff.staff;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StaffRepo extends JpaRepository<Staff, Long> {
    Staff findByStaffId(long staffId);
    Staff findByUserId(String userId);
    boolean existsByUserId(String userId);
    boolean existsByStaffId(long uuid);

    Staff findByFirstNameOrLastName(String firstName,String lastName);
    List<Staff> findAllByStaffTypeStaffTypeId(Long staffTypeId);
    List<Staff> findAllByStaffTypeStaffTypeValue(String staffTypeValue);
    boolean existsByFirstNameOrLastName(String firstName,String lastName);
}
