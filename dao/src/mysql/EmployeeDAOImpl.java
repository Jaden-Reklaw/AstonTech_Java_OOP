package mysql;

import com.astontech.bo.Employee;
import com.astontech.bo.Person;
import com.astontech.dao.EmployeeDAO;

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
        return 0;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        return false;
    }

    private static Employee HydrateObject(ResultSet rs) throws SQLException {
        //Create Employee Object
        Employee employee = new Employee();
        //Hydrating an object
        employee.setEmployeeId(rs.getInt(1));
        employee.setEmail(rs.getString(2));
        employee.setDOB(rs.getDate(3));

        return employee;
    }
}
