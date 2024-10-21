import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class EV_2_GUI extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea_show;

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
					EV_2_GUI frame = new EV_2_GUI();
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
	public EV_2_GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("กรุณาใส่คำที่ต้องการค้นหา");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 36, 192, 30);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(274, 36, 179, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_Search = new JButton("Search");
		btnNewButton_Search.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String mytext_tosearch = textField.getText().trim().toUpperCase();
				File f = new File("d:/Dictdata.txt");
				Scanner sc = null;
				Scanner scc = null;
				try
				{
					boolean isFound = false;
					System.out.println("start read file");
					sc = new Scanner(f);
					scc = new Scanner(f);
					while (sc.hasNext())
					{
						String word = sc.nextLine();
						String meaning = scc.nextLine();
						int a = 0;
						a = word.indexOf(",");
						word = word.substring(0, a);
						word = word.toUpperCase();
						meaning = meaning.substring(a+1, meaning.length());

						if (word.equals(mytext_tosearch))
						{
							textArea_show.setText("แปลว่า "+meaning);
							isFound = true;
							break;
						}
					}
					if (!isFound)
					{
						JOptionPane.showMessageDialog(EV_2_GUI.this, "Word not found!");
					}
					System.out.println("end read file");
					sc.close();

				} catch (FileNotFoundException h)
				{
					System.out.println("this is error");
					h.printStackTrace();
				}
			}
		});

		textArea_show = new JTextArea();
		textArea_show.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea_show.setEditable(false);
		textArea_show.setBounds(35, 111, 584, 357);
		contentPane.add(textArea_show);
		btnNewButton_Search.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_Search.setBounds(526, 36, 93, 30);
		contentPane.add(btnNewButton_Search);

	}
}
