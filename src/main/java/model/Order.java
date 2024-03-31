package model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> Items;

    public void addItem(OrderItem item) {
        Items.add(item);
    }

    private double total(){
        double sum = 0;
        for(OrderItem it : Items) {
            sum += it.getPrice() * it.getQuantity();
        }
        return sum;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(moment).append("\n");
        sb.append("Order status: ");
        sb.append(status).append("\n");
        sb.append(client).append("\n");
        sb.append("Order items: \n");
        for (OrderItem it : Items) {
            sb.append(it).append("\n");
        }
        sb.append("Total price: $");
        sb.append(total());

        return sb.toString();
    }
}
