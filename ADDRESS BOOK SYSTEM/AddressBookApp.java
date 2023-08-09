import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddressBookApp extends Application {

    private AddressBook addressBook;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        addressBook = new AddressBook();

        ContactForm contactForm = new ContactForm(addressBook);
        Scene addContactScene = new Scene(contactForm.getPane(), 600, 400);

        primaryStage.setTitle("Address Book");
        primaryStage.setScene(addContactScene);
        primaryStage.show();

        // Create an instance of ContactList and update the ListView
        ContactList contactList = new ContactList(addressBook);
        contactList.updateListView();

        // Show the contact list in a new stage/window
        Scene contactListScene = new Scene(new VBox(contactList.getListView()), 600, 400);
        Stage contactListStage = new Stage();
        contactListStage.setTitle("Contact List");
        contactListStage.setScene(contactListScene);
        contactListStage.show();
    }
}
