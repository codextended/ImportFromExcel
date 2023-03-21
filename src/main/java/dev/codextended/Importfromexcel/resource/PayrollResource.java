package dev.codextended.Importfromexcel.resource;

import dev.codextended.Importfromexcel.domain.Employee;
import dev.codextended.Importfromexcel.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/payroll")
@RequiredArgsConstructor
public class PayrollResource {

    private final PayrollService payrollService;

    @GetMapping(value = "")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(payrollService.getEmployees());
    }

    @PostMapping("/upload-employees")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file")MultipartFile file) {
        payrollService.saveEmployeesToDatabase(file);
        return ResponseEntity.ok(Map.of("Message", "Employees uploaded and saved to database"));
    }
}
