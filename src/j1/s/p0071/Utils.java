/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.DocFlavor;

/**
 *
 * @author vu
 */
public class Utils {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String checkInputString(String regex, String message) throws IOException {

        boolean check;
        String input = null;
        do {
            check = true;
            System.out.println(message);
            input = reader.readLine();
            if (!input.matches(regex)) {
                check = false;
            }
        } while (check == false);
        return input;
    }

    public double getDouble(double max, double min, String message) throws IOException {

        boolean check;
        double input = 0;
        do {
            check = true;
            try {

                System.out.println(message);
                input = Double.parseDouble(reader.readLine());
                if (input < min || input > max) {
                    System.out.println("Number Out of Range");
                    check = false;

                }
            } catch (Exception e) {
                System.err.println(e);
                check = false;
            }
        } while (check == false);
        return input;
    }
    
    public int getInt(int max, int min, String message) throws IOException {

        boolean check;
        int input = 0;
        do {
            check = true;
            try {

                System.out.println(message);
                input = Integer.parseInt(reader.readLine());
                if (input < min || input > max) {
                    System.out.println("Number Out of Range");
                    check = false;

                }
            } catch (Exception e) {
                System.err.println(e);
                check = false;
            }
        } while (check == false);
        return input;
    }

    public String getDate(String message, String format) throws ParseException {

       
        String input = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        sdf.setLenient(true);
        
        
        while(true){
            try {
                System.out.println(message);
                input = reader.readLine();
                date= sdf.parse(input);
                Date now = new Date();
                
                if(date.after(now)){
                    System.out.println("Day doesn't valid");
                    continue;
                    
                }
                break;
            } catch ( IOException  | ParseException io ) {
                System.out.println(io);
            }
        }
        return input;

    }
}
