package br.com.pelissaro.librarySystem.App;

import br.com.pelissaro.librarySystem.Service.BookService;

import java.util.Scanner;

public class LibraryApp {
    public static void startLibrary(){

        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==Library System Terminal==");
        System.out.println("--------------------------");
        System.out.println("-- Menu --");
        System.out.println("1 - Register Book ");
        int choose = scanner.nextInt();
        scanner.nextLine();

        switch (choose){
            case 1:
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
                System.out.println();
                System.out.println("1 - Show Books ");
                int choose2 = scanner.nextInt();
                scanner.nextLine();
                if (choose2 == 1) {
                    bookService.showBooks();
                }
        }
    }
}
