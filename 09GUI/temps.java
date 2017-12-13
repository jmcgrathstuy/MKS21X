import javax.swing.*;
import java.awt.*;
public class temps extends JFrame implements ActionListener{


    public temps(){

	this.setTitle("Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	
	private Container pane;
	private JButton  b, b2;
	private JTextField t;


    }

    
    public static double CtoF(double t){
	return (t * (9 / 5) + 32);
    }

    public static double FtoC(double t){
	return ((t - 32) * (5/9));
    }

    

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	S
    
