package homework.stream_optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
        System.out.println("Привет");
    }

    @GetMapping(value = "/")
    public List<Employee> findAll() {
        return EmployeeService.findAll();
    }

    @GetMapping(value = "/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("department") int department,
            @RequestParam("salary") int salary) {
        return service.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(value = "/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("department") int department,
            @RequestParam("salary") int salary) {
        return service.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(value = "/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("department") int department,
            @RequestParam("salary") int salary) {
        return service.findEmployee(firstName, lastName, department, salary);
    }
}
