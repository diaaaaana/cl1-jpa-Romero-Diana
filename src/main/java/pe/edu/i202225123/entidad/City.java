package pe.edu.i202225123.entidad;

import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Name;
    private String District;
    private int Population;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

    public City(){
    }

    public City(Integer ID, String name, String district, int population, Country country) {
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
        this.country = country;
    }

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

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "city{" +
                "Population=" + Population +
                ", District='" + District + '\'' +
                ", Name='" + Name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
