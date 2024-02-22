package ser322;

public interface JDBCDriverInterface
{
    /**
     * This function will allow the user to add data to the SQL DB by asking which table to add to, what type of data
     * to add, and what the element is. In addition, it should follow up with asking the user if they would like to add
     * another piece of data to the DB.
     */
    void addData(); // TODO: change parameters or return type to suit the method.

    /**
     * This function will allow the user to edit data on the SQL DB by asking which table to edit on, what type of data
     * to edit, and what the updated element is. In addition, it should follow up with asking the user if they would
     * like to edit another piece of data on the DB.
     */
    void editData(); // TODO: change parameters or return type to suit the method.

    /**
     * This function will allow the user to search for specific data in the SQL DB. The function should ask what table
     * to search, and what the search requirements are. It should then display the found results.
     */
    void searchData(); // TODO: change parameters or return type to suit the method.

    /**
     * This function will allow the user to delete data from the SQL DB by asking which table to delete from, what type
     * of data to delete, and what the element is. In addition, it should follow up with asking the user if they would
     * like to delete another piece of data from the DB.
     */
    void deleteData(); // TODO: change parameters or return type to suit the method.

    /**
     * This function will allow the user to list data from certain tables and in specified ranges. It should display the
     * results nicely.
     */
    void listData(); // TODO: change parameters or return type to suit the method.
}
