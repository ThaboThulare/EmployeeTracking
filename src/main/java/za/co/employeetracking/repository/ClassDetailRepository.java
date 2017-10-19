package za.co.employeetracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.employeetracking.domain.ClassDetail;

public interface ClassDetailRepository extends JpaRepository<ClassDetail, Long>
{

}
