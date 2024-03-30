package com.kmitl.pectjro.Frame.Main_Program.Homepage_feature.Profile;

import com.kmitl.pectjro.Database.Connection.DBConnect;
import com.kmitl.pectjro.Database.DatabaseTable.UserTable;
import com.kmitl.pectjro.Frame.Main_Program.home_page.home_pageController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ProfileController implements ActionListener {
	// Attribute
	private Profile view;
	private ProfileModel model;
	private home_pageController head_control;
	private changePass cpass;
	private changeUsername cuser;

	// Constructor
	public ProfileController(home_pageController head_control) {
		this.head_control = head_control;
		this.view = new Profile();
		this.model = new ProfileModel(view, this);

		view.getBn_select_photo().addActionListener(this);
		view.getBn_change_name().addActionListener(this);
		view.getBn_change_password().addActionListener(this);
		view.getBn_log_out().addActionListener(this);


	}

	// Listener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(view.getBn_select_photo())) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
			fc.setFileFilter(filter);
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				model.changePicture(fc.getSelectedFile().getAbsolutePath());
			}
		}else if (e.getSource().equals(view.getBn_change_name())){
			cuser = new changeUsername();
			cuser.getSubmit().addActionListener(this);
			cuser.getCancel().addActionListener(this);
		}else if (e.getSource().equals(view.getBn_change_password())){
			cpass = new changePass();
			cpass.getSubmit().addActionListener(this);
			cpass.getCancel().addActionListener(this);
		}else if (e.getSource().equals(view.getBn_log_out())){
			model.loadLogin();
		}else if (e.getActionCommand().equals("Submit")){
			Connection con = DBConnect.createConnect();
			UserTable use = new UserTable(con);
            try {
                use.updatePassword(head_control.getCache().id, cpass.getCon_txt().getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }else if (e.getActionCommand().equals("Done")){
			Connection con = DBConnect.createConnect();
			UserTable use = new UserTable(con);
			try {
				use.updateName(head_control.getCache().id, cuser.getUser().getText());

			}catch (SQLException ex){
				throw new RuntimeException(ex);
			}
		}else if (e.getSource().equals(cuser.getCancel()) || e.getSource().equals(cpass.getCancel())){
			System.exit(0);
		}
	}

	// Accessor
	public Profile getView() {
		return view;
	}
	public void setView(Profile view) {
		this.view = view;
	}
	public ProfileModel getModel() {
		return model;
	}
	public void setModel(ProfileModel model) {
		this.model = model;
	}
	public home_pageController getHead_control() {
		return head_control;
	}
	public void setHead_control(home_pageController head_control) {
		this.head_control = head_control;
	}
}
