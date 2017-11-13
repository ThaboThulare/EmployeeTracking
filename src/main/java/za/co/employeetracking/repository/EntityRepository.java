/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.employeetracking.repository;

import javax.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface EntityRepository extends JpaRepository<Entity, Long>
{
    
}
