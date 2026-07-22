import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements KeyListener {
    Player player;
    Timer timer;
    boolean leftPressed = false;
    boolean rightPressed = false;
    ArrayList<Bullet> bullets = new ArrayList<>();
    boolean facingRight =true;
    ArrayList<Enemy> enemies =new ArrayList<>();
    ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
    int spawncounter =0;
    World1 World1;
    Image background;

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



    public GamePanel(){

        player = new Player();
        addKeyListener(this);
        setFocusable(true);
        setBackground(Color.BLACK);

        try {

            tile1 = ImageIO.read(
                    new File("assets/world/world1/1.png")
            );

            tile2 = ImageIO.read(
                    new File("assets/world/world1/2.png")
            );

            tile3 = ImageIO.read(
                    new File("assets/world/world1/3.png")
            );

            tile4 = ImageIO.read(
                    new File("assets/world/world1/4.png")
            );

            tile5 = ImageIO.read(
                    new File("assets/world/world1/5.png")
            );

            tile6 = ImageIO.read(
                    new File("assets/world/world1/6.png")
            );

            tile7 = ImageIO.read(
                    new File("assets/world/world1/7.png")
            );

            tile8 = ImageIO.read(
                    new File("assets/world/world1/8.png")
            );

            tile9 = ImageIO.read(
                    new File("assets/world/world1/9.png")
            );

            tile10 = ImageIO.read(
                    new File("assets/world/world1/10.png")
            );

            tile11 = ImageIO.read(
                    new File("assets/world/world1/11.png")
            );

            tile12 = ImageIO.read(
                    new File("assets/world/world1/12.png")
            );

            tile13 = ImageIO.read(
                    new File("assets/world/world1/13.png")
            );

            tile14 = ImageIO.read(
                    new File("assets/world/world1/14.png")
            );

            tile15 = ImageIO.read(
                    new File("assets/world/world1/15.png")
            );

            tile16 = ImageIO.read(
                    new File("assets/world/world1/16.png")
            );

            background=ImageIO.read(
                    new File("assets/BG/BG.png")
            );

            World1 = new World1(
                    tile1,tile2,tile3,tile4,
                    tile5,tile6,tile7,tile8,
                    tile9,tile10,tile11,tile12,
                    tile13,tile14,tile15,tile16,background
            );


        } catch(Exception e){

            e.printStackTrace();

        }

        timer = new Timer(16,e->{


            if(leftPressed){
                    player.x -=5;
                    facingRight=false;
                    player.currentState=player.RUN;
                }

                if(rightPressed){
                    player.x +=5;
                    facingRight=true;
                    player.currentState=player.RUN;
                }

                if(!leftPressed && !rightPressed && player.onGround){
                    player.currentState=player.IDLE;
                }

                if(!player.onGround){
                    player.currentState=player.JUMP;
                }

                for(Bullet bullet : bullets){
                    bullet.update();
                }

                spawncounter++;

            if (spawncounter >= 120) {
                if(enemies.size()<3) {
                    enemies.add(new Enemy(350, 200));
                    spawncounter = 0;
                }
            }

                for(Enemy enemy:enemies){
                    enemy.update(player,enemyBullets);
                }

                for(EnemyBullet bullet :enemyBullets){
                    bullet.update(player);
                }

            for(int i=enemyBullets.size()-1;i>=0;i--){
                EnemyBullet enemybullet =enemyBullets.get(i);

                    if(enemybullet.getBounds().intersects(player.getBounds())) {
                        enemyBullets.remove(i);
                        System.out.println("player hit");
                    }
                }

                for(int i=bullets.size()-1;i>=0;i--){
                    Bullet bullet=bullets.get(i);
                    for(int j= enemies.size()-1;j>=0;j--){
                        Enemy enemy=enemies.get(j);

                        if(bullet.getBounds().intersects(enemy.getBounds())) {
                            bullets.remove(i);
                            enemies.remove(j);
                        }
                            break;
                    }
                }

                player.update(leftPressed,rightPressed);
                repaint();
            });

        timer.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        World1.draw(g);
        player.draw(g);
        for(Bullet bullet : bullets){
            bullet.draw(g);
        }

        for(Enemy enemy : enemies){
            enemy.draw(g);
        }

        for(EnemyBullet bullet : enemyBullets){
            bullet.draw(g);
        }
    }

    public void keyPressed(KeyEvent e){


        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightPressed = true;
            player.facingRight =true;
        }

        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftPressed =true;
            player.facingRight=false;
        }

        if(e.getKeyCode()==KeyEvent.VK_SPACE && player.onGround){
            player.velocityY = -18;
            player.onGround =false;
        }

        if(e.getKeyCode()==KeyEvent.VK_F){
            bullets.add(new Bullet(
                    player.x + player.width/2,
                    player.y + player.height/2,
                    facingRight
            ));
        }

        repaint();

    }
        @Override
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            leftPressed = false;
        }

        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            rightPressed=false;
        }
    }


    public void keyTyped(KeyEvent e){

    }

}