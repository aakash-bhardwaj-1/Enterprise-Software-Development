package erp.CRUD_FeeDetails.object_class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataToSend {
    private int student_id;
    private String first_name;
    private String last_name;
    private int domain;
    private String bill_id;
    private String bill_discription;
}
