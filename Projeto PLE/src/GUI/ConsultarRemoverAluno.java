package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facade.Fachada;
import Facade.exception.aluno.AlunoNaoEncontradoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class ConsultarRemoverAluno extends JFrame {

	private JPanel contentPane;
	private static ConsultarRemoverAluno instance;
	private JTextField textFieldCpfDoAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRemoverAluno frame = ConsultarRemoverAluno.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static ConsultarRemoverAluno getInstance() {
		if (instance == null) {
			instance = new ConsultarRemoverAluno();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private ConsultarRemoverAluno() {
		setTitle("Consultar Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCpfDoAluno = new JLabel("Digite o cpf do aluno:");
		lblCpfDoAluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpfDoAluno.setBounds(10, 11, 156, 14);
		contentPane.add(lblCpfDoAluno);

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

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 92, 40, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(10, 117, 30, 14);
		contentPane.add(lblCpf);

		JLabel lblNomedoaluno = new JLabel("NomeDoAluno");
		lblNomedoaluno.setBounds(51, 92, 336, 14);
		contentPane.add(lblNomedoaluno);

		JLabel lblCpfdoaluno = new JLabel("CpfDoAluno");
		lblCpfdoaluno.setBounds(41, 117, 169, 14);
		contentPane.add(lblCpfdoaluno);
		
		textFieldCpfDoAluno = new JTextField();
		textFieldCpfDoAluno.setBounds(10, 36, 200, 20);
		contentPane.add(textFieldCpfDoAluno);
		textFieldCpfDoAluno.setColumns(10);
		
		JLabel lblDadosDoAluno = new JLabel("Dados do Aluno:");
		lblDadosDoAluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosDoAluno.setBounds(10, 67, 156, 14);
		contentPane.add(lblDadosDoAluno);
		
		JButton btnConsultar_1 = new JButton("Consultar");
		btnConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblNomedoaluno.setText(Fachada.getInstance().consultar(textFieldCpfDoAluno.getText()).getNome());
					lblCpfdoaluno.setText(Fachada.getInstance().consultar(textFieldCpfDoAluno.getText()).getCpf());
				} catch (AlunoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnConsultar_1.setBounds(220, 35, 89, 23);
		contentPane.add(btnConsultar_1);
		
		if (Biblioteca.flag == false) {
			setTitle("Remover Aluno");
			JButton btnRemover = new JButton("Remover");
			btnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Fachada.getInstance().remover(lblCpfdoaluno.getText());
						JOptionPane.showMessageDialog(null, "Aluno removido!");
					} catch (AlunoNaoEncontradoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			});
			btnRemover.setBounds(335, 227, 89, 23);
			contentPane.add(btnRemover);
		}
	}
}
