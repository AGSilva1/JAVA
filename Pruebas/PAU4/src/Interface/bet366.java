package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class bet366 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bet366 frame = new bet366();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bet366() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1054, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLANTILLA BET366");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(36, 11, 941, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ALIAS:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 88, 75, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		textField.setBounds(121, 88, 340, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApuestas = new JLabel("APUESTAS");
		lblApuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuestas.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblApuestas.setBackground(Color.BLACK);
		lblApuestas.setBounds(36, 159, 941, 31);
		contentPane.add(lblApuestas);
		
		JLabel lblNewLabel_2 = new JLabel("NACIONAL 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(66, 261, 167, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("NACIONAL 2");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_2_1.setBounds(416, 261, 167, 31);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("INTERNACIONAL");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_2_1_1.setBounds(723, 261, 229, 31);
		contentPane.add(lblNewLabel_2_1_1);
	}
}
