package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entidades.Aluno;
import Facade.Fachada;
import Facade.exception.aluno.AlunoNuloException;
import Facade.exception.aluno.CpfJaExisteException;
import Repositorio.RepositorioAlunosArray;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class CadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private static CadastroAluno instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = CadastroAluno.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static CadastroAluno getInstance() {
		if(instance == null) {
			instance = new CadastroAluno();
		}
		return instance;
	}
	
	/**
	 * Create the frame.
	 */
	private CadastroAluno() {
		setTitle("Cadastro Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome e cpf para cadastrar um aluno:");
		lblDigiteONome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteONome.setBounds(75, 30, 310, 14);
		contentPane.add(lblDigiteONome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(140, 103, 43, 14);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(185, 100, 100, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setBounds(140, 132, 43, 14);
		contentPane.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(185, 129, 100, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno aluno = new Aluno(textFieldNome.getText(),textFieldCpf.getText());
				try {
					Fachada.getInstance().cadastrar(aluno);
					JOptionPane.showMessageDialog(null, "Aluno cadastrado!");
					dispose();
					instance = null;
					Biblioteca.getInstance().setVisible(true);
				} catch (CpfJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (AlunoNuloException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Pictures\\Livros.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 262);
		contentPane.add(lblNewLabel);
	}

}
