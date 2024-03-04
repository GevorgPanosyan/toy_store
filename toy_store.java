import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore{
    private static final int TOTAL_GET_CALLS =10;
    private PriorityQueue<Toy>queue;

    public static void main(String[] args){
        ToyStore toyStore = new ToyStore();
        toyStore.initializeQueue();
        toyStore.executeGetCalls();
        toyStore.writeResults To File();
    }

    // Initialize the queue with Toy objects
    private void initializeQueue(){
        queue = new PriorityQueue<>();

   //Add Toy objects to the queue with given id,name and weight
   addToyQueue("1","robot",2); 
   addToyQueue("2","doll",6);
   addToyQueue("3","car",3);
    }

  //Method to add a new Toy object to the queue
  private void addToyToQueue(String id,String name, int weight){
    Toy toy = new Toy(id,name,weight);
    queue.add(toy);
  }

  //Execute the Get calls and print the results
  private void executeGetCalls(){
    for(int i = 0; i < TOTAL_GET_CALLS; i++){
      int randomValue =getRandomValue();

      //Get thr toy from the queue based on the random value
      Toy toy = getToyFromQueue(randomValue);

      //print the toy information 
      System.out.println("Get"+(i+1)+":"+toy.getID());
    }
  }

  //Get random value between 1 and 100
  private int getRandomValue(){
    return(int)(Math.random()*100)+1;
  }

  //Get the toy from the queue based on the random value
  private Toy getToyFromQueue(int random Value){
    int accumulatedWeight = 0;
    Toy selectedToy = null;

    //Iterate through the queue and find the toy based on the random value
    for(Toy toy:queue){
      accumulatedWeight += toy.get.Weight();

      if(randomValue <= accumulatedWeight){
        selectedToy = toy;
        break;
      }
    }
    return selectedToy;
  }

  //Write the result to a file
  private void writeResultsToFile(){
    try{
      FileWriter writer = new FileWriter("results.txt");

      for(int i = 0; i < TOTAL_GET_CALLS; i++){
        int randomValue = getRandomValue();
        Toy toy = getToyFromQueue(randomValue);
        writer.write("Get"+(i+1)+":"+toy.getID()+"\n");
      }
      writer.close();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
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
   
