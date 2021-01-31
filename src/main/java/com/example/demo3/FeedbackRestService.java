package com.example.demo3;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.example.model.FeedbackModel;

@Path("/feedbacks")
public class FeedbackRestService {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedbackRecords(FeedbackModel newFeedback) {
//        newFeedback.setFeedback();
        return Response.ok(newFeedback).build();
    }


    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postFeedbackRecords(FeedbackModel feeds) {
        String result = feeds.getFeedback();
        return Response.status(201).entity(result).build();
    }


}
