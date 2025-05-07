import EventStream.FitCarEventStreamer;
import gui.MainController;

class Main {


    static final String FILE = "src/main/resources/Burg_Rabenstein.fit";

    public static void main(String[] args) {

        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);

        MainController controller = new MainController();


    }
}