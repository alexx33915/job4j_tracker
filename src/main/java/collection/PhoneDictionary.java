package collection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    /**
     * add person in phoneDictionary
     *
     * @param person add person in phoneDictionary
     */
    public void add(final Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей,
     * который содержат
     * key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> addressHasKey = person -> person.getAddress().contains(key);
        Predicate<Person> nameHasKey = person -> person.getName().contains(key);
        Predicate<Person> phoneHasKey = person -> person.getPhone().contains(key);
        Predicate<Person> surnameHasKey = person -> person.getSurname().contains(key);
        Predicate<Person> combine = addressHasKey.or(nameHasKey).or(phoneHasKey).or(surnameHasKey);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}