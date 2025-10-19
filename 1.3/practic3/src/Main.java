import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> startsWithJorN = s -> s != null && (s.startsWith("J") || s.startsWith("N"));

        Predicate<String> endsWithA = s -> s != null && s.endsWith("A");

        Predicate<String> startsWithJorNAndEndsWithA = startsWithJorN.and(endsWithA);

        // Тестовые строки
        String[] testStrings = {
                "JAVA",
                "NOVA",
                "JAVASCRIPT",
                "PYTHONA",
                "JAVAA",
                "NODEA",
                "C++",
                "Kotlin",
        };
        System.out.println("Проверка строк");
        for (String str : testStrings) {
            boolean isValid = startsWithJorNAndEndsWithA.test(str);
            System.out.printf("Строка '%s': %s%n", str, isValid ? "Правильно" : "Неправильно");
        }
    }
}