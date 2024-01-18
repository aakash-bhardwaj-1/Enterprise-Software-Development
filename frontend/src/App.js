import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Navbar from './layout/navbar';
import Login from './functions/login';
import Home from './functions/home';
import Paid from './functions/paid';
import Unpaid from './functions/unpaid';
import AddSingleBill from './functions/addSingleBill';
import AddBillToDomain from './functions/addBillToDomain';
import Update from './functions/update';


function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/home" element={<Home />} />
          <Route exact path="/paid" element={<Paid />} />
          <Route exact path="/unpaid" element={<Unpaid />} />
          <Route exact path="/addSingleBill" element={<AddSingleBill />} />
          <Route exact path="/addBills" element={<AddBillToDomain />} />
          <Route exact path="/update" element={<Update />} />
          <Route exact path="/login" element={<Login />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
