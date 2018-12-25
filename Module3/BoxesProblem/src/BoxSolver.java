import java.util.Scanner;

public class BoxSolver {

    public static boolean cmp(int x1, int x2, int y1, int y2, int z1, int z2) {
        if (x1 >= x2 && y1 >= y2 && z1 >= z2)
            return true;
        return false;
    }

    public static boolean rcmp(int x1, int x2, int y1, int y2, int z1, int z2) {
        if (x1 <= x2 && y1 <= y2 && z1 <= z2)
            return true;
        return false;
    }

    public static boolean b1_gr_b2(int x, int x1, int y, int y1, int z, int z1) {
        if (cmp(x, x1, y, y1, z, z1) ||
                cmp(x, y1, y, x1, z, z1) ||
                cmp(x, z1, y, x1, z, y1) ||
                cmp(x, z1, y, y1, z, x1) ||
                cmp(x, x1, y, z1, z, y1) ||
                cmp(x, y1, y, z1, z, x1)) {
            return true;
        }
        return false;
    }
    public static boolean b2_gr_b1(int x, int x1, int y, int y1, int z, int z1) {
        if (rcmp(x, x1, y, y1, z, z1) ||
                rcmp(x, y1, y, x1, z, z1) ||
                rcmp(x, z1, y, x1, z, y1) ||
                rcmp(x, z1, y, y1, z, x1) ||
                rcmp(x, x1, y, z1, z, y1) ||
                rcmp(x, y1, y, z1, z, x1)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();

        if(b1_gr_b2(x, x1, y, y1, z, z1) && b2_gr_b1(x, x1, y, y1, z, z1)) {
            // System.out.println(b1_gr_b2(x, x1, y, y1, z, z1));
            // System.out.println(b2_gr_b1(x, x1, y, y1, z, z1));
            System.out.println("Box 1 = Box 2");
        } else if (b1_gr_b2(x, x1, y, y1, z, z1)) {
            System.out.println("Box 1 > Box 2");
        } else if (b2_gr_b1(x, x1, y, y1, z, z1)) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incomparable");
        }

    }
}
