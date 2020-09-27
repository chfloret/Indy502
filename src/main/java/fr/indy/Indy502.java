package fr.indy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static fr.indy.Constants.*;

public class Indy502 extends JFrame {

    private final transient Engine engine;

    public Indy502() {
        super("Indy502");

        engine = new Engine();

        final JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                Indy502.this.engine.compute(graphics);
            }
        };
        content.setPreferredSize(new Dimension(COLUMNS * PIXELS, ROWS * PIXELS));
        content.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Indy502.this.engine.keyEvent(e);
            }
        });
        content.setFocusable(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(false);
        setContentPane(content);

        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (!Indy502.this.engine.isGameOver()) {
                    content.repaint();

                    try {
                        Thread.sleep(DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (!Indy502.this.engine.getWinner()) {
                    Indy502.this.engine.setLoser(true);
                }

                content.repaint();
            }
        });

        thread.start();
    }

    public static void main(String[] args) {
        Indy502 window = new Indy502();
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
