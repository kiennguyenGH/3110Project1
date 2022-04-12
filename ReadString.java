public class ReadString {

    private enum states {
        start,
        num,
        numWDecimal,
        fail
    }


    public float GetFloat(String input)
    {
        String number = "";
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
