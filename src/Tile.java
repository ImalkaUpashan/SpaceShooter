import java.awt.*;

public class Tile {
Image image;

int x;
int y;

int size=50;


public Tile(Image image,int x,int y){
    this.image=image;
    this.x =x;
    this.y =y;
}

public void draw(Graphics g){
    g.drawImage(image,x,y,size,size,null);
}

}
