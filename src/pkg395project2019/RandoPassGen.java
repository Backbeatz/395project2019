/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg395project2019;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Connor
 */
public class RandoPassGen {
    static final String vals = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom(); 
    //Generate password 6-12 characers
    public static String main(){
        int min = 6; //minimum chars
        int max = 12; //maximum chars
        
        int len = ThreadLocalRandom.current().nextInt(min, max + 1); //set len to
        StringBuilder newpass = new StringBuilder( len );
        for( int i = 0; i < len; i++ ) {
            newpass.append( vals.charAt( rnd.nextInt(vals.length()) ) );
        }
        return newpass.toString();
        
    }
}
