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
import GUI.sistema.ModeloFuncionarioTabela;
import GUI.sistema.ModeloLivroTabela;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarFuncionario extends JFrame {

	private JPanel contentPane;
	private static ListarFuncionario instance;
	private ModeloFuncionarioTabela modeloFuncionario;
	private JTable tableFuncionario;
	private JLabel lblListaDeFuncionarios;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFuncionario frame = ListarFuncionario.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static ListarFuncionario getInstance() {
		if(instance == null) {
			instance = new ListarFuncionario();
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	public ListarFuncionario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		modeloFuncionario = new ModeloFuncionarioTabela();
		tableFuncionario = new JTable(modeloFuncionario);
		tableFuncionario.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableFuncionario.setBounds(68, 163, 100, 30);
		tableFuncionario.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableFuncionario.setFillsViewportHeight(true);
		
		while(modeloFuncionario.getRowCount()>0) {
			modeloFuncionario.removeFuncionarioAt(0);
		}
		
		modeloFuncionario.addFuncionarioList(Fachada.getInstance().listarFuncionarios());
		contentPane.setLayout(null);

		JScrollPane scrollPaneLivro = new JScrollPane(tableFuncionario);
		scrollPaneLivro.setBounds(5, 32, 424, 140);
		contentPane.add(scrollPaneLivro);
		
		lblListaDeFuncionarios = new JLabel("Lista de funcionarios cadastrados:");
		lblListaDeFuncionarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeFuncionarios.setBounds(5, 11, 232, 14);
		contentPane.add(lblListaDeFuncionarios);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				instance = null;
				Biblioteca.getInstance().setVisible(true);
			}
		});
		btnVoltar.setBounds(5, 228, 89, 23);
		contentPane.add(btnVoltar);
	}

}
