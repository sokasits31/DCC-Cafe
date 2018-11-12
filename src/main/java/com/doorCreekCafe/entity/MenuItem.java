package com.doorCreekCafe.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Menu.
 */
@Entity(name= "MenuItem")     // Class Name
@Table (name= "menuItem")     // Table Name
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column (name="description")
    private String description;

    @Column (name="alt_description")
    private String altDescripton;

    @Column (name="price")
    private double price;

    @Column (name="frequency_level")
    private String frequencyLevel;

    @Column (name="cell_position")
    private String cellPosition;

    @Column (name="row_position")
    private String rowPosition;

    @Column (name="column_position")
    private String columnPosition;

    @Column (name="short_hand")
    private String shortHand;

    @ManyToOne
    private MenuCategory menuCategory;

    /**
     * Instantiates a new Menu.
     */
    public MenuItem() {
    }


    /**
     * Instantiates a new Menu item.
     *
     * @param description    the description
     * @param altDescripton  the alt descripton
     * @param price          the price
     * @param frequencyLevel the frequency level
     * @param cellPosition   the cell position
     */
    public MenuItem(String description, String altDescripton, double price, String frequencyLevel, String cellPosition) {
        this.description = description;
        this.altDescripton = altDescripton;
        this.price = price;
        this.frequencyLevel = frequencyLevel;
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
     * Gets alt descripton.
     *
     * @return the alt descripton
     */
    public String getAltDescripton() {
        return altDescripton;
    }

    /**
     * Sets alt descripton.
     *
     * @param altDescripton the alt descripton
     */
    public void setAltDescripton(String altDescripton) {
        this.altDescripton = altDescripton;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
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
    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    /**
     * Sets menu category.
     *
     * @param menuCategory the menu category
     */
    public void setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }

    /**
     * Gets row position.
     *
     * @return the row position
     */
    public String getRowPosition() {
        return rowPosition;
    }

    /**
     * Sets row position.
     *
     * @param rowPosition the row position
     */
    public void setRowPosition(String rowPosition) {
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

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", altDescripton='" + altDescripton + '\'' +
                ", price=" + price +
                ", frequencyLevel='" + frequencyLevel + '\'' +
                ", cellPosition='" + cellPosition + '\'' +
                ", shortHand='" + shortHand + '\'' +
                '}';
    }
}
