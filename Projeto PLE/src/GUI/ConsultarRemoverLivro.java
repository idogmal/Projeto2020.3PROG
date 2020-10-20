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
import Facade.exception.livro.LivroNaoEncontradoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class ConsultarRemoverLivro extends JFrame {

	private JPanel contentPane;
	private static ConsultarRemoverLivro instance;
	private JTextField textFieldIdDoLivro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRemoverLivro frame = ConsultarRemoverLivro.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ConsultarRemoverLivro getInstance() {
		if(instance == null) {
			instance = new ConsultarRemoverLivro();
		}
		return instance;
	}
	
	/**
	 * Create the frame.
	 */
	private ConsultarRemoverLivro() {
		setTitle("Consultar Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setBounds(10, 89, 43, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblTitulodolivro = new JLabel("T\u00EDtuloDoLivro");
		lblTitulodolivro.setBounds(50, 89, 319, 14);
		contentPane.add(lblTitulodolivro);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 114, 37, 14);
		contentPane.add(lblAutor);
		
		JLabel lblAutordolivro = new JLabel("AutorDoLivro");
		lblAutordolivro.setBounds(50, 114, 294, 14);
		contentPane.add(lblAutordolivro);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(10, 137, 53, 14);
		contentPane.add(lblEstoque);
		
		JLabel lblEstoquedelivros = new JLabel("Estoquedelivros");
		lblEstoquedelivros.setBounds(60, 137, 309, 14);
		contentPane.add(lblEstoquedelivros);
		
		JLabel lblDigiteOId = new JLabel("Digite o Id do livro:");
		lblDigiteOId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOId.setBounds(10, 11, 159, 14);
		contentPane.add(lblDigiteOId);
		
		textFieldIdDoLivro = new JTextField();
		textFieldIdDoLivro.setBounds(10, 36, 200, 20);
		contentPane.add(textFieldIdDoLivro);
		textFieldIdDoLivro.setColumns(10);
		
		JLabel lblDadosDoLivro = new JLabel("Dados do livro:");
		lblDadosDoLivro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosDoLivro.setBounds(10, 64, 108, 14);
		contentPane.add(lblDadosDoLivro);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 162, 24, 14);
		contentPane.add(lblId);
		
		JLabel lblIddolivro = new JLabel("IdDoLivro");
		lblIddolivro.setBounds(34, 162, 275, 14);
		contentPane.add(lblIddolivro);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblTitulodolivro.setText(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getTitulo());
					lblAutordolivro.setText(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getAutor());
					lblEstoquedelivros.setText(String.valueOf(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getEstoque()));
					lblIddolivro.setText(String.valueOf(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getId()));
				} catch (NumberFormatException e1) {
				//	JOptionPane.showMessageDialog(null, "Digite um número inteiro!");
				} catch (LivroNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConsultar.setBounds(220, 35, 89, 23);
		contentPane.add(btnConsultar);
		
		if (Biblioteca.flag == false) {
			setTitle("Remover Livro");
			JButton btnRemover = new JButton("Remover");
			btnRemover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						try {
							Fachada.getInstance().removerLivros(Integer.parseInt(lblIddolivro.getText()));
							JOptionPane.showMessageDialog(null, "Livro removido!");
							dispose();
							instance = null;
							Biblioteca.getInstance().setVisible(true);
						} catch (NumberFormatException e) {
						//	JOptionPane.showMessageDialog(null, e.getMessage());
						} catch (LivroNaoEncontradoException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					
				}
			});
			btnRemover.setBounds(335, 227, 89, 23);
			contentPane.add(btnRemover);
		}
	}
}
