package com.secret.santa.controller;

import com.secret.santa.model.SantaAssignment;
import com.secret.santa.service.CsvService;
import com.secret.santa.service.SecretSantaService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/secret-santa")
public class SecretSantaController {

    private final SecretSantaService secretSantaService;

    public SecretSantaController(SecretSantaService secretSantaService) {
        this.secretSantaService = secretSantaService;
    }

    @PostMapping("/assign")
    public String assignSecretSantaWithPreviousAssignment() {
        String employeeFile = "src/main/resources/employees.csv";
        String previousYearFile = "src/main/resources/previous_year_assignment.csv";
        String outputFile = "src/main/resources/output/result.csv";

        try {
            List<SantaAssignment> santaAssignments = secretSantaService.assignSecretSantas(employeeFile, previousYearFile);
            CsvService.writeAssignments(outputFile, santaAssignments);
            return "Secret Santa santaAssignments completed successfully! Check result.csv";
        } catch (IOException | IllegalStateException e) {
            return "Error: " + e.getMessage();
        }
    }

}
