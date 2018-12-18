package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type User test history.
 */
@Entity (name= "TestParm")     // Class Name
@Table (name= "test_parm")      // Table Name
public class TestParm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name="description")
    private int description;

    @Column (name="response_time")
    private String responseTime;

    /**
     * Instantiates a new Test parm.
     */
    public TestParm() {
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
     * Gets description.
     *
     * @return the description
     */
    public int getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(int description) {
        this.description = description;
    }

    /**
     * Gets response time.
     *
     * @return the response time
     */
    public String getResponseTime() {
        return responseTime;
    }

    /**
     * Sets response time.
     *
     * @param responseTime the response time
     */
    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public String toString() {
        return "TestParm{" +
                "id=" + id +
                ", description=" + description +
                ", responseTime='" + responseTime + '\'' +
                '}';
    }
}
