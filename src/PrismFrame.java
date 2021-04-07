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
		panelSrodek = new JPanel() {
			
			@Override
			protected void paintComponent(Graphics g) { 
		    	super.paintComponent(g);
		    	
				Graphics2D g2d = (Graphics2D) g;
				BasicStroke stroke = new BasicStroke(lineWidth);
                g2d.setStroke(stroke);
		    	g2d.translate(this.getSize().width / 2, this.getSize().height / 2);
				g2d.setColor(defaultColor);
				g2d.drawPolygon(trojkat);
		    }
		};
		
		
		panelSrodek.setPreferredSize(new Dimension(400, 200));
		
		panelPrawy = new JPanel();
		panelPrawy.setLayout(new GridLayout(15,1));
		
		panelLewy = new JPanel();
		panelLewy.setLayout(new GridLayout(3,1));	
		
		
		//MENU-------------------------------------
        menuBar = new JMenuBar();
        menu = new JMenu("Wybierz wiazke");
        menuItem1 = new JMenuItem("Wiazka mono czerwona");
        menuItem2 = new JMenuItem("Wiazka mono zielona");
        menuItem3 = new JMenuItem("Wiazka mono fioletowa");
        menuItem4 = new JMenuItem("Wiazka swiatla bialego");
		
		menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);
        menuBar.add(menu);
        
        typeLabel = new JLabel("Rodzaj swiatla:");
        paintComponents(getGraphics());
        panelPrawy.add(typeLabel);
        panelPrawy.add(menuBar);
        
      //BUTTONS-------------------------------------------
        rysujWiazke = new JButton("ON/OFF");
        zapiszDoPliku = new JButton("Zapisz do pliku");
        zakoncz = new JButton("Zakoncz");
        
        rysujWiazke.setSize(new Dimension(60, 30));
        rysujWiazke.addActionListener(new ActionListener() {
        	
          	 @Override
               public void actionPerformed(ActionEvent e){
          		//rysowanie wiazki swiatla
               }
   		});
        
        zapiszDoPliku.setSize(new Dimension(60, 30));

        zakoncz.setSize(new Dimension(60, 30));
        zakoncz.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e){
            	System.exit(0);
            }
		});
        
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
		n1 = new JLabel("Wspolczynnik zalamania 1");
		n2 = new JLabel("Wspolczynnik zalamania 2");
		alfa1 = new JLabel("Kat padania alfa_1");
		beta = new JLabel("Kat padania beta");
		alfa2 = new JLabel("Kat padania alfa_2");

		//TEXTFIELDS----------------------------------------
		textField1 = new JTextField("1,01");
		textField2 = new JTextField("1,53");
		textField3 = new JTextField("45");
		textField4 = new JTextField("27,5");
		textField5 = new JTextField("42,1");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
