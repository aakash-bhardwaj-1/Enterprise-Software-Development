import axios from 'axios';
import React, {useState} from 'react'
import { useNavigate } from 'react-router-dom';
import Navbar2 from '../layout/navbar2';

export default function Login() {

    const navigate = useNavigate();

    const [log, setlog] =useState({
        user_name:"",
        user_password:""
    });
    
    const{user_name, user_password}=log;

    const onInputChange=(e)=>{

        setlog({...log,[e.target.name]:e.target.value})
    };

    const onSubmit = async (e)=>{
        e.preventDefault();
        const response = await axios.post(`http://localhost:8080/MiniProjectERP-1.0-SNAPSHOT/api/details/login/`, log)
        
        console.log(response);
        navigate("/home");

        
    };

  return (
    <div> <Navbar2/>
    <div className = "container">
    <div className='row d-inline'>
    <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
        <h2 className='text-center m-4'>Login</h2>
        <form onSubmit={(e)=>onSubmit(e)}>
        <div className='mb-3'>
            <label htmlFor= "username" className='form-label'>
                Username
            </label>
            <input 
            type={"text"} 
            className="form-control" 
            placeholder="Enter username" 
            name="user_name" 
            value={user_name}
            onChange={(e)=>onInputChange(e)}
            />
        </div>

        <div className='mb-3'>
            <label htmlFor= "password" className='form-label'>
                Password
            </label>
            <input type={"password"}
            className="form-control" 
            placeholder="Enter password" 
            name="user_password" 
            value={user_password}
            onChange={(e)=>onInputChange(e)}/>
        </div>

        <button type="submit" className='btn btn-outline-primary'>
            Submit
        </button>
        </form>
    </div>
</div>
</div>
</div>
  )
}
