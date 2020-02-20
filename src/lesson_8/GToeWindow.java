package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GToeWindow extends JFrame {
    private int rows;
    private int cols;
    private JButton[][] field;
    private JLabel message;
    private int gPoint[] = new int[]{-1, -1};  //тут храним координаты нажатой кнопки
    private boolean restartFlag = false;

    public GToeWindow(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        setTitle("Tic Tac Toe");
        setBounds(200, 200, cols * 80, rows * 80 + 24);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        field = new JButton[rows][cols];


        JPanel gameField = new JPanel();
        gameField.setLayout(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                initFieldBtn(i, j);
                gameField.add(field[i][j]);
            }
        }

        JPanel footer = new JPanel();
        footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));
        JButton res = new JButton("Restart");
        res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                restartFlag = true;
            }
        });
        footer.add(res);
        message = new JLabel("");
        footer.add(message);


        getContentPane().add(gameField, BorderLayout.CENTER);
        getContentPane().add(footer, BorderLayout.SOUTH);


        setVisible(true);
    }

    private void initFieldBtn(int i, int j) {
        field[i][j] = new JButton("");
        field[i][j].addActionListener(new ActionListener() {
            final int x = i;
            final int y = j;

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gPoint[0] = x;
                gPoint[1] = y;
            }
        });
    }


    public void GPrintField(char[][] field) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.field[i][j].setText("" + field[i][j]);
            }
        }
    }

    public void GPrintMessage(String mes) {
        message.setText(mes);
    }

    public void resPoint() {
        gPoint[0] = -1;
    }

    public int[] getPoint() {
        return gPoint;
    }

    public boolean getRestartFlag() {
        return restartFlag;
    }


    public void resRestartFlag() {
        restartFlag = false;
    }
}
