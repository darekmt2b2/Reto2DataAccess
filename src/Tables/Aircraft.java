package Tables;

public class Aircraft {
    private int id;
    private String model;
    private String series;
    private String manufacturer;

    public Aircraft(int id, String model, String series, String manufacturer) {
        this.id = id;
        this.model = model;
        this.series = series;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", model='" + model + '\'' +
                ", series='" + series + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
