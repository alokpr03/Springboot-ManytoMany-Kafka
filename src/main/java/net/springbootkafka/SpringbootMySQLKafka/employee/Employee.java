package net.springbootkafka.SpringbootMySQLKafka.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import net.springbootkafka.SpringbootMySQLKafka.project.Project;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String fname;
    private String lname;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeassigned")
    private Set<Project> projects=new HashSet<>();

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public long getId() {
        return id;
    }
    public Set<Project> getProjects() {
        return projects;
    }
}
