package bbro.iut_book_v01.personalCabinet.interests.Interest;

import bbro.iut_book_v01.personalCabinet.interests.InterestCategory.InterestCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Interest {
    @Id
    @GeneratedValue
    private long interestId;

    @ManyToOne
    private InterestCategory interestCategory;

    private String interestValue;

    private boolean isConfirmed;

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public long getInterestId() {
        return interestId;
    }

    public void setInterestId(long interestId) {
        this.interestId = interestId;
    }

    public InterestCategory getInterestCategory() {
        return interestCategory;
    }

    public void setInterestCategory(InterestCategory interestCategory) {
        this.interestCategory = interestCategory;
    }

    public String getInterestValue() {
        return interestValue;
    }

    public void setInterestValue(String interestValue) {
        this.interestValue = interestValue;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "interestId=" + interestId +
                ", interestCategory=" + interestCategory +
                ", interestValue='" + interestValue + '\'' +
                ", isConfirmed=" + isConfirmed +
                '}';
    }
}
