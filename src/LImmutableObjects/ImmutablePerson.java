package LImmutableObjects;

final public class ImmutablePerson {
    final private int age;
    final private String name;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge( ) {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String []args) {
        ImmutablePerson myPerson = new ImmutablePerson("Arslan", 25);
        System.out.println(myPerson);
    }

}