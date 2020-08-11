package Visual;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Home extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{39, 114, 121, 121, 35, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 27, 0, 25, 23, 25, 31, 23, 68, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Paciente SUS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroPacienteSUS cadastroPacienteSUS = new CadastroPacienteSUS();
				cadastroPacienteSUS.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Bem-vindo!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Paciente Particular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPacienteParticular cadastroPacienteParticular = new CadastroPacienteParticular();
				cadastroPacienteParticular.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 5;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Hospital");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroHospital cadastroHospital = new CadastroHospital();
	            cadastroHospital.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1.gridx = 3;
		gbc_btnNewButton_1_1.gridy = 5;
		contentPane.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gerenciamento");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 7;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnGeral = new JButton("Geral");
		btnGeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciamentoGeral gerenciamentoGeral = new GerenciamentoGeral();
				gerenciamentoGeral.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_btnGeral = new GridBagConstraints();
		gbc_btnGeral.anchor = GridBagConstraints.NORTH;
		gbc_btnGeral.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGeral.insets = new Insets(0, 0, 5, 5);
		gbc_btnGeral.gridx = 1;
		gbc_btnGeral.gridy = 8;
		contentPane.add(btnGeral, gbc_btnGeral);
		
		JButton btnNewButton_1_2 = new JButton("Paciente");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciamentoPaciente gerenciamentoPaciente = new GerenciamentoPaciente();
				gerenciamentoPaciente.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1_2 = new GridBagConstraints();
		gbc_btnNewButton_1_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_2.gridx = 2;
		gbc_btnNewButton_1_2.gridy = 8;
		contentPane.add(btnNewButton_1_2, gbc_btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Hospital");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciamentoHospital gerenciamentoHospital = new GerenciamentoHospital();
				gerenciamentoHospital.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1_3 = new GridBagConstraints();
		gbc_btnNewButton_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_3.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1_3.gridx = 3;
		gbc_btnNewButton_1_3.gridy = 8;
		contentPane.add(btnNewButton_1_3, gbc_btnNewButton_1_3);
	}
}
