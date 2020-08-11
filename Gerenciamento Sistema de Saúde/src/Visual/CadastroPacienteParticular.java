package Visual;

import Backend.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroPacienteParticular extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField dataNascimento;
	private JTextField endereco;
	private JTextField telefone;
	private JTextField email;
	private JTextField nomeConvenio;
	private JTextField numeroConvenio;

	public CadastroPacienteParticular() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("max(25dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(82dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:216px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(53dlu;default)"),},
			new RowSpec[] {
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("22px"),
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Cadastro Paciente Particular");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, "4, 2, 3, 1, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1, "4, 4, center, default");
		
		nome = new JTextField();
		contentPane.add(nome, "6, 4, fill, default");
		nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2, "4, 5, center, default");
		
		cpf = new JTextField();
		contentPane.add(cpf, "6, 5, fill, default");
		cpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3, "4, 6, center, default");
		
		dataNascimento = new JTextField();
		contentPane.add(dataNascimento, "6, 6, fill, default");
		dataNascimento.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Endere\u00E7o");
		contentPane.add(lblNewLabel_4, "4, 7, center, default");
		
		endereco = new JTextField();
		contentPane.add(endereco, "6, 7, fill, default");
		endereco.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5, "4, 8, center, default");
		
		telefone = new JTextField();
		telefone.setColumns(10);
		contentPane.add(telefone, "6, 8, fill, default");
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6, "4, 9, center, default");
		
		email = new JTextField();
		email.setColumns(10);
		contentPane.add(email, "6, 9, fill, default");
		
		JLabel lblNewLabel_7 = new JLabel("Nome do Conv\u00EAnio");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_7, "4, 10, center, default");
		
		nomeConvenio = new JTextField();
		nomeConvenio.setColumns(10);
		contentPane.add(nomeConvenio, "6, 10, fill, default");
		
		JLabel lblNewLabel_8 = new JLabel("N\u00BA do Conv\u00EAnio");
		contentPane.add(lblNewLabel_8, "4, 11, center, default");
		
		numeroConvenio = new JTextField();
		contentPane.add(numeroConvenio, "6, 11, fill, default");
		numeroConvenio.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
	            home.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		contentPane.add(btnNewButton, "4, 15");
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new PacienteParticular(nome.getText(), cpf.getText(), dataNascimento.getText(), endereco.getText(), telefone.getText(), email.getText(), nomeConvenio.getText(), numeroConvenio.getText());
					JOptionPane.showMessageDialog(null, nome.getText()+" cadastrado com sucesso!");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Dados inválidos, favor preencher corretamente.");
				}
			}
		});
		contentPane.add(btnNewButton_1, "6, 15");
	}

}
