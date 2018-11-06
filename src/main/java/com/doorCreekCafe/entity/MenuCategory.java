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

    @Column (name="row_position")
    private int rowPosition;

    @Column (name="column_position")
    private String columnPosition;

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
     * @param rowPosition         the row position
     * @param columnPosition      the column position
     */
    public MenuCategory(String categoryDescription, String cellPosition, int rowPosition, String columnPosition) {
        this.categoryDescription = categoryDescription;
        this.cellPosition = cellPosition;
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
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
     * Gets row position.
     *
     * @return the row position
     */
    public int getRowPosition() {
        return rowPosition;
    }

    /**
     * Sets row position.
     *
     * @param rowPosition the row position
     */
    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    /**
     * Gets column position.
     *
     * @return the column position
     */
    public String getColumnPosition() {
        return columnPosition;
    }

    /**
     * Sets column position.
     *
     * @param columnPosition the column position
     */
    public void setColumnPosition(String columnPosition) {
        this.columnPosition = columnPosition;
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
                ", rowPosition=" + rowPosition +
                ", columnPosition='" + columnPosition + '\'' +
                ", menuItems=" + menuItems +
                '}';
    }
}
