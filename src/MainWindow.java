import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class MainWindow extends JFrame {

    private JPanel Contentpane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            MainWindow window=new MainWindow();
            window.setVisible(true);
            }
        });
    }
        public MainWindow(){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setBounds(100,100,600,600);
            Contentpane=new JPanel();
            Contentpane.setBorder(new EmptyBorder(5,5,5,5));
            setContentPane(Contentpane);
            Contentpane.setLayout(new CardLayout(0,0));

            DrawingPanel draw=new DrawingPanel();
            draw.setBackground(Color.white);

            Contentpane.add(draw);
            draw.setLayout(null);
        }
    }


