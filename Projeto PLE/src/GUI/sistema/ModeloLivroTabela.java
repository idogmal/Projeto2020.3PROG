package GUI.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Entidades.Livro;


public class ModeloLivroTabela extends AbstractTableModel{
		
		//TABELA PARA CLIENTE VISUALIZAR EXERCICIOS
				private ArrayList<Livro> dataList = new ArrayList<Livro>();
				private String[] columns={"Título", "Autor", "Estoque", "Id"};
				Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class};
				boolean[] columnEditables = new boolean[] {false, false, false, false};

				
				public Class getColumnCount(int columnIndex) {
					
					return columnTypes[columnIndex];
				}
				
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
				
				public ModeloLivroTabela() {
					
				}
				
				public ModeloLivroTabela(List l) {
					dataList.addAll(l);
				} 
				
				public void addLivro(Livro livro) {
					dataList.add(livro);
					fireTableDataChanged();
				}
				
				public void addLivroList(List l) {
					dataList.addAll(l);
					fireTableDataChanged();
				}
				
				public Livro getLivroAt(int row) {
					return dataList.get(row);
				}
				
				public int getLivroAt(Livro livro){
					return dataList.lastIndexOf(livro);
				}
				
				public Livro removeLivroAt(int row) {
					Livro l;
					l = dataList.remove(row);
					fireTableDataChanged();
					return l;
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
					Livro l = dataList.get(row);
					switch(col) {
					case 0:
						return l.getTitulo();
					case 1:
						return l.getAutor();
					case 2:
						return l.getEstoque();
					case 3:
						return l.getId();
					default:
						return null;
					}
					
				}

	}

