package br.sc.senac.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Principal {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 613, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(209, 11, 243, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*TESTE DE BOTÃO */
				JOptionPane.showMessageDialog(null, "Este menu ainda não está pronto!");
			}
		});
		btnEntrar.setBounds(33, 194, 105, 31);
		frame.getContentPane().add(btnEntrar);
		
		textField = new JTextField();
		textField.setBounds(33, 79, 105, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Login: ");
		lblNewLabel_1.setBounds(33, 54, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Senha: ");
		lblNewLabel_2.setBounds(33, 112, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(33, 148, 105, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblImgSenac = new JLabel("");
		lblImgSenac.setBackground(new Color(255, 255, 255));
		Image img = new ImageIcon(this.getClass().getResource("/senac.png")).getImage();
		lblImgSenac.setIcon(new ImageIcon(img));
		lblImgSenac.setBounds(322, 198, 265, 172);
		frame.getContentPane().add(lblImgSenac);
	}
}
