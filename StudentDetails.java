import java.util.*;

public class StudentDetails
{
   private int id;
   private String name;
   private int age;
   private String email;
   private String course;
   
   Scanner input = new Scanner(System.in);
   
   // Our database to store all the information 
   ArrayList<Integer> idInfo = new ArrayList<Integer>();
   ArrayList<String> nameInfo = new ArrayList<String>();
   ArrayList<Integer> ageInfo = new ArrayList<Integer>();
   ArrayList<String> emailInfo = new ArrayList<String>();
   ArrayList<String> courseInfo = new ArrayList<String>();
   
   public void startMenu(String key)
   {
      try
      {
         if( Integer.parseInt(key) == 1 )
         {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search a new student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print a student.");
            System.out.println("(5) Exit Application.");
                                            
            int selector = input.nextInt();
            
            switch(selector)
            {
               case 1: capture(); break;
               case 2: search(); break;
               case 3: delete(); break;
               case 4: printReport(); break;
               case 5: System.exit(0);   
               default: System.out.println("The number enter is not in the options, you may try again");  
            }
                      
         }
         else
         {
            System.exit(0);
         }
      }
      catch(Exception e)
      {
         System.exit(0);
      }
   
   }
   
   private void capture()
   {
     System.out.println("Enter the student id: ");
     id = input.nextInt(); input.nextLine();
     
     System.out.print("Enter the student name: ");
     name = input.nextLine();
     
     age = 0;
     
     while( age < 16 )
     {
        try
        {
            System.out.print("Enter the student age: ");
            age = Integer.parseInt(input.next());  input.nextLine(); // checks if age is a number 
            if( age < 16 ) throw new Exception("Incorect age");  // throw exception if age is less than 16 
           
        }
        catch(Exception e)
        {
            
            System.out.println("You have entered an incorrect student age!!!\nPlease re-enter the student age >>");
        }
    }
        
     System.out.print("Enter the student email: ");
     email = input.nextLine();
        
     System.out.print("Enter the student course: ");
     course = input.nextLine();
     
          
     idInfo.add(id);
     nameInfo.add(name);
     ageInfo.add(age);
     emailInfo.add(email);
     courseInfo.add(course);
     
     promptMenu();
     
     System.out.println("The student details have been saved successfully.");
     
   }
   
   private void promptMenu()     //This code checks the if the user stil want to access menu 
   {
         System.out.println("Enter (1) to launch menu or any other key to exit ");
         String check1 = input.nextLine();
         startMenu(check1);
   }

   private void search()
   {
      System.out.print("Enter the student id to search: ");
      int searchID = input.nextInt();
      System.out.println("--------------------------------------------");
      
      int index = idInfo.indexOf(searchID);
      
      if( index >= 0 )
      {
         showResults(index);
      }
      else
      {
         System.out.println("Student with student id: " + searchID + " was not found!");
      }
      
      System.out.println("--------------------------------------------");
      
      input.nextLine();
      promptMenu();

                 
      
   }
   private void showResults(int index)
   {
      System.out.println("STUDENT ID: "+idInfo.get(index));
      System.out.println("STUDENT NAME: " +nameInfo.get(index));
      System.out.println("STUDENT AGE: " + ageInfo.get(index));
      System.out.println("STUDENT EMAIL: " +emailInfo.get(index));
      System.out.println("STUDENT COURSE: " +courseInfo.get(index));
      
   }
   private void delete()
   {
      System.out.println("Enter the student id to delete: ");
      int idNumber = input.nextInt();  input.nextLine();
      int idDelete = idInfo.indexOf(idNumber);
      
      
      System.out.println("Are you sure you want to delete student " + idDelete + " from the system? Yes (y) to delete");
      String confirm = input.nextLine(); 
      
      if( confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("Yes")) 
      {
          idInfo.remove(idDelete);
          nameInfo.remove(idDelete);
          ageInfo.remove(idDelete);
          emailInfo.remove(idDelete);
          courseInfo.remove(idDelete);      
      }
       
       System.out.println("------------------------------------------------");
       System.out.println("Student with student id: " + idNumber+ " was deleted!");
       System.out.println("------------------------------------------------");

       
      promptMenu();
      
   }
   private void printReport()
   {
      for(int i = 0; i < idInfo.size(); i++)
      {
         int studentNumber = 1+i;
         System.out.println("STUDENT " + studentNumber);
         System.out.println("------------------------------------------------");
         showResults(i);
         System.out.println("------------------------------------------------");     
      }
      promptMenu();  
   }
   
}