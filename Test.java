import java.util.Scanner; 
public class Test
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a java floating point literal:");
        String input = scanner.nextLine();
        scanner.close();
        ReadString reader = new ReadString();
        System.out.println(reader.GetFloat(input));

    }
}
