package sample;

public class DamerauLevenshtein_distance {
    //calculates Damerau–Levenshtein distance via dynamic programming

    public static int[][] calculate(String firstString, String secondString) {
        // claculates Damerau–Levenshtein distance matrix

        // empty word at position zero
        int[][] dist=new int[firstString.length()+1][secondString.length()+1];

        //initialization
        for(int i=0; i<=firstString.length();i++){
            dist[i][0]=i;
        }
        for(int j=0; j<=secondString.length();j++){
            dist[0][j]=j;
        }

        //claculate values
        for (int i=1;i<=firstString.length();i++){
            for(int j=1; j<=secondString.length();j++){
                //an insertion or a deletion is necessary to match strings
                int val_1=dist[i-1][j]+1;
                int val_2=dist[i][j-1]+1;
                //match or mismatch of last char
                int val_3=dist[i-1][j-1];
                if( firstString.charAt(i-1)!=secondString.charAt(j-1))
                    val_3++;
                // transposition between last two chars is necessary to match strings
                int val_4=Integer.MAX_VALUE;
                if(i>1 && j>1 &&
                        // string length is shorter then array length due to empty word at position zero of arrays
                        firstString.charAt(i-2)==secondString.charAt(j-1) &&
                        firstString.charAt(i-1)==secondString.charAt(j-2)){
                    val_4=dist[i-2][j-2]+1;
                }
                dist[i][j]=min(val_1,val_2,val_3,val_4);
            }
        }

        return dist;
    }

    private static int min(int value_0, int value_1,int value_2, int value_3){
        //yields minimal value
        int min_value=value_0;
        if (value_1<min_value){
            min_value=value_1;
        }
        if (value_2<min_value){
            min_value=value_2;
        }
        if (value_3<min_value){
            min_value=value_3;
        }
        return min_value;
    }

}
