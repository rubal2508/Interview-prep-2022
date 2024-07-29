public class ScannerInput {
    public static void main(String[] args) {
        // Use the Scanner class

        /*
        int n      = sc.nextInt();        // read input as integer
        long k     = sc.nextLong();       // read input as long
        double d   = sc.nextDouble();     // read input as double
        String str = sc.next();           // read input as String
        String s   = sc.nextLine();       // read whole line as String
        char c     = sc.next().charAt(0)
        matrix[i] = stdin.nextLine().toCharArray();
        */


        Scanner sc = new Scanner(System.in);

        // read an int matrix 
        /* 3 5
         * 1 2 3 4 5
         * 1 2 3 2 4
         * 4 8 2 2 1
         */

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new matrix[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
}
