import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<String> isNotNull = str -> str != null;

        Predicate<String> isNotEmpty = str -> str != null && !str.isEmpty();

        Predicate<String> isNotNullAndNotEmpty = isNotNull.and(str -> !str.isEmpty());

        String testString1 = "ИСдо-45";
        String testString2 = "";
        String testString3 = null;
        String testString4 = "   ";

        System.out.println("Если строка не null");
        System.out.println("'" + testString1 + "' не null: " + isNotNull.test(testString1));
        System.out.println("'" + testString2 + "' не null: " + isNotNull.test(testString2));
        System.out.println("null не null: " + isNotNull.test(testString3));

        System.out.println("\nЕсли строка не пуста");
        System.out.println("'" + testString1 + "' не пуста: " + isNotEmpty.test(testString1));
        System.out.println("'" + testString2 + "' не пуста: " + isNotEmpty.test(testString2));
        System.out.println("null не пуста: " + isNotEmpty.test(testString3));

        System.out.println("\nЕсли строка не null и не пуста");
        System.out.println("'" + testString1 + "' не null и не пуста: " + isNotNullAndNotEmpty.test(testString1));
        System.out.println("'" + testString2 + "' не null и не пуста: " + isNotNullAndNotEmpty.test(testString2));
        System.out.println("null не null и не пуста: " + isNotNullAndNotEmpty.test(testString3));
        System.out.println("'" + testString4 + "' не null и не пуста: " + isNotNullAndNotEmpty.test(testString4));
    }
}