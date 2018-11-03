package com.doorCreekCafe.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Menu catagory.
 */
@Entity(name= "MenuCategory")     // Class Name
@Table(name= "menuCategory")      // Table Name
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name="category_description")
    private String categoryDescription;

    @Column (name="cell_position")
    private String cellPosition;

    @OneToMany(mappedBy = "menuCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<MenuItem> menuItems = new HashSet<>();

    /**
     * Instantiates a new Menu category.
     */
    public MenuCategory() {
    }

    /**
     * Instantiates a new Menu category.
     *
     * @param categoryDescription the category description
     * @param cellPosition        the cell position
     */
    public MenuCategory(String categoryDescription, String cellPosition) {
        this.categoryDescription = categoryDescription;
        this.cellPosition = cellPosition;
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
     * Gets category description.
     *
     * @return the category description
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * Sets category description.
     *
     * @param categoryDescription the category description
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     * Gets cell position.
     *
     * @return the cell position
     */
    public String getCellPosition() {
        return cellPosition;
    }

    /**
     * Sets cell position.
     *
     * @param cellPosition the cell position
     */
    public void setCellPosition(String cellPosition) {
        this.cellPosition = cellPosition;
    }

    /**
     * Gets menu items.
     *
     * @return the menu items
     */
    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Sets menu items.
     *
     * @param menuItems the menu items
     */
    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "id=" + id +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", cellPosition='" + cellPosition + '\'' +
                ", menuItems=" + menuItems +
                '}';
    }
}
