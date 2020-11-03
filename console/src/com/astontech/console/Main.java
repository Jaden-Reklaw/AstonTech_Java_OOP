package com.astontech.console;

//import dependencies file -> project structure -> Dependency Tab
import com.astontech.bo.*;
import com.astontech.dao.PersonDAO;
import common.helpers.MathHelper;
import common.helpers.StringHelper;
import interfaces.*;
import interfaces.Test;
import mysql.PersonDAOImpl;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class Main {

    //Create an instance of the Logger
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

	   //write your code here sout
       // System.out.println("Hello World!");

        //System.out.println("sout is a great shortcut");
        //String outsideVar = "hello from outside!";
        //Pass variable into the method
        //LessonVariables(outsideVar);

        //LessonDataTypes();

        //LessonStrings();

        //LessonList();

        //LessonFundamentals();

        //LessonOperators();

        //LessonFlowControl();

        //try{
        //    LessonExecptions();
        //} catch (Exception err) {
        //    System.out.println("My Error "+ err);
        //}

       // LessonFizzBuzzLab();
        //LessonCalculatorLab();

        //System.out.println("Test");
        //Test myTest = new Test();
        //System.out.println(myTest.Test_Method());

        //LessonClassObjects();

        //LessonInheritance();

        //LessonMethods();

        //LessonObjectsLab();

        //LessonCollections();

        //LessonComplexProperties();

        //LessonCollectionLab();

        //LessonInstanceVsStatic();

        //LessonPolymorphism();

        //LessonHash();

        //LessonValueVsRef();

        //LessonInterfaceTest();

        //LessonLogging();

        //LessonComparable();

        //LessonDBConnection();

        //LessonExecQuery();

        //LessonGetStoredProcedure();

        //LessonDAO();

        PostgreSQLExecQuery();
    }

    private static Connection PostrgreSQLConnection() {
        String dbHost = "localhost";
        String dbName = "hr";
        String dbUser = "postgres";
        String dbPass = "Welcome1@";
        String useSSL = "false";
        String procBod = "true";

        try{
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException ex) {
            logger.error("PostgreSQL Driver not found!", ex);
            return null;
        }
        logger.info("PostgreSQL Driver Registered.");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + dbHost + ":5432/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPass);
        } catch (SQLException ex) {
            logger.error("Connection failed" + ex);
            return null;
        }

        if(connection != null) {
            logger.info("Successfully connected to PostgreSQL database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }

    private static void PostgreSQLExecQuery() {
        Connection conn = PostrgreSQLConnection();

        try {
            Statement statement = conn.createStatement();
            String sql1 = "SELECT PersonID, FirstName, LastName FROM Person";
            ResultSet rs = statement.executeQuery(sql1);

            while (rs.next()) {
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                System.out.println(personId + ": " + firstName + " " + lastName);
            }
            conn.close();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    private static void LessonDAO() {
        /*
        Person Table
        Person Id
        FirstName
        LastName
        DisplayFirstname
        etc...

        <<interface>> PersonDAO
        getPersonById()
        getPersonList()
        insertPerson()
        updatePerson()
        deletePerson()

        Main Java Class
        LessonDAO

        PersonDAOImplement
        getPersonById()
        getPersonList()
        insertPerson()
        updatePerson()
        deletePerson()
        */
        //region Create Menu
        PersonDAO personDAO = new PersonDAOImpl(); //amend in next lesson
        List<Person> personList = personDAO.getPersonList();

        System.out.println("===============================");
        for(Person person: personList) {
            System.out.println(person.getPersonId() + ": " + person.getFirstName() + " " + person.getLastName());
        }
        System.out.println("===============================");
        //endregion

        //region Prompt User
        Scanner reader = new Scanner(System.in);
        System.out.println("Please Select a Person from the list: ");
        String personId = reader.nextLine();
        //endregion

        //region Get Person Details
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));

        System.out.println("---Person Details---");
        System.out.println("Full Name: " + personDetail.GetFullName());
        //endregion
    }

    private static void LessonGetStoredProcedure() {
        Connection conn = LessonDBConnection();
        try {
            String sp = "{CALL USP_GetPerson(?, ?)}";
            CallableStatement cStmt = conn.prepareCall(sp);

            cStmt.setInt(1, 20);
            cStmt.setInt(2, 2);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    private static void LessonExecQuery() {
        Connection conn = LessonDBConnection();

        try {
            Statement statement = conn.createStatement();
            String sql1 = "SELECT PersonID, FirstName, LastName FROM Person";
            ResultSet rs = statement.executeQuery(sql1);

            while (rs.next()) {
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                System.out.println(personId + ": " + firstName + " " + lastName);
            }
            conn.close();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    private static Connection LessonDBConnection() {

        String dbHost = "localhost";
        String dbName = "aston_database";
        String dbUser = "consoleUser";
        String dbPass = "Password1@";
        String useSSL = "false";
        String procBod = "true";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            logger.error("MySQL Drier not found!", ex);
            return null;
        }
        logger.info("MySQL Driver Registered.");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPass);
        } catch (SQLException ex) {
            logger.error("Connection failed" + ex);
            return null;
        }

        if(connection != null) {
            logger.info("Successfully connected to MySQL database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }

    public static void LessonComparable() {
        Person p1 = new Person(7, "Bob");
        Person p2 = new Person(5, "Linda");

        System.out.println("Compare to Returns :: " + p1.compareTo(p2));
        int result = p1.compareTo(p2);

        if(result < 0) {
            System.out.println(p1.getFirstName() + " comes before " + p2.getFirstName());
        } else if(result > 0) {
            System.out.println(p2.getFirstName() + " comes before " + p1.getFirstName());
        } else {
            System.out.println(p1.getFirstName() + " are equals " + p2.getFirstName());
        }
    }

    private static void LessonLogging() {
        //levels of logging
        //development level
        logger.debug("This is a DEBUG message");
        logger.info("This is a INFO message");
        // production level
        logger.warn("This is a WARN message");
        logger.error("This is a FATAL message");
        logger.fatal("This is a FATAL message");

        //log and exception
        try {
            int i = 10 /0;
        } catch (ArithmeticException error) {
            logger.error("An exception occurred: " + error);
        }
    }

    private static void LessonInterfaceTest() {
        Site MN010 = new Site();
        MN010.setSiteName("MN010");
        MN010.setCoffeeMachine(2);
        MN010.setConferenceRooms(1);
        MN010.setOffices(6);
        MN010.setCubicles(8);
        MN010.setTrainingDesks(36);

        Home myHouse = new Home();
        myHouse.setAddress("123 Main Stree");
        myHouse.setOwner(new Employee("Jordan", "Walker"));

        LessonInterfaces(MN010);
        LessonInterfaces(myHouse);

        //Two new classes connected to the Player interface
        Wizard wiz1 = new Wizard("Bob Belcher", "Burger Flip of Destiny", "Blue");
        Warrior war1 = new Warrior("Louis Belcher","House Kuchi Kopi", "Imagination of My Creation", "Brute");
        UsePlayerInterface(wiz1);
        UsePlayerInterface(war1);

        //Send to Test class that uses CharSequence Interface with a method that prints things backwards
        Test test = new Test();
        UseCharSequenceInterface(test.StringBackWard("Hello World!"));
    }

    private static void UseCharSequenceInterface(CharSequence charSequence) {
        //print string backwards
        System.out.println(charSequence);
    }

    private static void UsePlayerInterface(Player player) {
        System.out.println(player.attack());
        System.out.println(player.eat());
        System.out.println(1 + player.move());
    }

    private static void LessonInterfaces(ILocation Ilocation) {
        System.out.println("=================");
        System.out.println("Location Name: " + Ilocation.getLocationName());
        System.out.println("Can have meetings: " + Ilocation.canHaveMeetings());
        System.out.println("Number of work spaces: " + Ilocation.numberOfWorkSpaces());
        System.out.println("Has Coffee: " + Ilocation.hasCoffee());
    }

    private static void LessonValueVsRef() {
        System.out.println("--ref types--");
        //references are objects
        Employee firstEmp = new Employee();
        firstEmp.setFirstName("Jordan");

        //secondEmp is pointing to firstEmp thus if you change one you change the other
        Employee secondEmp = firstEmp;
        secondEmp.setFirstName("Kelsey");

        System.out.println(firstEmp.getFirstName());
        System.out.println(secondEmp.getFirstName());

        //Value types
        System.out.println("--value types--");
        int num1 = 10;
        int num2 = num1;
        System.out.println(num1);
        System.out.println(num2);
        num2 = 20;
        System.out.println(num1);
        System.out.println(num2);
    }

    private static void LessonHash() {
        // Key-Value Pairs / Value List
        /*
        Hash Table
        1.) Does NOT allow null for either key or value
        2.) synchronized, thread safe, but performance is decreased
         */

        System.out.println("---Hash Table---");

        Hashtable<Integer, String> oopPrinciples = new Hashtable<>();
        oopPrinciples.put(1, "Inheritance");
        oopPrinciples.put(2, "Polymorphism");
        oopPrinciples.put(3, "Abstraction");
        oopPrinciples.put(4, "Encapsulation");
        //oopPrinciples.put(5, null); // throws null pointer execption

        //Single output from hashtable
        System.out.println(oopPrinciples.get(3));

        //All values
        for(Integer key : oopPrinciples.keySet()) {
            System.out.println(oopPrinciples.get(key));
        };
        System.out.println("----------------");

        // Key-Value Pairs / Value List
        /*
        Hash Map
        1.) Does allow null for either key or value
        2.) unsynchronized, not thread safe, but performance is better
         */

        System.out.println("---Hash Map---");

        HashMap<Integer, String> oopPrinciples2 = new HashMap<>();
        oopPrinciples2.put(1, "Inheritance");
        oopPrinciples2.put(2, "Polymorphism");
        oopPrinciples2.put(3, "Abstraction");
        oopPrinciples2.put(4, "Encapsulation");
        oopPrinciples2.put(5, null);

        //Single output from hashtable
        System.out.println(oopPrinciples2.get(3));

        //All values
        for(Integer key : oopPrinciples.keySet()) {
            System.out.println(oopPrinciples.get(key));
        };
        System.out.println("----------------");

        // Key-Value Pairs / Value List
        /*
        Hash Set
        1.) Built in mechanism for duplicates
        2.) used for when you wanna maintain unique list
         */

        System.out.println("---Hash Set---");

        HashSet<String> oopPrinciples3 = new HashSet<>();
        oopPrinciples3.add("Inheritance");
        oopPrinciples3.add("Polymorphism");
        oopPrinciples3.add("Abstraction");
        oopPrinciples3.add("Encapsulation");

        //Single output from hashtable
        System.out.println(oopPrinciples3);

        //All values
        for(String s : oopPrinciples3) {
            System.out.println(s);
        }

        if(oopPrinciples.contains("Inheritance")) {
            System.out.println("Value does exist!");
        } else {
            System.out.println("Value does not exist!");
        }

        System.out.println("----------------");
    }

    private static void LessonPolymorphism() {
        // compile time polymorphism - overloaded
        //think creating multiple constructors
        Employee empOne = new Employee("Bob");
        Employee empTwo = new Employee("Linda", "Belcher");
        System.out.println(empOne.getFirstName());
        System.out.println(empTwo.getFirstName() + " " + empTwo.getLastName());
        // run-time polymorphism - override
        //Override a method that is in a super class in a lower class
        // Create a method in BaseBO and create the same method in Empl
        BaseBO obj1 = new BaseBO();
        System.out.println(obj1.test_method());

        EntityType obj2 = new EntityType();
        System.out.println(obj2.test_method());
    }

    private static void LessonInstanceVsStatic() {
        //Add dependency file -> project structure -> modules -> dependency tab -> + button -> select dependency
        System.out.println(MathHelper.E);
        System.out.println(MathHelper.PI);
        System.out.println(MathHelper.square(5));
        //Three helper methods for StringHelper
        System.out.println(StringHelper.removeLeadingAndTrailingSpaces("  Hello  "));
        System.out.println(StringHelper.removeAllSpace(" He ll o !"));
        System.out.println(StringHelper.yelling("hello"));
        //Three helper methods for MathHelper
        System.out.println(MathHelper.cubed(5));
        System.out.println(MathHelper.areaOfRectangle(2,3));
        System.out.println(MathHelper.perimeterOfRectangle(4, 5));

    }

    private static void LessonCollectionLab() {
        Employee emp1 = new Employee();

        emp1.getVehicles().add(new Vehicle(LocalDate.of(2012, 02, 12), "4738474HJF84", new VehicleModel("CX5")));
        emp1.getVehicles().add(new Vehicle(LocalDate.of(2013, 05, 11), "AAAAAA4HJF84", new VehicleModel("CX3")));
        emp1.getVehicles().add(new Vehicle(LocalDate.of(2014, 06, 8), "473BBBBBBBBB", new VehicleModel("CX9")));

        for(Vehicle vehcile : emp1.getVehicles()) {
            System.out.println(vehcile.getModel().getVehicleModelName());
        }
        //With setter
        emp1.getVehicles().get(0).getModel().setVehicleModelName("T1");

        //with getter
        System.out.println(emp1.getVehicles().get(0).getModel().getVehicleModelName());

        for(Vehicle vehcile : emp1.getVehicles()) {
            System.out.println(vehcile.getModel().getVehicleModelName());
        }
    }

    private static void LessonComplexProperties() {
        //When to use inheritance(Ask the question: 'IS A?'). Employee IS A Person
        //When to use complex(nested) objects(Ask the question: 'HAS A?'). Employee HAS A Email
        EntityType emailWorkType = new EntityType("Work");
        emailWorkType.setEntityTypeId(1);

        //instance of an object using constructor sending email in
        Email myEmail = new Email("bipin@aston.com");
        //setting email type on the Email object that is connected to EntityType Object through an instance
        myEmail.setEmailType(emailWorkType);

        //myEmail.getEmailType().getEntityTypeName() object within and object accessed with dot notation
        System.out.println(myEmail.getEmailAddress() +  " Type: " + myEmail.getEmailType().getEntityTypeName() +
                           myEmail.getEmailType().getEntityTypeId());

        //collection/list of complex(nested) objects as a property
        Employee myEmployee = new Employee();
        //Employee inherits from Person which has getEmails which sends back a List
        //then you use .add to add more emails to that List and create new Email object in that list
        myEmployee.getEmails().add(new Email("test1@test.com"));
        myEmployee.getEmails().add(new Email("test2@test.com"));
        myEmployee.getEmails().add(new Email("test3@test.com"));

        //for each statement reads email with in myEmployee object then list using getEmails
        for(Email email : myEmployee.getEmails()) {
            System.out.println(email.getEmailAddress());
        }

    }

    private static void LessonCollections() {
        // List<T> - generic type 'T'
        List<Employee> employeeList = new ArrayList<Employee>();

        //Create Employees from Employee objects constructor
        Employee emp1 = new Employee("Jordan", "Walker");
        Employee emp2 = new Employee("Mark", "Tuttle");
        Employee emp3 = new Employee("Wayne", "Henderson");

        //Add them to employee list
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        //Create employee and add to list in one line
        employeeList.add(new Employee("Erick", "Jensen"));

        //Get info from list
        System.out.println(employeeList.get(3).GetFullName());

        //Print all full names from employee list
        for(Employee e : employeeList) {
            System.out.println(e.GetFullName());
        }

    }

    private static void LessonObjectsLab() {
        //1
        Project myProject = new Project("Test", "2020-01-01", "2020-05-04");
        System.out.println(myProject.GetDaysTillCompletion());

        //2
        Address myAddress = new Address("123 Hello World", "Earth", "MN", "54543");
        System.out.println(myAddress.ShowFullAddress());
    }

    //method signature /declaration
    /*
    <access modifier> <instance/static> <return data type> <method name> (<data type> <param name, <data type> <param name> ...) {body}
    private             static           void               LessonMethods   (nothing passed in)
    public                               int                getPersonId     (nothing passed in)
    public                               void               setPersonId     (int PersonId)
     */
    private static void LessonMethods() {
        // constructors are special methods with same name as the class
        Employee constructEmployee = new Employee("Axel", "Walker");
        System.out.println(constructEmployee.getFirstName() + " " + constructEmployee.getLastName());

        //Use getfullname method with a new employee with nothing set
        Employee employee4 = new Employee();
        System.out.println(employee4.GetFullName());

        //get full name of object that has both firstname and lastname filled out
        System.out.println(constructEmployee.GetFullName());
    }

    private static void LessonInheritance() {
        // 4 Principles(tenets) Encapsulation, Abstraction, Inheritance, Polymorphism
        //create an instance of Employee Object
        Employee employee1 = new Employee();

        //Set Id , firstName and lastName of Employee from Person Class and BaseBO
        employee1.setId(13);
        employee1.setFirstName("Jordan(e)");
        employee1.setLastName("Walker(e)");

        //Print info out
        System.out.println("Id#" + employee1.getId() + " " + employee1.getFirstName() + " " + employee1.getLastName());

        //create a Person object and inherit from BaseBO class Id
        Person person3 = new Person();
        person3.setId(7);
        person3.setFirstName("Jordan(p)");
        person3.setLastName("Walker(p)");

        System.out.println("Id#" + person3.getId() + " " + person3.getFirstName() + " " + person3.getLastName());
    }

    private static void LessonClassObjects() {
        //instantiating a new object
        Person person1 = new Person();
        Person person2 = new Person();

        //Set title, firstname and lastname
        person1.setTitle("Mr.");
        person1.setFirstName("Jordan");
        person1.setLastName("Walker");

        person2.setTitle("Mrs.");
        person2.setFirstName("Kelsey");
        person2.setLastName("Walker");

        //Print out
        System.out.println(person1.getTitle()+ " " + person1.getFirstName() + " " + person1.getLastName());
        System.out.println(person2.getTitle()+ " " + person2.getFirstName() + " " + person2.getLastName());

        // Set super BaseBO class
        person1.setId(7);
        System.out.println(person1.getFirstName() + " Id is: " + person1.getId());
    }

    //Create another seperate method (LessonCalculatorLAB)
    private static void LessonCalculatorLab() {
        //Write code that prompts the user to enter a number from 0-9 and then reads the users input.
        // Create a Scanner object
        Scanner reader = new Scanner(System.in);
        // Prompt User and get num1 input
        System.out.print("Enter a number from 0-9: ");
        int num1 = reader.nextInt();

        //If the user enters anything other than a number from 0-9, print "INVALID" to the console and reprommpt.
        while(num1 < 0 || num1 > 9) {
            System.out.println("INVALID");
            System.out.print("Enter a number from 0-9: ");
            num1 = reader.nextInt();
        }

        //Prompt the user for a second number, with the same check.
        //Second Number
        System.out.print("Enter another number from 0-9: ");
        int num2 = reader.nextInt();
        reader.nextLine(); //fix issue with not consuming next line after nextInts

        //If the user enters anything other than a number from 0-9, print "INVALID" to the console and reprommpt.
        while(num2 < 0 || num2 > 9) {
            System.out.println("INVALID");
            System.out.print("Enter another number from 0-9: ");
            num2 = reader.nextInt();
            reader.nextLine();
        }

        //Operator
        //Prompt the user to choose an operator (+, -, /, *) and accept input.
        //If the user enters anything other than one of the four operators, print "INVALID" to the console and reprompt.
        System.out.print("Choose an Operator +, -, /, * ");
        String operator = reader.nextLine();

        while(!operator.equals("-") && !operator.equals("+") && !operator.equals("*") && !operator.equals("/")) {
            System.out.println("INVALID");
            System.out.print("Choose an Operator +, -, /, * ");
            operator = reader.nextLine();
        }
//        boolean flag = true;
//
//        do {
//            if(operator.equals("-")  || operator.equals("+") || operator.equals("*") || operator.equals("/")) {
//                flag = false;
//            } else {
//                System.out.println("INVALID");
//                System.out.print("Choose an Operator +, -, /, * ");
//                operator = reader.nextLine();
//            }
//        } while (flag);

        //Using a switch/case perform the selected operation on the two entered numbers and output the result to the console.
        //switch (operator) {
            //case "-" -> System.out.println(num1 - num2);
            //case "+"-> System.out.println(num1 + num2);
            //case "*"-> System.out.println(num1 * num2);
            //case "/" -> System.out.println(num1/num2);
            //default -> System.out.println("This will never happen");
        //}
    }

    //Create a separate method (LessonFizzBuzzLAB)
    private static void LessonFizzBuzzLab() {
        //Write a loop that counts from 0-100
            for(int index=0; index <= 100; index++) {
                //If the value is divisible by 15 print "FizzBuzz"
                if(index%3 == 0 && index%5 == 0) {
                    //If the value is divisible by 3 print "Fizz"
                    System.out.println("FizzBuzz");
                } else if(index%3 == 0) {
                    System.out.println("Fizz");
                    //If the value is divisible by 5 print "Buzz"
                } else if(index%5 == 0) {
                    System.out.println("Buzz");
                    //If the value is not divisible by 3,5, or 15 simply print the number
                } else {
                    System.out.println(index);
                }
            }
            //Write code that will throw an exception (other than the ones we covered in the lesson) and catch it.
            String[] myStrArray = new String[2];
            myStrArray[0] = "Hello";
            myStrArray[1] = "Hello";
            try {
                System.out.println(myStrArray[2]);
            } catch(ArrayIndexOutOfBoundsException error){
                System.out.println(error);
            }
    }

    private static void LessonExecptions() throws Exception {
        // Simple unhandled exception
//        String firstName = "Jordan";
//        int x = Integer.parseInt(firstName);
//
//        System.out.println("Integer value: ");
//        System.out.println(x);

        // try catch block
//        String firstName = "Jordan";
//        try {
//            int x = Integer.parseInt(firstName);
//            System.out.println("Integer value: ");
//            System.out.println(x);
//        } catch(NumberFormatException err) {
//            System.out.println("Error is: " + err);
//        }

        // multiple exceptions and finally
        //order of the catch matters
//        String firstName = "Hello";
//        try {
//            int x = Integer.parseInt(firstName);
//            System.out.println("Integer value: ");
//            System.out.println(x);
//        } catch (NumberFormatException err) {
//            System.out.println("Error is: " + err.toString());
//        } catch (IllegalArgumentException err) {
//            System.out.println("Illegal Arg Error is: " + err.toString());
//        } catch(NullPointerException err) {
//            System.out.println("Null Pointer Error is: " + err.toString())
//        } catch (Exception err) {
//            System.out.println("Generic Error is: " + err.toString());
//        } finally {
//            System.out.println("Runs no matter what the exception is!");
//        }

        //If you create an exception it handles it all the way up to main so the method needs to throw an
        //main method for LessonException needs to be in a try catch block

        String firstName = null;
        try {
            int x = Integer.parseInt(firstName);
            System.out.println("Integer value: ");
            System.out.println(x);
        } catch(Exception err) {
            throw new Exception("A custom error message for Exception from Lesson Method", err);
        }
    }

    private static void LessonFlowControl() {
        //IF ElSE
        String name = "Bob";
        if(name == "Bob") {
            System.out.println("Hello Bob!");
        } else {
            System.out.println("You are not Bob!");
        }

        //on strings use equals function
        if(name.equals("Bob")){
            System.out.println("Hello Bob!");
        } else {
            System.out.println("You are not Bob!");
        }

        //nested ifs
        if(name.equals("Bob")){
            System.out.println("Hello Bob!");
            if(name.length() > 2) {
                System.out.println("Your name is longer then 2 letters");
            } else {
                System.out.println("Your name is not longer then 2 letters");
            }
        } else {
            System.out.println("You are not Bob!");
        }

        //else if
        int time = 22;
        if (time < 10) {
            System.out.println("Good morning.");
        } else if (time < 20) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        int day = 4;
        switch (day) {
            case 1 : System.out.println("Monday");
            case 2 : System.out.println("Tuesday");
            case 3 : System.out.println("Wednesday");
            case 4 : System.out.println("Thursday");
            case 5 : System.out.println("Friday");
            case 6 : System.out.println("Saturday");
            case 7 : System.out.println("Sunday");
            default : System.out.println("Not a day!");
        }
    }

    private static void LessonOperators() {
        //plus and minus
        int num1 = 10;
        System.out.println(num1 + 10);
        System.out.println(num1 - 10);

        // module or remainder
        int num2 = 3;
        System.out.println(10%num2);

        // increment ++ and decrement --
        //inc and dec after
        int num3 = 0;
        System.out.println("inc after");
        System.out.println(num3++); //0
        System.out.println(num3++); //1
        System.out.println(num3++); //2
        System.out.println(num3);  //3
        System.out.println("dec after");
        System.out.println(num3--); //3
        System.out.println(num3--); //2
        System.out.println(num3--); //1
        System.out.println(num3);  //0
        //inc and dec before
        System.out.println("inc before");
        System.out.println(++num3); //1
        System.out.println(++num3); //2
        System.out.println(++num3); //3
        System.out.println(num3);  //3
        System.out.println("dec before");
        System.out.println(--num3); //2
        System.out.println(--num3); //1
        System.out.println(--num3); //0
        System.out.println(num3);  //0

        //equal and not equal
        int num4 = 10;
        if(num4 == 10) {
            System.out.println("Num4 is equal to 10.");
        } else {
            System.out.println("Num4 is not equal to 10");
        }
        if(num4 != 10) {
            System.out.println("Num4 is not equal to 10.");
        } else {
            System.out.println("Num4 is equal to 10");
        }

        //and or statements
        int num5 = 13;
        String name = "Bill";

        if(num5 == 13 && name == "Bill") {
            System.out.println("Num3 is 13 and name is Bill!");
        } else {
            System.out.println("Either num5 is not 13 or name is not Bill!");
        }

        num5 = 3;
        if(num5 == 13 && name == "Bill" || num5 == 3) {
            System.out.println("Num3 is 13 and name is Bill!");
        } else {
            System.out.println("Either num5 is not 13 or name is not Bill!");
        }

        //negation !
        boolean answer = true;
        if(!answer){
            System.out.println("The answer is true!");
        } else {
            System.out.println("The answer is false!");
        }

    }

    private static void LessonFundamentals() {
        //#2
//        Scanner reader = new Scanner(System.in);
//        System.out.print("Enter a number from 1 to 10: ");
//        String input = reader.nextLine();
//        System.out.println(Integer.parseInt(input) + 1.75);

        //#3
        byte myNum1 = 100;
        System.out.println(myNum1);
        short myNum2 = 5000;
        System.out.println(myNum2);
        int myNum3 = 100000;
        System.out.println(myNum3);
        long myNum4 = 15000000000L;
        System.out.println(myNum4);
        float myNum5 = 5.75f;
        System.out.println(myNum5);
        double myNum6 = 19.99d;
        System.out.println(myNum6);
        boolean isJavaFun = true;
        boolean isFishTasty = false;
        System.out.println(isJavaFun);
        System.out.println(isFishTasty);
        char myGrade = 'B';
        System.out.println(myGrade);
        String greeting = "Hello World";
        System.out.println(greeting);

        //#4
        //Strings are non-primitive data types that are objects
        //Strings can be empty or null while primitive type can not
        //int a = null;
        String b = null;

        //#5
        List<String> stringList = new ArrayList<String>();
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("Let's do this");

        for(String oneStr : stringList) {
            System.out.println(oneStr);
        }

        //List can't have primitive types like int, char, double etc
        //List(int) characters = new ArrayList<int>()

        //#6
        //Lottery Variables
        String gameName = "Powerball";
        double jackpot = 20000000.00d;
        String drawingDate = "1/2/2013";
        List<String> winningNumbers = new ArrayList<String>();
        winningNumbers.add("3");
        winningNumbers.add("7");
        winningNumbers.add("13");
        winningNumbers.add("25");
        winningNumbers.add("47");
        winningNumbers.add("13LB");
        winningNumbers.add("5x");

    }

    private static void LessonList() {
        // collections / lists
        List<String> myStringCollection = new ArrayList<String>();

        myStringCollection.add("Str 1");
        myStringCollection.add("Str 2");
        myStringCollection.add("Str 3");
        myStringCollection.add("Str 4");
        myStringCollection.add("Str 5");

        System.out.println(myStringCollection);

        //loop over string collection
        for(String oneStr : myStringCollection) {
            System.out.println(oneStr);
        }

        List<Integer> myIntCollection = new ArrayList<Integer>();
        myIntCollection.add(10);
        myIntCollection.add(20);
        myIntCollection.add(30);
        myIntCollection.add(40);
        myIntCollection.add(50);
        System.out.println(myIntCollection);
        for(int oneNum : myIntCollection) {
            System.out.println(oneNum);
        }

        // Array
        //if you say an array of 5 that is all you can have in your list
        //if you go over it will be out bounce
        String[] myStringArray = new String[5];
        myStringArray[0] = "1st";
        myStringArray[1] = "2nd";
        myStringArray[2] = "3rd";
        myStringArray[3] = "4th";
        myStringArray[4] = "5th";

        System.out.println(myStringArray);
        for(String oneStr : myStringArray) {
            System.out.println(oneStr);
        }
    }

    private static void LessonStrings() {
        // String have a value or not
        String str = ""; //Empty
        str = null; // string has no value
        str = "Hello World!"; //string has a value

        if(str == null || str.isEmpty()) {
            System.out.println("String is either empty or null!");
        } else {
            System.out.println("String has a value!");
        }

        // immutable - unable to be changed...
        str = "another value"; //this create a new string each time its assigned a new value

//        for(int i = 0; i <= 10; i++) {
//            str = "New Value" + Integer.toString(i); //new string created each time
//            System.out.println(str);
//        }

        // overcome string immutable issue
//        StringBuilder myStringBuilder = new StringBuilder(); //doesn't create a new string
//        for(int i=0; i <= 10; i++) {
//            myStringBuilder.append("new value with string builder: ").append(Integer.toString(i)).append("\n");
//        }
//
//        System.out.println(myStringBuilder);

        //Strings are array of characters
        //Useful methods on strings indexOf and lastIndexOf
        String instructor = "Bipin";
        int firstIndex = instructor.indexOf("i");
        int lastIndex = instructor.lastIndexOf("i");

        System.out.println(firstIndex);
        System.out.println(lastIndex);

        //Break done a string into characters
        String sentence = "The cat in the hat sat on a rat!";
//        for(char c: sentence.toCharArray()) {
//            System.out.println(c);
//        }

        //substring to break down strings
        String partOfSentence = sentence.substring(4, 7);
        System.out.println(partOfSentence);

    }

    private static  void LessonDataTypes() {
        int num1 = 1;
        double num2 = 2.3;
        String myStr = "Hello World!";
        Date myDate = new Date();
        boolean myBool = true;

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(myStr);
        System.out.println(myDate);
        System.out.println(myBool);

        // parsing / converting data types
        // String -> int
        String num3 = "341";
        int intFromString = Integer.parseInt(num3);
        // int -> String
        int num4 = 455;
        String numStr = Integer.toString(num4);
        // date -> string
        String stringFromDate = myDate.toString();


    }

    private static void LessonVariables(String var1) {
        System.out.println(var1);
        // Declare Vars
        String lastName;
        String firstName = "Jordan", middleName = "Scott";

        //Set var to a value
        lastName = "Walker";
        //output to the console
        System.out.println(firstName + " " + middleName + " " + lastName);

        // Create a Scanner object
        Scanner reader = new Scanner(System.in);
        // Prompt User
        System.out.print("Enter Your Name: ");
        // Read input from the user and store in a variable
        String input = reader.nextLine();
        //print the value back to the screen
        System.out.println("Hello " + input);
    }
}
