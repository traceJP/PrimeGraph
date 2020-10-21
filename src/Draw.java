import javax.swing.*;
import java.awt.*;

class Draw extends JPanel {

    // 计算最大数以内
    private final long NUMBER = 100000;    // 十万
    // 每个点之间的距离
    private final int INTERVAL = 2;
    // 原点
    public static final int initialX = 3000;
    public static final int initialY = 1500;

    @Override
    public void paint(Graphics g) {
        line(g);
    }

    private void line(Graphics graphics) {

        // 方向：E(东) S(南) W(西) N(北)
        char direction = 'W';    // 默认向西走

        int x = initialX / 2;
        int y = initialY / 2;

        for (long i = 2; i < NUMBER; i++) {
            if(isPrime(i)) {
                // 是素数->转弯
                switch (direction) {
                    case 'W' : direction = 'N';break;
                    case 'N' : direction = 'E';break;
                    case 'E' : direction = 'S';break;
                    case 'S' : direction = 'W';break;
                }
            } else {
                // 不是素数->画线
                switch (direction) {
                    case 'W' :
                        graphics.drawLine(x, y, x-INTERVAL, y);
                        x -= INTERVAL;
                        break;
                    case 'N' :
                        graphics.drawLine(x, y, x, y+INTERVAL);
                        y += INTERVAL;
                        break;
                    case 'E' :
                        graphics.drawLine(x, y, x+INTERVAL, y);
                        x += INTERVAL;
                        break;
                    case 'S' :
                        graphics.drawLine(x, y, x, y-INTERVAL);
                        y -= INTERVAL;
                        break;
                }

            }

        }

    }

    // 素数判断
    private boolean isPrime(long next) {

        for (int i = 2; i * i <= next; i++)
            if (next % i == 0)
                return false;
        return true;

    }

}

