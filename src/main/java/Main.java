import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Main {

    JFrame window;
    JLabel counterLabel;
    Font font = new Font("Arial", Font.PLAIN, 34);

    Timer timer;

    int second;
    int minute;
    String ddSecond, ddMinute;
    DecimalFormat decimalFormat = new DecimalFormat("00");


    public static void main(String[] args) {

        new Main();
    }

    public Main(){

        window = new JFrame();
        window.setSize(400,200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        counterLabel = new JLabel("Counter");
        counterLabel.setBounds(0,0,400,200);
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setOpaque(true);
        counterLabel.setBackground(Color.DARK_GRAY);
        counterLabel.setFont(font);
        counterLabel.setForeground(Color.WHITE);

        window.add(counterLabel);
        window.setVisible(true);

            counterLabel.setText("50:00");
            second = 0;
            minute = 50;
            countdownTimer();
            timer.start();
    }

    public void countdownTimer(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second--;
                ddSecond = decimalFormat.format(second);
                ddMinute = decimalFormat.format(minute);

                counterLabel.setText(ddMinute + ":" + ddSecond);

                if(second==-1){
                    second = 59;
                    minute--;
                    ddSecond = decimalFormat.format(second);
                    ddMinute = decimalFormat.format(minute);
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }

                if(minute == 0 && second == 0){
                    timer.stop();
                }
            }
        });
    }
}
