public class Main {
    public static void main(String[] args) {
        // Create a new Human instance
        Human person = new Human("John Doe", 30);

        // Using the getter methods
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());

        // Using the setter methods
        person.setName("Jane Doe");
        person.setAge(28);

        // Invoking the custom method
        person.talk("Hello, world!");
    }
}
