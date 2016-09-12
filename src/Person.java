/**
 * Created by lee on 9/12/16.
 */
public class Person implements Comparable {
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
