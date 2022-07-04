package net.springbootkafka.SpringbootMySQLKafka.employee;

import com.fasterxml.jackson.annotation.*;
import net.springbootkafka.SpringbootMySQLKafka.project.Project;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @JsonIgnoreProperties("employeeassigned")
    @ManyToMany(mappedBy = "employeeassigned",cascade = {CascadeType.ALL})
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
