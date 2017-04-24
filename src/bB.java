import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Manoj Khanna
 */

public class bB {

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
            int T = in.nextInt();

            for (int i = 1; i <= T; i++) {
                int Np = in.nextInt(),
                        Ne = in.nextInt(),
                        Nt = in.nextInt();

                int[] Ap = new int[Np];

                for (int j = 0; j < Np; j++) {
                    int pj = in.nextInt();

                    Ap[j] = pj;
                }

                int[] Ae = new int[Ne];

                for (int j = 0; j < Ne; j++) {
                    int ej = in.nextInt();

                    Ae[j] = ej;
                }

                int[] At = new int[Nt];

                for (int j = 0; j < Nt; j++) {
                    int tj = in.nextInt();

                    At[j] = tj;
                }

                ArrayList<Double> list = new ArrayList<>();

                for (int j = 0; j < Np; j++) {
                    for (int k = 0; k < Ne; k++) {
                        for (int l = 0; l < k; l++) {
                            for (int m = 0; m < Nt; m++) {
                                list.add(((double) Ap[j] / Ae[k]) * ((double) Ae[l] / At[m]));
                            }
                        }

                        for (int l = k + 1; l < Ne; l++) {
                            for (int m = 0; m < Nt; m++) {
                                list.add(((double) Ap[j] / Ae[k]) * ((double) Ae[l] / At[m]));
                            }
                        }
                    }
                }

                list.sort(Double::compare);

                int M = in.nextInt();

                out.println("Case #" + i + ":");

                for (int j = 0; j < M; j++) {
                    int P = in.nextInt(),
                            Q = in.nextInt();

                    double r = (double) P / Q;
                    boolean b = false;

                    for (Double d : list) {
                        if (d == r) {
                            b = true;
                            break;
                        } else if (d > r) {
                            break;
                        }
                    }

                    out.println(b ? "Yes" : "No");
                }
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
