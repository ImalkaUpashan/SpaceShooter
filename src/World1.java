import java.awt.*;

public class World1 {

    public final int tileSize = 50;

    Image background;

    int[][] map = {
            {},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {2,2,2,2,3, 0, 0, 0, 0, 0, 0,1,2,2,2},
            {9,9,9,9,6, 0, 0, 0, 0, 0, 0,4,5,5,5},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 9, 9, 9},
            { 0, 0, 0,13,14,15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0,0,1,2,3, 0, 0, 0, 0, 0, 0,},
            { 0, 0, 0, 0, 0, 0,0,4,5,6, 0, 0, 0, 0, 0, 0,},
            {2, 2, 3, 0, 0, 0, 1,2,2,2,2,3,0,0,0,0},
            {2, 2, 2, 2, 17, 17, 5, 5, 5, 5, 5, 5, 2, 2, 17, 17},
            {5, 5, 5, 5, 18, 18, 5, 5, 5, 5, 5, 5, 5, 5, 18, 18},
            {5, 5, 5, 5, 18, 18, 5, 5, 5, 5, 5, 5, 5, 5, 18, 18}
    };


    Image tile1;
    Image tile2;
    Image tile3;
    Image tile4;
    Image tile5;
    Image tile6;
    Image tile7;
    Image tile8;
    Image tile9;
    Image tile10;
    Image tile11;
    Image tile12;
    Image tile13;
    Image tile14;
    Image tile15;
    Image tile16;


    public World1(
            Image tile1,
            Image tile2,
            Image tile3,
            Image tile4,
            Image tile5,
            Image tile6,
            Image tile7,
            Image tile8,
            Image tile9,
            Image tile10,
            Image tile11,
            Image tile12,
            Image tile13,
            Image tile14,
            Image tile15,
            Image tile16,
            Image background
    ) {

        this.tile1 = tile1;
        this.tile2 = tile2;
        this.tile3 = tile3;
        this.tile4 = tile4;
        this.tile5 = tile5;
        this.tile6 = tile6;
        this.tile7 = tile7;
        this.tile8 = tile8;
        this.tile9 = tile9;
        this.tile10 = tile10;
        this.tile11 = tile11;
        this.tile12 = tile12;
        this.tile13 = tile13;
        this.tile14 = tile14;
        this.tile15 = tile15;
        this.tile16 = tile16;
        this.background= background;

    }

    public boolean isSolidTile(int tile){
        switch(tile){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return true;

            default:
                return false;

        }
    }

    public boolean isSolidAt(int worldX,int worldY){

        int col=worldX/tileSize;
        int row=worldY/tileSize;

        if(row<0 || row>= map.length)
            return false;
        if(col<0 || col>= map[row].length)
            return false;
        return isSolidTile(map[row][col]);
    }



    public void draw(Graphics g){

        g.drawImage(background,0,0,1280,720,null);

        for(int row = 0; row < map.length; row++){

            for(int col = 0; col < map[row].length; col++){

                int tile = map[row][col];

                int x = col * tileSize;
                int y = row * tileSize;


                if(tile == 1){
                    g.drawImage(tile1, x, y, tileSize, tileSize, null);
                }

                else if(tile == 2){
                    g.drawImage(tile2, x, y, tileSize, tileSize, null);
                }

                else if(tile == 3){
                    g.drawImage(tile3, x, y, tileSize, tileSize, null);
                }

                else if(tile == 4){
                    g.drawImage(tile4, x, y, tileSize, tileSize, null);
                }

                else if(tile == 5){
                    g.drawImage(tile5, x, y, tileSize, tileSize, null);
                }

                else if(tile == 6){
                    g.drawImage(tile6, x, y, tileSize, tileSize, null);
                }

                else if(tile == 7){
                    g.drawImage(tile7, x, y, tileSize, tileSize, null);
                }

                else if(tile == 8){
                    g.drawImage(tile8, x, y, tileSize, tileSize, null);
                }

                else if(tile == 9){
                    g.drawImage(tile9, x, y, tileSize, tileSize, null);
                }

                else if(tile == 10){
                    g.drawImage(tile10, x, y, tileSize, tileSize, null);
                }

                else if(tile == 11){
                    g.drawImage(tile11, x, y, tileSize, tileSize, null);
                }

                else if(tile == 12){
                    g.drawImage(tile12, x, y, tileSize, tileSize, null);
                }

                else if(tile == 13){
                    g.drawImage(tile13, x, y, tileSize, tileSize, null);
                }

                else if(tile == 14){
                    g.drawImage(tile14, x, y, tileSize, tileSize, null);
                }

                else if(tile == 15){
                    g.drawImage(tile15, x, y, tileSize, tileSize, null);
                }

                else if(tile == 16){
                    g.drawImage(tile16, x, y, tileSize, tileSize, null);
                }

            }
        }
    }
}