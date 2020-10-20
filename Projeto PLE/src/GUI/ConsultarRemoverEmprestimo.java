package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Devolucao;
import Entidades.Emprestimo;
import Entidades.Item;
import Facade.Fachada;
import Facade.exception.emprestimo.AlunoSemEmprestimoException;
import Facade.exception.emprestimo.EmprestimoNaoEncontradoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConsultarRemoverEmprestimo extends JFrame {

	private JPanel contentPane;
	private static ConsultarRemoverEmprestimo instance;
	private JTextField textFieldCpfDoAluno;
	private JComboBox<String> comboBoxEmprestimos;
	private JLabel lblCpfdoaluno;
	private JLabel lblNomedofuncionario;
	private JLabel lblDatadoemprestimo;
	private JLabel lblDatadadevolucao;
	private JComboBox<String> comboBoxItens;
//	private ArrayList<Emprestimo> emprestimosLista = new  ArrayList<Emprestimo>();
	private Emprestimo[] emprestimosVetor = new Emprestimo[100];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRemoverEmprestimo frame = ConsultarRemoverEmprestimo.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static ConsultarRemoverEmprestimo getInstance() {
		if (instance == null) {
			instance = new ConsultarRemoverEmprestimo();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private ConsultarRemoverEmprestimo() {
		setTitle("Consultar Emprestimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AcaoSelecaoCombo acaoSelecao = new AcaoSelecaoCombo();

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				instance = null;
				Biblioteca.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 304, 89, 23);
		contentPane.add(btnVoltar);

		if (Biblioteca.flag == false) {
			setTitle("Remover Emprestimo");
			JButton btnRemover = new JButton("Remover");
			btnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Fachada.getInstance().removerEmprestimo(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getId());
						JOptionPane.showMessageDialog(null, "Emprestimo removido!");
					} catch (EmprestimoNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null, "Remoção inválida!");
					}
				}
			});
			btnRemover.setBounds(335, 304, 89, 23);
			contentPane.add(btnRemover);
		}

		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(10, 139, 43, 14);
		contentPane.add(lblAluno);

		lblCpfdoaluno = new JLabel("CpfDoAluno");
		lblCpfdoaluno.setBounds(61, 139, 299, 14);
		contentPane.add(lblCpfdoaluno);

		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(10, 164, 69, 14);
		contentPane.add(lblFuncionrio);

		lblNomedofuncionario = new JLabel("NomeDoFuncionario");
		lblNomedofuncionario.setBounds(96, 164, 292, 14);
		contentPane.add(lblNomedofuncionario);

		JLabel lblDataDeEmprstimo = new JLabel("Data de Empr\u00E9stimo:");
		lblDataDeEmprstimo.setBounds(10, 189, 121, 14);
		contentPane.add(lblDataDeEmprstimo);

		lblDatadoemprestimo = new JLabel("DataDoEmprestimo");
		lblDatadoemprestimo.setBounds(136, 189, 189, 14);
		contentPane.add(lblDatadoemprestimo);

		JLabel lblItens = new JLabel("Itens:");
		lblItens.setBounds(10, 239, 89, 14);
		contentPane.add(lblItens);

		JLabel lblDataDaDevoluo = new JLabel("Data da Devolu\u00E7\u00E3o:");
		lblDataDaDevoluo.setBounds(10, 214, 121, 14);
		contentPane.add(lblDataDaDevoluo);

		lblDatadadevolucao = new JLabel("DataDaDevolucao");
		lblDatadadevolucao.setBounds(134, 214, 191, 14);
		contentPane.add(lblDatadadevolucao);

		comboBoxItens = new JComboBox<String>();
		comboBoxItens.setBounds(10, 263, 315, 20);
		contentPane.add(comboBoxItens);

		JLabel lblDigiteOCpf = new JLabel("Digite o cpf do aluno:");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOCpf.setBounds(10, 11, 194, 14);
		contentPane.add(lblDigiteOCpf);

		textFieldCpfDoAluno = new JTextField();
		textFieldCpfDoAluno.setBounds(10, 36, 315, 20);
		contentPane.add(textFieldCpfDoAluno);
		textFieldCpfDoAluno.setColumns(10);

		JLabel lblDadosDoEmprstimo = new JLabel("Dados do empr\u00E9stimo:");
		lblDadosDoEmprstimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosDoEmprstimo.setBounds(10, 114, 156, 14);
		contentPane.add(lblDadosDoEmprstimo);

		JLabel lblEmprstimosEmAberto = new JLabel("Empr\u00E9stimos em aberto:");
		lblEmprstimosEmAberto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmprstimosEmAberto.setBounds(10, 64, 209, 14);
		contentPane.add(lblEmprstimosEmAberto);

		comboBoxEmprestimos = new JComboBox<String>();
		comboBoxEmprestimos.setBounds(10, 86, 315, 20);
		contentPane.add(comboBoxEmprestimos);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carregarComboBox(textFieldCpfDoAluno.getText());
				} catch (AlunoSemEmprestimoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConsultar.setBounds(335, 35, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnCarregarItens = new JButton("Carregar Itens");
		btnCarregarItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					carregarComboBoxItens();
					btnCarregarItens.setVisible(false);
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Carregamento inválido!");
				}
				
			}
		});
		btnCarregarItens.setBounds(312, 235, 112, 23);
		contentPane.add(btnCarregarItens);

		
		//quando o item e selecionado no combobox-------------------------------------------------------------------------------------
		comboBoxEmprestimos.addActionListener(acaoSelecao);
		
		
	}

	private void carregarComboBox(String cpf) throws AlunoSemEmprestimoException{
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		emprestimos = Fachada.getInstance().procurarEmprestimos(cpf);
		for(int i = 0; i<emprestimos.size();i++){
			if (emprestimos.get(i) != null) {
				emprestimosVetor[i] = emprestimos.get(i);
				comboBoxEmprestimos.addItem(emprestimos.get(i).toString());
			}
		}

	}

	private void carregarComboBoxItens() {
		Item[] itens = emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getItens();
		for (Item itm : itens) {
			if (itm != null) {
				comboBoxItens.addItem(itm.toString());
			}
		}
	}

	private class AcaoSelecaoCombo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
				lblCpfdoaluno.setText(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getAluno().getCpf());
				lblNomedofuncionario.setText(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getFuncionario().getNome());
				lblDatadadevolucao.setText(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getDataDevolucao().toString());
				lblDatadoemprestimo.setText(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getDataEmpretimo().toString());
		}

	}
}
