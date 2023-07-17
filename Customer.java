package Exam;

import java.util.List;

enum CustomerType {
    REGULAR,
    VIP
}
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String deliveryAddress;
    private CustomerType customerType;
    private Double customerDiscount;
    private List<OrderItem> favoriteItems;
    private Gift customerGift;


    public Customer(int id, String firstName, String lastName, String email, String deliveryAddress,
                    CustomerType customerType, Double customerDiscount, List<OrderItem> favoriteItems, Gift customerGift) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
        this.customerType = customerType;
        this.customerDiscount = customerDiscount;
        this.favoriteItems = favoriteItems;
        this.customerGift = customerGift;
    }
    public void takeGift(Gift gift) {
        this.customerGift = gift;
    }

    public void openGift() {
        if (customerGift != null) {
            customerGift.openGift();
            customerGift = null;
        } else {
            System.out.println("No gift available for opening.");
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public void setCustomerDiscount(Double customerDiscount) {
        this.customerDiscount = customerDiscount;
    }

    public void setFavoriteItems(List<OrderItem> favoriteItems) {
        this.favoriteItems = favoriteItems;
    }

    public void setCustomerGift(Gift customerGift) {
        this.customerGift = customerGift;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public Double getCustomerDiscount() {
        return customerDiscount;
    }

    public List<OrderItem> getFavoriteItems() {
        return favoriteItems;
    }

    public Gift getCustomerGift() {
        return customerGift;
    }
    public void addToFavoriteItems(OrderItem item) {
        for (OrderItem favoriteItem : favoriteItems) {
            if (favoriteItem.getItemName().equals(item.getItemName()) && favoriteItem.getId() == item.getId()) {
                return; // Item already exists in the favorite list
            }
        }
        favoriteItems.add(item);
    }

    public void removeFromFavoriteItems(String itemName) {
        favoriteItems.remove(itemName);
    }


}
