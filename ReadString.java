import java.lang.Math;

// Set of states
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

    //Use dfa to read string input
    public void GetFloat(String input)
    {
        states dfa = states.start;
        states previousState;
        String nonDecimal = "";
        String eValue = "";
        float finalNumber = 0;
        float exponentValue = 0;
        float decimalIndex = -1;

        //Traverse through each input
        for (int i = 0; i < input.length(); i++)
        {
            previousState = dfa;
            switch (dfa)
            {
                // Start state
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

                // Whole number digit state
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
                
                //Decimal point state (when input reads '.')
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

                //Fraction digit state (digits read are decimals)
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

                //Underscore state for whole numbers
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

                //Underscore state for decimal numbers
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

                //State for start of exponents (when 'e' or 'E' is read)
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
                //Exponent state (digits read are exponents)
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

                //Underscore state for exponents
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
                //If program is not in a valid state, automatically fail
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
        // If in non-accept state, print out empty string
        if (dfa == states.fail || 
            dfa == states.num ||
            dfa == states.exponentStart)
        {
            System.out.println();
        }
        else dfa = states.done;
        // Else accept and print out valid float
        // Calculated by moving whole numbers and exponents to separate strings, and adding all decimals to final value
        // Then traverse through whole number string and individually add each digit to final value
        // Then add each digit of exponent string to separate value, and use that separate value to multiply (final value * 10e(exponent value))
        // to get final float value
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
