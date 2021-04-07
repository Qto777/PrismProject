import java.awt.*;
import javax.swing.*;
import java.awt.Graphics2D;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrismFrame extends JFrame implements ActionListener  {
	//Inicjuje PANELE
	JPanel panelSrodek;
	JPanel panelPrawy;
	JPanel panelLewy;
	
	//Inicjuje MENU
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	JMenuItem menuItem3;
	JMenuItem menuItem4;
	
	//Inicjuje GUZIK
	JButton rysujWiazke;
	JButton zapiszDoPliku;
	JButton zakoncz;
	
	//Inicjuje ETYKIETA
	JLabel typeLabel;
	JLabel on_offLabel;
	JLabel n1;
	JLabel n2;
	JLabel alfa1;
	JLabel beta;
	JLabel alfa2;
	
	//Inicjuje RADIOBUTTON
	ButtonGroup BG;
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	
	//Inicjuje POLE_TEKSTOWE
	
	
	public PrismFrame() {
		// TODO Auto-generated constructor stub
		super("Prism Simulator");
		this.setSize(800,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Graphics2D g2d = (Graphics2D) g;
		
		//Tworze PANELE---------------------------
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel5.setLayout(new FlowLayout());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
