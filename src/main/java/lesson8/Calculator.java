package lesson8;

public class Calculator {
    public int add(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        int posY = Math.abs(y);
        int res = 0;
        for (int i = 0; i < posY; i++) {
            res += x;
        }
        if (y > 0) {
            return res;
        } else {
            return -res;
        }
    }
}
