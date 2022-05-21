package lesson9;

import lesson3.Person;

import java.sql.*;
import java.util.Properties;

public class Main {

    static void sqlExample() {
        String url = "jdbc:sqlite:./src/main/resources/test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS persons;");
            // Создание таблицы
            statement.executeUpdate("CREATE TABLE persons(name TEXT, age INTEGER);");

            // Добавление данных
            statement.executeUpdate("INSERT INTO persons(name, age) VALUES ('Andrew', 23);");
            statement.executeUpdate("INSERT INTO persons(name, age) VALUES ('Vasiliy', 25);");
            statement.executeUpdate("INSERT INTO persons(name, age) VALUES ('Andrew', 20);");

            // Запрос данных
            ResultSet rs = statement.executeQuery("SELECT name, age, ROWID FROM persons;");
            while (rs.next()) {
                int rowid = rs.getInt("ROWID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("Person #%d with name %s and age %d\n", rowid, name, age);
            }

            // Изменение строк
            System.out.println("После изменение строки");
            statement.executeUpdate("UPDATE persons SET age=24 WHERE rowid=1;");
            rs = statement.executeQuery("SELECT name, age, ROWID FROM persons;");
            while (rs.next()) {
                int rowid = rs.getInt("ROWID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("Person #%d with name %s and age %d\n", rowid, name, age);
            }

            // Удаление строк
            System.out.println("После удаления строк");
            statement.executeUpdate("DELETE FROM persons where name='Andrew';");
            rs = statement.executeQuery("SELECT name, age, ROWID FROM persons;");
            while (rs.next()) {
                int rowid = rs.getInt("ROWID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("Person #%d with name %s and age %d\n", rowid, name, age);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static void tableReferencesExample() {
        String url = "jdbc:sqlite:./src/main/resources/store.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS checks;");
            statement.executeUpdate("DROP TABLE IF EXISTS products;");

            statement.executeUpdate("CREATE TABLE checks(" +
                    "check_id INTEGER PRIMARY KEY, " +
                    "store TEXT, " +
                    "date TEXT) WITHOUT ROWID;");
            statement.executeUpdate("CREATE TABLE products(" +
                    "product_id INT PRIMARY KEY, " +
                    "name TEXT, " +
                    "price REAL, " +
                    "check_id INT, " +
                    "FOREIGN KEY(check_id) REFERENCES checks(check_id)) WITHOUT ROWID;");

            statement.executeUpdate("INSERT INTO checks(check_id, store, date) VALUES (1, 'Pyaterochka', datetime());");
            statement.executeUpdate("INSERT INTO checks(check_id, store, date) VALUES (2, 'Magnit', datetime());");

            statement.executeUpdate("INSERT INTO products(product_id, name, price, check_id) values (1, 'Cola', 90.1, 1);");
            statement.executeUpdate("INSERT INTO products(product_id, name, price, check_id) values (2, 'Pepsi', 90.1, 1);");
            statement.executeUpdate("INSERT INTO products(product_id, name, price, check_id) values (3, 'Bread', 30.2, 2);");

            ResultSet rs = statement.executeQuery("SELECT p.name name, p.price price, c.store store, c.date date " +
                    "FROM products p JOIN checks c on p.check_id=c.check_id;");
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String store = rs.getString("store");
                Date date = rs.getDate("date");
                Time time = rs.getTime("date");
                System.out.printf("Product %s %f bought from %s on %s|%s\n", name, price, store, date.toString(), time.toString());
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static void preparedStatements() {
        String url = "jdbc:sqlite:./src/main/resources/test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS persons;");
            // Создание таблицы
            statement.executeUpdate("CREATE TABLE persons(name TEXT, age INTEGER);");

            // Добавление данных
            PreparedStatement addPerson = conn.prepareStatement("INSERT INTO persons(name, age) VALUES (?, ?);");
            addPerson.setString(1, "Andrew");
            addPerson.setInt(2, 23);
            addPerson.executeUpdate();
            addPerson.setString(1, "Vasiliy");
            addPerson.setInt(2, 25);
            addPerson.executeUpdate();
            addPerson.setString(1, "Andrew");
            addPerson.setInt(2, 20);
            addPerson.executeUpdate();

            Person p = new Person("Yulia", 20);
            addPerson.setString(1, p.name);
            addPerson.setInt(2, p.age);
            addPerson.executeUpdate();

            ResultSet rs = statement.executeQuery("SELECT name, age, ROWID FROM persons;");
            while (rs.next()) {
                int rowid = rs.getInt("ROWID");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("Person #%d with name %s and age %d\n", rowid, name, age);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static void personTableExample() {
        try {
            PersonTable pt = new PersonTable();
            Person person1 = new Person("Andrew", 23);
            Person person2 = new Person("Vasiliy", 25);
            System.out.println(person1);
            System.out.println(person2);
            pt.addPerson(person1);
            System.out.println(pt.getAllPersons());

            pt.addPerson(person2);
            System.out.println(pt.getAllPersons());

            pt.incAgeById(2);
            System.out.println(pt.getPersonById(2));

            pt.deletePerson(2);
            System.out.println(pt.getPersonById(2));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void postgreSqlExample() {
        String url = "jdbc:postgresql://localhost:5432/java2503";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "12345678");
        try (Connection conn = DriverManager.getConnection(url, props)) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM persons;");
            while (rs.next()) {
                System.out.printf("#%d: %s %d\n", rs.getInt("person_id"), rs.getString("name"), rs.getInt("age"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
//        sqlExample();
//        tableReferencesExample();
//        preparedStatements();
//        personTableExample();
        postgreSqlExample();
    }
}
