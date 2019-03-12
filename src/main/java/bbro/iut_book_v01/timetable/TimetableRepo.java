package bbro.iut_book_v01.timetable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepo extends JpaRepository<Timetable, Long> {
    Timetable findByGroupGroupId(long groupId);
    boolean existsByGroupGroupId(long groupId);

}
