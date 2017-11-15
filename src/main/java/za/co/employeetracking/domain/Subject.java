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
@Table(name = "subject")
public class Subject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "subject_desc")
    private String subjectDesc;
    
    @ManyToOne
    @JoinColumn(name = "entity_id")
    private EntityClass entityClass;

    public EntityClass getEntityClass()
    {
        return entityClass;
    }

    public void setEntityClass(EntityClass entityClass)
    {
        this.entityClass = entityClass;
    }
    
    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
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
