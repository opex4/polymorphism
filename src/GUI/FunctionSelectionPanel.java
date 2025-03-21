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

        // Кнопка для показа флота
        showFleetButton.addActionListener(e -> {
            outputPanel.clearText();
            String result = fleet.showFleet();
            outputPanel.appendText(result);
        });

        // Кнопка для показа характеристик
        showCharacteristicsButton.addActionListener(e -> {
            outputPanel.clearText();
            String result = fleet.showCharacteristics();
            outputPanel.appendText(result);
        });

        // Кнопка для поиска лучшего ледокола
        findBestIcebreakerButton.addActionListener(e -> {
            outputPanel.clearText();
            String result = fleet.foundBestIcebreaker();
            outputPanel.appendText(result);
        });

        add(showFleetButton);
        add(showCharacteristicsButton);
        add(findBestIcebreakerButton);

        setBorder(BorderFactory.createTitledBorder("Выбор функций"));
    }
}

