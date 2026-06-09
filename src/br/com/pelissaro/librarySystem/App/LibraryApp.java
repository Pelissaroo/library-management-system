package br.com.pelissaro.librarySystem.App;

import br.com.pelissaro.librarySystem.Service.BookService;
import br.com.pelissaro.librarySystem.Service.UserService;

import java.util.Scanner;

public class LibraryApp {
    public static void startLibrary(){

            BookService bookService = new BookService();
            UserService userService = new UserService();
            Scanner scanner = new Scanner(System.in);

            boolean running = true;

            while (running){
                System.out.println();
                System.out.println("--------------------------");
            System.out.println("Library System Terminal");
            System.out.println("--------------------------");
            System.out.println("-- Menu --");
            System.out.println("1 - Show users");
            System.out.println("2 - Show books");
            System.out.println("3 - Register Book ");
            System.out.println("4 - Register User ");
                System.out.println("0 - Exit program.");
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose){
                case 1:
                    userService.showUsers();
                    break;
                case 2:
                    bookService.showBooks();
                    break;
                case 3:
                    System.out.println("Enter the book title: ");
                    String inputTitle = scanner.nextLine();
                    if (inputTitle.trim().isEmpty()){
                        System.out.println("Insert a valid tittle book");
                    }
                    System.out.println("Enter the author name : ");
                    String inputAuthor = scanner.nextLine();
                    if (inputAuthor.trim().isEmpty()){
                        System.out.println("Insert a valid author name");
                    }

                    bookService.createNewBook(inputTitle, inputAuthor);
                    System.out.println("Book created successfully!");
                    break;

                case 4:
                    System.out.println("Username: ");
                    String inputName = scanner.nextLine();
                    if (inputName.trim().isEmpty()){
                        System.out.println("Username Invalid or Empty.");
                    }
                    System.out.println("CPF: ");
                    String inputCPF = scanner.nextLine();
                    if (inputCPF.trim().isEmpty()){
                        System.out.println("CPF Invalid or Empty.");
                    }
                    System.out.println("Adress: ");
                    String inputAddress = scanner.nextLine();
                    if (inputAddress.trim().isEmpty()){
                        System.out.println("Address invalid or empty.");
                    }
                    System.out.println("Number Adress: ");
                    String inputNumberAddress = scanner.nextLine();
                    int numberAddress = 0;
                    if (inputNumberAddress.trim().isEmpty()) {
                        System.out.println("Number Address invalid or empty.");
                    } else {
                        numberAddress = Integer.parseInt(inputNumberAddress);
                    }
                    System.out.println("Phone Number: ");
                    String inputPhoneNumber = scanner.nextLine();
                    if (inputPhoneNumber.trim().isEmpty()){
                        System.out.println("Phone Number invalid or empty.");
                    }
                    userService.CadasterUser(inputName, inputCPF, inputAddress, numberAddress, inputPhoneNumber);
                    System.out.println("User created successfully!");
                    break;
                case 0:
                    running = false;
                    break;
            }
        }
    }
}
