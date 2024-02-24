/**
 * @authors Joshua McKenzie, Dung Ho, Estevan Perez
 * Project Deliverable 4
 * Team 11
 * SER 322 - Summer Session C
 * Instructor Moubayed
 *
 * Description: The driver for JDBC command-line interface to do various SQL statements.
 */

package ser322;

import java.sql.*;
import java.io.*;
import java.util.*;

public class JDBCDriver implements JDBCDriverInterface
{
    private String url;
    private String username;
    private String password;

    /**
     * Constructor
     */
    public JDBCDriver(String pURL, String pUsername, String pPassword)
    {
        this.url = pURL;
        this.username = pUsername;
        this.password = pPassword;
    }
    /**
     * This function will allow the user to add data to the SQL DB by asking which table to add to, what type of data
     * to add, and what the element is. In addition, it should follow up with asking the user if they would like to add
     * another piece of data to the DB.
     */
    @Override
    public void addData(Connection connection)
    {
        System.out.print("Which table would you like to add to");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        
        if(input.equals("Department") ) {
        	String sqlStatementDepartment = "INSERT INTO Department (Dep_Num, Dep_Name, Office_Address, Dep_Manager) VALUES (?, ?, ?, ?)";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStatementDepartment)) {
        		System.out.println("Now adding to Department table.");
            	System.out.println("\t Please insert Department Number");
            	int Dep_Num = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert Department Name");
            	String Dep_Name = scanner.nextLine();
            	System.out.println("\t Please insert Office Address");
            	String Office_Address = scanner.nextLine();
            	//System.out.println("\t Please insert Department Manager");
            	//int Dep_Manager = scanner.nextInt();
            	//scanner.nextLine();
            	preparedStatement.setInt(1, Dep_Num);
            	preparedStatement.setString(2, Dep_Name);
            	preparedStatement.setString(3, Office_Address);
            	preparedStatement.setString(4, null);
            	int rowChanges = preparedStatement.executeUpdate();
            	if(rowChanges > 0) {
            		 System.out.println("Data inserted!");
            	} else {
                    System.out.println("Error inserting data.");
                }
        	}catch (SQLException e) {
        		e.printStackTrace();
        	}
        	
        }else if (input.equals("Employee")){
        	String sqlStatementEmployee = "INSERT INTO Employee (Emp_ID, SSN, First_Name, Last_Name, Address, Dep_Num) "
        			+ "VALUES (?, ?, ?, ?, ?, ?)";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStatementEmployee)) {
        		System.out.println("Now adding to Department table.");
            	System.out.println("\t Please insert Employee ID");
            	int Emp_ID = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert SSN (as one complete number ex 123456789)");
            	int SSN = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert First Name");
            	String First_Name = scanner.nextLine();
            	System.out.println("\t Please insert Last Name");
            	String Last_Name = scanner.nextLine();
            	System.out.println("\t Please insert Address");
            	String Address = scanner.nextLine();
            	System.out.println("\t Please insert Department Number");
            	int Dep_Num = scanner.nextInt();
            	scanner.nextLine();
            	preparedStatement.setInt(1, Emp_ID);
            	preparedStatement.setInt(2, SSN);
            	preparedStatement.setString(3, First_Name);
            	preparedStatement.setString(4, Last_Name);
            	preparedStatement.setString(5, Address);
            	preparedStatement.setInt(6, Dep_Num);
            	int rowChanges = preparedStatement.executeUpdate();
            	if(rowChanges > 0) {
            		 System.out.println("Data inserted!");
            	} else {
                    System.out.println("Error inserting data.");
                }
        	}catch (SQLException e) {
        		e.printStackTrace();
        	}
        	
        }else if (input.equals("Product")){
        	String sqlStatementProduct = "INSERT INTO Product (SKU, Product_Name, Product_Description) "
        			+ "VALUES (?, ?, ?)";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStatementProduct)) {
        		System.out.println("Now adding to Product table.");
            	System.out.println("\t Please insert SKU");
            	int SKU = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert Product Name");
            	String Product_Name = scanner.nextLine();
            	System.out.println("\t Please insert Product Description");
            	String Product_Description = scanner.nextLine();
            	preparedStatement.setInt(1, SKU);
            	preparedStatement.setString(2, Product_Name);
            	preparedStatement.setString(3, Product_Description);
            	int rowChanges = preparedStatement.executeUpdate();
            	if(rowChanges > 0) {
            		 System.out.println("Data inserted!");
            	} else {
                    System.out.println("Error inserting data.");
                }
        	}catch (SQLException e) {
        		e.printStackTrace();
        	}
        }else if (input.equals("Exports")){
        	String sqlStatementExports = "INSERT INTO Exports (Order_No, Dep_Num, SKU, Quantity) "
        			+ "VALUES (?, ?, ?, ?)";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStatementExports)) {
        		System.out.println("Now adding to Exports table.");
            	System.out.println("\t Please insert Order Number");
            	int Order_No = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert Department Number");
            	int Dep_Num = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert SKU");
            	int SKU = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert Quantity");
            	int Quantity = scanner.nextInt();
            	scanner.nextLine();
            	preparedStatement.setInt(1, Order_No);
            	preparedStatement.setInt(2, Dep_Num);
            	preparedStatement.setInt(3, SKU);
            	preparedStatement.setInt(4, Quantity);
            	int rowChanges = preparedStatement.executeUpdate();
            	if(rowChanges > 0) {
            		 System.out.println("Data inserted!");
            	} else {
                    System.out.println("Error inserting data.");
                }
        	}catch (SQLException e) {
        		e.printStackTrace();
        	}
        }else if (input.equals("Inventory")){
        	String sqlStatementInventory = "INSERT INTO Inventory (SKU, Quantity, Dep_Num) "
        			+ "VALUES (?, ?, ?)";
        	try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStatementInventory)) {
        		System.out.println("Now adding to Inventory table.");
            	System.out.println("\t Please insert SKU");
            	int SKU = scanner.nextInt();
            	
            	System.out.println("\t Please insert Quantity");
            	int Quantity = scanner.nextInt();
            	scanner.nextLine();
            	System.out.println("\t Please insert Department Number");
            	int Dep_Num = scanner.nextInt();
            	scanner.nextLine();
            	preparedStatement.setInt(1, SKU);
            	preparedStatement.setInt(2, Quantity);
            	preparedStatement.setInt(3, Dep_Num);
            	int rowChanges = preparedStatement.executeUpdate();
            	if(rowChanges > 0) {
            		 System.out.println("Data inserted!");
            	} else {
                    System.out.println("Error inserting data.");
                }
        	}catch (SQLException e) {
        		e.printStackTrace();
        	}
        }else {
        	System.out.println("Invalid input please try again.");
        }
        
        System.out.println("Would you like to add another piece of data?. If so type Yes if not then No");
        input = scanner.next();
        if(input.equals("Yes")) {
        	addData(connection);
        }else{
        	System.out.println("Exiting data adding.");
        }
    }
    /**
     * This function will allow the user to edit data on the SQL DB by asking which table to edit on, what type of data
     * to edit, and what the updated element is. In addition, it should follow up with asking the user if they would
     * like to edit another piece of data on the DB.
     */
    @Override
    public void editData(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the table you want to edit data in: ");
            String tableName = scanner.nextLine().trim();

            System.out.print("Enter the column name to update: ");
            String columnName = scanner.nextLine().trim();

            System.out.print("Enter the new value: ");
            String newValue = scanner.nextLine().trim();

            System.out.print("Enter the condition to locate the row(s) to update: ");
            String condition = scanner.nextLine().trim();

            String updateQuery = "UPDATE " + tableName + " SET " + columnName + " = ? WHERE " + condition;

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newValue);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    
    private static boolean isValidTable(String input) {
        return input.equalsIgnoreCase("Department") ||
               input.equalsIgnoreCase("Employee") ||
               input.equalsIgnoreCase("Product") ||
               input.equalsIgnoreCase("Exports") ||
               input.equalsIgnoreCase("Inventory");
    }
    
    
    /**
     * This function will allow the user to search for specific data in the SQL DB. The function should ask what table
     * to search, and what the search requirements are. It should then display the found results.
     */
    @Override
    public void searchData(Connection connection) {
        System.out.print("Which table would you like to search in? ");
        System.out.println("Valid Tables: Department, Employee, Product, Exports, and Inventory");

        Scanner scanner = new Scanner(System.in);
        String tableInput = scanner.nextLine();

        while (!isValidTable(tableInput)){
            System.out.println("Enter table name: ");
            tableInput = scanner.nextLine();
            
            if (!isValidTable(tableInput)) {
                System.out.println("Invalid input. Please try again." + isValidTable(tableInput));
            }

        } 

        
        System.out.println("Please enter a condition to search for.");
        System.out.println("\t Ex. Dep_Num = 0");
        System.out.println("\t Ex. First_Name = Bob");
        String condition = scanner.nextLine();

        String sqlStatement = "SELECT * FROM " + tableInput + " WHERE " + condition;
        
        
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
            System.out.println("Now searching " + tableInput + " table.");
           

            
            switch (tableInput) {
                case "Department":
                    sqlStatement = "SELECT * FROM Department WHERE " + condition;
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (!resultSet.isBeforeFirst()) {
                            System.out.println("No data found for the given condition.");
                        } else {
                            while (resultSet.next()) {
                            	int depNum = resultSet.getInt("Dep_Num");
                                String depName = resultSet.getString("Dep_Name");
                                String officeAddress = resultSet.getString("Office_address");
                                String depManager = resultSet.getString("Dep_Manager");

                                System.out.println("Department Number: " + depNum);
                                System.out.println("Department Name: " + depName);
                                System.out.println("Office Address: " + officeAddress);
                                System.out.println("Department Manager: " + depManager);
                                System.out.println("---------------");
                            }
                        }
                    }
                    break;
                case "Employee":
                    sqlStatement = "SELECT * FROM Employee WHERE " + condition;
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (!resultSet.isBeforeFirst()) {
                            System.out.println("No data found for the given condition.");
                        } else {
                            while (resultSet.next()) {
                            	int Emp_ID = resultSet.getInt("Emp_ID");
                            	int SSN = resultSet.getInt("SSN");
                                String First_Name = resultSet.getString("First_Name");
                                String Last_Name = resultSet.getString("Last_Name");
                                String Address = resultSet.getString("Address");
                                int Dep_Num = resultSet.getInt("Dep_Num");
                                
                                
                                System.out.println("Employee ID: " + Emp_ID);
                                System.out.println("SSN: " + SSN);
                                System.out.println("First Name: " + First_Name);
                                System.out.println("Last Name: " + Last_Name);
                                System.out.println("Addresss: " + Address);
                                System.out.println("Department Number: " + Dep_Num);
                                System.out.println("---------------");
                            }
                        }
                    }
                    break;
                case "Product":
                    sqlStatement = "SELECT * FROM Product WHERE " + condition;
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (!resultSet.isBeforeFirst()) {
                            System.out.println("No data found for the given condition.");
                        } else {
                            while (resultSet.next()) {
                            	int SKU = resultSet.getInt("SKU");
                                String Product_Name = resultSet.getString("Product_Name");
                                String Product_Description = resultSet.getString("Product_Description");

                                System.out.println("SKU: " + SKU);
                                System.out.println("Product Name: " + Product_Name);
                                System.out.println("Product Description: " + Product_Description);
                                System.out.println("---------------");
                            }
                        }
                    }
                    break;
                case "Exports":
                    sqlStatement = "SELECT * FROM Exports WHERE " + condition;
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (!resultSet.isBeforeFirst()) {
                            System.out.println("No data found for the given condition.");
                        } else {
                            while (resultSet.next()) {
                            	int Order_No = resultSet.getInt("SKU");
                            	int Dep_Num_Exports = resultSet.getInt("Dep_Num");
                            	int SKU_Exports = resultSet.getInt("SKU");
                            	int Quantity = resultSet.getInt("Quantity");

                                System.out.println("Order Number: " + Order_No);
                                System.out.println("Department Number: " + Dep_Num_Exports);
                                System.out.println("SKU: " + SKU_Exports);
                                System.out.println("Quantity: " + Quantity);
                                System.out.println("---------------");
                            }
                        }
                    }
                    break;
                case "Inventory":
                    sqlStatement = "SELECT * FROM Inventory WHERE " + condition;
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (!resultSet.isBeforeFirst()) {
                            System.out.println("No data found for the given condition.");
                        } else {
                            while (resultSet.next()) {
                            	int SKU_Inventory = resultSet.getInt("SKU");
                            	int Quantity_Inventory = resultSet.getInt("Quantity");
                            	int Dep_Num_Inventory = resultSet.getInt("Dep_Num");

                                System.out.println("SKU: " + SKU_Inventory);
                                System.out.println("Quantity: " + Quantity_Inventory);
                                System.out.println("Department Number: " + Dep_Num_Inventory);
                                System.out.println("---------------");
                                
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid table name.");
                    return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This function will allow the user to delete data from the SQL DB by asking which table to delete from, what type
     * of data to delete, and what the element is. In addition, it should follow up with asking the user if they would
     * like to delete another piece of data from the DB.
     */
    @Override
    public void deleteData(Connection connection)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the table from which you want to delete data: ");
            String tableName = scanner.nextLine().trim();

            System.out.print("Enter the condition to locate the row(s) to delete: ");
            String condition = scanner.nextLine().trim();

            String deleteQuery = "DELETE FROM " + tableName + " WHERE " + condition;

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " row(s) deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    /**
     * This function will allow the user to list data from certain tables and in specified ranges. It should display the
     * results nicely.
     */
    @Override
    public void listData(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the table name you want to list data from: ");
            String tableName = scanner.nextLine().trim();

            System.out.print("Enter the number of rows you want to fetch: ");
            int numRows = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            String selectQuery = "SELECT * FROM " + tableName + " LIMIT ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setInt(1, numRows);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Print column headers
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(metaData.getColumnLabel(i) + "\t");
                    }
                    System.out.println();

                    // Print rows
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
