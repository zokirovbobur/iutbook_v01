package bbro.iut_book_v01.staff.staff;

import bbro.iut_book_v01.staff.staff.staffType.StaffType;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Staff {
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue
    private long staffId;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String userId;

    @ManyToOne
    private StaffType staffType;

    public Staff nullUuid(){
        this.staffId = 0;
        return this;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

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

    public StaffType getStaffType() {
        return staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", userId='" + userId + '\'' +
                ", staffType=" + staffType +
                '}';
    }
}
