import java.util.*;
class StudentGrade
{
  public static void main(String ar[])
  {
   Scanner sc= new Scanner(System.in);
   System.out.println("Enter the number of subjects");
   int subject=sc.nextInt();
   int i;
   double grade[]=new double[subject];
   double total=0;
   for(i=0;i<subject;i++)
   {
	   System.out.println("Enter grade of subject="+(i+1)+"");
	   grade[i]=sc.nextDouble();
	   total=total+grade[i];
   }
    double average=total/subject;
	System.out.println("Average Grade ="+average);
	
	String Final;
	if(average>=90)Final="A";
	else if(average>=80)Final="B";
	else if(average>=70)Final="C";
	else if(average>=60)Final="D";
	else Final="F";
	System.out.println("Final grade of Student ="+Final);
   
  }
}