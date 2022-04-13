import java.util.Scanner; 
public class Test
{
    public static void main (String[] args)
    {
        ReadString reader = new ReadString();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("Enter a java floating point literal: (q to quit)");
            input = scanner.nextLine();
            if (input.equals("q"))
            {
                break;
            }
            
            reader.GetFloat(input);
        }
        scanner.close();

    }
}
