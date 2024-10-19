public class Human {
    // Data members
    private String name;
    private int age;
    private String[] loc;
    
    // Basic constructor
    public Human(String name, int age, String[] loc) {
        this.name = name;
        this.age = age;
        this.loc = loc;
    }
    
    public Human(String string, int i, String string2, String string3) {
        //TODO Auto-generated constructor stub
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getLoc() {
        return loc;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = (age > 0) ? age : 1; // Ensure the age is positive
    }

    public void setLoc(String[] loc) {
        this.loc = loc;
    }
    
    // Custom method
    public void talk(String message) {
        System.out.println(name + " says: " + message);
    }

    public void location() {
        System.out.println("LOCATION OF " + getName() + "...");
        System.out.println("Long: (" + loc[0] + ")");
        System.out.println("Lat: (" + loc[1] + ")");
    }
}
