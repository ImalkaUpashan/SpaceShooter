import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;

public class Player {
    int x=350;
    int y=250;

    int width =50;
    int height=50;

    int velocityY =0;
    int gravity =1;
    boolean onGround =true;

    Image[] idleFrame = new Image[10];
    Image[] runFrame = new Image[10];
    Image[] jumpFrame = new Image[10];

    public static final int IDLE=0;
    public static final int RUN=1;
    public static final int JUMP=2;

    int currentState =IDLE;
    int maxFrames;

    int currentFrame=0;
    int animationCounter =0;

    boolean facingRight = true;

    public Player(){
        try{
            for(int i=0;i<10;i++){
                idleFrame[i] =ImageIO.read(
                        new File("assets/sprite/idle/idle" +(i+1)+".png")
                );

            }

            for(int i=0;i<10;i++){
                runFrame[i] =ImageIO.read(
                        new File("assets/sprite/run/run" +(i+1)+".png")
                );

            }

            for(int i=0;i<10;i++){
                jumpFrame[i] =ImageIO.read(
                        new File("assets/sprite/jump/jump" +(i+1)+".png")
                );

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(boolean leftPressed,boolean rightPressed,World1 world){

        if(leftPressed){
            if(!world.isSolidAt(
                    x-2,y+height/2
            )){
                x-=5;
            }
            facingRight=false;
        }

        if(rightPressed){
            if(!world.isSolidAt(
                    x+width+2,y+height/2
            )){
                x+=5;
            }
        facingRight=true;
        }

        velocityY +=gravity;
        y += velocityY;

       if(world.isSolidAt(
               x+width/2,y+height)){
           int tileRow =(y+height)/ world.tileSize;
           y=tileRow* world.tileSize-height;
           velocityY=0;
           onGround=true;
       }else{
           onGround=false;
       }

        animationCounter++;
        if(animationCounter>=6){
            animationCounter=0;
            currentFrame++;

            if(!onGround){
                currentState =JUMP;
            }else if (leftPressed ||rightPressed){
                currentState =RUN;
            }else{
                currentState =IDLE;
            }

            switch(currentState){
                case IDLE :
                    maxFrames=idleFrame.length;
                    break;

                case RUN :
                    maxFrames=runFrame.length;
                    break;

                case JUMP :
                    maxFrames=jumpFrame.length;
                    break;
            }

            if(currentFrame>=maxFrames){
                currentFrame =0;
            }
        }

    }

    public void draw(Graphics g){
        Image currentImage =null;

        switch(currentState){
            case IDLE :
                currentImage= idleFrame[currentFrame];
                break;

            case RUN :
                currentImage= runFrame[currentFrame];
                break;

            case JUMP :
                currentImage= jumpFrame[currentFrame];
                break;
        }

        Graphics2D g2 =(Graphics2D) g;

        if(facingRight){
            g2.drawImage(currentImage,x,y,width,height,null);
        }else{
            g2.drawImage(currentImage,x+width,y,-width,height,null);
        }

    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
}
