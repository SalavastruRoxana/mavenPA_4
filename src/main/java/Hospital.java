import java.util.Arrays;

public class Hospital implements Comparable {

    int capacity;
    String name;
    Resident[] accepedResidents;
    Resident[] preferences;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hospital(String name) {
        this.name = name;
    }

    public void setPreferences(Resident... preferences) {
        this.preferences = preferences;
    }

    public void addAcceptedResidents(Resident accepedResident) {
        this.accepedResidents[this.accepedResidents.length] = accepedResident;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object temp) {
        Hospital other = (Hospital) temp;
        if (other.preferences != null && this.preferences != null)
            if (other.preferences.length > this.preferences.length)
                return -1;
            else if (other.preferences.length < this.preferences.length)
                return 1;
        return 0;
    }
}
