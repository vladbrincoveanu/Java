package presentation;


import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class LogIn extends JPanel {
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel lblUser;
    private JLabel lblPassword;
    private JButton btnLogin;

    /**
     * Create the panel.
     */
    public LogIn() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 54, 0, 0, 116, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        lblUser = new JLabel("User");
        GridBagConstraints gbc_lblUser = new GridBagConstraints();
        gbc_lblUser.insets = new Insets(0, 0, 5, 5);
        gbc_lblUser.gridx = 4;
        gbc_lblUser.gridy = 3;
        add(lblUser, gbc_lblUser);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 6;
        gbc_textField.gridy = 3;
        add(textField, gbc_textField);
        textField.setColumns(10);

        lblPassword = new JLabel("Password");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 4;
        gbc_lblPassword.gridy = 5;
        add(lblPassword, gbc_lblPassword);

        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 6;
        gbc_passwordField.gridy = 5;
        add(passwordField, gbc_passwordField);

        btnLogin = new JButton("LogIn");
        GridBagConstraints gbc_btnLogin = new GridBagConstraints();
        gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
        gbc_btnLogin.gridx = 6;
        gbc_btnLogin.gridy = 10;
        add(btnLogin, gbc_btnLogin);

    }

    public void addLogInListener(ActionListener e){
        btnLogin.addActionListener(e);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JLabel getLblUser() {
        return lblUser;
    }

    public void setLblUser(JLabel lblUser) {
        this.lblUser = lblUser;
    }

    public JLabel getLblPassword() {
        return lblPassword;
    }

    public void setLblPassword(JLabel lblPassword) {
        this.lblPassword = lblPassword;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(JButton btnLogin) {
        this.btnLogin = btnLogin;
    }

}
