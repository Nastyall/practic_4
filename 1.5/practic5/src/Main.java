void main() {
    Function<Integer, String> numberClassifier = num -> {
        if (num > 0) {
            return "Положительное число";
        } else if (num < 0) {
            return "Отрицательное число";
        } else {
            return "Ноль";
        }
    };

    // Тестирование
    IO.println(numberClassifier.apply(5));
    IO.println(numberClassifier.apply(-3));
    IO.println(numberClassifier.apply(0));
    IO.println(numberClassifier.apply(10));
    IO.println(numberClassifier.apply(-7));
}