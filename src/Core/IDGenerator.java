package Core;

public class IDGenerator {
    private static int currentId = 1;

    public synchronized static int getNextId() {
        return currentId++;
    }

    public synchronized static void reset() {
        currentId = 1;
    }
}
