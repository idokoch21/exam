package Exam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum PaymentType {
    CREDIT_CARD,
    CASH,
    CHECK,
    OTHER
}
public class Main {
    public static void main(String[] args) {

        Customer regularCustomer = new Customer(1, "John", "cohen", "john@gamil.com", "rotshild",
                CustomerType.REGULAR, null, new ArrayList<>(), null);
        Customer vipCustomer = new Customer(2, "tomer", "levi", "tomer@gamil.com", "fabrigat",
                CustomerType.VIP, 10.0, new ArrayList<>(), null);


        OrderItem item1 = new OrderItem(1, "chesse", 10.0);
        OrderItem item2 = new OrderItem(2, "milk", 20.0);
        OrderItem item3 = new OrderItem(3, "butter", 15.0);
        OrderItem item4 = new OrderItem(4, "milki", 5.0);

        List<OrderItem> vipOrderItems = new ArrayList<>();
        vipOrderItems.add(item2);
        vipOrderItems.add(item1);
        vipOrderItems.add(item4);

        VIPOrder vipOrder = new VIPOrder(2, "VIP Order", "fabrigat", vipOrderItems,
                vipCustomer, PaymentType.CREDIT_CARD, new Date());

        System.out.println("VIP Order:");
        System.out.println("Customer: " + vipOrder.getCustomer().getFirstName() + " " +
                vipOrder.getCustomer().getLastName());
        System.out.println("Total Price: " + vipOrder.getTotalPrice());

        List<OrderItem> regularOrderItems = new ArrayList<>();
        regularOrderItems.add(item1);
        regularOrderItems.add(item3);
        regularOrderItems.add(item4);

        RegularOrder regularOrder = new RegularOrder(1, "Regular Order", "rotshild", regularOrderItems,
                regularCustomer, PaymentType.CASH, new Date());

        System.out.println("Regular Order:");
        System.out.println("Customer: " + regularOrder.getCustomer().getFirstName() + " " +
                regularOrder.getCustomer().getLastName());
        System.out.println("Total Price: " + regularOrder.getTotalPrice());

        RegularOrder regularOrder2 = new RegularOrder(2, "Regular Order", "rotshild", regularOrderItems,
                regularCustomer, PaymentType.CASH, new Date());

        System.out.print("Favorite Items: ");
        for (OrderItem item : regularCustomer.getFavoriteItems()) {
            System.out.print(item.getItemName() + ", ");
        }
        System.out.println();

        Gift customerGift = new CustomerGift();
        vipCustomer.takeGift(customerGift);

        System.out.println("Open the gift:");
        vipCustomer.openGift();
    }
}
