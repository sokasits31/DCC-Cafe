package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type User test history.
 */
@Entity (name= "TestHistory")     // Class Name
@Table (name= "testHistory")      // Table Name
public class TestHistory {

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

    @Column (name="frequency_order")
    private int frequencyOrder;

    @Column (name="random_number")
    private double randomNumber;

    @Column (name="short_hand")
    private String shortHand;

    @Column (name="menu_Category")
    private String menuCategory;

    @Column (name="response_time_in_sec")
    private int responseTimeInSec;

    @Column (name="response_status")
    private String responseStatus;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "testHistory_user_id_fk")
    )
    private User user;

    /**
     * Instantiates a new Test history.
     */
    public TestHistory() {
    }

    /**
     * Instantiates a new Test history.
     *
     * @param menuItemId        the menu item id
     * @param description       the description
     * @param altDescription    the alt description
     * @param frequencyOrder    the frequency order
     * @param randomNumber      the random number
     * @param shortHand         the short hand
     * @param menuCategory      the menu category
     * @param responseTimeInSec the response time in sec
     * @param responseStatus    the response status
     */
    public TestHistory(int menuItemId, String description, String altDescription, int frequencyOrder, double randomNumber, String shortHand, String menuCategory, int responseTimeInSec, String responseStatus) {
        this.menuItemId = menuItemId;
        this.description = description;
        this.altDescription = altDescription;
        this.frequencyOrder = frequencyOrder;
        this.randomNumber = randomNumber;
        this.shortHand = shortHand;
        this.menuCategory = menuCategory;
        this.responseTimeInSec = responseTimeInSec;
        this.responseStatus = responseStatus;
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

    /**
     * Gets menu category.
     *
     * @return the menu category
     */
    public String getMenuCategory() {
        return menuCategory;
    }

    /**
     * Sets menu category.
     *
     * @param menuCategory the menu category
     */
    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    /**
     * Gets response time in sec.
     *
     * @return the response time in sec
     */
    public int getResponseTimeInSec() {
        return responseTimeInSec;
    }

    /**
     * Sets response time in sec.
     *
     * @param responseTimeInSec the response time in sec
     */
    public void setResponseTimeInSec(int responseTimeInSec) {
        this.responseTimeInSec = responseTimeInSec;
    }

    /**
     * Gets response status.
     *
     * @return the response status
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets response status.
     *
     * @param responseStatus the response status
     */
    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TestHistory{" +
                "id=" + id +
                ", menuItemId=" + menuItemId +
                ", description='" + description + '\'' +
                ", altDescription='" + altDescription + '\'' +
                ", frequencyOrder=" + frequencyOrder +
                ", randomNumber=" + randomNumber +
                ", shortHand='" + shortHand + '\'' +
                ", menuCategory='" + menuCategory + '\'' +
                ", responseTimeInSec=" + responseTimeInSec +
                ", responseStatus='" + responseStatus + '\'' +
                '}';
    }
}
