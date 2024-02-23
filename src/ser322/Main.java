/**
 * @authors Joshua McKenzie, Dung Ho, Estevan Perez
 * Project Deliverable 4
 * Team 11
 * SER 322 - Summer Session C
 * Instructor Moubayed
 * <p>
 * Description: A JDBC command-line interface to do various SQL statements.
 */
package ser322;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    private static final String DB_URL = "jdbc:mysql://34.28.33.230:3306/warehouse";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Deliverable4";
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.err.println("MySQL JDBC driver not found");
            e.printStackTrace();
            return;
        }

        try(Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD))
        {
            // Connection successful
            System.out.println("Connected to the database!");
            // You can perform database operations here


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
                        driver.addData(conn); // TODO: Method call may need adjustment here
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
                        driver.deleteData(conn); // TODO: Method call may need adjustment here
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
        catch(SQLException e)
        {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
}