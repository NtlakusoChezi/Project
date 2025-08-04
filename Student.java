abstract class Subjects 
{
   private int mathsMark;
   private int physicsMark;
   private int other1;
   private int other2;
   private int other3;
   private int other4;
   private  int aps;
   
   private int calculateAPS()
   {
      return (int) (mathsMark/10 + physicsMark/10 + other1/10 + other2/10+ other3/10 + other4/10) -6;
   }

   //abstract void viewAvailableCourses();
   abstract void viewQualifiedCourses();
   
   public void setAPS(int a)
   {
      aps = a;
   }
   public int getAPS()
   {
      return calculateAPS();
   }
   public void setMathsMark(int m)
   {
      mathsMark = m;
   }
   public int getMathsMark()
   {
      return mathsMark;
   }
   public void setPhysicsMark(int a)
   {
      physicsMark = a;
   }
   public int getPhysicsMark()
   {
      return physicsMark;
   }
   public void setOther1(int m)
   {
      other1 = m;
   }
   public int getOther1()
   {
      return other1;
   }
   public void setOther2(int a)
   {
      other2 = a;
   }
   public int getOther2()
   {
      return other2;
   }
    public void setOther3(int m)
   {
      other3 = m;
   }
   public int getOther3()
   {
      return other3;
   }
   public void setOther4(int a)
   {
      other4 = a;
   }
   public int getOther4()
   {
      return other4;
   }
  
}