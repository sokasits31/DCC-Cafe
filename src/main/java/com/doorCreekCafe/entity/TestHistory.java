package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column (name="user_id")
    private int userId;

    @Column (name="menu_id")
    private int menuId;

    @Column (name="response_time_seconds")
    private int responseTimeSeconds;

    @Column (name="status")
    private String status;

    @Column (name="menu_item_description")
    private String menuItemDescription;

    /**
     * Instantiates a new Test history.
     */
    public TestHistory() {
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
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets menu id.
     *
     * @return the menu id
     */
    public int getMenuId() {
        return menuId;
    }

    /**
     * Sets menu id.
     *
     * @param menuId the menu id
     */
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    /**
     * Gets response time seconds.
     *
     * @return the response time seconds
     */
    public int getResponseTimeSeconds() {
        return responseTimeSeconds;
    }

    /**
     * Sets response time seconds.
     *
     * @param responseTimeSeconds the response time seconds
     */
    public void setResponseTimeSeconds(int responseTimeSeconds) {
        this.responseTimeSeconds = responseTimeSeconds;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets menu item description.
     *
     * @return the menu item description
     */
    public String getMenuItemDescription() {
        return menuItemDescription;
    }

    /**
     * Sets menu item description.
     *
     * @param menuItemDescription the menu item description
     */
    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }

    @Override
    public String toString() {
        return "TestHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", menuId=" + menuId +
                ", responseTimeSeconds=" + responseTimeSeconds +
                ", status='" + status + '\'' +
                ", menuItemDescription='" + menuItemDescription + '\'' +
                '}';
    }
}
