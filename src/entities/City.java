package entities;

//City class to store the City entity form the world database
public class City {
    Integer ID; // PK on the table city database World in workbench
    String Name;
    String CountryCode;
    String District;
    Integer Population;

    // Creat getters and setters for ID, Name, CountryCode, District, Population
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countrycode) {
        CountryCode = countrycode;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    @Override
    public String toString() {
        return "City [CountryCode = " + CountryCode + ",District = " + District +
                ", ID =" + ID + ", Name = " + Name + ",Population = " + Population + "]";
    }
}
