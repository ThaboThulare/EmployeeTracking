/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.employeetracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.employeetracking.domain.Status;

/**
 *
 * @author User
 */
public interface StatusRepository extends JpaRepository<Status, Long>
{
    
}
