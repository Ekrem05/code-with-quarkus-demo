package org.acme.rest;

import jakarta.persistence.PostUpdate;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.entity.Task;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;

@Path("api")
public class Endpoints {

    @GET
    @Path("hello")
    public String hello(){
        return "Hello world!";
    }

    @GET
    @Path("task")
    public List<Task> getTasks(){
        return Task.listAll();
    }

    @POST
    @Path("task")
    public void addNewTask(Task task){
        Task.add(task);
    }

    @DELETE
    @Path("task")
    @Transactional
    public void deleteTask(@RestQuery int id){
        Task.deleteById(id);
    }

    @PUT
    @Path("task")
    public void update(Task task){
        Task.update(task);
    }
}
