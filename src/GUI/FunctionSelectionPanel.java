package GUI;

import Logic.Fleet;
import javax.swing.*;
import java.awt.*;

public class FunctionSelectionPanel extends JPanel {

    public FunctionSelectionPanel(Fleet fleet, OutputPanel outputPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton showFleetButton = new JButton("Показать флот");
        JButton showCharacteristicsButton = new JButton("Показать характеристики");
        JButton findBestIcebreakerButton = new JButton("Найти лучший ледокол");
        JButton additionalParameterButton = new JButton("О доп. параметре");

        // Кнопка для показа флота
        showFleetButton.addActionListener(e -> {
            outputPanel.clearText();
            outputPanel.appendText(fleet.showFleet(), showFleetButton.getText());
        });

        // Кнопка для показа характеристик
        showCharacteristicsButton.addActionListener(e -> {
            outputPanel.clearText();
            outputPanel.appendTable(fleet.showTableCharacteristics(), showCharacteristicsButton.getText());
        });

        // Кнопка для поиска лучшего ледокола
        findBestIcebreakerButton.addActionListener(e -> {
            outputPanel.clearText();
            outputPanel.appendTable(fleet.foundBestIcebreakerTable(), findBestIcebreakerButton.getText());
        });

        // Кнопка about доп параметр
        additionalParameterButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Доп. параметр\nПарусник - максимальный коэф. парусности\nЛедокол - толщина пробиваемого льда\nПароход - количество котлов", "Справка", JOptionPane.PLAIN_MESSAGE);
        });

        add(showFleetButton);
        add(showCharacteristicsButton);
        add(findBestIcebreakerButton);
        add(additionalParameterButton);

        setBorder(BorderFactory.createTitledBorder("Выбор функций"));
    }
}

