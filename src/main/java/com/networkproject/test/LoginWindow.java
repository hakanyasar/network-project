package com.networkproject.test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.networkproject.entityFactory.EntityFactory;
import com.networkproject.entityFactoryImpl.EntityFactoryImpl;
import com.networkproject.model.user.Role;
import com.networkproject.model.user.User;
import com.networkproject.queries.UserQueries;
import com.networkproject.repository.RoleRepository;
import com.networkproject.repository.UserRepository;
import com.networkproject.repositoryImpl.RoleRepositoryImpl;
import com.networkproject.repositoryImpl.UserRepositoryImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	private JFrame frmNetwopro;
	private JTextField fieldUsername;
	private JPasswordField fieldPassword;
	
	private static Role role;
	private static User user;
	
	private RoleRepository roleRepository = new RoleRepositoryImpl();
	private UserRepository userRepository = new UserRepositoryImpl();
	
	private static String tempUserName;
	private static String tempPassword;
	private JButton btnLogin;
	
	Boolean temp = null;
	
	private UserWindow userWindow;
	
	public LoginWindow() {
		initialize();
	}

	private void initialize() {

		frmNetwopro = new JFrame();
		frmNetwopro.setTitle("NetwoPro");
		frmNetwopro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hyyasar\\eclipse-workspace\\com.networkproject\\src\\test\\resources\\nproIco.png"));
		frmNetwopro.setBounds(100, 100, 450, 282);
		frmNetwopro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetwopro.getContentPane().setLayout(null);
		
		fieldUsername = new JTextField(); 
		fieldUsername.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		fieldUsername.setBounds(163, 107, 205, 23);
		frmNetwopro.getContentPane().add(fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel labelNetwoPro = new JLabel("NetwoPro");
		labelNetwoPro.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		labelNetwoPro.setBounds(163, 42, 140, 30);
		frmNetwopro.getContentPane().add(labelNetwoPro);
		
		JLabel labelUsername = new JLabel("Username:");
		labelUsername.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		labelUsername.setBounds(30, 107, 115, 23);
		frmNetwopro.getContentPane().add(labelUsername);
		
		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		labelPassword.setBounds(30, 141, 115, 23);
		frmNetwopro.getContentPane().add(labelPassword);
		
		btnLogin = new JButton("Log In");
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnLogin.setBounds(163, 192, 109, 23);
		frmNetwopro.getContentPane().add(btnLogin);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		fieldPassword.setBounds(163, 141, 205, 23);
		frmNetwopro.getContentPane().add(fieldPassword);
		
		createEvents();
	}
	
	private void createEvents() {
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						
						tempUserName = fieldUsername.getText();
						tempPassword = fieldPassword.getText();
						
						temp = userRepository.findUserByUsernameAndPassword(tempUserName, tempPassword);
						
						if(temp == true) {

							int userId = userRepository.findUserIdByUserName(tempUserName);
							userWindow = new UserWindow(userId);
							userWindow.getFrame().setVisible(true);
							frmNetwopro.setVisible(false);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Giriþ yapýlamadý. Kullanýcý adý ya da parola hatalý..");
						
						}
					} catch (Exception e2) {
						System.out.println("error: " + e2);
					}
				}
			});		
	}
	

	public JFrame getFrmNetwopro() {
		return frmNetwopro;
	}

	public void setFrmNetwopro(JFrame frmNetwopro) {
		this.frmNetwopro = frmNetwopro;
	}
	
}
