package Exam;

public class OrderItem {
        private int id;
        private String itemName;
        private double itemPrice;

        public OrderItem(int id, String itemName, double itemPrice) {
            this.id = id;
            this.itemName = itemName;
            this.itemPrice = itemPrice;
        }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}
