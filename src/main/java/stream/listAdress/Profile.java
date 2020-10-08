package stream.listAdress;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    List<Address> collect(List<Profile> profiles){
        Comparator<Address> comparator = (x, y) -> x.getCity().compareTo(y.getCity());
        return profiles.stream()
                            .map(x -> x.address)
                            .sorted(comparator)
                             .distinct()
                             .collect(Collectors.toList());
    }
}
