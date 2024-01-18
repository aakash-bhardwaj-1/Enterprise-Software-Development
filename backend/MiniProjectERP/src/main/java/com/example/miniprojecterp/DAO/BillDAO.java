package com.example.miniprojecterp.DAO;

import com.example.miniprojecterp.Bean.Bill;

import java.util.List;

public interface BillDAO {
    public boolean addBill(Bill bill);

    public boolean addBillDomain(int domId, Bill bill);

    public Bill getBill(int  billId);

    public List<Bill> getAllBills();

    public void updateBillAmt(int billId,int amount);

    public void updateBillDeadline(Integer billId,String deadline);

    public void deleteBill(Integer billId);
}
