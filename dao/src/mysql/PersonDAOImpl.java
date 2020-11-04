package mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends MySQL implements PersonDAO {

    @Override
    public Person getPersonById(int personId) {
        //connect to database from MySQL class using connect method
        Connect();
        //not instantiated since if no records returned don't use memory
        Person person = null;

        try {
            String storeProcedure = "{CALL USP_GetPerson(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storeProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                person = HydrateObject(rs);
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }

        return person;
    }

    @Override
    public List<Person> getPersonList() {
        //connect to database from MySQL class using connect method
        Connect();
        //not instantiated since if no records returned don't use memory
        List<Person> personList = new ArrayList<Person>();

        try {
            String storeProcedure = "{CALL USP_GetPerson(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storeProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                personList.add(HydrateObject(rs));
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }

        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        //Connect to database
        Connect();
        int id = 0; //thing to change on return

        try {
            //CALL USP_ExecPerson(QueryID, PersonID, Title , FirstName, LastName, DisplayFirstName, IsDeleted, Gender, CreateDate);
            String storeProcedure = "{CALL USP_ExecPerson(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(storeProcedure);

            statement.setInt(1, INSERT);
            statement.setInt(2, 0);
            statement.setString(3, person.getTitle());
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
            statement.setString(6, person.getDisplayFirstName());
            statement.setInt(7, 0);
            statement.setString(8, person.getGender());
            statement.setDate(9, DateHelper.utilDateToSqlDate(person.getCreateDate()));

            //Execute query and get last id created
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    @Override
    public boolean updatePerson(Person person) {
        //Connect to database
        Connect();
        int id = 0; //thing to change on return

        try {
            //CALL USP_ExecPerson(QueryID, PersonID, Title , FirstName, LastName, DisplayFirstName, IsDeleted, Gender, CreateDate);
            String storeProcedure = "{CALL USP_ExecPerson(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(storeProcedure);

            statement.setInt(1, UPDATE);
            statement.setInt(2, person.getPersonId());
            statement.setString(3, person.getTitle());
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
            statement.setString(6, person.getDisplayFirstName());
            statement.setInt(7, 0);
            statement.setString(8, person.getGender());
            statement.setDate(9, DateHelper.utilDateToSqlDate(person.getCreateDate()));

            //Execute query and get last id created
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id > 0;
    }

    @Override
    public boolean deletePerson(int personId) {
        return false;
    }

    private static Person HydrateObject(ResultSet rs) throws SQLException {
        //See what rs object is hydrating the person object with
//        System.out.println(rs.getInt(1));
//        System.out.println(rs.getString(2));
//        System.out.println(rs.getString(3));
//        System.out.println(rs.getString(4));
//        System.out.println(rs.getString(5));
//        System.out.println(rs.getByte(6));
//        System.out.println(rs.getString(7));
//        System.out.println(rs.getDate(8));
        //Create Person Object
        Person person = new Person();
        //Hydrating an object
        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setLastName(rs.getString(4));
        person.setDisplayFirstName(rs.getString(5));
        person.setIsDeleted(rs.getByte(6));
        person.setGender(rs.getString(7));
        person.setCreateDate(rs.getDate(8));

        return person;
    }
}
