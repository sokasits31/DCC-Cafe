package com.doorCreekCafe.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Menu catagory.
 */
@Entity(name= "MenuCatagory")     // Class Name
@Table(name= "menuCatagory")      // Table Name
public class MenuCatagory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name="description")
    private String catagoryDescription;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Menu> MenuItems = new HashSet<>();

    /**
     * Instantiates a new Menu catagory.
     */
    public MenuCatagory() {
    }

    /**
     * Instantiates a new Menu catagory.
     *
     * @param id           the id
     * @param catagoryDescription the catagory name
     */
    public MenuCatagory(int id, String catagoryDescription) {
        this.id = id;
        this.catagoryDescription = catagoryDescription;
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
     * Gets catagory name.
     *
     * @return the catagory name
     */
    public String getCatagoryName() {
        return catagoryDescription;
    }

    /**
     * Sets catagory name.
     *
     * @param catagoryDescription the catagory name
     */
    public void setCatagoryName(String catagoryDescription) {
        this.catagoryDescription = catagoryDescription;
    }

    @Override
    public String toString() {
        return "MenuCatagory{" +
                "id=" + id +
                ", catagoryDescription='" + catagoryDescription + '\'' +
                '}';
    }
}
