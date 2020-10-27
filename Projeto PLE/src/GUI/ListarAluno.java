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
import GUI.sistema.ModeloAlunoTabela;
import GUI.sistema.ModeloLivroTabela;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarAluno extends JFrame {

	private JPanel contentPane;
	private static ListarAluno instance;
	private ModeloAlunoTabela modeloAluno;
	private JTable tableAluno;
	private JLabel lblListaDeAlunos;
	private JButton btnVoltar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarAluno frame = ListarAluno.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ListarAluno getInstance() {
		if(instance == null) {
			instance = new ListarAluno();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 */
	private ListarAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		modeloAluno = new ModeloAlunoTabela();
		tableAluno = new JTable(modeloAluno);
		tableAluno.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableAluno.setBounds(68, 163, 100, 30);
		tableAluno.setPreferredScrollableViewportSize(new Dimension(300, 50));
		tableAluno.setFillsViewportHeight(true);
		
		while(modeloAluno.getRowCount()>0) {
			modeloAluno.removeLivroAt(0);
		}
		
		modeloAluno.addAlunoList(Fachada.getInstance().listar());
		contentPane.setLayout(null);

		JScrollPane scrollPaneLivro = new JScrollPane(tableAluno);
		scrollPaneLivro.setBounds(5, 36, 424, 136);
		contentPane.add(scrollPaneLivro);
		
		lblListaDeAlunos = new JLabel("Lista de alunos cadastrados:");
		lblListaDeAlunos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeAlunos.setBounds(5, 11, 240, 14);
		contentPane.add(lblListaDeAlunos);
		
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
