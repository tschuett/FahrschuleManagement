package EventStream;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class EventConsumer implements Consumer<CarEvent> {
    private final ArrayList<CarEvent> events = new ArrayList<>();


    @Override
    public void accept(CarEvent event) {
        events.add(event);
    }

    public Stream<CarEvent> stream() {
        return events.stream();
    }
}
