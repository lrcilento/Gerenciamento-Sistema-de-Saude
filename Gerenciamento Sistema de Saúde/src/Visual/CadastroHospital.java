package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Backend.*;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroHospital extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel contentPane;
	private JTextField nomeHospital;
	private JTextField enderecoHospital;
	private JTextField totalLeitos;
	private JTextField totalLeitosDisp;

	public CadastroHospital() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("max(29dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(65dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("right:216px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default)"),},
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
				RowSpec.decode("22px"),
				RowSpec.decode("22px"),}));
		
		JLabel lblNewLabel = new JLabel("Cadastro Hospital");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, "4, 2, 3, 1, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1, "4, 4, center, default");
		
		nomeHospital = new JTextField();
		contentPane.add(nomeHospital, "6, 4, fill, default");
		nomeHospital.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2, "4, 5, center, default");
		
		enderecoHospital = new JTextField();
		contentPane.add(enderecoHospital, "6, 5, fill, default");
		enderecoHospital.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total de Leitos");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3, "4, 6, center, default");
		
		totalLeitos = new JTextField();
		contentPane.add(totalLeitos, "6, 6, fill, default");
		totalLeitos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Leitos Dispon\u00EDveis");
		contentPane.add(lblNewLabel_4, "4, 7, center, default");
		
		totalLeitosDisp = new JTextField();
		contentPane.add(totalLeitosDisp, "6, 7, fill, default");
		totalLeitosDisp.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home home = new Home();
	            home.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		contentPane.add(btnNewButton, "4, 9");
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Hospitais(nomeHospital.getText(), enderecoHospital.getText(), Integer.parseInt(totalLeitos.getText()), Integer.parseInt(totalLeitosDisp.getText()));
					JOptionPane.showMessageDialog(null, nomeHospital.getText()+" cadastrado com sucesso!");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Dados inválidos, favor preencher corretamente.");
				}
			}
		});
		contentPane.add(btnNewButton_1, "6, 9");
	}

}
