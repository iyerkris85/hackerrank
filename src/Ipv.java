public class Ipv {

    public static void main(String[] args){

        String addr="1e1.4.5.6";
        String addr2 = "20EE:Fb8:85a3:0:0:8A2E:0370:7334:12";
        System.out.println(validIPAddress(addr));
        System.out.println(validIPAddress(addr2));
    }

    public static String validIPAddress(String IP) {

        String answer = "Neither";

        if(IP.length() <= 0){
            return answer;
        }

        //Validate IPV4
        if(IP.contains(".")){
            if(IP.charAt(IP.length()-1) == '.'){
                return answer;
            }
            if(isIPV4(IP)){
                return "IPv4";
            }
        }

        //Validate IPV6
        if(IP.contains(":")){
            if(IP.charAt(IP.length()-1) == ':'){
                return answer;
            }
            if(isIPV6(IP)){
                return "IPv6";
            }
        }

        return answer;
    }

    public static boolean isIPV4(String IP){

        String[] subnets = IP.split("\\.");
        if(subnets.length != 4){
            return false;
        }

        for(String net:subnets){
            try{
                int netInteger = Integer.parseInt(net);
                String netString = String.valueOf(netInteger);
                if(netString.length() != net.length()){
                    return false;
                }
                if(netInteger > 255 || netInteger < 0){
                    return false;
                }
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }

    public static boolean isIPV6(String IP){
        String[] subnets = IP.split(":");
        if(subnets.length != 8){
            return false;
        }
        for(String net:subnets){
            try{
                int netInteger = Integer.parseInt(net,16);
                if(net.length() == 0 || net.length() > 4 || net.contains("-")){
                    return false;
                }
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }


}
