package EventStream;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

public final class CSVCarEventStreamer implements CarEventStream {
    ArrayList<CarEvent> events = new ArrayList<>();
    ArrayList<Consumer<CarEvent>> listeners = new ArrayList<>();

    CSVCarEventStreamer() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader("yourfile.csv")).build();
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }
    }

    @Override
    public void onEvent(Consumer<CarEvent> action) {
          listeners.add(action);
    }

    @Override
    public void awaitTermination() {
        for (CarEvent event: events) {
            for (Consumer<CarEvent> listener: listeners) {
                listener.accept(event);
            }
        }
    }

    @Override
    public void start()  {
    }
}

