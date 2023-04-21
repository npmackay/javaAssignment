package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.City;

//CityDao class to query data from the City entity from world database

public class CityDao implements Dao<City, Integer> {
    Connection connection;

    public CityDao(Connection connection) {
        this.connection = connection;
    }

    // implementation for findAll()
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM city");

            while (result.next()) {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return cities;
    }

    public void insert(City city) {

        try (Statement statement = connection.createStatement()) {
            String insert = "INSERT INTO city VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, city.getName());
            ps.setString(3, city.getCountryCode());
            ps.setString(4, city.getDistrict());
            ps.setInt(5, city.getPopulation());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                city.setID(keys.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Boolean update(City city) {
        Boolean success = true;
        String update = "UPDATE city SET population=? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(update);) {
            ps.setInt(1, city.getPopulation());
            ps.setInt(2, city.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    public City findById(Integer pk) {
        City city = new City();

        String select = "SELECT * FROM city WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select);) {
            preparedStatement.setInt(1, pk);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                city.setID(result.getInt("ID"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return city;
    }

    public Boolean delete(Integer pk) {
        Boolean success = false;
        String delete = "delete city WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, pk);
            if (ps.executeUpdate() != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return success;
    }

    /***
     * 
     * @param pk
     * @return
     */

    public City findByName(String pk) {

        String select = "SELECT * FROM city WHERE name=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select);) {
            preparedStatement.setString(1, pk);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                city.setID(result.getInt("ID"));
                return city;
            } else {
                System.out.println("No city found for id: " + pk);
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /***
     * 
     * @param countryCode
     * @return
     */
    public List<City> findCitiesByCountryCode(String countryCode) {
        List<City> cities = new ArrayList<>();
        String select = "SELECT * FROM city WHERE CountryCode=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select);) {
            preparedStatement.setString(1, countryCode);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                City city = new City();
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cities;

    }

    /***
     * 
     * @return
     */
    public List<City> largePopulation() {
        List<City> cities = new ArrayList<>();
        String select = "SELECT * FROM city WHERE Population > 1000000";
        try (PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                City city = new City();
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return cities;
    }

}
