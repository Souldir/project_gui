import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import MyPackage.SimpleSphere;

public class UserInterface {
	JFrame frame = new JFrame("CardLayout");
	JPanel panelCont = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel(new BorderLayout());
	JButton button1 = new JButton("1)");
	JButton button2 = new JButton("2)");
	JButton button3 = new JButton("Return");
	CardLayout ui = new CardLayout();

	public UserInterface() {
		panelCont.setLayout(ui);
		pan1.add(button1);
		pan2.add(button2);
		pan1.setBackground(Color.BLACK);
		pan2.setBackground(Color.BLACK);

		
		pan2.add(button3, BorderLayout.SOUTH);
		//button2.setSize(10,10);


		panelCont.add(pan1, "1");
		panelCont.add(pan2, "2");
		
		ui.show(panelCont, "1");

		//actions
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				ui.show(panelCont, "2");
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				SimpleSphere ball;
				ball = new SimpleSphere(19.1);
				System.out.println("THe Volume of a sphere of a radius" + ball.getRadius() + " inches is " +
				(float)ball.getVolume() + "cubuc inches\n");
				}
		});

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ui.show(panelCont,"1");
			}
		});

		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(250, 150);
		//frame.pack();
		frame.setVisible(true);
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new UserInterface();
			}
		});
	}

}
