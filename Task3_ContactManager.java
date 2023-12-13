import java.util.ArrayList;
import java.util.Scanner;

class Contact
 {
    String name;
    String phoneNumber;
    String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}

public class Task3_ContactManager 
{
    private static ArrayList<Contact> contactList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int choice;
        do {
            System.out.println("Contact Manager Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contact list");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) 
            {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContactList();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
    }

    private static void addContact() 
    {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, emailAddress);
        contactList.add(newContact);
        System.out.println("Contact added successfully!");
    }

    private static void viewContactList() 
    {
        if (contactList.isEmpty()) 
        {
            System.out.println("Contact list is empty.");
        } 
        else 
        {
            System.out.println("\nContact List:");
            for (int i = 0; i < contactList.size(); i++) 
            {
                Contact contact = contactList.get(i);
                System.out.println("Name: " + contact.name);
                System.out.println("Phone Number: " + contact.phoneNumber);
                System.out.println("Email Address: " + contact.emailAddress);
                System.out.println("------------");
            }
        }
    }

    private static void editContact() 
    {
        System.out.print("Enter the name of the contact you want to edit: ");
        String searchName = scanner.nextLine();

        for (Contact contact : contactList) 
        {
            if (contact.name.equals(searchName)) 
            {
                System.out.print("Enter new phone number: ");
                contact.phoneNumber = scanner.nextLine();
                System.out.print("Enter new email address: ");
                contact.emailAddress = scanner.nextLine();
                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    private static void deleteContact() 
    {
        System.out.print("Enter the name of the contact you want to delete: ");
        String searchName = scanner.nextLine();

        for (int i = 0; i < contactList.size(); i++) 
        {
            Contact contact = contactList.get(i);
            if (contact.name.equals(searchName))
            {
                contactList.remove(i);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}
