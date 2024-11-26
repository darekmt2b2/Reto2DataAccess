package Tables;

public class Airlines {

    private int ID;
    private String name;
    private String country;
    private int hub;

    public Airlines(int ID, String name, String country, int hub) {
        this.ID = ID;
        this.name = name;
        this.country = country;
        this.hub = hub;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHub() {
        return hub;
    }

    public void setHub(int hub) {
        this.hub = hub;
    }

    @Override
    public String toString() {
        return "ID=" + ID +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", hub=" + hub +
                '}';
    }
}
