# CheckoutView Package

The CheckoutView package provides a graphical user interface (GUI) component for managing a checkout process. It allows users to scan barcodes of products, void transactions, make payments, and display transaction details.

## Features

1. Scan Barcodes: Users can scan product barcodes using the provided barcode field.

2. Void Transactions: Transactions can be voided by entering the barcode and quantity of the product to be voided.

3. Make Payments: Users can make payments by entering the cash amount.

4. Display Transaction Details: The GUI displays a table showing the list of products, their prices, quantities, and subtotals.

5. New Transaction: Users can start a new transaction to begin a fresh checkout process.

## Product Interface

The `Product` interface defines the contract for a product that can be used within the CheckoutView. The interface includes two methods:

1. `getName()`: Returns the name of the product.

2. `getPrice()`: Returns the price of the product as a double value.

## Usage

To use the CheckoutView, you can set various actions to handle events within the GUI.

### Actions

1. `setScanAction(Consumer<String> scanAction)`: Sets the action to be performed when a barcode is scanned.

2. `setVoidAction(BiConsumer<String, String> voidAction)`: Sets the action to be performed when a void transaction is requested.

3. `setPaymentAction(Consumer<String> paymentAction)`: Sets the action to be performed when a payment is made.

4. `setNewTransactionAction(Runnable newTransactionAction)`: Sets the action to be performed when a new transaction is started.

### Display Actions

1. `getTotalDisplayAction()`: Gets the action to be performed when the total amount needs to be displayed in the GUI.

2. `getCashDisplayAction()`: Gets the action to be performed when the cash amount needs to be displayed in the GUI.

3. `getChangeDisplayAction()`: Gets the action to be performed when the change amount needs to be displayed in the GUI.

4. `getProductDisplayAction()`: Gets the action to be performed when displaying products and quantities in the GUI table.

### Table Model

1. `getTableModel()`: Retrieves the table model used by the GUI table to manage data.

## Example

```java
// Instantiate the CheckoutPanel
CheckoutPanel checkoutPanel = new CheckoutPanel();

// Set the actions
checkoutPanel.setScanAction(barcode -> {
    // Handle barcode scanning action
    // Add the product to the transaction cart
});

checkoutPanel.setVoidAction((barcode, quantity) -> {
    // Handle void transaction action
    // Remove the specified quantity of the product from the transaction cart
});

checkoutPanel.setPaymentAction(cashAmount -> {
    // Handle payment action
    // Process the payment and calculate the change
});

checkoutPanel.setNewTransactionAction(() -> {
    // Handle new transaction action
    // Start a new checkout process
});

// Retrieve display actions if needed
Consumer<String> totalDisplayAction = checkoutPanel.getTotalDisplayAction();
Consumer<String> cashDisplayAction = checkoutPanel.getCashDisplayAction();
Consumer<String> changeDisplayAction = checkoutPanel.getChangeDisplayAction();
Consumer<LinkedHashMap<Product, Integer>> productDisplayAction = checkoutPanel.getProductDisplayAction();

// Retrieve the table model if needed
DefaultTableModel tableModel = checkoutPanel.getTableModel();
