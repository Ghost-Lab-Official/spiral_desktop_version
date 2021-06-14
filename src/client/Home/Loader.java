package client.Home;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import client.Landing;

=======
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24

public class Loader {
    static final WaitLayerUI layerUI = new WaitLayerUI();

    JFrame frame = new JFrame("Loading spiral content ....");

    public Loader() {
<<<<<<< HEAD
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width,700);
=======
        JPanel panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 400);
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
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
<<<<<<< HEAD
//                clossing the current class
                layerUI.stop();
                panel.remove(waitLable);
                Window win = SwingUtilities.getWindowAncestor(panel);
                win.dispose();

                // then call the second class
                Landing landing   =new Landing();
                landing.initUI();
            }
        };


        Timer timer = new Timer(6000,managePlay);
        timer.setInitialDelay(3000);
        timer.setRepeats(false);
        timer.start();

//        layerUI.stop();

=======
                layerUI.stop();
                panel.remove(waitLable);
            }
        };

        Timer timer = new Timer(6000,managePlay);
        timer.setInitialDelay(10000);
        timer.setRepeats(false);
        timer.start();

>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24

    }




    public static void main(String args[]) {





        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Loader loading_Test = new Loader();
<<<<<<< HEAD

=======
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
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

