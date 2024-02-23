/**
 * @authors Joshua McKenzie, Dung Ho, Estevan Perez
 * Project Deliverable 4
 * Team 11
 * SER 322 - Summer Session C
 * Instructor Moubayed
 *
 * Description: A JDBC command-line interface to do various SQL statements.
 */

package ser322;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Main
{
    private static final String DB_URL = "jdbc:mysql://34.28.33.230:3306/warehouse"; // TODO: Type in the URL once we know it
    private static final String USERNAME = "root"; // TODO: Type in the USERNAME once we know it
    private static final String PASSWORD = "Deliverable4"; // TODO: Type in the PASSWORD once we know it

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        JDBCDriver driver = new JDBCDriver(DB_URL, USERNAME, PASSWORD);
        int userMenuChoice = 0;

        System.out.println("===============JDBC Database Editor===============");
        System.out.println("==by Joshua McKenzie, Estevan Perez, and Dung Ho==");

        while(true)
        {
            System.out.println("\nMAIN MENU\n");
            System.out.println("Choose from the menu below:");
            System.out.println("(1) = Add an element to the database");
            System.out.println("(2) = Edit an element in the database");
            System.out.println("(3) = Search for an element in the database");
            System.out.println("(4) = List an element(s) from the database");
            System.out.println("(5) = Delete an element from the database");
            System.out.println("(6) = EXIT\n");
            System.out.print(">>> ");
            try
            {
                userMenuChoice = Integer.parseInt(in.nextLine());
            }
            catch(NumberFormatException nfe)
            {
                System.err.println("User entered an incorrect string or value. Enter an integer value.");
                continue;
            }
            switch(userMenuChoice)
            {
                case 1:
                    System.out.println("Case 1");
//                    driver.addData(); // TODO: Method call may need adjustment here
                    break;
                case 2:
                    System.out.println("Case 2");
//                    driver.editData(); // TODO: Method call may need adjustment here
                    break;
                case 3:
                    System.out.println("Case 3");
//                    driver.searchData(); // TODO: Method call may need adjustment here
                    break;
                case 4:
                    System.out.println("Case 4");
//                    driver.listData(); // TODO: Method call may need adjustment here
                    break;
                case 5:
                    System.out.println("Case 5");
//                    driver.deleteData(); // TODO: Method call may need adjustment here
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("User entered an incorrect integer value, please try again.");
                    break;
            }
        }
    }
}