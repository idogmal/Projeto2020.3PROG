package GUI.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidades.Emprestimo;



public class ModeloEmprestimoTabela extends AbstractTableModel{
			
			//TABELA PARA CLIENTE VISUALIZAR EXERCICIOS
					private ArrayList<Emprestimo> dataList = new ArrayList<Emprestimo>();
					private String[] columns={"Aluno", "Funcionário", "Itens", "Data de empréstimo", "Situação"};
					Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class};
					boolean[] columnEditables = new boolean[] {false, false, false, false, false};

					
					public Class getColumnCount(int columnIndex) {
						
						return columnTypes[columnIndex];
					}
					
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
					
					public ModeloEmprestimoTabela() {
						
					}
					
					public ModeloEmprestimoTabela(List e) {
						dataList.addAll(e);
					} 
					
					public void addEmprestimo(Emprestimo emprestimo) {
						dataList.add(emprestimo);
						fireTableDataChanged();
					}
					
					public void addEmprestimoList(List e) {
						dataList.addAll(e);
						fireTableDataChanged();
					}
					
					public Emprestimo getEmprestimoAt(int row) {
						return dataList.get(row);
					}
					
					public int getEmprestimoAt(Emprestimo emprestimo){
						return dataList.lastIndexOf(emprestimo);
					}
					
					public Emprestimo removeEmprestimoAt(int row) {
						Emprestimo e;
						e = dataList.remove(row);
						fireTableDataChanged();
						return e;
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
						Emprestimo e = dataList.get(row);
						switch(col) {
						case 0:
							return e.getAluno().getNome();
						case 1:
							return e.getFuncionario().getNome();
						case 2:
							return e.getItens().toString();
						case 3:
							return e.getDataEmpretimo();
						case 4:
							return e.isDevolvido();
						default:
							return null;
						}
						
					}

		}


