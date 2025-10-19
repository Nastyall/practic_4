import java.lang.reflect.Method;

public class AdvancedDeprecatedExProcessor {

    public static void processClassRecursive(Class<?> clazz) {
        processClassInternal(clazz);

        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null && !superClass.equals(Object.class)) {
            processClassRecursive(superClass);
        }
    }

    private static void processClassInternal(Class<?> clazz) {
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            printClassWarning(clazz.getSimpleName(), annotation.message());
        }

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                printMethodWarning(method.getName(), annotation.message());
            }
        }
    }

    private static void printClassWarning(String className, String message) {
        System.out.printf(" КЛАСС УСТАРЕЛ: '%s' -> используйте: '%s'%n",
                className, message);
    }

    private static void printMethodWarning(String methodName, String message) {
        System.out.printf(" МЕТОД УСТАРЕЛ: '%s' -> используйте: '%s'%n",
                methodName, message);
    }
}