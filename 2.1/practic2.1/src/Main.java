@DeprecatedEx(message = "Используйте новый класс NewCalculator")
class OldCalculator {

    @DeprecatedEx(message = "Используйте метод addNumbers()")
    public int add(int a, int b) {
        return a + b;
    }

    @DeprecatedEx(message = "Используйте метод multiplyNumbers()")
    public int multiply(int a, int b) {
        return a * b;
    }

    public void displayResult(int result) {
        System.out.println("Результат: " + result);
    }
}

@DeprecatedEx(message = "Замените на ModernStringProcessor")
class StringUtils {
    @DeprecatedEx(message = "Используйте String.join()")
    public static String concatenate(String... strings) {
        return String.join("", strings);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(" Анализ OldCalculator ");
        DeprecatedExProcessor.processClass(OldCalculator.class);

        System.out.println("\nАнализ StringUtils ");
        DeprecatedExProcessor.processClass(StringUtils.class);

        System.out.println("\nАнализ по имени класса ");
        DeprecatedExProcessor.processClass("OldCalculator");
    }
}