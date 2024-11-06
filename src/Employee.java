import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee
{
    private List<Ticket> linkedTickets;
    private String name;
    private LocalDate companyJoinDate;

    public Employee(String name, LocalDate companyJoinDate)
    {
        this.linkedTickets = new ArrayList<>();
        this.name = name;
        this.companyJoinDate = companyJoinDate;
    }

    public List<Ticket> getLinkedTickets()
    {
        return this.linkedTickets;
    }

    public void setLinkedTickets(List<Ticket> linkedTickets)
    {
        this.linkedTickets = linkedTickets;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getCompanyJoinDate()
    {
        return this.companyJoinDate;
    }

    public void setCompanyJoinDate(LocalDate companyJoinDate)
    {
        this.companyJoinDate = companyJoinDate;
    }
}
