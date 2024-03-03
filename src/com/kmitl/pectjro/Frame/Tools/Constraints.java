package com.kmitl.pectjro.Frame.Tools;
import java.awt.*;

public class Constraints extends GridBagConstraints{
    public Constraints(int gridx, int gridy, int gridweight, int gridheight, int weightx, int weighty, int anchor, int fill, Insets insert) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridweight;
        this.gridheight = gridheight;
        this.weightx = weightx;
        this.weighty = weighty;
        this.anchor = anchor;
        this.fill = fill;
        this.insets = insert;
    }
    public Constraints(int gridx, int gridy, int gridweight, int gridheight, int weightx, int weighty, int anchor, Insets insert){
        this(gridx, gridy, gridweight, gridheight, weightx, weighty, anchor, GridBagConstraints.NONE, insert);
    }
    public Constraints(int gridx, int gridy, int gridweight, int gridheight, int weightx, int weighty, Insets insert){
        this(gridx, gridy, gridweight, gridheight, weightx, weighty, GridBagConstraints.CENTER, GridBagConstraints.NONE, insert);
    }
    public Constraints(int gridx, int gridy, int weightx, int weighty, Insets insert){
        this(gridx, gridy, 1, 1, weightx, weighty, GridBagConstraints.CENTER, GridBagConstraints.NONE, insert);
    }
    public Constraints(int gridx, int gridy){
        this(gridx, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0));
    }
}
