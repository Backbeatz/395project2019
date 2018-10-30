/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg395project2019;

import java.awt.Desktop;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Random;
import pkg395project2019.RandoPassGen;
import pkg395project2019.addToDatabase;

/**
 * Connor's big old testing program
 *
 * @author Connor
 */
public class Main {

    /**
     * TEST CASE FOR Non-web elements
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Test if we can access account
        //testRandomPass(); //works

        testAccountMake1(); //works but basic

        testAccountMake2(); //Not working

        //testWeb(); //not working
        //test our webpage launcher
        //testWeb();
        //Login
    }

    public static void testRandomPass() {
        //Test random password gen
        String testpassPre = RandoPassGen.main();
        System.out.println("Here's a password:" + " " + testpassPre);
    }

    /**
     * Tests the addToDatabase's most basic version
     */
    public static void testAccountMake1() {
        //Test case 001: adding user (contractor)
        Random rand1 = new Random();
        int ID1 = rand1.nextInt(50);
        //insure Id is diffrent
        String testpass1 = RandoPassGen.main();

        //Test add
        System.out.println("Test entry: " + "__" + ID1 + "__" + "USER" + "__" + testpass1 + "__" + '2');

        addToDatabase.maintest(ID1, "Boss", testpass1, 2);
        //addToDatabase.main( ID1, "Bob", testpass1,2);
        System.out.println("DBconnect works");

    }

    /**
     * Test's addtodatabse's new functions -Connor
     */
    public static void testAccountMake2() {

        //Test case 001: adding user (contractor)
        Random rand1 = new Random();
        int ID1 = rand1.nextInt(50);
        //insure Id is diffrent
        String testpass1 = RandoPassGen.main();

        //Test add
        System.out.println("Test entry: " + "__" + ID1 + "__" + "USER" + "__" + testpass1 + "__" + '2');
        addToDatabase.main(ID1, "Boss", testpass1, 2);
        //addToDatabase.main( ID1, "Bob", testpass1,2);
        System.out.println("DBconnect works");

    }

    /**
     * Tests our webpage launcher
     *
     * @throws IOException
     */
    public static void testWeb() throws IOException {
        File htmlFile = new File("MainLogin.xhtml");
        htmlFile.toURI();
        //java server
        URI theURI = htmlFile.toURI();
        java.awt.Desktop.getDesktop().browse(theURI);
    }
}
