package cl.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
