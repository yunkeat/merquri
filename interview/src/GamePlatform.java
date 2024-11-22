public class GamePlatform {
    public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
        // throw new UnsupportedOperationException("Waiting to be implemented.");
        double finalSpeed = initialSpeed;
        for (int x : inclinations){
                finalSpeed -= x;
        }
        return finalSpeed;
    }

    public static void main(String[] args) {
        System.out.println(getFinalSpeed(60.0, new int[] { 0, -30, 0, 45, 0 })); // should print 45
    }
}