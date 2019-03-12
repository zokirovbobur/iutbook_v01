package bbro.iut_book_v01.personalCabinet.message;

import bbro.iut_book_v01.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findAllByReceiver(Student receiver);


}
