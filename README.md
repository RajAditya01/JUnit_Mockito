# JUnit and Mockito Example Project

This project demonstrates how to use **JUnit** and **Mockito** for unit testing in a Java application. The combination of these tools allows developers to write effective and maintainable tests for Java code, ensuring the software is robust and reliable.

## Prerequisites

Before you begin, ensure you have the following installed on your system:

- Java Development Kit (JDK) 8 or higher
- Maven or Gradle for dependency management
- An IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code

## Project Setup

### Dependencies

Add the following dependencies to your `pom.xml` file if using Maven:

```xml
<dependencies>
    <!-- JUnit -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>5.5.0</version>
        <scope>test</scope>
    </dependency>

    <!-- Mockito JUnit Integration -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-junit-jupiter</artifactId>
        <version>5.5.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

If you are using Gradle, include the following in your `build.gradle` file:

```groovy
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
    testImplementation 'org.mockito:mockito-core:5.5.0'
    testImplementation 'org.mockito:mockito-junit-jupiter:5.5.0'
}
```

## Key Features

- **JUnit 5 (JUnit Jupiter):** Used for writing and running tests.
- **Mockito:** Used for mocking dependencies to isolate the code under test.
- **Mockito Annotations:** Simplifies mock initialization.

## Example Usage

### Sample Service

```java
public class CalculatorService {
    private final MathService mathService;

    public CalculatorService(MathService mathService) {
        this.mathService = mathService;
    }

    public int add(int a, int b) {
        return mathService.add(a, b);
    }
}
```

### Sample Dependency

```java
public class MathService {
    public int add(int a, int b) {
        return a + b;
    }
}
```

### Test Class

```java
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @Mock
    private MathService mathService;

    @InjectMocks
    private CalculatorService calculatorService;

    @Test
    void testAdd() {
        // Arrange
        when(mathService.add(2, 3)).thenReturn(5);

        // Act
        int result = calculatorService.add(2, 3);

        // Assert
        assertEquals(5, result);
        verify(mathService).add(2, 3);
    }
}
```

## Running the Tests

### Maven

Run the following command to execute the tests:

```bash
mvn test
```

### Gradle

Run the following command to execute the tests:

```bash
gradle test
```

## Tips for Effective Testing

1. **Write tests for all critical paths**: Ensure edge cases are covered.
2. **Mock external dependencies**: Isolate the unit of work by mocking external services.
3. **Use assertions**: Validate the output and behavior of the code.
4. **Leverage annotations**: Simplify test setup with Mockito annotations like `@Mock` and `@InjectMocks`.

## Resources

- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://site.mockito.org/)

