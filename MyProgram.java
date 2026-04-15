import java.util.Arrays;
public class MyProgram
{
    static int[][] board = new int[9][9];
    public static boolean isValid(int row, int col, int num) 
    {
    for (int c = 0; c < 9; c++)
    {
        if (board[row][c] == num)
        {
            return false;
        }
    }

    for (int r = 0; r < 9; r++)
    {
        if (board[r][col] == num)
        {
            return false;
        }
    }
    for (int r = 0; r < 3; r++)
    {
        for (int c = 0; c < 3; c++)
        {
            if (board[((row / 3) * 3) + r][((col / 3) * 3) + c] == num)
            {
                return false;
            }
        }
    }
    return true;
    }
    public static void main(String[] args) 
    {
        boolean solved = false;

        while (!solved) 
        {
            board = new int[9][9];
            solved = true;

            for (int row = 0; row < 9; row++)
            {
                for (int col = 0; col < 9; col++)
                {
                    int atp = 0;
                    int num = (int) (Math.random() * 9) + 1;

                    while (!isValid(row, col, num)) 
                    {
                        num = (int) (Math.random() * 9) + 1;
                        atp++;
                        if (atp > 100) 
                        { 
                            solved = false;
                            break;
                        }
                    }

                    if (!solved) 
                    {
                        break;
                    }
                    board[row][col] = num;
                }
                if (!solved) 
                {
                break;
                }
            }
        }
        for (int[] row : board) 
        {
    System.out.println(Arrays.toString(row));
        }
}
}
