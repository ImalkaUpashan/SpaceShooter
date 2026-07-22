import java.awt.*;

public class Bullet {
    int x;
    int y;

    int speed =10;

    boolean movingRight;

    public Bullet(int x,int y,boolean movingRight){
        this.x=x;
        this.y=y;
        this.movingRight=movingRight;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,10,5);
    }


    public void update(){
    if(movingRight){
        x += speed;
    }else{
        x -= speed;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillOval(x,y,10,5);
    }
}
