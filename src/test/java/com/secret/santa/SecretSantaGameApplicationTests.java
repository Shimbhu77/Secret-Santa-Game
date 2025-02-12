package com.secret.santa;

import com.secret.santa.model.Employee;
import com.secret.santa.model.SantaAssignment;
import com.secret.santa.service.SecretSantaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SecretSantaGameApplicationTests {

    private final SecretSantaService secretSantaService = new SecretSantaService();

    @Test
    void testAssignSecretSantasWithMultipleEmployees() {
        List<Employee> employees = List.of(
                new Employee("Alice","alice@gmail.com"),
                new Employee("Bob","bob@gmail.com"),
                new Employee("Charlie","charlie@gmail.com"),
                new Employee("David","david@gmail.com")
        );

        List<SantaAssignment> assignments = secretSantaService.assignSecretSantas(employees, Collections.emptyMap());

        Assertions.assertNotNull(assignments);
        Assertions.assertEquals(employees.size(), assignments.size());

        assignments.forEach(assignment ->
                Assertions.assertNotEquals(assignment.getGiver().getEmployeeName(), assignment.getReceiver().getEmployeeName(),
                        "An employee cannot be their own Santa"));
    }

    @Test
    void testAssignSecretSantasOnlyOneEmployee_ShouldThrowException() {
        List<Employee> employees = List.of(new Employee("Alice","alice@gmail.com"));

        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class,
                () -> secretSantaService.assignSecretSantas(employees, Collections.emptyMap()));

        Assertions.assertEquals("Valid Santa assignment not possible, try again.", exception.getMessage());
    }

    @Test
    void testAssignSecretSantasNoEmployees_ShouldThrowException() {
        List<Employee> employees = Collections.emptyList();

        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class,
                () -> secretSantaService.assignSecretSantas(employees, Collections.emptyMap()));

        Assertions.assertEquals("Valid Santa assignment not possible, try again.", exception.getMessage());
    }
}
