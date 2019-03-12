package bbro.iut_book_v01.tutorialContent;

import bbro.iut_book_v01.personalCabinet.interests.Interest.Interest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TutorialVideo {
    @Id
    @GeneratedValue
    private long tutorialVideoId;

    @ManyToOne
    private Interest interest;

    private String url;

}
