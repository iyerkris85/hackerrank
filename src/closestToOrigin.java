import java.util.Arrays;

public class closestToOrigin {

    private static int[][] pts;
    public int[][] kClosest(int[][] points, int K) {

        this.pts = points;
        select(0,points.length-1,K-1);
        return Arrays.copyOfRange(this.pts, 0, K);
//        Arrays.sort(points,(point1, point2) -> {
//            int dist1 = (point1[0]*point1[0]) + (point1[1]*point1[1]);
//            int dist2 = (point2[0]*point2[0]) + (point2[1]*point2[1]);
//            if(dist1 <= dist2){
//                return -1;
//            }else{
//                return 1;
//            }
//        });
//
//        int[][] answer= new int[K][2];
//        for(int i = 0; i< K ; i++){
//            answer[i][0]= points[i][0];
//            answer[i][1]= points[i][1];
//        }
//        return answer;


    }

    private void select(int start, int end, int K){
        if(start > end){
            return;
        }
        int i= start;
        int j = end;

        int pivotDistance = distance(pts[(end-start)/2 + start]);
        while(i < j){
            while(distance(pts[i]) < pivotDistance && i<j){
                ++i;
            }
            while(distance(pts[j]) > pivotDistance && i<j ){
                --j;
            }
            if(i<j){
                if (distance(pts[i]) != distance(pts[j])) {
                    swap( i, j);
                }

            }
        }
        if(i < K ){
            select(i+1, end,K);
        }else{
            select(start, i-1,K);
        }



    }




    //Calculate Distance
    private int distance(int[] pt1){
        return (pt1[0]*pt1[0])+(pt1[1]*pt1[1]);
    }

    public void swap(int i, int j) {
        int t0 = pts[i][0], t1 = pts[i][1];
        pts[i][0] = pts[j][0];
        pts[i][1] = pts[j][1];
        pts[j][0] = t0;
        pts[j][1] = t1;
    }

    public static void main(String args[]){
        closestToOrigin sample = new closestToOrigin();
        int[][] pt ={
                {9,0},{7,10},{-4,-2},{3,-9},{9,1},
                {-5,-1}
        };
        System.out.println(Arrays.deepToString(sample.kClosest(pt, 6)));
    }
}
