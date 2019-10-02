package dzialki;

public class Dzialka {
private String name;
private String link;
private String phone;
private String email;
private String localization;
private double price;
private double getSizeOfArea;


    public Dzialka (DzialkaBuilder dzialkaBuilder){
    this.name = dzialkaBuilder.name;
    this.link = dzialkaBuilder.link;
    this.price = dzialkaBuilder.price;
    this.localization = dzialkaBuilder.localization;
    this.phone = dzialkaBuilder.phone;
    this.email = dzialkaBuilder.email;
    this.getSizeOfArea = dzialkaBuilder.getSizeOfArea;
    }

    public String getName() {
        return name;
    }
    public String getLink() {
        return link;
    }
    public String getLocalization() {
        return localization;
    }
    public double getPrice() {
        return price;
    }

public static class DzialkaBuilder{
        private String name;
        private String link;
        private String phone;
        private String email;
        private String localization;
        private double price;
        private double getSizeOfArea;

        public DzialkaBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public DzialkaBuilder setLink(String link) {
            this.link = link;
            return this;
        }

        public DzialkaBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public DzialkaBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public DzialkaBuilder setLocalization(String localization) {
            this.localization = localization;
            return this;
        }

        public DzialkaBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public DzialkaBuilder setGetSizeOfArea(double getSizeOfArea) {
            this.getSizeOfArea = getSizeOfArea;
            return this;
        }
        public Dzialka build(){
            return new Dzialka (this);
        }



}

}

