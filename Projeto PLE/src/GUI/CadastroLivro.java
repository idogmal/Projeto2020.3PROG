package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Livro;
import Facade.Fachada;
import Facade.exception.livro.LivroJaExisteException;
import Facade.exception.livro.LivroNuloException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldEstoque;
	private static CadastroLivro instance;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLivro frame = CadastroLivro.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static CadastroLivro getInstance() {
		if(instance == null) {
			instance = new CadastroLivro();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private CadastroLivro() {
		setTitle("Cadastro Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(124, 94, 46, 14);
		contentPane.add(lblTtulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(174, 91, 124, 20);
		contentPane.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(124, 119, 51, 14);
		contentPane.add(lblAutor);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(174, 116, 124, 20);
		contentPane.add(textFieldAutor);
		textFieldAutor.setColumns(10);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(124, 144, 51, 14);
		contentPane.add(lblEstoque);
		
		textFieldEstoque = new JTextField();
		textFieldEstoque.setBounds(174, 141, 124, 20);
		contentPane.add(textFieldEstoque);
		textFieldEstoque.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Livro livro = new Livro(textFieldTitulo.getText(),textFieldAutor.getText(),Integer.parseInt(textFieldEstoque.getText()),Integer.parseInt(textFieldId.getText()));
					Fachada.getInstance().cadastrar(livro);
					JOptionPane.showMessageDialog(null, "Livro cadastrado!");
					dispose();
					instance = null;
					Biblioteca.getInstance().setVisible(true);
				} catch (LivroJaExisteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (LivroNuloException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (NumberFormatException e) {
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
		
		JLabel lblDigiteOTtulo = new JLabel("Digite o t\u00EDtulo, autor, quantidade em estoque e Id para cadastrar o livro:");
		lblDigiteOTtulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOTtulo.setBounds(10, 30, 424, 14);
		contentPane.add(lblDigiteOTtulo);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(124, 169, 46, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(174, 166, 124, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
	}
}
