package com.demo.overcooked.ui;

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

    public Transporter() {
        this.gameScreen = GameScreenUI.getInstance();
        configTransporter();
        buttonsListeners();
    }

    public static Transporter getInstance() {
        if (instance == null) {
            instance = new Transporter();
        }
        return instance;
    }

    private void addIngredientToOrder(JPanel transporterPanel) {
        System.out.println("com.demo.overcooked.ui.Transporter.addIngredientToOrder()");
    }

    private void deleteIngredientForTransporter(JPanel transporterPanel) {
        System.out.println("com.demo.overcooked.ui.Transporter.deleteIngredientForTransporter()");
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

    private Component[] getComponents(JPanel parentPanel, String componentsName) {
        Component[] screenComponents = gameScreen.getContentPane().getComponents();

        if (parentPanel != null) {
            screenComponents = parentPanel.getComponents();
        }

        int componentsSize = 0;
        for (Component screenComponent : screenComponents) {
            if (componentHasName(screenComponent, componentsName)) {
                componentsSize++;
            }
        }

        Component[] components = new Component[componentsSize];
        int componentsIndexer = 0;

        for (Component screenComponent : screenComponents) {
            if (componentHasName(screenComponent, componentsName)) {
                components[componentsIndexer] = screenComponent;
                componentsIndexer++;
            }
        }

        return components;
    }

    private boolean componentHasName(Component component, String name) {
        return component.getName() != null
                && component.getName().contains(name)
                ? true : false;
    }

    private void populatePanelsAndBtnsArrays() {
        Component[] transporterPanels = getComponents(
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
            Component[] childPanelBtns = getComponents(
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

    public void addBasePanelToContainerPanels() {
        Component[] transporterPanels = getComponents(
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
    
    
    public void setOpaqueTransporterComponents() {
        common.setPanelsOpaque(transporterContainerPanels);
    }

    public void configTransporter() {
        addBasePanelToContainerPanels();
        populatePanelsAndBtnsArrays();
        setOpaqueTransporterComponents();
    }
}
