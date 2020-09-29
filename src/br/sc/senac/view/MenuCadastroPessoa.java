package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import br.sc.senac.controller.ControladorPesquisador;
import br.sc.senac.controller.ControladorPublicoVoluntario;
import br.sc.senac.model.vo.PesquisadorVO;
import br.sc.senac.model.vo.PublicoVoluntarioVO;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.UIManager;

public class MenuCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtDataNascimento;
	private JTextField txtInstituicao;
	private JRadioButton rdbtnSimVoluntario;
	private JRadioButton rdbtnNaoVoluntario;
	private JCheckBox checkPesquisador;
	private JLabel lblInstituicao;
	private String txtNomeV;
	private DatePicker dataNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
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
	 * @throws Exception 
	 */
	public MenuCadastroPessoa() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInstituicao = new JLabel("Institui\u00E7\u00E3o: ");
		lblInstituicao.setEnabled(false);
		lblInstituicao.setBounds(23, 314, 104, 14);
		contentPane.add(lblInstituicao);
		
		JLabel lblTituloCadastroPesquisador = new JLabel("Cadastro de Pessoa");
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
		lblSexo.setBounds(24, 202, 46, 14);
		contentPane.add(lblSexo);
		
		rdbtnSimVoluntario = new JRadioButton("Sim");
		rdbtnSimVoluntario.setBounds(23, 258, 60, 23);
		contentPane.add(rdbtnSimVoluntario);
		
		rdbtnNaoVoluntario = new JRadioButton("N\u00E3o");
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
					rdbtnSimVoluntario.setEnabled(false);
					rdbtnNaoVoluntario.setEnabled(false);
				} else {
					lblInstituicao.setEnabled(false);
					txtInstituicao.setEnabled(false);
					rdbtnSimVoluntario.setEnabled(true);
					rdbtnNaoVoluntario.setEnabled(true);
				}
			}
		});
		checkPesquisador.setHorizontalTextPosition(SwingConstants.LEFT);
		checkPesquisador.setHorizontalAlignment(SwingConstants.LEFT);
		checkPesquisador.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		checkPesquisador.setBounds(23, 284, 104, 23);
		contentPane.add(checkPesquisador);
		
		
		txtNome = new JTextField();
		txtNome.setBounds(23, 78, 200, 23);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		/*txtNomeV = txtNome;
		if(txtNome.getText().length() < 3)
		    throw new Exception("Nome com menos de 3 caracteres, por favor insira novamente o nome."); // Exception específica da sua aplicação.*/
		
		
		/*txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(23, 123, 86, 20);
		contentPane.add(txtCpf);*/
		
		MaskFormatter mascaraCpf;
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            txtCpf = new JFormattedTextField(mascaraCpf);
            txtCpf.setText("");
            txtCpf.setBounds(23, 123, 200, 23);
            contentPane.add(txtCpf);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cpf\nErro: " + e.getMessage());
        }
		
		DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setAllowKeyboardEditing(false);
        dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");

        dataNascimento = new DatePicker(dateSettings);
        dataNascimento.getComponentToggleCalendarButton().setBounds(162, 0, 31, 23);
        dataNascimento.getComponentDateTextField().setBounds(0, 0, 159, 23);
        dataNascimento.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        dataNascimento.setBounds(23, 168, 200, 23);
        getContentPane().add(dataNascimento);
        dataNascimento.setLayout(null);
		
		
		txtInstituicao = new JTextField();
		txtInstituicao.setEnabled(false);
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(23, 339, 200, 23);
		contentPane.add(txtInstituicao);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(24, 217, 91, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(118, 217, 91, 23);
		contentPane.add(rdbtnFeminino);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMasculino);
		group.add(rdbtnFeminino);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkPesquisador.isSelected()) {
					PesquisadorVO pesquisadorVO = new PesquisadorVO();
					pesquisadorVO.setNomeCompleto(txtNome.getText());
					if(rdbtnMasculino.isSelected()) {
						pesquisadorVO.setSexo("Masculino");
					} else {
						pesquisadorVO.setSexo("Feminino");
					}
					pesquisadorVO.setCpf(txtCpf.getText().replace(".",  "").replace("-", ""));
					pesquisadorVO.setDataNascimento(dataNascimento.getText());
					pesquisadorVO.setInstituicao(txtInstituicao.getText());
					
					ControladorPesquisador controladorPesquisador = new ControladorPesquisador();
					controladorPesquisador.cadastrarPesquisador(pesquisadorVO);
					
				} else {
					PublicoVoluntarioVO publicoVoluntarioVO = new PublicoVoluntarioVO();
					publicoVoluntarioVO.setNomeCompleto(txtNome.getText());
					if(rdbtnMasculino.isSelected()) {
						publicoVoluntarioVO.setSexo("Masculino");
					} else {
						publicoVoluntarioVO.setSexo("Feminino");
					}
					publicoVoluntarioVO.setCpf(txtCpf.getText().replace(".",  "").replace("-", ""));
					publicoVoluntarioVO.setDataNascimento(dataNascimento.getText());
					if(rdbtnSimVoluntario.isSelected()) {
						publicoVoluntarioVO.setVoluntario(true);
					} else {
						publicoVoluntarioVO.setVoluntario(false);
					}
					
					ControladorPublicoVoluntario controladorPublicoVoluntario = new ControladorPublicoVoluntario();
					controladorPublicoVoluntario.cadastrarPublicoVoluntario(publicoVoluntarioVO);
			}
			}
		});
		btnSalvar.setBounds(179, 385, 100, 33);
		contentPane.add(btnSalvar);
		
		
	}
}
