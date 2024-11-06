import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TicketTest
{
    private Ticket ticket1;
    private Ticket ticket2;

    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    void setup()
    {
        ticket1 = new Ticket("yes", 5, 1, 4);
        ticket2 = new Ticket("yes", 2, 1, 4);

        employee1 = new Employee("Diego", LocalDate.of(2020, 1, 1));
        employee2 = new Employee("Luca", LocalDate.of(2018, 1, 1));
    }

    @Test
    void setEmployee_ifEmployeeExperienceIs4AndRequiredExperienceIs5_shouldReturnIllegalArgument()
    {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> {ticket1.setEmployee(employee1);});
        assertEquals(0, employee1.getLinkedTickets().size());
    }

    @Test
    void setEmployee_ifEmployeeExperienceIs6AndRequiredExperienceIs2_EmployeeTicketsShouldBeOne()
    {
        // Assert
        ticket2.setEmployee(employee2);
        assertEquals(employee2, ticket2.getEmployee());
        assertEquals(1, employee2.getLinkedTickets().size());
    }
}
