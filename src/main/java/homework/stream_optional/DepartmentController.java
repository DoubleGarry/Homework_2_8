package homework.stream_optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/max-salary")
    public Employee findMaxSalaryInDepartment(@RequestParam("department") int department) {
        return departmentService.findMaxSalaryInDepartment(department);
    }

    @GetMapping(value = "/min-salary")
    public Employee findMinSalaryInDepartment(@RequestParam("department") int department) {
        return departmentService.findMinSalaryInDepartment(department);
    }

    @GetMapping(value = "/all", params = "department")
    public List<Employee> findAllEmployeesByDepartment(@RequestParam("department") int department) {
        return departmentService.findAllEmployeesByDepartment(department);
    }

    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> findEmployeesDepartment() {
        return departmentService.findEmployeesDepartment();
    }
}
