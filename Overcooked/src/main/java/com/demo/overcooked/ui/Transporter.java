package com.demo.overcooked.ui;

import com.demo.overcooked.estructuras.cinta.CircularList;
import com.demo.overcooked.estructuras.cinta.Ingredient;
import com.demo.overcooked.ui.transporter.ingredients.bread;
import com.demo.overcooked.ui.transporter.ingredients.cheese;
import com.demo.overcooked.ui.transporter.ingredients.lettuce;
import com.demo.overcooked.ui.transporter.ingredients.meat;
import com.demo.overcooked.ui.transporter.transporterBasePanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Transporter {

    private static Transporter instance;

    GameScreenUI gameScreen;
    private static Common common = new Common();
    private static Constants constant = new Constants();

    private JPanel[] transporterContainerPanels = new JPanel[5];
    private JButton[] buttons = new JButton[10];

    private CircularList ingredientsTransporter = new CircularList();
    IngredientsCounter ingredientsCounter;

    public Transporter() {
        this.gameScreen = GameScreenUI.getInstance();
        this.ingredientsCounter = IngredientsCounter.getInstance();
        configTransporter();
        buttonsListeners();
        populateTransporter();
    }

    public void populateTransporter() {
        for (JPanel transporterContainerPanel : transporterContainerPanels) {
            JPanel basePanel = (JPanel) transporterContainerPanel.getComponents()[0];
            JPanel ingredientPanel = (JPanel) common.getComponents(
                    basePanel,
                    "panel"
            )[0];

            if (!common.panelIsEmpty(ingredientPanel)) {
                continue;
            }

            JPanel ingredient = getRandomIngredient();

            common.addContentToPanel(ingredientPanel, ingredient, constant.INGREDIENT_PANEL_SIZE);
            ingredientsTransporter.inserta(new Ingredient(ingredient));
        }

        System.out.println(ingredientsTransporter.getNodehead().getDato().getIngredient().getName());
    }

    public JPanel getRandomIngredient() {
        JPanel[] ingredients = new JPanel[]{
            new lettuce(),
            new cheese(),
            new bread(),
            new meat()
        };

        return ingredients[common.getRandomNumber(ingredients.length)];
    }

    private void addIngredientToOrder(JPanel transporterPanel) {
        JPanel ingredientPanel = (JPanel) common.getComponents(
                transporterPanel,
                "panel"
        )[0];
        String ingredient = ingredientPanel.getComponents()[0].getName();

        if (ingredientsCounter.isIngredientPartOfOrder(ingredient)) {
            ingredientsCounter.updateIngredientsCounter(ingredient);
        }

    }

    private void deleteIngredientForTransporter(JPanel transporterPanel) {
        JPanel ingredientPanel = (JPanel) common.getComponents(
                transporterPanel,
                "panel"
        )[0];
        ingredientPanel.removeAll();
        populateTransporter();        
    }

    private void buttonsListeners() {
        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel parentPanel = (JPanel) button.getParent();

                    if (button.getName().contains("add")) {
                        addIngredientToOrder(parentPanel);
                    } else {
                        deleteIngredientForTransporter(parentPanel);
                    }
                }
            });
        }
    }

    private void populatePanelsAndBtnsArrays() {
        Component[] transporterPanels = common.getComponents(
                null,
                "transporter"
        );
        Component[][] childBtns = new Component[5][2];

        int indexPanels = 0;
        int indexBtns = 0;

        for (Component panelComponent : transporterPanels) {
            JPanel panel = (JPanel) panelComponent;
            this.transporterContainerPanels[indexPanels] = panel;
            indexPanels++;

            JPanel childPanel = (JPanel) panel.getComponents()[0];
            Component[] childPanelBtns = common.getComponents(
                    childPanel,
                    "btn"
            );
            childBtns[indexBtns] = childPanelBtns;
            indexBtns++;
        }

        int indexChildBtns = 0;
        for (Component[] btns : childBtns) {
            this.buttons[indexChildBtns] = (JButton) btns[0];
            this.buttons[indexChildBtns + 1] = (JButton) btns[1];
            indexChildBtns = indexChildBtns + 2;
        }
    }

    private void addBasePanelToContainerPanels() {
        Component[] transporterPanels = common.getComponents(
                null,
                "transporter"
        );

        for (Component transporterPanel : transporterPanels) {
            JPanel basePanel = new transporterBasePanel();
            common.addContentToPanel(
                    (JPanel) transporterPanel,
                    basePanel,
                    constant.TRANSPORTER_BASE_PANEL
            );

            basePanel.setName(constant.TRANSPORTER_BASE_NAME);
        }
    }

    private void setOpaqueTransporterComponents() {
        common.setPanelsOpaque(transporterContainerPanels);
    }

    private void configTransporter() {
        addBasePanelToContainerPanels();
        populatePanelsAndBtnsArrays();
        setOpaqueTransporterComponents();
    }

    public static Transporter getInstance() {
        if (instance == null) {
            instance = new Transporter();
        }
        return instance;
    }
}
