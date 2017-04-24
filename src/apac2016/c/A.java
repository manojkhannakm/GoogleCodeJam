package apac2016.c;

import java.io.*;
import java.util.*;

/**
 * @author Manoj Khanna
 */

public class A {

    private static InputReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        if (Arrays.asList(args).contains("-local")) {
            try {
                in = new InputReader(new FileInputStream("in.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            in = new InputReader(System.in);
        }

        try {
            out = new PrintWriter("out.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        new Solution().solve();

        out.close();
    }

    private static class Solution {

        public void solve() {
            int t = in.nextInt();

            for (int i = 1; i <= t; i++) {
                int p = in.nextInt();

                int[] s = new int[p];

                for (int j = 0; j < p; j++) {
                    s[j] = in.nextInt();
                }

                int n = in.nextInt();

                int[] w = new int[n];
                String[][] a = new String[n][p];

                for (int j = 0; j < n; j++) {
                    w[j] = in.nextInt();

                    for (int k = 0; k < p; k++) {
                        a[j][k] = in.next();
                    }
                }

                int m = in.nextInt();

                HashMap<String, Athlete> map = new HashMap<>();

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < p; k++) {
                        Athlete athlete = map.get(a[j][k]);

                        if (athlete == null) {
                            athlete = new Athlete(a[j][k]);

                            map.put(a[j][k], athlete);
                        }

                        athlete.list.add(s[k] * w[j]);
                    }
                }

                for (Athlete athlete : map.values()) {
                    athlete.list.sort(Comparator.reverseOrder());

                    for (int j = 0; j < m && j < athlete.list.size(); j++) {
                        athlete.s += athlete.list.get(j);
                    }
                }

                ArrayList<Athlete> list = new ArrayList<>(map.values());
                list.sort((o1, o2) -> {
                    int c = Integer.compare(o2.s, o1.s);

                    if (c == 0) {
                        c = o1.a.compareTo(o2.a);
                    }

                    return c;
                });

                out.println("Case #" + i + ":");

                for (int j = 0, k = 1; j < list.size(); j++) {
                    if (j > 0 && list.get(j - 1).s > list.get(j).s) {
                        k = j + 1;
                    }

                    out.println(k + ": " + list.get(j).a);
                }
            }
        }

        private class Athlete {

            private String a;

            private ArrayList<Integer> list = new ArrayList<>();
            private int s;

            public Athlete(String a) {
                this.a = a;
            }

        }

    }

    @SuppressWarnings("UnusedDeclaration")
    private static class InputReader {

        private BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public InputReader(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return stringTokenizer.nextToken();
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            if (stringTokenizer != null && stringTokenizer.hasMoreTokens()) {
                return stringTokenizer.nextToken("");
            }

            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
