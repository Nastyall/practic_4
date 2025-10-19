@FunctionalInterface
interface Printable {
    void print();
}

public class Main {
    public static void main(String[] args) {
        Printable printer = () -> System.out.println("ИСдо-45");

        printer.print();

        Printable datePrinter = () -> System.out.println("Сегодняшняя дата: " + java.time.LocalDate.now());
        datePrinter.print();

        Printable numberPrinter = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Число: " + i);
            }
        };
        numberPrinter.print();
    }
}