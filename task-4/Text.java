import java.io.*;
import java.util.*;

public class Text{
    public static void Copydata(File file1,File file2) throws Exception{
        FileInputStream Input = new FileInputStream(file1);
        FileOutputStream Output = new FileOutputStream(file2);
        try{
            int i;
            while((i=Input.read())!=-1){
                Output.write(i);
            }
        }catch(Exception e){
            System.out.print(e.getMessage());
        }finally{
            if(Input!= null){
                Input.close();
            }
            if(Output!=null){
                Output.close();
            }
        }
        System.out.println("File Copoied");
    }
    public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the file name that is to be copied");
    String file1 =sc.nextLine();
    File a = new File("C:\\Users\\admin\\IdeaProjects\\untitled\\src\\"+file1);
        System.out.println("Enter the file name that is to be printed");
    String file2 =sc.nextLine();
    File b= new File("C:\\Users\\admin\\IdeaProjects\\untitled\\src\\"+file2);
        sc.close();
    Copydata(a,b);


    }
}
