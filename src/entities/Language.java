package entities;

//Language class to store the Language entity form the world database
public class Language {
    PK countryLanguage;// primary key from database countylanguage
    Boolean isOfficial;
    Float percentage;

    public Language(String code, String language, Boolean isOfficial, Float percentage) {
        countryLanguage = new PK(code, language);
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public static class PK {
        // add constructor with 2 filed being passed and initialize it
        public PK(String countryCode, String language) {
            this.countryCode = countryCode;
            this.language = language;
        }

        String countryCode;
        String language;
    }

    @Override
    public String toString() {
        return "countryCode: " + countryLanguage.countryCode +
                ",isOfficial:" + isOfficial + ",percentage" + percentage + "Language" + countryLanguage.language;
    }

}
