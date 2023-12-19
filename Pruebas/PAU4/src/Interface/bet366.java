package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Apostador;
import Clases.Apuesta;
import Clases.Liga;
import Clases.Partido;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.io.*;

public class bet366 extends JFrame {

	private JPanel contentPane;
	private JTextField aliastxt;

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
		ArrayList<Apostador> cliente = new ArrayList<Apostador>();
		Liga[] ligas = new Liga[4];
		ligas[0] = new Liga("Premier League", "Internacional");
		ligas[1] = new Liga("Bundesliga", "Internacional");
		ligas[2] = new Liga("LaLiga", "Internacional");
		ligas[3] = new Liga("Primear Division de Chile", "Nacional");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1055, 862);
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
		
		aliastxt = new JTextField();
		aliastxt.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		aliastxt.setBounds(121, 53, 340, 29);
		contentPane.add(aliastxt);
		aliastxt.setColumns(10);
		
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
		
		JComboBox<String> pa1int1 = new JComboBox<String>();
		pa1int1.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa1int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int1.setBounds(258, 238, 119, 22);
		contentPane.add(pa1int1);
		
		JComboBox<String> pa1int2 = new JComboBox<String>();
		pa1int2.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa1int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int2.setBounds(258, 271, 119, 22);
		contentPane.add(pa1int2);
		
		JComboBox<String> pa1int3 = new JComboBox<String>();
		pa1int3.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa1int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int3.setBounds(258, 304, 119, 22);
		contentPane.add(pa1int3);
		
		JComboBox<String> pa1nac = new JComboBox<String>();
		pa1nac.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa1nac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1nac.setBounds(258, 337, 119, 22);
		contentPane.add(pa1nac);
		
		JComboBox<String> pa2int1 = new JComboBox<String>();
		pa2int1.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa2int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int1.setBounds(409, 238, 119, 22);
		contentPane.add(pa2int1);
		
		JComboBox<String> pa3int1 = new JComboBox<String>();
		pa3int1.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa3int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int1.setBounds(554, 238, 119, 22);
		contentPane.add(pa3int1);
		
		JComboBox<String> pa2int2 = new JComboBox<String>();
		pa2int2.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa2int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int2.setBounds(409, 271, 119, 22);
		contentPane.add(pa2int2);
		
		JComboBox<String> pa2int3 = new JComboBox<String>();
		pa2int3.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa2int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int3.setBounds(409, 304, 119, 22);
		contentPane.add(pa2int3);
		
		JComboBox<String> pa4int1 = new JComboBox<String>();
		pa4int1.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa4int1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int1.setBounds(702, 238, 119, 22);
		contentPane.add(pa4int1);
		
		JComboBox<String> pa4int2 = new JComboBox<String>();
		pa4int2.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa4int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int2.setBounds(702, 271, 119, 22);
		contentPane.add(pa4int2);
		
		JComboBox<String> pa4int3 = new JComboBox<String>();
		pa4int3.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa4int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int3.setBounds(702, 304, 119, 22);
		contentPane.add(pa4int3);
		
		JComboBox<String> pa4nac = new JComboBox<String>();
		pa4nac.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa4nac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4nac.setBounds(702, 337, 119, 22);
		contentPane.add(pa4nac);
		
		JComboBox<String> pa3int2 = new JComboBox<String>();
		pa3int2.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa3int2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int2.setBounds(554, 273, 119, 22);
		contentPane.add(pa3int2);
		
		JComboBox<String> pa3int3 = new JComboBox<String>();
		pa3int3.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa3int3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int3.setBounds(554, 306, 119, 22);
		contentPane.add(pa3int3);
		
		JComboBox<String> pa3nac = new JComboBox<String>();
		pa3nac.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
		pa3nac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3nac.setBounds(554, 339, 119, 22);
		contentPane.add(pa3nac);
		
		JComboBox<String> pa2nac = new JComboBox<String>();
		pa2nac.setModel(new DefaultComboBoxModel(new String[] {"Sin Apostar", "Local", "Empate", "Visita"}));
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
		
		JLabel lblPartidos = new JLabel("PARTIDOS");
		lblPartidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartidos.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPartidos.setBackground(Color.BLACK);
		lblPartidos.setBounds(36, 452, 941, 31);
		contentPane.add(lblPartidos);
		
		JLabel lblNewLabel_2_1 = new JLabel("INTERNACIONAL 1");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(19, 540, 229, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("INTERNACIONAL 2");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_2_1.setBounds(19, 574, 229, 23);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("INTERNACIONAL 3");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_3_1.setBounds(19, 606, 229, 23);
		contentPane.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("NACIONAL");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_4_1.setBounds(19, 639, 229, 23);
		contentPane.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("Partido 1");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(258, 505, 119, 19);
		contentPane.add(lblNewLabel_3_4);
		
		JComboBox<String> pa1int1F = new JComboBox<String>();
		pa1int1F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa1int1F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int1F.setBounds(258, 540, 119, 22);
		contentPane.add(pa1int1F);
		
		JComboBox<String> pa1int2F = new JComboBox<String>();
		pa1int2F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa1int2F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int2F.setBounds(258, 573, 119, 22);
		contentPane.add(pa1int2F);
		
		JComboBox<String> pa1int3F = new JComboBox<String>();
		pa1int3F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa1int3F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1int3F.setBounds(258, 606, 119, 22);
		contentPane.add(pa1int3F);
		
		JComboBox<String> pa1nacF = new JComboBox<String>();
		pa1nacF.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa1nacF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa1nacF.setBounds(258, 639, 119, 22);
		contentPane.add(pa1nacF);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Partido 2");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(409, 505, 119, 19);
		contentPane.add(lblNewLabel_3_1_1);
		
		JComboBox<String> pa2int1F = new JComboBox<String>();
		pa2int1F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa2int1F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int1F.setBounds(409, 540, 119, 22);
		contentPane.add(pa2int1F);
		
		JComboBox<String> pa2int2F = new JComboBox<String>();
		pa2int2F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa2int2F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int2F.setBounds(409, 573, 119, 22);
		contentPane.add(pa2int2F);
		
		JComboBox<String> pa2int3F = new JComboBox<String>();
		pa2int3F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa2int3F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2int3F.setBounds(409, 606, 119, 22);
		contentPane.add(pa2int3F);
		
		JComboBox<String> pa2nacF = new JComboBox<String>();
		pa2nacF.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa2nacF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa2nacF.setBounds(409, 641, 119, 22);
		contentPane.add(pa2nacF);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Partido 3");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2_1.setBounds(554, 503, 114, 19);
		contentPane.add(lblNewLabel_3_2_1);
		
		JComboBox<String> pa3int1F = new JComboBox<String>();
		pa3int1F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa3int1F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int1F.setBounds(554, 540, 119, 22);
		contentPane.add(pa3int1F);
		
		JComboBox<String> pa3int2F = new JComboBox<String>();
		pa3int2F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa3int2F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int2F.setBounds(554, 575, 119, 22);
		contentPane.add(pa3int2F);
		
		JComboBox<String> pa3int3F = new JComboBox<String>();
		pa3int3F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa3int3F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3int3F.setBounds(554, 608, 119, 22);
		contentPane.add(pa3int3F);
		
		JComboBox<String> pa3nacF = new JComboBox<String>();
		pa3nacF.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa3nacF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa3nacF.setBounds(554, 641, 119, 22);
		contentPane.add(pa3nacF);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Partido 4");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3_1.setBounds(702, 503, 119, 19);
		contentPane.add(lblNewLabel_3_3_1);
		
		JComboBox<String> pa4int1F = new JComboBox<String>();
		pa4int1F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa4int1F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int1F.setBounds(702, 540, 119, 22);
		contentPane.add(pa4int1F);
		
		JComboBox<String> pa4int2F = new JComboBox<String>();
		pa4int2F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa4int2F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int2F.setBounds(702, 573, 119, 22);
		contentPane.add(pa4int2F);
		
		JComboBox<String> pa4int3F = new JComboBox<String>();
		pa4int3F.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa4int3F.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4int3F.setBounds(702, 606, 119, 22);
		contentPane.add(pa4int3F);
		
		JComboBox<String> pa4nacF = new JComboBox<String>();
		pa4nacF.setModel(new DefaultComboBoxModel(new String[] {"Local", "Empate", "Visita"}));
		pa4nacF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pa4nacF.setBounds(702, 639, 119, 22);
		contentPane.add(pa4nacF);
		
		JButton btnNewButton = new JButton("Apostar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String alias = aliastxt.getText();
				Apuesta[] ap1 = new Apuesta[4];
				ap1[0] = new Apuesta(pa1int1.getSelectedItem().toString());
				ap1[1] = new Apuesta(pa2int1.getSelectedItem().toString());
				ap1[2] = new Apuesta(pa3int1.getSelectedItem().toString());
				ap1[3] = new Apuesta(pa4int1.getSelectedItem().toString());
				Apuesta[] ap2 = new Apuesta[4];
				ap2[0] = new Apuesta(pa1int2.getSelectedItem().toString());
				ap2[1] = new Apuesta(pa2int2.getSelectedItem().toString());
				ap2[2] = new Apuesta(pa3int2.getSelectedItem().toString());
				ap2[3] = new Apuesta(pa4int2.getSelectedItem().toString());
				Apuesta[] ap3 = new Apuesta[4];
				ap3[0] = new Apuesta(pa1int3.getSelectedItem().toString());
				ap3[1] = new Apuesta(pa2int3.getSelectedItem().toString());
				ap3[2] = new Apuesta(pa3int3.getSelectedItem().toString());
				ap3[3] = new Apuesta(pa4int3.getSelectedItem().toString());
				Apuesta[] ap4 = new Apuesta[4];
				ap4[0] = new Apuesta(pa1nac.getSelectedItem().toString());
				ap4[1] = new Apuesta(pa2nac.getSelectedItem().toString());
				ap4[2] = new Apuesta(pa3nac.getSelectedItem().toString());
				ap4[3] = new Apuesta(pa4nac.getSelectedItem().toString());
				Apostador apostador = new Apostador(alias, ap1, ap2, ap3, ap4);
				cliente.add(apostador);
				
				JOptionPane.showMessageDialog(null, "Apostador Agregado, \n valor a pagar "+ cliente.get(cliente.size()-1).ValorTotalApuesta());
				aliastxt.setText("");
				pa1int1.setSelectedIndex(0);
				pa2int1.setSelectedIndex(0);
				pa3int1.setSelectedIndex(0);
				pa4int1.setSelectedIndex(0);
				pa1int2.setSelectedIndex(0);
				pa2int2.setSelectedIndex(0);
				pa3int2.setSelectedIndex(0);
				pa4int2.setSelectedIndex(0);
				pa1int3.setSelectedIndex(0);
				pa2int3.setSelectedIndex(0);
				pa3int3.setSelectedIndex(0);
				pa4int3.setSelectedIndex(0);
				pa1nac.setSelectedIndex(0);
				pa2nac.setSelectedIndex(0);
				pa3nac.setSelectedIndex(0);
				pa4nac.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(451, 385, 101, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finalizar Apuestas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Partido[] intr1 = new Partido[4];
				intr1[0] = new Partido(pa1int1F.getSelectedItem().toString());
				intr1[1] = new Partido(pa2int1F.getSelectedItem().toString());
				intr1[2] = new Partido(pa3int1F.getSelectedItem().toString());
				intr1[3] = new Partido(pa4int1F.getSelectedItem().toString());
				ligas[0].addResultados(intr1[0], intr1[1], intr1[2], intr1[3]);
				Partido[] intr2 = new Partido[4];
				intr2[0] = new Partido(pa1int2F.getSelectedItem().toString());
				intr2[1] = new Partido(pa2int2F.getSelectedItem().toString());
				intr2[2] = new Partido(pa3int2F.getSelectedItem().toString());
				intr2[3] = new Partido(pa4int2F.getSelectedItem().toString());
				ligas[1].addResultados(intr2[0], intr2[1], intr2[2], intr2[3]);
				Partido[] intr3 = new Partido[4];
				intr3[0] = new Partido(pa1int3F.getSelectedItem().toString());
				intr3[1] = new Partido(pa2int3F.getSelectedItem().toString());
				intr3[2] = new Partido(pa3int3F.getSelectedItem().toString());
				intr3[3] = new Partido(pa4int3F.getSelectedItem().toString());
				ligas[2].addResultados(intr3[0], intr3[1], intr3[2], intr3[3]);
				Partido[] nacio = new Partido[4];
				nacio[0] = new Partido(pa1nacF.getSelectedItem().toString());
				nacio[1] = new Partido(pa2nacF.getSelectedItem().toString());
				nacio[2] = new Partido(pa3nacF.getSelectedItem().toString());
				nacio[3] = new Partido(pa4nacF.getSelectedItem().toString());
				ligas[3].addResultados(nacio[0], nacio[1], nacio[2], nacio[3]);
				
				
				PrintWriter pw = null;
				try(FileWriter fichero = new FileWriter("C:\\Unidad4\\InformeApuestas.txt", true)) {
				
				pw = new PrintWriter(fichero);
				
				for(int i = 0; i < ligas.length; i++) {
					int totApuestas = 0;
					int totmontos = 0;
					int totpagar = 0;
					String PagaApostador = "";
					pw.println("LIGA "+ligas[i].Tipo+" "+ligas[i].Nombre);
					for(int j = 0; j < 4; j++) {
						int npartido = j+1;
						int cantap = 0;
						int montap = 0;
						int montpaga = 0;
						for(int c = 0; c < cliente.size(); c++) {
							switch(i) {
							case 0:
								if(!cliente.get(c).Internacional[j].resultado.equals("Sin Apostar")) {
									cantap += 1;
									montap += cliente.get(c).Internacional[j].ValorApuestaInternacional();
									montpaga += cliente.get(c).Internacional[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
									totpagar += cliente.get(c).Internacional[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
									totmontos += cliente.get(c).Internacional[j].ValorApuestaInternacional();
									totApuestas += 1;
									
								}
								break;
							case 1:
									if(!cliente.get(c).Internacional2[j].resultado.equals("Sin Apostar")) {
										cantap += 1;
										montap += cliente.get(c).Internacional2[j].ValorApuestaInternacional();
										montpaga += cliente.get(c).Internacional2[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
										totpagar += cliente.get(c).Internacional[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
										totmontos += cliente.get(c).Internacional[j].ValorApuestaInternacional();
										totApuestas += 1;
									}	
								break;
							case 2:
									if(!cliente.get(c).Internacional3[j].resultado.equals("Sin Apostar")) {
										cantap += 1;
										montap += cliente.get(c).Internacional3[j].ValorApuestaInternacional();
										montpaga += cliente.get(c).Internacional3[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
										totpagar += cliente.get(c).Internacional[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
										totmontos += cliente.get(c).Internacional[j].ValorApuestaInternacional();
										totApuestas += 1;
									}
								break;
							case 3:
									if(!cliente.get(c).Nacional[j].resultado.equals("Sin Apostar")) {
										cantap += 1;
										montap += cliente.get(c).Nacional[j].ValorApuestaNacional();
										montpaga += cliente.get(c).Nacional[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
										totpagar += cliente.get(c).Internacional[j].GananciaXApuesta(ligas[i].partidos[j].resultado);
										totmontos += cliente.get(c).Internacional[j].ValorApuestaInternacional();
										totApuestas += 1;
									}
								break;
							}
						}
						pw.println("Resultado Partido "+npartido+" - "+ligas[i].partidos[j].resultado);
						pw.println("Cantidad Apuestas al Partido: "+cantap);
						pw.println("Monto Apostado al Partido: "+montap);
						pw.println("Monto pagara a apostadores: "+montpaga);
						pw.println("------------------------------------------------");
					}
					pw.println("Total Apuestas Liga: "+totApuestas);
					pw.println("Total Monto Apuestas Liga: "+totmontos);
					pw.println("Total a pagar a ganadores Liga: "+totpagar);
					pw.println("======================================================");
				}
				pw.println("==================APUESTAS=====================");
				for(int i = 0; i < cliente.size(); i++) {
					pw.println(cliente.get(i).Alias+";"+cliente.get(i).ValorTotalApuesta());
					pw.println("Internacional;"+cliente.get(i).Internacional[0].resultado+";"+cliente.get(i).Internacional[1].resultado+";"+cliente.get(i).Internacional[2].resultado+";"+cliente.get(i).Internacional[3].resultado);
					pw.println("Internacional2;"+cliente.get(i).Internacional2[0].resultado+";"+cliente.get(i).Internacional2[1].resultado+";"+cliente.get(i).Internacional2[2].resultado+";"+cliente.get(i).Internacional2[3].resultado);
					pw.println("Internacional3;"+cliente.get(i).Internacional3[0].resultado+";"+cliente.get(i).Internacional3[1].resultado+";"+cliente.get(i).Internacional3[2].resultado+";"+cliente.get(i).Internacional3[3].resultado);
					pw.println("Nacional;"+cliente.get(i).Nacional[0].resultado+";"+cliente.get(i).Nacional[1].resultado+";"+cliente.get(i).Nacional[2].resultado+";"+cliente.get(i).Nacional[3].resultado);
				}
				JOptionPane.showMessageDialog(null, "Archivo Generado");
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error al crear archivo ");
				}

				
			}
		});
		btnNewButton_1.setBounds(436, 707, 119, 31);
		contentPane.add(btnNewButton_1);
		
		
		
	}
}
