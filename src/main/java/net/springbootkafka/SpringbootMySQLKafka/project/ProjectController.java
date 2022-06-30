package net.springbootkafka.SpringbootMySQLKafka.project;

import net.springbootkafka.SpringbootMySQLKafka.employee.Employee;
import net.springbootkafka.SpringbootMySQLKafka.employee.EmployeeRepository;
import net.springbootkafka.SpringbootMySQLKafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping
    List<Project> getProjects(){
        kafkaProducer.sendMessage("Data Fetched");
        return projectRepository.findAll();
    }

    @PostMapping
    Project createProject(@RequestBody Project project)
    {
        kafkaProducer.sendMessage("Data Added");
        return projectRepository.save(project);
    }
    @PutMapping("/{projectid}/employee/{employeeid}")
    Project addEmployeeToProject(@PathVariable Long projectid,@PathVariable Long employeeid )
    {
        Project project=projectRepository.findById(projectid).get();
        Employee employee=employeeRepository.findById(employeeid).get();
        project.employeeassigned.add(employee);
        kafkaProducer.sendMessage("Project "+ projectid +" Assigned to "+ employeeid + " employee");
        return projectRepository.save(project);
    }

}
