package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Facade.Fachada;
import GUI.sistema.ModeloEmprestimoTabela;
import GUI.sistema.ModeloLivroTabela;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarEmprestimo extends JFrame {

	private JPanel contentPane;
	private ModeloEmprestimoTabela modeloEmprestimo;
	private JTable tableEmprestimo;
	private static ListarEmprestimo instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarEmprestimo frame = ListarEmprestimo.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static ListarEmprestimo getInstance() {
		if(instance == null) {
			instance = new ListarEmprestimo();
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	private ListarEmprestimo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		modeloEmprestimo = new ModeloEmprestimoTabela();
		tableEmprestimo = new JTable(modeloEmprestimo);
		tableEmprestimo.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableEmprestimo.setBounds(68, 163, 100, 30);
		tableEmprestimo.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableEmprestimo.setFillsViewportHeight(true);
		
		while(modeloEmprestimo.getRowCount()>0) {
			modeloEmprestimo.removeEmprestimoAt(0);
		}
		
		modeloEmprestimo.addEmprestimoList(Fachada.getInstance().listarEmprestimos());
		contentPane.setLayout(null);

		JScrollPane scrollPaneLivro = new JScrollPane(tableEmprestimo);
		scrollPaneLivro.setBounds(5, 42, 424, 135);
		contentPane.add(scrollPaneLivro);
		
		JLabel lblListaDeEmprestimos = new JLabel("Lista de emprestimos:");
		lblListaDeEmprestimos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeEmprestimos.setBounds(10, 11, 182, 14);
		contentPane.add(lblListaDeEmprestimos);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				instance = null;
				Biblioteca.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(5, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		
	}
}
