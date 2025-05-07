package EventStream;

import java.util.function.Consumer;

interface CarEventStream {

    void onEvent(Consumer<CarEvent> action);

    void awaitTermination();

    void start() ;
}
