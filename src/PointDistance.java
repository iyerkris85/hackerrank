
class Point {

    double x;
    double y;
    double z;

    Point(double x, double y, double z){
         this.x = x;
         this.y = y;
         this.z = z;
    }

    double distance(Point B) throws Exception{
        if(this.equals(B)){
            throw new Exception("Same Point distance will always be zero");
        }else{
            return Math.sqrt(((this.x - B.x) * (this.x - B.x) + ((this.y - B.y) * (this.y - B.y))) + ((this.z - B.z) * (this.z - B.z)));
        }
    }
}

public class PointDistance {

    public static void main(String args[]){

        Point a  = new Point(13.3, 89.3,33.1);
        Point b  = new Point(65.3, -99.3,33.1);
        Point c  = new Point(-34.3, 33.3,-45.1);

        try{
            System.out.println("Distance between A and B is "+a.distance(b));
            System.out.println("Distance between A and C is "+a.distance(c));
            System.out.println("Distance between B and C is "+b.distance(c));
            System.out.println("Distance between B and A is "+b.distance(a));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
