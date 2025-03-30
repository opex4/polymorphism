package GUI;

import javax.swing.*;
import java.awt.*;
import Logic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddShipPanel extends JPanel {

    private final Fleet fleet;
    private final JTextField nameField, tonnageField, speedField, additionalField;
    private final JComboBox<String> shipTypeComboBox;
    private final JLabel additionalLabel;

    public AddShipPanel(Fleet fleet) {
        this.fleet = fleet;
        setLayout(new GridLayout(6, 2));

        // Добавляем элементы формы
        add(new JLabel("Название корабля:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Тоннаж:"));
        tonnageField = new JTextField();
        add(tonnageField);

        add(new JLabel("Скорость:"));
        speedField = new JTextField();
        add(speedField);

        add(new JLabel("Тип корабля:"));
        shipTypeComboBox = new JComboBox<>(new String[]{"Парусник", "Ледокол", "Пароход"});
        add(shipTypeComboBox);

        // Метка для дополнительного параметра
        additionalLabel = new JLabel("Максимальный коэффициент парусности:");
        add(additionalLabel);
        additionalField = new JTextField();
        add(additionalField);

        JButton addShipButton = new JButton("Добавить корабль");
        addShipButton.addActionListener(e -> addShipToFleet());
        add(addShipButton);

        setBorder(BorderFactory.createTitledBorder("Добавление корабля"));

        // Добавляем слушатель событий на изменение выбора в JComboBox
        shipTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdditionalLabel();
            }
        });

        // Добавляем слушатель событий на добавление символов в JTextField
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });

        tonnageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '.')) {
                    e.consume();
                }
            }
        });

        speedField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '.')) {
                    e.consume();
                }
            }
        });

        additionalField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '.')) {
                    e.consume();
                }
            }
        });
    }

    private void updateAdditionalLabel() {
        String selectedType = (String) shipTypeComboBox.getSelectedItem();
        String labelText = switch (selectedType) {
            case "Парусник" -> "Максимальный коэффициент парусности:";
            case "Ледокол" -> "Толщина пробиваемого льда:";
            case "Пароход" -> "Количество котлов:";
            default -> "Дополнительный параметр:";
        };
        additionalLabel.setText(labelText); // Обновляем текст
    }

    private void addShipToFleet() {
        try {
            if (nameField.getText().isEmpty() || tonnageField.getText().isEmpty() || speedField.getText().isEmpty()){
                throw new IllegalArgumentException("Все поля должны быть заполнены!");
            }

            String name = nameField.getText();
            double tonnage = Double.parseDouble(tonnageField.getText());
            double speed = Double.parseDouble(speedField.getText());
            String shipType = (String) shipTypeComboBox.getSelectedItem();

            Ship newShip = null;
            switch (shipType) {
                case "Парусник":
                    double windage = Double.parseDouble(additionalField.getText());
                    newShip = new SailingShip(name, tonnage, speed, windage);
                    break;
                case "Ледокол":
                    double iceThickness = Double.parseDouble(additionalField.getText());
                    newShip = new Icebreaker(name, tonnage, speed, iceThickness);
                    break;
                case "Пароход":
                    int numBoilers = Integer.parseInt(additionalField.getText());
                    newShip = new Steamboat(name, tonnage, speed, numBoilers);
                    break;
            }

            if (newShip != null) {
                fleet.addShip(newShip);
                JOptionPane.showMessageDialog(this, "Корабль добавлен в флот.\n" + newShip.getCharacteristics(), "Успех", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}