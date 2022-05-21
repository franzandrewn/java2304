package lesson9;

import lesson3.Person;

import java.sql.*;
import java.util.LinkedList;

public class PersonTable {
    private static final String url = "jdbc:sqlite:./src/main/resources/person.db";
    private static final Connection connection = ConnectionSingleton.getInstance(url).getConnection();
    private final PreparedStatement addPerson;
    private final PreparedStatement deletePerson;
    private final PreparedStatement changePerson;
    private final PreparedStatement getAllPersons;
    private final PreparedStatement getPersonById;
    private static final String sqlToAddPerson = "INSERT INTO PERSONS(id, name, age) VALUES (?,?,?);";
    private static final String sqlToDeletePerson = "DELETE FROM persons WHERE id=?;";
    private static final String sqlToChangePerson = "UPDATE persons SET name=?, age=? WHERE id=?;";
    private static final String sqlToGetAllPersons = "SELECT * FROM persons;";
    private static final String sqlToGetPersonById = "SELECT * FROM persons WHERE id=?;";

    public PersonTable() throws SQLException {
        Statement stat = connection.createStatement();
        stat.executeUpdate("CREATE TABLE persons(id INT PRIMARY KEY, name TEXT NOT NULL, age INT);");
        addPerson = connection.prepareStatement(sqlToAddPerson);
        changePerson = connection.prepareStatement(sqlToChangePerson);
        deletePerson = connection.prepareStatement(sqlToDeletePerson);
        getAllPersons = connection.prepareStatement(sqlToGetAllPersons);
        getPersonById = connection.prepareStatement(sqlToGetPersonById);
    }

    // CRUD - Create, Read, Update, Delete
    // Create
    public void addPerson(Person p) throws SQLException {
        addPerson.setInt(1, p.id);
        addPerson.setString(2, p.name);
        addPerson.setInt(3, p.age);
        addPerson.executeUpdate();
    }

    // Read
    public LinkedList<Person> getAllPersons() throws SQLException {
        LinkedList<Person> result = new LinkedList<>();
        ResultSet rs = getAllPersons.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            int id = rs.getInt("id");
            Person temp = new Person(name, age, id);
            result.add(temp);
        }
        return result;
    }

    public Person getPersonById(int id) throws SQLException {
        getPersonById.setInt(1, id);
        ResultSet rs = getPersonById.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            int pId = rs.getInt("id");
            return new Person(name, age, pId);
        } else {
            return null;
        }
    }

    // Update
    public void changePerson(int id, String name, int age) throws SQLException {
        changePerson.setString(1, name);
        changePerson.setInt(2, age);
        changePerson.setInt(3, id);
        changePerson.executeUpdate();
    }

    // Delete
    public void deletePerson(int id) throws SQLException {
        deletePerson.setInt(1, id);
        deletePerson.executeUpdate();
    }

    public void incAgeById(int id) throws SQLException {
        Person temp = getPersonById(2);
        changePerson(2, temp.name, temp.age + 1);
    }
}
