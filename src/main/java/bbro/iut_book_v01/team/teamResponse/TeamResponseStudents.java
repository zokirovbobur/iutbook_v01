package bbro.iut_book_v01.team.teamResponse;

import bbro.iut_book_v01.student.Student;
import bbro.iut_book_v01.team.Team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TeamResponseStudents {
    @Id @GeneratedValue
    private long teamResStudentId;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Student responseStudent;

    public long getTeamResStudentId() {
        return teamResStudentId;
    }

    public void setTeamResStudentId(long teamResStudentId) {
        this.teamResStudentId = teamResStudentId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Student getResponseStudent() {
        return responseStudent;
    }

    public void setResponseStudent(Student responseStudent) {
        this.responseStudent = responseStudent;
    }

    @Override
    public String toString() {
        return "TeamResponseStudents{" +
                "teamResStudentId=" + teamResStudentId +
                ", team=" + team +
                ", responseStudent=" + responseStudent +
                '}';
    }
}
