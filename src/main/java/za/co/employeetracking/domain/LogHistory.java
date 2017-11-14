/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.employeetracking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "log_history")
public class LogHistory
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "time_table_id")
    private TimeTable timeTable;
    
    @Column(name ="is_attended")
    private boolean isAttended;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private EntityClass entityClass;

    public Long getId()
    {
        return Id;
    }

    public void setId(Long Id)
    {
        this.Id = Id;
    }

    public EntityClass getEntityClass()
    {
        return entityClass;
    }

    public void setEntityClass(EntityClass entityClass)
    {
        this.entityClass = entityClass;
    }


    public TimeTable getTimeTable()
    {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable)
    {
        this.timeTable = timeTable;
    }
        public boolean isIsAttended()
    {
        return isAttended;
    }

    public void setIsAttended(boolean isAttended)
    {
        this.isAttended = isAttended;
    }

}
