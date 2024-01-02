package com.todo;

import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
public class todoDAO extends AbstractDAO<todo> {

    public todoDAO(SessionFactory factory) {
        super(factory);
    }
    public todo findById(String id) {
        return get(id);
    }

    public String create(todo info) {
        return persist(info).getTaskid();
    }
    public List<todo> findAll() {
        // return list(namedQuery("com.wordpress.nullpointerexception1.info.findAll"));
        return list((Query<todo>) namedQuery("info.findAll"));
    }
    public void deleteByTaskid(String taskid) {
        System.out.println(taskid);
        todo info = findById(taskid);
        if (info != null) {
            currentSession().delete(info);
        }
    }
    public void update(todo info) {
        currentSession().update(info);
    }
}
