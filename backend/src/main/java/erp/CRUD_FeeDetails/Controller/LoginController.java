package erp.CRUD_FeeDetails.Controller;

import erp.CRUD_FeeDetails.entities.Employee;
import erp.CRUD_FeeDetails.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {

    //@Autowired
    private LoginRepository loginRepository;

        @PostMapping("/login/{email_id}/{password}")
    boolean update(@PathVariable String email_id, @PathVariable String password){
        Employee s = loginRepository.findByEmail(email_id);
        if (s != null) {
            String pass = s.getPassword();
            Integer domid=s.getDepartment();
            if(password.equals(pass) && domid==1)
            return true;
        }
        return false;
    }
}
