import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore{
  private static final int TOTAL_GET_CALLS = 10;
  private PriorityQueue<Toy>queue;

  public static void main(String[] args){
    ToyStore toyStore = new ToyStore();
    toyStore.initializeQueue();
    toyStore.executeGetCalls();
    toyStore.writeResults To File();
  }

  //Initialize the queue with Toy objects
  private void initializeQueue(){
    queue = new PriorityQueue<>();
    
