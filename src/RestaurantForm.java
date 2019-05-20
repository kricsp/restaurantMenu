import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.eclipse.persistence.internal.libraries.asm.commons.StaticInitMerger;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;

public class RestaurantForm {

	private JFrame frame,frame2,frame3, frame4, frame5, frame6, frame7;
	private JPanel jPanel,jPanel2,jPanel3,jPanel4, jPanel5, jPanel6;
	private JTable jTable, jTable2, jTable3;
	private JList<String> jList1,jList2;
	DefaultTableModel dtm, dtm2,dtm3;
	JTextPane jTextPane, jTextPane2, jTextPane3;
	JLabel jFrame2Label1,jFrame2Label2,jFrame2Label3,jFrame3Label1,jFrame3Label2,jFrame3Label3,jFrame3Label4,jFrame3Label5,jFrame3Label6;
	JScrollPane jScrollPane, jScrollPane2, jScrollPane3;
	private JTextField jTextField1,jTextField2,jTextField3,jTextField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantForm window = new RestaurantForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RestaurantForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 500);
		//frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton = new JButton("Add Dish");
		btnNewButton.setBounds(250, 70, 120, 30);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame3 = new JFrame("Add Dish");
				frame3.getContentPane().setLayout(null);
				jTextField1 = new JTextField();
				jTextField1.setText("Add Name");
				jTextField1.setBounds(105, 30, 146, 26);
				frame3.getContentPane().add(jTextField1);
				jTextField1.setColumns(10);
				jTextField2 = new JTextField();
				jTextField2.setText("Add Description");
				jTextField2.setBounds(170, 60, 300, 26);
				frame3.getContentPane().add(jTextField2);
				jTextField2.setColumns(10);
				jTextField3 = new JTextField();
				jTextField3.setText("Add Add Ons");
				jTextField3.setBounds(105, 90, 250, 26);
				frame3.getContentPane().add(jTextField3);
				jTextField3.setColumns(10);
				jTextField4 = new JTextField();
				jTextField4.setText("0");
				jTextField4.setBounds(105, 130, 300, 26);
				frame3.getContentPane().add(jTextField4);
				jTextField4.setColumns(10);
				jFrame3Label1 = new JLabel("Name:");
				jFrame3Label1.setBounds(30, 30, 69, 20);
				frame3.getContentPane().add(jFrame3Label1);
				jFrame3Label2 = new JLabel("Description:");
				jFrame3Label2.setBounds(30, 60, 130, 20);
				frame3.getContentPane().add(jFrame3Label2);
				jFrame3Label3 = new JLabel("Add Ons:");
				jFrame3Label3.setBounds(30, 90, 69, 20);
				frame3.getContentPane().add(jFrame3Label3);
				jFrame3Label4 = new JLabel("Price:");
				jFrame3Label4.setBounds(30, 120, 69, 20);
				frame3.getContentPane().add(jFrame3Label4);
				jFrame3Label5 = new JLabel("Quantity:");
				jFrame3Label5.setBounds(30, 160, 100, 20);
				frame3.getContentPane().add(jFrame3Label5);
				jFrame3Label6 = new JLabel("Time:");
				jFrame3Label6.setBounds(30, 300, 69, 20);
				frame3.getContentPane().add(jFrame3Label6);
				
				DefaultListModel<String> listModel1 = new DefaultListModel<>();
				listModel1.addElement("Small");
				listModel1.addElement("Medium");
				listModel1.addElement("Large");
				
				DefaultListModel<String> listModel2 = new DefaultListModel<>();
				listModel2.addElement("Breakfast");
				listModel2.addElement("Lunch");
				listModel2.addElement("Dinner");
				
				jList1 = new JList<>(listModel1);
				jList2 = new JList<>(listModel2);
				jList1.setBounds(135, 160, 80, 70);
				frame3.getContentPane().add(jList1);
				jList2.setBounds(105, 300, 100, 70);
				frame3.getContentPane().add(jList2);
				
				
				JButton submitButton = new JButton("Submit");
				submitButton.setBounds(30, 400, 120, 30);
				submitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Dish dish=new Dish();
						dish.setName(jTextField1.getText());
						dish.setDescription(jTextField2.getText());
						dish.setAddon(jTextField3.getText());
						dish.setPrice(Integer.parseInt(jTextField4.getText()));
						dish.setQuantity(jList1.getSelectedValuesList().toString().replaceAll("\\[","").replaceAll("\\]", ""));
						
						for(int i=0;i<jList2.getModel().getSize();i++) {
							if(jList2.isSelectedIndex(i)) {
							if(i==0){dish.setTime("breakfast");new BreakfastMenu().add(dish);};
							if(i==1){dish.setTime("lunch");new LunchMenu().add(dish);};
							if(i==2){dish.setTime("dinner");new DinnerMenu().add(dish);};
							}
							
						}
						
						
						
						
					}
				});
				frame3.getContentPane().add(submitButton);
				
				frame3.setBounds(100, 100, 1000, 800);
				frame3.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnShowMenu = new JButton("Show Menu");
		btnShowMenu.setBounds(250, 10, 120, 30);
		btnShowMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int count=1,count2=1,count3=1;
				frame2 = new JFrame("Menu");
				BoxLayout boxLayout = new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS);
				frame2.getContentPane().setLayout(boxLayout);
				jPanel = new JPanel();
				jPanel4 = new JPanel();
				jPanel5 = new JPanel();
				jPanel6 = new JPanel();
				
				
				//jPanel.setLayout(new FlowLayout( FlowLayout.CENTER, 0, 20));
				//jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
				jPanel.setBounds(20, 20, frame2.getWidth(), frame2.getHeight()/5);
				jPanel4.setBounds(20, 50, frame2.getWidth(), frame2.getHeight()/5);
				jPanel6.setBounds(20, 80, frame2.getWidth(), frame2.getHeight()/5);
				jPanel.setLocation(0, 50);
				jPanel4.setLocation(50, 50);
				jPanel6.setLocation(100, 50);
				jTable= new JTable();
				jTable2 = new JTable();
				jTable3 = new JTable();
			
				dtm = new DefaultTableModel(0, 0);
				dtm2 = new DefaultTableModel(0, 0);
				dtm3 = new DefaultTableModel(0, 0);
				//frame2.getContentPane().add(jScrollPane);
				//frame2.getContentPane().add(new JScrollPane(jTextPane2));
				String header[] = new String[] { "Serial No.", "Name", "Description",
				            "Add Ons", "Serving Size", "Price($)" };
				dtm.setColumnIdentifiers(header);
				dtm2.setColumnIdentifiers(header);
				dtm3.setColumnIdentifiers(header);
				jTable.setModel(dtm);
				jTable2.setModel(dtm2);
				jTable3.setModel(dtm3);
				//jTable.setLocation(10, 50);
				for (Dish dish: new BreakfastMenu().getDish()) {
					dtm.addRow(new Object[] { count++, dish.getName(), dish.getDescription(), dish.getAddon(),
			                dish.getQuantity(), dish.getPrice()});
				}
				for (Dish dish: new LunchMenu().getDish()) {
					dtm2.addRow(new Object[] { count2++, dish.getName(), dish.getDescription(), dish.getAddon(),
			                dish.getQuantity(), dish.getPrice()});
				}
				for (Dish dish: new DinnerMenu().getDish()) {
					dtm3.addRow(new Object[] { count3++, dish.getName(), dish.getDescription(), dish.getAddon(),
			                dish.getQuantity(), dish.getPrice()});
				}
				jScrollPane=new JScrollPane();
				jScrollPane2=new JScrollPane();
				jScrollPane3=new JScrollPane();
				jScrollPane.setViewportView(jTable);
				jScrollPane2.setViewportView(jTable2);
				jScrollPane3.setViewportView(jTable3);
				jPanel.add(jScrollPane);
				jPanel4.add(jScrollPane2);
				jPanel6.add(jScrollPane3);
				//jPanel.setLocation(new Point(0, 30)); //setAlignmentX(30); //setBounds(100, 40, 400, 800);
				//jScrollPane.getViewport().setViewPosition(new Point(30,0));
								
				jPanel2 = new JPanel();
				jPanel3 = new JPanel();
				
				//jPanel2.setLayout(new FlowLayout( FlowLayout.LEADING , 0, 0));
				//jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
				// getContentPane().add(jPanel2);
				
				//jPanel2.setSize(20, 10);
				jFrame2Label1=new JLabel();
				jFrame2Label2=new JLabel();
				jFrame2Label3=new JLabel();
				jPanel2.setAlignmentY(0);// setBounds(0, 0, 10, 80);
				//jLabel.setSize(20, 20);
				jFrame2Label1.setText("Breakfast");
				jPanel2.add(jFrame2Label1);
				frame2.getContentPane().add(jPanel2);
				frame2.getContentPane().add(jPanel);
				jFrame2Label2.setText("Lunch");
				jPanel3.add(jFrame2Label2);
				jFrame2Label3.setText("Dinner");
				jPanel5.add(jFrame2Label3);
				frame2.getContentPane().add(jPanel3);
				frame2.getContentPane().add(jPanel4);
				frame2.getContentPane().add(jPanel5);
				frame2.getContentPane().add(jPanel6);
				frame2.setBounds(100, 100, 1000, 800);
				frame2.setVisible(true);
				
				
				//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		frame.getContentPane().add(btnShowMenu);
				
		JButton deleteDish = new JButton("Delete Dish");
		deleteDish.setBounds(250, 130, 120, 30);
		deleteDish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame4 = new JFrame("Remove Dish");
				frame4.getContentPane().setLayout(null);
				jFrame3Label5 = new JLabel("Enter the name of dish to be removed: ");
				jFrame3Label5.setBounds(105, 30, 300, 26);
				frame4.getContentPane().add(jFrame3Label5);
				jTextField1 = new JTextField();
				jTextField1.setText("Name of dish");
				jTextField1.setBounds(350, 30, 146, 26);
				frame4.getContentPane().add(jTextField1);
				jTextField1.setColumns(10);
				jFrame3Label6 = new JLabel("Select the time: ");
				jFrame3Label6.setBounds(105, 60, 300, 26);
				frame4.getContentPane().add(jFrame3Label6);
				
				
				DefaultListModel<String> listModel2 = new DefaultListModel<>();
				listModel2.addElement("Breakfast");
				listModel2.addElement("Lunch");
				listModel2.addElement("Dinner");
				
				jList2 = new JList<>(listModel2);
				jList2.setBounds(200, 60, 100, 70);
				frame4.getContentPane().add(jList2);
				
				
				JButton deleteButton = new JButton("Delete");
				deleteButton.setBounds(100, 150, 120, 30);
				deleteButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Dish dish=new Dish();
						dish.setName(jTextField1.getText());
						
						for(int i=0;i<jList2.getModel().getSize();i++) {
							if(jList2.isSelectedIndex(i)) {
							if(i==0){
								dish.setTime("breakfast");
								if(new BreakfastMenu().delete(dish)!=0) {
									frame4.revalidate();
									frame4.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 70, 120, 200);
									frame4.getContentPane().add(jFrame3Label4);
									frame4.revalidate();
									frame4.repaint();
									//frame4.pack();
								}else { 
									frame4.revalidate();
									frame4.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 70, 120, 200);
									frame4.getContentPane().add(jFrame3Label4);
									frame4.revalidate();
									frame4.repaint();
									//frame4.pack();
								}
							}
							if(i==1){
								dish.setTime("lunch");
								if(new LunchMenu().delete(dish)!=0) {
									frame4.revalidate();
									frame4.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 70, 120, 200);
									frame4.getContentPane().add(jFrame3Label4);
									frame4.revalidate();
									frame4.repaint();
								}else { 
									frame4.revalidate();
									frame4.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 70, 120, 200);
									frame4.getContentPane().add(jFrame3Label4);
									frame4.revalidate();
									frame4.repaint();
								}
							
							}
							if(i==2){
								dish.setTime("dinner");
								if(new DinnerMenu().delete(dish)!=0) {
									frame4.revalidate();
									frame4.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 70, 120, 200);
									frame4.getContentPane().add(jFrame3Label4);
									frame4.revalidate();
									frame4.repaint();
								}else { 
									frame4.revalidate();
									frame4.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 70, 120, 200);
									frame4.getContentPane().add(jFrame3Label4);
									frame4.revalidate();
									frame4.repaint();
								}
								}
							
							}
							
						}						
					}
				});
				frame4.getContentPane().add(deleteButton);
				
				
				frame4.setBounds(100, 100, 700, 300);
				frame4.setVisible(true);
			
			}
		});
		
		frame.getContentPane().add(deleteDish);
		
		
		JButton updatePrice = new JButton("Update Price");
		updatePrice.setBounds(250, 200, 120, 30);
		updatePrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame5 = new JFrame("Update Price");
				frame5.getContentPane().setLayout(null);
				jFrame3Label5 = new JLabel("Enter the name of dish to update the Price: ");
				jFrame3Label5.setBounds(105, 30, 300, 26);
				frame5.getContentPane().add(jFrame3Label5);
				jTextField1 = new JTextField();
				jTextField1.setText("Name of dish");
				jTextField1.setBounds(350, 30, 146, 26);
				frame5.getContentPane().add(jTextField1);
				jTextField1.setColumns(10);
				jFrame3Label6 = new JLabel("Select the time: ");
				jFrame3Label6.setBounds(105, 60, 300, 26);
				frame5.getContentPane().add(jFrame3Label6);
								
				DefaultListModel<String> listModel2 = new DefaultListModel<>();
				listModel2.addElement("Breakfast");
				listModel2.addElement("Lunch");
				listModel2.addElement("Dinner");
				
				jList2 = new JList<>(listModel2);
				jList2.setBounds(200, 60, 100, 70);
				frame5.getContentPane().add(jList2);
				
				jFrame3Label4 = new JLabel("Enter the new Price: ");
				jFrame3Label4.setBounds(105,  140, 300, 25);
				frame5.getContentPane().add(jFrame3Label4);
				jTextField2 = new JTextField();
				jTextField2.setText("New Price");
				jTextField2.setBounds(350, 140, 100, 26);
				frame5.getContentPane().add(jTextField2);
				JButton updateButton = new JButton("Update");
				updateButton.setBounds(100, 170, 120, 30);
				updateButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Dish dish=new Dish();
						dish.setName(jTextField1.getText());
						dish.setPrice(Integer.parseInt(jTextField2.getText()));
						for(int i=0;i<jList2.getModel().getSize();i++) {
							if(jList2.isSelectedIndex(i)) {
							if(i==0){
								dish.setTime("breakfast");
								if(new BreakfastMenu().changePrice(dish)!=0) {
									frame5.revalidate();
									frame5.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame5.getContentPane().add(jFrame3Label4);
									frame5.revalidate();
									frame5.repaint();
									//frame4.pack();
								}else { 
									frame5.revalidate();
									frame5.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame5.getContentPane().add(jFrame3Label4);
									frame5.revalidate();
									frame5.repaint();
									//frame4.pack();
								}
							}
							if(i==1){
								dish.setTime("lunch");
								if(new LunchMenu().changePrice(dish)!=0) {
									frame5.revalidate();
									frame5.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame5.getContentPane().add(jFrame3Label4);
									frame5.revalidate();
									frame5.repaint();
								}else { 
									frame5.revalidate();
									frame5.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame5.getContentPane().add(jFrame3Label4);
									frame5.revalidate();
									frame5.repaint();
								}
							
							}
							if(i==2){
								dish.setTime("dinner");
								if(new DinnerMenu().changePrice(dish)!=0) {
									frame5.revalidate();
									frame5.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame5.getContentPane().add(jFrame3Label4);
									frame5.revalidate();
									frame5.repaint();
								}else { 
									frame5.revalidate();
									frame5.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame5.getContentPane().add(jFrame3Label4);
									frame5.revalidate();
									frame5.repaint();
								}
								}
							
							}
							
						}						
					}
				});
				frame5.getContentPane().add(updateButton);
				frame5.setBounds(100, 100, 700, 300);
				frame5.setVisible(true);
			
			}
		});
		
		frame.getContentPane().add(updatePrice);
		
		JButton updateDesc = new JButton("Update Description");
		updateDesc.setBounds(250, 270, 150, 30);
		updateDesc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame6 = new JFrame("Update Description");
				frame6.getContentPane().setLayout(null);
				jFrame3Label5 = new JLabel("Enter the name of dish to update the Description: ");
				jFrame3Label5.setBounds(105, 30, 300, 26);
				frame6.getContentPane().add(jFrame3Label5);
				jTextField1 = new JTextField();
				jTextField1.setText("Name of dish");
				jTextField1.setBounds(400, 30, 146, 26);
				frame6.getContentPane().add(jTextField1);
				jTextField1.setColumns(10);
				jFrame3Label6 = new JLabel("Select the time: ");
				jFrame3Label6.setBounds(105, 60, 300, 26);
				frame6.getContentPane().add(jFrame3Label6);
								
				DefaultListModel<String> listModel2 = new DefaultListModel<>();
				listModel2.addElement("Breakfast");
				listModel2.addElement("Lunch");
				listModel2.addElement("Dinner");
				
				jList2 = new JList<>(listModel2);
				jList2.setBounds(200, 60, 100, 70);
				frame6.getContentPane().add(jList2);
				
				jFrame3Label4 = new JLabel("Enter the new Description: ");
				jFrame3Label4.setBounds(105,  140, 300, 25);
				frame6.getContentPane().add(jFrame3Label4);
				jTextField2 = new JTextField();
				jTextField2.setText("New Description");
				jTextField2.setBounds(270, 140, 300, 26);
				frame6.getContentPane().add(jTextField2);
				JButton updateButton = new JButton("Update");
				updateButton.setBounds(100, 170, 120, 30);
				updateButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Dish dish=new Dish();
						dish.setName(jTextField1.getText());
						dish.setDescription(jTextField2.getText());
						for(int i=0;i<jList2.getModel().getSize();i++) {
							if(jList2.isSelectedIndex(i)) {
							if(i==0){
								dish.setTime("breakfast");
								if(new BreakfastMenu().changeDescription(dish)!=0) {
									frame6.revalidate();
									frame6.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame6.getContentPane().add(jFrame3Label4);
									frame6.revalidate();
									frame6.repaint();
									//frame4.pack();
								}else { 
									frame6.revalidate();
									frame6.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame6.getContentPane().add(jFrame3Label4);
									frame6.revalidate();
									frame6.repaint();
									//frame4.pack();
								}
							}
							if(i==1){
								dish.setTime("lunch");
								if(new LunchMenu().changeDescription(dish)!=0) {
									frame6.revalidate();
									frame6.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame6.getContentPane().add(jFrame3Label4);
									frame6.revalidate();
									frame6.repaint();
								}else { 
									frame6.revalidate();
									frame6.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame6.getContentPane().add(jFrame3Label4);
									frame6.revalidate();
									frame6.repaint();
								}
							
							}
							if(i==2){
								dish.setTime("dinner");
								if(new DinnerMenu().changeDescription(dish)!=0) {
									frame6.revalidate();
									frame6.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame6.getContentPane().add(jFrame3Label4);
									frame6.revalidate();
									frame6.repaint();
								}else { 
									frame6.revalidate();
									frame6.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame6.getContentPane().add(jFrame3Label4);
									frame6.revalidate();
									frame6.repaint();
								}
								}
							
							}
							
						}						
					}
				});
				frame6.getContentPane().add(updateButton);
				frame6.setBounds(100, 100, 700, 300);
				frame6.setVisible(true);
			
			}
		});
		
		frame.getContentPane().add(updateDesc);
		
		JButton swapTime = new JButton("Swap Dish Time");
		swapTime.setBounds(250, 330, 150, 30);
		swapTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame7 = new JFrame("Swap Dish Time");
				frame7.getContentPane().setLayout(null);
				jFrame3Label5 = new JLabel("Enter the name of dish to update the Dish Time: ");
				jFrame3Label5.setBounds(105, 30, 300, 26);
				frame7.getContentPane().add(jFrame3Label5);
				jTextField1 = new JTextField();
				jTextField1.setText("Name of dish");
				jTextField1.setBounds(400, 30, 146, 26);
				frame7.getContentPane().add(jTextField1);
				jTextField1.setColumns(10);
				jFrame3Label6 = new JLabel("Select the new time: ");
				jFrame3Label6.setBounds(105, 60, 300, 26);
				frame7.getContentPane().add(jFrame3Label6);
								
				DefaultListModel<String> listModel2 = new DefaultListModel<>();
				listModel2.addElement("Breakfast");
				listModel2.addElement("Lunch");
				listModel2.addElement("Dinner");
				
				jList2 = new JList<>(listModel2);
				jList2.setBounds(230, 60, 100, 70);
				frame7.getContentPane().add(jList2);
				
				
				JButton updateButton = new JButton("Update");
				updateButton.setBounds(100, 170, 120, 30);
				updateButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Dish dish=new Dish();
						dish.setName(jTextField1.getText());
						for(int i=0;i<jList2.getModel().getSize();i++) {
							if(jList2.isSelectedIndex(i)) {
							if(i==0){
								dish.setTime("breakfast");
								if(new BreakfastMenu().swapDish(dish)!=0) {
									frame7.revalidate();
									frame7.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame7.getContentPane().add(jFrame3Label4);
									frame7.revalidate();
									frame7.repaint();
									//frame4.pack();
								}else { 
									frame7.revalidate();
									frame7.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame7.getContentPane().add(jFrame3Label4);
									frame7.revalidate();
									frame7.repaint();
									//frame4.pack();
								}
							}
							if(i==1){
								dish.setTime("lunch");
								if(new LunchMenu().swapDish(dish)!=0) {
									frame7.revalidate();
									frame7.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame7.getContentPane().add(jFrame3Label4);
									frame7.revalidate();
									frame7.repaint();
								}else { 
									frame7.revalidate();
									frame7.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame7.getContentPane().add(jFrame3Label4);
									frame7.revalidate();
									frame7.repaint();
								}
							
							}
							if(i==2){
								dish.setTime("dinner");
								if(new DinnerMenu().swapDish(dish)!=0) {
									frame7.revalidate();
									frame7.repaint();
									jFrame3Label4 = new JLabel("Successful");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame7.getContentPane().add(jFrame3Label4);
									frame7.revalidate();
									frame7.repaint();
								}else { 
									frame7.revalidate();
									frame7.repaint();
									jFrame3Label4 = new JLabel("Error, no dish found.");
									jFrame3Label4.setBounds(250, 90, 120, 200);
									frame7.getContentPane().add(jFrame3Label4);
									frame7.revalidate();
									frame7.repaint();
								}
								}
							
							}
							
						}						
					}
				});
				frame7.getContentPane().add(updateButton);
				frame7.setBounds(100, 100, 700, 300);
				frame7.setVisible(true);
			
			}
		});
		
		frame.getContentPane().add(swapTime);
		
		
		
		
		
		
	}
}
