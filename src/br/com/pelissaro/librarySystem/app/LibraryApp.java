package br.com.pelissaro.librarySystem.app;

import br.com.pelissaro.librarySystem.domain.Book;
import br.com.pelissaro.librarySystem.domain.Loan;
import br.com.pelissaro.librarySystem.domain.User;
import br.com.pelissaro.librarySystem.exception.*;
import br.com.pelissaro.librarySystem.service.BookService;
import br.com.pelissaro.librarySystem.service.UserService;
import br.com.pelissaro.librarySystem.service.LoanService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp {
    public static void startLibrary(){

            BookService bookService = new BookService();
            UserService userService = new UserService();
            LoanService loanService = new LoanService();

            Scanner scanner = new Scanner(System.in);

            boolean running = true;

            while (running) {
                System.out.println();
                System.out.println("---------------------------");
                System.out.println("  Library System Terminal");
                System.out.println("---------------------------");
                System.out.println("-- Menu --");
                System.out.println("1 - Show users");
                System.out.println("2 - Show books");
                System.out.println("3 - List loans");
                System.out.println("4 - Detailed consultation");
                System.out.println("5 - Register Book ");
                System.out.println("6 - Register User ");
                System.out.println("7 - New Loan ");
                System.out.println("8 - Edit User ");
                System.out.println("9 - Edit Book ");
                System.out.println("10 - Return loan");
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
                    case 3:
                        try{
                            loanService.listLoans();
                        } catch (NoLoansFoundException e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        boolean stopMenu = false;

                        while (!stopMenu){
                            boolean validOptionMenu = false;
                            int optionMenu = 0;

                            while (!validOptionMenu){
                                System.out.println("--DETAILED CONSULTATION--");
                                System.out.println("1 - search user");
                                System.out.println("2 - search book");
                                System.out.println("3 - search loan");
                                System.out.println("0 - Return to principal menu");
                                String inputD = scanner.nextLine();


                                try {
                                    optionMenu = Integer.parseInt(inputD);
                                    if (optionMenu >= 0 && optionMenu <= 4){
                                        validOptionMenu = true;
                                    } else {
                                        System.out.println("Choose a valid option!");
                                        System.out.println();
                                    }
                                } catch (NumberFormatException e){
                                    System.out.println("Type only numbers");
                                    System.out.println();
                                }
                            }

                            switch (optionMenu){
                                case 1:
                                    boolean validateUserID = false;

                                    User user = null;

                                    while (!validateUserID) {
                                        System.out.println("User ID: ");
                                        String input = scanner.nextLine();

                                        int IdUser = 0;

                                        try {
                                            IdUser = Integer.parseInt(input);
                                        } catch (NumberFormatException e){
                                            System.out.println("User id must be a number");
                                            continue;
                                        }

                                        try{
                                            user = userService.findUserByID(IdUser);
                                            System.out.println(user);
                                            System.out.println();
                                            validateUserID = true;
                                        } catch (IllegalArgumentException | UserNotFoundException e){
                                            System.out.println(e.getMessage());
                                        }
                                    }break;

                                case 2:
                                    boolean bookIdValid = false;
                                    Book book = null;

                                    while (!bookIdValid){
                                        System.out.println("Book ID: ");
                                        String input = scanner.nextLine();

                                        int idBook = 0;

                                        try{
                                            idBook = Integer.parseInt(input);
                                        } catch (NumberFormatException e){
                                            System.out.println("Id must be a number");
                                            continue;
                                        }

                                        try{
                                            book = bookService.findBookByID(idBook);
                                            bookIdValid = true;
                                            System.out.println(book);
                                            System.out.println();
                                        } catch (IllegalArgumentException | BookNotFoundException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } break;

                                case 3:
                                    boolean loanIdValid = false;
                                    Loan loan = null;

                                    while (!loanIdValid){
                                        System.out.println("Loan ID: ");
                                        String input = scanner.nextLine();

                                        int loanId = 0;

                                        try{
                                            loanId = Integer.parseInt(input);
                                        } catch (NumberFormatException e){
                                            System.out.println("Id must be a number");
                                            continue;
                                        }

                                        try{
                                            loan = loanService.findLoanById(loanId);
                                            loanIdValid = true;
                                            System.out.println(loan);
                                            System.out.println();
                                        } catch (IllegalArgumentException | LoanNotFoundException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } break;

                                case 0:
                                    stopMenu = true;
                                    System.out.println("Returning to principal menu...");
                                    break;

                                default:
                                    System.out.println("Choose a valid option.");
                                    break;
                            }
                        } break;

                    case 5:
                        System.out.println("--REGISTER NEW BOOK--");
                        boolean bookCreated = false;

                        while (!bookCreated){
                            boolean validTitle = false;
                            boolean validAuthor = false;
                            boolean validQuantity = false;

                            String title = null;
                            String author = null;
                            int quantityAvailable = 0;

                            while (!validTitle || !validAuthor){
                                System.out.println();
                                System.out.println("Enter the book title: ");
                                String inputTitle = scanner.nextLine();

                                System.out.println("Enter the author name : ");
                                String inputAuthor = scanner.nextLine();

                                try {
                                    bookService.validateInputString(inputTitle);
                                    title = inputTitle;
                                    validTitle = true;

                                    bookService.validateInputString(inputAuthor);
                                    author = inputAuthor;
                                    validAuthor = true;

                                } catch (IllegalArgumentException e){
                                    System.out.println(e.getMessage());
                                }
                            }

                            while(!validQuantity){
                                try {
                                    System.out.println("Enter quantity :");
                                    String input = scanner.nextLine();
                                    quantityAvailable = Integer.parseInt(input);
                                    validQuantity = true;
                                } catch (IllegalArgumentException e){
                                    System.out.println("quantity must be a number.");
                                    System.out.println();
                                }
                            }


                            try {
                                bookService.createNewBook(title, author,quantityAvailable);
                                System.out.println("Book created successfully!");
                                bookCreated = true;
                            } catch (IllegalArgumentException | DuplicateEntryException e) {
                                System.out.println(e.getMessage());
                            }
                        } break;


                    case 6:

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


                                    case 7:
                                        boolean loanCreated = false;
                                        loanMenu:

                                        while (!loanCreated) {
                                            boolean bookIdValid = false;
                                            boolean userIdValid = false;
                                            boolean loanConfirmed = false;
                                            Book findedBook = null;
                                            User findedUser = null;

                                            while (!bookIdValid) {
                                                System.out.println("Book ID : ");
                                                String input = scanner.nextLine();

                                                int inputIdBook = 0;

                                                try{
                                                    inputIdBook = Integer.parseInt(input);
                                                } catch (NumberFormatException e){
                                                    System.out.println("Book id must be a number");
                                                    continue;
                                                }

                                                try {
                                                    findedBook = bookService.findBookByID(inputIdBook);
                                                    System.out.println(findedBook);
                                                    System.out.println();
                                                    bookIdValid = true;
                                                } catch (BookNotFoundException e) {
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
                                                } catch (NumberFormatException e) {
                                                    System.out.println("User id must be a number");
                                                    continue;
                                                }

                                                try {
                                                    findedUser = userService.findUserByID(inputIdUser);
                                                    System.out.println(findedUser);
                                                    System.out.println();
                                                    userIdValid = true;
                                                } catch (UserNotFoundException e) {
                                                    System.out.println(e.getMessage());
                                                    System.out.println();
                                                }
                                            }

                                                while(!loanConfirmed){
                                                    try{
                                                        System.out.println("Confirm loan? (y/n)");
                                                        String input = scanner.nextLine();
                                                        if (input.equals("y")){
                                                            try {
                                                                loanService.borrow(findedBook, findedUser);
                                                                System.out.println("Loan Created Successfully!");
                                                                loanConfirmed = true;
                                                                loanCreated = true;
                                                            } catch (LoanCreateException e) {
                                                                System.out.println(e.getMessage());
                                                            }
                                                        } else if (input.equals("n")) {
                                                            System.out.println("Returning to menu...");
                                                            break loanMenu;
                                                        }
                                                    } catch (LoanCreateException e){
                                                        System.out.println(e.getMessage());
                                                    }
                                                }
                                        }
                                        break;


                                    case 8:
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
                                            System.out.println("1 - Edit name");
                                            System.out.println("2 - Edit CPF");
                                            System.out.println("3 - Edit address");
                                            System.out.println("4 - Edit address number");
                                            System.out.println("5 - Edit phone number");
                                            System.out.println("6 - !Delete user!");
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
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println("Type only numbers");
                                                        }

                                                        try {
                                                            userService.updateCPF(user, newCPF);
                                                            validNewCpfForUpdate = true;
                                                            System.out.println("Changes save successfully");
                                                        } catch (DuplicateEntryException e){
                                                            System.out.println(e.getMessage());
                                                            System.out.println();
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
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println("Invalid phone number");
                                                            System.out.println();
                                                            continue;
                                                        }

                                                        try {
                                                            userService.updatePhoneNumber(user, newPhoneNumber);
                                                            validNewPhoneNumber = true;
                                                            System.out.println("Changes saved successfully!");
                                                        } catch (DuplicateEntryException e){
                                                            System.out.println(e.getMessage());
                                                            System.out.println();
                                                        }
                                                    } break;

                                                case 6:
                                                    System.out.println("You sure than delete user? (y/n)");
                                                    String input = scanner.nextLine();

                                                    if (input.equals("y")){
                                                        userService.deleteUser(user);
                                                        validateUserID = false;
                                                        System.out.println("user deleted successfully!");
                                                    } else if (input.equals("n")) {
                                                        System.out.println("returning to menu...");
                                                    }
                                                    break;
                                                case 0:
                                                    validateUserID = false;
                                                    break;

                                                default:
                                                    System.out.println("Choose a valid option.");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 9:
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
                                            System.out.println("3 - Add stock");
                                            System.out.println("4 - !Delete book!");
                                            System.out.println("0 - Exit to Main-Menu");

                                            int answer2 = scanner.nextInt();
                                            scanner.nextLine();
                                            switch (answer2) {
                                                case 1:
                                                    boolean titleUpdated = false;
                                                    String newTitle = null;

                                                    while (!titleUpdated){

                                                        boolean validNewTitle = false;

                                                        while (!validNewTitle){
                                                            System.out.println("New title: ");
                                                            String title = scanner.nextLine();

                                                            try{
                                                                bookService.validateInputString(title);
                                                                newTitle = title;
                                                                validNewTitle = true;

                                                            } catch (IllegalArgumentException e){
                                                                System.out.println("Invalid title");
                                                                System.out.println();
                                                            }
                                                        }

                                                        try{
                                                            bookService.updateTitle(foundBookToEdit, newTitle);
                                                            titleUpdated = true;
                                                            System.out.println("Changes saved successfully!");

                                                        } catch (DuplicateEntryException e){
                                                            System.out.println(e.getMessage());
                                                            System.out.println();
                                                        }
                                                    }break;

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

                                                case 3:
                                                    boolean quantityValid = false;

                                                    while (!quantityValid){
                                                        System.out.println("quantity: ");
                                                        String input = scanner.nextLine();

                                                        int quantity = 0;

                                                        try{
                                                            quantity = Integer.parseInt(input);
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println("quantity must be a number.");
                                                            System.out.println();
                                                            continue;
                                                        }

                                                        try {
                                                            bookService.addStock(quantity, foundBookToEdit);
                                                            quantityValid = true;
                                                            System.out.println("Stock updated successfully");
                                                        } catch (IllegalArgumentException e){
                                                            System.out.println(e.getMessage());
                                                        }
                                                    }break;

                                                case 4:
                                                    System.out.println("You sure than delete book? (y/n)");
                                                    String answer = scanner.nextLine();

                                                    if (answer.equals("y")){
                                                        bookService.deleteBook(foundBookToEdit);
                                                        System.out.println("book deleted.");
                                                        bookIdValid = false;
                                                    } else if (answer.equals("n")) {
                                                        System.out.println("returning to menu...");
                                                        continue;
                                                    }
                                                    break;

                                                case 0:
                                                    bookIdValid = false;
                                                    break;

                                                default:
                                                    System.out.println("Choose a valid option");
                                                    break;
                                            }
                                        }break;

                                    case 10:
                                        boolean loanIdValid = false;
                                        boolean confirmedReturnLoan = false;
                                        Loan loan = null;

                                        while (!loanIdValid) {
                                            System.out.println("Loan ID: ");
                                            String input = scanner.nextLine();

                                            int loanId = 0;

                                            try {
                                                loanId = Integer.parseInt(input);
                                            } catch (NumberFormatException e) {
                                                System.out.println("Id must be a number");
                                                continue;
                                            }

                                            try {
                                                loan = loanService.findLoanById(loanId);
                                                System.out.println(loan);
                                                loanIdValid = true;
                                            } catch (IllegalArgumentException | LoanNotFoundException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }

                                        while (!confirmedReturnLoan) {
                                            System.out.println("You sure you want to return this book? (y/n)");
                                            String input = scanner.nextLine();

                                            if (input.equals("y")) {
                                                try {
                                                    loanService.returnLoan(loan);
                                                    confirmedReturnLoan = true;
                                                    System.out.println("Loan returned with success");
                                                } catch (LoanAlreadyReturnedException e) {
                                                    System.out.println(e.getMessage());
                                                    break;
                                                }
                                            } else if (input.equals("n")) {
                                                System.out.println("Returning to menu...");
                                                break;
                                            } else {
                                                System.out.println("Answer with 'y' or 'n'");
                                            }
                                        } break;

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
