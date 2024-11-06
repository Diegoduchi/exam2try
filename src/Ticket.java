import java.time.LocalDate;
import java.time.Period;

public class Ticket
{
    private String description;
    private int requiredExperience;
    private int priority;
    private int hoursToResolve;
    private Employee employee;

    public Ticket(String description, int requiredExperience, int priority, int hoursToResolve)
    {
        this.description = description;
        this.requiredExperience = requiredExperience;
        this.priority = priority;
        this.hoursToResolve = hoursToResolve;
        this.employee = null;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getRequiredExperience()
    {
        return this.requiredExperience;
    }

    public void setRequiredExperience(int requiredExperience)
    {
        this.requiredExperience = requiredExperience;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priority)
    {
        if (priority >= 1 && priority <= 5)
        {
            this.priority = priority;
        } else
        {
            throw new IllegalArgumentException("Priority must be between 1 and 5");
        }
    }

    public int getHoursToResolve()
    {
        return this.hoursToResolve;
    }

    public void setHoursToResolve(int hoursToResolve)
    {
        this.hoursToResolve = hoursToResolve;
    }

    public Employee getEmployee()
    {
        return this.employee;
    }

    public void setEmployee(Employee employee)
    {
        int yearsOfEmployment = Period.between(employee.getCompanyJoinDate(), LocalDate.now()).getYears();

        if (yearsOfEmployment >= this.requiredExperience)
        {
            this.employee = employee;
            employee.getLinkedTickets().add(this);
        } else
        {
            throw new IllegalArgumentException("Employee Experience not enough");
        }
    }
}
