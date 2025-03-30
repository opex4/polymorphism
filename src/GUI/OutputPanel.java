package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OutputPanel extends JPanel {

    private final DefaultTableModel model;

    public OutputPanel() {
        setLayout(new BorderLayout());
        model = new DefaultTableModel(new String[]{"Поле для вывода результатов"}, 0);
        JTable table = new JTable(model);
        table.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        add(scrollPane, BorderLayout.CENTER);
        setBorder(BorderFactory.createTitledBorder("Результаты"));
    }

    public void appendText(String text, String NameMessage) {
        model.addColumn(NameMessage);
        String[] rows = text.split("\n");
        for (String row : rows) {
            model.addRow(new Object[]{row.trim()});
        }
    }

    public void appendTable(String text, String NameMessage) {
        model.addColumn("Название");
        model.addColumn("Класс корабля");
        model.addColumn("Скорость, узлов");
        model.addColumn("Тоннаж, т.");
        model.addColumn("Доп. параметр, кв.м., м., шт.");
        String[] rows = text.split("\n");
        for (String s : rows) {
            String[] cols = s.split(",");
            if (cols.length == 1){
                clearText();
                model.addColumn(NameMessage);
                model.addRow(cols);
                return;
            }
            model.addRow(cols);
        }
    }

    public void clearText() {
        model.setRowCount(0);
        model.setColumnCount(0);
    }
}