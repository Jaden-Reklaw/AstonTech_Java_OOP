package mysql;

import com.astontech.bo.Employee;
import com.astontech.dao.EmployeeDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl extends MySQL implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(int employeeId) {
        //connect to database from MySQL class using connect method
        Connect();
        //not instantiated since if no records returned don't use memory
        Employee employee = null;

        try {
            String storeProcedure = "{CALL USP_GetEmployee(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storeProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, employeeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                employee = HydrateObject(rs);
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }

        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        //connect to database from MySQL class using connect method
        Connect();
        //not instantiated since if no records returned don't use memory
        List<Employee> employeeList = new ArrayList<Employee>();

        try {
            String storeProcedure = "{CALL USP_GetEmployee(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storeProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs);
                employeeList.add(HydrateObject(rs));
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }

        return employeeList;
    }

    @Override
    public int insertEmployee(Employee employee) {
        //Connect to database
        Connect();
        int id = 0; //thing to change on return

        try {
            //CALL USP_ExecPerson(QueryID, EmployeeID, Email, HireDate, TermDate, BirthDate, PersonId);
            String storeProcedure = "{CALL USP_ExecEmployee(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(storeProcedure);

            statement.setInt(1, INSERT);
            statement.setInt(2, 0);
            statement.setString(3, employee.getEmail());
            statement.setDate(4, DateHelper.utilDateToSqlDate(employee.getHireDate()));
            statement.setDate(5, DateHelper.utilDateToSqlDate(employee.getTermDate()));
            statement.setDate(6, DateHelper.utilDateToSqlDate(employee.getBirthDate()));
            statement.setInt(7, employee.getPersonId());

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
    public boolean updateEmployee(Employee employee) {
        //Connect to database
        Connect();
        int id = 0; //thing to change on return

        try {
            //CALL USP_ExecPerson(QueryID, EmployeeID, Email, HireDate, TermDate, BirthDate, PersonId);
            String storeProcedure = "{CALL USP_ExecEmployee(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(storeProcedure);

            statement.setInt(1, UPDATE);
            statement.setInt(2, employee.getEmployeeId());
            statement.setString(3, employee.getEmail());
            statement.setDate(4, null);
            statement.setDate(5, null);
            statement.setDate(6, null);
            statement.setInt(7, employee.getPersonId());

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
    public boolean deleteEmployee(int employeeId) {
        //Connect to database
        Connect();
        int id = 0; //thing to change on return

        try {
            //CALL USP_ExecPerson(QueryID, EmployeeID, Email, HireDate, TermDate, BirthDate, PersonId);
            String storeProcedure = "{CALL USP_ExecEmployee(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(storeProcedure);

            statement.setInt(1, DELETE);
            statement.setInt(2, employeeId);
            statement.setString(3, null);
            statement.setDate(4, null);
            statement.setDate(5, null);
            statement.setDate(6, null);
            statement.setInt(7, 0);

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

    private static Employee HydrateObject(ResultSet rs) throws SQLException {
        //Create Employee Object
        Employee employee = new Employee();
        //Hydrating an object
        employee.setEmployeeId(rs.getInt(1));
        employee.setEmail(rs.getString(2));
        employee.setHireDate(rs.getDate(3));
        employee.setTermDate(rs.getDate(4));
        employee.setBirthDate(rs.getDate(5));
        employee.setPersonId(rs.getInt(6));

        return employee;
    }
}
