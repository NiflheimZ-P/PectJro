package com.kmitl.pectjro.Frame.Tools;
import java.awt.*;

public class Constraints {
    public Constraints(int gridx, int gridy, int gridweight, int gridheight, int weightx, int weighty, int anchor, int fill, Insets insert) {
        GridBagConstraints manage = new GridBagConstraints();
        manage.gridx = gridx;
        manage.gridy = gridy;
        manage.gridwidth = gridweight;
        manage.gridheight = gridheight;
        manage.weightx = weightx;
        manage.weighty = weighty;
        manage.anchor = anchor;
        manage.fill = fill;
        manage.insets = insert;
    }
    public Constraints(int gridx, int gridy, int gridweight, int gridheight, int weightx, int weighty, int anchor, int fill) {
        this(gridx, gridy, gridweight, gridheight, weightx, weighty, anchor, fill, new Insets(0, 0, 0, 0));
    }
    public Constraints(int gridx, int gridy, int gridweight, int gridheight, int weightx, int weighty, int fill) {
        this(gridx, gridy, gridweight, gridheight, weightx, weighty, GridBagConstraints.CENTER, fill, new Insets(0, 0, 0, 0));
    }
    public Constraints(int gridx, int gridy, int weightx, int weighty, int anchor, Insets insert){
        this(gridx, gridy, 1, 1, weightx, weighty, anchor, GridBagConstraints.NONE, insert);
    }
    public Constraints(int gridx, int gridy) {
        this(gridx, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0));
    }
    public Constraints(int gridx, int gridy, int anchor) {
        this(gridx, gridy, 1, 1, 0, 0, anchor, GridBagConstraints.NONE, new Insets(0, 0, 0, 0));
    }
}
