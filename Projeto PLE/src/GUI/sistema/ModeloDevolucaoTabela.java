package GUI.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidades.Devolucao;
import Entidades.Livro;

public class ModeloDevolucaoTabela extends AbstractTableModel{
			
			//TABELA PARA CLIENTE VISUALIZAR EXERCICIOS
					private ArrayList<Devolucao> dataList = new ArrayList<Devolucao>();
					private String[] columns={"Aluno", "Funcionário", "Itens", "Data de Devolução", "Multa"};
					Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class};
					boolean[] columnEditables = new boolean[] {false, false, false, false, false};

					
					public Class getColumnCount(int columnIndex) {
						
						return columnTypes[columnIndex];
					}
					
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
					
					public ModeloDevolucaoTabela() {
						
					}
					
					public ModeloDevolucaoTabela(List d) {
						dataList.addAll(d);
					} 
					
					public void addLivro(Devolucao devolucao) {
						dataList.add(devolucao);
						fireTableDataChanged();
					}
					
					public void addDevolucaoList(List d) {
						dataList.addAll(d);
						fireTableDataChanged();
					}
					
					public Devolucao getDeolvucaoAt(int row) {
						return dataList.get(row);
					}
					
					public int getDevolucaoAt(Devolucao devolucao){
						return dataList.lastIndexOf(devolucao);
					}
					
					public Devolucao removeDevolucaoAt(int row) {
						Devolucao d;
						d = dataList.remove(row);
						fireTableDataChanged();
						return d;
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
						Devolucao d = dataList.get(row);
						switch(col) {
						case 0:
							return d.getAluno().getNome();
						case 1:
							return d.getFuncionario().getNome();
						case 2:
							return d.getItens();
						case 3:
							return d.getDataDevolucao();
						case 4:
							return d.getMulta();
						default:
							return null;
						}
						
					}

		}


