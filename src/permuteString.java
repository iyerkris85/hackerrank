

    public class permuteString {

    private boolean[] used;
        private StringBuilder out = new StringBuilder();
        private final String in;

        public permuteString( final String str ){
            in = str;
            used = new boolean[ in.length() ];
        }

        public static void main(String args[]){

            permuteString perm = new permuteString("abcde");
            perm.permute();
        }

        public void permute( ){
            if( out.length() == in.length() ){
                System.out.println( out );
                return;
            }
            for( int i = 0; i < in.length(); ++i ){
                if(!used[i]){
                    out.append( in.charAt(i) );
                    used[i] = true;
                    permute();
                    //System.out.println(used[0]+""+used[1]+used[2]+used[3]);
                    used[i] = false;
                    out.setLength( out.length() - 1 );
                }
            }
        }
    }

