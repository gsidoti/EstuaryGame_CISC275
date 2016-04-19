package OverallGame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//change
public class Window extends Canvas{

	private static final long serialVersionUID = -5596174652453925475L;

	public Window(int width, int height, String title, Controller game){
		JFrame frame = new JFrame(title);
		JPanel contentPane = new JPanel();
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setResizable(false);
		frame.setContentPane(contentPane);
		
		JLabel estuaryLabel = new JLabel("Estuary Game");
		estuaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		estuaryLabel.setFont(new Font("Dialog", Font.BOLD, 50));
		contentPane.add(estuaryLabel, BorderLayout.NORTH);
		
		JButton estuaryButton = new JButton("Start Game");
		estuaryButton.setActionCommand("disable");
		estuaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("disable" .equals(e.getActionCommand()))
					estuaryButton.setEnabled(false);
			}
		});
		contentPane.add(estuaryButton, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(contentPane);
		frame.setVisible(true);
		game.start();
	}
	
}