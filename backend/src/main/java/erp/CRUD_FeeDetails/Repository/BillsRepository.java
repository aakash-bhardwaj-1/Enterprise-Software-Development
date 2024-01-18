package erp.CRUD_FeeDetails.Repository;

import erp.CRUD_FeeDetails.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepository extends JpaRepository<Bills,Integer>{
}