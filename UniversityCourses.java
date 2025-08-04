import java.util.*;
class UniversityCourses extends Subjects
{      
   Scanner input = new Scanner(System.in);
   //This will be our database in the format of course - mathsMarks - PhysMarks - APS. This shows the minimun required marks for entry in different unis
   String[][] univen = { {"Botany", "40", "50","26"}, {"Biochemistry", "50", "40","26"} ,{"Computer Science", "50", "50","30"},
    {"Mathematics", "60", "50","28"} ,{"Statistics", "30", "50","50"}, {"Phyics", "40", "50","30"}, {"Zoology", "50", "50","50"} };
   String[][] uj = { {"Acturial Science", "70", "50","33"}, {"Biochemistry", "50", "60","30"} ,{"Computer Science", "60", "50","30"},
    {"Mathematics", "50", "50","30"} ,{"Statistics", "60", "50","30"}, {"Phyics", "40", "50","28"}, {"Informatics", "60", "40","33"} };
   String[][] wits = { {"Botany", "60", "60","35"}, {"Biochemistry", "60", "60","33"} ,{"Computer Science", "70", "60","35"},
    {"Mathematics", "50", "50","50"} ,{"Statistics", "50", "50","50"}, {"Phyics", "50", "50","50"}, {"Phyics", "50", "50","50"} };
   String[][] up ={ {"Botany", "60", "50","30"}, {"Biochemistry", "50", "50","31"} ,{"Computer Science", "70", "50","33"},
    {"Mathematics", "60", "60","32"} ,{"Statistics", "60", "60","31"}, {"Phyics", "60", "60","30"}, {"Chemical Englineering", "50", "50","31"} };
   String[][] ul = { {"Medicine", "70", "50","36"}, {"Biochemistry", "50", "50","30"} ,{"Computer Science", "50", "40","30"},
    {"Mathematics", "60", "50","30"} ,{"Statistics", "60", "50","28"}, {"Phyics", "50", "40","30"}, {"Applied Mathematics", "50", "40","30"} };
   String[][] ufs = { {"Botany", "50", "50","50"}, {"Biochemistry", "50", "50","50"} ,{"Computer Science", "50", "50","50"},
    {"Mathematics", "50", "50","50"} ,{"Statistics", "50", "50","50"}, {"Phyics", "50", "50","50"}, {"Phyics", "50", "50","50"} };
   String[][] uct ={ {"Botany", "50", "50","50"}, {"Biochemistry", "50", "50","50"} ,{"Computer Science", "50", "50","50"},
    {"Mathematics", "50", "50","50"} ,{"Statistics", "50", "50","50"}, {"Phyics", "50", "50","50"}, {"Phyics", "50", "50","50"} };
   String[][] uwc = { {"Accounting Science", "40", "50","50"}, {"Biochemistry", "50", "50","50"} ,{"Computer Science", "50", "50","50"},
    {"Mathematics", "50", "50","50"} ,{"Statistics", "50", "50","50"}, {"Phyics", "50", "50","50"}, {"Phyics", "50", "50","50"} };
   String[][] nmu ={ {"Botany", "50", "50","50"}, {"Biochemistry", "50", "50","50"} ,{"Computer Science", "50", "50","50"},
    {"Mathematics", "50", "50","50"} ,{"Statistics", "50", "50","50"}, {"Phyics", "50", "50","50"}, {"Phyics", "50", "50","50"} };
   String[][] ump = { {"Food Science", "40", "40","40"}, {"Biochemistry", "50", "50","50"} ,{"Computer Science", "50", "50","50"},
    {"Mathematics", "50", "50","50"} ,{"Statistics", "50", "50","50"}, {"Phyics", "50", "50","50"}, {"Phyics", "50", "50","50"} };
    
    public UniversityCourses()
    {
      System.out.println("Please enter the following six(6) marks excluding Life Orientation:" );
      System.out.print("Mathematics: ");        setMathsMark(input.nextInt());
      System.out.print("Physical Sciences: ");  setPhysicsMark(input.nextInt());
      System.out.print("Other subject 1: ");    setOther1(input.nextInt());
      System.out.print("Other subject 2: ");    setOther2(input.nextInt());
      System.out.print("Other subject 3: ");    setOther3(input.nextInt());
      System.out.print("Other subject 4: ");    setOther4(input.nextInt());      
      input.nextLine();
      promptMenu();
    }
    
    private void promptMenu()
    {
      System.out.println("Please select one of the options");
      System.out.println("(1) Display a list of science courses available in South African universities");
      System.out.println("(2) Display a list of science courses you qualify for in South African universities");
      System.out.println("(3) Calculate your APS");
      System.out.println("(4) Exit the Application");
      
      int option = input.nextInt(); input.nextLine();
      
      try
      {
         switch(option)
         {
            case 1: viewAvailableCourses(); break;
            case 2: viewQualifiedCourses(); break;
            case 3: System.out.println("Your APS is " +getAPS()); break;
            case 4: System.exit(0); break;
            //case 1: view(); break;
            default: System.out.println("You are attempting to enter an incorrect option. Try again later"); break;

         }
      }
      catch(Exception e)
      {
         System.out.println("You have entered an invalid option. Try again later");
      }
      promptMenu();

    }
    
        
    public void viewAvailableCourses()    
    { 
      for( int i = 0; i < 10; i++) //This is each university
      {
         System.out.println();
         if( i == 0 ){  System.out.println("The list of all available science courses at the university of Venda (Univen) are:"); }
         else if( i == 1 ){  System.out.println("The list of all available science courses at the university of Johannesburg (UJ) are:"); }
         else if( i == 2 ){  System.out.println("The list of all available science courses at the university of Witwatersrand (WITS) are:"); }
         else if( i == 3 ){  System.out.println("The list of all available science courses at the university of Pretoria (UP) are:"); }
         else if( i == 4 ){  System.out.println("The list of all available science courses at the university of Limpopo (UL) are:"); }
         else if( i == 5 ){  System.out.println("The list of all available science courses at the university of Free State (UFS) are:"); }
         else if( i == 6 ){  System.out.println("The list of all available science courses at the university of Cape Town (UCT) are:"); }
         else if( i == 7 ){  System.out.println("The list of all available science courses at the university of Western Cape (UWC) are:"); }
         else if( i == 8 ){  System.out.println("The list of all available science courses at the university of Nelson Mandela (NMU) are:"); }
         else if( i == 9 ){  System.out.println("The list of all available science courses at the university of Mpumalanga (UMP) are:"); }
         
         for( int j = 0; j < 7; j++) // This is a certain course in a university like 
         {      
               System.out.println(university(i)[j][0] );
         }
      }
    }
    
    public void viewQualifiedCourses()    
    { 
      for( int i = 0; i < 10; i++) //This is each university
      {
         if( i == 0 ){  System.out.println("The list of courses you qualify for at the university of Venda are: "); }
         if( i == 1 ){  System.out.println("The list of courses you qualify for at the university of uj are: "); }
         if( i == 2 ){  System.out.println("The list of courses you qualify for at the university of wits are: "); }
         if( i == 3 ){  System.out.println("The list of courses you qualify for at the university of Limpopo are: "); }
         if( i == 4 ){  System.out.println("The list of courses you qualify for at the university of Pretoria are: "); }
         if( i == 5 ){  System.out.println("The list of courses you qualify for at the university of Free State are: "); }
         if( i == 6 ){  System.out.println("The list of courses you qualify for at the university of Cape Town are: "); }
         if( i == 7 ){  System.out.println("The list of courses you qualify for at the university of Western Cape are: "); }
         if( i == 8 ){  System.out.println("The list of courses you qualify for at the university of Nelson Mandela are: "); }
         if( i == 9 ){  System.out.println("The list of courses you qualify for at the university of Mpumalanga are: "); }
         
         for( int j = 0; j < 7; j++) // This is a certain course in a university like 
         {
            if( Integer.parseInt( university(i)[j][1] ) <= getMathsMark()  &&  Integer.parseInt( university(i)[j][2] ) <= getPhysicsMark() &&  Integer.parseInt( university(i)[j][3] ) <= getAPS())
            {
               //System.out.println( univen[j][0] );
               System.out.println(university(i)[j][0] );
            }
         }
      }
    }
    
    private String[][] university(int i)
    {
      switch(i)
      {
         case 0: return univen;
         case 1: return uj;
         case 2: return wits;
         case 3: return up;
         case 4: return ul;
         case 5: return ufs; 
         case 6: return uct; 
         case 7: return uwc; 
         case 8: return nmu; 
         case 9: return up; 
      }
      return univen;
    }


}