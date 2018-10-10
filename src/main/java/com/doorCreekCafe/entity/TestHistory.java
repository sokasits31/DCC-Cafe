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

    @Column (name="test_date")
    private LocalDate testDate;

    @Column (name="test_level")
    private int testLevel;

    @Column (name="menu_id_tested")
    private int menuIdTested;

    @Column (name="response_time")
    private LocalDate responseTime;

    /**
     * Instantiates a new User test history.
     */
    public TestHistory() {
    }

    /**
     * Instantiates a new User test history.
     *
     * @param id           the id
     * @param userId       the user id
     * @param testDate     the test date
     * @param testLevel    the test level
     * @param menuIdTested the menu id tested
     * @param responseTime the response time
     */
    public TestHistory(int id, int userId, LocalDate testDate, int testLevel, int menuIdTested, LocalDate responseTime) {
        this.id = id;
        this.userId = userId;
        this.testDate = testDate;
        this.testLevel = testLevel;
        this.menuIdTested = menuIdTested;
        this.responseTime = responseTime;
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
     * Gets test date.
     *
     * @return the test date
     */
    public LocalDate getTestDate() {
        return testDate;
    }

    /**
     * Sets test date.
     *
     * @param testDate the test date
     */
    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    /**
     * Gets test level.
     *
     * @return the test level
     */
    public int getTestLevel() {
        return testLevel;
    }

    /**
     * Sets test level.
     *
     * @param testLevel the test level
     */
    public void setTestLevel(int testLevel) {
        this.testLevel = testLevel;
    }

    /**
     * Gets menu id tested.
     *
     * @return the menu id tested
     */
    public int getMenuIdTested() {
        return menuIdTested;
    }

    /**
     * Sets menu id tested.
     *
     * @param menuIdTested the menu id tested
     */
    public void setMenuIdTested(int menuIdTested) {
        this.menuIdTested = menuIdTested;
    }

    /**
     * Gets response time.
     *
     * @return the response time
     */
    public LocalDate getResponseTime() {
        return responseTime;
    }

    /**
     * Sets response time.
     *
     * @param responseTime the response time
     */
    public void setResponseTime(LocalDate responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "UserTestHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", testDate=" + testDate +
                ", testLevel=" + testLevel +
                ", menuIdTested=" + menuIdTested +
                ", responseTime=" + responseTime +
                '}';
    }
}
