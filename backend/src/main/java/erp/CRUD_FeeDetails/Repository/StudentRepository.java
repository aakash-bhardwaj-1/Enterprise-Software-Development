package erp.CRUD_FeeDetails.Repository;

import erp.CRUD_FeeDetails.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
