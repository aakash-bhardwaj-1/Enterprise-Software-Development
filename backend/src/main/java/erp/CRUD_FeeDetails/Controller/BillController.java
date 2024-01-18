package erp.CRUD_FeeDetails.Controller;


import erp.CRUD_FeeDetails.Repository.BillsRepository;
import erp.CRUD_FeeDetails.entities.Bills;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/bills") // Added a base path for the controller
public class BillController {

    private final BillsRepository billsRepository;

    public BillController(BillsRepository billsRepository) {
        this.billsRepository = billsRepository;
    }

    @PostMapping("/add")
    public Bills newBill(@RequestBody Bills newBill) {
        return billsRepository.save(newBill);
    }

    @GetMapping("/all")
    public List<Bills> getAllBills() {
        return billsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bills getBillById(@PathVariable int id) {
        return billsRepository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Bills updateBill(@RequestBody Bills newBill, @PathVariable int id) {
        Bills bill = billsRepository.findById(id).orElse(null);
        if (bill != null) {
            // Update fields as needed
            bill.setAmount(newBill.getAmount());
            // Add more fields as needed

            billsRepository.save(bill);
            return bill;
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBill(@PathVariable int id) {
        billsRepository.deleteById(id);
        return "Deleted bill with ID: " + id;
    }
}
