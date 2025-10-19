import java.util.function.Consumer;

record HeavyBox(int weight) {
}

public class Main {
    static void main() {
        Consumer<HeavyBox> shipBox = box ->
                System.out.println("Отгрузили ящик с весом " + box.weight());

        Consumer<HeavyBox> sendBox = box ->
                System.out.println("Отправляем ящик с весом " + box.weight());

        Consumer<HeavyBox> combinedAction = shipBox.andThen(sendBox);

        HeavyBox box = new HeavyBox(190);
        combinedAction.accept(box);
    }
}