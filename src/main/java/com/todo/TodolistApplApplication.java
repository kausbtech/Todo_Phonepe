package com.todo;

import com.todo.resources.TodolistApplResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class TodolistApplApplication extends Application<TodolistApplConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TodolistApplApplication().run(args);
    }

    @Override
    public String getName() {
        return "TodolistAppl";
    }


    @Override
    public void run(final TodolistApplConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        System.out.println("Value from dev.yml is "+configuration.getDataSourceFactory().getUser());
        todoDAO infoDao = new todoDAO(hibernate.getSessionFactory());
        final TodolistApplResource resource = new TodolistApplResource(infoDao);
        environment.jersey().register(resource);
    }
    private HibernateBundle<TodolistApplConfiguration> hibernate = new HibernateBundle<TodolistApplConfiguration>(todo.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(TodolistApplConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };



    @Override
    public void initialize(Bootstrap<TodolistApplConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

}
