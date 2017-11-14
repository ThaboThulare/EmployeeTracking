/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.employeetracking.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "vanue")
public class Vanue
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "subject_desc")
    private String subjectDesc;
    
    @OneToMany(mappedBy = "vanue", fetch = FetchType.EAGER)
    private List<TimeTable> timeTableList;

    public Long getId()
    {
        return Id;
    }

    public List<TimeTable> getTimeTableList()
    {
        return timeTableList;
    }

    public void setTimeTableList(List<TimeTable> timeTableList)
    {
        this.timeTableList = timeTableList;
    }

    public void setId(Long Id)
    {
        this.Id = Id;
    }

    public String getSubjectDesc()
    {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc)
    {
        this.subjectDesc = subjectDesc;
    }
}
