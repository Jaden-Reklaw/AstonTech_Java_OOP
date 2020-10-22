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

        //LessonList();

        //LessonFundamentals();

        LessonOperators();
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
