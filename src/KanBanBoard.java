import java.util.ArrayList;
import java.util.List;

public class KanBanBoard
{
    private List<Column> columns;

    public KanBanBoard()
    {
        this.columns = new ArrayList<>();
        this.columns.add(new Column("To Do"));
        this.columns.add(new Column("In Progress"));
        this.columns.add(new Column("Done"));
    }

    public List<Column> getColumns()
    {
        return this.columns;
    }

    public void setColumns(List<Column> columns)
    {
        this.columns = columns;
    }

    public void addColumn(Column column)
    {
        this.columns.add(column);
    }

    public List<Ticket> getEmployeeTickets(String name)
    {
        List<Ticket> employeeTickets = new ArrayList<>();

        for (Column column : this.columns)
        {
            for (Ticket ticket : column.getTickets())
            {
                Employee employee = ticket.getEmployee();

                if (employee != null && employee.getName().equals(name))
                {
                    employeeTickets.add(ticket);
                }
            }
        }

        return employeeTickets;
    }

    public double ticketsCompletedPercentage()
    {
        double doneTickets = 0;
        double totalTickets = 0;

        for (Column column : this.columns)
        {
            totalTickets += column.getTickets().size();

            if (column.getTitle().equals("Done"))
            {
                doneTickets += column.getTickets().size();
            }
        }

        double percentage = (doneTickets / totalTickets) * 100;
        return percentage;
    }
}
