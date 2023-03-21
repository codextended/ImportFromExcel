package dev.codextended.Importfromexcel.service;

import dev.codextended.Importfromexcel.domain.Employee;
import dev.codextended.Importfromexcel.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void saveEmployeesToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Employee> employees = ExcelUploadService.getEmployeesDataFromExcel(file.getInputStream());
                employeeRepository.saveAll(employees);
            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }
}
