class MagicSquareEvaluator{
    public static void main(String[] args){
        int[][] a = {{2, 7, 6}, {9, 5, 1}, {4, 3, 9}};
        System.out.println(ValueFinder(a, 0));
        System.out.println(rowValueFinder(a, 0));
        System.out.println(forwardDiagonal(a));
        System.out.println(backwardDiagonal(a));
        System.out.println(isMagicSquare(a));
    }
    
    public static boolean isMagicSquare(int[][] param){
        int COMPARISONVAL = ValueFinder(param, 0);
        for(int i =0; i < param[0].length; i++){
            int w = ValueFinder(param, i);
            if(w != COMPARISONVAL){
                return false;
            }
        }

        for(int i = 0; i < param.length; i++){
            int v = rowValueFinder(param, i);
            if(v != COMPARISONVAL){
                return false;
            }
        }
        if(COMPARISONVAL != forwardDiagonal(param)){
            return false;
        }
        else if(COMPARISONVAL != backwardDiagonal(param)){
            return false;
        }


        return true;

    }

    public static int ValueFinder(int[][] param, int d){
        int a = 0;
        for(int i = 0; i < param.length; i++){
            a += param[i][d];
        }
        return a;
    }

    public static int rowValueFinder(int[][] param, int d){
        int a = 0;
        for(int i = 0; i < param[0].length; i++){
            a += param[d][i];
        }
        return a;
    }

    public static int forwardDiagonal(int[][] param){
        int a = 0;
        int i = 0;
        for(int j = 0; j < param[0].length; j++){
            a += param[i][j];
            i++;
        }
        return a;
    }

    public static int backwardDiagonal(int[][] param){
        int a = 0;
        int i = param[0].length - 1;
        for(int j = param[0].length - 1; j >= 0; j-- ){
            a += param[i][j];
            i--;
        }
        return a;
    }

    

}