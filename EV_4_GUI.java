import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EV_4_GUI extends JFrame
{

	private JPanel contentPane;
	private JTextField textField_fill;
	private JTextField textField_result;

	private JComboBox comboBox_left_1;
	private JComboBox comboBox_right_1;
	private JLabel lblNewLabel_3;

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
					EV_4_GUI frame = new EV_4_GUI();
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
	public EV_4_GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		String currency[] =
		{ "Thai Baht (THB)", "US dollar (USD)", "Euro (EUR)", "Japanese yen (JPY)", "The pound sterling (GBP)",
				"Australian dollar (AUD)", "Canadian dollar (CAD)", "Swiss franc (CHF)", "Chinese Yuan (CNY)",
				"Hong Kong dollar (HKD)", "New Zealand dollar (NZD)" };
		double arr[] = new double[11];

		comboBox_left_1 = new JComboBox(currency);
		comboBox_left_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		comboBox_left_1.setBounds(76, 103, 190, 38);
		contentPane.add(comboBox_left_1);

		comboBox_right_1 = new JComboBox(currency);
		comboBox_right_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_right_1.setBounds(427, 103, 190, 38);
		contentPane.add(comboBox_right_1);

		JButton btnNewButton_Convert = new JButton("Convert");
		btnNewButton_Convert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String inputs = textField_fill.getText();
				boolean check = true;
				check = inputs.isEmpty();
				if (check == true)
				{
					JLabel label = new JLabel("กรุณาใส่จำนวนเงิน!");
					label.setFont(new Font("Tahoma", Font.PLAIN, 16));
					JOptionPane.showMessageDialog(EV_4_GUI.this, label);
				}
				String output;
				if (check == false)
				{
					double inputd = Double.parseDouble(inputs);
					double usd = 33.18, eur = 36.05, jpy = 0.2230, gbp = 43.1, aud = 22.10, cad = 24, chf = 38.4,
							hkd = 4.27, nzd = 20.05, cny = 4.72;
					Object l, r;
					l = comboBox_left_1.getSelectedItem();
					r = comboBox_right_1.getSelectedItem();
					if (l != "Thai Baht (THB)" && r != "Thai Baht (THB)")
					{
						JLabel label = new JLabel("กรุณาเลือกสกุลเงินด้านหนึ่งเป็นเงินไทยบาท!");
						label.setFont(new Font("Tahoma", Font.PLAIN, 16));
						JOptionPane.showMessageDialog(EV_4_GUI.this, label);
					}

					if (l == "Thai Baht (THB)" && r == "Thai Baht (THB)")
					{
						textField_result.setText(inputs);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "US dollar (USD)")
					{
						output = String.valueOf(inputd / usd);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "Euro (EUR)")
					{
						output = String.valueOf(inputd / eur);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "Japanese yen (JPY)")
					{
						output = String.valueOf(inputd / jpy);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "The pound sterling (GBP)")
					{
						output = String.valueOf(inputd / gbp);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "Australian dollar (AUD)")
					{
						output = String.valueOf(inputd / aud);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "Canadian dollar (CAD)")
					{
						output = String.valueOf(inputd / cad);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "Swiss franc (CHF)")
					{
						output = String.valueOf(inputd / chf);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "Chinese Yuan (CNY)")
					{
						output = String.valueOf(inputd / cny);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "Hong Kong dollar (HKD)")
					{
						output = String.valueOf(inputd / hkd);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (l == "Thai Baht (THB)" && r == "New Zealand dollar (NZD)")
					{
						output = String.valueOf(inputd / nzd);
						textField_result.setText(output);
						textField_fill.setText(null);
					}

					if (r == "Thai Baht (THB)" && l == "Thai Baht (THB)")
					{
						textField_result.setText(inputs);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "US dollar (USD)")
					{
						output = String.valueOf(inputd * usd);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "Euro (EUR)")
					{
						output = String.valueOf(inputd * eur);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "Japanese yen (JPY)")
					{
						output = String.valueOf(inputd * jpy);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "The pound sterling (GBP)")
					{
						output = String.valueOf(inputd * gbp);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "Australian dollar (AUD)")
					{
						output = String.valueOf(inputd * aud);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "Canadian dollar (CAD)")
					{
						output = String.valueOf(inputd * cad);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "Swiss franc (CHF)")
					{
						output = String.valueOf(inputd * chf);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "Chinese Yuan (CNY)")
					{
						output = String.valueOf(inputd * cny);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "Hong Kong dollar (HKD)")
					{
						output = String.valueOf(inputd * hkd);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
					if (r == "Thai Baht (THB)" && l == "New Zealand dollar (NZD)")
					{
						output = String.valueOf(inputd * nzd);
						textField_result.setText(output);
						textField_fill.setText(null);
					}
				}

			}

		});
		btnNewButton_Convert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_Convert.setBounds(295, 285, 108, 38);
		contentPane.add(btnNewButton_Convert);

		textField_fill = new JTextField();
		textField_fill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_fill.setBounds(76, 212, 190, 38);
		contentPane.add(textField_fill);
		textField_fill.setColumns(10);

		textField_result = new JTextField();
		textField_result.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_result.setBackground(new Color(255, 255, 255));
		textField_result.setEditable(false);
		textField_result.setColumns(10);
		textField_result.setBounds(427, 212, 190, 38);
		contentPane.add(textField_result);

		JLabel lblNewLabel = new JLabel("เลือกสกุลเงิน");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(121, 51, 94, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("เลือกสกุลเงิน");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(478, 51, 94, 42);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("กรอกจำนวนเงินที่ต้องการ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(86, 170, 180, 42);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("จำนวนเงินที่ได้");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(475, 170, 108, 42);
		contentPane.add(lblNewLabel_2_1);

		lblNewLabel_3 = new JLabel(
				"ข้อมูลนี้อ้างอิงจาก https://www.superrich1965.com/th/exchange-rate วันที่ 16 ตุลาคม 2024 ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(121, 350, 518, 29);
		contentPane.add(lblNewLabel_3);
	}
}
