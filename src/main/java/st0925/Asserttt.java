package st0925;

public class Asserttt {

    public static void main(String[] args) {
        int a = -1;
        int b = square(a);
        assert b >= 0 : "你程式有錯！";
        System.out.println(b);
    }

    public static  int square(int i) {
        return i*i;
    }
}
