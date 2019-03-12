package bbro.iut_book_v01.personalCabinet.interests.InterestCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InterestCategory {
    @Id
    @GeneratedValue
    private long interestCategoryId;

    private String interestCategoryValue;



    public long getInterestCategoryId() {
        return interestCategoryId;
    }

    public void setInterestCategoryId(long interestCategoryId) {
        this.interestCategoryId = interestCategoryId;
    }

    public String getInterestCategoryValue() {
        return interestCategoryValue;
    }

    public void setInterestCategoryValue(String interestCategoryValue) {
        this.interestCategoryValue = interestCategoryValue.toLowerCase();
    }

    @Override
    public String toString() {
        return "InterestCategory{" +
                "interestCategoryId=" + interestCategoryId +
                ", interestCategoryValue='" + interestCategoryValue + '\'' +
                '}';
    }
}
