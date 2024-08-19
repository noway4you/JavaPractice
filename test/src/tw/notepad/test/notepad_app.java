package tw.notepad.test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.text.BadLocationException;

public class notepad_app extends JFrame{
		
		private JLabel detailsOfFile;
		private JPanel bottomPanel;
		private JMenuBar menuBar;
		private JMenu file;
		private JMenu edit;
		private JMenu format;
		private JMenuItem newdoc;
		private JMenuItem open;
		private JMenuItem save;
		private JMenuItem print;
		private JMenuItem exit;
		private JMenuItem undo;
		private JMenuItem redo;
		private JMenuItem selectall;
		private JMenuItem fontfamily;
		private JMenuItem fontstyle;
		private JMenuItem fontsize;
		private JList familylist;
		private JList stylelist;
		private JList sizelist;
		private JTextArea area;
		private JScrollPane scpane;
		private String text;
		private JList fontSizeList;
		private JList fontFamilyList;
		private JList fontStyleList;
		private Font newFont;
		private LinkedList<String> save_area;
		private LinkedList<String> recycle_area;
		
		private String fontFamilyValues[] = {"Agency FB", "Antiqua", "Architect", "Arial", "Calibri", "Comic Sans", "Courier", "Cursive", "Impact", "Serif"};
		private String fontSizeValues[] = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70"};
		private int[] stylevalue = {Font.PLAIN, Font.BOLD, Font.ITALIC};
		private String[] fontStyleValues = {"PLAIN", "BOLD", "ITALIC"};
		private String fontFamily, fontSize;
		private int fstyle;
		private int fsize = 17;
		private int cl;
		private int linecount;
		private JScrollPane sp;
		
		public notepad_app() {
			super("Notepad");
			
			detailsOfFile = new JLabel();
			bottomPanel = new JPanel();
		    menuBar = new JMenuBar();
		    file = new JMenu("File");
		    newdoc = new JMenuItem("New");
		    open = new JMenuItem("Open");
		    save = new JMenuItem("Save");
		    print = new JMenuItem("Print");
		    exit = new JMenuItem("Exit");
		    edit = new JMenu("Edit");
		    undo = new JMenuItem("Undo");
		    redo = new JMenuItem("Redo");
		    selectall = new JMenuItem("Select All");
		    format = new JMenu("Format");
		    fontfamily = new JMenuItem("Font Family");
		    fontstyle = new JMenuItem("Font Style");
		    fontsize = new JMenuItem("Font Size");
		    familylist = new JList();
		    stylelist = new JList();
		    sizelist = new JList();
		    fontSizeList = new JList(fontSizeValues);
			fontFamilyList = new JList(fontFamilyValues);
			fontStyleList = new JList(fontStyleValues);
		    area = new JTextArea();
		    sp = new JScrollPane(area);
		    save_area = new LinkedList<String>();
		    recycle_area = new LinkedList<String>();
		    
		    newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		    open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		    save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		    print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		    exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		    selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		    
		    familylist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    sizelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    stylelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    
		    area.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		    area.setLineWrap(true);
		    area.setWrapStyleWord(true);
		    sp.setBorder(BorderFactory.createEmptyBorder());
		    
		    menuBar.add(file);
		    menuBar.add(edit);
		    menuBar.add(format);

		    file.add(newdoc);
		    file.add(open);
		    file.add(save);
		    file.add(print);
		    file.add(exit);

		    edit.add(undo);
		    edit.add(redo);
		    edit.add(selectall);

		    format.add(fontfamily);
		    format.add(fontstyle);
		    format.add(fontsize);
		    
		    bottomPanel.add(detailsOfFile);
		    
		    setSize(800,800);
		    setJMenuBar(menuBar);
		    setLayout(new BorderLayout());
		    add(sp, BorderLayout.CENTER);
		    add(bottomPanel, BorderLayout.SOUTH);
		    setVisible(true);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    
		    initEvent();
		}
		
		private void initEvent() {
			newdoc.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					area.setText("");
				}
			});
	        save.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser jfc = new JFileChooser();
					if (jfc.showSaveDialog(area) == JFileChooser.APPROVE_OPTION) {
						File file = jfc.getSelectedFile();
						BufferedWriter outfile = null;
						try {
							outfile = new BufferedWriter(new FileWriter(file));
							area.write(outfile);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Open Failure");
						}
					}
				}
			});
	        open.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser jfc = new JFileChooser();
					if (jfc.showSaveDialog(area) == JFileChooser.APPROVE_OPTION) {
						File file = jfc.getSelectedFile();
						try {
							FileReader reader = new FileReader(file);
							BufferedReader br = new BufferedReader(reader);
							area.read(br,null);
							br.close();
							area.requestFocus();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Open Failure");
						}
					}
				}
			});
	        undo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					recycle_area.add(area.getText());
					area.replaceRange(save_area.peekLast(),0,area.getText().length());
				}
			});
	        redo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					area.replaceRange(recycle_area.peekLast(),0,area.getText().length());
					recycle_area.add(save_area.removeLast());
				}
			});
	        selectall.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					area.selectAll();
				}
			});
	        print.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						area.print();
					} catch (PrinterException e1) {
						JOptionPane.showMessageDialog(null,"Print Failure");
					}
				}
			});
	        exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
	        fontfamily.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showConfirmDialog(null, fontFamilyList, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		            fontFamily = String.valueOf(fontFamilyList.getSelectedValue());
					newFont = new Font(fontFamily,fstyle,fsize);
		            area.setFont(newFont);
				}
			});
	        fontsize.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showConfirmDialog(null,fontSizeList,"Choose Font Size",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					if(fontSizeList.getSelectedValue()!=null) {
						fontSize = String.valueOf((fontSizeList.getSelectedValue()));
			            fsize = Integer.parseInt(fontSize);
						newFont = new Font(fontFamily,fstyle,fsize);
						area.setFont(newFont);
					}
				}
			});
	        fontstyle.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showConfirmDialog(null,fontStyleList,"Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					if(fontStyleList.getSelectedIndex()!=-1) {
						fstyle = stylevalue[fontStyleList.getSelectedIndex()];
			            newFont = new Font(fontFamily, fstyle, fsize);
			            area.setFont(newFont);
					}
				}
			});
	        area.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					cl = area.getText().length();
			        linecount = area.getLineCount();
			        detailsOfFile.setText("Length: " + cl + " Line: " + linecount);
			        save_area.add(area.getText());
				}
			});
		}
		
		public static void main(String[] args) {
			new notepad_app();
		}
}
