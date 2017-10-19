package za.co.employeetracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.employeetracking.domain.Scanner;

public interface ScannerRepository extends JpaRepository<Scanner, Long>
{
}
