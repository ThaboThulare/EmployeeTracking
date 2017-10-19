package za.co.employeetracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.employeetracking.domain.UserDetail;

public interface UserRoleRepository extends JpaRepository<UserDetail, Long>
{
}
