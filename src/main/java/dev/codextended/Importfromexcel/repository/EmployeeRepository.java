package dev.codextended.Importfromexcel.repository;

import dev.codextended.Importfromexcel.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
