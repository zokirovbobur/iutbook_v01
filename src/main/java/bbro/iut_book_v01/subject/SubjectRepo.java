package bbro.iut_book_v01.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    List<Subject> findAllByFs(int fs);
    Subject findBySubjectName(String subjectName);
    boolean existsBySubjectId(long id);
}
