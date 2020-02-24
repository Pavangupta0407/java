package assignment;
import java.util.Scanner;

class Myexception extends Exception
{
    String s;
    Myexception(String s)
    {
        this.s= s;
    }
    @Override
    public String toString()
    {
        return s;
    }
}
class student
{
    String name;
    float CGPA;
    String Enroll;
    String Pass;
    Exception e=new Exception();
    void getdata()
    {
        try
        {
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter name: ");
            name=sc1.next();
            if(name==null)
            {
                throw new Myexception("Invalid name");
            }
            System.out.println("Enter cgpa:");
            CGPA=sc1.nextFloat();
            if(CGPA<0 || CGPA>10)
            {
                throw new Myexception("Invalid cgpa");
            }
            System.out.println("Enter enrollment number: ");
            Enroll=sc1.next();
            String s1,s2,s3,s4;
            s1=Enroll.substring(0,2);
            s2=Enroll.substring(2,4);
            s3=Enroll.substring(4,7);
            s4=Enroll.substring(7,Enroll.length());
            int year=Integer.parseInt(s2);
            int roll=Integer.parseInt(s4);
            if(!(s1.equals("BE"))&&(year<11 || year>20)&&(!(s3.equals("CSU")) || !(s3.equals("EEU")) || !(s3.equals("ESU")) || !(s3.equals("MEC")))&&(roll<0 || roll>250))
            {
                throw new Myexception("Invalid enrollment number");
            }
            System.out.println("Enter password: ");
            Pass=sc1.next();
            int i;
            int len=Pass.length();
            boolean low=false,up=false,num=false,sp=false;
            for(i=0;i<len;i++)
            {
                char ch=Pass.charAt(i);
                int as=(int)ch;
                if(as>=65 || as<=90)
                {
                    up=true;
                }
                else if(as>=97 || as<=122)
                {
                    low=true;
                }
                else if(as>=48 || as<=57)
                {
                    num=true;
                }
                else if(as==35 || as==36 || as==38 || as==64 || as==42)
                {
                    sp=true;
                }
            } 
            if(len<8 && (up==false && low==false && num==false && sp==false ))
            {
                throw new Myexception("Invalid password");
            }      
        }
        catch(Myexception e)
        {
            System.out.println(e);
        }
        
    }
    void display()
    {
        System.out.println("STUDENT NAME: "+name);
        System.out.println("ENROLLMENT NUMBER: "+Enroll);
        System.out.println("CGPA: "+CGPA);
        System.out.println("PASSWORD: "+Pass);
    }
}
public class Main
{
    public static void main(String args[])
    {
        student ob=new student();
        ob.getdata();
        ob.display();
    }
}

