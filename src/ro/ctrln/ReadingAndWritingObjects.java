package ro.ctrln;

import ro.ctrln.model.Person;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ReadingAndWritingObjects {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("John", "Cena", 25, "Boxer"),
                new Person("Lady", "Gaga", 30, "Singer"));
        writeObjectToFile(persons);

        List<Person> binaryPersons = (List<Person>) readObjectFromFile();
        System.out.println(binaryPersons);
    }

    private static Object readObjectFromFile() {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.bin"))) {
            return objectInputStream.readObject();
        } catch (Exception ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    private static void writeObjectToFile(Object object) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.bin"))) {
            objectOutputStream.writeObject(object);
        } catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
