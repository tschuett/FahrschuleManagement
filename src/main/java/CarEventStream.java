import java.util.function.Consumer;

interface CarEventStream {

    void onEvent(Consumer<CarEvent> action);

}
