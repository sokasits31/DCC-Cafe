package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    /**
     * Instance variables
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role")
    private String role;

    @Column(name = "email_address")
    private String emailAddress;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "skill_level")
    private int skillLevel;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<TestScore> testScores = new HashSet<>();


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param role         the role
     * @param emailAddress the email address
     * @param firstName    the first name
     * @param lastName     the last name
     * @param skillLevel   the skill level
     */
    public User(String role, String emailAddress, String firstName, String lastName, int skillLevel) {
        this.role = role;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillLevel = skillLevel;
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
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets skill level.
     *
     * @return the skill level
     */
    public int getSkillLevel() {
        return skillLevel;
    }

    /**
     * Sets skill level.
     *
     * @param skillLevel the skill level
     */
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * Gets test scores.
     *
     * @return the test scores
     */
    public Set<TestScore> getTestScores() {
        return testScores;
    }

    /**
     * Sets test scores.
     *
     * @param testScores the test scores
     */
    public void setTestScores(Set<TestScore> testScores) {
        this.testScores = testScores;
    }

    /**
     * Add Test Score.
     *
     * @param testScore the test score
     */
    public void addTestScore(TestScore testScore) {
        testScores.add(testScore);
        testScore.setUser(this);
    }

    /**
     * Remove Test Score.
     *
     * @param testScore the test score
     */
    public void removeTestScore(TestScore testScore) {
        testScores.remove(testScore);
        testScore.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }


    
}
