public class MaxSideLength {

    public static class Point {
        int x , y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    // function to calculate distance between two points (vertical or horizontal)
    public static double distance(Point p1, Point p2) {
        return Math.max(Math.abs(p1.x - p2.x) , Math.abs(p1.y - p2.y));
    }

    // X and Y are the arrays of points sorted by x and y coordinates
    // left and right are the upper and lower bounds of the array
    public double FindClosestPair (Point[] X, Point[] Y, int left, int right){
        // base case
        if (right-left<=3){
            double closestPairDistance = Double.MAX_VALUE;
            for (int i = left; i < right; i++){
                for (int j = i+1 ; j <= right; j++){
                    double distance = distance(X[i],X[j]);
                    closestPairDistance = Math.min(closestPairDistance,distance);
                }
            }
            return closestPairDistance;
        }
        // divide the array into two halves
        int mid = left + (right-left)/2;
        Point midPoint = X[mid];
        // find the closest pair of points in the left half
        double deltaLeft = FindClosestPair(X,Y,left,mid);
        // find the closest pair of points in the right half
        double deltaRight = FindClosestPair(X,Y,mid,right);
        // find the minimum distance between the two halves
        double delta = Math.min(deltaLeft,deltaRight);
        // create an array of points that are far away midPoint by delta horizontally
        Point[] YStrip = new Point[right - left];
        int stripSize = 0;
        for (int i=left; i<right; i++){
            if (Math.abs(Y[i].x-midPoint.x)<delta)
                YStrip[stripSize++] = Y[i];
        }
        // find the closest pair of points in the strip
        double deltaStrip = FindClosestPairStrip(YStrip,stripSize,delta);
        return Math.min(delta,deltaStrip);

    }

    // function to find the closest pair of points in the strip
    public double FindClosestPairStrip(Point[] YStrip,int stripSize ,double delta){
        double closestPairDistance = delta;
        for (int i=0; i < stripSize; i++){
           for (int j = i+1; j < stripSize ; j++){
               double distance = distance(YStrip[i],YStrip[j]);
               closestPairDistance = Math.min(closestPairDistance,distance);
           }
        }
        return closestPairDistance;
    }


}
