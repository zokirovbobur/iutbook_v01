package bbro.iut_book_v01.personalCabinet.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;


    public ResponseEntity<String> save(Message message){
        if(message.getReceiver()==null||message.getMessageContent()==null){
            return ResponseEntity.badRequest().body("required fields: student receiver, message content");
        }
        else {

            message.giveCurrentDate();
            messageRepo.save(message);
            return ResponseEntity.ok("Message has been added");
        }
    }
    public List<Message> findAll(){
        messageRepo.findAll().forEach(message -> {
            System.out.println(message.getDate());
        });
        return messageRepo.findAll();
    }
    public List<Message> findAllByReceiver(Message message){
        return messageRepo.findAllByReceiver(message.getReceiver());
    }
    public ResponseEntity<String> delete(Message message){
        messageRepo.delete(message);
        return ResponseEntity.ok("deleted successfully");
    }
}
