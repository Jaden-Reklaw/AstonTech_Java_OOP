package com.astontech.dao;

import com.astontech.bo.Employee;

import java.util.List;
import com.astontech.bo.Phone;

public interface PhoneDAO {
    //GET Methods
    public Phone getPhoneById(int phoneId);
    public List<Phone> getPhoneList();

    //EXECUTE Methods
    public int insertPhone(Phone phone);
    public boolean updatePhone(Phone phone);
    public boolean deletePhone(int phoneId);
}
