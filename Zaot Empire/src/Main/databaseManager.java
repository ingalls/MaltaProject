package Main;

import javax.swing.*;

public class databaseManager extends javax.swing.JFrame {


	private JLabel header;
	private JButton roomCreateButton;
	private JButton listUsersButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public void start() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				databaseManager inst = new databaseManager();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public databaseManager() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			{
				header = new JLabel();
				header.setText("Database Manager v0.5");
			}
			{
				roomCreateButton = new JButton();
				roomCreateButton.setText("Room Creation");
			}
			{
				listUsersButton = new JButton();
				listUsersButton.setText("List Users");
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(header, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(roomCreateButton, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(listUsersButton, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(308, Short.MAX_VALUE));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(header, GroupLayout.Alignment.LEADING, 0, 736, Short.MAX_VALUE)
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(roomCreateButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 589, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(listUsersButton, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 589, Short.MAX_VALUE)))
				.addContainerGap());
			this.setSize(760, 412);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
