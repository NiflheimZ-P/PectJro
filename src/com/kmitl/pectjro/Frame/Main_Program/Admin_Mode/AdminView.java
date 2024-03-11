package com.kmitl.pectjro.Frame.Main_Program.Admin_Mode;

import com.kmitl.pectjro.Frame.Groups_interface.MainPage_Controller;
import com.kmitl.pectjro.Frame.Groups_interface.View_Getter;
import com.kmitl.pectjro.Frame.Main_Program.Admin_Mode.Sub_Windows.UserTablePage;
import com.kmitl.pectjro.Frame.Tools.JDesktopBG;

import javax.swing.*;
import java.awt.*;

public class AdminView implements View_Getter {
	private JDesktopBG adminview;

	public AdminView() {
		super();
		adminview = new JDesktopBG(new ImageIcon("resources/Images/kmitl_it_data_science_01.jpg").getImage());
		adminview.add(new UserTablePage());
	}

	@Override
	public Container getView() {
		return adminview;
	}
}
