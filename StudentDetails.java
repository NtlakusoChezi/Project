import java.util.*;

public class StudentDetails
{
   //Our object field
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
         if( Integer.parseInt(key) == 1 )   //This will display after we get a message to press 1 or exit
         {
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search a new student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print a student.");
            System.out.println("(5) Exit Application.");
                                            
            int selector = input.nextInt();  
            
            switch(selector)  //This part will enter the option you choose. Our methods are defined below
            {
               case 1: capture(); break;
               case 2: search(); break;
               case 3: delete(); break;
               case 4: printReport(); break;
               case 5: System.exit(0);   
               default: System.exit(0);
 
            }
                      
         }
         else
         {
            System.exit(0);
         }
      }
      catch(Exception e)  // 
      {
         System.exit(0);
      } 
   }
   
   //This methods allows us to capture student data and save it to our database  ////////////////////////
   private void capture()
   {
     System.out.print("Enter the student id: "); input.nextLine();
     boolean idVerifier = false;
     
     while( !idVerifier)
     {
      try
      {
          id = input.nextInt(); input.nextLine();
          idVerifier = verifyID(id);
          
          if( idInfo.indexOf(id) > -1 )  //Checks if the id is already in our database
          {
            System.out.println("The student id " +id+" already exists in our system! Therefore...");
           throw new Exception("ID already exists!"); 
           
          }
          
          if( idVerifier ) {  break;  }
          
          else {  System.out.print("You have entered an invalid id!\nPlease re-enter the id: "); }
      }
      catch(Exception e)
      {
         System.out.print("You have entered an invalid id!\nPlease re-enter the id: ");
         input.nextLine();
      }
     }
     idInfo.add(id);  //add id ///////////////////////////////////////////////////////////////////
    
     System.out.print("Enter the student name: ");
     
     boolean nameVerifier = false;
     
     while( !nameVerifier)
     {
       name = input.nextLine();
       nameVerifier = verifyName(name);
       
       if( nameVerifier ) {   break;   }
       
       else { System.out.print("You have entered an invalid name!\nPlease re-enter the name: ");    }
     }
     nameInfo.add(name);  // add name to the sysem ///////////////////////////////////////////////////
     
     age = 0;              //This renews age to be 0 so that it enters. It took us days to debug this line
     
     System.out.print("Enter the student age: ");
     while( age < 16 )
     {
        try
        {
            age = Integer.parseInt(input.nextLine());  // checks if age is a number 
            if( age < 16 ) throw new Exception("Incorect age");  // throw exception if age is less than 16            
        }
        catch(Exception e)
        {            
            System.out.print("You have entered an incorrect student age!!!\nPlease re-enter the student age >> ");
            //age = Integer.parseInt(input.next()); 
            // input.nextLine();
           // age = 0;

        }
        
    }
    ageInfo.add(age); // add age to the system ///////////////////////////////////////////////////////


        
     System.out.print("Enter the student email: ");
     //email = input.nextLine();
     
     boolean verifier = true;
     
     while( verifier )
     {
       email = input.nextLine();
       verifier = verifyEmail(email);
       
       if( verifier == false )
       { 
         System.out.print("You have entered an invalid email!\nPlease re-enter the email>> "); 
         verifier = true;
       }
       else  { break;}
       
       //System.out.print("Enter the student email: ");
     }
     emailInfo.add(email); //Add email to our system////////////////////////////////////////////////////
        
     System.out.print("Enter the student course: ");     
     boolean courseVerifier = false;
     
     while( !courseVerifier)
     {
       course = input.nextLine();
       courseVerifier = verifyName(course);
       
       if( courseVerifier ) {   break;   }
       
       else { System.out.print("You have entered an invalid course!\nPlease re-enter the course >> ");    }
     }
      courseInfo.add(course);  //Add course to our system//////////////////////////////////////////////
     
     promptMenu();
     
     System.out.println("The student details have been saved successfully.");
     
   }
   
   private void promptMenu()     //This code checks the if the user stil want to access menu 
   {
         System.out.println("Enter (1) to launch menu or any other key to exit ");
         String check1 = input.nextLine();
         startMenu(check1);
   }

   //This method allows us to browce through aour database to look for a certain id
   private void search()
   {
            
      int searchID = 0;
      System.out.print("Enter the student id to search: "); input.nextLine();
                 
      while( searchID < 1000 )
      {
         try
         {
            searchID = Integer.parseInt((input.nextLine()).trim()); 
            if( searchID < 1000 ) throw new Exception("Invalid id");  
         }     
         catch(Exception e)
         {
            //searchID = Integer.parseInt(input.nextLine()); 
            System.out.print("You are attemping to search for an invalid id. Please enter a valid! ");           
         }
      }
      
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
      promptMenu();

      input.nextLine();
      input.nextLine();   //here was an error, uncomment

      //promptMenu();  promptMenu();      
   }
   
   //Simplfyin method for printing///////////////////////////////////////////////////////////////////
   private void showResults(int index)
   {
      System.out.println("STUDENT ID: "+idInfo.get(index));
      System.out.println("STUDENT NAME: " +nameInfo.get(index));
      System.out.println("STUDENT AGE: " + ageInfo.get(index));
      System.out.println("STUDENT EMAIL: " +emailInfo.get(index));
      System.out.println("STUDENT COURSE: " +courseInfo.get(index));     
   }
   
   //This method deletes the data of a particular student with a particular ID///////////////////////////////////
   private void delete()
   {
      System.out.print("Enter the student id to delete: ");
      int idNumber = input.nextInt();  input.nextLine(); 
      int idDelete = idInfo.indexOf(idNumber);     
      
      System.out.println("Are you sure you want to delete student " + idDelete + " from the system? Yes (y) to delete.");
      String confirm = input.nextLine(); 
      
      if( confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("Yes")) 
      {
          idInfo.remove(idDelete);
          nameInfo.remove(idDelete);
          ageInfo.remove(idDelete);
          emailInfo.remove(idDelete);
          courseInfo.remove(idDelete);      
          
          System.out.println("------------------------------------------------");
          System.out.println("Student with student id: " + idNumber+ " was deleted!");
          System.out.println("------------------------------------------------");
       }
       else
       {
         //?We need to figure out what to do if the anwer is no
       }
       
      promptMenu();
      
   }
   //This method displays the details of every student in our database
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
      input.nextLine();
      promptMenu();  
   }
   // This methods makes allows the user to exit
   private void Exit()
   {
      System.exit(0);
   }
      //information hiding, encapsulation
      public void SaveStudent(){ capture(); }
      public void SearchStudent(){ search(); }
      public void DeleteStudent(){ delete(); }
      public void StudentReport(){  printReport(); }
      public void ExitStudentApplication (){ Exit(); }
      
      //Additional methods 
      public boolean verifyName(String n)
      {
         String nam = n.trim();
         char[] characters = nam.toCharArray();
         
         for( int i = 0; i< characters.length; i++)  // names can cointain . and should be at least bigger than 2 letters
         {
            int compare = (int) characters[i];
            if( compare < 46 || ( compare > 46 && compare < 65 ) ||compare > 122 || characters.length < 2  )
            {
               return false;
            }
         }
         return true;
      }
      private boolean verifyEmail(String e)  // We assume that a valid email should have more than 5 char with @
      {
         String emailAddress = e.trim();
         String[] emailArray = emailAddress.split("");
         
         for(int i = 0; i < emailArray.length; i++)
         {
            if( emailArray[i].equals("@") && emailArray.length > 4)
            {
               return true;
            }
         }
         return false;
      }
      private boolean verifyID(int idd)   //We assume that an id is a number without commas and bigger than 5 didgits
      {
         if( (idd%2==0 || idd%2 == 1) && idd / 1000 > 1) {   return true;  } return false;
      }
      //We assume a student must have a course, and course name shouldn't be empty nor should it have special character
      private boolean verifyCourse(String course)
      {
         return verifyName(course);
      }
      // We assume that student ids are unique, so, let's verify before capturing
}