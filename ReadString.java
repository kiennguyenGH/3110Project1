import java.lang.Math;

public class ReadString {

    private enum states {
        start,
        num,
        underscoreNum,
        decimalStart,
        decimal,
        underscoreDecimal,
        exponentStart,
        exponent,
        underscoreExponent,
        done,
        fail
    }


    public void GetFloat(String input)
    {
        states dfa = states.start;
        states previousState;
        String nonDecimal = "";
        String eValue = "";
        float finalNumber = 0;
        float exponentValue = 0;
        float decimalIndex = -1;
        for (int i = 0; i < input.length(); i++)
        {
            previousState = dfa;
            switch (dfa)
            {
                case start:
                {
                    if (input.charAt(i) == '.')
                    {
                        dfa = states.decimalStart;
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
                        nonDecimal += input.charAt(i);
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
                        nonDecimal += input.charAt(i);
                    }
                    else if (input.charAt(i) == '.')
                    {
                        dfa = states.decimalStart;
                    }
                    else if (input.charAt(i) == '_')
                    {
                        dfa = states.underscoreNum;
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
                        if (i + 1 != input.length())
                        {
                            dfa = states.fail;
                        }
                        else dfa = states.done;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                case decimalStart:
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
                        dfa = states.decimal;
                        finalNumber += (Character.getNumericValue(input.charAt(i)) *  Math.pow(10, decimalIndex));
                        decimalIndex--;
                    }
                    else if (input.charAt(i) == 'e' ||
                            input.charAt(i) == 'E')
                    {
                        if (previousState == states.num)
                        {
                            dfa = states.num;
                        }
                        else
                        {
                            dfa = states.fail;
                        }
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
                case decimal:
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
                        dfa = states.decimal;
                        finalNumber += (Character.getNumericValue(input.charAt(i)) *  Math.pow(10, decimalIndex));
                        decimalIndex--;
                    }
                    else if (input.charAt(i) == '_')
                    {
                        dfa = states.underscoreDecimal;
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
                        if (i + 1 != input.length())
                        {
                            dfa = states.fail;
                        }
                        else dfa = states.done;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                case underscoreNum:
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
                        nonDecimal += input.charAt(i);
                    }
                    else if (input.charAt(i) == '_')
                    {
                        dfa = states.underscoreNum;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                case underscoreDecimal:
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
                        dfa = states.decimal;
                        finalNumber += (Character.getNumericValue(input.charAt(i)) *  Math.pow(10, decimalIndex));
                        decimalIndex--;
                    }
                    else if (input.charAt(i) == '_')
                    {
                        dfa = states.underscoreDecimal;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                case exponentStart:
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
                        eValue += input.charAt(i);
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
                        eValue += input.charAt(i);
                    }
                    else if (input.charAt(i) == '_')
                    {
                        dfa = states.underscoreExponent;
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
                        else dfa = states.done;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                case underscoreExponent:
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
                        eValue += input.charAt(i);
                    }
                    else if (input.charAt(i) == '_')
                    {
                        dfa = states.underscoreExponent;
                    }
                    else
                    {
                        dfa = states.fail;
                    }
                    break;
                default:
                    dfa = states.fail;
                    break;
            }
            if (dfa == states.fail)
            {
                break;
            }
        }

        // Check if final state is accept state
        if (dfa == states.fail || 
            dfa == states.num ||
            dfa == states.exponentStart)
        {
            System.out.println();
        }
        else dfa = states.done;
        if (dfa == states.done)
        {
            float power = nonDecimal.length() - 1;
            for (int i = 0; i < nonDecimal.length(); i++)
            {
                finalNumber += Character.getNumericValue(nonDecimal.charAt(i)) * Math.pow(10, power);
                power--;
            }
            power = eValue.length() - 1;
            for (int i = 0; i < eValue.length(); i++)
            {
                exponentValue += Character.getNumericValue(eValue.charAt(i)) * Math.pow(10,power);
                power--;
            }
            finalNumber *= Math.pow(10, exponentValue);
            System.out.println(finalNumber);
        }  
    }
}
