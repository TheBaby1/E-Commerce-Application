package com.example.listview_shopphile_ecommerceapp_ensomo;

public class ItemModal {

    // variables for our item name, description, price, and quantity, along with id
    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    private String itemDescription;
    private int id;

    // creating getter and setter methods
    public String getItemName() { return itemName; }

    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemPrice() { return itemPrice; }

    public void setItemPrice(String itemPrice) { this.itemPrice = itemPrice; }

    public String getItemQuantity() { return itemQuantity; }

    public void setItemQuantity(String itemQuantity) { this.itemQuantity = itemQuantity; }

    public String getItemDescription() { return itemDescription; }

    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public ItemModal(String itemName, String itemPrice, String itemQuantity, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
    }
}
