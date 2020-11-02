package com.astontech.dao;
import com.astontech.bo.Person;

import java.util.List;

public interface PersonDAO {
    //GET Methods
    public Person getPersonById(int personId);
    public List<Person> getPersonList();

    //EXECUTE Methods
    public int insertPerson(Person person);
    public boolean updatePerson(Person person);
    public boolean deletePerson(int personId);
}
