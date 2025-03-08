import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FleetGUI {
    private Fleet fleet = new Fleet();
    private JFrame frame;
    private JTextField nameField, tonnageField, speedField, extraField;
    private JComboBox<String> shipTypeBox;
    private JTextArea outputArea;

    public FleetGUI() {
        frame = new JFrame("Управление флотом");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Панель ввода
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Название:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Тоннаж:"));
        tonnageField = new JTextField();
        inputPanel.add(tonnageField);

        inputPanel.add(new JLabel("Скорость:"));
        speedField = new JTextField();
        inputPanel.add(speedField);

        inputPanel.add(new JLabel("Тип корабля:"));
        shipTypeBox = new JComboBox<>(new String[]{"Ледокол", "Парусник", "Пароход"});
        inputPanel.add(shipTypeBox);

        inputPanel.add(new JLabel("Доп. параметр:"));
        extraField = new JTextField();
        inputPanel.add(extraField);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Кнопки управления
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Добавить");
        JButton showFleetButton = new JButton("Показать флот");
        JButton showCharacteristicsButton = new JButton("Характеристики");
        JButton bestIcebreakerButton = new JButton("Лучший ледокол");

        buttonPanel.add(addButton);
        buttonPanel.add(showFleetButton);
        buttonPanel.add(showCharacteristicsButton);
        buttonPanel.add(bestIcebreakerButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Вывод информации
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Обработчики событий
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addShip();
            }
        });

        showFleetButton.addActionListener(e -> fleet.showFleet());
        showCharacteristicsButton.addActionListener(e -> fleet.showСharacteristics());
        bestIcebreakerButton.addActionListener(e -> fleet.foundBestIcebreaker());

        frame.setVisible(true);
    }

    private void addShip() {
        try {
            String name = nameField.getText();
            double tonnage = Double.parseDouble(tonnageField.getText());
            double speed = Double.parseDouble(speedField.getText());
            String type = (String) shipTypeBox.getSelectedItem();

            if (type.equals("Ледокол")) {
                double iceThickness = Double.parseDouble(extraField.getText());
                fleet.addShip(new Icebreaker(name, tonnage, speed, iceThickness));
            } else if (type.equals("Парусник")) {
                double maxWindageFactor = Double.parseDouble(extraField.getText());
                fleet.addShip(new SailingShip(name, tonnage, speed, maxWindageFactor));
            } else if (type.equals("Пароход")) {
                int numBoilers = Integer.parseInt(extraField.getText());
                fleet.addShip(new Steamboat(name, tonnage, speed, numBoilers));
            }
            outputArea.append("Корабль добавлен!\n");
        } catch (Exception e) {
            outputArea.append("Ошибка при добавлении корабля!\n");
        }
    }
}

