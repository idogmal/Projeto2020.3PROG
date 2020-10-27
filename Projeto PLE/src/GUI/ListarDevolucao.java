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
import GUI.sistema.ModeloDevolucaoTabela;
import GUI.sistema.ModeloLivroTabela;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarDevolucao extends JFrame {

	private JPanel contentPane;
	private ModeloDevolucaoTabela modeloDevolucao;
	private JTable tableDevolucao;
	private static ListarDevolucao instance;
	private JLabel lblListaDeDevolues;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarDevolucao frame = ListarDevolucao.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public static ListarDevolucao getInstance() {
		if(instance == null) {
			instance = new ListarDevolucao();
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	private ListarDevolucao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		modeloDevolucao = new ModeloDevolucaoTabela();
		tableDevolucao = new JTable(modeloDevolucao);
		tableDevolucao.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableDevolucao.setBounds(68, 163, 100, 30);
		tableDevolucao.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableDevolucao.setFillsViewportHeight(true);
		
		while(modeloDevolucao.getRowCount()>0) {
			modeloDevolucao.removeDevolucaoAt(0);
		}
		
		modeloDevolucao.addDevolucaoList(Fachada.getInstance().listarDevolucao());
		contentPane.setLayout(null);

		JScrollPane scrollPaneLivro = new JScrollPane(tableDevolucao);
		scrollPaneLivro.setBounds(5, 46, 424, 129);
		contentPane.add(scrollPaneLivro);
		
		lblListaDeDevolues = new JLabel("Lista de Devolu\u00E7\u00F5es:");
		lblListaDeDevolues.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeDevolues.setBounds(10, 11, 237, 14);
		contentPane.add(lblListaDeDevolues);
		
		btnVoltar = new JButton("Voltar");
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
