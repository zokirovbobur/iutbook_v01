package bbro.iut_book_v01.team;

import bbro.iut_book_v01.staff.staff.StaffRepo;
import bbro.iut_book_v01.student.Student;
import bbro.iut_book_v01.student.StudentRepo;
import bbro.iut_book_v01.subject.Subject;
import bbro.iut_book_v01.subject.SubjectRepo;
import bbro.iut_book_v01.team.teamResponse.TeamResponseStudents;
import bbro.iut_book_v01.team.teamResponse.TeamResponseStudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private TeamResponseStudentsRepo responseStudentsRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private SubjectRepo subjectRepo;

    //creates new record for finding team
    public ResponseEntity<String> createTeam(Team team){
        if (team.getStudentRequest()==null){
            return ResponseEntity.badRequest().body("request student is missing");
        }else if (!studentRepo.existsByUuid(team.getStudentRequest().getUuid())){
            return ResponseEntity.badRequest().body("request student's Uuid is incorrect");
        }else if (team.getStaff()!=null &&
                !staffRepo.existsByUserId(team.getStaff().getUserId())){
            return ResponseEntity.badRequest().body("professor's or staff's userId is incorrect");
        }else if(team.getMaxNoOfStudents()<=1){
            return ResponseEntity.badRequest().body("max number of students is incorrect");
        }else if ( team.getSubject()!=null
                && !subjectRepo.existsBySubjectId(team.getSubject().getSubjectId())){
            return ResponseEntity.badRequest().body("subject id is incorrect");
        }else if (team.getTeamId()!=0){
            return ResponseEntity.badRequest().body("this api for creating new team search only");
        }else {


            team.setStaff(staffRepo.findByUserId(team.getStaff().getUserId()));
            team.setComment(team.getComment().toLowerCase());
            team.setTitle(team.getTitle().toLowerCase());

            team = teamRepo.save(team);
            teamRepo.flush();//from stackoverflow , but i have no idea why need
            System.out.println("team info inside create team: " + team.toString());
            TeamResponseStudents teamResponseStudents = new TeamResponseStudents();
            teamResponseStudents.setTeam(team);
            teamResponseStudents.setResponseStudent(team.getStudentRequest());
            responseStudentsRepo.save(teamResponseStudents);
            return ResponseEntity.ok("team search has been started");
        }

    }

    public ResponseEntity<String> addResponseStudent(long teamId,Student student){

        int maxNumber = teamRepo.findByTeamId(teamId).getMaxNoOfStudents(),
                numberOfResponses = responseStudentsRepo.findAllByTeam_TeamId(teamId).size();
        System.out.println("maxNumber: " + maxNumber + "\nnumberOfResponses: " + numberOfResponses);
        if (!studentRepo.existsByUuid(student.getUuid())){
            return ResponseEntity.badRequest().body("student uuid is incorrect");
        }else if (!teamRepo.existsByTeamId(teamId)){
            return ResponseEntity.badRequest().body("team Id is incorrect");
        }else if (maxNumber <= numberOfResponses){
            return ResponseEntity.badRequest().body("team is already full");
        }else {
            TeamResponseStudents students = new TeamResponseStudents();
            students.setTeam(teamRepo.findByTeamId(teamId));
            students.setResponseStudent(student);

            responseStudentsRepo.save(students);
            return ResponseEntity.ok("new student added");
        }
    }

    public List<Team> findAll(){
        List<Team> teams = teamRepo.findAll();
        teams.forEach(team -> {
            team.setStudentRequest(team.getStudentRequest().nullUuid());
            team.setStaff(team.getStaff().nullUuid());

        });
        return teams;
    }

    public List<Student> findAllByTeamId(Team team){
        List<Student> students = new ArrayList<>();

        List<TeamResponseStudents> teamResponseStudents = responseStudentsRepo.findAllByTeam_TeamId(team.getTeamId());
        teamResponseStudents.forEach(teamResponseStudent -> {
            System.out.println(teamResponseStudent.toString());
            teamResponseStudent.setResponseStudent(
                    teamResponseStudent.getResponseStudent().nullUuid()
            );
            Team teamCycle  = teamResponseStudent.getTeam();
            teamCycle.setStaff(teamResponseStudent.getTeam().getStaff().nullUuid());
            teamCycle.setStudentRequest(teamResponseStudent.getTeam().getStudentRequest().nullUuid());
            teamResponseStudent.setTeam(teamCycle);
            students.add(teamResponseStudent.getResponseStudent());
        });

        return students;
    }

    public ResponseEntity<String> delete(Team team){
        teamRepo.delete(team);
        return ResponseEntity.ok("team deleted");
    }

    public List<Team> findAllByFS(Subject subject){
        List<Team> teams = teamRepo.findAllBySubjectFs(subject.getFs());
        teams.forEach(team -> {
            team.setStudentRequest(team.getStudentRequest().nullUuid());
            team.setStaff(team.getStaff().nullUuid());

        });
        return teams;
    }


}
