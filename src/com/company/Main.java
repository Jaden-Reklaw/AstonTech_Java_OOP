package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here sout
       // System.out.println("Hello World!");

        //System.out.println("sout is a great shortcut");
        //String outsideVar = "hello from outside!";
        //Pass variable into the method
        //LessonVariables(outsideVar);

        //LessonDataTypes();

        //LessonStrings();

        LessonList();
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
