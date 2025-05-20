package EventStream;

import java.util.function.Consumer;

///  Represents a stream of car events, see jdk.jfr.consumer.EventStream.
interface CarEventStream {

    void onEvent(Consumer<CarEvent> action);

    void awaitTermination();

    void start() ;
}
