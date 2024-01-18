package com.example.miniprojecterp.Controller;

import com.example.miniprojecterp.Bean.User;
import com.example.miniprojecterp.Services.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;

@Path("details")
public class LoginController {
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(User user){
        String message;
        LoginService service = new LoginService();
        boolean result = service.login(user);
        System.out.println(result);
        if(result){
            message= "Success";
            return Response.ok().entity(message).build();
        }
        else{
            message= "Failure";
            return Response.status(401).build();
        }
    }

}
