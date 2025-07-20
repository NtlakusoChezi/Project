import java.util.*;
public class College
{
   public static void main(String[] sgh)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("STUDENT MANAGEMENT APPLICATION");
      System.out.println("*************************************");
      System.out.println("Enter (1) to launch menu or any other key to exit.");
      String key = input.nextLine();           
      StudentDetails s = new StudentDetails();
      s.startMenu(key);
   }
}