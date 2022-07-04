package net.springbootkafka.SpringbootMySQLKafka.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.springbootkafka.SpringbootMySQLKafka.employee.Employee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String name;
    @JsonIgnoreProperties("projects")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_assigned",joinColumns = @JoinColumn(name = "project_id"),inverseJoinColumns = @JoinColumn(name = "employee_id"))
    Set<Employee> employeeassigned=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public Set<Employee> getEmployeeassigned() {
        return employeeassigned;
    }
}
