package bbro.iut_book_v01.team.teamResponse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamResponseStudentsRepo extends JpaRepository<TeamResponseStudents,Long> {
    List<TeamResponseStudents> findAllByTeam_TeamId(long id);
    boolean existsByTeam_TeamId(long id);
}
