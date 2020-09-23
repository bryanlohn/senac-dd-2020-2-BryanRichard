package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MenuCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataNascimento;
	private JTextField txtInstituicao;
	private JCheckBox checkPesquisador;
	private JLabel lblInstituicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCadastroPessoa frame = new MenuCadastroPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuCadastroPessoa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInstituicao = new JLabel("Institui\u00E7\u00E3o: ");
		lblInstituicao.setEnabled(false);
		lblInstituicao.setBounds(23, 314, 104, 14);
		contentPane.add(lblInstituicao);
		
		JLabel lblTituloCadastroPesquisador = DefaultComponentFactory.getInstance().createTitle("Cadastro de Pessoa");
		lblTituloCadastroPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloCadastroPesquisador.setBounds(125, 11, 183, 25);
		contentPane.add(lblTituloCadastroPesquisador);
		
		JLabel lblNomePesquisador = new JLabel("Nome: ");
		lblNomePesquisador.setBounds(23, 63, 46, 14);
		contentPane.add(lblNomePesquisador);
		
		JLabel lblCpfPesquisador = new JLabel("CPF: ");
		lblCpfPesquisador.setBounds(23, 109, 46, 14);
		contentPane.add(lblCpfPesquisador);
		
		JLabel lblDataNascimento = new JLabel("Data de nascimento:");
		lblDataNascimento.setBounds(23, 152, 126, 14);
		contentPane.add(lblDataNascimento);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(23, 197, 46, 14);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnSimVoluntario = new JRadioButton("Sim");
		rdbtnSimVoluntario.setBounds(23, 258, 60, 23);
		contentPane.add(rdbtnSimVoluntario);
		
		JRadioButton rdbtnNaoVoluntario = new JRadioButton("N\u00E3o");
		rdbtnNaoVoluntario.setBounds(85, 258, 54, 23);
		contentPane.add(rdbtnNaoVoluntario);
		
		ButtonGroup groupVoluntario = new ButtonGroup();
		groupVoluntario.add(rdbtnSimVoluntario);
		groupVoluntario.add(rdbtnNaoVoluntario);
		
		JLabel lblVoluntrio = new JLabel("Volunt\u00E1rio:");
		lblVoluntrio.setBounds(23, 242, 104, 14);
		contentPane.add(lblVoluntrio);
		
	
		
		checkPesquisador = new JCheckBox("Pesquisador: ");
		checkPesquisador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkPesquisador.isSelected()) {
					lblInstituicao.setEnabled(true);
					txtInstituicao.setEnabled(true);
				} else {
					lblInstituicao.setEnabled(false);
					txtInstituicao.setEnabled(false);
				}
			}
		});
		checkPesquisador.setHorizontalTextPosition(SwingConstants.LEFT);
		checkPesquisador.setHorizontalAlignment(SwingConstants.LEFT);
		checkPesquisador.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkPesquisador.setBounds(23, 284, 104, 23);
		contentPane.add(checkPesquisador);
		
		txtNome = new JTextField();
		txtNome.setBounds(23, 78, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(23, 123, 86, 20);
		contentPane.add(txtCpf);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(23, 167, 86, 20);
		contentPane.add(txtDataNascimento);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setEnabled(false);
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(23, 339, 86, 20);
		contentPane.add(txtInstituicao);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(23, 212, 91, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(117, 212, 91, 23);
		contentPane.add(rdbtnFeminino);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMasculino);
		group.add(rdbtnFeminino);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(181, 402, 89, 23);
		contentPane.add(btnSalvar);
	}
}
