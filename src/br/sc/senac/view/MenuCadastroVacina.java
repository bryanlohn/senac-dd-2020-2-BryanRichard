package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import br.sc.senac.controller.ControladorVacina;
import br.sc.senac.model.vo.VacinaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MenuCadastroVacina extends JFrame {

	private JPanel contentPane;
	private JTextField txtPaisOrigemVacina;
	private JTextField txtNomePesquisador;
	private JComboBox cboxEstagioPesquisa;
	private DatePicker dataInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCadastroVacina frame = new MenuCadastroVacina();
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
	public MenuCadastroVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloVacina = new JLabel("Cadastro de Vac\u00EDnas");
		lblTituloVacina.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloVacina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVacina.setBounds(10, 11, 414, 36);
		contentPane.add(lblTituloVacina);
		
		JLabel lblPaisOrigemVacina = new JLabel("Pa\u00EDs de Origem da Vacina: ");
		lblPaisOrigemVacina.setBounds(12, 122, 171, 14);
		contentPane.add(lblPaisOrigemVacina);
		
		txtPaisOrigemVacina = new JTextField();
		txtPaisOrigemVacina.setBounds(10, 137, 149, 20);
		contentPane.add(txtPaisOrigemVacina);
		txtPaisOrigemVacina.setColumns(10);
		
		JLabel lblEstagioPesquisa = new JLabel("Est\u00E1gio da Pesquisa: ");
		lblEstagioPesquisa.setBounds(12, 168, 171, 14);
		contentPane.add(lblEstagioPesquisa);

		DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setAllowKeyboardEditing(false);
        dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");

        dataInicio = new DatePicker(dateSettings);
        dataInicio.getComponentToggleCalendarButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        dataInicio.setBounds(10, 230, 183, 26);
        getContentPane().add(dataInicio);
		
		cboxEstagioPesquisa = new JComboBox();
		cboxEstagioPesquisa.setModel(new DefaultComboBoxModel(new String[] {"1-inicial", "2-testes", "3-aplica\u00E7\u00E3o em massa"}));
		cboxEstagioPesquisa.setBounds(9, 184, 147, 20);
		contentPane.add(cboxEstagioPesquisa);
		
		JLabel lblDataInicioPesquisa = new JLabel("Data de in\u00EDcio da pesquisa: ");
		lblDataInicioPesquisa.setBounds(12, 215, 171, 14);
		contentPane.add(lblDataInicioPesquisa);
		
		JLabel lblNomePesquisador = new JLabel("Nome do Pesquisador:  ");
		lblNomePesquisador.setBounds(12, 83, 147, 14);
		contentPane.add(lblNomePesquisador);
		
		txtNomePesquisador = new JTextField();
		txtNomePesquisador.setColumns(10);
		txtNomePesquisador.setBounds(10, 98, 149, 20);
		contentPane.add(txtNomePesquisador);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VacinaVO vacinaVO = new VacinaVO();
				vacinaVO.setPesquisadorVO(txtNomePesquisador.getText());
				vacinaVO.setPaisOrigem(txtPaisOrigemVacina.getText());
				String resultadoCombo = (String)cboxEstagioPesquisa.getSelectedItem();
				vacinaVO.setEstagioPesquisa(resultadoCombo);
				vacinaVO.setDataInicioPesquisa(dataInicio.getText());
				
				ControladorVacina controleVacina = new ControladorVacina();
				controleVacina.cadastrarVacina(vacinaVO);
			}
		});
		btnCadastrar.setBounds(195, 367, 98, 26);
		contentPane.add(btnCadastrar);
	}
}
