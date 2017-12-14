import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class temps extends JFrame implements ActionListener{


    private Container pane;
	private JButton  b, b2;
	private JTextField t;

    public temps(){

	this.setTitle("Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	b = new JButton("C to F");
	b2 = new JButton("F to C");
	t = new JTextField("Temperature");
	
	b.addActionListener(this);
	b2.addActionListener(this);
	t.addActionListener(this);
	
	pane.add(b);
	pane.add(b2);
	pane.add(t);


    }

    
    public static double CtoF(double t){
	    return (t * (9 / 5) + 32);
    }

    public static double FtoC(double t){
	    return ((t - 32) * (5/9));
    }

    

    public void actionPerformed(ActionEvent e){
	    String s = e.getActionCommand();
	    System.out.println(s);
		if(s.equals("C to F")){
			system.out.println(CtoF(Integer.parseInt(t.getText)));
		}else{
			system.out.println(FtoC(Integer.parseInt(t.getText)));
		}
	}
    
