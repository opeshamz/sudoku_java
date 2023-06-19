public class Sudoku {
    private static final int gird_size = 9;

    public  static  void main(String[] args){
        int[][] sudo_board= {
                {7,0,2,0,5,0,6,0,0},
                {0,0,1,0,0,3,0,0,0},
                {1,0,0,0,0,9,5,0,0},
                {8,0,0,0,0,0,0,9,0},
                {0,4,3,0,0,0,7,5,0},
                {0,9,0,0,0,0,0,0,8},
                {0,0,9,7,0,0,0,0,5},
                {0,0,0,2,0,0,0,0,0},
                {0,0,7,0,4,0,2,0,3},

        };
        if(solveSudoku(sudo_board)){
            System.out.println("problem solved");
        }
        else{
            System.out.println("NOt solved");
        }

        outPut(sudo_board);

    }

    private static void  outPut(int[][] items){
        for (int row = 0; row < gird_size; row++ ){
            for (int column =0; column < gird_size; column++ ){
                System.out.println(items[row][column]);
            }
            System.out.println();
        }

    }

    // check if number is in a row
    public static boolean numberInrow (int[][] items, int number, int row){
        for(int i =0; i <gird_size; i++){
            if(items[row][i]== number ){
                return true;
            }

        }
        return false;
    }
    public static boolean numberInColumn (int[][] items, int number, int column){
        for(int i =0 ;i <gird_size; i++){
            if(items[i][column]== number ){
                return true;
            }

        }
        return false;
    }
    public static boolean numberInThreeByThreeBox (int[][] items, int number, int row, int column){
        int firstRowInThreeBox = row - row % 3;
        int firstColomnInThreeBox = row - row % 3;

        for(int i =firstRowInThreeBox ;i <firstRowInThreeBox + 3; i++){
            for(int k =firstColomnInThreeBox ;k <firstColomnInThreeBox+ 3; k++){
                if(items[i][k] == number ){
                    return true;
                }
            }
        }
        return false;
    }

    public  static boolean validPositions (int[][] items, int number, int row, int column){
        return !numberInrow(items,number,row) && !numberInColumn(items,number,column) &&
                !numberInThreeByThreeBox(items, number, row,column);
    }

    public static boolean solveSudoku(int[][] items){
        //console.log(items);
        System.out.println(items);
        for (int row = 0; row < gird_size; row++){
            for(int column = 0; column <= gird_size; column++){
                if(items[row][column] == 0){
                    for (int input = 1; input<= gird_size; input++){
                        if(validPositions(items, input,row,column)){
                            items[row][column] = input;
                            if(solveSudoku(items)){
                                return true;
                            }
                            else {
                                items[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
