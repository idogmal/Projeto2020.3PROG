package GUI.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidades.Aluno;
import Entidades.Livro;

public class ModeloAlunoTabela extends AbstractTableModel{
			
			//TABELA PARA CLIENTE VISUALIZAR EXERCICIOS
					private ArrayList<Aluno> dataList = new ArrayList<Aluno>();
					private String[] columns={"Nome", "Cpf"};
					Class[] columnTypes = new Class[] { Object.class, Object.class};
					boolean[] columnEditables = new boolean[] {false, false};

					
					public Class getColumnCount(int columnIndex) {
						
						return columnTypes[columnIndex];
					}
					
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
					
					public ModeloAlunoTabela() {
						
					}
					
					public ModeloAlunoTabela(List a) {
						dataList.addAll(a);
					} 
					
					public void addAluno(Aluno aluno) {
						dataList.add(aluno);
						fireTableDataChanged();
					}
					
					public void addAlunoList(List a) {
						dataList.addAll(a);
						fireTableDataChanged();
					}
					
					public Aluno getAlunoAt(int row) {
						return dataList.get(row);
					}
					
					public int getAlunoAt(Aluno aluno){
						return dataList.lastIndexOf(aluno);
					}
					
					public Aluno removeLivroAt(int row) {
						Aluno a;
						a = dataList.remove(row);
						fireTableDataChanged();
						return a;
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
						Aluno a = dataList.get(row);
						switch(col) {
						case 0:
							return a.getNome();
						case 1:
							return a.getCpf();
						default:
							return null;
						}
						
					}

		}

