public class stringCombinations {
    private StringBuilder out = new StringBuilder();
    private final String in;

    public stringCombinations( final String str ){ in = str; }

    public static void main(String args[]) {
        stringCombinations input = new stringCombinations("abcd");
        input.combine( 0 );
    }
    private void combine(int start ){
        for( int i = start; i < in.length(); ++i ){
            out.append( in.charAt(i) );
            System.out.println( out );
            if ( i < in.length() )
                combine( i + 1);
            out.setLength( out.length() - 1 );
        }
    }


}
