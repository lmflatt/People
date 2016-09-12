import java.io.Serializable;

/**
 * Created by lee on 9/12/16.
 */
public class Person implements Comparable, Serializable {
    private String firstName;
    private String lastName;
    private String country;

    public Person() {
    }

    public Person(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        int i = lastName.compareTo(p.lastName);
        if (i == 0)
            i = firstName.compareTo(p.firstName);
        return i;
    }

    @Override
    public String toString() {
        String s = String.format("%s %s is from %s\n", firstName, lastName, country);
        return s;
    }
}
