package mysql;

import com.astontech.bo.Person;
import com.astontech.bo.Phone;
import com.astontech.dao.PhoneDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl extends MySQL implements PhoneDAO {

    @Override
    public Phone getPhoneById(int phoneId) {
        //connect to database from MySQL class using connect method
        Connect();
        //not instantiated since if no records returned don't use memory
        Phone phone = null;

        try {
            String storeProcedure = "{CALL USP_GetPhone(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storeProcedure);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, phoneId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                phone = HydrateObject(rs);
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }

        return phone;
    }

    @Override
    public List<Phone> getPhoneList() {
        //connect to database from MySQL class using connect method
        Connect();
        //not instantiated since if no records returned don't use memory
        List<Phone> phoneList = new ArrayList<Phone>();

        try {
            String storeProcedure = "{CALL USP_GetPhone(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(storeProcedure);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                phoneList.add(HydrateObject(rs));
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }

        return phoneList;
    }

    @Override
    public int insertPhone(Phone phone) {
        return 0;
    }

    @Override
    public boolean updatePhone(Phone phone) {
        return false;
    }

    @Override
    public boolean deletePhone(int phoneId) {
        return false;
    }

    private static Phone HydrateObject(ResultSet rs) throws SQLException {
        //Create Person Object
        Phone phone = new Phone();
        //Hydrating an object
        phone.setPhoneId(rs.getInt(1));
        phone.setAreaCode(rs.getInt(5));
        phone.setPhoneNumber(rs.getInt(6));
        phone.setClientId(rs.getInt(4));

        return phone;
    }
}
