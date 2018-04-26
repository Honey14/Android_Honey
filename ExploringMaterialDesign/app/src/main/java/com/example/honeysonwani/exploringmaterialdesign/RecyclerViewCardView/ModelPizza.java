package com.example.honeysonwani.exploringmaterialdesign.RecyclerViewCardView;

import com.example.honeysonwani.exploringmaterialdesign.R;

/**
 * Created by honeysonwani on 4/26/2018.
 */

public class ModelPizza {
    String name;
    private int imageResourceID;

    public static ModelPizza pizzas[] = {
            new ModelPizza("Sun Rise", R.drawable.toolbarimg),
            new ModelPizza("Random Image",R.drawable.ic_launcher_foreground)
    };
    public ModelPizza(String name, int imageResourceID) {
        this.name = name;
        this.imageResourceID = imageResourceID;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }
}
