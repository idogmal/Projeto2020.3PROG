package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entidades.Item;
import Entidades.Livro;
import Facade.Fachada;
import Facade.exception.item.ItemNuloException;
import Facade.exception.livro.LivroNaoEmprestavelException;
import Repositorio.RepositorioLivrosArray;

public class CadastroItem extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldQuantidade;
	private JComboBox<Livro> comboBoxLivros;
	private static CadastroItem instance;
    protected static Item itemCriado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroItem frame = CadastroItem.getInstance();
					itemCriado = null;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static CadastroItem getInstance() {
		if (instance == null) {
			instance = new CadastroItem();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private CadastroItem() {
		setTitle("Cadastro item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxLivros = new JComboBox<Livro>();
		comboBoxLivros.setBounds(110, 95, 240, 20);
		contentPane.add(comboBoxLivros);
		
		carregarComboBox();
		
		JLabel lblLivro = new JLabel("Livro:");
		lblLivro.setBounds(76, 98, 46, 14);
		contentPane.add(lblLivro);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(76, 126, 70, 14);
		contentPane.add(lblQuantidade);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setBounds(144, 123, 145, 20);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				instance = null;
				CadastroEmprestimo.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 228, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = new Item((Livro) comboBoxLivros.getSelectedItem(), Integer.parseInt(textFieldQuantidade.getText()));
				itemCriado = item;
				try {
					Fachada.getInstance().consultarEstoque(item);
					Fachada.getInstance().cadastrar(item);
					JOptionPane.showMessageDialog(null, "Item cadastrado!");
					CadastroEmprestimo.vezes = 0;
					setVisible(false);
					CadastroEmprestimo.getInstance().setVisible(true);
				} catch (ItemNuloException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (LivroNaoEmprestavelException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnOk.setBounds(335, 228, 89, 23);
		contentPane.add(btnOk);
		
		JLabel lblSelecioneOLivro = new JLabel("Selecione o livro e indique a quantidade para o empr\u00E9stimo:");
		lblSelecioneOLivro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelecioneOLivro.setBounds(45, 33, 379, 14);
		contentPane.add(lblSelecioneOLivro);
		
	}
	
	private void carregarComboBox(){
		ArrayList<Livro> livros = new ArrayList<Livro>();
		livros = Fachada.getInstance().listarLivros();
		for(Livro lvr : livros){
			comboBoxLivros.addItem(lvr);
		}
	}
	
}
