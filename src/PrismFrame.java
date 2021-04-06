import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;

public class PrismFrame {
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class PrismFrame {
public class PrismFrame extends JFrame implements ActionListener  {
	//Inicjuje PANELE
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	
	//Inicjuje MENU
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	JMenuItem menuItem3;
	JMenuItem menuItem4;
	
	//Inicjuje SUWAK
	JSlider slider;
	static final int SLIDER_MIN = 3;
	static final int SLIDER_MAX = 33;
	static final int SLIDER_INIT = 3;
	
	//Inicjuje GUZIK
	JButton button1;
	JButton button2;
	JButton button3;
	
	//Inicjuje ETYKIETA
	JLabel label1;
	
	//Inicjuje RADIOBUTTON
	ButtonGroup BG;
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	
	//Inicjuje POLE_TEKSTOWE
	JTextField textField;
	
	//Inicjuje zmienne
	int lineWidth = 1;
	Color defaultColor = Color.black;
	Color backgroundColor = Color.white;
	Random rand = new Random();
	
	
	public PrismFrame() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
