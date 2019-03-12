package bbro.iut_book_v01.personalCabinet.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public Message sample(){return new Message();}

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Message message){
        return messageService.save(message);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Message message){
        return messageService.delete(message);
    }

    @GetMapping("all")
    public List<Message> findAll(){return messageService.findAll();}

    @PostMapping("findByReceiver")
    public List<Message> findAllByReceiver(@RequestBody Message message){
        return messageService.findAllByReceiver(message);
    }
}
