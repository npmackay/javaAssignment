import entities.database;
import java.sql.Connection;
import java.util.List;

import entities.City;
import entities.Country;

import daos.*;

/*Github link -->  */
public class App {
  public static void main(String[] args) throws Exception {
    Connection connection = database.dbConnect();
    CountryDao countryDao = new CountryDao(connection);
    CityDao citydao = new CityDao(connection);
    Country myCountry = new Country();
    myCountry.setCode("SU");
    myCountry.setName("States United");
    myCountry.setContinent("North America");
    myCountry.setRegion("Western USA");
    myCountry.setLocalName("USA");
    myCountry.setGovermentForm("Constitutional republic");
    myCountry.setHeadOfState("President");
    myCountry.setCapital("Malto");
    myCountry.setCode2("SUA");
    myCountry.setSurfaceArea(9.8f);
    myCountry.setLifeExpectancy(78.9f);
    myCountry.setGNP(21.4f);
    myCountry.setGNPOld(19.4f);
    myCountry.setIndepYear(1776);
    myCountry.setPopulation(328_200_000);

    /*
     * Country Find all function
     * List<Country> countryList = countryDao.findAll();
     * for(Country country : countryList)
     * {
     * System.out.println(country) ;
     * }
     */

    /*
     * Country Find by ID function
     * System.out.println(countryDao.findById("CAN"));
     */

    /*
     * Country Update Function
     * if(countryDao.update(myCountry))
     * {
     * System.out.println("OBJECT ADDED");
     * }
     * else
     * {
     * System.out.println("OBJECT FAILED TO ADD");
     * }
     */

    /*
     * Country Delete function
     * if (countryDao.delete(myCountry.getCode())) {
     * System.out.println("OBJECT DELETED");
     * } else {
     * System.out.println("OBJECT FAILED TO DELETE");
     * };
     */

    /*
     * City find by name function
     * System.out.println(citydao.findByName("Kabul"));
     */
    /*
     * City find by countrycode
     * List<City> cities = citydao.findCitiesByCountryCode("USA");
     * 
     * for(City city : cities)
     * {
     * System.out.println(city) ;
     * }
     */
    /*
     * City find Populaton over a million
     * List<City> cityPop = citydao.largePopulation();
     * for(City city : cityPop)
     * {
     * System.out.println(city) ;
     * }
     */
    /*
     * Country find by Name
     * System.out.println(countryDao.findByName("Canada"));
     */

    /* Country find by region */
    List<Country> countriesInEurope = countryDao.findByRegion("North America");

    for (Country region : countriesInEurope) {
      System.out.println(region);
    }

  }
}