package erp.CRUD_FeeDetails.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bill")
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int amount;
    private String description;
    private Date bill_date;

//    @JsonIgnore
//    @OneToMany(mappedBy = "bill")
//    private List<Student> bill;
}
