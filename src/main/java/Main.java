import EventStream.FitCarEventStreamer;

class Main {


    static final String FILE = "src/main/resources/Burg_Rabenstein.fit";

    public static void main(String[] args) {

        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
    }
}