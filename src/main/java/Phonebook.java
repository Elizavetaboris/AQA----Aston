import java.util.*;

public class Phonebook {
    private final Map<String, List<String>> phones= new HashMap<>();
    public void add(String surname, String number) {
        List<String> numbers = phones.getOrDefault(surname, new ArrayList<>());
       numbers.add(number);
        phones.put(surname, numbers);
    }
    public List<String> get(String surname) {
        return phones.getOrDefault(surname, new ArrayList<>());
    }
}
