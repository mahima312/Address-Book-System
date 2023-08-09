import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ContactForm {
    private AddressBook addressBook;

    private TextField nameField;
    private TextField phoneNumberField;
    private TextField emailAddressField;
    private VBox pane; // Define pane as an instance variable

    public ContactForm(AddressBook addressBook) {
        this.addressBook = addressBook;

        Label nameLabel = new Label("Name:");
        nameField = new TextField();

        Label phoneNumberLabel = new Label("Phone Number:");
        phoneNumberField = new TextField();

        Label emailAddressLabel = new Label("Email Address:");
        emailAddressField = new TextField();

        Button addButton = new Button("Add Contact");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String emailAddress = emailAddressField.getText();

                Contact contact = new Contact(name, phoneNumber, emailAddress);
                addressBook.addContact(contact);

                // Clear fields
                nameField.clear();
                phoneNumberField.clear();
                emailAddressField.clear();
            }
        });

        // Create the layout
        pane = new VBox(10, nameLabel, nameField, phoneNumberLabel, phoneNumberField,
                        emailAddressLabel, emailAddressField, addButton);
        // Set alignment and padding as needed
    }

    public Pane getPane() {
        return pane; // Return the created layout pane
    }
}
