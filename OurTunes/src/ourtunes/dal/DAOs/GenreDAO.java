/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal.DAOs;

import java.util.ArrayList;
import java.util.List;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ourtunes.dal.DatabaseConnection;
import ourtunes.dal.DatabaseConnection;

/**
 *
 * @author XMdag
 */
public class GenreDAO {
    
private DatabaseConnection connector;


public GenreDAO()
{
connector = new DatabaseConnection();
}

//Gets a list with names of all genres from the database.

public List<String> getAllGenres() throws SQLException
    {
        List<String> allGenres = new ArrayList();
        String sqlStatement = "SELECT * FROM Genres";
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                allGenres.add(rs.getString("genreName"));
            }
            return allGenres;
        }
    }
}