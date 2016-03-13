package apac2016.a;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            long[] A = new long[64];
            long Ai = 1;

            for (int i = 0; i < A.length; i++) {
                A[i] = Ai;
                Ai *= 2;
            }

            int T = in.nextInt();

            for (int i = 1; i <= T; i++) {
                long K = in.nextLong();

                int M = 0;

                while (K > 0) {
                    for (long Aj : A) {
                        if (Aj >= K) {
                            K = Aj - K;

                            if (K > 0) {
                                M++;
                            }

                            break;
                        }
                    }
                }

                int Y;

                if (K == 0) {
                    if (M % 2 == 0) {
                        Y = 0;
                    } else {
                        Y = 1;
                    }
                } else {
                    if (M % 2 == 0) {
                        Y = 1;
                    } else {
                        Y = 0;
                    }
                }

                out.println("Case #" + i + ": " + Y);
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
