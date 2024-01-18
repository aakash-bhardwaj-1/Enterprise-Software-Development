import React from 'react'
import { Link } from 'react-router-dom'
export default function Navbar() {
  return (
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark" style={{backgroundColor: '#ff6600'}}>
    <div class="container-fluid">
    <a class="navbar-brand" href="/home">Fee Details CRUD</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Add Bill
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/addSingleBill">Add Single Bill</a>
          <a class="dropdown-item" href="/addBills">Add Bill to Domain</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/update">Update</a>
      </li>
    </ul>
  </div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <Link className='btn btn-outline-light mx-2' to="/login">
      Logout
    </Link>
    
  </div>
</nav>
    </div>
  )
}
