

import java.io.File;
import java.io.FileReader;
import java.awt.Point;
import java.io.IOException;

import Code.Hero;

public class Map extends Hero {
    boolean[][] m = new boolean[5][5];
    char[][] arr = new char[5][5];
    char[] chars;
    int counter = 0;

    public void loadMap(int level) {
        String f = "level"+level+".txt";
        File file = new File(f);
        try (FileReader fr = new FileReader(file)) {
            chars = new char[(int) file.length()];
            fr.read(chars);
            String fileContent = new String(chars);
            System.out.println(fileContent);
        } catch (IOException e) {
            System.out.println("Error Occured!! Check your File!");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char e = chars[counter];
                arr[i][j] = e;
                counter++;
            }
        }
    }
    
    public Point findStart()
    {
        Point loc;
        loc.setLocation(0, 0);
        return loc;
    }

    public void removeCharAtLoc(Point loc)
    {
        int x = (int)loc.getX();
        int y = (int)loc.getY();

        m[x][y] = false;
    }

    public void reveal(Point loc)
    {
        int x = (int)loc.getX();
        int y = (int)loc.getY();

        m[x][y] = true;
    }

    public String mapToString()
    {
        int x = (int)loc.getX();
        int y = (int)loc.getY();

        for(int i = 0;i < 5;i++)
        {
            for(int j = 0;j < 5;i++)
            {
                if(m[i][j]) arr[i][j] = 'X';
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        String curr_pos = "Hero Current Position : "+arr[x][y];
        return curr_pos;
    }
}