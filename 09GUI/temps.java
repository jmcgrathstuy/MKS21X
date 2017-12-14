import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class temps extends JFrame implements ActionListener{


    private Container pane;
	private JButton  b, b2;
	private JTextField t;

    public temps(){

	this.setTitle("Converter");
	this.setSize(350,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	b = new JButton("C to F");
	b2 = new JButton("F to C");
	t = new JTextField("                  ");
	
	b.addActionListener(this);
	b2.addActionListener(this);
	t.addActionListener(this);
	
	pane.add(b);
	pane.add(b2);
	pane.add(t);


    }

    
    public static double CtoF(double t){
		t = t * 9 / 5;
		t += 32;
		return t;
    }

    public static double FtoC(double t){
	    t -= 32;
		t = t * 5 / 9;
		return t;
    }

    

    public void actionPerformed(ActionEvent e){
	    String s = e.getActionCommand();
	    System.out.println(s);
		if(s.equals("C to F")){
			System.out.println(CtoF(Double.parseDouble(t.getText())));
		}else{
			System.out.println(FtoC(Double.parseDouble(t.getText())));
		}
	}
	
	public static void main( String[] args){
		temps g = new temps();
		g.setVisible(true);
	}
	
}
    
