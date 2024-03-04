import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {
    private static final int TOTAL_GET_CALLS = 10;
    private PriorityQueue<Toy> queue;

    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.initializeQueue();
        toyStore.executeGetCalls();
        toyStore.writeResultsToFile();
    }

    // Initialize the queue with Toy objects
    private void initializeQueue() {
        queue = new PriorityQueue<>();
        
        // Add Toy objects to the queue with given id, name, and weight
        addToyToQueue("1", "robot", 2);
        addToyToQueue("2", "doll", 6);
        addToyToQueue("3", "car", 3);
    }

    // Method to add a new Toy object to the queue
    private void addToyToQueue(String id, String name, int weight) {
        Toy toy = new Toy(id, name, weight);
        queue.add(toy);
    }

    // Execute the Get calls and print the results
    private void executeGetCalls() {
        for (int i = 0; i < TOTAL_GET_CALLS; i++) {
            int randomValue = getRandomValue();

            // Get the toy from the queue based on the random value
            Toy toy = getToyFromQueue(randomValue);

            // Print the toy information
            System.out.println("Get " + (i + 1) + ": " + toy.getId());
        }
    }

    // Get a random value between 1 and 100
    private int getRandomValue() {
        return (int) (Math.random() * 100) + 1;
    }

    // Get the toy from the queue based on the random value
    private Toy getToyFromQueue(int randomValue) {
        int accumulatedWeight = 0;
        Toy selectedToy = null;

        // Iterate through the queue and find the toy based on the random value
        for (Toy toy : queue) {
            accumulatedWeight += toy.getWeight();

            if (randomValue <= accumulatedWeight) {
                selectedToy = toy;
                break;
            }
        }

        return selectedToy;
    }

    // Write the results to a file
    private void writeResultsToFile() {
        try {
            FileWriter writer = new FileWriter("results.txt");

            for (int i = 0; i < TOTAL_GET_CALLS; i++) {
                int randomValue = getRandomValue();
                Toy toy = getToyFromQueue(randomValue);
                writer.write("Get " + (i + 1) + ": " + toy.getId() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Toy class with id, name, and weight fields
    private class Toy implements Comparable<Toy> {
        private String id;
        private String name;
        private int weight;

        public Toy(String id, String name, int weight) {
            this.id = id;
            this.name = name;
            this.weight = weight;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Toy otherToy) {
            return Integer.compare(this.weight, otherToy.getWeight());
        }
    }
}

        
        
   
