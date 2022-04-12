public class ReadString {
    public float GetFloat(String input)
    {
        String number = "1000";
        float finalNumber;
        for (int i = 0; i < input.length(); i++)
        {

            if (input.charAt(i) == '9')
            {
                continue;
            }
        }
        finalNumber = Float.parseFloat(number);
        return finalNumber; 
    }
}
