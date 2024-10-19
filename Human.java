public class Human {
    // Data members
    private String name;
    private int age;
    
    // Basic constructor
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = (age > 0) ? age : 1; // Ensure the age is positive
    }
    
    // Custom method
    public void talk(String message) {
        System.out.println(name + " says: " + message);
    }
}
