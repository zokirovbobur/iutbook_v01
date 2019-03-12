package bbro.iut_book_v01.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransferService {
    @Autowired
    private TransferRepo transferRepo;
    //smart createTeam function which recognizes
    public ResponseEntity<String> save(Transfer transfer){
        System.out.println(transfer.toString());
        //incorrect or null fields
        if(transfer.getStudentRequest()==null|| transfer.getToGroup()==null){
            return ResponseEntity.badRequest().body("required fields: " +
                    "data of student who want to change group and to which group want to change ");
        }else {

            if (transferRepo.existsByStudentRequestUuidAndToGroupGroupId(transfer.getStudentRequest().getUuid(),
                    transfer.getToGroup().getGroupId()
                    )
                    ){
                System.out.println("such transfer exists already");
                return ResponseEntity.badRequest().body("such transfer exists already");
            }

            String res;
            try{
                Transfer transferFromBase= transferRepo.findByTransferId(transfer.getTransferId());
                if (!transferFromBase.isFixed()){
                    //adding responsive student
                    res = "Congratulations transfer has been fixed";
                    transferFromBase.setStudentResponse(transfer.getStudentResponse());
                    transferRepo.save(transferFromBase);
                    return ResponseEntity.ok(res);
                }
                else {
                    //handling overflow of responsive students
                    res ="transfer is already fixed";
                    return ResponseEntity.badRequest().body(res);
                }

            }catch (NullPointerException e){
                //adding new transfer
                if(transfer.getStudentResponse()!=null){
                    return ResponseEntity.badRequest().body("groupId should be entered when adding response student");
                }
                System.out.println(transfer.toString());
                transferRepo.save(transfer);
                res = "new transfer added successfully";
                return ResponseEntity.ok(res);
            }


        }




    }



    public ResponseEntity<String> delete(Transfer transfer){
        transferRepo.delete(transfer);
        return ResponseEntity.ok("transfer deleted successfully");
    }
    public List<Transfer> findAll(){
        List<Transfer> all = transferRepo.findAll();
        transferRepo.findAll().forEach(transfer -> {
        transfer.getStudentRequest().nullUuid();
        //transfer.getStudentRequest().setPassword("");
        try{
            transfer.getStudentResponse().nullUuid();
            //transfer.getStudentResponse().setPassword("");
        }catch (NullPointerException e){
            System.out.println("nullPointerException TransferService in findAll()");
            //e.printStackTrace();
        }


        });
        return all;
    }
    public List<Transfer> findAllByToGroup(Transfer transfer){
        return transferRepo.findAllByToGroupGroupId(transfer.getTransferId());
    }

}
