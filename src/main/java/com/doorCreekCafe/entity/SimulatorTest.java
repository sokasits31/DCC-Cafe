package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type User test history.
 */
@Entity (name= "SimulatorTest")     // Class Name
@Table (name= "simulatorTest")      // Table Name
public class SimulatorTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name="item_id")
    private int menuItemId;

    @Column (name="description")
    private String description;

    @Column (name="alt_description")
    private String altDescription;

    @Column (name="frequency_level")
    private String frequencyLevel;

    @Column (name="frequency_order")
    private int frequencyOrder;

    @Column (name="random_number")
    private double randomNumber;

    @Column (name="short_hand")
    private String shortHand;

    /**
     * Instantiates a new Simulator test.
     */
    public SimulatorTest() {
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
     * Gets menu item id.
     *
     * @return the menu item id
     */
    public int getMenuItemId() {
        return menuItemId;
    }

    /**
     * Sets menu item id.
     *
     * @param menuItemId the menu item id
     */
    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
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
     * Gets alt description.
     *
     * @return the alt description
     */
    public String getAltDescription() {
        return altDescription;
    }

    /**
     * Sets alt description.
     *
     * @param altDescription the alt description
     */
    public void setAltDescription(String altDescription) {
        this.altDescription = altDescription;
    }

    /**
     * Gets frequency level.
     *
     * @return the frequency level
     */
    public String getFrequencyLevel() {
        return frequencyLevel;
    }

    /**
     * Sets frequency level.
     *
     * @param frequencyLevel the frequency level
     */
    public void setFrequencyLevel(String frequencyLevel) {
        this.frequencyLevel = frequencyLevel;
    }

    /**
     * Gets frequency order.
     *
     * @return the frequency order
     */
    public int getFrequencyOrder() {
        return frequencyOrder;
    }

    /**
     * Sets frequency order.
     *
     * @param frequencyOrder the frequency order
     */
    public void setFrequencyOrder(int frequencyOrder) {
        this.frequencyOrder = frequencyOrder;
    }

    /**
     * Gets random number.
     *
     * @return the random number
     */
    public double getRandomNumber() {
        return randomNumber;
    }

    /**
     * Sets random number.
     *
     * @param randomNumber the random number
     */
    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    /**
     * Gets short hand.
     *
     * @return the short hand
     */
    public String getShortHand() {
        return shortHand;
    }

    /**
     * Sets short hand.
     *
     * @param shortHand the short hand
     */
    public void setShortHand(String shortHand) {
        this.shortHand = shortHand;
    }

    @Override
    public String toString() {
        return "SimulatorTest{" +
                "id=" + id +
                ", menuItemId=" + menuItemId +
                ", description='" + description + '\'' +
                ", altDescription='" + altDescription + '\'' +
                ", frequencyLevel='" + frequencyLevel + '\'' +
                ", frequencyOrder=" + frequencyOrder +
                ", randomNumber=" + randomNumber +
                ", shortHand='" + shortHand + '\'' +
                '}';
    }
}
