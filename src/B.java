import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Manoj Khanna
 */

public class B {

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
                int n = in.nextInt();

                int[] p = new int[n];
                long[] k = new long[n];

                for (int j = 0; j < n; j++) {
                    int pj = in.nextInt();
                    long kj = in.nextLong();

                    p[j] = pj;
                    k[j] = kj;
                }

                long f;

                if (p[n - 1] == 100) {
                    f = k[n - 1];
                } else {
                    ArrayList<Double> list = new ArrayList<>();

                    for (int j = 0; j < n; j++) {
                        int pj = p[j];
                        long kj = k[j];

                        if (pj > 0 && kj > 0) {
                            list.add(100.0 / pj * kj);
                        }
                    }

                    double m = 0.0f;

                    for (Double d : list) {
                        m += d;
                    }

                    m /= list.size();

                    double sd = 0.0f;

                    for (Double d : list) {
                        sd += (d - m) * (d - m);
                    }

                    sd = Math.sqrt(sd / list.size());

                    if (sd < 1.0) {
                        f = (long) Math.floor(m);
                    } else {
                        f = -1;
                    }
                }

                out.println("Case #" + i + ": " + f);
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
