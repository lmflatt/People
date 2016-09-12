import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Reads a csv file and maps country name to a list of people who are from that country. 
 * Then, for each list sorts by last name.
 */
public class People {
    public static Map<String, List<Person>> peopleMap = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<Person> peopleList = new ArrayList<>();
        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);
        String line = fileScanner.nextLine();

        while (fileScanner.hasNext()) {
            populateMapFromFile(fileScanner.nextLine());
        }

        orderPeopleByName();

        printAndWriteToJson();

    }

    public static void printAndWriteToJson() throws IOException{
        List<Person> peopleList = new ArrayList<>();
        File newFile = new File("people.json");
        JsonSerializer s = new JsonSerializer();
        String json = "";
        FileWriter fw = new FileWriter(newFile);
        List<List<Person>> peopleMaster = new ArrayList<>();

        for (Map.Entry<String, List<Person>> entry : peopleMap.entrySet()) {
            peopleList = entry.getValue();
            peopleMaster.add(peopleList);
            for (Person person : peopleList) {
                System.out.printf(person.toString());
            }
        }
        json = s.serialize(peopleMaster);
        fw.write(json);
        fw.close();
    }

    public static void orderPeopleByName() {
        for (Map.Entry<String, List<Person>> entry : peopleMap.entrySet()) {
            List<Person> peopleList = entry.getValue();
            Collections.sort(peopleList);
        }
    }

    public static void populateMapFromFile(String line) {
        List<Person> peopleList = new ArrayList<>();
        String[] column = line.split(",");
        Person person = new Person(column[1], column[2], column[4]);

        if (peopleMap.containsKey(person.getCountry())) {
            peopleList = peopleMap.get(person.getCountry());
            peopleList.add(person);
        }
        else {
            peopleList.add(person);
            peopleMap.put(person.getCountry(), peopleList);
        }
    }
}