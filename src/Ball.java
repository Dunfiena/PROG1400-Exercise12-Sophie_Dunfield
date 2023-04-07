import java.awt.*;

public class Ball extends Token{

    //Constructor
    public Ball(Color color, int heigth, int width, int Xposition, int Yposition, int Xspeed, int Yspeed){
        this.setColor(color);
        this.setHeight(heigth);
        this.setWidth(width);
        this.setxPosition(Xposition);
        this.setyPosition(Yposition);
        this.setxSpeed(Xspeed);
        this.setySpeed(Yspeed);
    }

    //Draw the ball
    @Override
    public void drawToken(Graphics g) {
        g.setColor(this.getColor());
        g.fillOval(this.getxPosition(),this.getyPosition(),this.getWidth(),this.getHeight());
    }

    //Move the ball
    @Override
    public void moveToken() {
        this.setxPosition(this.getxPosition()+this.getxSpeed());
        this.setyPosition(this.getyPosition()+this.getySpeed());
    }

}
