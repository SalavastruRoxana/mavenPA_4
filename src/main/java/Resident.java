import java.util.Arrays;
import java.util.Objects;

public class Resident {

    String name;
    Hospital[] preferences;
    Hospital acceptedAt;

    public Resident(String name, Hospital... preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public Resident(String name) {
        this.name = name;
    }

    public void hospitalsPreferences(Hospital ... hospitals) {
        this.preferences = hospitals;
    }

    public int hospitalsPreferencesLength()
    {
        if (this.preferences == null) return 0;
        return this.preferences.length;
    }

    @Override
    public String toString() {
        return "\nResident{" +
                "name = " + name +
                " }\n";
    }

    public void afiseazaInformatiile(){
        if(acceptedAt != null)
        System.out.println("Rezidentul " + this.name + " a fost acceptat la spitalul: " + acceptedAt.name +" prefera spitalele: ");
        else
            System.out.println("Rezidentul " + this.name + " prefera spitalele: ");
        for (Hospital h : preferences)
        {
            System.out.println(h.name);
        }
    }

    public Hospital[] getPreferences()
    {
        return this.preferences;
    }

}
