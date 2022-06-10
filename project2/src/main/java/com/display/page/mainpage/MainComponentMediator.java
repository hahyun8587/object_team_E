package com.display.page.mainpage;

import java.net.URI;
import java.awt.Desktop;

import com.display.ComponentMediator;
import com.display.CorePage;
import com.display.UIDisplayer;
//import com.display.page.FileManagePage;
//import com.display.page.MemberManagePage;
import com.display.page.mainpage.settingpage.SettingDialog;
import com.display.page.recordmanagepage.ConferenceManagePage;
import com.display.page.recordmanagepage.JobManagePage;
import com.display.page.recordmanagepage.ScheduleManagePage;

import java.net.URISyntaxException;
import java.io.IOException;

public class MainComponentMediator extends ComponentMediator {
    
    public MainComponentMediator(UIDisplayer displayer) {
        super(displayer);
    }

    public void memberManage() {
        //forward(new MemberManagePage(displayer, user));
    } 

    public void conferenceManage() {
        forward(new ConferenceManagePage(displayer, displayer.getUser()));
    }

    public void jobManage() {
        forward(new JobManagePage(displayer, ((CorePage) displayer.getCurrentPage()).getUser()));
    }

    public void scheduleManage() {
        forward(new ScheduleManagePage(displayer, ((CorePage) displayer.getCurrentPage()).getUser()));
    }

    public void zoom() throws URISyntaxException, IOException {
		Desktop.getDesktop().browse(new URI("https://zoom.us/"));
    }

    public void setting() {
        branch(new SettingDialog(displayer, displayer.getCurrentPage()));
    }

    public void fileManage() {
        //forward(new FileManagePage(displayer, user));
    }
}
