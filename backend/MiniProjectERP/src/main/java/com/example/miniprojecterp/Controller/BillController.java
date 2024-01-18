package com.example.miniprojecterp.Controller;

import com.example.miniprojecterp.Bean.Bill;
import com.example.miniprojecterp.Bean.Student;
import com.example.miniprojecterp.Bean.Student_Payment;
import com.example.miniprojecterp.Services.BillService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("/bills")
public class BillController {
    @POST
    @Path("/add/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add_bill(@QueryParam("desc") String descrption, @QueryParam("amt") int amount,@QueryParam("date") String date,@QueryParam("dead") String deadline ,@QueryParam("id") int id){
        String result = "Added Bill";
        System.out.println(result);
        BillService service = new BillService();
        Student student = service.getStudentId(id);
        service.addNewSingleBill(descrption, amount, date, deadline, student);

        System.out.println(result);
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/add/domain/{desc}/{amt}/{date}/{dead}/{domain}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add_bill_to_domain(@PathParam("desc") String descrption, @PathParam("amt") int amount,@PathParam("date") String date,@PathParam("dead") String deadline ,@PathParam("domain") int domainId){
        String result = "Added Bills";
        System.out.println(result);
        BillService service = new BillService();
//        List<Student> students = service.getStudentList(domainId);
//
//        for(Student s: students){
//            service.addNewSingleBill(descrption, amount, date, deadline, s);
//        }
        service.addBillToDomain(descrption, amount, date, deadline, domainId);
        System.out.println(result);
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/updateamt/{id}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update_bill_amount(@PathParam("id") int billid, @PathParam("amount") int amt){
        BillService service = new BillService();
        service.updateBillAmount(billid, amt);
        String result = "Updated Bill Amount";
        return Response.ok().entity(result).build();
    }

    @POST
    @Path("/updatedeadline/{id}/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update2_bill(@PathParam("id") int billId, @PathParam("date") String deadline){
        BillService service = new BillService();
        service.updateBillDead(billId, deadline);
        String result = "Updated Bill Deadline";
        return Response.ok().entity(result).build();
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete_bill(@QueryParam("billid") int id){
        BillService service = new BillService();
        service.deleteBill(id);
        String result = "Bill Deleted";
        return Response.ok().entity(result).build();
    }

    @GET
    @Path("viewAllBills")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAll(){
        List<Bill> billsList  = new ArrayList<>();
        BillService service = new BillService();
        billsList = service.viewAllBills();
        //GenericEntity<List<Bill>> genericEntity = new GenericEntity<List<Bill>>(billsList){};
        return Response.ok().entity(billsList).build();
    }

    @GET
    @Path("viewPaid")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewPaid(){
        List<Bill> paymentList  = new ArrayList<>();
        BillService service = new BillService();
        paymentList = service.viewPaidBills();
        //GenericEntity<List<Bill>> genericEntity = new GenericEntity<List<Bill>>(billsList){};
        return Response.ok().entity(paymentList).build();
    }

    @GET
    @Path("viewUnpaid")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewunPaid(){
        List<Bill> unpaidBillsList  = new ArrayList<>();
        BillService service = new BillService();
        unpaidBillsList = service.viewUnpaidBills();
        //GenericEntity<List<Bill>> genericEntity = new GenericEntity<List<Bill>>(billsList){};
        return Response.ok().entity(unpaidBillsList).build();
    }
}
