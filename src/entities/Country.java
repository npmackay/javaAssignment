package entities;

//Country class to store the Country entity form the world database
public class Country {
    String code;
    String name;
    String continent;
    String region;
    String localName;
    String govermentForm;
    String headOfState;
    String capital;

    String code2;
    Float surfaceArea;
    Float lifeExpectancy;
    Float GNP;
    Float GNPOld;

    Integer indepYear;
    Integer population;

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region
                + ", localName=" + localName + ", govermentForm=" + govermentForm + ", headOfState=" + headOfState
                + ", capital=" + capital + ", code2=" + code2 + ", surfaceArea=" + surfaceArea + ", lifeExpectancy="
                + lifeExpectancy + ", GNP=" + GNP + ", GNPOld=" + GNPOld + ", indepYear=" + indepYear + ", population="
                + population + "]";
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovermentForm() {
        return govermentForm;
    }

    public void setGovermentForm(String govermentForm) {
        this.govermentForm = govermentForm;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Float getGNP() {
        return GNP;
    }

    public void setGNP(Float gNP) {
        GNP = gNP;
    }

    public Float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(Float gNPOld) {
        GNPOld = gNPOld;
    }

    public Integer getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

}
