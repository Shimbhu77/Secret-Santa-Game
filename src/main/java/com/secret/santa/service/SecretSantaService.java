package com.secret.santa.service;

import com.secret.santa.model.SantaAssignment;
import com.secret.santa.model.Employee;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;

@Service
public class SecretSantaService {

    public List<SantaAssignment> assignSecretSantas(String employeeFile, String previousYearFile) throws IOException {
        List<Employee> employees = CsvService.readEmployees(employeeFile);
        Map<String, String> previousAssignments = CsvService.readPreviousAssignments(previousYearFile);

        return assignSecretSantas(employees, previousAssignments);
    }

    public List<SantaAssignment> assignSecretSantas(List<Employee> employees, Map<String, String> previousAssignments) {
        // ✅ Ensure we handle cases where there are no employees
        if (employees.isEmpty()) {
            throw new IllegalStateException("Valid Santa assignment not possible, try again.");
        }

        List<Employee> availableReceivers = new ArrayList<>(employees);
        Collections.shuffle(availableReceivers);

        List<SantaAssignment> assignments = new ArrayList<>();

        for (Employee giver : employees) {
            Employee receiver = findValidReceiver(giver, availableReceivers, previousAssignments);

            if (receiver == null) {
                throw new IllegalStateException("Valid Santa assignment not possible, try again.");
            }

            assignments.add(new SantaAssignment(giver, receiver));
            availableReceivers.remove(receiver);
        }

        return assignments;
    }

    private Employee findValidReceiver(Employee giver, List<Employee> availableReceivers, Map<String, String> previousAssignments) {
        for (Employee receiver : availableReceivers) {
            if (!giver.getEmployeeEmailId().equals(receiver.getEmployeeEmailId()) &&
                    !previousAssignments.getOrDefault(giver.getEmployeeEmailId(), "").equals(receiver.getEmployeeEmailId())) {
                return receiver;
            }
        }
        return null;
    }
}

