package za.co.employeetracking.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lecture_module")
public class LectureModule
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_detail_id")
    ClassDetail classDetail;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    UserDetail userDetail;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "dayOfWeek")
    private Date dayOfWeek;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassDetail getClassDetail() {
        return classDetail;
    }

    public void setClassDetail(ClassDetail classDetail) {
        this.classDetail = classDetail;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Date dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
