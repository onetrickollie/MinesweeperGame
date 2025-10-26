public class MineFieldTester {
    public static void main(String[] args){
        boolean[][] data = {
            {false, true, false},
            {false, false, false},
            {true, false, false}
        };
        MineField mf = new MineField(data);

        assert mf.numRows() == 3 && mf.numCols() == 3: "size";
        assert mf.numMines() == 2: "mineCount";
        assert mf.inRange(0,0) && !mf.inRange(-1,0)&&!mf.inRange(3,3): "range";
        assert mf.hasMine(0,1) && mf.hasMine(2,0) && !mf.hasMine(1,1): "hasMine";
        assert mf.numAdjacentMines(0,0) == 1: "adj(0,0)";
        assert mf.numAdjacentMines(2,2) == 0: "adj(2,2)";
        assert mf.numAdjacentMines(1,1) == 2: "adj(1,1)";

        System.out.println("please work please work please work");


    }
}
