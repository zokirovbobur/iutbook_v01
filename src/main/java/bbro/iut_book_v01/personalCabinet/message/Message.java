package bbro.iut_book_v01.personalCabinet.message;

import bbro.iut_book_v01.student.Student;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private long messageId;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Student receiver;

    @Column(nullable = false)
    private String messageContent;

    private boolean isNew;

    private String messageType;

    @Column(nullable = false)
    private Timestamp date;

    public void giveCurrentDate() {
        date = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Student getReceiver() {
        return receiver;
    }

    public void setReceiver(Student receiver) {
        this.receiver = receiver;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", receiver=" + receiver +
                ", messageContent='" + messageContent + '\'' +
                ", isNew=" + isNew +
                ", date=" + date +
                '}';
    }
}
