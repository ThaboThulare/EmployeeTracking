/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.employeetracking.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.joda.time.DateTime;

/**
 *
 * @author User
 */
@javax.persistence.Entity
@Table(name = "log_history")
public class LogHistory
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    
    @Column(name = "time_in")
    private DateTime timeIn;
    
    @Column(name = "time_out")
    private DateTime timeOut;

    @ManyToOne
    @JoinColumn(name = "vanue_id")
    private Vanue vanue;

    @ManyToOne
    @JoinColumn(name = "entity_id")
    private Entity entity;

    public Long getId()
    {
        return Id;
    }

    public void setId(Long Id)
    {
        this.Id = Id;
    }

    public DateTime getTimeIn()
    {
        return timeIn;
    }

    public void setTimeIn(DateTime timeIn)
    {
        this.timeIn = timeIn;
    }

    public DateTime getTimeOut()
    {
        return timeOut;
    }

    public void setTimeOut(DateTime timeOut)
    {
        this.timeOut = timeOut;
    }

    public Vanue getVanue()
    {
        return vanue;
    }

    public void setVanue(Vanue vanue)
    {
        this.vanue = vanue;
    }

    public Entity getEntity()
    {
        return entity;
    }

    public void setEntity(Entity entity)
    {
        this.entity = entity;
    }
    
    
}
