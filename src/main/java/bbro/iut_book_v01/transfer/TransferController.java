package bbro.iut_book_v01.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @GetMapping
    public Transfer sample(){return new Transfer();}

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Transfer transfer){return transferService.save(transfer);}

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Transfer transfer){
        return ResponseEntity.badRequest().body("delete function allowed only for admin only");
    }

    @GetMapping("all")
    public List<Transfer> getAll(){
        return transferService.findAll();
    }
    @PostMapping("allByToGroup")
    public List<Transfer> getAllByToGroup(@RequestBody Transfer transfer){
        return transferService.findAllByToGroup(transfer);
    }
}
