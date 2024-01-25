package LImmutableObjects;

public class Person {
    int age;
    String name;

    public Person(String name) {
        this.name = name;
    }
    public void setAge(int age ) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge( ) {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String []args) {
        Person myPerson = new Person("Arslan");
        myPerson.setAge(25);
        System.out.println(myPerson);
    }
}
