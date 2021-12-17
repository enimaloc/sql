# Objective

Objective of this project is to provide a simple ORM for multiple database

## Planned
### Get a database

```java
public class Main {
    private final static Database DATABASE;

    public static void main(String... args) {
        DATABASE = Database.getSQLite("filename");
        DATABASE = Database.getMySQL("address", "username", "password");
    }
}
```

### Serialize class from table

```java
import java.util.List;

public class Main {
    private final static Database DATABASE;

    public static void main(String... args) {
        List<Person> persons;

        persons = DATABASE.get(PersonWithoutConstructor.class)
                          .accept()
                          .findAll();
        persons = DATABASE.get(PersonWithConstructor.class)
                          .accept()
                          .findAll();
    }

    static class Person {}

    @Table(name = "person")
    static class PersonWithoutConstructor extends Person {
        @Column(name = "name")
        private String name;
        @Column(name = "nickname")
        private String nickname;
        @Column(name = "age")
        private int    age;
        @Column(name = "weight")
        private double weight;
    }

    @Table(name = "person")
    static class PersonWithConstructor extends Person {
        @Column(name = "name")
        private final String name;
        @Column(name = "nickname")
        private final String nickname;
        @Column(name = "age")
        private final int    age;
        @Column(name = "weight")
        private final double weight;

        @TableConstructor
        public PersonWithConstructor(
                @Linked(fieldName = "name") String name,
                @Linked(fieldName = "nickname") String nickname,
                @Linked(fieldName = "age") int age,
                @Linked(fieldName = "weight") double weight
        ) {
            this.name     = name;
            this.nickname = nickname;
            this.age      = age;
            this.weigth   = weigth;
        }
    }
} 
```

### Get one item

```java
import java.util.Optional;

public class Main {
    private final static Database DATABASE;

    public static void main(String... args) {
        Optional<Person> person = DATABASE.get(Person.class)
                                          .where(where -> where.eq("nickname", "enimaloc")
                                                               .above("age", 18)
                                                               .below("weight", 70))
                                          .accept()
                                          .findFirst();
        Optional<Person> person = DATABASE.get(Person.class)
                                          .where("nickname LIKE 'enimaloc' AND age > 18 AND weight < 70")
                                          .accept()
                                          .findFirst();
    }

    @Table(name = "person")
    static class Person {
        @Column(name = "name")
        private String name;
        @Column(name = "nickname")
        private String nickname;
        @Column(name = "age")
        private int    age;
        @Column(name = "weight")
        private double weight;
    }
} 
```

### Deserialize class list in table

```java
import java.util.List;

public class Main {
    private final static Database DATABASE;

    public static void main(String... args) {
        List<Person> persons = List.of(
                new Person("Antoine", "enimaloc", 18, 55),
                new Person("Kévin", "kévinoulabanane", 18, 65)
        );
        DATABASE.get(Person.class).putList(persons)
                .onDuplicate(DuplicateStrategy.REPLACE)
                .accept();
        DATABASE.putList(persons)
                .onDuplicate(DuplicateStrategy.KEEP)
                .accept();
    }

    @Table(name = "person")
    static class Person {
        @Column(name = "name")
        private String name;
        @Column(name = "nickname")
        private String nickname;
        @Column(name = "age")
        private int    age;
        @Column(name = "weight")
        private double weight;

        public Person(String name, String nickname, int age, double weight) {
            this.name    = name;
            this.surname = nickname;
            this.age     = age;
            this.weight  = weight;
        }
    }
} 
```

### Deserialize class in table

```java
public class Main {
    private final static Database DATABASE;

    public static void main(String... args) {
        DATABASE.get(Person.class)
                .put(new Person("Antoine", "enimaloc", 18, 55))
                .onDuplicate(DuplicateStrategy.REPLACE)
                .accept();
        DATABASE.put(new Person("Kevin", "kevinoulabanane", 18, 65))
                .onDuplicate(DuplicateStrategy.KEEP)
                .accept();
    }

    @Table(name = "person")
    static class Person {
        @Column(name = "name")
        private String name;
        @Column(name = "nickname")
        private String nickname;
        @Column(name = "age")
        private int    age;
        @Column(name = "weight")
        private double weight;

        public Person(String name, String nickname, int age, double weight) {
            this.name     = name;
            this.nickname = nickname;
            this.age      = age;
            this.weight   = weight;
        }
    }
} 
```