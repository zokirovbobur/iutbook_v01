package bbro.iut_book_v01.staff.staff.staffType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StaffType {
    @Id
    @GeneratedValue
    private long staffTypeId;
    @Column(unique = true)
    private String staffTypeValue;

    public long getStaffTypeId() {
        return staffTypeId;
    }

    public void setStaffTypeId(long staffTypeId) {
        this.staffTypeId = staffTypeId;
    }

    public String getStaffTypeValue() {
        return staffTypeValue;
    }

    public void setStaffTypeValue(String staffTypeValue) {
        this.staffTypeValue = staffTypeValue;
    }

    @Override
    public String toString() {
        return "StaffType{" +
                "staffTypeId=" + staffTypeId +
                ", staffTypeValue='" + staffTypeValue + '\'' +
                '}';
    }
}
