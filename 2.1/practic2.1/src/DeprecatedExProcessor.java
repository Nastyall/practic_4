import java.lang.reflect.Method;

public class DeprecatedExProcessor {

    public static void processClass(Class<?> clazz) {
        if (clazz.isAnnotationPresent(DeprecatedEx.class)) {
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.printf("! класс '%s' устарел – альтернатива: '%s'%n",
                    clazz.getSimpleName(), annotation.message());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(DeprecatedEx.class)) {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.printf("! метод '%s' устарел – альтернатива: '%s'%n",
                        method.getName(), annotation.message());
            }
        }
    }

    public static void processClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            processClass(clazz);
        } catch (ClassNotFoundException e) {
            System.err.println("Класс не найден: " + className);
        }
    }
}