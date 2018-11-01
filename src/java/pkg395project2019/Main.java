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
 * @author Connor
 */
public class Main {

    /**
     * TEST CASE FOR Non-web elements
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //Test if we can access account
        testAccountMake1();
        //test our webpage launcher
        //testWeb();
        //Login
        
        
        
        
    }
    
    /**
     *Tests the addToDatabase
     */
    public static void testAccountMake1(){
        //Test random password gen
        String testpassPre = RandoPassGen.main();
        System.out.println("Here's a password:" + " " + testpassPre);
        
        
        //Test case 001: adding user (contractor)
        Random rand1 = new Random(); 
        int ID1 = rand1.nextInt(50);
        //insure Id is diffrent
        String testpass1 = RandoPassGen.main();
        System.out.println("Test password: " + " " + testpass1);
        
        addToDatabase.main();
        System.out.println("DBconnect works");
        /*
        //Test case 002: adding user (admin)
        Random rand2 = new Random(); 
        int ID2 = rand2.nextInt(50);
        //insure Id is diffrent
        String testpass2 = RandoPassGen.main();
        System.out.println("Test password: " + " " + testpass2);
        System.out.println("DBconnect works");
        addToDatabase.main(ID2,"bob",testpass2,1); 
        */
    }
    
    
    
    
    
    /**
     *Tests our webpage launcher
     * @throws IOException
     */
    public static void testWeb()throws IOException{
       File htmlFile = new File("MainLogin.xhtml");
       htmlFile.toURI();
         
       URI theURI = htmlFile.toURI();
       java.awt.Desktop.getDesktop().browse(theURI);
    }
}
