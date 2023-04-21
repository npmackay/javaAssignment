package model;

import java.util.Random;

public class datamodel {
   
    public static String[][] getData()
    {
        int numCols = 4;
        Random random = new Random();
        String[][] data;

        int numRows = 10 + random.nextInt(20);
        data = new String[numRows][numCols];

        for(int row = 0; row < numRows; row++)
        {
            for(int col = 0; col < numCols; col++)
            {
                data[row][col] = String.valueOf(random.nextInt(1000));
            }
        }
        return data;
    }

}
