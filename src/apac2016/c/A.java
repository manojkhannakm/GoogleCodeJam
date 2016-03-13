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
                    int sj = in.nextInt();

                    s[j] = sj;
                }

                int n = in.nextInt();

                HashMap<String, ArrayList<Integer>> map = new HashMap<>();

                for (int j = 0; j < n; j++) {
                    int w = in.nextInt();

                    for (int k = 0; k < p; k++) {
                        String ak = in.next();

                        ArrayList<Integer> list = map.get(ak);

                        if (list == null) {
                            list = new ArrayList<>();
                            map.put(ak, list);
                        }

                        list.add(w * s[k]);
                    }
                }

                int m = in.nextInt();

                ArrayList<Athlet> list = new ArrayList<>();

                for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
                    ArrayList<Integer> value = entry.getValue();
                    value.sort(Comparator.<Integer>reverseOrder());

                    int score = 0;

                    for (int j = 0, x = Math.min(m, value.size()); j < x; j++) {
                        score += value.get(j);
                    }

                    list.add(new Athlet(entry.getKey(), score));
                }

                list.sort(Comparator.<Athlet>naturalOrder());

                out.println("Case #" + i + ":");

                int rank = 1;

                for (int j = 0; j < list.size(); j++) {
                    Athlet athlet2 = list.get(j);

                    if (j > 0) {
                        Athlet athlet1 = list.get(j - 1);

                        if (athlet1.score > athlet2.score) {
                            rank = j + 1;
                        }
                    }

                    out.println(rank + ": " + athlet2.name);
                }
            }
        }

        private class Athlet implements Comparable<Athlet> {

            private String name;
            private int score;

            public Athlet(String name, int score) {
                this.name = name;
                this.score = score;
            }

            @Override
            public String toString() {
                return name + " -> " + score;
            }

            @Override
            public int compareTo(Athlet o) {
                int i = Integer.compare(o.score, score);

                if (i == 0) {
                    i = name.compareTo(o.name);
                }

                return i;
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
