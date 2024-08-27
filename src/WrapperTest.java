import java.util.ArrayList;

public class WrapperTest {

    public static void main(String[] args) {
        Integer n1 = Integer.valueOf(1);
        Integer n2 = 1;
        System.out.println(n1 == n2);

        Integer n3 = Integer.valueOf(1000);
        Integer n4 = 1000;
        System.out.println(n3 == n4);
//        System.out.println(quadraticRoots(752, 904, 164));
    }

    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> result = new ArrayList();
        double dis = b * b - (4 * a * c);
        if(dis > 0) {
            double root1 = (-b - Math.sqrt(dis)) / (2 * a);
            double root2 = (-b + Math.sqrt(dis)) / (2 * a);
            result.add((int)Math.floor(root1));
            result.add((int)Math.floor(root2));
        } else if(dis == 0) {
            double root = -b / (2 * a);
            result.add((int)root);
            result.add((int)root);
        } else {
            result.add(-1);
        }
        return result;
    }
}
