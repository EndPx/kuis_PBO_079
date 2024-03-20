package responsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Responsi implements ActionListener {
    private JFrame panelLogin;
    private JFrame panelHitungSiku;
    private JLabel userLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JTextField usernameField = new JTextField("");
    private JPasswordField passwordField = new JPasswordField("");
    private JButton login = new JButton("Masuk");
    private JLabel ALabel = new JLabel("A : ");
    private JTextField AField = new JTextField("");
    private JLabel BLabel = new JLabel("B : ");
    private JTextField BField = new JTextField("");
    private JButton hitung = new JButton("Hitung");
    private JLabel hasil = new JLabel("C : ");
    private JButton kembali = new JButton("Kembali");
    private JLabel cekLogin = new JLabel("");

    public Responsi() {
        //setting layout login
        panelLogin = new JFrame("Login Page");
        panelLogin.setLayout(null);
        panelLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //penambahan komponen untuk panel login
        panelLogin.add(userLabel);
        panelLogin.add(usernameField);
        panelLogin.add(passwordLabel);
        panelLogin.add(passwordField);
        panelLogin.add(login);
        panelLogin.add(cekLogin);
        
        //penambahan lokasi dan ukuran untuk komponen panel login
        userLabel.setBounds(50, 50, 100, 30);
        passwordLabel.setBounds(50, 90, 100, 30);
        login.setBounds(50, 140, 100, 30);
        usernameField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 90, 150, 30);
        cekLogin.setBounds(150, 140, 150,30);
        
        //menambahkan add listener untuk tombol login
        login.addActionListener(this);
        kembali.addActionListener(this);
        
        //setting panel login
        panelLogin.setSize(400, 230);
        panelLogin.setVisible(true);
        
        //setting layout panelhitungsiku
        panelHitungSiku = new JFrame("Hitung Siku Page");
        panelHitungSiku.setLayout(null);
        panelHitungSiku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //penampahan komponen untuk panelhitungsiku
        panelHitungSiku.add(ALabel);
        panelHitungSiku.add(AField);
        panelHitungSiku.add(BLabel);
        panelHitungSiku.add(BField);
        panelHitungSiku.add(hitung);
        panelHitungSiku.add(hasil);
        panelHitungSiku.add(kembali);
        
        ALabel.setBounds(50, 50, 100, 30);
        BLabel.setBounds(50, 90, 100, 30);
        hitung.setBounds(50, 140, 100, 30);
        kembali.setBounds(50, 190, 100, 30);
        AField.setBounds(150, 50, 150, 30);
        BField.setBounds(150, 90, 150, 30);
        hasil.setBounds(150, 140, 150, 30);
        
        
        //penambahan add listene untuk tombol hitung
        hitung.addActionListener(this);
        
        //setting panel hitung siku
        panelHitungSiku.setSize(400, 300);
        panelHitungSiku.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //jika memencet tombol login
        if (e.getSource() == login) {
            //mengambil username dari usernamefield
            String username = usernameField.getText();
            //mengambil password dari passwordfield
            String password = new String(passwordField.getPassword());
            
            //Untuk username dan password isikan dengan tukang_3DigitNimTerakhir
            if("tukang_079".equals(username) && password.equals("tukang_079")){
                panelLogin.setVisible(false);
                panelHitungSiku.setVisible(true);
                usernameField.setText("");
                passwordField.setText("");
                cekLogin.setText("");
            } else {
                cekLogin.setText("Login Salah");
            }
        //jika memencet tombol hitung
        } else if(e.getSource() == hitung){
            //mengubah a dari string ke angka 
            double a = Double.parseDouble(AField.getText());
            //mengubah b dari string ke angka 
            double b = Double.parseDouble(BField.getText());
            
            //mengubah c dari string ke angka 
            double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

            hasil.setText("C : " + c);
        } else if(e.getSource() == kembali){
            AField.setText("");
            BField.setText("");
            hasil.setText("");
            panelLogin.setVisible(true);
            panelHitungSiku.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Responsi();
    }
}