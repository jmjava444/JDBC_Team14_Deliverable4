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

import java.io.*;
import java.sql.*;

public class JDBCDriver implements JDBCDriverInterface
{
    /**
     * This function will allow the user to add data to the SQL DB by asking which table to add to, what type of data
     * to add, and what the element is. In addition, it should follow up with asking the user if they would like to add
     * another piece of data to the DB.
     */
    @Override
    public void addData()
    {
        
    }
    /**
     * This function will allow the user to edit data on the SQL DB by asking which table to edit on, what type of data
     * to edit, and what the updated element is. In addition, it should follow up with asking the user if they would
     * like to edit another piece of data on the DB.
     */
    @Override
    public void editData()
    {

    }
    /**
     * This function will allow the user to search for specific data in the SQL DB. The function should ask what table
     * to search, and what the search requirements are. It should then display the found results.
     */
    @Override
    public void searchData()
    {

    }
    /**
     * This function will allow the user to delete data from the SQL DB by asking which table to delete from, what type
     * of data to delete, and what the element is. In addition, it should follow up with asking the user if they would
     * like to delete another piece of data from the DB.
     */
    @Override
    public void deleteData()
    {

    }
    /**
     * This function will allow the user to list data from certain tables and in specified ranges. It should display the
     * results nicely.
     */
    @Override
    public void listData()
    {

    }
}
