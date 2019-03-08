package Project1; 
import java.io.*;
import java.util.*;  
public class Calculated {
 
 
   int[][] array = new int[10000][2]; 
   public static void main(String[] args) {
   
   
      Calculated obj = new Calculated();
      obj.run();
      obj.print();
      System.out.println();
      obj.sortfile();
      obj.array = obj.totalunit(obj.array);
      obj.print();      
      System.out.println();
   }
   
  
   public void print(){
      for(int i = 0; i < array.length; i++){
         if(array[i][0] != 0)
            System.out.println(array[i][0] + " " + array[i][1]);
      }
   }
   
   
   public void sortfile(){
      Arrays.sort(array, new Comparator<int[]>() {
         public int compare(final int[] row1, final int[] row2) {
                  if(row1[0] < row2[0])
                     return -1;
                  else if(row1[0] > row2[0])
                     return 1;
                  else
                     return 0;
         }
      });
   }
 
    public int [][] totalunit(int[][] array)
    {
       
       int [][] pid = new int[10000][2];
       int currentID;
       int previousID = array[0][0];
       int pid1 = 0; 
       for(int spot = 0; spot<pid.length; spot++){
          currentID = array[spot][0];
          
          if (currentID != previousID)
          {
            pid1++;
          }
          
          pid[pid1][0]= array[spot][0];
          pid[pid1][1]+= array[spot][1];
          previousID = currentID;
       }
       return pid;
    }
   public void run() 
   {
      String csvFile = "Project1/Sales Data.csv";
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";
      int index = 0;
   
      try {
      
         br = new BufferedReader(new FileReader(csvFile));
         br.readLine();
         while ((line = br.readLine()) != null) {
         
            String[] salesData = line.split(cvsSplitBy);
            array[index][0] = Integer.parseInt(salesData[0]);
            array[index][1] = Integer.parseInt(salesData[1]);
            index++;
         }
      
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      } 
      catch (IOException e) {
         e.printStackTrace();
      } 
      finally {
         if (br != null) {
            try {
               br.close();
            } 
            catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
   
      System.out.println("ProductID   Units");
   }
 
}
