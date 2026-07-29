package br.com.pelissaro.librarySystem.app;

import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.*;
import br.com.pelissaro.librarySystem.service.BookService;
import br.com.pelissaro.librarySystem.service.UserService;
import br.com.pelissaro.librarySystem.service.LoanService;

import java.util.Scanner;

public class LibraryApp {
    public static void startLibrary(){

            BookService bookService = new BookService();
            UserService userService = new UserService();
            LoanService loanService = new LoanService();
            DataLoader dataLoader = new DataLoader(bookService, userService);


            Scanner scanner = new Scanner(System.in);

            boolean running = true;

            while (running) {
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

                switch (choose) {

                    case 1:
                        try {
                            userService.showUsers();
                        } catch (NoUsersFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            bookService.showBooks();
                        } catch (NoBooksFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        boolean validTitle = false;
                        boolean validAuthor = false;

                        String title = null;
                        String author = null;

                            while (!validTitle){
                                System.out.println("Enter the book title: ");
                                String inputTitle = scanner.nextLine();

                                try {
                                    bookService.validateInputString(inputTitle);
                                    title = inputTitle;
                                    validTitle = true;
                                } catch (IllegalArgumentException e){
                                    System.out.println("type a valid title");
                                }
                            }

                            while (!validAuthor) {
                                System.out.println("Enter the author name : ");
                                String inputAuthor = scanner.nextLine();

                                try {
                                    bookService.validateInputString(inputAuthor);
                                    author = inputAuthor;
                                    validAuthor = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("type a valid author name");
                                }
                            }

                            try {
                                bookService.createNewBook(title, author);
                                System.out.println("Book created successfully!");
                            } catch (IllegalArgumentException e) {
                                System.out.println();
                            } break;


                    case 5:

                        boolean validName = false;
                        boolean validCpf = false;
                        boolean validAddress = false;
                        boolean validNumberAddress = false;
                        boolean validPhoneNumber = false;


                        String username = null;
                        String cpf = null;
                        String address = null;
                        int numberAddress = 0;
                        String phoneNumber = null;

                        while (!validName) {
                            System.out.println("Username: ");
                            String inputName = scanner.nextLine();

                            try {
                                userService.validateInputString(inputName);
                                username = inputName;
                                validName = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid name.");
                            }
                        }

                            while (!validCpf) {

                                System.out.println("CPF: ");
                                String inputCPF = scanner.nextLine();

                                try {
                                    userService.validateCpf(inputCPF);
                                    cpf = inputCPF;
                                    validCpf = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Type only numbers.");

                                }
                            }

                                while (!validAddress) {
                                    System.out.println("Address: ");
                                    String inputAddress = scanner.nextLine();

                                    try {
                                        userService.validateInputString(inputAddress);
                                        address = inputAddress;
                                        validAddress = true;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid Address.");

                                    }
                                }


                                while (!validNumberAddress) {
                                    System.out.println("Number Adress: ");
                                    String inputNumberAddress = scanner.nextLine();

                                    try {
                                        numberAddress = Integer.parseInt(inputNumberAddress);
                                        validNumberAddress = true;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Invalid number address");
                                    }
                                }

                                    while (!validPhoneNumber) {
                                        System.out.println("Phone Number: ");
                                        String inputPhoneNumber = scanner.nextLine();

                                        try {
                                            userService.validatePhoneNumber(inputPhoneNumber);
                                            phoneNumber = inputPhoneNumber;
                                            validPhoneNumber = true;
                                        } catch (IllegalArgumentException e) {
                                            System.out.println("Invalid phone number.");
                                            continue;
                                        }

                                        userService.registerUser(username, cpf, address, numberAddress, phoneNumber);
                                        System.out.println("User created successfully!");

                                    } break;


                                    case 6:
                                        boolean loanCreated = false;

                                        while (!loanCreated) {
                                            boolean bookIdValid = false;
                                            boolean userIdValid = false;
                                            Book findedBook = null;
                                            User findedUser = null;

                                            while (!bookIdValid) {
                                                System.out.println("Book ID : ");
                                                String input = scanner.nextLine();

                                                int inputIdBook = 0;

                                                try{
                                                    inputIdBook = Integer.parseInt(input);
                                                } catch (IllegalArgumentException e){
                                                    System.out.println("Book id must be a number");
                                                    continue;
                                                }

                                                try {
                                                    findedBook = bookService.findBookByID(inputIdBook);
                                                    bookIdValid = true;
                                                } catch (IllegalArgumentException | BookNotFoundException e) {
                                                    System.out.println(e.getMessage());
                                                    System.out.println();
                                                }
                                            }

                                            while (!userIdValid) {
                                                System.out.println("User ID : ");
                                                String input = scanner.nextLine();

                                                int inputIdUser = 0;

                                                try{
                                                    inputIdUser = Integer.parseInt(input);
                                                } catch (IllegalArgumentException e) {
                                                    System.out.println("User id must be a number");
                                                    continue;
                                                }

                                                try {
                                                    findedUser = userService.findUserByID(inputIdUser);
                                                    userIdValid = true;
                                                } catch (IllegalArgumentException | UserNotFoundException e) {
                                                    System.out.println(e.getMessage());
                                                    System.out.println();
                                                }
                                            }

                                            try {
                                                loanService.borrow(findedBook, findedUser);
                                                System.out.println("Loan Created Successfully!");
                                                loanCreated = true;
                                            } catch (IllegalArgumentException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        break;

                                    case 7:
                                        boolean validateUserID = false;

                                        User user = null;

                                        System.out.println("--EDIT USER--");

                                        while (!validateUserID) {
                                            System.out.println("User ID: ");
                                            String input = scanner.nextLine();

                                            int IdUser = 0;

                                            try {
                                                IdUser = Integer.parseInt(input);
                                            } catch (IllegalArgumentException e){
                                                System.out.println("User id must be a number");
                                                continue;
                                            }

                                            try{
                                                user = userService.findUserByID(IdUser);
                                                System.out.println(user);
                                                validateUserID = true;
                                            } catch (IllegalArgumentException | UserNotFoundException e){
                                                System.out.println(e.getMessage());
                                            }
                                        }

                                        while (validateUserID) {
                                            System.out.println("---------------");
                                            System.out.println("1 - Edit Name");
                                            System.out.println("2 - Edit CPF");
                                            System.out.println("3 - Edit Address");
                                            System.out.println("4 - Edit Address number");
                                            System.out.println("5 - Edit Phone number");
                                            System.out.println("0 - Exit to Main-Menu");
                                            int answer = scanner.nextInt();
                                            scanner.nextLine();

                                            switch (answer) {
                                                case 1:
                                                    boolean validNewNameForUpdate = false;

                                                    while (!validNewNameForUpdate) {
                                                        System.out.println("New name: ");
                                                        String newName = scanner.nextLine();
                                                        try {
                                                            userService.validateInputString(newName);
                                                            userService.updateName(user, newName);
                                                            validNewNameForUpdate = true;
                                                            System.out.println("Changes saved successfully!");
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println("Invalid name.");
                                                            System.out.println();
                                                        }
                                                    }break;

                                                case 2:
                                                    boolean validNewCpfForUpdate = false;

                                                    while (!validNewCpfForUpdate){

                                                        System.out.println("New CPF: ");
                                                        String newCPF = scanner.nextLine();

                                                        try {
                                                            userService.validateCpf(newCPF);
                                                            userService.updateCPF(user, newCPF);
                                                            validNewCpfForUpdate = true;
                                                            System.out.println("Changes saved successfully!");
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println("Type only numbers");
                                                        }
                                                    }break;


                                                case 3:
                                                    boolean validNewAdressForUpdate = false;

                                                    while (!validNewAdressForUpdate){
                                                        System.out.println("New Address: ");
                                                        String newAddress = scanner.nextLine();

                                                        try{
                                                            userService.validateInputString(newAddress);
                                                            userService.updateAddress(user, newAddress);
                                                            validNewAdressForUpdate = true;
                                                            System.out.println("Changes saved successfully!");
                                                        } catch (IllegalArgumentException e) {
                                                            System.out.println("Invalid address");
                                                        }
                                                    } break;

                                                case 4:
                                                    boolean validNewAddressNumber = false;


                                                    while (!validNewAddressNumber){
                                                        System.out.println("New Address Number: ");
                                                        String newAddressNumber = scanner.nextLine();

                                                        int newNumberAddress = 0;

                                                        try {
                                                            newNumberAddress = Integer.parseInt(newAddressNumber);
                                                            userService.updateAddressNumber(user, newNumberAddress);
                                                            validNewAddressNumber = true;
                                                            System.out.println("Changes saved successfully!");
                                                        } catch (IllegalArgumentException e) {
                                                            System.out.println("Invalid number address");
                                                        }
                                                    } break;

                                                case 5:
                                                    boolean validNewPhoneNumber = false;

                                                    while (!validNewPhoneNumber){
                                                        System.out.println("New Phone Number: ");
                                                        String newPhoneNumber = scanner.nextLine();

                                                        try{
                                                            userService.validatePhoneNumber(newPhoneNumber);
                                                            userService.updatePhoneNumber(user, newPhoneNumber);
                                                            validNewPhoneNumber = true;
                                                            System.out.println("Changes saved successfully!");
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println("Invalid phone number");
                                                        }
                                                    } break;

                                                case 0:
                                                    validateUserID = false;
                                                    break;

                                                default:
                                                    System.out.println("Choose a valid option.");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 8:
                                        boolean bookIdValid = false;
                                        Book foundBookToEdit = null;

                                        while (!bookIdValid){
                                            System.out.println("--EDIT BOOK--");
                                            System.out.println("Book ID: ");
                                            String input = scanner.nextLine();

                                            int idBook = 0;

                                            try{
                                                idBook = Integer.parseInt(input);
                                            } catch (IllegalArgumentException e){
                                                System.out.println("Id must be a number");
                                                continue;
                                            }

                                                try{
                                                    foundBookToEdit = bookService.findBookByID(idBook);
                                                    bookIdValid = true;
                                                    System.out.println(foundBookToEdit);
                                                } catch (IllegalArgumentException | BookNotFoundException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                        }

                                        while (bookIdValid) {
                                            System.out.println("---------------");
                                            System.out.println("1 - Edit Title");
                                            System.out.println("2 - Edit author ");
                                            System.out.println("0 - Exit to Main-Menu");

                                            int answer2 = scanner.nextInt();
                                            scanner.nextLine();
                                            switch (answer2) {
                                                case 1:
                                                    boolean validNewTitle = false;

                                                    while (!validNewTitle){
                                                        System.out.println("New title: ");
                                                        String newTitle = scanner.nextLine();

                                                        try{
                                                            bookService.validateInputString(newTitle);
                                                            bookService.updateTitle(foundBookToEdit, newTitle);
                                                            System.out.println("Changes saved successfully!");
                                                            validNewTitle = true;
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println("Invalid title");
                                                            System.out.println();
                                                        }
                                                    }
                                                    break;

                                                case 2:
                                                    boolean validNewAuthorName = false;

                                                    while (!validNewAuthorName) {

                                                        System.out.println("New Author name: ");
                                                        String newAuthorName = scanner.nextLine();

                                                            try {
                                                                bookService.validateInputString(newAuthorName);
                                                                bookService.updateAuthor(foundBookToEdit, newAuthorName);
                                                                System.out.println("Changes saved successfully!");
                                                                validNewAuthorName = true;
                                                            } catch (IllegalArgumentException e) {
                                                                System.out.println("Invalid author name");
                                                            }
                                                        }
                                                        break;

                                                case 0:
                                                    bookIdValid = false;
                                                    break;

                                                default:
                                                    System.out.println("Choose a valid option");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 3:
                                        try{
                                            loanService.listLoans();
                                        } catch (NoLoansFoundException e){
                                            System.out.println(e.getMessage());
                                        }
                                        break;

                                    case 0:
                                        running = false;
                                        break;
                    default:
                        System.out.println("Choose a valid option.");
                        break;
                }
                            }
                        }
                }
