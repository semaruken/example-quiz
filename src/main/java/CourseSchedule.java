import java.util.*;

class CourseSchedule {
    static int[] findOrder(int n, int[][] course) {
        if (course == null) {
            throw new IllegalArgumentException("empty array");
        }

        int len = course.length;

        if (len == 0) {
            int[] res = new int[n];
            for (int m = 0; m < n; m++) {
                res[m] = m;
            }
            return res;
        }

        int[] pCounter = new int[n];
        for (int i = 0; i < len; i++) {
            pCounter[course[i][0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }

        int numNoPre = queue.size();

        int[] result = new int[n];
        int j = 0;

        while (!queue.isEmpty()) {
            int c = queue.remove();
            result[j++] = c;

            for (int i = 0; i < len; i++) {
                if (course[i][1] == c) {
                    pCounter[course[i][0]]--;
                    if (pCounter[course[i][0]] == 0) {
                        queue.add(course[i][0]);
                        numNoPre++;
                    }
                }

            }
        }

        if (numNoPre == n) {
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] course = {{0, 1, 2}, {1, 3}, {2, 3}, {3, 4, 5}, {4, 6}, {5, 6}};

        int[] result = findOrder(n, course);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.print("]");
    }


}

