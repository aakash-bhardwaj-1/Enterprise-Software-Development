package erp.CRUD_FeeDetails.Controller;
import erp.CRUD_FeeDetails.entities.Bills;
import erp.CRUD_FeeDetails.object_class.DataToSend;

import java.util.ArrayList;
import java.util.List;

import erp.CRUD_FeeDetails.entities.Student;
import erp.CRUD_FeeDetails.Repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class StudentBillController {

    private final StudentRepository studentRepository;

    public  StudentBillController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PutMapping("/student/{student_id}/{bill_id}")
    Student update(@PathVariable Bills bill_id,@PathVariable Integer student_id){
        Student s = studentRepository.findById(student_id).orElse(null);

        if(s!=null){
            s.setBills(bill_id);
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    @PutMapping("/student/{student_id}")
    Student updatetosetnull(@PathVariable(name = "student_id") Integer student_id) {
        Student s = studentRepository.findById(student_id).orElse(null);

        if (s != null) {
            // Set the bill_id to null
            s.setBills(null);
            studentRepository.save(s);
            return s;
        }
        return null;
    }

    @PutMapping("/student/domain/{bill_id}/{domain_id}")
    public List<Student> updateDomain(@PathVariable Bills bill_id, @PathVariable Integer domain_id) {
        List<Student> students = studentRepository.findAll();

        for (Student student : students) {
            if (String.valueOf(student.getDomain()).equals(String.valueOf(domain_id))) {
                student.setBills(bill_id); // Assuming you have a setBillId method
            }
        }

        studentRepository.saveAll(students);
        return students;

    }

    public Student newStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @GetMapping("/student/detail")
    public List<DataToSend> getAllDetails() {
        List<Student> students = studentRepository.findAll();
        List<DataToSend> dataToSendList = new ArrayList<>();

        for (Student student : students) {
            DataToSend dataToSend = new DataToSend();
            dataToSend.setStudent_id(student.getStudent_id());
            dataToSend.setFirst_name(student.getFirst_name());
            dataToSend.setLast_name(student.getLast_name());
            dataToSend.setDomain(student.getDomain());
            // Assuming there is only one bill for each student in this example
            if (student.getBills() != null ) {
                Bills bill = student.getBills(); // Assuming you have a List<Bill> in Student
                dataToSend.setBill_id(String.valueOf(bill.getId()));
                dataToSend.setBill_discription(bill.getDescription());
            }

            dataToSendList.add(dataToSend);
        }

        return dataToSendList;
    }
    @GetMapping("/student/detail/{id}")
    public List<Student> getDetail(@PathVariable int id) {
        return studentRepository.findAll();
    }
}
