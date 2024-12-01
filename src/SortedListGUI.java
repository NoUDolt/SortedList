import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI extends JFrame {
    private SortedList sortedList;
    private JTextArea textArea;
    private JTextField inputField;
    private JTextField searchField;

    public SortedListGUI() {
        sortedList = new SortedList();

        setTitle("Sorted List GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 400);

        // Top Panel for inputs
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        inputField = new JTextField();
        JButton addButton = new JButton("Add to List");
        searchField = new JTextField();
        JButton searchButton = new JButton("Search List");

        topPanel.add(new JLabel("Enter String to Add:"));
        topPanel.add(inputField);
        topPanel.add(new JLabel("Enter String to Search:"));
        topPanel.add(searchField);

        // Text Area for displaying operations
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Bottom Panel for buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(addButton);
        bottomPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Button Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    sortedList.add(input);
                    textArea.append("Added: " + input + "\n");
                    textArea.append("Current List: " + sortedList.getAllElements() + "\n");
                    inputField.setText("");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = searchField.getText().trim();
                if (!search.isEmpty()) {
                    String result = sortedList.search(search);
                    textArea.append("Search: " + search + " -> " + result + "\n");
                    searchField.setText("");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SortedListGUI();
    }
}
