package bbro.iut_book_v01.student;

import bbro.iut_book_v01.group.GroupRepo;
import bbro.iut_book_v01.group.Group_;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private GroupRepo groupRepo;

    public ResponseEntity<Student> save(Student student){
        studentRepo.save(student);
        return ResponseEntity.ok(studentRepo.findByUserId(student.getUserId()));
    }
    public ResponseEntity<Student> login(StudentLogin student){

        if (isPasswordCorrect(student)){

            Student studentFromBase;
            if (studentRepo.existsByUserId(student.getUserId())){
                studentFromBase = studentRepo.findByUserId(student.getUserId());
                studentFromBase.calculateFS();
                studentRepo.save(studentFromBase);
                return ResponseEntity.ok(studentFromBase);
            }else {
                Student studentReport = new Student();
                studentReport.setFirstName("user is not exists");
                return ResponseEntity.badRequest().body(studentReport);
            }
        }else {
            Student studentReport = new Student();
            studentReport.setFirstName("password is incorrect");
            return ResponseEntity.badRequest().body(studentReport);
        }


    }

    private boolean isPasswordCorrect(StudentLogin studentLogin){
//        Map<String, String> vars = new HashMap<String, String>();
//        vars.put("id", "JS01");
        /**
         *
         * Doing the REST call and then displaying the data/user object
         *
         */
        try
        {
            /*
                This is code to post and return a user object
             */
            RestTemplate rt = new RestTemplate();
            //rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());
            String uri = "http://localhost:8080/student/testLogin";

            boolean returns = rt.postForObject(uri, studentLogin, boolean.class);
            if (returns){
                //there should be returned true
            }else {
                //there false
            }
            System.out.println("returns: " + returns);
        }
        catch (HttpClientErrorException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;//it should be taken from here
    }

    public boolean checkPasswordTesting(StudentLogin studentLogin){
        return studentLogin.getUserId().equals("u1710117") && studentLogin.getPassword().equals("pass");
    }


    //smart update for updating only group of object (but it should have been changed to full update one)
    public ResponseEntity<String> update(Student student){
        if(student.getUuid()==0||student.getGroup()==null){
            return ResponseEntity.badRequest().body("required fields student's uuid and group");
        }else {
            Student studentFromBase = studentRepo.findByUuid(student.getUuid());
            try {
                System.out.println(studentFromBase.getUserId()==null);
            }catch (NullPointerException e){
                return ResponseEntity.badRequest().body("uuid is incorrect");
            }
            System.out.println("after try catch and return");
            studentFromBase.setGroup(student.getGroup());
            studentRepo.save(studentFromBase);
            return ResponseEntity.ok("updated");
        }
    }

    public List<Student> findAll(){
        List<Student> all = studentRepo.findAll();
        all.forEach(student -> {
            student.nullUuid();
            //student.setPassword("");
        });
        return all;
    }
    public ResponseEntity<String> delete(Student student){
//        Student studentFromBase = studentRepo.findByUserId(student.getUserId());
//        if(student.matchesPassword(studentFromBase)){
//            studentRepo.delete(student);
//            return ResponseEntity.ok("User has been deleted successfully...");
//        }
//        else {
//            return ResponseEntity.badRequest().body("password is incorrect");
//
//        }
        return ResponseEntity.badRequest().body("this function is not available now");
    }

    public ResponseEntity<Student> findByUserId(StudentSample student){
        System.out.println(student.getUserId());

        return ResponseEntity.ok(studentRepo.findByUserId(student.getUserId()).nullUuid()) ;
    }

    public ResponseEntity<Student> findByName(Student student){
        return ResponseEntity.ok(studentRepo.findByFirstNameOrLastName(
                student.getFirstName(),student.getLastName()
        ).nullUuid());
    }

    //retrieving data from excel
    public ResponseEntity<String> updateAllStudentsGroupsUsingXSLX(String docName){

        String SAMPLE_XLSX_FILE_PATH =  docName;
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // 3. Or you can use a Java 8 forEach with lambda
        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });
        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 3. Or you can use Java 8 forEach loop with lambda
        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
        sheet.forEach(row -> {
            Student studentFromBase;
            Group_ groupFromBase;
            String objectData[] = new String[3];
            for (int i = 0; i < 3; i++) {
                objectData[i] = dataFormatter.formatCellValue(row.getCell(i));
            }

            if (studentRepo.existsByUserId(objectData[0].toLowerCase())){
                System.out.println("student exists in db");
                studentFromBase = studentRepo.findByUserId(objectData[0].toLowerCase());
                System.out.println("stud from db: " + studentFromBase.toString());
            }else {
                System.out.println("stud not exists");
                studentFromBase = new Student();

                studentFromBase.detectFromFullName(objectData[1]);
                //this is not final result
                studentFromBase.setUserId(objectData[0].toLowerCase());
            }
            String dep = objectData[2].substring(0,3).toUpperCase();
            String noOfGr = objectData[2].substring(3,objectData[2].length());
            if (noOfGr.startsWith("-")){
                noOfGr = noOfGr.substring(1);
            }
            if (!groupRepo.existsByDepartmentAndNoOfGroup(dep,noOfGr)){
                groupFromBase = new Group_();
                groupFromBase.setDepartment(dep);//there should be checked
                groupFromBase.setNoOfGroup(noOfGr );

                groupRepo.save(groupFromBase);
            }

            groupFromBase = groupRepo.findByDepartmentAndNoOfGroup(dep, noOfGr );

            studentFromBase.setGroup(groupFromBase);
            studentFromBase.calculateFS();
            System.out.println("students info: " + studentFromBase.toString()  );

            studentRepo.save(studentFromBase);
        });

        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
        return ResponseEntity.ok("all student's group has been changed");
    }


}
