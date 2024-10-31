import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class EV_7_GUI extends JFrame
{

	private JPanel contentPane;
	private JLabel bearlabel;
	private JLabel tigerlabel;
	private JLabel zebralabel;
	int b, t, z;
	private Timer timer;
	MusicPlayer musicPlayer;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					EV_7_GUI frame = new EV_7_GUI();
					frame.setVisible(true);
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public class MusicPlayer {
	    private Clip clip;

	    public MusicPlayer(String filePath) {
	        try {
	            File musicFile = new File("C:/EPT/eclipse-workspace/EV/musicwav.wav");
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
	            clip = AudioSystem.getClip();
	            clip.open(audioStream);
	        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	            e.printStackTrace();
	        }
	    }

	    public void play() {
	        if (clip != null) {
	            clip.start();
	            clip.loop(Clip.LOOP_CONTINUOUSLY);  // Loop music
	        }
	    }

	    public void stop() {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	        }
	    }
	}
	public EV_7_GUI()

	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 666, 395);
		contentPane.add(panel);
		panel.setLayout(null);

		bearlabel = new JLabel("");
		bearlabel.setBounds(22, 10, 102, 107);
		panel.add(bearlabel);
		ImageIcon iconb = new ImageIcon("C:/EPT/eclipse-workspace/EV/bear2.png");
		Image bear = iconb.getImage();
		Image newbear = bear.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		ImageIcon realbear = new ImageIcon(newbear);
		bearlabel.setIcon((realbear));
		b = bearlabel.getX();

		tigerlabel = new JLabel("");
		tigerlabel.setBounds(10, 137, 114, 120);
		panel.add(tigerlabel);
		ImageIcon icont = new ImageIcon("C:/EPT/eclipse-workspace/EV/tiger.png");
		Image tiger = icont.getImage();
		Image newtiger = tiger.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		ImageIcon realtiger = new ImageIcon(newtiger);
		tigerlabel.setIcon((realtiger));
		t = tigerlabel.getX();

		zebralabel = new JLabel("");
		zebralabel.setBounds(22, 267, 102, 110);
		panel.add(zebralabel);
		ImageIcon iconz = new ImageIcon("C:/EPT/eclipse-workspace/EV/zebra.png");
		Image zebra = iconz.getImage();
		Image newzebra = zebra.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
		ImageIcon realzebra = new ImageIcon(newzebra);
		zebralabel.setIcon((realzebra));
		z = zebralabel.getX();

		JLabel finishlabel = new JLabel("<html>F<br>I<br>N<br>I<br>S<br>H<br></html>");
		finishlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		finishlabel.setForeground(Color.DARK_GRAY);
		finishlabel.setFont(new Font("Tahoma", Font.PLAIN, 52));
		finishlabel.setBackground(Color.YELLOW);
		finishlabel.setBounds(611, 0, 55, 395);
		finishlabel.getVerticalTextPosition();
		panel.add(finishlabel);
		finishlabel.setOpaque(true);

		JButton btnNewButton = new JButton("Go!");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.RED);
		class Run extends TimerTask
		{
			public void run()
			{

				b = b + (int) ((Math.random() * 50) + 1);
				bearlabel.setLocation(b, bearlabel.getY());

				t = t + (int) ((Math.random() * 50) + 1);
				tigerlabel.setLocation(t, tigerlabel.getY());

				z = z + (int) ((Math.random() * 50) + 1);
				zebralabel.setLocation(z, zebralabel.getY());

				if (bearlabel.getX() >= 520)
				{
					JOptionPane.showMessageDialog(EV_7_GUI.this, "The winner is the bear!");
					timer.cancel();
					musicPlayer.stop();
				} else if (tigerlabel.getX() >= 520)
				{

					JOptionPane.showMessageDialog(EV_7_GUI.this, "The winner is the tiger!");
					timer.cancel();
					musicPlayer.stop();

				} else if (zebralabel.getX() >= 520)
				{

					JOptionPane.showMessageDialog(EV_7_GUI.this, "The winner is the zebra!");
					timer.cancel();
					musicPlayer.stop();
				}

			}
		}
		btnNewButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				musicPlayer = new MusicPlayer("C:/EPT/eclipse-workspace/EV/musicwav.wav");
				
		        musicPlayer.play();
				if (timer != null)
				{
					timer.cancel();
				}
				b = 0;
				t = 0;
				z = 0;
				bearlabel.setLocation(0, bearlabel.getY());
				tigerlabel.setLocation(0, tigerlabel.getY());
				zebralabel.setLocation(0, zebralabel.getY());
				musicPlayer.stop();
				timer = new Timer();
				TimerTask task = new Run();
				timer.schedule(task, 0, 150);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(256, 415, 112, 46);
		contentPane.add(btnNewButton);
	
	}
}
