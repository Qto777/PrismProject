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
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	JTextField textField4;
	JTextField textField5;
	
	//Zmienne
	int lineWidth = 2;
	Color defaultColor = Color.gray;
	Color backgroundColor;
	Polygon trojkat;
	
	public PrismFrame() {
		super("Prism Simulator");
		this.setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		rysuj();
		//Tworze PANELE---------------------------
		
		
		panelSrodek.setPreferredSize(new Dimension(400, 200));
		
		panelPrawy = new JPanel();
		panelPrawy.setLayout(new GridLayout(15,1));
		
		panelLewy = new JPanel();
		panelLewy.setLayout(new GridLayout(3,1));	
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
