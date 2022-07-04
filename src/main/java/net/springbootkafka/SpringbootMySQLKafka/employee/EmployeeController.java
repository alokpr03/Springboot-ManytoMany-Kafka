package net.springbootkafka.SpringbootMySQLKafka.employee;

import net.springbootkafka.SpringbootMySQLKafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    KafkaProducer kafkaProducer;
    @GetMapping
    List<Employee> getEmployee()
    {
        kafkaProducer.sendMessage("Data Fetched");
        return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    Employee getEmployById(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    @PostMapping
    Employee createEmployee(@RequestBody Employee employee)
    {
        kafkaProducer.sendMessage("Data Added");
        return employeeRepository.save(employee);
    }
}
