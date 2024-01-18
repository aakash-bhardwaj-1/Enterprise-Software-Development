import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom';
import Navbar from '../layout/navbar';

export default function Paid() {

    const [bill, setBill]=useState([

    ])

    
    useEffect(() => {
        loadBills();
    },[]);

    const loadBills= async()=>{
        const result = await axios.get("http://localhost:8080/MiniProjectERP-1.0-SNAPSHOT/api/bills/viewPaid");
        setBill(result.data);
    }

    const deleteSpec= async(specialisation_id)=>{
        await axios.delete(`http://localhost:8080/erpRest-1.0-SNAPSHOT/api/specialisation?sid=${specialisation_id}`);
        loadBills();
    }

  return (
    <div>
        <Navbar/>
        <h2 className='text-center m-2'>Paid Bills</h2>
        <table class="table border shadow">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Description</th>
      <th scope="col">Amount</th>
      <th scope="col">Bill Date</th>
      <th scope="col">Deadline</th>
      <th scope="col">Student_id</th>
    </tr>
  </thead>
  <tbody>
    {
        bill.map((bills,index)=>(
        <tr>
            <td>{bills.id}</td>
            <td>{bills.description}</td>
            <td>{bills.amount}</td>
            <td>{bills.bill_date}</td>
            <td>{bills.deadline}</td>
            <td>{bills.stud.student_id}</td>
        </tr>
        ))
    }
  </tbody>
</table>
<Link className='btn btn-outline-primary' to="/home">View All Bills</Link>
</div>
  )
}
