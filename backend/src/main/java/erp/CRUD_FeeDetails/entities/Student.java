package erp.CRUD_FeeDetails.entities;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    @Column(nullable = false)
    private String roll_no;
    private String first_name;
    private String last_name;
    private String email;
    private float cgpa;
    private int placement_id;
    @Column(nullable = false)
    private int domain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bill_id")
    private Bills bills;
}
