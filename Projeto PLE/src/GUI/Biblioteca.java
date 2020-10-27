package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

public class Biblioteca extends JFrame {

	private JPanel contentPane;
	private static Biblioteca instance;
	public static Boolean flag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Biblioteca frame = Biblioteca.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static Biblioteca getInstance() {
		if (instance == null) {
			instance = new Biblioteca();
		}
		return instance;
	}

	private Biblioteca() {
		
		setTitle("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Aluno----------------------------------------------------------------------------------------------------------------------------

		JLabel lblAluno = new JLabel("Aluno");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAluno.setForeground(Color.BLACK);
		lblAluno.setBounds(10, 32, 46, 14);
		contentPane.add(lblAluno);

		JButton btnCadastrarAluno = new JButton("Cadastrar");
		btnCadastrarAluno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CadastroAluno.getInstance().setVisible(true);
			}
		});
		btnCadastrarAluno.setBounds(0, 57, 80, 23);
		contentPane.add(btnCadastrarAluno);

		JButton btnAtualizarAluno = new JButton("Atualizar");
		btnAtualizarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AtualizarAluno.getInstance().setVisible(true);
			}
		});
		btnAtualizarAluno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizarAluno.setBounds(0, 91, 80, 23);
		contentPane.add(btnAtualizarAluno);

		JButton btnRemoverAluno = new JButton("Remover");
		btnRemoverAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = false;
				ConsultarRemoverAluno.getInstance().setVisible(true);

			}
		});
		btnRemoverAluno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoverAluno.setBounds(0, 125, 80, 23);
		contentPane.add(btnRemoverAluno);

		JButton btnConsultarAluno = new JButton("Consultar");
		btnConsultarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = true;
				ConsultarRemoverAluno.getInstance().setVisible(true);
			}
		});
		btnConsultarAluno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultarAluno.setBounds(0, 159, 80, 23);
		contentPane.add(btnConsultarAluno);
		
		JButton btnListarAluno = new JButton("Listar");
		btnListarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListarAluno.getInstance().setVisible(true);
			}
		});
		btnListarAluno.setBounds(0, 193, 80, 23);
		contentPane.add(btnListarAluno);

		// Livro-----------------------------------------------------------------------------------------------------------------------------

		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLivro.setForeground(Color.BLACK);
		lblLivro.setBounds(91, 32, 46, 14);
		contentPane.add(lblLivro);

		JButton btnCadastrarLivro = new JButton("Cadastrar");
		btnCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CadastroLivro.getInstance().setVisible(true);
			}
		});
		btnCadastrarLivro.setBounds(91, 57, 80, 23);
		contentPane.add(btnCadastrarLivro);

		JButton btnAtualizarLivro = new JButton("Atualizar");
		btnAtualizarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AtualizarLivro.getInstance().setVisible(true);
			}
		});
		btnAtualizarLivro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizarLivro.setBounds(91, 91, 80, 23);
		contentPane.add(btnAtualizarLivro);

		JButton btnRemoverLivro = new JButton("Remover");
		btnRemoverLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = false;
				ConsultarRemoverLivro.getInstance().setVisible(true);
			}
		});
		btnRemoverLivro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoverLivro.setBounds(91, 125, 80, 23);
		contentPane.add(btnRemoverLivro);

		JButton btnConsultarLivro = new JButton("Consultar");
		btnConsultarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = true;
				ConsultarRemoverLivro.getInstance().setVisible(true);
			}
		});
		btnConsultarLivro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultarLivro.setBounds(91, 159, 80, 23);
		contentPane.add(btnConsultarLivro);
		
		JButton btnListarLivro = new JButton("Listar");
		btnListarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListarLivro.getInstance().setVisible(true);;
			}
		});
		btnListarLivro.setBounds(91, 193, 80, 23);
		contentPane.add(btnListarLivro);

		// Funcionario-------------------------------------------------------------------------------------------------------------------------

		JLabel lblFuncionario = new JLabel("Funcionario");
		lblFuncionario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuncionario.setForeground(Color.BLACK);
		lblFuncionario.setBounds(182, 32, 71, 14);
		contentPane.add(lblFuncionario);

		JButton btnCadastrarFuncionario = new JButton("Cadastrar");
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CadastroFuncionario.getInstance().setVisible(true);
			}
		});
		btnCadastrarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrarFuncionario.setBounds(182, 57, 80, 23);
		contentPane.add(btnCadastrarFuncionario);
		
		JButton btnAtualizarFuncionario = new JButton("Atualizar");
		btnAtualizarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AtualizarFuncionario.getInstance().setVisible(true);
			}
		});
		btnAtualizarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtualizarFuncionario.setBounds(182, 91, 80, 23);
		contentPane.add(btnAtualizarFuncionario);
		
		JButton btnRemoverFuncionario = new JButton("Remover");
		btnRemoverFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = false;
				ConsultarRemoverFuncionario.getInstance().setVisible(true);
			}
		});
		btnRemoverFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoverFuncionario.setBounds(182, 125, 80, 23);
		contentPane.add(btnRemoverFuncionario);
		
		JButton btnConsultarFuncionario = new JButton("Consultar");
		btnConsultarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = true;
				ConsultarRemoverFuncionario.getInstance().setVisible(true);
			}
		});
		btnConsultarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultarFuncionario.setBounds(182, 159, 80, 23);
		contentPane.add(btnConsultarFuncionario);
		
		JButton btnListarFuncionario = new JButton("Listar");
		btnListarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListarFuncionario.getInstance().setVisible(true);
			}
		});
		btnListarFuncionario.setBounds(182, 193, 80, 23);
		contentPane.add(btnListarFuncionario);
		
		// Emprestimo------------------------------------------------------------------------------------------------------------------------
		
		JLabel lblEmprstimo = new JLabel("Empr\u00E9stimo");
		lblEmprstimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmprstimo.setForeground(Color.BLACK);
		lblEmprstimo.setBounds(273, 32, 71, 14);
		contentPane.add(lblEmprstimo);
		
		JButton btnCadastrarEmprestimo = new JButton("Cadastrar");
		btnCadastrarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CadastroEmprestimo.getInstance().setVisible(true);
			}
		});
		btnCadastrarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrarEmprestimo.setBounds(273, 57, 80, 23);
		contentPane.add(btnCadastrarEmprestimo);
		
		JButton btnRemoverEmprestimo = new JButton("Remover");
		btnRemoverEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = false;
				ConsultarRemoverEmprestimo.getInstance().setVisible(true);
			}
		});
		btnRemoverEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoverEmprestimo.setBounds(273, 125, 80, 23);
		contentPane.add(btnRemoverEmprestimo);
		
		JButton btnConsultarEmprestimo = new JButton("Consultar");
		btnConsultarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = true;
				ConsultarRemoverEmprestimo.getInstance().setVisible(true);
			}
		});
		btnConsultarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultarEmprestimo.setBounds(273, 159, 80, 23);
		contentPane.add(btnConsultarEmprestimo);
		
		JButton btnListarEmprestimo = new JButton("Listar");
		btnListarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ListarEmprestimo.getInstance().setVisible(true);
			}
		});
		btnListarEmprestimo.setBounds(273, 193, 80, 23);
		contentPane.add(btnListarEmprestimo);
		
		//Devolucao--------------------------------------------------------------------------------------------------------------------

		JLabel lblDevoluo = new JLabel("Devolu\u00E7\u00E3o");
		lblDevoluo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDevoluo.setForeground(Color.BLACK);
		lblDevoluo.setBounds(364, 32, 71, 14);
		contentPane.add(lblDevoluo);

		JButton btnCadastrarDevolucao = new JButton("Cadastrar");
		btnCadastrarDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CadastroDevolucao.getInstance().setVisible(true);
			}
		});
		btnCadastrarDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCadastrarDevolucao.setBounds(364, 57, 80, 23);
		contentPane.add(btnCadastrarDevolucao);

		JButton btnRemoverDevolucao = new JButton("Remover");
		btnRemoverDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = false;
				ConsultarRemoverDevolucao.getInstance().setVisible(true);
			}
		});
		btnRemoverDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemoverDevolucao.setBounds(364, 125, 80, 23);
		contentPane.add(btnRemoverDevolucao);

		JButton btnConsultarDevolucao = new JButton("Consultar");
		btnConsultarDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				flag = true;
				ConsultarRemoverDevolucao.getInstance().setVisible(true);
			}
		});
		btnConsultarDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultarDevolucao.setBounds(364, 159, 80, 23);
		contentPane.add(btnConsultarDevolucao);
		
		JButton btnListarDevolucao = new JButton("Listar");
		btnListarDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ListarDevolucao.getInstance().setVisible(true);
			}
		});
		btnListarDevolucao.setBounds(364, 193, 80, 23);
		contentPane.add(btnListarDevolucao);
		
		//--------------------------------------------------------------------------------------------------------------------------
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				instance = null;
				Login.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 256, 89, 23);
		contentPane.add(btnVoltar);
		
	}
}
