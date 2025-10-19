void main() {

    Supplier<Double> doubleSupplier = () -> Math.random() * 10;
    IO.println("Случайное double: " + doubleSupplier.get());

    Supplier<Integer> intSupplier = () -> new Random().nextInt(11);
    IO.println("Случайное int: " + intSupplier.get());

    for (int i = 0; i < 5; i++) {
        IO.println("Число " + (i + 1) + ": " + intSupplier.get());
    }
}