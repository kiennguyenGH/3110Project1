public class ReadString {

    private enum states {
        start,
        num,
        numWDecimal,
        exponentStart,
        exponent,
        done,
        fail
    }


    public String GetFloat(String input)
    {
        String number = "";
        states dfa = states.start;
        float finalNumber = 0;
        float nonExponent = 0;
        boolean isNegative = false;
        boolean isNegativeExponent = false;
        boolean notParsed = false;
        for (int i = 0; i < input.length(); i++)
        {
            switch (dfa)
            {

                case start:
                {
                    if (input.charAt(i) == '-')
                    {
                        isNegative = true;
                        dfa = states.num;
                    }
                    else if (input.charAt(i) == '.')
                    {
                        dfa = states.numWDecimal;
                        number += input.charAt(i);
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
                        number += input.charAt(i);
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
                        number += input.charAt(i);
                    }
                    else if (input.charAt(i) == '.')
                    {
                        dfa = states.numWDecimal;
                        number += input.charAt(i);
                    }
                    else if (input.charAt(i) == 'e' ||
                            input.charAt(i) == 'E')
                    {

                        dfa = states.exponentStart;
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
                        dfa = states.num;
                        number += input.charAt(i);
                    }
                    else if (input.charAt(i) == 'e' ||
                            input.charAt(i) == 'E')
                    {

                        dfa = states.exponentStart;
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
                case exponentStart:
                    if (input.charAt(i) == '-')
                    {
                        isNegativeExponent = true;
                        dfa = states.exponent;
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
                        dfa = states.exponent;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                case exponent:
                    break;
                default:
                    dfa = states.fail;
                    break;
            }
            if (dfa == states.fail)
            {
                return "";
            }

        }
        
        if (!notParsed) 
        {
            finalNumber = Float.parseFloat(number);
        }
        if (isNegative)
        {
            finalNumber *= -1;
        }  
        number = String.valueOf(finalNumber);
        return number; 
    }
}
