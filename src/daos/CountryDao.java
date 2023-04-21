package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.Country;

public class CountryDao implements Dao<Country, String> {
    Connection connection;

    public CountryDao(Connection connection) {
        this.connection = connection;
    }

    // implementation for findAll()
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM country");

            while (result.next()) {
                Country country = new Country();

                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovermentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getString("Capital"));
                country.setCode2(result.getString("Code2"));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return countries;
    }

    @Override
    public Country findById(String pk) {

        String select = "SELECT * FROM country WHERE code=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select);) {
            preparedStatement.setString(1, pk);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovermentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getString("Capital"));
                country.setCode2(result.getString("Code2"));
                return country;
            } else {
                System.out.println("No country found for id: " + pk);
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void insert(Country item) {
        String insert = "INSERT INTO country VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            Country country = new Country();
            preparedStatement.setString(1, country.getCode());
            preparedStatement.setString(2, country.getName());
            preparedStatement.setString(3, country.getContinent());
            preparedStatement.setString(4, country.getRegion());
            preparedStatement.setFloat(5, country.getSurfaceArea());
            preparedStatement.setInt(6, country.getIndepYear());
            preparedStatement.setInt(7, country.getPopulation());
            preparedStatement.setFloat(8, country.getLifeExpectancy());
            preparedStatement.setFloat(9, country.getGNP());
            preparedStatement.setFloat(10, country.getGNPOld());
            preparedStatement.setString(11, country.getLocalName());
            preparedStatement.setString(12, country.getGovermentForm());
            preparedStatement.setString(13, country.getHeadOfState());
            preparedStatement.setString(14, country.getCapital());
            preparedStatement.setString(15, country.getCode2());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Number of records added = " + rowsAffected);

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
    }

    @Override
    public Boolean update(Country country) {
        String update = "UPDATE country SET Name=?, Continent=?, Region=?, SurfaceArea=?, IndepYear=?, Population=?, LifeExpectancy=?, GNP=?, GNPOld=?, LocalName=?, GovernmentForm=?, HeadOfState=?, Capital=?, Code2=? WHERE Code=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getContinent());
            preparedStatement.setString(3, country.getRegion());
            preparedStatement.setFloat(4, country.getSurfaceArea());
            preparedStatement.setInt(5, country.getIndepYear());
            preparedStatement.setInt(6, country.getPopulation());
            preparedStatement.setFloat(7, country.getLifeExpectancy());
            preparedStatement.setFloat(8, country.getGNP());
            preparedStatement.setFloat(9, country.getGNPOld());
            preparedStatement.setString(10, country.getLocalName());
            preparedStatement.setString(11, country.getGovermentForm());
            preparedStatement.setString(12, country.getHeadOfState());
            preparedStatement.setString(13, country.getCapital());
            preparedStatement.setString(14, country.getCode2());
            preparedStatement.setString(15, country.getCode());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
 
    @Override
    public Boolean delete(String pk) {
        Boolean success = false;
        String delete = "delete country WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setString(1, pk);
            if (ps.executeUpdate() != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    /***
     * find a country by its name
     * @param name a string that contains the countrys name
     * @return a country object thats name is equal to the one passed to the function
     */
    public Country findByName(String name) {
        Country country = null;
        String select = "SELECT * FROM country WHERE Name=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovermentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getString("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return country;
    }

    /**
     * find any country in a certain region
     * @param region pass a string with a region inside
     * @return a list of countries that are within the passed region
     */
    public List<Country> findByRegion(String region) {
        List<Country> countries = new ArrayList<>();
        String select = "SELECT * FROM country WHERE Region=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            preparedStatement.setString(1, region);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getFloat("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getFloat("LifeExpectancy"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovermentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getString("Capital"));
                country.setCode2(result.getString("Code2"));
                countries.add(country);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return countries;
    }
}
