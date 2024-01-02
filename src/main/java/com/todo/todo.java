package com.todo;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@NamedQueries({
        @NamedQuery(name = "info.findAll",
                query = "select e from todo e")
})
public class todo {
    @Column(name = "description")
    private String description;

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "enddate")
    private String enddate;

    @Column(name = "status")
    private String status;

    @Id
    @Column(name = "taskid")
    private String taskid;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
}
