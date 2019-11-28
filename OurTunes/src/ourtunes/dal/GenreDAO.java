/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ourtunes.dal;

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
<<<<<<< Updated upstream
import ourtunes.be.Genre;
=======
>>>>>>> Stashed changes
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
//Gets All songs from the database
    public List<Genre> getAllGeners() throws SQLException
    {
<<<<<<< Updated upstream
        String sqlStatement = "SELECT * FROM Genres";
        List<Genre>allGenres = new ArrayList();
=======
        String sqlStatement = "SELECT * FROM Geners";
        List<Genre> allGens = new ArrayList();
>>>>>>> Stashed changes
        try(Connection con = connector.getConnection();
                PreparedStatement statement = con.prepareStatement(sqlStatement))
        {

            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                int genre_ID = rs.getInt("genre_ID");
                String genre_name = rs.getString("genre_name");
<<<<<<< Updated upstream
                allGenres.add(new Genre(genre_ID, genre_name));
=======
                allGenres.add(new Genre(Genre_ID, Genre_name));
>>>>>>> Stashed changes
            }
        }
        return allGenres;
    }
<<<<<<< Updated upstream
    }
=======
    }

>>>>>>> Stashed changes
