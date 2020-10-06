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
  /*  public ArrayList<Person> find(final String key) {
        ArrayList<Person> result = new ArrayList<>();

        for (Person person : persons) {
            if (person.getAddress().contains(key)
                    || person.getName().contains(key)
                    || person.getPhone().contains(key)
                    || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }*/

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> person.getAddress().contains(key)
                                            || person.getName().contains(key)
                                            || person.getPhone().contains(key)
                                            || person.getSurname().contains(key);


        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }




}