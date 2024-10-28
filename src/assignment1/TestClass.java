package assignment1;

public class TestClass {
    public static void main(String[] args) {
        System.out.println("BANK ACCOUNT TEST");
        BankAccount bankAccount = new BankAccount(1000);
        System.out.println("Account Number: "+bankAccount.getAccountNumber());
        System.out.println("Current Balance: "+bankAccount.getBalance());
        System.out.println("Depositing 1000...");
        bankAccount.deposit(1000);
        System.out.println("Current Balance: "+bankAccount.getBalance());
        System.out.println("Withdrawing 500...");
        bankAccount.withdraw(500);
        System.out.println("Current Balance: "+bankAccount.getBalance()+"\n");

        System.out.println("MATH FUNCTION TEST");
        System.out.println("Calculating 2(3^3) recursively... "+ MathFunction.multiplyRecursive(3));
        System.out.println("Calculating sqrt(16)... "+ MathFunction.sqrt(16, 0, 16)+"\n");

        System.out.println("STUDENT TEST");
        Student student = new Student("John Doe", "123456");
        System.out.println("Adding grades: 90, 80, 70, 60...");
        student.addGrade(90);
        student.addGrade(80);
        student.addGrade(70);
        student.addGrade(60);
        System.out.println("Average grade: "+student.getAverageGrade()+"\n");

        System.out.println("LIBRARY TEST");
        System.out.println("Creating library...");
        Library library = new Library();
        System.out.println("Adding books...");
        Book book1 = new Book("Book1", "Charlie", "978-1-56619-909-4");
        Book book2 = new Book("Book2", "James", "978-92-95055-02-5");
        Book book3 = new Book("Book3", "Lewis", "978-29-18462-124-5");
        System.out.println("Adding books to library...");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        System.out.println("Printing books...");
        library.printBooks();
        System.out.println("\nRemoving book with ISBN 978-92-95055-02-5...\n");
        library.removeBook("978-92-95055-02-5");
        System.out.println("Printing books...");
        library.printBooks();
    }
}
