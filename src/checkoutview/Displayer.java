package checkoutview;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import javax.swing.table.DefaultTableModel;

/**
 * Handles the logic to display products in the table view.
 *
 * @param <T> The type of product that extends the Product interface.
 */
public class Displayer<T extends Product> {

    // Table model of the cart table in view.
    private DefaultTableModel model;

    /**
     * Creates a new Displayer with the given DefaultTableModel.
     *
     * @param model The DefaultTableModel representing the cart table in the
     * view.
     */
    public Displayer(DefaultTableModel model) {
        this.model = model;
    }

    /**
     * Called every time the cart changes so that the display is in sync with
     * the cart content. This method also computes the total price of the
     * products in the cart.
     *
     * @param cart The LinkedHashMap containing the products in the cart along
     * with their quantities.
     * @return The total price of the products in the cart.
     */
    public BigDecimal display(LinkedHashMap<T, Integer> cart) {
        model.setRowCount(0);

        BigDecimal total = BigDecimal.ZERO;

        for (var product : cart.keySet()) {
            int quantity = cart.get(product);

            BigDecimal price = BigDecimal.valueOf(product.getPrice());
            BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(quantity)).setScale(2, BigDecimal.ROUND_HALF_UP);

            // Increment the total price with the totalPrice of the current product.
            total = total.add(totalPrice).setScale(0, RoundingMode.CEILING);

            model.addRow(new Object[]{
                product.getName(),
                price,
                quantity,
                totalPrice
            });
        }

        return total;
    }
}