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
import java.awt.event.ActionEvent;

public class GerenciamentoHospital extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel contentPane;

	public GerenciamentoHospital() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:max(106dlu;default)"),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Gerenciar Hospital");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, "8, 2");
		
		
		JList<Hospitais> hospitalList = new JList<Hospitais>(SistemaDeSaude.hospitais);
		hospitalList.setCellRenderer(new ListCellRenderer());
		contentPane.add(hospitalList, "4, 8, 1, 21, fill, fill");
		JList<Paciente> internadosList = new JList<Paciente>();
		internadosList.setCellRenderer(new ListCellRenderer());
		contentPane.add(internadosList, "12, 8, 1, 21, fill, fill");
		
		JButton btnNewButton = new JButton("Listar Internados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					internadosList.setListData(hospitalList.getSelectedValue().internados);
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione o hospital desejado.");
				}
			}
		});
		contentPane.add(btnNewButton, "8, 10");
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
	            home.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Liberar Leito");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hospitalList.getSelectedValue().liberarLeito(internadosList.getSelectedValue());
					JOptionPane.showMessageDialog(null, "Paciente liberado com sucesso!");
					internadosList.setListData(hospitalList.getSelectedValue().internados);
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione um paciente e o hospital desejado.");
				}
			}
		});
		contentPane.add(btnNewButton_2, "8, 14");
		
		JButton btnNewButton_4 = new JButton("Remover Hospital");
		btnNewButton_4.addActionListener(new ActionListener() {
			boolean pendencia = false;
			public void actionPerformed(ActionEvent e) {
				try {
					Hospitais selecionado = hospitalList.getSelectedValue();
					for (int i = 0; i < SistemaDeSaude.pacientes.size(); i++) {
						if (SistemaDeSaude.pacientes.get(i).localDeInternacao == selecionado) {
							pendencia = true;
							break;
						}
					}
					if (pendencia == false) {
						if (JOptionPane.showConfirmDialog(new JFrame(), "Deseja mesmo remover "+selecionado.nomeHospital+"?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
							SistemaDeSaude.hospitais.remove(selecionado);
							if (SistemaDeSaude.hospitaisDisponiveis.contains(selecionado)) {
								SistemaDeSaude.hospitaisDisponiveis.remove(selecionado);
							}
							SistemaDeSaude.totalLeitos -= selecionado.numeroLeitos;
							SistemaDeSaude.totalLeitosDisp -= selecionado.numeroLeitosDisp;
							JOptionPane.showMessageDialog(null, selecionado.nomeHospital+" removido com sucesso.");
							hospitalList.setListData(SistemaDeSaude.hospitais);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Erro: ainda existem paciente internados neste hospital!");
					}
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione o hospital desejado.");
				}
			}
		});
		contentPane.add(btnNewButton_4, "8, 18");
		contentPane.add(btnNewButton_1, "8, 28");
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
	            setText(hospital.nomeHospital+" ("+(hospital.numeroLeitos-hospital.numeroLeitosDisp)+"/"+hospital.numeroLeitos+")");
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
