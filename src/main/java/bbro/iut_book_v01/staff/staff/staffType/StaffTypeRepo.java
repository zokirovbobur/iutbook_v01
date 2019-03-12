package bbro.iut_book_v01.staff.staff.staffType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffTypeRepo extends JpaRepository<StaffType, Long> {
    StaffType findByStaffTypeId(long staffTypeId);
    boolean existsByStaffTypeId(long staffTypeId);
    boolean existsByStaffTypeValue(String value);
}
