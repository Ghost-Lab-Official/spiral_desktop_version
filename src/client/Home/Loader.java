package client.Home;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

public class Loader {
    static final WaitLayerUI layerUI = new WaitLayerUI();

    JFrame frame = new JFrame("Loading spiral content ....");

    public Loader() {
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
            }
        };
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.decode("#283A6D"));

        JLabel waitLable=new JLabel("<html><font size='6' color=white>Please wait...</font></html>",JLabel.CENTER);
        waitLable.setFont(new Font("Verdana", Font.PLAIN, 25));
        waitLable.setForeground(Color.white);

        waitLable.setBackground(Color.white);

        waitLable.setVerticalAlignment(JLabel.BOTTOM);

        JLayer<JPanel> jlayer = new JLayer<>(panel, layerUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jlayer);
//
        frame.pack();
        panel.add(waitLable, BorderLayout.CENTER);

        frame.setVisible(true);
        layerUI.start();

        ActionListener managePlay=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layerUI.stop();
                panel.remove(waitLable);
            }
        };

        Timer timer = new Timer(6000,managePlay);
        timer.setInitialDelay(10000);
        timer.setRepeats(false);
        timer.start();


    }




    public static void main(String args[]) {





        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Loader loading_Test = new Loader();
            }
        });

        //setting timer to load



    }

}





class WaitLayerUI extends LayerUI<JPanel> implements ActionListener {
    private boolean mIsRunning;
    private boolean mIsFadingOut;
    private Timer mTimer;
    private int mAngle;
    private int mFadeCount;
    private int mFadeLimit = 15;



    @Override
    public void paint(Graphics g, JComponent c) {
        int w = c.getWidth();
        int h = c.getHeight();
        super.paint(g, c); // Paint the view.
        if (!mIsRunning) {
            return;
        }
        Graphics2D g2 = (Graphics2D) g.create();
        //g2.setFont();

        float fade = (float) mFadeCount / (float) mFadeLimit;
        Composite urComposite = g2.getComposite(); // Gray it out.
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f * fade));
        g2.fillRect(0, 0, w, h);
        g2.setComposite(urComposite);
        int s = Math.min(w, h) / 5;// Paint the wait indicator.
        int cx = w / 2;
        int cy = h / 2;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(s / 4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setPaint(Color.white);
        g2.rotate(Math.PI * mAngle / 180, cx, cy);
        for (int i = 0; i < 12; i++) {
            float scale = (11.0f - (float) i) / 11.0f;
            g2.drawLine(cx + s, cy, cx + s * 1, cy);
            g2.rotate(-Math.PI / 6, cx, cy);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, scale * fade));


        }

        g2.dispose();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (mIsRunning) {
            firePropertyChange("tick", 0, 1);
            mAngle +=4;
            if (mAngle >= 360) {
                mAngle = 0;
            }
            if (mIsFadingOut) {
                if (--mFadeCount == 0) {
                    mIsRunning = false;
                    mTimer.stop();

                }
            } else if (mFadeCount < mFadeLimit) {
                mFadeCount++;
            }
        }
    }



    public void start(){
        if (mIsRunning) {
            return;
        }
        mIsRunning = true;// Run a thread for animation.
        mIsFadingOut = false;
        mFadeCount = 0;
        int fps = 24;
        int tick = 1000 / fps;
        mTimer = new Timer(tick, this);
        mTimer.start();
    }
    public void stop(){
        mIsFadingOut = true;

    }


    @Override
    public void applyPropertyChange(PropertyChangeEvent pce, JLayer l) {
        if ("tick".equals(pce.getPropertyName())) {
            l.repaint();
        }
    }
}

