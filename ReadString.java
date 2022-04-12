import java.lang.Math;
public class ReadString {

    private enum states {
        start,
        num,
        numWDecimal,
        exponent,
        done,
        fail
    }


    public String GetFloat(String input)
    {
        states dfa = states.start;
        float finalNumber = 0;
        float exponent = 0;
        float exponentIndex = 0;
        float decimalIndex = -1;
        for (int i = 0; i < input.length(); i++)
        {
            switch (dfa)
            {
                case start:
                {
                    if (input.charAt(i) == '.')
                    {
                        dfa = states.numWDecimal;
                    }
                    else if (input.charAt(i) == '1' ||
                            input.charAt(i) == '2' ||
                            input.charAt(i) == '3' ||
                            input.charAt(i) == '4' ||
                            input.charAt(i) == '5' ||
                            input.charAt(i) == '6' ||
                            input.charAt(i) == '7' ||
                            input.charAt(i) == '8' ||
                            input.charAt(i) == '9' ||
                            input.charAt(i) == '0')
                    {
                        dfa = states.num;
                        finalNumber += (Character.valueOf(input.charAt(i)) *  Math.pow(10, i));
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                }
                case num:
                    if (input.charAt(i) == '1' ||
                    input.charAt(i) == '2' ||
                    input.charAt(i) == '3' ||
                    input.charAt(i) == '4' ||
                    input.charAt(i) == '5' ||
                    input.charAt(i) == '6' ||
                    input.charAt(i) == '7' ||
                    input.charAt(i) == '8' ||
                    input.charAt(i) == '9' ||
                    input.charAt(i) == '0')
                    {
                        dfa = states.num;
                        finalNumber += (Character.valueOf(input.charAt(i)) *  Math.pow(10, i));
                    }
                    else if (input.charAt(i) == '.')
                    {
                        dfa = states.numWDecimal;
                    }
                    else if (input.charAt(i) == 'e' ||
                            input.charAt(i) == 'E')
                    {

                        dfa = states.exponent;
                    }
                    else if (input.charAt(i) == 'd' ||
                            input.charAt(i) == 'D' ||
                            input.charAt(i) == 'f' ||
                            input.charAt(i) == 'F')
                    {
                        if (i + 1 != input.length())
                        {
                            dfa = states.fail;
                        }
                        dfa = states.done;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                case numWDecimal:
                    if (input.charAt(i) == '1' ||
                    input.charAt(i) == '2' ||
                    input.charAt(i) == '3' ||
                    input.charAt(i) == '4' ||
                    input.charAt(i) == '5' ||
                    input.charAt(i) == '6' ||
                    input.charAt(i) == '7' ||
                    input.charAt(i) == '8' ||
                    input.charAt(i) == '9' ||
                    input.charAt(i) == '0')
                    {
                        dfa = states.numWDecimal;
                        finalNumber += (Character.valueOf(input.charAt(i)) *  Math.pow(10, decimalIndex));
                        decimalIndex--;
                    }
                    else if (input.charAt(i) == 'e' ||
                            input.charAt(i) == 'E')
                    {
                        dfa = states.exponent;
                    }
                    else if (input.charAt(i) == 'd' ||
                            input.charAt(i) == 'D' ||
                            input.charAt(i) == 'f' ||
                            input.charAt(i) == 'F')
                    {
                        dfa = states.done;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                case exponent:
                    if (input.charAt(i) == '1' ||
                        input.charAt(i) == '2' ||
                        input.charAt(i) == '3' ||
                        input.charAt(i) == '4' ||
                        input.charAt(i) == '5' ||
                        input.charAt(i) == '6' ||
                        input.charAt(i) == '7' ||
                        input.charAt(i) == '8' ||
                        input.charAt(i) == '9' ||
                        input.charAt(i) == '0')
                    {
                        dfa = states.exponent;
                        exponent += (Character.valueOf(input.charAt(i)) *  Math.pow(10, exponentIndex));
                        exponentIndex++;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                default:
                    dfa = states.fail;
                    break;
            }
            if (dfa == states.fail)
            {
                return "";
            }
            if (i + 1 == input.length() && dfa != states.fail)
            {
                dfa = states.done;
            }
        }
        if (dfa == states.done)
        {
            finalNumber *= Math.pow(10, exponent);
        }  

        
        return String.valueOf(finalNumber); 
    }
}
