package Exam;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private String name;
    private String deliveryAddress;
    private List<OrderItem> items;
    private Customer customer;
    private double totalPrice;
    private PaymentType paymentType;
    private Date orderDate;

    public Order(int id, String name, String deliveryAddress, List<OrderItem> items, Customer customer,
                 PaymentType paymentType, Date orderDate) {
        this.id = id;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
        this.customer = customer;
        this.paymentType = paymentType;
        this.orderDate = orderDate;
        this.totalPrice = calculateTotalPrice();

        for (OrderItem item : items) {
            boolean isItemInFavorites = false;
            for (OrderItem favoriteItem : customer.getFavoriteItems()) {
                if (favoriteItem.getItemName().equals(item.getItemName())) {
                    isItemInFavorites = true;
                    break;
                }
            }
            if (!isItemInFavorites) {
                customer.addToFavoriteItems(item);
            }
        }
    }
        public void setId ( int id){
            this.id = id;
        }

        public void setName (String name){
            this.name = name;
        }

        public void setDeliveryAddress (String deliveryAddress){
            this.deliveryAddress = deliveryAddress;
        }

        public void setOrderItems (List < OrderItem > items) {
            this.items = items;
        }

        public void setCustomer (Customer customer){
            this.customer = customer;
        }

        public void setTotalPrice ( double totalPrice){
            this.totalPrice = totalPrice;
        }

        public void setPaymentType (PaymentType paymentType){
            this.paymentType = paymentType;
        }

        public void setOrderDate (Date orderDate){
            this.orderDate = orderDate;
        }

        public int getId () {
            return id;
        }

        public String getName () {
            return name;
        }

        public String getDeliveryAddress () {
            return deliveryAddress;
        }

        public List<OrderItem> getOrderItems () {
            return items;
        }

        public Customer getCustomer () {
            return customer;
        }

        public double getTotalPrice () {
            return totalPrice;
        }

        public PaymentType getPaymentType () {
            return paymentType;
        }

        public Date getOrderDate () {
            return orderDate;
        }
    private double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : items) {
            totalPrice += item.getItemPrice();
        }

        if (customer.getCustomerType() == CustomerType.VIP && !(this instanceof VIPOrder)) {
            throw new RuntimeException("Error: Only VIP orders can be assigned to a VIP customer.");
        }

        if (customer.getCustomerType() == CustomerType.VIP) {
            totalPrice -= totalPrice * (customer.getCustomerDiscount() / 100.0);
        }

        return totalPrice;
    }
    }
