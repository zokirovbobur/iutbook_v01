package bbro.iut_book_v01.student;

import bbro.iut_book_v01.group.Group_;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Student {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue
    private long uuid;
    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String userId;

    @ManyToOne
    private Group_ group;

    private int fs;

    public Student() {
    }

    public void calculateFS(){

        int

                faculty = Integer.valueOf(String.valueOf(userId.charAt(4)))+1,
                currentYear = Calendar.getInstance().get(Calendar.YEAR),
                month = Calendar.getInstance().get(Calendar.MONTH)+1,
                studentEnteredYear10 =Integer.valueOf(
                        String.valueOf(userId.charAt(1))),
                studentEnteredYear1= Integer.valueOf(String.valueOf(userId.charAt(2))),
                studentEnteredYear = studentEnteredYear10*10+studentEnteredYear1;


        int semester = currentYear - (2000+ studentEnteredYear);
        semester*=2;
        if(month>=9){
            semester++;
        }


        System.out.println("f: "+faculty+" s: "+ semester);
        fs = faculty*10 + semester;
        System.out.println(fs);

    }
    public void detectFromFullName(String fullname){
        String str = fullname;
        //String fName,lName;
        int indexOfSpace = str.indexOf(" ");
        if (str.endsWith("OV")||str.endsWith("EV")||str.endsWith("OVA")||str.endsWith("EVA")||
                str.endsWith("ov")||str.endsWith("ev")||str.endsWith("ova")||str.endsWith("eva")
                ){

            firstName = str.substring(0,indexOfSpace);
            lastName = str.substring(indexOfSpace+1,str.length());
        } else {
            lastName = str.substring(0,indexOfSpace);
            firstName = str.substring(indexOfSpace+1,str.length());
        }
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public Student nullUuid(){uuid = 0;return this;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Group_ getGroup() {
        return group;
    }

    public void setGroup(Group_ group) {
        this.group = group;
    }

    public int getFs() {
        return fs;
    }

    public void setFs(int fs) {
        this.fs = fs;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //    private PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", userId='" + userId + '\'' +
                ", group='" + group + '\'' +
                ", fs='" + fs + '\'' +
                '}';
    }
}
