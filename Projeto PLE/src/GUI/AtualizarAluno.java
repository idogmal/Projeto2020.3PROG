package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Aluno;
import Facade.Fachada;
import Facade.exception.aluno.AlunoNaoEncontradoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class AtualizarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeAtt;
	private static AtualizarAluno instance;
	private JTextField textFieldCpfDoAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarAluno frame = AtualizarAluno.getInstance();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static AtualizarAluno getInstance() {
		if (instance == null) {
			instance = new AtualizarAluno();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private AtualizarAluno() {
		setTitle("Atualizar Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 92, 40, 14);
		contentPane.add(lblNome);

		JLabel lblNomedoaluno = new JLabel("NomeDoAluno");
		lblNomedoaluno.setBounds(51, 92, 159, 14);
		contentPane.add(lblNomedoaluno);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(10, 117, 30, 14);
		contentPane.add(lblCpf);

		JLabel lblCpfdoaluno = new JLabel("CpfDoAluno");
		lblCpfdoaluno.setBounds(41, 117, 169, 14);
		contentPane.add(lblCpfdoaluno);

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

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno(textFieldNomeAtt.getText(), lblCpfdoaluno.getText());
				try {
					Fachada.getInstance().atualizar(aluno);
					JOptionPane.showMessageDialog(null, "Aluno atualizado!");
					dispose();
					instance = null;
					Biblioteca.getInstance().setVisible(true);
				} catch (AlunoNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAtualizar.setBounds(335, 227, 89, 23);
		contentPane.add(btnAtualizar);

		JLabel lblNome_1 = new JLabel("Nome:");
		lblNome_1.setBounds(220, 92, 40, 14);
		contentPane.add(lblNome_1);

		textFieldNomeAtt = new JTextField();
		textFieldNomeAtt.setBounds(261, 89, 163, 20);
		contentPane.add(textFieldNomeAtt);
		textFieldNomeAtt.setColumns(10);

		JLabel lblDigiteOCpf = new JLabel("Digite o cpf do aluno:");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOCpf.setBounds(10, 11, 168, 14);
		contentPane.add(lblDigiteOCpf);

		textFieldCpfDoAluno = new JTextField();
		textFieldCpfDoAluno.setBounds(10, 36, 200, 20);
		contentPane.add(textFieldCpfDoAluno);
		textFieldCpfDoAluno.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblNomedoaluno.setText(Fachada.getInstance().consultar(textFieldCpfDoAluno.getText()).getNome());
					lblCpfdoaluno.setText(Fachada.getInstance().consultar(textFieldCpfDoAluno.getText()).getCpf());
				} catch (AlunoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnConsultar.setBounds(220, 35, 89, 23);
		contentPane.add(btnConsultar);

		JLabel lblDadosAntigos = new JLabel("Dados antigos:");
		lblDadosAntigos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosAntigos.setBounds(10, 67, 113, 14);
		contentPane.add(lblDadosAntigos);

		JLabel lblDadosAtualizados = new JLabel("Dados atualizados:");
		lblDadosAtualizados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosAtualizados.setBounds(220, 69, 134, 14);
		contentPane.add(lblDadosAtualizados);
	}
}
