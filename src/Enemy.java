import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Enemy {
    int x;
    int y;
    int shootTimer =0;

    int width = 100;
    int height =100;
    boolean facingRight =false;

    int speed =2;

    Image[] runFrame = new Image[8];
    Image[] attackFrame = new Image[10];

    public static final int RUN =0;
    public static final int ATTACK =1;
    int currentState =RUN;

    int currentFrame =0;
    int animationCounter =0;

    public Enemy(int x,int y){
        this.x =x;
        this.y =y;
        try{
            for(int i=0;i<8;i++){
                runFrame[i] =ImageIO.read(
                        new File("assets/enemy/walk/Bringer-of-Death_Walk_" +(i+1)+".png")
                );

            }

            for(int i=0;i<10;i++){
                attackFrame[i] =ImageIO.read(
                        new File("assets/enemy/Attack/Bringer-of-Death_Attack_" +(i+1)+".png")
                );

            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public Rectangle getBounds(){
        return new Rectangle(x+30,y+20,20,100);
    }

    public void update(Player player,ArrayList<EnemyBullet> enemyBullets ){
        int distance =Math.abs(player.x-x);

        if(distance>50){
            currentState=RUN;

            if(player.x<x){
                x-=speed;
                facingRight=true;
            }

            if(player.x>x){
                x+=speed;
                facingRight=false;
            }
        }else{
            currentState =ATTACK;

            shootTimer++;

            if(shootTimer>120){
                shootTimer=0;

                enemyBullets.add(
                        new EnemyBullet(x,y+height/2,facingRight)
                );
            }
        }

        animationCounter++;
        if(animationCounter>=6){
            animationCounter =0;
            currentFrame++;

            int maxFrames;

            if(currentState==RUN){
                maxFrames=runFrame.length;
            }else{
                maxFrames=attackFrame.length;
            }

            if(currentFrame>=maxFrames){
                currentFrame=0;
            }
        }

    }

    public void draw(Graphics g){
        Graphics2D g2 =(Graphics2D) g;

        Image currentImage;

        if(currentState==RUN){
            currentImage =runFrame[currentFrame];
        }else{
            currentImage =attackFrame[currentFrame];
        }

        if(facingRight){
            g2.drawImage(
                    currentImage,x,y,width,height,null
            );
        }else{
            g2.drawImage(
                    currentImage,x+width,y,-width,height,null
            );
        }
    }

}
