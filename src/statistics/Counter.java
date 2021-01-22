package statistics;

public class Counter {
    private static int economy;
    private static int standard;
    private static int deluxe;

    public void registerWash(String washtype) {
        switch (washtype) {
            case "ECONOMY": economy++; break;
            case "STANDARD":standard++; break;
            case "DELUXE": deluxe++; break;
        }
    }

    @Override
    public String toString() {
        return "Simple Statistics (eco, std, deluxe): " +
                economy + " " + standard + " " + deluxe;
    }
}


