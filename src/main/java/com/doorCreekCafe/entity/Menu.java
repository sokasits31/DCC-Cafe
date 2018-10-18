package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Menu.
 */
@Entity(name= "Menu")     // Class Name
@Table (name= "menu")      // Table Name
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="catagory")
    private String catagory;

    @Column (name="description")
    private String description;

    @Column (name="alt_description")
    private String altDescripton;

    @Column (name="price")
    private double price;

    @Column (name="frequency_level")
    private int frequencyLevel;

    @ManyToOne
    private MenuCatagory menuCatagory;
    /**
     * Instantiates a new Menu.
     */
    public Menu() {
    }

    /**
     * Instantiates a new Menu.
     *
     * @param catagory       the catagory
     * @param description    the description
     * @param altDescripton  the alt descripton
     * @param price          the price
     * @param frequencyLevel the frequency level
     */
    public Menu(String catagory, String description, String altDescripton, double price, int frequencyLevel) {
        this.catagory = catagory;
        this.description = description;
        this.altDescripton = altDescripton;
        this.price = price;
        this.frequencyLevel = frequencyLevel;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets catagory.
     *
     * @return the catagory
     */
    public String getCatagory() {
        return catagory;
    }

    /**
     * Sets catagory.
     *
     * @param catagory the catagory
     */
    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets alt descripton.
     *
     * @return the alt descripton
     */
    public String getAltDescripton() {
        return altDescripton;
    }

    /**
     * Sets alt descripton.
     *
     * @param altDescripton the alt descripton
     */
    public void setAltDescripton(String altDescripton) {
        this.altDescripton = altDescripton;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets frequency level.
     *
     * @return the frequency level
     */
    public int getFrequencyLevel() {
        return frequencyLevel;
    }

    /**
     * Sets frequency level.
     *
     * @param frequencyLevel the frequency level
     */
    public void setFrequencyLevel(int frequencyLevel) {
        this.frequencyLevel = frequencyLevel;
    }

    @Override
    public String toString() {
        return "menu{" +
                "id=" + id +
                ", catagory='" + catagory + '\'' +
                ", description='" + description + '\'' +
                ", altDescripton='" + altDescripton + '\'' +
                ", price=" + price +
                ", frequencyLevel=" + frequencyLevel +
                '}';
    }
}
