package stream.listAdress;

import java.util.Objects;

public class Address  implements Comparable{
    private String city;
    private String street;
    private int home;
    private int apartment;

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return home == address.home &&
                apartment == address.apartment &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public int compareTo(Object o) {
        Address adress = (Address)o;
        return this.getCity().compareTo(adress.getCity());
    }
}