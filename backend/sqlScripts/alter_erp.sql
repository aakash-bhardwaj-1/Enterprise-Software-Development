alter table bill add 
	constraint fk_bill_student_id FOREIGN KEY (bill_student_id) references student(student_id);

