package GUI;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

    private JTextArea textArea;

    public OutputPanel() {
        setLayout(new BorderLayout());

        textArea = new JTextArea(10, 40);
        // Запрещает пользователю редактировать текст
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        setBorder(BorderFactory.createTitledBorder("Результаты"));
    }

    public void appendText(String text) {
        textArea.append(text + "\n");
    }

    public void clearText() {
        textArea.setText("");
    }
}