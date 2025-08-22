import java.util.*;
public class StudentMain
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      System.out.println("STUDENT MANAGEMENT APPLICATION");
      System.out.println("*************************************");
      System.out.println("Enter (1) to launch menu or any other key to exit.");
      String key = input.nextLine();           
      Student s = new Student();
      s.startMenu(key);
   }
}