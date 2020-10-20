package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Devolucao;
import Entidades.Emprestimo;
import Entidades.Item;
import Entidades.Livro;
import Facade.Fachada;
import Facade.exception.aluno.AlunoNaoEncontradoException;
import Facade.exception.devolucao.DevolucaoJaExisteException;
import Facade.exception.devolucao.DevolucaoNulaException;
import Facade.exception.emprestimo.AlunoSemEmprestimoException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextPane;

public class CadastroDevolucao extends JFrame {

	private JPanel contentPane;
	private static CadastroDevolucao instance;
	private JTextField textFieldCpfDoAluno;
	private JComboBox<String> comboBoxEmprestimos;
	private JLabel lblNomeDoFuncionario;
	private JList list;
	private JLabel lblDatadoemprestimo;
	private JComboBox<String> comboBoxItens;
	private JLabel lblValordamulta;
	private Emprestimo[] emprestimosVetor = new Emprestimo[100];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDevolucao frame = CadastroDevolucao.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static CadastroDevolucao getInstance() {
		if(instance == null) {
			instance = new CadastroDevolucao();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private CadastroDevolucao() {
		setTitle("Cadastro Devolução");
		
		AcaoSelecaoCombo acaoSelecao = new AcaoSelecaoCombo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxEmprestimos = new JComboBox<String>();
		comboBoxEmprestimos.setBounds(86, 61, 239, 20);
		contentPane.add(comboBoxEmprestimos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				instance = null;
				Biblioteca.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 267, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Devolucao devolucao = new Devolucao(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getAluno(),emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getItens(),Login.funcionarioAtivo);
				try {
					Fachada.getInstance().cadastrar(devolucao);
					Fachada.getInstance().atualizarEstoqueDevolucao(devolucao);
					JOptionPane.showMessageDialog(null, "Devolução cadastrada!");
					dispose();
					instance = null;
					Biblioteca.getInstance().setVisible(true);
				} catch (DevolucaoJaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (DevolucaoNulaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnOk.setBounds(335, 267, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(10, 142, 68, 14);
		contentPane.add(lblFuncionrio);
		
		JLabel lblEmprstimo = new JLabel("Empr\u00E9stimo:");
		lblEmprstimo.setBounds(10, 167, 99, 14);
		contentPane.add(lblEmprstimo);
		
		JLabel lblItensDevolvidos = new JLabel("Itens devolvidos:");
		lblItensDevolvidos.setBounds(228, 142, 110, 14);
		contentPane.add(lblItensDevolvidos);
		
		comboBoxItens = new JComboBox<String>();
		comboBoxItens.setBounds(228, 164, 195, 20);
		contentPane.add(comboBoxItens);
		
		JLabel lblCpfDoAluno = new JLabel("Cpf do Aluno:");
		lblCpfDoAluno.setBounds(10, 39, 76, 14);
		contentPane.add(lblCpfDoAluno);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o Cpf do aluno para pesquisar empr\u00E9stimos:");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOCpf.setBounds(10, 11, 342, 14);
		contentPane.add(lblDigiteOCpf);
		
		textFieldCpfDoAluno = new JTextField();
		textFieldCpfDoAluno.setBounds(86, 36, 239, 20);
		contentPane.add(textFieldCpfDoAluno);
		textFieldCpfDoAluno.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						carregarComboBox(Fachada.getInstance().consultar(textFieldCpfDoAluno.getText()).getCpf());
					} catch (AlunoSemEmprestimoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				} catch (AlunoNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConsultar.setBounds(335, 35, 89, 23);
		contentPane.add(btnConsultar);
		
		JLabel lblEmprstimos = new JLabel("Empr\u00E9stimos:");
		lblEmprstimos.setBounds(10, 64, 89, 14);
		contentPane.add(lblEmprstimos);
		
		JLabel lblDadosDoEmprstimo = new JLabel("Dados do empr\u00E9stimo:");
		lblDadosDoEmprstimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosDoEmprstimo.setBounds(10, 114, 164, 14);
		contentPane.add(lblDadosDoEmprstimo);
		
		lblNomeDoFuncionario = new JLabel("NomeDoFuncionario");
		lblNomeDoFuncionario.setBounds(86, 139, 143, 20);
		contentPane.add(lblNomeDoFuncionario);
		
		lblDatadoemprestimo = new JLabel("DataDoEmprestimo");
		lblDatadoemprestimo.setBounds(86, 167, 143, 14);
		contentPane.add(lblDatadoemprestimo);
		
		JLabel lblMulta = new JLabel("Multa:");
		lblMulta.setBounds(10, 192, 46, 14);
		contentPane.add(lblMulta);
		
		lblValordamulta = new JLabel("ValorDaMulta");
		lblValordamulta.setBounds(64, 192, 165, 14);
		contentPane.add(lblValordamulta);
		
		JButton btnCarregarItens = new JButton("Carregar itens");
		btnCarregarItens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					carregarComboBoxItens();
					btnCarregarItens.setVisible(false);
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Carregamento inválido!");
				}
			}
		});
		btnCarregarItens.setBounds(314, 138, 110, 23);
		contentPane.add(btnCarregarItens);
		
		//quando o emprestimo no combobox for selecionado----------------------------------------------------
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
		for(Item itm : itens) {
			if(itm != null) {
				comboBoxItens.addItem(itm.getLivro().getTitulo());
			}
		}
	}
	
	private class AcaoSelecaoCombo implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			lblNomeDoFuncionario.setText(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getFuncionario().getNome());
			lblDatadoemprestimo.setText(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getDataEmpretimo().toString());
			Devolucao devolucao = new Devolucao(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getAluno(),emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())].getItens(),Login.funcionarioAtivo);
			lblValordamulta.setText(String.valueOf(Fachada.getInstance().devolver(emprestimosVetor[(comboBoxEmprestimos.getSelectedIndex())], devolucao)));
		}
		
	}
}
