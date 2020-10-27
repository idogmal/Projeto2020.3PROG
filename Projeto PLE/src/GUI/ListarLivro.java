package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Facade.Fachada;
import GUI.sistema.ModeloLivroTabela;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarLivro extends JFrame {

	private JPanel contentPane;
	private ModeloLivroTabela modeloLivro;
	private JTable tableLivro;
	private static ListarLivro instance;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarLivro frame = ListarLivro.getInstance();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static ListarLivro getInstance() {
		if(instance == null) {
			instance = new ListarLivro();
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	private ListarLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modeloLivro = new ModeloLivroTabela();
		tableLivro = new JTable(modeloLivro);
		tableLivro.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableLivro.setBounds(68, 163, 100, 30);
		tableLivro.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableLivro.setFillsViewportHeight(true);
		
		while(modeloLivro.getRowCount()>0) {
			modeloLivro.removeLivroAt(0);
		}
		
		modeloLivro.addLivroList(Fachada.getInstance().listarLivros());

		JScrollPane scrollPaneLivro = new JScrollPane(tableLivro);
		scrollPaneLivro.setBounds(10, 64, 458, 131);
		contentPane.add(scrollPaneLivro);
		
		JLabel lblListaDeLivros = new JLabel("Lista de livros no estoque:");
		lblListaDeLivros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeLivros.setBounds(10, 11, 256, 14);
		contentPane.add(lblListaDeLivros);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				instance = null;
				Biblioteca.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 267, 89, 23);
		contentPane.add(btnVoltar);
	}
}
