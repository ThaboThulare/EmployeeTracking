package za.co.employeetracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.employeetracking.domain.LectureModule;

public interface LectureModuleRepository extends JpaRepository<LectureModule, Long>
{
}
