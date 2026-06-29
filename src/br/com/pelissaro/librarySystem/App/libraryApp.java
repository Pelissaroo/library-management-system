package br.com.pelissaro.librarySystem.App;

import br.com.pelissaro.librarySystem.Domain.Book;
import br.com.pelissaro.librarySystem.Domain.User;
import br.com.pelissaro.librarySystem.Service.BookService;
import br.com.pelissaro.librarySystem.Service.UserService;
import br.com.pelissaro.librarySystem.Service.LoanService;

import java.util.Scanner;

public class libraryApp {
    public static void startLibrary(){

            BookService bookService = new BookService();
            UserService userService = new UserService();
            LoanService loanService = new LoanService();
            DataLoader dataLoader = new DataLoader(bookService, userService);



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
            System.out.println("3 - List loans");
            System.out.println("4 - Register Book ");
            System.out.println("5 - Register User ");
                System.out.println("6 - New Loan ");
                System.out.println("7 - Edit User ");
                System.out.println("8 - Edit Book ");
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
                case 4:
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

                case 5:
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
                    userService.registerUser(inputName, inputCPF, inputAddress, numberAddress, inputPhoneNumber);
                    System.out.println("User created successfully!");
                    break;

                case 6:
                    System.out.println("Book ID : ");
                    int inputIdBook = scanner.nextInt();
                    Book findedBook = bookService.findBookByID(inputIdBook);
                    System.out.println("User ID : ");
                    int inputIdUser = scanner.nextInt();
                    User findedUser = userService.findUserByID(inputIdUser);
                    loanService.borrow(findedBook, findedUser);
                    System.out.println("Loan Created Sucefully! ");
                    break;

                case 7:
                    System.out.println("--EDIT USER--");
                    System.out.println("User ID: ");
                    int IdUser = scanner.nextInt();
                    User findedUserToEdit = userService.findUserByID(IdUser);
                    System.out.println(findedUserToEdit);


                    boolean userEdit = true;
                while (userEdit) {
                    System.out.println("---------------");
                    System.out.println("1 - Edit Name");
                    System.out.println("2 - Edit CPF");
                    System.out.println("3 - Edit Address");
                    System.out.println("4 - Edit Address number");
                    System.out.println("5 - Edit Phone number");
                    System.out.println("0 - Exit to Main-Menu");
                    int answer = scanner.nextInt();
                    scanner.nextLine();
                    switch (answer){
                        case 1:
                        System.out.println("New name: ");
                            String newName = scanner.nextLine();
                        userService.updateName(findedUserToEdit, newName);
                        System.out.println("Changes saved successfully!");
                        break;

                        case 2:
                            System.out.println("New CPF: ");
                            String newCPF = scanner.nextLine();
                            userService.updateCPF(findedUserToEdit, newCPF);
                            System.out.println("Changes saved successfully!");
                            break;

                        case 3:
                            System.out.println("New Address: ");
                            String newAddress = scanner.nextLine();
                            userService.updateAddress(findedUserToEdit, newAddress);
                            System.out.println("Changes saved successfully!");
                            break;

                        case 4:
                            System.out.println("New Address Number: ");
                            int newAddressNumber = scanner.nextInt();
                            userService.updateAddressNumber(findedUserToEdit, newAddressNumber);
                            System.out.println("Changes saved successfully!");
                            break;

                        case 5:
                            System.out.println("New Phone Number: ");
                            String newPhoneNumber = scanner.nextLine();
                            userService.updatePhoneNumber(findedUserToEdit, newPhoneNumber);
                            System.out.println("Changes saved successfully!");
                            break;

                        case 0:
                            userEdit = false;
                            break;
                    }
                } break;

                case 8:
                    System.out.println("entering case 8...");
                    System.out.println("--EDIT BOOK--");
                    System.out.println("Book ID: ");
                    int Idbook = scanner.nextInt();
                    Book findedBookToEdit = bookService.findBookByID(Idbook);
                    System.out.println(findedBookToEdit);

                    boolean bookEdit = true;
                    while (bookEdit) {
                        System.out.println("---------------");
                        System.out.println("1 - Edit Title");
                        System.out.println("2 - Edit author ");
                        System.out.println("0 - Exit to Main-Menu");

                        int answer2 = scanner.nextInt();
                        scanner.nextLine();
                        switch (answer2){
                            case 1:
                                System.out.println("New title: ");
                                String newTitle = scanner.nextLine();
                                bookService.updateTitle(findedBookToEdit, newTitle);
                                System.out.println("Changes saved successfully!");
                                break;

                            case 2:
                                System.out.println("New Author name: ");
                                String newAuthorName = scanner.nextLine();
                                bookService.updateAuthor(findedBookToEdit, newAuthorName);
                                System.out.println("Changes saved successfully!");
                                break;

                            case 0:
                                bookEdit = false;
                                break;
                        }
                    } break;

                case 3:
                    loanService.listLoans();
                    break;

                case 0:
                    running = false;
                    break;
            }
        }
    }
}
