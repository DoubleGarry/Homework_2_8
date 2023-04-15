package homework.stream_optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
        System.out.println("Привет");
    }

    @GetMapping(value = "/")
    public Collection<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/add")
    public Employee addEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @GetMapping(value = "/remove")
    public Employee removeEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping(value = "/find")
    public Employee findEmployee(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return service.findEmployee(firstName, lastName);
    }
}
