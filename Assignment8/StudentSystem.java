package Assignment8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentSystem {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponent(panel);
        frame.setVisible(true);
    }

    public static void placeComponent(JPanel panel){
        panel.setLayout(null);
        JLabel id = new JLabel("Student ID");
        id.setBounds(200, 40, 200, 25);
        panel.add(id);
        JLabel name = new JLabel("Student Name");
        name.setBounds(200, 100, 200, 25);
        panel.add(name);
        JLabel gender = new JLabel("Student Gender");
        gender.setBounds(200, 160, 200, 25);
        panel.add(gender);
        JTextField idText = new JTextField();
        idText.setBounds(400, 40, 200, 25);
        panel.add(idText);
        JTextField nameText = new JTextField();
        nameText.setBounds(400, 100, 200, 25);
        panel.add(nameText);
        JComboBox genderChoice = new JComboBox();
        genderChoice.setBounds(400, 160, 200, 25);
        genderChoice.addItem("Please Choose");
        genderChoice.addItem("Male");
        genderChoice.addItem("Female");
        panel.add(genderChoice);
        JButton add = new JButton("ADD");
        add.setBounds(60, 240, 120, 25);
        panel.add(add);
        JButton delete = new JButton("DELETE");
        delete.setBounds(240, 240, 120, 25);
        panel.add(delete);
        JButton modify = new JButton("MODIFY");
        modify.setBounds(420, 240, 120, 25);
        panel.add(modify);
        JButton find = new JButton("FIND");
        find.setBounds(600, 240, 120, 25);
        panel.add(find);
        String[] title = {"ID", "Name", "Gender"};
        Object[][] data = new Object[0][3];
        DefaultTableModel table = new DefaultTableModel(data, title);
        JTable students = new JTable(table);
        JScrollPane pane = new JScrollPane(students);
        pane.setBounds(50, 300, 700, 250);
        panel.add(pane);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.valueOf(idText.getText());
                String name = nameText.getText();
                String gender = genderChoice.getSelectedItem().toString();
                String[] arr = new String[3];
                arr[0] = String.valueOf(id);
                arr[1] = name;
                arr[2] = gender;
                table.addRow(arr);
                students.invalidate();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = students.getSelectedRows();
                for(int i = 0; i < selectedRows.length; i++){
                    table.removeRow(selectedRows[0]);
                }
                students.invalidate();
            }
        });
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = students.getSelectedRow();
                int id = Integer.valueOf(idText.getText());
                String name = nameText.getText();
                String gender = genderChoice.getSelectedItem().toString();
                String[] arr = new String[3];
                arr[0] = String.valueOf(id);
                arr[1] = name;
                arr[2] = gender;
                table.removeRow(selectRow);
                table.insertRow(selectRow, arr);
                students.invalidate();
            }
        });
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter sorter = new TableRowSorter(table);
                students.setRowSorter(sorter);
                String id = idText.getText();
                String name = nameText.getText();
                String gender = genderChoice.getSelectedItem().toString();
                ArrayList<RowFilter<Object, Object>> filters = new ArrayList<>();
                int count = 0;
                if(id.length() != 0){
                    filters.add(RowFilter.regexFilter(id, count));
                    count++;
                }
                if(name.length() != 0){
                    filters.add(RowFilter.regexFilter(name, count));
                    count++;
                }
                if(gender.length() != 0){
                    filters.add(RowFilter.regexFilter(gender, count));
                    count++;
                }
                if(count == 0){
                    sorter.setRowFilter(null);
                } else {
                    RowFilter filter = RowFilter.andFilter(filters);
                    sorter.setRowFilter(filter);
                }
            }
        });
    }
}
