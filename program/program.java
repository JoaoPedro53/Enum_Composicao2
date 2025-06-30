package EnumeracoeseComposicao.enumeracoes2.program;

import EnumeracoeseComposicao.enumeracoes2.entites.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner jl = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = jl.nextLine();
        System.out.print("Email: ");
        String email = jl.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(jl.next());

        Client cliente = new Client(name, email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(jl.next());
        Order order = new Order(new Date(), status, cliente);

        System.out.println("How many items to this order? ");
        int x = jl.nextInt();
        jl.nextLine();

        for (int i = 0; i < x; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product Name: ");
            String nameProduct = jl.nextLine();
            System.out.print("Product Price: ");
            double price = jl.nextDouble();
            jl.nextLine();
            System.out.print("Quantity: ");
            int quantity = jl.nextInt();
            jl.nextLine();

            Product product = new Product(nameProduct, price);
            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);

        }

        System.out.println("ORDER SUMMARY:");
        System.out.print(order);



        jl.close();
    }
}
