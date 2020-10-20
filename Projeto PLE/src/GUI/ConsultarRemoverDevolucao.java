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
import Facade.exception.devolucao.AlunoSemDevolucaoException;
import Facade.exception.devolucao.DevolucaoNaoEncontradaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;

public class ConsultarRemoverDevolucao extends JFrame {

	private JPanel contentPane;
	private static ConsultarRemoverDevolucao instance;
	private JTextField textFieldCpfDoAluno;
	private JComboBox<String> comboBoxDevolucoes;
	private JLabel lblCpfdoaluno;
	private JLabel lblNomedofuncionario;
	private JLabel lblDatadadevolucao;
	private JLabel lblValordamulta;
	private JComboBox<String> comboBoxItens;
	private Devolucao[] devolucoesVetor = new Devolucao[100];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRemoverDevolucao frame = ConsultarRemoverDevolucao.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static ConsultarRemoverDevolucao getInstance() {
		if(instance == null) {
			instance = new ConsultarRemoverDevolucao();
		}
		return instance;
	}
	
	/**
	 * Create the frame.
	 */
	private ConsultarRemoverDevolucao() {
		setTitle("Consultar Devolução");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
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
		btnVoltar.setBounds(10, 324, 89, 23);
		contentPane.add(btnVoltar);
		
		if (Biblioteca.flag == false) {
			setTitle("Remover Devolução");
			JButton btnRemover = new JButton("Remover");
			btnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					Fachada.getInstance().removerDevolucao(devolucoesVetor[(comboBoxDevolucoes.getSelectedIndex())].getId());
					JOptionPane.showMessageDialog(null, "Devolução removida!");
					dispose();
					instance = null;
					Biblioteca.getInstance().setVisible(true);
					} catch(DevolucaoNaoEncontradaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ArrayIndexOutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null, "Remoção inválida!");
					}
				}
			});
			btnRemover.setBounds(335, 324, 89, 23);
			contentPane.add(btnRemover);
		}
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(10, 139, 43, 14);
		contentPane.add(lblAluno);
		
		lblCpfdoaluno = new JLabel("CpfDoAluno");
		lblCpfdoaluno.setBounds(78, 139, 258, 14);
		contentPane.add(lblCpfdoaluno);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(10, 164, 70, 14);
		contentPane.add(lblFuncionrio);
		
		lblNomedofuncionario = new JLabel("NomeDoFuncionario");
		lblNomedofuncionario.setBounds(102, 164, 285, 14);
		contentPane.add(lblNomedofuncionario);
		
		JLabel lblDataDaDevoluo = new JLabel("Data da devolu\u00E7\u00E3o:");
		lblDataDaDevoluo.setBounds(10, 189, 109, 14);
		contentPane.add(lblDataDaDevoluo);
		
		lblDatadadevolucao = new JLabel("DataDaDevolucao");
		lblDatadadevolucao.setBounds(133, 189, 218, 14);
		contentPane.add(lblDatadadevolucao);
		
		JLabel lblMulta = new JLabel("Multa:");
		lblMulta.setBounds(10, 214, 37, 14);
		contentPane.add(lblMulta);
		
		lblValordamulta = new JLabel("ValorDaMulta");
		lblValordamulta.setBounds(51, 214, 168, 14);
		contentPane.add(lblValordamulta);
		
		JLabel lblItens = new JLabel("Itens:");
		lblItens.setBounds(10, 239, 70, 14);
		contentPane.add(lblItens);
		
		comboBoxItens = new JComboBox<String>();
		comboBoxItens.setBounds(10, 264, 316, 20);
		contentPane.add(comboBoxItens);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o cpf do aluno:");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOCpf.setBounds(10, 11, 149, 14);
		contentPane.add(lblDigiteOCpf);
		
		textFieldCpfDoAluno = new JTextField();
		textFieldCpfDoAluno.setBounds(10, 36, 316, 20);
		contentPane.add(textFieldCpfDoAluno);
		textFieldCpfDoAluno.setColumns(10);
		
		JLabel lblDadosDaDevoluo = new JLabel("Dados da devolu\u00E7\u00E3o:");
		lblDadosDaDevoluo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosDaDevoluo.setBounds(10, 114, 149, 14);
		contentPane.add(lblDadosDaDevoluo);
		
		JLabel lblDevoluesFeitas = new JLabel("Devolu\u00E7\u00F5es feitas:");
		lblDevoluesFeitas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDevoluesFeitas.setBounds(10, 64, 116, 14);
		contentPane.add(lblDevoluesFeitas);
		
		comboBoxDevolucoes = new JComboBox<String>();
		comboBoxDevolucoes.setBounds(10, 86, 316, 20);
		contentPane.add(comboBoxDevolucoes);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					carregarComboBox(textFieldCpfDoAluno.getText());
				} catch (AlunoSemDevolucaoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnConsultar.setBounds(335, 35, 89, 23);
		contentPane.add(btnConsultar);
		
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
		btnCarregarItens.setBounds(315, 235, 109, 23);
		contentPane.add(btnCarregarItens);
		
		//quando o emprestimo no combobox for selecionado----------------------------------------------------
		comboBoxDevolucoes.addActionListener(acaoSelecao);
	}
	
	private void carregarComboBox(String cpf) throws AlunoSemDevolucaoException{
		ArrayList<Devolucao> devolucoes = new ArrayList<Devolucao>();
		devolucoes = Fachada.getInstance().procurarDevolucoes(cpf);
		for(int i = 0; i<devolucoes.size();i++){
			if (devolucoes.get(i) != null) {
				devolucoesVetor[i] = devolucoes.get(i);
				comboBoxDevolucoes.addItem(devolucoes.get(i).toString());
			}
		}
	}
	
	private void carregarComboBoxItens() {
		Item[] itens = devolucoesVetor[(comboBoxDevolucoes.getSelectedIndex())].getItens();
		for(Item itm : itens) {
			if(itm != null) {
				comboBoxItens.addItem(itm.toString());
			}
		}
	}
	
	private class AcaoSelecaoCombo implements ActionListener{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			lblCpfdoaluno.setText(devolucoesVetor[(comboBoxDevolucoes.getSelectedIndex())].getAluno().getCpf());
			lblNomedofuncionario.setText(devolucoesVetor[(comboBoxDevolucoes.getSelectedIndex())].getFuncionario().getNome());
			lblDatadadevolucao.setText(devolucoesVetor[(comboBoxDevolucoes.getSelectedIndex())].getDataDevolucao().toString());
			lblValordamulta.setText(String.valueOf(devolucoesVetor[(comboBoxDevolucoes.getSelectedIndex())].getMulta()));
		}
		
	}
}
