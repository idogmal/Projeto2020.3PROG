package GUI.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidades.Funcionario;
import Entidades.Livro;

public class ModeloFuncionarioTabela extends AbstractTableModel{
			
			//TABELA PARA CLIENTE VISUALIZAR EXERCICIOS
					private ArrayList<Funcionario> dataList = new ArrayList<Funcionario>();
					private String[] columns={"Nome", "Cpf", "Senha"};
					Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class};
					boolean[] columnEditables = new boolean[] {false, false, false};

					
					public Class getColumnCount(int columnIndex) {
						
						return columnTypes[columnIndex];
					}
					
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
					
					public ModeloFuncionarioTabela() {
						
					}
					
					public ModeloFuncionarioTabela(List f) {
						dataList.addAll(f);
					} 
					
					public void addLivro(Funcionario funcionario) {
						dataList.add(funcionario);
						fireTableDataChanged();
					}
					
					public void addFuncionarioList(List f) {
						dataList.addAll(f);
						fireTableDataChanged();
					}
					
					public Funcionario getFuncionarioAt(int row) {
						return dataList.get(row);
					}
					
					public int getFuncionarioAt(Livro livro){
						return dataList.lastIndexOf(livro);
					}
					
					public Funcionario removeFuncionarioAt(int row) {
						Funcionario f;
						f = dataList.remove(row);
						fireTableDataChanged();
						return f;
					}
					
					public void onRemoveAll() {
				        dataList.clear();
				        fireTableDataChanged();
					}

					@Override
					public int getRowCount() {
						
						return dataList.size();
					}
					
					public int getColumnCount() {
						return columns.length;
					}

					public String getColumnName(int col) {
						return columns[col];
					}

					@Override
					public Object getValueAt(int row, int col) {
						Funcionario f = dataList.get(row);
						switch(col) {
						case 0:
							return f.getNome();
						case 1:
							return f.getCpf();
						case 2:
							return f.getSenha();
						default:
							return null;
						}
						
					}

		}

