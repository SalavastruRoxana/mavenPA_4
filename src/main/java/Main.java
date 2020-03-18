import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static public void main(String[] args) {
        Resident r0 = new Resident("R0");
        Resident r1 = new Resident("R1");
        Resident r2 = new Resident("R2");
        Resident r3 = new Resident("R3");

        Hospital h0 = new Hospital("H0");
        h0.setCapacity(1);
        Hospital h1 = new Hospital("H1");
        h1.setCapacity(2);
        Hospital h2 = new Hospital("H2");
        h2.setCapacity(2);

        r0.hospitalsPreferences(h0, h1, h2);
        r1.hospitalsPreferences(h0, h1, h2);
        r2.hospitalsPreferences(h0, h1);
        r3.hospitalsPreferences(h0, h2);

        h0.setPreferences(r3, r0, r1, r2);
        h1.setPreferences(r0, r2, r1);
        h2.setPreferences(r0, r1, r3);

        //Create a list of residents, using an ArrayList implementation. Sort the residents, using a comparator.

        Resident[] residents = new Resident[4];
        residents[0] = r0;
        residents[1] = r1;
        residents[2] = r2;
        residents[3] = r3;

        Comparator<Resident> residentComparator = Comparator.comparing(Resident::hospitalsPreferencesLength);
        Arrays.sort(residents, residentComparator);
        for (Resident i : residents)
            i.afiseazaInformatiile();

        //Create a set of hospitals, using a TreeSet implementation. Make sure that Hospital objects are comparable.

        System.out.println("TreeSetSpitale: ");
        TreeSet<Hospital> hos = new TreeSet<Hospital>();

        hos.add(h2);
        hos.add(h2);
        hos.add(h1);
        hos.add(h2);
        hos.add(h0);
        hos.add(h2);//duplicatele sunt ignorate, Hospital implements Comparable

        System.out.println(hos);

        //Create two maps (having different implementations) describing the residents and the hospital preferences and print them on the screen.

        System.out.println("Hash map 1 : ");
        Map<Resident, Hospital[]> map1 = new HashMap<>();
        map1.put(r0, r0.getPreferences());
        map1.put(r1, r1.getPreferences());
        map1.put(r2, r2.getPreferences());
        map1.put(r3, r3.getPreferences());
        System.out.println(map1);

        Hashtable<Resident, Hospital[]> map2 = new Hashtable<Resident, Hospital[]>();

        System.out.println("Map 2: ");
        map2.put(r0, r0.getPreferences());
        map2.put(r1, r1.getPreferences());
        map2.put(r2, r2.getPreferences());
        map2.put(r3, r3.getPreferences());
        System.out.println(map2);
        //Using Java Stream API, write queries that display the residents who find acceptable H0 and H2, and the hospitals that have R0 as their top preference.
        for (Resident r : residents) {
            boolean ok1 = false, ok2 = false;
            for (Hospital h : r.preferences) {
                if (h.equals(h0))
                    ok1 = true;
                if (h.equals(h1))
                    ok2 = true;
            }
            if (ok1 == true && ok2 == true)
                System.out.println("Rezidentul " + r + " accepta spitalele h0 si h1");
        }
        Hospital[] hospitals = new Hospital[3];
        hospitals[0] = h0;
        hospitals[1] = h1;
        hospitals[2] = h2;
        for (Hospital h : hospitals) {
            if (h.preferences[0] == r0)
                System.out.println("Spitalul " + h + " il are pe r0 in topul listei");

        }
    }
}