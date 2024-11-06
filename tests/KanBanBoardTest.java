import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class KanBanBoardTest
{
    private KanBanBoard kanBanBoard;

    private Column todo;
    private Column progress;
    private Column done;

    private Ticket ticket1;
    private Ticket ticket2;
    private Ticket ticket3;
    private Ticket ticket4;
    private Ticket ticket5;
    private Ticket ticket6;

    @BeforeEach
    void setup()
    {
        kanBanBoard = new KanBanBoard();

        ticket1 = new Ticket("yes", 1, 1, 3);
        ticket2 = new Ticket("yes", 1, 1, 3);
        ticket3 = new Ticket("yes", 1, 1, 3);
        ticket4 = new Ticket("yes", 1, 1, 3);
        ticket5 = new Ticket("yes", 1, 1, 3);
        ticket6 = new Ticket("yes", 1, 1, 3);

        todo = kanBanBoard.getColumns().getFirst();
        progress = kanBanBoard.getColumns().get(1);
        done = kanBanBoard.getColumns().get(2);
    }

    @Test
    void ticketsCompletedPercentage_shouldReturn50()
    {
        // Arrange
        done.addTickets(ticket1);
        done.addTickets(ticket2);
        done.addTickets(ticket3);
        progress.addTickets(ticket4);
        progress.addTickets(ticket5);
        progress.addTickets(ticket6);

        //Act
        double percentage = kanBanBoard.ticketsCompletedPercentage();

        // Assert
        assertEquals(50, percentage);
    }

    @Test
    void ticketsCompletedPercentage_shouldReturn100()
    {
        // Arrange
        done.addTickets(ticket1);
        done.addTickets(ticket2);
        done.addTickets(ticket3);
        done.addTickets(ticket4);
        done.addTickets(ticket5);
        done.addTickets(ticket6);

        //Act
        double percentage = kanBanBoard.ticketsCompletedPercentage();

        // Assert
        assertEquals(100, percentage);
    }

    @Test
    void ticketsCompletedPercentage_shouldReturn0()
    {
        // Arrange
        todo.addTickets(ticket1);
        todo.addTickets(ticket2);
        todo.addTickets(ticket3);
        progress.addTickets(ticket4);
        progress.addTickets(ticket5);
        progress.addTickets(ticket6);

        //Act
        double percentage = kanBanBoard.ticketsCompletedPercentage();

        // Assert
        assertEquals(0, percentage);
    }

    @Test
    void getEmployeeTickets_ifEmployee1TicketsIs4_shouldReturn4()
    {
        // Arrange
        Employee employee1 = new Employee("Diego", LocalDate.of(2018, 1, 1));

        done.addTickets(ticket1);
        done.addTickets(ticket2);
        done.addTickets(ticket3);
        progress.addTickets(ticket4);
        progress.addTickets(ticket5);
        progress.addTickets(ticket6);

        ticket1.setEmployee(employee1);
        ticket2.setEmployee(employee1);
        ticket3.setEmployee(employee1);
        ticket4.setEmployee(employee1);

        // Act
        int size = kanBanBoard.getEmployeeTickets("Diego").size();

        // Assert
        assertEquals(4, size);
    }

    @Test
    void getEmployeeTickets_ifEmployee1TicketsIs2_shouldReturn2()
    {
        // Arrange
        Employee employee1 = new Employee("Diego", LocalDate.of(2018, 1, 1));

        done.addTickets(ticket1);
        done.addTickets(ticket2);
        done.addTickets(ticket3);
        progress.addTickets(ticket4);
        progress.addTickets(ticket5);
        progress.addTickets(ticket6);

        ticket1.setEmployee(employee1);
        ticket2.setEmployee(employee1);

        // Act
        int size = kanBanBoard.getEmployeeTickets("Diego").size();

        // Assert
        assertEquals(2, size);
    }
}
