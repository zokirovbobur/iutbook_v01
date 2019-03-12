package bbro.iut_book_v01.subject.subjectProfessor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectProfessorRepo extends JpaRepository<SubjectProfessor, Long> {
    boolean existsByStaff_StaffIdAndSubject_SubjectId(long staffId,long subjectId);
    List<SubjectProfessor> findAllBySubject_SubjectId(long subjectId);

}
