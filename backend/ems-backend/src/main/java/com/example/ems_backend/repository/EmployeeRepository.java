package com.example.ems_backend.repository;

import org.springframework.data.jpa.repository.*;
import com.example.ems_backend.entity.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
