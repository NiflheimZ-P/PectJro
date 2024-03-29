package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.task_page;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;
import com.kmitl.pectjro.Frame.Main_Program.home_page;

import java.awt.*;
import javax.swing.*;

public class Task {
    private JPanel fr;

    public JPanel getFrame() {
        return fr;
    }

    public Task(){
        fr = new JPanel();

        fr.setBackground(new Color(49,51,56));
        fr.setSize(1000,600);
        fr.setVisible(true);
        fr.add(new task_view());
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(new FlatMacLightLaf());
        SwingUtilities.invokeLater(() -> {new Profile(); });
    }
}
