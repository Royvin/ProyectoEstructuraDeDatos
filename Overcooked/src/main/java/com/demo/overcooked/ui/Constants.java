package com.demo.overcooked.ui;

public class Constants {

    public final String CHEESE_BURGER = "cheese";
    public final String MEAT_BURGER = "meat";
    public final String MEAT_AND_CHEESE_BURGER = "meat-cheese";
    public final String INGREDIENT_BREAD = "bread";
    public final String INGREDIENT_CHEESE = "cheese";
    public final String INGREDIENT_LETTUCE = "lettuce";
    public final String INGREDIENT_MEAT = "meat";

    public final String TRANSPORTER_BASE_NAME = "base-panel";

    public final String BIG_CHEESE_IMG_PATH = "assets/orders/big-cheese.png";
    public final String BIG_MEAT_IMG_PATH = "assets/orders/big-meat.png";
    public final String BIG_MEAT_AND_CHEESE_IMG_PATH = "assets/orders/big-meat-cheese.png";

    public final String TINY_CHEESE_IMG_PATH = "assets/orders/cheese.png";
    public final String TINY_MEAT_IMG_PATH = "assets/orders/meat.png";
    public final String TINY_MEAT_AND_CHEESE_IMG_PATH = "assets/orders/meat-cheese.png";
    public final String TRANSPORTER_BASE_PANEL_IMG_PATH = "assets/ingredients/base-panel.png";

    public final int[] TINY_ORDERS_SIZE = new int[]{195, 156};
    public final int[] TRANSPORTER_BASE_PANEL = new int[]{164, 200};
    public final int[] INGREDIENT_PANEL_SIZE = new int[]{164, 124};

    public final String[] CHEESE_BURGER_INGREDIENTS = {INGREDIENT_BREAD, INGREDIENT_CHEESE};
    public final String[] MEAT_BURGER_INGREDIENTS = {INGREDIENT_BREAD, INGREDIENT_MEAT};
    public final String[] CHEESE_AND_MEAT_BURGER_INGREDIENTS
            = {INGREDIENT_BREAD,
                INGREDIENT_CHEESE,
                INGREDIENT_MEAT,
                INGREDIENT_LETTUCE
            };
}
