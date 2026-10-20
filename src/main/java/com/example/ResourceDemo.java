//
//package com.example;
//
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import java.util.List;
//
//@Path("Demos")
//public class ResourceDemo {
//   DemoRepository repo=new DemoRepository();
//  //fatching
//   @GET
//    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//    public List<Demo> getDemos() {
//         return  repo.getDemo();
//    }
//
//
//    @GET
//    @Path("Demo/{id}")
//
//    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//    public Demo getDemo(@PathParam("id") int id) {
//        return  repo.getDemo(id);
//    }
//
//    //creating
//    @POST
//    @Path("Demo")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Demo createDemo(Demo d1){
//        System.out.println(d1);
//        repo.create(d1);
//       return d1;
//    }
//}

package com.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("Demos")
public class ResourceDemo {

    DemoRepository repo = new DemoRepository();

    // Fetch all records
    @GET

    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Demo> getDemos() {
        return repo.getDemo();
    }

    // Fetch a record by ID
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Demo getDemo(@PathParam("id") int id) {
        return repo.getDemo(id);
    }

    // Create a record
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Demo createDemo(Demo d1) {
        repo.create(d1);
        return d1;
    }
}

