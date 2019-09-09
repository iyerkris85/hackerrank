public class xlsColumnNumber {

    public int getColumnNumber(String title){

        int number = 0;

        for(int i=0;i<title.length();i++){

            number *=26;
            number += (int)title.charAt(i) - 65 + 1;
        }

        return number;
    }

    public String getColumnName(int number){

        StringBuffer name= new StringBuffer();


        while(number > 0){
           int rem = number % 26;
           if(rem == 0){
               name.append("Z");
               number = (number/26) - 1;
           }else{
               name.append((char) ((rem - 1) + 65));
               number = number/26;
           }
        }

        return name.reverse().toString();
    }

    public static void main(String args[]){

        xlsColumnNumber obj = new xlsColumnNumber();

        System.out.println(obj.getColumnNumber("ZZ"));
        System.out.println(obj.getColumnName(702));
    }
}
