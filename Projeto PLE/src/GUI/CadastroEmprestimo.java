package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Emprestimo;
import Entidades.Item;
import Facade.Fachada;
import Facade.exception.aluno.AlunoNaoEncontradoException;
import Facade.exception.emprestimo.EmprestimoJaExisteException;
import Facade.exception.emprestimo.EmprestimoNuloException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class CadastroEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCpfDoAluno;
	private static CadastroEmprestimo instance;
	private JComboBox<String> comboBox;
	static int Limite = 10;
	private ArrayList<Item> itensArray = new ArrayList<Item>();
	private JButton btnAdicionarItem;
	public static int vezes = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEmprestimo frame = CadastroEmprestimo.getInstance();
					vezes = 0;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static CadastroEmprestimo getInstance() {
		if (instance == null) {
			instance = new CadastroEmprestimo();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private CadastroEmprestimo() {
		setTitle("Cadastro empréstimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(80, 105, 261, 20);
		contentPane.add(comboBox);

		JLabel lblCpfDoAluno = new JLabel("Cpf do Aluno:");
		lblCpfDoAluno.setBounds(80, 49, 75, 14);
		contentPane.add(lblCpfDoAluno);

		textFieldCpfDoAluno = new JTextField();
		textFieldCpfDoAluno.setBounds(151, 46, 190, 20);
		contentPane.add(textFieldCpfDoAluno);
		textFieldCpfDoAluno.setColumns(10);

		JLabel lblItens = new JLabel("Itens:");
		lblItens.setBounds(80, 80, 51, 14);
		contentPane.add(lblItens);

		btnAdicionarItem = new JButton("Adicionar Item");
		btnAdicionarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CadastroItem.itemCriado != null) {
					if (vezes == 0) {
						itensArray.add(CadastroItem.itemCriado);
						comboBox.addItem(CadastroItem.itemCriado.toString());
						vezes++;
					}
				}
			}
		});
		btnAdicionarItem.setBounds(222, 136, 119, 23);
		contentPane.add(btnAdicionarItem);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				instance = null;
				Biblioteca.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 228, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Item[] itens = new Item[Limite];
				for (int i = 0; i < itensArray.size(); i++) {
					itens[i] = itensArray.get(i);
				}
				try {
					Emprestimo emprestimo = new Emprestimo(
							Fachada.getInstance().consultar(textFieldCpfDoAluno.getText()), itens,
							Login.funcionarioAtivo);
					Fachada.getInstance().cadastrar(emprestimo);
					Fachada.getInstance().atualizarEstoqueEmprestimo(emprestimo);
					JOptionPane.showMessageDialog(null, "Emprestimo cadastrado!");
					dispose();
					instance = null;
					Limite = 0;
					Biblioteca.getInstance().setVisible(true);
				} catch (AlunoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (EmprestimoJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (EmprestimoNuloException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(335, 228, 89, 23);
		contentPane.add(btnCadastrar);

		JLabel lblDigiteOCpf = new JLabel("Digite o Cpf do aluno e adicione itens para cadastrar o empr\u00E9stimo:");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOCpf.setBounds(10, 11, 414, 14);
		contentPane.add(lblDigiteOCpf);

		JButton btnCriarItem = new JButton("Criar Item");
		btnCriarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CadastroItem.getInstance().setVisible(true);
			}
		});
		btnCriarItem.setBounds(246, 77, 95, 23);
		contentPane.add(btnCriarItem);

	}
}
