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
	private JLabel lblCadastroVacina;
	public MenuCadastroVacina menuCadastroVacina;

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
		
		JLabel lblCadastroPessoa = new JLabel("Cadastro de Pessoa:");
		lblCadastroPessoa.setBounds(34, 100, 105, 14);
		frame.getContentPane().add(lblCadastroPessoa);
		
		lblCadastroVacina = new JLabel("Cadastro de Vacina: ");
		lblCadastroVacina.setBounds(34, 158, 105, 14);
		frame.getContentPane().add(lblCadastroVacina);
		
		JLabel lblImgSenac = new JLabel("");
		lblImgSenac.setBackground(new Color(255, 255, 255));
		Image img = new ImageIcon(this.getClass().getResource("/senac.png")).getImage();
		lblImgSenac.setIcon(new ImageIcon(img));
		lblImgSenac.setBounds(322, 198, 265, 172);
		frame.getContentPane().add(lblImgSenac);
		
		JButton btnCadastroDePessoa = new JButton("Cadastro de Pessoa");
		btnCadastroDePessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}

		});
		btnCadastroDePessoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastroDePessoa.setBounds(34, 116, 143, 31);
		frame.getContentPane().add(btnCadastroDePessoa);
		
		JButton btnCadastroDeVacina = new JButton("Cadastro de Vacina");
		btnCadastroDeVacina.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastroDeVacina.setBounds(34, 174, 143, 31);
		frame.getContentPane().add(btnCadastroDeVacina);
	}


}
