package GUI;

import javax.swing.*;
import java.awt.*;
import Logic.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddShipPanel extends JPanel {

    private Fleet fleet;
    private JTextField nameField, tonnageField, speedField, additionalField;
    private JComboBox<String> shipTypeComboBox;
    private JLabel additionalLabel;

    public AddShipPanel(Fleet fleet) {
        this.fleet = fleet;
        setLayout(new GridLayout(7, 2));

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
    }

    private void updateAdditionalLabel() {
        String selectedType = (String) shipTypeComboBox.getSelectedItem();
        String labelText = switch (selectedType) {
            case "Парусник" -> "Максимальный коэффициент парусности:";
            case "Ледокол" -> "Толщина пробиваемого льда:";
            case "Пароход" -> "Количество котлов:";
            default -> "Дополнительный параметр:";
        };
        additionalLabel.setText(labelText); // Обновляем текст метки
    }

    private void addShipToFleet() {
        try {
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
                JOptionPane.showMessageDialog(this, "Корабль добавлен в флот.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при добавлении корабля.");
        }
    }
}
