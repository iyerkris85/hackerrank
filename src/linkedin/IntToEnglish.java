package linkedin;

public class IntToEnglish {


    public String numberToWords(int num) {
        //Number Zero
        if(num == 0){
            return "Zero";
        }

        String result="";
        int billion = num/1000000000;
        int million = (num - (billion *  1000000000))/1000000;
        int thousand = (num - (billion *  1000000000) - (million * 1000000))/1000;
        int hundreds = num - (billion *  1000000000) - (million * 1000000) - (thousand * 1000);

        if(billion != 0){
            result = ones(billion)+" Billion";
        }
        if(million != 0){
            if(!result.isEmpty()){
                result += " ";
            }
            result += three(million) + " Million";
        }
        if(thousand != 0){
            if(!result.isEmpty()){
                result += " ";
            }
            result += three(thousand) + " Thousand";
        }

        if(hundreds != 0){
            if(!result.isEmpty()){
                result += " ";
            }
            result += three(hundreds);
        }
        return result;
    }

    /**
     * Return English for Single Digit
     * @param number
     * @return
     */
    private String ones(int number){
        switch(number){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }


    private String three(int number) {
        int hundred = number / 100;
        int two = number - (hundred * 100);
        String result = "";

        if(hundred * two != 0) {
          result = ones(hundred)+" Hundred "+twos(two) ;
        }else if ((hundred == 0) && (two != 0)){
          result = twos(two);
        }else if ((hundred != 0) && (two == 0)){
            result = ones(hundred) + " Hundred";
        }

        return result;
    }

    private String twos(int number){
        if (number == 0)
            return "";
        else if (number < 10)
            return ones(number);
        else if (number < 20)
            return twoLessThan20(number);
        else {
            int tenner = number / 10;
            int rest = number - tenner * 10;
            if (rest != 0)
                return ten(tenner) + " " + ones(rest);
            else
                return ten(tenner);
        }
    }

    public String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    public static void main(String args[]){
        IntToEnglish sample = new IntToEnglish();
        System.out.println(sample.numberToWords(2147483647));
    }

}
