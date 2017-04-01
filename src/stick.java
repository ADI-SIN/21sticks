import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class stick extends JFrame{
	private int left=21;
	private String n1;
	private String n2;
	private JButton p1;
	private JButton p2;
	private JButton toss;
	private int ch;
	private int z;
	
	
	stick(){
		super("       21 STICKS     ");
		setLayout(new FlowLayout());
		
		
		
		JButton msg= new JButton(new AbstractAction("  HOW TO PLAY  "){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(getParent(), "This is a simple game that works on core java.\nTwo players will play at a time. There are 21 sticks, each player has to pick the stick one by one\nthe one who picks the stick last will lose, remember you can only pick either 1 or 2 sticks at a time  \ndeveloper: ADITYA SINGH");
			}
      }
						 
						 );
      add(msg);
	
	
	JTextField txt=new JTextField("\t\t\t\t\t\t          NUMBER OF STICKS LEFT  :  21",120);
	txt.setBackground(Color.YELLOW);
	add(txt);
   
	   p1= new JButton(new AbstractAction(" PLAYER 1 "){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				n1=JOptionPane.showInputDialog(getParent(),"ENTER THE PLAYER'S NAME (not more than 8 letters long) : ");
				p1.setLabel(n1);
				p1.setBackground(Color.ORANGE);
			}
    }
						 
						 );
    add(p1);
    

	   p2= new JButton(new AbstractAction(" PLAYER 2 "){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				n2=JOptionPane.showInputDialog(getParent(),"ENTER THE PLAYER'S NAME (not more than 8 letters long): ");
				p2.setLabel(n2);
				p2.setBackground(Color.ORANGE);
			}
 }
						 
						 );
 add(p2);
 
 Random rand=new Random();
 z=rand.nextInt(2);
  
  toss= new JButton(new AbstractAction("   TOSS  "){
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(z==0)
			JOptionPane.showMessageDialog(getParent()," "+n1+" will pick the stick first ");
			else
			JOptionPane.showMessageDialog(getParent()," "+n2+" will pick the stick first ");
			
			toss.setBackground(Color.gray);
		}
         
 }
					 
					 );
add(toss);
 
JButton pick= new JButton(new AbstractAction("  PICK  "){
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for(int i=0;i<21;i++)
		{
		String choice=JOptionPane.showInputDialog(getParent(),"ENTER THE NO. OF STICKS YOU WANT TO PICK : ");
		ch=Integer.parseInt(choice);
		if(ch<1 || ch>2){
			JOptionPane.showMessageDialog(getParent(),"INCORRECT CHOICE!!\nYOU CAN PICK EITHER 1 OR 2 STICKS ,PICK AGAIN");
			break;
		} 
		left=left-ch;
		
		txt.setText(" \t\t\t\t\t\t          NUMBER OF STICKS LEFT  :  "+left);
		if(z==0)
		{
		JOptionPane.showMessageDialog(getParent()," "+n2+"'s turn ");
		++z;
		if(left<=0){
			JOptionPane.showMessageDialog(getParent(),"THE GAME ENDS \n"+n2+" WON !!");
			break;
		}
		
	    }
		else if(z==1)
		{
			JOptionPane.showMessageDialog(getParent()," "+n1+"'s turn ");
			--z;
			if(left<=0){
				JOptionPane.showMessageDialog(getParent(),"THE GAME ENDS \n"+n1+" WON !!");
				break;
			}
		}
		
		
		}
	}
}
				 
				 );
add(pick);

    
    
}
}