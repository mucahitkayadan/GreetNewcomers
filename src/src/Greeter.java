import java.util.ArrayList;
import java.util.List;

public class Greeter {
    private String name;
    private List<Newcomer> assignedNewcomers;

    public Greeter(String name) {
        this.name = name;
        this.assignedNewcomers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Newcomer> getAssignedNewcomers() {
        return assignedNewcomers;
    }

    public void addNewcomer(Newcomer newcomer) {
        assignedNewcomers.add(newcomer);
    }

    @Override
    public String toString() {
        return "Greeter{" +
                "name='" + name + '\'' +
                ", assignedNewcomers=" + assignedNewcomers +
                '}';
    }
    // Add other methods as needed
}
