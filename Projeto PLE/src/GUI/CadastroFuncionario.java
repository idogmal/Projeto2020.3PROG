package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Funcionario;
import Facade.Fachada;
import Facade.exception.aluno.CpfJaExisteException;
import Facade.exception.funcionario.FuncionarioNuloException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldSenha;
	private static CadastroFuncionario instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = CadastroFuncionario.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static CadastroFuncionario getInstance() {
		if (instance == null) {
			instance = new CadastroFuncionario();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private CadastroFuncionario() {
		setTitle("Cadastro Funcionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(133, 86, 39, 14);
		contentPane.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(174, 83, 122, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(133, 111, 39, 14);
		contentPane.add(lblCpf);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(174, 108, 122, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(133, 136, 39, 14);
		contentPane.add(lblSenha);

		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(174, 133, 122, 20);
		contentPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario(textFieldNome.getText(), textFieldCpf.getText(), textFieldSenha.getText());
				try {
					Fachada.getInstance().cadastrar(funcionario);
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");
					dispose();
					instance = null;
					Biblioteca.getInstance().setVisible(true);
				} catch (CpfJaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (FuncionarioNuloException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(335, 228, 89, 23);
		contentPane.add(btnCadastrar);

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

		JLabel lblDigiteONome = new JLabel("Digite o nome, cpf e senha para cadastrar um funcion\u00E1rio:");
		lblDigiteONome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteONome.setBounds(54, 30, 370, 14);
		contentPane.add(lblDigiteONome);
	}
}
