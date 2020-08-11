package Visual;

import Backend.*;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class GerenciamentoGeral extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel contentPane;

	public GerenciamentoGeral() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		NumberFormat formatter = new DecimalFormat("#0");  
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:max(106dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(106dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Gerenciamento Geral");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, "8, 2");
		JList<Paciente> filaDeEsperaList = new JList<Paciente>();
		filaDeEsperaList.setCellRenderer(new ListCellRenderer());
		contentPane.add(filaDeEsperaList, "12, 8, 1, 21, fill, fill");
		
		JButton btnNewButton = new JButton("Exibir Fila de Espera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SistemaDeSaude.filaDeEspera.isEmpty()) {
					JOptionPane.showMessageDialog(null, "A fila de espera está vazia.");
				}
				else {
					filaDeEsperaList.setListData(SistemaDeSaude.filaDeEspera);
				}
			}
		});
		contentPane.add(btnNewButton, "4, 10, 5, 1");
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
	            home.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		contentPane.add(textPane, "4, 18, 5, 1, fill, fill");
		contentPane.add(btnNewButton_1, "8, 28");
		
		JButton btnNewButton_2 = new JButton("Calcular Quantidade de Leitos Dispon\u00EDveis");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double perc = (((double)SistemaDeSaude.totalLeitos-(double)SistemaDeSaude.totalLeitosDisp)/(double)SistemaDeSaude.totalLeitos)*100;
					textPane.setText(formatter.format(perc)+"% dos leitos encontram-se ocupados. \n("+(SistemaDeSaude.totalLeitos-SistemaDeSaude.totalLeitosDisp)+"/"+SistemaDeSaude.totalLeitos+")");
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro inesperado.");
				}
			}
		});
		contentPane.add(btnNewButton_2, "4, 14, 5, 1");

	}
	public class ListCellRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		public Component getListCellRendererComponent(JList<?> list,
	                                 Object value,
	                                 int index,
	                                 boolean isSelected,
	                                 boolean cellHasFocus) {
	        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	        if (value instanceof Hospitais) {
	        	Hospitais hospital = (Hospitais)value;
	            setText(hospital.nomeHospital);
	        }
	        else if (value instanceof PacienteSUS) {
	        	Paciente paciente = (Paciente)value;
	            setText(paciente.nome+" (SUS)");
	        }
	        else if (value instanceof PacienteParticular) {
	        	PacienteParticular paciente = (PacienteParticular)value;
	            setText(paciente.nome+" ("+paciente.nomeConvenio+")");
	        }
	        return this;
	    }
	}

}
