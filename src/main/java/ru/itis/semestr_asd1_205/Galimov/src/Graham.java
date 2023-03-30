
import java.util.Stack;

public class Graham {
    public long iterations;

    public Graham() {
        iterations = 0;
    }

    public Stack<Point> grahamScan(Point[] points) {
        int n = points.length;

        for (int i = 1; i < n; i++) {
            iterations++;
            if (points[i].x < points[0].x) {
                Point buf = points[i];
                points[i] = points[0];
                points[0] = buf;
            }
        }
        iterations += quicksort(points, 1, points.length - 1, 0);
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < n; i++) {
            while (rotate(stack.get(stack.size() - 2), stack.peek(), points[i]) < 0) {
                iterations++;
                stack.pop();
            }
            iterations++;
            stack.push(points[i]);
        }
        return stack;
    }

    public static long quicksort(Point[] array, int low, int high, long iterations) {
        Point mid = array[low + (high - low) / 2];
        int i = low;
        int j = high;
        while (i <= j) {
            while (rotate(array[0], mid, array[i]) < 0) {
                iterations++;
                i++;
            }
            while (rotate(array[0], mid, array[j]) > 0) {
                iterations++;
                j--;
            }
            if (i <= j) {
                Point buf = array[i];
                array[i] = array[j];
                array[j] = buf;
                i++;
                j--;
            }
        }

        if (low < j) {
            iterations += quicksort(array, low, j, 0);
        }
        if (high > i) {
            iterations += quicksort(array, i, high, 0);
        }
        return iterations;
    }


    public static double rotate(Point a, Point b, Point c) {
        return -((b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y));
    }

}
