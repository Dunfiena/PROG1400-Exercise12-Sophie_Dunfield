import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
public class DrawingPanel extends JPanel{

    int count;
    private Timer timer=new Timer(10, new TimerAction());
    ArrayList<Token> tokens;
    JTextArea clicks;
    JTextArea speed;
    JTextArea gameover;

    public DrawingPanel(){
        tokens=new ArrayList<>();
        Ball ball=new Ball(Color.BLUE, 50,50,300,300,5,0);
        tokens.add(ball);
        clicks=new JTextArea();
        clicks.setEditable(false);
        clicks.setBounds(300,0,100,25);
        speed=new JTextArea();
        speed.setEditable(false);
        speed.setBounds(400,0,100,25);
        add(clicks);
        add(speed);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (timer.isRunning()){
                    count++;
                    clicks.setText("Clicks: " +count);
                    speed.setText("Speed: " + ball.getxSpeed());
                    if(ball.getxSpeed()>0) {
                        ball.setxSpeed((ball.getxSpeed() + count/5) * -1);
                    } else if (ball.getxSpeed()<0) {
                        ball.setxSpeed((ball.getxSpeed() - count/3) * -1);
                    }
                } else {
                    timer.start();
                }
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Token tok: tokens){
            tok.drawToken(g);
        }
    }
    public void movethings(){
        for(Token tok:tokens){
            tok.moveToken();
            this.checkcollision(tok);
        }
        this.repaint();
    }

    public void checkcollision(Token currToken){
        gameover=new JTextArea();
        gameover.setBounds(200,200,200,200);
        gameover.setFont(new Font("Merryweather", Font.BOLD, 32));
        gameover.setEditable(false);
        if(currToken.getxPosition()+currToken.getWidth()>this.getWidth()){
            gameover.setText("Game Over! \n Score: "+getCount());
            add(gameover);
        } else if (currToken.getxPosition()<0) {
            currToken.setxSpeed(currToken.getxSpeed()*-1);
            gameover.setText("Game Over! \n Score: " +getCount());
            add(gameover);
        }
    }

    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            movethings();
        }
    }

    public int getCount() {
        return count;
    }
}
