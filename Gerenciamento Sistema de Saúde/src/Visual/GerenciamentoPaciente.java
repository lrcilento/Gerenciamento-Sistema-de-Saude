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

public class GerenciamentoPaciente extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel contentPane;

	public GerenciamentoPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 502);
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
		
		JLabel lblNewLabel = new JLabel("Gerenciar Paciente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel, "8, 2");
		JList<Hospitais> hospitaisDiponiveisList = new JList<Hospitais>();
		hospitaisDiponiveisList.setCellRenderer(new ListCellRenderer());
		contentPane.add(hospitaisDiponiveisList, "12, 8, 1, 25, fill, fill");
		
		JList<Paciente> pacienteList = new JList<Paciente>(SistemaDeSaude.pacientes);
		pacienteList.setCellRenderer(new ListCellRenderer());
		contentPane.add(pacienteList, "4, 8, 1, 25, fill, fill");
		
		JButton btnNewButton = new JButton("Listar Hospitais Dispon\u00EDveis");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospitaisDiponiveisList.setListData(SistemaDeSaude.hospitaisDisponiveis);
				if (SistemaDeSaude.hospitaisDisponiveis.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum hospital disponivel, por favor adione o paciente a fila de espera.");
				}
			}
		});
		contentPane.add(btnNewButton, "8, 8");
		
		JButton btnNewButton_1 = new JButton("Realizar Interna\u00E7\u00E3o");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(pacienteList.getSelectedValue().localDeInternacao == null) {
						if(hospitaisDiponiveisList.getSelectedValue().numeroLeitosDisp > 0) {
							hospitaisDiponiveisList.getSelectedValue().inserirPaciente(pacienteList.getSelectedValue());
							JOptionPane.showMessageDialog(null, pacienteList.getSelectedValue().nome+" internado com sucesso!");
							hospitaisDiponiveisList.setListData(SistemaDeSaude.hospitaisDisponiveis);
							pacienteList.setListData(SistemaDeSaude.pacientes);
						}
						else {
							JOptionPane.showMessageDialog(null, "Hospital lotado, atualize a lista de hospitais disponíveis.");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Paciente já internado.");
					}
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione um paciente e o hospital desejado.");
				}
			}
		});
		contentPane.add(btnNewButton_1, "8, 12");
		
		JButton btnNewButton_3 = new JButton("Adicionar a Fila de Espera");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(pacienteList.getSelectedValue().localDeInternacao == null) {
						if (SistemaDeSaude.hospitaisDisponiveis.isEmpty()) {
							pacienteList.getSelectedValue().adicionarFila();
							JOptionPane.showMessageDialog(null, pacienteList.getSelectedValue().nome+" foi adicionado(a) a fila de espera");
							pacienteList.setListData(SistemaDeSaude.pacientes);
						}
						else {
							SistemaDeSaude.hospitaisDisponiveis.get(0).inserirPaciente(pacienteList.getSelectedValue());
							JOptionPane.showMessageDialog(null, "Foram encontradas vagas! "+ pacienteList.getSelectedValue().nome+" internado com sucesso!");
							hospitaisDiponiveisList.setListData(SistemaDeSaude.hospitaisDisponiveis);
							pacienteList.setListData(SistemaDeSaude.pacientes);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Paciente já internado.");
					}
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione o paciente a ser adiconado.");
				}
			}
		});
		
		contentPane.add(btnNewButton_3, "8, 16");
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
	            home.setVisible(true);
	            setVisible(false);
	            dispose();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Verificar Local de Internação");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (pacienteList.getSelectedValue().localDeInternacao != null) {
						JOptionPane.showMessageDialog(null, pacienteList.getSelectedValue().nome+" está internado em "+pacienteList.getSelectedValue().localDeInternacao.nomeHospital+".");
					}
					else {
						JOptionPane.showMessageDialog(null, pacienteList.getSelectedValue().nome+" não encontra-se internado.");
					}
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione um paciente desejado.");
				}
			}
		});
		contentPane.add(btnNewButton_4, "8, 20");
		JButton btnNewButton_5 = new JButton("Ocultar/Mostrar Paciente Internados");
		btnNewButton_5.addActionListener(new ActionListener() {
			boolean ocultar = false;
			public void actionPerformed(ActionEvent e) {
				if (ocultar == false) {
					pacienteList.setListData(SistemaDeSaude.pacientesLivres);
					ocultar = true;
				}
				else {
					pacienteList.setListData(SistemaDeSaude.pacientes);
					ocultar = false;
				}
			}
		});
		contentPane.add(btnNewButton_5, "8, 24");
		
		JButton btnNewButton_6 = new JButton("Remover Paciente");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Paciente selecionado = pacienteList.getSelectedValue();
					if (JOptionPane.showConfirmDialog(new JFrame(), "Deseja mesmo remover "+selecionado.nome+"?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == 0) {
						SistemaDeSaude.pacientes.remove(selecionado);
						if (SistemaDeSaude.pacientesLivres.contains(selecionado)) {
							SistemaDeSaude.pacientesLivres.remove(selecionado);
						}
						if (SistemaDeSaude.filaDeEspera.contains(selecionado)) {
							SistemaDeSaude.filaDeEspera.remove(selecionado);
						}
						JOptionPane.showMessageDialog(null, selecionado.nome+" removido com sucesso.");
						pacienteList.setListData(SistemaDeSaude.pacientes);
					}
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione um paciente desejado.");
				}
			}
		});
		contentPane.add(btnNewButton_6, "8, 28");
		contentPane.add(btnNewButton_2, "8, 32");
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
	            setText(hospital.nomeHospital+" ("+hospital.numeroLeitosDisp+" vagas)");
	        }
	        else if (value instanceof Paciente) {
	        	Paciente paciente = (Paciente)value;
	        	if (paciente.localDeInternacao == null && paciente.filaDeEspera == false) {
	        		setText(paciente.nome);
	        	}
	        	else if (paciente.filaDeEspera == true) {
	        		setText(paciente.nome+" (Fila de Espera)");
	        	}
	        	else {
	        		setText(paciente.nome+" (Internado)");
	        	}
	        }
	        return this;
	    }
	}

}
