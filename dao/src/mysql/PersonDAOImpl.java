package mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

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

            cStmt.setInt(1, 10);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                //Hydrating an object
                person = new Person();
                person.setPersonId(rs.getInt(1));
                person.setFirstName(rs.getString(2));
                person.setLastName(rs.getString(3));
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

            cStmt.setInt(1, 20);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //Hydrating an object
                Person person = new Person();
                person.setPersonId(rs.getInt(1));
                person.setFirstName(rs.getString(2));
                person.setLastName(rs.getString(3));

                personList.add(person);
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }

        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(int personId) {
        return false;
    }
}
