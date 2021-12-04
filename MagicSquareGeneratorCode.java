private static int[][] magicSquareGenerator(int squareCount) {
        int[][] twoDArray = new int[squareCount][squareCount];
        if (squareCount % 2 == 0) {
            twoDArray = evenMagicSquare(squareCount);
        } else {
            twoDArray = oddMagicSquareGenerator(squareCount);
        }
        return twoDArray;
    }

    // Function for building even number Magic square
    private static int[][] evenMagicSquare(int n) {
        int[][] evenMagicSquare = new int[n][n];
        int i, j;
        // fill array with their index-counting
        // starting from 1
        for ( i = 0; i<n; i++)
        {
            for ( j = 0; j<n; j++)
                // filling array with its count value
                // starting from 1;
                evenMagicSquare[i][j] = (n*i) + j + 1;
        }

        // change value of Array elements
        // at fix location as per rule
        // (n*n+1)-arr[i][j]
        // Top Left corner of Matrix
        // (order (n/4)*(n/4))
        for ( i = 0; i<n/4; i++)
        {
            for ( j = 0; j<n/4; j++)
                evenMagicSquare[i][j] = (n*n + 1) - evenMagicSquare[i][j];
        }

        // Top Right corner of Matrix
        // (order (n/4)*(n/4))
        for ( i = 0; i< n/4; i++)
        {
            for ( j = 3* (n/4); j<n; j++)
                evenMagicSquare[i][j] = (n*n + 1) - evenMagicSquare[i][j];
        }

        // Bottom Left corner of Matrix
        // (order (n/4)*(n/4))
        for ( i = 3* n/4; i<n; i++)
        {
            for ( j = 0; j<n/4; j++)
                evenMagicSquare[i][j] = (n*n + 1) - evenMagicSquare[i][j];
        }

        // Bottom Right corner of Matrix
        // (order (n/4)*(n/4))
        for ( i = 3* n/4; i<n; i++)
        {
            for ( j = 3* n/4; j<n; j++)
                evenMagicSquare[i][j] = (n*n + 1) - evenMagicSquare[i][j];
        }

        // Centre of Matrix (order (n/2)*(n/2))
        for ( i = n/4; i<3* n/4; i++)
        {
            for ( j = n/4; j<3* n/4; j++)
                evenMagicSquare[i][j] = (n*n + 1) - evenMagicSquare[i][j];
        }

        // print magic square
        System.out.println("The Magic Square for " + n + ":");
        System.out.println("Sum of each row or column " + n * (n * n + 1) / 2 + ":");
        // Printing the magic-square
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) System.out.print(evenMagicSquare[i][j] + " ");
            System.out.println();
        }
        return evenMagicSquare;
    }

    //function to build odd number Magic Square
    private static int[][] oddMagicSquareGenerator(int n) {


        int[][] oddMagicSquare = new int[n][n];

        // Initialize position for 1
        int i = n / 2;
        int j = n - 1;

        // One by one put all values in magic square
        for (int num = 1; num <= n * n;) {
            if (i == -1 && j == n) // 3rd condition
            {
                j = n - 2;
                i = 0;
            }
            else {
                // 1st condition helper if next number
                // goes to out of square's right side
                if (j == n)
                    j = 0;

                // 1st condition helper if next number is
                // goes to out of square's upper side
                if (i < 0)
                    i = n - 1;
            }

            // 2nd condition
            if (oddMagicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            }
            else
                // set number
                oddMagicSquare[i][j] = num++;

            // 1st condition
            j++;
            i--;
        }

        // print magic square
        System.out.println("The Magic Square for " + n
                + ":");
        System.out.println("Sum of each row or column "
                + n * (n * n + 1) / 2 + ":");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(oddMagicSquare[i][j] + " ");
            System.out.println();
        }
        return  oddMagicSquare;
    }