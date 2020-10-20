package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Livro;
import Facade.Fachada;
import Facade.exception.livro.LivroNaoEncontradoException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class AtualizarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTituloAtt;
	private JTextField textFieldAutorAtt;
	private JTextField textFieldEstoqueAtt;
	private static AtualizarLivro instance;
	private JTextField textFieldIdDoLivro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarLivro frame = AtualizarLivro.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static AtualizarLivro getInstance() {
		if(instance == null) {
			instance = new AtualizarLivro();
		}
		return instance;
	}
	
	/**
	 * Create the frame.
	 */
	private AtualizarLivro() {
		setTitle("Atualizar Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 92, 37, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblTitulodolivro = new JLabel("TituloDoLivro");
		lblTitulodolivro.setBounds(50, 92, 160, 14);
		contentPane.add(lblTitulodolivro);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 117, 37, 14);
		contentPane.add(lblAutor);
		
		JLabel lblAutordolivro = new JLabel("AutorDoLivro");
		lblAutordolivro.setBounds(49, 117, 161, 14);
		contentPane.add(lblAutordolivro);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(10, 142, 54, 14);
		contentPane.add(lblEstoque);
		
		JLabel lblEstoquedelivros = new JLabel("EstoqueDeLivros");
		lblEstoquedelivros.setBounds(59, 142, 151, 14);
		contentPane.add(lblEstoquedelivros);
		
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
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 167, 22, 14);
		contentPane.add(lblId);
		
		JLabel lblIddolivro = new JLabel("IdDoLivro");
		lblIddolivro.setBounds(34, 167, 78, 14);
		contentPane.add(lblIddolivro);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Livro livro = new Livro(textFieldTituloAtt.getText(),textFieldAutorAtt.getText(),Integer.parseInt(textFieldEstoqueAtt.getText()),Integer.parseInt(lblIddolivro.getText()));
					Fachada.getInstance().atualizar(livro);
					JOptionPane.showMessageDialog(null, "Livro atualizado!");
					dispose();
					instance = null;
					Biblioteca.getInstance().setVisible(true);
				} catch (LivroNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (NumberFormatException e2) {
				}
			}
		});
		btnAtualizar.setBounds(335, 227, 89, 23);
		contentPane.add(btnAtualizar);
		
		JLabel lblTtulo_1 = new JLabel("T\u00EDtulo:");
		lblTtulo_1.setBounds(220, 92, 30, 14);
		contentPane.add(lblTtulo_1);
		
		textFieldTituloAtt = new JTextField();
		textFieldTituloAtt.setBounds(270, 89, 154, 20);
		contentPane.add(textFieldTituloAtt);
		textFieldTituloAtt.setColumns(10);
		
		JLabel lblAutor_1 = new JLabel("Autor:");
		lblAutor_1.setBounds(220, 117, 31, 14);
		contentPane.add(lblAutor_1);
		
		textFieldAutorAtt = new JTextField();
		textFieldAutorAtt.setBounds(270, 114, 154, 20);
		contentPane.add(textFieldAutorAtt);
		textFieldAutorAtt.setColumns(10);
		
		JLabel lblEstoque_1 = new JLabel("Estoque:");
		lblEstoque_1.setBounds(220, 142, 50, 14);
		contentPane.add(lblEstoque_1);
		
		textFieldEstoqueAtt = new JTextField();
		textFieldEstoqueAtt.setBounds(270, 139, 154, 20);
		contentPane.add(textFieldEstoqueAtt);
		textFieldEstoqueAtt.setColumns(10);
		
		JLabel lblDigiteOId = new JLabel("Digite o Id do livro:");
		lblDigiteOId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDigiteOId.setBounds(10, 11, 133, 14);
		contentPane.add(lblDigiteOId);
		
		textFieldIdDoLivro = new JTextField();
		textFieldIdDoLivro.setBounds(10, 36, 201, 20);
		contentPane.add(textFieldIdDoLivro);
		textFieldIdDoLivro.setColumns(10);
		
		JLabel lblDadosAntigos = new JLabel("Dados antigos:");
		lblDadosAntigos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosAntigos.setBounds(10, 67, 102, 14);
		contentPane.add(lblDadosAntigos);
		
		JLabel lblDadosAtualizados = new JLabel("Dados atualizados:");
		lblDadosAtualizados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosAtualizados.setBounds(220, 67, 145, 14);
		contentPane.add(lblDadosAtualizados);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblTitulodolivro.setText(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getTitulo());
					lblAutordolivro.setText(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getAutor());
					lblEstoquedelivros.setText(String.valueOf(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getEstoque()));
					lblIddolivro.setText(String.valueOf(Fachada.getInstance().consultarLivro(Integer.parseInt(textFieldIdDoLivro.getText())).getId()));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite um número inteiro!");
				} catch (LivroNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConsultar.setBounds(220, 35, 89, 23);
		contentPane.add(btnConsultar);
		
	}
}
