package bbro.iut_book_v01.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Map;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepo timetableRepo;

    public ResponseEntity<String> save(Timetable timetable){
        if (timetable.getGroup()==null|| timetable.getTimetable()==null){
            return ResponseEntity.badRequest().body("required fields: timetable, group");
        }else {
            timetableRepo.save(timetable);
            return ResponseEntity.ok("done");
        }
    }
    public String findTimeTableByGroupName(String groupName){
        final File folder = new File("./Timetable");
        String document = groupName+".txt";
        try {
            return findTimetableFromFolder(folder+"/"+document);
        } catch (IOException e) {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }
    private String findTimetableFromFolder(String direction) throws IOException {
        System.out.println(direction);
        File fileEntry = new File(direction);
        FileReader fr = null;
        try {
            fr = new FileReader(fileEntry);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "not found";
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        String content="";//String content="\"";
        while((line = br.readLine()) != null){
            //process the line
            //System.out.println(line);
            content+=line;
            if (content.endsWith(">")){
                content+=System.lineSeparator();
            }
        }
        //content+="\"";
        System.out.println("content: " + content);
        return content;
    }
}
