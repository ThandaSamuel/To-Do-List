import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JList list;
	List<String> data = new ArrayList<>();
	DefaultListModel toDoList ;
	private JButton removeButton;

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JButton btnNewButton = new JButton("ADD TASK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toDoList  = new DefaultListModel();
				 
				 for (String item : data) {
		                toDoList.addElement(item);
		          }
				 data.add(textField.getText());
				toDoList.addElement(textField.getText());
				list.setModel(toDoList);
				textField.setText("");
				
			}
		});
		
		removeButton = new JButton("REMOVE TASK");
		removeButton.setBounds(365, 183, 128, 34);
		contentPane.add(removeButton);	
			        removeButton.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                int selectedIndex = list.getSelectedIndex();
			                if (selectedIndex != -1) {
			                    toDoList.remove(selectedIndex);
			                   data.remove(selectedIndex);
			                }
			            }
			        });
				
		btnNewButton.setBounds(365, 10, 128, 41);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(25, 10, 318, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		list = new JList();
		list.setBounds(25, 54, 318, 356);
		contentPane.add(list);
		
	}
	
}

