package com.ua.project.util.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHelpers {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String getStringInputByLength(final String inputMessage, final int maxLength) {
        String inputString;

        while(true){
            System.out.print(inputMessage);
            inputString = SCANNER.nextLine();

            if(inputString.length() < maxLength){
                System.out.println(" Entered string is to short!\n Try again!");
                continue;
            }

            return inputString;
        }
    }

    public static Date getDateInput(final String inputMessage){
        while(true){
            try{
                System.out.print(inputMessage);
                return DATE_FORMAT.parse(SCANNER.nextLine());
            }
            catch(ParseException e){
                System.out.println(" Incorrect date format!\n Expected (yyyy-MM-dd)");
                SCANNER.next();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                SCANNER.next();
            }
        }
    }
}
