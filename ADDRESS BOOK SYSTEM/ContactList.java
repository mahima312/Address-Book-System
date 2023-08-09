import javafx.scene.control.ListView;
import javafx.collections.ObservableList;

public class ContactList {
    private AddressBook addressBook;
    private ListView<String> listView;

    public ContactList(AddressBook addressBook) {
        this.addressBook = addressBook;
        listView = new ListView<>();

        updateListView();
    }

    public void updateListView() {
        ObservableList<String> items = listView.getItems();
        items.clear();

        for (Contact contact : addressBook.getAllContacts()) {
            items.add(contact.getName() + " - " + contact.getPhoneNumber() + " - " + contact.getEmailAddress());
        }
    }

    public ListView<String> getListView() {
        return listView;
    }
}
