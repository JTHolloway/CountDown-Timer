package countdowntimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class JFrame extends javax.swing.JFrame implements ActionListener {

    private boolean StartPressed = false;
    private boolean reset = false;
    private int value;
    private String MusicFile = System.getProperty("user.dir") + "\\Music\\Beep.wav";

    public JFrame() {
        initComponents();

        this.setVisible(true);
        this.setSize(430, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Start();
    }

    private void Start() {
        reset = false;
        StartPressed = false;
        Time.setValue(0);
        while (!StartPressed) {
            value = Time.getValue();
            Time();

            try {
                Thread.sleep(200);
            } catch (InterruptedException ie) {
                System.out.println("Error: " + ie);
            }
        }
        CountDown();
    }

    private void Reset() {
        Stop();
        reset = true;
        value = 0;
        Time.setValue(0);
        Time();

    }

    private void Stop() {
        StartPressed = false;
    }

    private void CountDown() {

        if (StartPressed) {
            A:
            while (value > 0) {
                if (StartPressed) {
                    value = value - 1;
                    Time();
                    System.out.println(value);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        System.out.println("Error: " + ie);
                    }
                } else {
                    if (reset) {
                        break A;
                    }
                    value = value;
                }
            }

            if (value == 0) {
                for (int i = 0; i < 3; i++) {
                    if (!reset) {
                        playMusic();
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        System.out.println("Error: " + ie);
                    }
                }
            }

            Start();
        }
    }

    private void playMusic() {
        InputStream beep;
        try {
            beep = new FileInputStream(new File(MusicFile));
            AudioStream Sound = new AudioStream(beep);
            AudioPlayer.player.start(Sound);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(Start, e, MusicFile, 200);
        }
    }

    private void Time() {
        int Mins = value / 60;
        int seconds = value % 60;

        String M = String.format("%02d", Mins);
        String S = String.format("%02d", seconds);

        Minuets.setText(M);
        Seconds.setText(":" + S);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Time = new javax.swing.JSlider();
        Seconds = new javax.swing.JLabel();
        Minuets = new javax.swing.JLabel();
        Start = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Stop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Time.setMaximum(3600);
        Time.setValue(0);
        getContentPane().add(Time);
        Time.setBounds(110, 140, 200, 26);

        Seconds.setFont(new java.awt.Font("Trebuchet MS", 1, 86)); // NOI18N
        Seconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Seconds.setText(":00");
        getContentPane().add(Seconds);
        Seconds.setBounds(180, 30, 150, 111);

        Minuets.setFont(new java.awt.Font("Trebuchet MS", 1, 86)); // NOI18N
        Minuets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Minuets.setText("00");
        getContentPane().add(Minuets);
        Minuets.setBounds(90, 30, 100, 111);

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        getContentPane().add(Start);
        Start.setBounds(180, 170, 80, 23);

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Reset);
        Reset.setBounds(270, 170, 61, 23);

        Stop.setText("Stop");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
        getContentPane().add(Stop);
        Stop.setBounds(90, 170, 80, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
        StartPressed = true;

    }//GEN-LAST:event_StartActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_ResetActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        // TODO add your handling code here:
        Stop();
    }//GEN-LAST:event_StopActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Minuets;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel Seconds;
    private javax.swing.JButton Start;
    private javax.swing.JButton Stop;
    private javax.swing.JSlider Time;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
