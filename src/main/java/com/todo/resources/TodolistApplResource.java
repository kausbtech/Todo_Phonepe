package com.todo.resources;

import javax.transaction.Transactional;
import javax.ws.rs.*;

import com.codahale.metrics.annotation.Timed;
import com.todo.TodolistApplApplication;
import com.todo.todo;
import com.todo.todoDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Objects;
@Path("/todo")
public class TodolistApplResource {

    private todoDAO infoDao;

    public TodolistApplResource(todoDAO infoDao) {
        this.infoDao = infoDao;
    }

    @DELETE
    @Timed
    @UnitOfWork
    @Transactional
    @Path("/deleteTask/{taskid}")
    public String deleteEmp(@PathParam("taskid") String taskid) {
        System.out.println("Kaus");
        todo existingInfo = infoDao.findById(taskid);
        if (existingInfo != null) {
            infoDao.deleteByTaskid(taskid);
            return "Succesful";

        } else {
            return "Unsuccesful";
        }
    }

    @PUT
    @Timed
    @UnitOfWork
    @Transactional
    @Path("/updateTask/{taskid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateEmp(@PathParam("taskid") String taskid, todo info) {
        todo existingInfo = infoDao.findById(taskid);

        if (existingInfo != null) {
            if(info.getDescription() != null) {
                existingInfo.setDescription(info.getDescription());
                infoDao.update(existingInfo);
            }
            if(info.getStartdate() != null) {
                existingInfo.setStartdate(info.getStartdate());
                infoDao.update(existingInfo);
            }
            if(info.getEnddate() != null) {
                existingInfo.setEnddate(info.getEnddate());
                infoDao.update(existingInfo);
            }
            if(info.getStatus() != null) {
                existingInfo.setStatus(info.getStatus());
                infoDao.update(existingInfo);
            }

            return "Successfulr"; // 200 OK
        } else {
            return "Unsuccessful"; // 404 Not Found
        }
    }


    @GET
    @Timed
    @UnitOfWork
    @Path("/findAllTask")
    @Produces(MediaType.APPLICATION_JSON)
    public List<todo> findAllTask() {
        System.out.println("All Emp  : "+infoDao.findAll());
        return infoDao.findAll();
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/findTaskById/{taskid}")
    @Produces(MediaType.APPLICATION_JSON)
    public todo findEmpById(@PathParam("taskid") String taskid) {
        return infoDao.findById(taskid);

    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/saveTask")
    public String saveEmp(todo info) {
        return infoDao.create(info);
    }



}
