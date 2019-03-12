package bbro.iut_book_v01.team;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {
    Team findByTeamId(Long teamId);
    List<Team> findAllBySubjectFs(int fs);
    List<Team> findAll();
    boolean existsByTeamId(long id);

}
