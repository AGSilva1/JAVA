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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;

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
		lblNewLabel_1.setBounds(36, 53, 75, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		textField.setBounds(121, 53, 340, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApuestas = new JLabel("APUESTAS");
		lblApuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuestas.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblApuestas.setBackground(Color.BLACK);
		lblApuestas.setBounds(36, 95, 941, 31);
		contentPane.add(lblApuestas);
		
		JLabel lblNewLabel_2 = new JLabel("INTERNACIONAL 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(19, 238, 229, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Partido 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(258, 203, 119, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Partido 2");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(409, 203, 119, 19);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Partido 3");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(554, 201, 114, 19);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Partido 4");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(702, 201, 119, 19);
		contentPane.add(lblNewLabel_3_3);
		
		JComboBox pa1int1 = new JComboBox();
		pa1int1.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa1int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int1.setBounds(258, 238, 119, 22);
		contentPane.add(pa1int1);
		
		JComboBox pa1int2 = new JComboBox();
		pa1int2.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa1int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int2.setBounds(258, 271, 119, 22);
		contentPane.add(pa1int2);
		
		JComboBox pa1int3 = new JComboBox();
		pa1int3.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa1int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int3.setBounds(258, 304, 119, 22);
		contentPane.add(pa1int3);
		
		JComboBox pa1nac = new JComboBox();
		pa1nac.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa1nac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1nac.setBounds(258, 337, 119, 22);
		contentPane.add(pa1nac);
		
		JComboBox pa2int1 = new JComboBox();
		pa2int1.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa2int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int1.setBounds(409, 238, 119, 22);
		contentPane.add(pa2int1);
		
		JComboBox pa3int1 = new JComboBox();
		pa3int1.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa3int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int1.setBounds(554, 238, 119, 22);
		contentPane.add(pa3int1);
		
		JComboBox pa2int2 = new JComboBox();
		pa2int2.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa2int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int2.setBounds(409, 271, 119, 22);
		contentPane.add(pa2int2);
		
		JComboBox pa2int3 = new JComboBox();
		pa2int3.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa2int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int3.setBounds(409, 304, 119, 22);
		contentPane.add(pa2int3);
		
		JComboBox pa4int1 = new JComboBox();
		pa4int1.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa4int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int1.setBounds(702, 238, 119, 22);
		contentPane.add(pa4int1);
		
		JComboBox pa4int2 = new JComboBox();
		pa4int2.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa4int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int2.setBounds(702, 271, 119, 22);
		contentPane.add(pa4int2);
		
		JComboBox pa4int3 = new JComboBox();
		pa4int3.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa4int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int3.setBounds(702, 304, 119, 22);
		contentPane.add(pa4int3);
		
		JComboBox pa4nac = new JComboBox();
		pa4nac.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa4nac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4nac.setBounds(702, 337, 119, 22);
		contentPane.add(pa4nac);
		
		JButton btnNewButton = new JButton("Apostar");
		btnNewButton.setBounds(451, 385, 101, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finalizar Apuestas");
		btnNewButton_1.setBounds(42, 500, 119, 31);
		contentPane.add(btnNewButton_1);
		
		JComboBox pa3int2 = new JComboBox();
		pa3int2.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa3int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int2.setBounds(554, 273, 119, 22);
		contentPane.add(pa3int2);
		
		JComboBox pa3int3 = new JComboBox();
		pa3int3.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa3int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int3.setBounds(554, 306, 119, 22);
		contentPane.add(pa3int3);
		
		JComboBox pa3nac = new JComboBox();
		pa3nac.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa3nac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3nac.setBounds(554, 339, 119, 22);
		contentPane.add(pa3nac);
		
		JComboBox pa2nac = new JComboBox();
		pa2nac.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Local", "Empate", "Visita"}));
		pa2nac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2nac.setBounds(409, 339, 119, 22);
		contentPane.add(pa2nac);
		
		JLabel lblNewLabel_2_2 = new JLabel("INTERNACIONAL 2");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_2.setBounds(19, 272, 229, 23);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("INTERNACIONAL 3");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_3.setBounds(19, 304, 229, 23);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("NACIONAL");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_4.setBounds(19, 337, 229, 23);
		contentPane.add(lblNewLabel_2_4);
	}
}
