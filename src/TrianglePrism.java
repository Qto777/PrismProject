import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TrianglePrism {
	
	int lineWidth = 1;
	Color defaultColor = Color.black;
	
	public TrianglePrism() {
	}
	
	void paintComponent(Graphics g) {
    	
		Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(lineWidth);
        g2d.setStroke(stroke);
        
        int R = 100;
        int[] x = new int[3];
    	int[] y = new int[3];

    	//RYSUJE FOREMNY TROJKAT
    	for (int i = 0; i < 3; i++) {
    		x[i] = (int)(R * Math.cos((Math.PI / 2 + 2 * Math.PI * i) / 3));
    		y[i] = (int)(R * Math.sin((Math.PI / 2 + 2 * Math.PI * i) / 3));
    		
    	g2d.translate(400, 250);
		g2d.setColor(defaultColor);
		g2d.drawPolygon(x, y, 3);
    }
};

}
