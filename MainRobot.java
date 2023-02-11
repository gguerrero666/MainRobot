import java.awt.*;
import java.util.Random;


public class MainRobot {
    public static final int SECONDS = 30000;

    public static final int MAX_Y = 5;
    public static final int MAX_X = 5;

    public static final boolean console = false;

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        int nx = 0;
        int ny = 0;

        while (true) {
            if (nx == getPosX() && ny == getPosY()) {
                nx = getPosX() + getRandom(MAX_X);
                ny = getPosY() + getRandom(MAX_Y);
                if(console) System.out.println("x " + nx + " - y " + ny);
                robot.mouseMove(nx, ny);
            } else {
                if(console) System.out.println("unexpected movement");
                nx = getPosX();
                ny = getPosY();

            }
            Thread.sleep(SECONDS);
        }
    }
	
	public static int getRandom(int val){
		Random random = new Random();
		return random.nextInt(val + val) - val;
	}

    public static int getPosX(){
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        return x;
    }


    public static int getPosY(){
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int y = (int) b.getY();
        return y;
    }
}
