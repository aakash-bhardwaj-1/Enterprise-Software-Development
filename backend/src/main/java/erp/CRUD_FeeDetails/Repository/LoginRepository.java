package erp.CRUD_FeeDetails.Repository;


import erp.CRUD_FeeDetails.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Employee, Integer> {
    public Employee findByEmail(String email);
}
