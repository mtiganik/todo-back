package com.todoApp.todoback.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="todo_name")
    private String todoName;

    @Column(name = "is_done")
    private Boolean isDone;

    @Column(name = "last_modified")
    private Date lastModified;

    public Todo(){}

    public Todo(String todoName, Boolean isDone){
        super();
        this.todoName = todoName;
        this.isDone = isDone;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getTodoName(){
        return todoName;
    }

    public void setTodoName(String todoName){
        this.todoName = todoName;
    }

    public Date getLastModified(){return lastModified;}
    public void setLastModified(Date lastModified){this.lastModified = lastModified;}
    public Boolean getIsDone(){
        return isDone;
    }
    public void setIsDone(Boolean isDone){
        this.isDone = isDone;
    }


}
