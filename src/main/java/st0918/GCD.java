package st0918;

public class GCD {



    public static void main(String[] args) {
        int r;
        System.out.println("安安");
        GCD g = new GCD();
        r = g.gcd(24,18);
        System.out.println(r);

        r = g.gcd2(24, 18);
        System.out.println(r);
    }

    public GCD(){
        System.out.println("建構子");
    }

    // 有設定中斷點後，run debug後，可以選取你想選的地方，可以watch
    public int gcd(int m, int n) {
        int r = 0;
        while (n != 0) { // 應該是n不是m
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public int gcd2(int m, int n) { // 遞迴很雞掰，要想清楚，這段程式是有點立體的感覺，用debug會容易認為都在同一層
        if (n == 0) {
            return m;
        }else {
            gcd3(n, m % n);
        }
         return m;
    }

    public int gcd3(int m, int n) {
        if (n == 0) {
            return m;
        }else {
            gcd4(n, m % n);
        }
        return m;
    }

    public int gcd4(int m, int n) {
        if (n == 0) {
            return m;
        }else {
            gcd5(n, m % n);
        }
        return m;
    }

    public int gcd5(int m, int n) {
        if (n == 0) {
            return m;
        }else {
            System.out.println("太多囉");
            gcd5(n, m % n);
        }
        return m;
    }

}