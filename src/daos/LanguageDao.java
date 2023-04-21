package daos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Language;
import java.sql.Statement;
import entities.Language.PK;

//LanguageDao class to query data from the Language entity from world database

public class LanguageDao implements Dao<Language, Language.PK>{

    Connection connection;
    public LanguageDao(Connection connection)
    
    {
        this.connection = connection;
    }

    public List<Language> findAll()
    {
        List<Language> languageList = new ArrayList<>();
        try(Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery("SELECT * FROM CountryLanguage");
            while(result.next())
            {
                Language language = new Language(

                result.getString("CountryCode"),
                result.getString("Language"),
                result.getBoolean("isOfficial"),
                result.getFloat("Percentage"));

                languageList.add(language);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return languageList;
    }

    
    public Language findById(PK pk) {
        return null;
    }

    
    public void insert(Language item) {
        
    }

    
    public Boolean update(Language item) {
        Boolean success = true;
        return success;
    }

    
    public Boolean delete(PK pk) {
        return false;
    }

    
}
