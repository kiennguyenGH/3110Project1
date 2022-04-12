import java.util.Scanner; 
public class Test
{
    public static void main (String[] args)
    {
        ReadString reader = new ReadString();
        String value = "";
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("Enter a java floating point literal: (q to quit)");
            value = scanner.nextLine();
            if (value.equals("q"))
            {
                break;
            }
            
            System.out.println(reader.GetFloat(value));
        }
        scanner.close();

    }
}
