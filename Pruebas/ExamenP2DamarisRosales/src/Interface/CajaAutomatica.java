package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Operaciones.Caja;
import Operaciones.Producto;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class CajaAutomatica extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnaddProd;
	private JTextField txtNomProd;
	private JButton btnComprar;
	Caja Operacion = new Caja();
	private JTable tblAlmacen;
	private DefaultTableModel modeloTabla;
	private JButton btnCleanCom;
	private JTable tblCompra;
	private JRadioButton rdlBoleta;
	private JRadioButton rdlFactura;
	private JTextField txtDoc;
	private JButton btnBuscar;
	private JButton btnReporte;
	private JButton btnAddCompra;
	private List<Producto> CompraProd;
	private JRadioButton rdlBoletaB;
	private JRadioButton rdlFacturaB;

	//Inicia Panel e ingresa inventaria del SUPERMERCADO
	public CajaAutomatica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 579);
		setResizable(false);
		iniciarComponentes();
		//Lee Archivo Productos.txt para guardarlos en el Alamcen
		Operacion.RellenaInventario();
		//Instancia listado de productos a comprar
		CompraProd = new ArrayList();
		//Instancia y alamcena los productos del Supermercado para manipulacion
		List<Producto> superMerc = Operacion.ListaProductos();
		if(superMerc == null || superMerc.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No se puede Abrir el Almacen, no existen Productos");
		}else {
			//Muestra Productos
			MuestraProductos(superMerc);
		}
	}
//Inicia los botones, textos, tablas, etc. del Panel
private void iniciarComponentes() {
		
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel_2 = new JPanel();
	panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_2.setBounds(10, 10, 634, 356);
	contentPane.add(panel_2);
	panel_2.setLayout(null);
	
	JLabel titleAlmacen = new JLabel("ALMACEN");
	titleAlmacen.setBounds(254, 3, 142, 35);
	panel_2.add(titleAlmacen);
	titleAlmacen.setFont(new Font("Tahoma", Font.BOLD, 29));
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 49, 610, 235);
	panel_2.add(scrollPane);
	
	tblAlmacen = new JTable();
	tblAlmacen.setModel(new DefaultTableModel(
			new Object[][] {
		    },
		    new String[] {
		        "CHK", "PRODUCTO", "VALORxU", "CANTIDAD"
		    }) {
		@SuppressWarnings("rawtypes")
        Class[] columnTypes = new Class[] {
            Boolean.class, Object.class, Object.class, Object.class
        };
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public Class getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
        boolean[] columnEditables = new boolean[] {
            true, false, false, true
        };
        public boolean isCellEditable(int row, int column) {
            return columnEditables[column];
        }
	});
	tblAlmacen.getColumnModel().getColumn(0).setPreferredWidth(36);
	tblAlmacen.getColumnModel().getColumn(1).setPreferredWidth(172);
	tblAlmacen.getColumnModel().getColumn(1).setMinWidth(14);
	tblAlmacen.getColumnModel().getColumn(2).setPreferredWidth(64);
	tblAlmacen.getColumnModel().getColumn(3).setPreferredWidth(63);
	scrollPane.setViewportView(tblAlmacen);
	
	btnAddCompra = new JButton("+ Agregar Compra");
	btnAddCompra.addActionListener(this);
	btnAddCompra.setBounds(254, 310, 163, 23);
	panel_2.add(btnAddCompra);
	
	JPanel panel_3 = new JPanel();
	panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_3.setBounds(650, 373, 433, 166);
	contentPane.add(panel_3);
	panel_3.setLayout(null);
	
	JLabel lblNroDoc = new JLabel("NRO DOC :");
	lblNroDoc.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblNroDoc.setBounds(43, 93, 93, 30);
	panel_3.add(lblNroDoc);
	
	txtDoc = new JTextField();
	txtDoc.setColumns(10);
	txtDoc.setBounds(146, 95, 80, 30);
	panel_3.add(txtDoc);
	
	btnBuscar = new JButton("Buscar");
	btnBuscar.addActionListener(this);
	btnBuscar.setBounds(236, 99, 129, 23);
	panel_3.add(btnBuscar);
	
	btnReporte = new JButton("Reporte Consolidado");
	btnReporte.addActionListener(this);
	btnReporte.setBounds(126, 132, 161, 23);
	panel_3.add(btnReporte);
	
	JLabel titleReport = new JLabel("REPORTE");
	titleReport.setBounds(126, 11, 150, 35);
	panel_3.add(titleReport);
	titleReport.setFont(new Font("Tahoma", Font.BOLD, 29));
	
	rdlBoletaB = new JRadioButton("Boleta");
	rdlBoletaB.setSelected(true);
	rdlBoletaB.addActionListener(this);
	rdlBoletaB.setBounds(109, 61, 109, 23);
	panel_3.add(rdlBoletaB);
	
	rdlFacturaB = new JRadioButton("Factura");
	rdlFacturaB.setSelected(false);
	rdlFacturaB.addActionListener(this);
	rdlFacturaB.setBounds(221, 61, 109, 23);
	panel_3.add(rdlFacturaB);
	
	JPanel panel = new JPanel();
	panel.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel.setBounds(10, 373, 634, 166);
	contentPane.add(panel);
	panel.setLayout(null);
	
	JLabel lbladdProdNom = new JLabel("NOMBRE :");
	lbladdProdNom.setBounds(87, 74, 93, 30);
	panel.add(lbladdProdNom);
	lbladdProdNom.setFont(new Font("Tahoma", Font.BOLD, 15));
	
	txtNomProd = new JTextField();
	txtNomProd.setBounds(190, 76, 336, 30);
	panel.add(txtNomProd);
	txtNomProd.setColumns(10);
	
	btnaddProd = new JButton("+ Agregar Producto");
	btnaddProd.setBounds(247, 119, 129, 23);
	panel.add(btnaddProd);
	
	JLabel titleAddProd = new JLabel("NUEVO PRODUCTO");
	titleAddProd.setBounds(190, 11, 297, 35);
	panel.add(titleAddProd);
	titleAddProd.setFont(new Font("Tahoma", Font.BOLD, 29));
	
	JPanel panel_1 = new JPanel();
	panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	panel_1.setBounds(651, 10, 432, 356);
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	
	JLabel titleCompra = new JLabel("COMPRA");
	titleCompra.setBounds(144, 11, 127, 35);
	panel_1.add(titleCompra);
	titleCompra.setFont(new Font("Tahoma", Font.BOLD, 29));
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(10, 52, 413, 233);
	panel_1.add(scrollPane_1);
	
	tblCompra = new JTable();
	tblCompra.setModel(new DefaultTableModel(
			new Object[][] {
		    },
		    new String[] {
		        "PRODUCTO", "CANTIDAD", "TOTAL"
		    }) {
		@SuppressWarnings("rawtypes")
        Class[] columnTypes = new Class[] {
            Object.class, Object.class, Object.class
        };
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public Class getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
        boolean[] columnEditables = new boolean[] {
            false, false, false
        };
        public boolean isCellEditable(int row, int column) {
            return columnEditables[column];
        }
	});
	scrollPane_1.setViewportView(tblCompra);
	
	rdlBoleta = new JRadioButton("Boleta");
	rdlBoleta.addActionListener(this);
	rdlBoleta.setBounds(129, 292, 109, 23);
	panel_1.add(rdlBoleta);
	rdlBoleta.setSelected(true);
	
	rdlFactura = new JRadioButton("Factura");
	rdlFactura.addActionListener(this);
	rdlFactura.setBounds(241, 292, 109, 23);
	panel_1.add(rdlFactura);
	rdlFactura.setSelected(false);
	
	btnComprar = new JButton("Pagar");
	btnComprar.setBounds(75, 322, 129, 23);
	panel_1.add(btnComprar);
	
	btnCleanCom = new JButton("Cancelar");
	btnCleanCom.setBounds(228, 322, 129, 23);
	panel_1.add(btnCleanCom);
	btnCleanCom.addActionListener(this);
	btnComprar.addActionListener(this);
	btnaddProd.addActionListener(this);
	
		
	}


	//Negocio interacciones con Panel
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnaddProd) {//Agrega producto al SuperMercado
			if(!txtNomProd.getText().isEmpty()) {
				AgregarProducto(txtNomProd.getText());
			}else {
				JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del producto que desea Agregar al Almacen");
			}

		}else if(e.getSource()==btnComprar) {//Agrega Compra
			
			Producto prod = null;
			List<Producto> Canasta = new ArrayList();
			int tipoDoc = 0;
			
			//Lee tabla de compra para ingresarlos a la compra
			modeloTabla = (DefaultTableModel) tblCompra.getModel();
			for(int i = 0; i < modeloTabla.getRowCount(); i++) {
				int PrecioUni = 0;
				PrecioUni = Integer.parseInt(modeloTabla.getValueAt(i, 2).toString())/Integer.parseInt(modeloTabla.getValueAt(i, 1).toString());
				prod = new Producto(modeloTabla.getValueAt(i, 0).toString(), PrecioUni,Integer.parseInt(modeloTabla.getValueAt(i, 1).toString()));
				Canasta.add(prod);
			}
			
			//Valida Tipo de documento que se generara
			if(rdlBoleta.isSelected()) {
				tipoDoc = 39;
			}else {
				tipoDoc = 33;
			}
			
			if(tipoDoc != 0) {
				//Ingresa Compra
				if(Operacion.AddCompra(Canasta, tipoDoc)) {
					JOptionPane.showMessageDialog(null, Operacion.VerUltimaCompra());
					LimpiaListaProd(0);
					MuestraProductos(Operacion.ListaProductos());
				}else {
					JOptionPane.showMessageDialog(null, "No se logro ingresar la compra, intente de nuevo");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de documento de la Compra");
			}
		}else if(e.getSource()==btnCleanCom) {//Limpia Tabla Compra
			
			LimpiaListaProd(3);
			
		}else if(e.getSource()==btnAddCompra) {//Agrega los productos seleccionados la carrito de compra
			//Agrega Productos seleccionados a una Compra antes de pagar
			for(int i = 0; i < tblAlmacen.getModel().getRowCount(); i++) {
				if((Boolean)tblAlmacen.getModel().getValueAt(i, 0) && Integer.parseInt(tblAlmacen.getModel().getValueAt(i, 3).toString()) > 0) {
					Producto prod = new Producto(tblAlmacen.getModel().getValueAt(i, 1).toString(),Integer.parseInt(tblAlmacen.getModel().getValueAt(i,2).toString()),Integer.parseInt(tblAlmacen.getModel().getValueAt(i,3).toString()));
					CompraProd.add(prod);
				}
			}
			//Lista los productos seleccionados a compra en la tabla compra antes de pagar
			modeloTabla = (DefaultTableModel) tblCompra.getModel();
			for(Producto produ : CompraProd) {
				Object[] fila = new Object[4];
				int SubTotal = 0;
				SubTotal =  produ.GetCantidad() * produ.GetValor();
				fila[0]=produ.GetNombre();
				fila[2]=SubTotal;
				fila[1]=produ.GetCantidad();
				modeloTabla.addRow(fila);
			}
			
			LimpiaListaProd(1);
			MuestraProductos(Operacion.ListaProductos());
			
		}else if(e.getSource()==btnBuscar) {//Busca Compra por Nro Documento
			//Buscar una compra por numero de documento
			int tpDoc = 0;
			if(rdlBoletaB.isSelected()) {
				tpDoc = 39;
			}else {
				tpDoc = 33;
			}
			JOptionPane.showMessageDialog(null, Operacion.VerCompraXDoc(Integer.parseInt(txtDoc.getText()),tpDoc));
			LimpiaListaProd(4);
		}else if(e.getSource()==btnReporte) {//Genera Reporte Consoilidado y lo archiva
			JOptionPane.showMessageDialog(null, Operacion.ReporteConsolidado());
		}else if(e.getSource()==rdlBoleta) {//Setea radios buton de seleccion de tipo de documento al comprar
			//Valida Select de RadioButton Boleta
			if(rdlBoleta.isSelected()) {
				rdlFactura.setSelected(false);
			}else {
				rdlFactura.setSelected(true);
			}
		}else if(e.getSource()==rdlFactura) {//Setea radios buton de seleccion de tipo de documento al comprar
			//Valida Select de RadioButton Factura
			if(rdlFactura.isSelected()) {
				rdlBoleta.setSelected(false);
			}else {
				rdlBoleta.setSelected(true);
			}
		}else if(e.getSource()==rdlBoletaB) {//Setea radios buton de seleccion de tipo de documento al Buscar
			//Valida Select de RadioButton Boleta
			if(rdlBoletaB.isSelected()) {
				rdlFacturaB.setSelected(false);
			}else {
				rdlFacturaB.setSelected(true);
			}
		}else if(e.getSource()==rdlFacturaB) {//Setea radios buton de seleccion de tipo de documento al Buscar
			//Valida Select de RadioButton Factura
			if(rdlFacturaB.isSelected()) {
				rdlBoletaB.setSelected(false);
			}else {
				rdlBoletaB.setSelected(true);
			}
		}
		
	}
	
	//Agrega nuevo producto al almacen
	private void AgregarProducto(String nombre) {

		//Valida si ingresa producto o no
		if(Operacion.AddProducto(nombre)) {
			JOptionPane.showMessageDialog(null, "Producto Agregado en el almacen");
			LimpiaListaProd(1);
			LimpiaListaProd(2);
			MuestraProductos(Operacion.ListaProductos());
		}else {
			//Valida el tipo de error
			if(Operacion.almacen.size()>12) {
				JOptionPane.showMessageDialog(null, "No se pudo Agregar el Prroducto, Almacen lleno");
			}else {
				JOptionPane.showMessageDialog(null, "No se pudo Agregar el Prroducto, Ya existe en listado");
			}
			LimpiaListaProd(2);
		}
		
	}
	
	//Lista los Productos del alamacen para comprar
	private void MuestraProductos(List<Producto> alm) {
		modeloTabla = (DefaultTableModel) tblAlmacen.getModel();
		for(Producto prod : alm) {
			Object[] fila = new Object[4];
			
			fila[0]=false;
			fila[1]=prod.GetNombre();
			fila[2]=prod.GetValor();
			fila[3]=prod.GetCantidad();
			modeloTabla.addRow(fila);
		}
		
		
	}
	
	//Limpia Componenetes que interactuan en todo el Panel
	private void LimpiaListaProd(int seccion) {
		//int seccion = {0: Todo el Panel, 1: ALMACEN, 2: NUEVO PRODUCTO, 3: COMPRA, 4: REPORTE}
		
		switch(seccion){
		case 0://TODO EL PANEL
				modeloTabla = (DefaultTableModel) tblAlmacen.getModel();
				while(modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}
				modeloTabla = (DefaultTableModel) tblCompra.getModel();
				while(modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}
				CompraProd = new ArrayList();
				rdlBoleta.setSelected(true);
				rdlFactura.setSelected(false);
				txtNomProd.setText("");
				txtDoc.setText("");
			break;
		case 1://ALMACEN
				modeloTabla = (DefaultTableModel) tblAlmacen.getModel();
				while(modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}
			break;
		case 2://NUEVO PRODUCTO
			txtNomProd.setText("");
			break;
		case 3://COMPRA
				modeloTabla = (DefaultTableModel) tblCompra.getModel();
				while(modeloTabla.getRowCount() > 0) {
					modeloTabla.removeRow(0);
				}
				CompraProd = new ArrayList();
				rdlBoleta.setSelected(true);
				rdlFactura.setSelected(false);
			break;
		case 4://REPORTE
				txtDoc.setText("");
			default://NADA
				
		}
	}
}
