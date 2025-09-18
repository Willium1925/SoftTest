package st0918;

public class GCD {

    public GCD(){
        System.out.println("GCD");
    }

    public static void main(String[] args) {
        int r;
        GCD g = new GCD();
        r = g.gcd(24,18);
        System.out.println(r);

        r = g.gcd2(24, 18);
        System.out.println(r);
    }

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
            gcd2(n, m % n);
        }
         return m;
    }

}