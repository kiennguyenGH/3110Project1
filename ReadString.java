public class ReadString {
    public float GetFloat(String input)
    {
        String number = "";
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '9')
            {
                continue;
            }
        }
        float finalNumber = Float.parseFloat(number);
        return finalNumber; 
    }
}
