package ourtunes.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**

 * 
 * @author Xmdag
 *
 */

//The DatabaseConnection class contains the code for connecting to the Database, being able to get values from it
public class DatabaseConnection {
    
    private static final String PROP_FILE = "data/connectionInfo.properties";
    private SQLServerDataSource ds;
    
    /**
     * Creates a connection with the database.
     */
    public DatabaseConnection()
    {
        try
        {
            Properties databaseProperties = new Properties();
            databaseProperties.load(new FileInputStream(PROP_FILE));
            ds = new SQLServerDataSource();
            ds.setServerName(databaseProperties.getProperty("Server"));
            ds.setDatabaseName(databaseProperties.getProperty("Database"));
            ds.setUser(databaseProperties.getProperty("User"));
            ds.setPassword(databaseProperties.getProperty("Password"));
        }
        catch(IOException e)
        {
            
        }
    }
    
    //Returns Connection object which is able to provide information about the Database.
     
    public Connection getConnection() throws SQLServerException
    {
        return ds.getConnection();
    }
}