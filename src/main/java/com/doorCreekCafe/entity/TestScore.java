package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The type User test history.
 */
@Entity (name= "TestScore")     // Class Name
@Table (name= "testScore")      // Table Name
public class TestScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name="test_date")
    private LocalDate testDate;

    @Column (name="test_level")
    private int testLevel;

    @Column (name="menu_id_tested")
    private int menuIdTested;

    @Column (name="response_time")
    private int responseTimeInSeconds;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Test history.
     */
    public TestScore() {
    }

    /**
     * Instantiates a new Test history.
     *
     * @param testDate              the test date
     * @param testLevel             the test level
     * @param menuIdTested          the menu id tested
     * @param responseTimeInSeconds the response time in seconds
     * @param user                  the user
     */
    public TestScore(LocalDate testDate, int testLevel, int menuIdTested, int responseTimeInSeconds, User user) {
        this.testDate = testDate;
        this.testLevel = testLevel;
        this.menuIdTested = menuIdTested;
        this.responseTimeInSeconds = responseTimeInSeconds;
        this.user = user;
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
     * Gets response time in seconds.
     *
     * @return the response time in seconds
     */
    public int getResponseTimeInSeconds() {
        return responseTimeInSeconds;
    }

    /**
     * Sets response time in seconds.
     *
     * @param responseTimeInSeconds the response time in seconds
     */
    public void setResponseTimeInSeconds(int responseTimeInSeconds) {
        this.responseTimeInSeconds = responseTimeInSeconds;
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
        return "TestScore{" +
                "id=" + id +
                ", testDate=" + testDate +
                ", testLevel=" + testLevel +
                ", menuIdTested=" + menuIdTested +
                ", responseTimeInSeconds=" + responseTimeInSeconds +
                ", user=" + user +
                '}';
    }
}
