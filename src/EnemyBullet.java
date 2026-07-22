import java.awt.*;

public class EnemyBullet {

    int x;
    int y;

    int speed =6;
    boolean movingRight;

    public EnemyBullet(int x,int y,boolean movingRight){
        this.x =x;
        this.y=y;
        this.movingRight=movingRight;
    }

    public void update(Player player){
        if(movingRight){
            x +=speed;
        }
        else{
            x -=speed;
        }

    }

    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x,y,10,5);
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,10,5);
    }
}
