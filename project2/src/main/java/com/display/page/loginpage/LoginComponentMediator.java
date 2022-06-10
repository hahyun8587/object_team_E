package com.display.page.loginpage;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import com.display.FramePage;
import com.display.ComponentMediator;
import com.display.UIDisplayer;
import com.display.page.mainpage.MainPage;
import com.std.User;

public class LoginComponentMediator extends ComponentMediator {
    private JTextField idText;
    private JPasswordField pwText;

    public LoginComponentMediator(UIDisplayer displayer) {
        super(displayer);
    }

    public void login() {
        FramePage page = displayer.getCurrentPage();
        User user = User.login(((LoginPage) page).getUa(), idText.getText(), new String(pwText.getPassword()));

        if(user != null) {
            displayer.setUser(user);
            forward(new MainPage(displayer, user));
        }
        else 
            JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 다시 확인해주세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
    }

    public void idPwSearch() {
        /* implement */
    }

    public void registerId(JTextField idText) {
        this.idText = idText;
    }

    public void registerPw(JPasswordField pwText) {
        this.pwText = pwText;
    }
}
