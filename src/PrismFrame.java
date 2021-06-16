import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Polygon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrismFrame extends JFrame implements ActionListener  {
	//Inicjuje PANELE
	JPanel panelSrodek;
	JPanel panelPrawy;
	JPanel panelLewy;
	
	BufferedImage prism;
	
	//Inicjuje MENU
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem1;
	JMenuItem menuItem2;
	JMenuItem menuItem3;
	JMenuItem menuItem4;
	
	//Inicjuje SLIDER
	JSlider kolorSlider;
	static final int SLIDER_MIN = 400;
	static final int SLIDER_MAX = 750;
	static final int SLIDER_INIT = 550;
	
	//Inicjuje GUZIK
	JButton rysujWiazke;
	JButton zapiszDoPliku;
	JButton zakoncz;
	
	//Inicjuje ETYKIETA
	JLabel waveLabel;
	JLabel typeLabel;
	JLabel on_offLabel;
	JLabel n1Label;
	JLabel n2Label;
	JLabel alfa1Label;
	JLabel betaLabel;
	JLabel alfa2Label;
	
	//Inicjuje RADIOBUTTON
	ButtonGroup BG;
	JRadioButton radioButton1;
	JRadioButton radioButton2;
	
	//Inicjuje COMBOBOX
	JComboBox<String> nZewnatrz;
	JComboBox<String> nPryzmat;
	
	
	//Inicjuje POLE_TEKSTOWE
	JTextField textField3;
	JTextField textField4;
	JTextField textField5;
	
	//Zmienne
	int lineWidth = 2;
	Color defaultColor = Color.gray;
	Color backgroundColor;
	Color kolorFali = Color.green;
	Polygon trojkat;
	double n1 = 1; 
	double n2 = 1.31; //wspolczynniki
	double lambda = 550, v, nA, nB;
	double alfa1 = 45; //kat padania
	double beta1, alfa2, beta1Deg, alfa2Deg;
	double sinAlfa1, sinBeta1, sinBeta2, cosBeta, beta2;
	//Metody--------------------------------------
	
	public double ProstaPodKatem(double pktX, double pktY, double angle, double newX) {
		double m = Math.tan(Math.atan(pktY/pktX)-angle);
		double newY = pktY-m*(pktX-newX);
		return newY;
	}
	
	public double XPrzeciecia2Prostych(double a1, double b1, double a2, double b2) {
		double newX;
		newX = (b2-b1)/(a1-a2);
		return newX;
	}
	
	public double YPrzeciecia2Prostych(double a1, double b1, double a2, double b2) {
		double newY, newX;
		newX = (b2-b1)/(a1-a2);
		newY = a1*newX+b1;
		return newY;
	}
	
	public PrismFrame() {
		super("Prism Simulator");
		this.setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		rysuj();
		//Tworze PANELE---------------------------
		panelSrodek = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) { 
		    	super.paintComponent(g);
		    	
				Graphics2D g2d = (Graphics2D) g;
				BasicStroke stroke = new BasicStroke(lineWidth);
                g2d.setStroke(stroke);
		    	g2d.translate(this.getSize().width / 2, this.getSize().height / 2);
		    	

				//silnik matematyczno-geometryczny------------------------
				double y1; //prosta wiązki wpadajacej
				y1 = -Math.tan(alfa1-Math.PI/6)*(-170) - 5710/127; //dopasowująca się 2-ga współrzędna pktu początkowego wiązki padającej
				
				
				sinAlfa1 = Math.sin(alfa1); //sinus kąta padania promienia padającego na pryzmat
				sinBeta1 = sinAlfa1*nA*lambda; //Prawo Snelliusa, aby mieć kąt ugięcia beta
				cosBeta = Math.sqrt(1-sinBeta1*sinBeta1);
				beta1 = Math.asin(sinAlfa1*nA*lambda); //kąt załamania promienia padającego na pryzmat
				beta1Deg = beta1 * 57.3;
				beta2 = Math.PI/3 - beta1; //kąt padania promienia wychodzącego z pryzmatu
				sinBeta2 = Math.sin(beta2); 
				alfa2 = Math.asin(sinBeta2*nB*lambda); //kąt załamania promienia wychodzącego z pryzmatu
				alfa2Deg = alfa2 * 57.3;
				
				double x2, y2, aUgiete; //wiązka ugięta
				y2 = ProstaPodKatem(-43, -26, beta1, 40);
				aUgiete = Math.tan(Math.atan(26/43)-beta1);
				x2 = XPrzeciecia2Prostych( aUgiete, -26, 149/86, -100);
				
				double yN, y1N; //Normalna prawa
				yN = -(Math.sqrt(3)/3)*170 + y2 + x2*(86/149);
				y1N = (Math.sqrt(3)/3)*60 + y2 + x2*(86/149);
				
				double y3; //wiązka wychodząca
                double a3 = Math.tan(alfa2-Math.PI/6);
                double b3 = y2 - a3*x2;
                y3 = a3*170 + b3;
				
				
				//GRAFIKA - RYSOWANIE
				g2d.setColor(defaultColor);
				g2d.drawPolygon(trojkat);
				g2d.drawLine(-170, -99, 86, 49); //normalna lewa
				g2d.drawLine((int)x2 - 5, (int)y2, 170, (int)yN); //normalna prawa
				g2d.setColor(kolorFali);
				
				g2d.drawLine(-170, (int)y1, -43, -26);
				g2d.drawLine(-43, -26, (int)x2 - 5, (int)y2);
				g2d.drawLine((int)x2 - 5, (int)y2, 170, (int)y3);
		    }
		};
		
		
		panelSrodek.setPreferredSize(new Dimension(400, 200));
		
		panelPrawy = new JPanel();
		panelPrawy.setLayout(new GridLayout(16,1));
		
		panelLewy = new JPanel();
		panelLewy.setLayout(new GridLayout(3,1));	
		
		
		//MENU-------------------------------------
        menuBar = new JMenuBar();
        menu = new JMenu("Wybierz wiązkę");
        menuItem1 = new JMenuItem("Wiązka mono czerwona");
        menuItem1.setActionCommand("czerwona");
        menuItem1.addActionListener(this);
        
        menuItem2 = new JMenuItem("Wiązka mono zielona");
        menuItem2.setActionCommand("zielona");
        menuItem2.addActionListener(this);
        
        menuItem3 = new JMenuItem("Wiązka mono fioletowa");
        menuItem3.setActionCommand("fiolet");
        menuItem3.addActionListener(this);
        
        menuItem4 = new JMenuItem("Wiązka swiatła białego");
        menuItem4.setActionCommand("biala");
        menuItem4.addActionListener(this);
		
		menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menuBar.add(menu);
        
        waveLabel = new JLabel("Długość fali: ");
        
        typeLabel = new JLabel("Rodzaj światła:");
        paintComponents(getGraphics());
        panelPrawy.add(typeLabel);
        panelPrawy.add(menuBar);
        panelPrawy.add(waveLabel);
        
      /*//SLIDER--------------------------------------------
        kolorSlider = new JSlider();
        kolorSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        kolorSlider.setPreferredSize(new Dimension(300,50));//rozmiar suwaka
        kolorSlider.setMajorTickSpacing(50); //gestosc przedzialow glownych
        kolorSlider.setMinorTickSpacing(10); //gestosc podzialek
        kolorSlider.setPaintTicks(true);//podzialki na pasku
        kolorSlider.setPaintLabels(true); //przedzialy glowne, przedzialowe paska
        kolorSlider.addChangeListener(new SliderChangeListener());
        
        */
        
        
      //BUTTONS-------------------------------------------
        rysujWiazke = new JButton("ON/OFF");
        zapiszDoPliku = new JButton("Zapisz do pliku");
        zakoncz = new JButton("Zakończ");
        
        rysujWiazke.setSize(new Dimension(60, 30));
        rysujWiazke.setActionCommand("wiazka");
        rysujWiazke.addActionListener(this);
        
        zapiszDoPliku.setSize(new Dimension(60, 30));
        zapiszDoPliku.setActionCommand("zapisz");
        zapiszDoPliku.addActionListener(this);

        zakoncz.setSize(new Dimension(60, 30));
        zakoncz.setActionCommand("zakoncz");
        zakoncz.addActionListener(this);
        
        panelLewy.add(rysujWiazke);
        panelLewy.add(zapiszDoPliku);
        panelLewy.add(zakoncz);
        
        //RADIOBUTTONS-------------------------------------
        radioButton1 = new JRadioButton("Zapalone swiatlo");
        radioButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
    			panelSrodek.setBackground(Color.white);
    			rysuj();
			}
		});
		radioButton1.setSelected(true);
		
		radioButton2 = new JRadioButton("Zgaszone swiatlo");
		radioButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
    			panelSrodek.setBackground(Color.black);
    			rysuj();
			}
		});
		BG = new ButtonGroup();
		BG.add(radioButton1);
		BG.add(radioButton2);
		
		on_offLabel = new JLabel("Wlacz/Wylacz swiatlo:");
		panelPrawy.add(on_offLabel);
		
		panelPrawy.add(radioButton1);
		panelPrawy.add(radioButton2);
		
		//LABELS--------------------------------------------
		//TEXTFIELDS----------------------------------------
		textField1 = new JTextField("1,01");
		textField2 = new JTextField("1,53");
		textField3 = new JTextField("45");
		textField4 = new JTextField("27,5");
		textField5 = new JTextField("42,1");
		
		//DODAJE KOMPONENTY
		panelPrawy.add(n1);
		panelPrawy.add(textField1);
		panelPrawy.add(n2);
		panelPrawy.add(textField2);
		panelPrawy.add(alfa1);
		panelPrawy.add(textField3);
		panelPrawy.add(beta);
		panelPrawy.add(textField4);
		panelPrawy.add(alfa2);
		panelPrawy.add(textField5);
		panelSrodek.paintComponents(getGraphics());
		
		//DODAJE PANELE--------------------------------------
		this.add(panelSrodek, BorderLayout.CENTER);
		this.add(panelPrawy, BorderLayout.LINE_END);
		this.add(panelLewy, BorderLayout.LINE_START);

	}

	protected void rysuj() {
		int R = 100;
        int[] x = new int[3];
    	int[] y = new int[3];
    	

    	for (int i = 0; i < 3; i++) {
    		x[i] = (int)(R * Math.cos((Math.PI / 2 + 2 * Math.PI * i) / 3));
    		y[i] = (int)(R * Math.sin((Math.PI / 2 + 2 * Math.PI * i) / 3));
    		//System.out.println("Wierzchołek" + (i+1) + ": (" + x[i] + ";" + y[i] + ")\n");
    	}
    	
    	
    	trojkat = new Polygon(x, y, 3);
    	this.getContentPane().repaint();
		
	}

	public static void main(String[] args) {
		PrismFrame frame = new PrismFrame();
		frame.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}