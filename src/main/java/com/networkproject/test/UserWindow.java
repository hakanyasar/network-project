package com.networkproject.test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.networkproject.model.Province;
import com.networkproject.model.Router;
import com.networkproject.model.Text;
import com.networkproject.model.Unit;
import com.networkproject.model.user.Role;
import com.networkproject.model.user.User;
import com.networkproject.repository.ProvinceRepository;
import com.networkproject.repository.RoleRepository;
import com.networkproject.repository.RouterRepository;
import com.networkproject.repository.TextRepository;
import com.networkproject.repository.UnitRepository;
import com.networkproject.repository.UserRepository;
import com.networkproject.repositoryImpl.ProvinceRepositoryImpl;
import com.networkproject.repositoryImpl.RoleRepositoryImpl;
import com.networkproject.repositoryImpl.RouterRepositoryImpl;
import com.networkproject.repositoryImpl.TextRepositoryImpl;
import com.networkproject.repositoryImpl.UnitRepositoryImpl;
import com.networkproject.repositoryImpl.UserRepositoryImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class UserWindow {
	
	private static Role role;
	private static User user;
	private static Province province;
	private static Unit unit;
	private static Router router;
	private static Text text;
	
	private static RoleRepository roleRepository = new RoleRepositoryImpl();
	private static UserRepository userRepository = new UserRepositoryImpl(); 
	private static ProvinceRepository provinceRepository = new ProvinceRepositoryImpl();
	private static UnitRepository unitRepository = new UnitRepositoryImpl();
	private static RouterRepository routerRepository = new RouterRepositoryImpl();
	private static TextRepository textRepository = new TextRepositoryImpl();
	
	private JFrame frameUserWindow;
	private JComboBox comboBoxSehir;
	private JComboBox comboBoxBirim;
	private JComboBox comboBoxRouterMarka;
	private JComboBox comboBoxRouterModel;
	
	private String tempRouterBrand;
	private String tempRouterModel;
	private JTextArea textAreaAciklamaKonusu;
	private JTextArea textAreaAciklama;
	private JButton btnKaydet;
	
	private JLayeredPane layeredPane;
	
	private JMenuItem mntmAciklamalariGor;
	private JMenuItem mntmAciklamaEkle;
	
	private JPanel panelAciklamaEkle;
	private JPanel panelAciklamalariGor;
	
	private JTable tableTextData;
	private JScrollPane scrollPaneTextData;
	
	private JComboBox comboBoxKullaniciAdiAG;
	private JComboBox comboBoxSehirAG;
	private JComboBox comboBoxBirimAG;
	private JComboBox comboBoxRouterMarkaAG;
	private JComboBox comboBoxRouterModelAG;
	
	private JButton btnAra;
	private JLayeredPane layeredPaneGuncelleAG;
	private JPanel panelGuncelleAG;
	private JButton btnGuncelleAG;
	
	private int userID;
	
	private int userIDAG;
	private int provinceID;
	private int unitID;
	private int routerID;
	private int textID;
	
	private int provinceIDAG;  // AG kýsaltmasý Açýklamalarý Gör paneli anlamýnda
	private int unitIDAG;
	private int routerIDAG;
	
	private List<String> names;
	
	private static String ceProvinceName, ceUnitName, ceRouterBrandName, ceRouterModelName;
	private static String ceProvinceNameAG, ceUnitNameAG, ceRouterBrandNameAG, ceRouterModelNameAG;
	
	private LoginWindow loginWindow;
	private JPanel panelHakkinda;
	private JMenuItem mntmHakkinda;
	private JButton btnSil;
	private JMenu mntmCikis;
	private JTextArea textAreaGuncelleAG;
	private JButton btnKaydetAG;
	
	
	/*
	public UserWindow() {
		initialize();
	}
	*/
	
	public UserWindow(int userID) {
		this.userID = userID;
		initialize();
	}
	
	private void initialize() {
		
		frameUserWindow = new JFrame();
		frameUserWindow.setVisible(true);
		frameUserWindow.getContentPane().setFont(new Font("Century Gothic", Font.PLAIN, 13));
		frameUserWindow.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 32, 961, 344);
		frameUserWindow.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		frameUserWindow.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hyyasar\\eclipse-workspace\\com.networkproject\\src\\test\\resources\\nproIco.png"));
		frameUserWindow.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		frameUserWindow.setTitle("NetwoPro");
		frameUserWindow.setBounds(100, 100, 997, 435);
		frameUserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frameUserWindow.setJMenuBar(menuBar);
		
		JMenu mnNetwopro = new JMenu("NetwoPro");
		mnNetwopro.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		menuBar.add(mnNetwopro);
		
		mntmHakkinda = new JMenuItem("Hakk\u0131nda");
		mntmHakkinda.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		mnNetwopro.add(mntmHakkinda);
		
		JMenu mnAklama = new JMenu("A\u00E7\u0131klama");
		mnAklama.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		menuBar.add(mnAklama);
		
		mntmAciklamaEkle = new JMenuItem("A\u00E7\u0131klama Ekle");
		mntmAciklamaEkle.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		mnAklama.add(mntmAciklamaEkle);
		
		mntmAciklamalariGor = new JMenuItem("A\u00E7\u0131klamalar\u0131 G\u00F6r");
		mntmAciklamalariGor.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		mnAklama.add(mntmAciklamalariGor);
		
		mntmCikis = new JMenu("\u00C7\u0131k\u0131\u015F");
		mntmCikis.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		menuBar.add(mntmCikis);
		
		initializePanelAciklamaEkle();
		
		initializePanelAciklamalariGor();
		
		initializePanelHakkinda();
		
		createEvents();
	}
	
	public void initializePanelAciklamaEkle() {
		
		panelAciklamaEkle = new JPanel();
		panelAciklamaEkle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(panelAciklamaEkle, "name_24117055766127");
		panelAciklamaEkle.setLayout(null);
		
		comboBoxSehir = new JComboBox();
		comboBoxSehir.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxSehir.setBounds(10, 11, 176, 20);
		panelAciklamaEkle.add(comboBoxSehir);
		
		
		{   // we populate comboBox in parts like this (as fetch data from database and set comboBox)  
			names = new ArrayList<String>();
			names.add(0, "Þehir Seçiniz");
			names.addAll(provinceRepository.findAllProvinceNames());
			comboBoxSehir.setModel(new DefaultComboBoxModel(names.toArray()));
		}
		
		comboBoxBirim = new JComboBox();
		comboBoxBirim.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxBirim.setBounds(10, 42, 176, 20);
		panelAciklamaEkle.add(comboBoxBirim);
		comboBoxBirim.setEnabled(false);
		
		comboBoxRouterMarka = new JComboBox();
		comboBoxRouterMarka.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxRouterMarka.setBounds(10, 73, 176, 20);
		panelAciklamaEkle.add(comboBoxRouterMarka);
		comboBoxRouterMarka.setEnabled(false);
		
		
		comboBoxRouterModel = new JComboBox();
		comboBoxRouterModel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxRouterModel.setBounds(10, 104, 176, 20);
		panelAciklamaEkle.add(comboBoxRouterModel);
		comboBoxRouterModel.setEnabled(false);
		
		
		JScrollPane scrollPaneAciklamaKonusu = new JScrollPane();
		scrollPaneAciklamaKonusu.setBounds(10, 135, 176, 37);
		panelAciklamaEkle.add(scrollPaneAciklamaKonusu);
		
		textAreaAciklamaKonusu = new JTextArea();
		textAreaAciklamaKonusu.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		textAreaAciklamaKonusu.setLineWrap(true);
		scrollPaneAciklamaKonusu.setViewportView(textAreaAciklamaKonusu);
		
		JScrollPane scrollPaneAciklama = new JScrollPane();
		scrollPaneAciklama.setBounds(10, 183, 941, 94);
		panelAciklamaEkle.add(scrollPaneAciklama);
		
		textAreaAciklama = new JTextArea();
		textAreaAciklama.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		textAreaAciklama.setLineWrap(true);
		scrollPaneAciklama.setViewportView(textAreaAciklama);
		
		btnKaydet = new JButton("Kaydet");
		btnKaydet.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnKaydet.setBounds(862, 288, 89, 23);
		panelAciklamaEkle.add(btnKaydet);
		btnKaydet.setEnabled(false);
		
		JLabel lblAciklamaEkle = new JLabel("A\u00E7\u0131klama Ekle");
		lblAciklamaEkle.setBounds(862, 0, 99, 14);
		panelAciklamaEkle.add(lblAciklamaEkle);
		lblAciklamaEkle.setForeground(Color.GRAY);
		lblAciklamaEkle.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		
	}
	
	public void initializePanelAciklamalariGor() {
		
		panelAciklamalariGor = new JPanel();
		panelAciklamalariGor.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(panelAciklamalariGor, "name_24970926650141");
		panelAciklamalariGor.setLayout(null);
		
		comboBoxKullaniciAdiAG = new JComboBox();
		comboBoxKullaniciAdiAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxKullaniciAdiAG.setBounds(10, 26, 176, 20);
		panelAciklamalariGor.add(comboBoxKullaniciAdiAG);
		
		{   // we populate comboBox in parts like this (as fetch data from database and set comboBox)  
			names = new ArrayList<String>();
			names.add(0, "Kullanýcý Adý Seçiniz");
			names.addAll(userRepository.findAllUserNames());
			comboBoxKullaniciAdiAG.setModel(new DefaultComboBoxModel(names.toArray()));
		}
		
		comboBoxSehirAG = new JComboBox();
		comboBoxSehirAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxSehirAG.setBounds(10, 57, 176, 20);
		panelAciklamalariGor.add(comboBoxSehirAG);
		
		{
			names = new ArrayList<String>();
			names.add(0, "Þehir Seçiniz");
			names.addAll(provinceRepository.findAllProvinceNames());
			comboBoxSehirAG.setModel(new DefaultComboBoxModel(names.toArray()));
		}
		
		comboBoxBirimAG = new JComboBox();
		comboBoxBirimAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxBirimAG.setBounds(10, 88, 176, 20);
		panelAciklamalariGor.add(comboBoxBirimAG);
		comboBoxBirimAG.setEnabled(false);
	
		comboBoxRouterMarkaAG = new JComboBox();
		comboBoxRouterMarkaAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxRouterMarkaAG.setBounds(10, 116, 176, 20);
		panelAciklamalariGor.add(comboBoxRouterMarkaAG);
		comboBoxRouterMarkaAG.setEnabled(false);

	
		comboBoxRouterModelAG = new JComboBox();
		comboBoxRouterModelAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		comboBoxRouterModelAG.setBounds(10, 147, 176, 20);
		panelAciklamalariGor.add(comboBoxRouterModelAG);
		comboBoxRouterModelAG.setEnabled(false);

		
		btnAra = new JButton("G\u00F6ster");
		btnAra.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnAra.setBounds(92, 178, 94, 34);
		panelAciklamalariGor.add(btnAra);
		
		JLabel lblAciklamalariGor = new JLabel("A\u00E7\u0131klamalar\u0131 G\u00F6r");
		lblAciklamalariGor.setForeground(Color.GRAY);
		lblAciklamalariGor.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblAciklamalariGor.setBounds(842, 0, 119, 14);
		panelAciklamalariGor.add(lblAciklamalariGor);
		
		scrollPaneTextData = new JScrollPane();
		scrollPaneTextData.setBounds(196, 26, 755, 157);
		panelAciklamalariGor.add(scrollPaneTextData);
		
		
		tableTextData = new JTable();
		tableTextData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		scrollPaneTextData.setViewportView(tableTextData);

		
		btnGuncelleAG = new JButton("G\u00FCncelle");
		btnGuncelleAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnGuncelleAG.setBounds(703, 189, 119, 23);
		panelAciklamalariGor.add(btnGuncelleAG);
		
		btnSil = new JButton("Sil");
		btnSil.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnSil.setBounds(832, 189, 119, 23);
		panelAciklamalariGor.add(btnSil);
		
		layeredPaneGuncelleAG = new JLayeredPane();
		layeredPaneGuncelleAG.setVisible(false);
		layeredPaneGuncelleAG.setBounds(10, 229, 951, 104);
		panelAciklamalariGor.add(layeredPaneGuncelleAG);
		layeredPaneGuncelleAG.setLayout(null);
		
		panelGuncelleAG = new JPanel();
		panelGuncelleAG.setBounds(0, 0, 962, 104);
		layeredPaneGuncelleAG.add(panelGuncelleAG);
		panelGuncelleAG.setLayout(null);
		
		JScrollPane scrollPaneGuncelleAG = new JScrollPane();
		scrollPaneGuncelleAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		scrollPaneGuncelleAG.setBounds(0, 11, 940, 64);
		panelGuncelleAG.add(scrollPaneGuncelleAG);
		
		textAreaGuncelleAG = new JTextArea();
		textAreaGuncelleAG.setLineWrap(true);
		textAreaGuncelleAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		scrollPaneGuncelleAG.setViewportView(textAreaGuncelleAG);
		
		btnKaydetAG = new JButton("Kaydet");
		btnKaydetAG.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		btnKaydetAG.setBounds(805, 81, 119, 23);
		panelGuncelleAG.add(btnKaydetAG);
		
		
	}
	
	public void initializePanelHakkinda() {
		
		panelHakkinda = new JPanel();
		layeredPane.add(panelHakkinda, "name_25007519396904");
		panelHakkinda.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(106, 58, 755, 178);
		panelHakkinda.add(scrollPane);
		
		JTextPane txtHakkinda = new JTextPane();
		txtHakkinda.setBackground(UIManager.getColor("Button.background"));
		txtHakkinda.setEditable(false);
		scrollPane.setViewportView(txtHakkinda);
		txtHakkinda.setText("Bu program Temmuz 2019 - Eyl\u00FCl 2019 tarihleri aras\u0131nda bu kurumda staj yapan bir \u00F6\u011Frenci taraf\u0131ndan yap\u0131lm\u0131\u015Ft\u0131r.\r\n\r\nYard\u0131mlar\u0131 i\u00E7in Ertem Yabac\u0131' ya te\u015Fekk\u00FCrler...");
		txtHakkinda.setFont(new Font("Consolas", Font.PLAIN, 15));
		
	}
	
	public void createEvents() {
		
		comboBoxSehir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ceProvinceName = ((String)(comboBoxSehir.getSelectedItem()));
				provinceID = provinceRepository.findProvinceByProvinceName(ceProvinceName).getProvinceId();
				
				ArrayList<String> unitNames = new ArrayList<String>();
				
				unitNames.add(0, "Birim Seçiniz");
				unitNames.addAll(unitRepository.findUnitNamesByProvinceId(provinceID));
				
				comboBoxBirim.setModel(new DefaultComboBoxModel(unitNames.toArray()));

				comboBoxBirim.setEnabled(true);
				
			}
		});
		
		comboBoxBirim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ceUnitName = (String)(comboBoxBirim.getSelectedItem());
				unitID = unitRepository.findUnitByUnitName(ceUnitName).getUnitId();
				
				ArrayList<String> routerBrandNames = new ArrayList<String>();
				
				routerBrandNames.add(0, "Router Markasý Seçiniz");
				routerBrandNames.addAll(routerRepository.findRouterBrandsByProvinceIdAndUnitId(provinceID, unitID));
				comboBoxRouterMarka.setModel(new DefaultComboBoxModel(routerBrandNames.toArray()));

				comboBoxRouterMarka.setEnabled(true);
				
			}
		});
		
		comboBoxRouterMarka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				ceRouterBrandName = (String) (comboBoxRouterMarka.getSelectedItem());
				routerID = routerRepository.findRouterByRouterBrandName(ceRouterBrandName).getRouterId();
				
				ArrayList<String> routerModelNames = new ArrayList<String>();
				
				routerModelNames.add(0, "Router Modeli Seçiniz");
				routerModelNames.addAll(routerRepository.findRouterModelsByProvinceIdUnitIdRouterId(provinceID, unitID, routerID));
				comboBoxRouterModel.setModel(new DefaultComboBoxModel(routerModelNames.toArray()));

				comboBoxRouterModel.setEnabled(true);				
				
			}
		});
		
		comboBoxRouterModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					ceRouterModelName = (String) (comboBoxRouterModel.getSelectedItem());
			
					if((comboBoxSehir != null && comboBoxSehir.getSelectedItem() != "Þehir Seçiniz") &&
							(comboBoxBirim != null && comboBoxBirim.getSelectedItem() != "Birim Seçiniz") &&
								(comboBoxRouterMarka != null && comboBoxRouterMarka.getSelectedItem() != "Router Markasý Seçiniz") &&
									(comboBoxRouterModel != null && comboBoxRouterModel.getSelectedItem() != "Router Modeli Seçiniz")) {
						
						btnKaydet.setEnabled(true);
						
					}
			}
		});
		
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if((comboBoxSehir != null && comboBoxSehir.getSelectedItem() != "Þehir Seçiniz") &&
						(comboBoxBirim != null && comboBoxBirim.getSelectedItem() != "Birim Seçiniz") &&
							(comboBoxRouterMarka != null && comboBoxRouterMarka.getSelectedItem() != "Router Markasý Seçiniz") &&
								(comboBoxRouterModel != null && comboBoxRouterModel.getSelectedItem() != "Router Modeli Seçiniz")) {
									
			    role = roleRepository.findRoleByUserId(userID);
				
				user = userRepository.findUserByUserName(userRepository.findUserById(userID).getUserName());
				
				province = provinceRepository.findProvinceByProvinceName(ceProvinceName);
				
				unit = unitRepository.findUnitByUnitName(ceUnitName);
				
				router = routerRepository.findRouterByRouterBrandAndRouterModel(ceRouterBrandName, ceRouterModelName);
				
				text = new Text(textAreaAciklamaKonusu.getText(), textAreaAciklama.getText(), new Date(), null, unit, router, province, user);
				
				insertData(role, user, province, unit, router, text);
				
				JOptionPane.showMessageDialog(null, " "+ "aciklamaniz kaydedilmistir.");
				
				}else {
					JOptionPane.showMessageDialog(null, " "+ "Açýklamanýz kaydedilemedi. \n\nLütfen þehir, birim, router markasý ve router modeli seçimlerinizi eksiksiz yapýnýz.");
				}
				
			}
		});
		
		mntmAciklamaEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				layeredPane.removeAll();
				layeredPane.add(panelAciklamaEkle);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		
		mntmAciklamalariGor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				layeredPane.removeAll();
				layeredPane.add(panelAciklamalariGor);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		
		mntmHakkinda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				layeredPane.removeAll();
				layeredPane.add(panelHakkinda);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		
		
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(comboBoxKullaniciAdiAG.getSelectedItem() != null && (String) comboBoxKullaniciAdiAG.getSelectedItem() != "Kullanýcý Adý Seçiniz") {

					String tempUserName = (String) comboBoxKullaniciAdiAG.getSelectedItem();
					
					userIDAG = userRepository.findUserIdByUserName(tempUserName);
					
					List<Text> texts = textRepository.findTextsByUserName(tempUserName);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();
			        
			        columns.add("TID");
			        columns.add("Kullanýcý Adý");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getUser().getUserName(), texts.get(i).getSubject(), texts.get(i).getText(), 
			            						texts.get(i).getProvince().getProvinceName(), texts.get(i).getUnit().getUnitName(), 
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
					
				}
				
				
				else if(comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz") {
					
					String tempProvinceName = (String) comboBoxSehirAG.getSelectedItem();
					
					provinceIDAG = provinceRepository.findProvinceByProvinceName(tempProvinceName).getProvinceId();
					
					List<Text> texts = textRepository.findTextsByProvinceName(tempProvinceName);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();
			        
			        columns.add("TID");
			        columns.add("Þehir");
			        columns.add("Kullanýcý Adý");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Birim");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getProvince().getProvinceName(), texts.get(i).getUser().getUserName(), 
			            						texts.get(i).getSubject(), texts.get(i).getText(), texts.get(i).getUnit().getUnitName(), 
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
					
					
				}
				
				if((comboBoxKullaniciAdiAG.getSelectedItem() != null && (String) comboBoxKullaniciAdiAG.getSelectedItem() != "Kullanýcý Adý Seçiniz")
						&& (comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz")) {
					
					List<Text> texts = textRepository.findTextsByUserIdAndProvinceId(userIDAG, provinceIDAG);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();

			        columns.add("TID");
			        columns.add("Kullanýcý Adý");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getUser().getUserName(), texts.get(i).getProvince().getProvinceName(),
			            					texts.get(i).getUnit().getUnitName(), texts.get(i).getSubject(), texts.get(i).getText(),  
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
					
				}

				
				if((comboBoxKullaniciAdiAG.getSelectedItem() != null && (String) comboBoxKullaniciAdiAG.getSelectedItem() != "Kullanýcý Adý Seçiniz")
						&& (comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz") && 
						(comboBoxBirimAG.getSelectedItem() != null && (String) comboBoxBirimAG.getSelectedItem() != "Birim Seçiniz")) {
					
					String tempUnitName = (String) comboBoxBirimAG.getSelectedItem();
					
					unitIDAG = unitRepository.findUnitByUnitName(tempUnitName).getUnitId();
					
					List<Text> texts = textRepository.findTextsByUserIdAndProvinceIdAndUnitId(userIDAG, provinceIDAG, unitIDAG);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();

			        columns.add("TID");
			        columns.add("Kullanýcý Adý");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getUser().getUserName(), texts.get(i).getProvince().getProvinceName(),
			            						texts.get(i).getUnit().getUnitName(), texts.get(i).getSubject(), texts.get(i).getText(),  
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
					
				}
				
				if((comboBoxKullaniciAdiAG.getSelectedItem() != null && (String) comboBoxKullaniciAdiAG.getSelectedItem() != "Kullanýcý Adý Seçiniz")
					&& (comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz") && 
					(comboBoxBirimAG.getSelectedItem() != null && (String) comboBoxBirimAG.getSelectedItem() != "Birim Seçiniz") && 
				 (comboBoxRouterMarkaAG.getSelectedItem() != null && (String) comboBoxRouterMarkaAG.getSelectedItem() != "Router Markasý Seçiniz")) {
					
					ceRouterBrandNameAG = (String) comboBoxRouterMarkaAG.getSelectedItem();
					
					routerIDAG = routerRepository.findRouterByRouterBrandName(ceRouterBrandNameAG).getRouterId();
					
					List<Text> texts = textRepository.findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandName(userIDAG, provinceIDAG, unitIDAG, ceRouterBrandNameAG);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();

			        columns.add("TID");
			        columns.add("Kullanýcý Adý");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Router Marka");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getUser().getUserName(), texts.get(i).getProvince().getProvinceName(),
			            						texts.get(i).getUnit().getUnitName(), texts.get(i).getRouter().getRouterBrand(), 
			            						texts.get(i).getSubject(), texts.get(i).getText(),   
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
				}
				
				
				if((comboBoxKullaniciAdiAG.getSelectedItem() != null && (String) comboBoxKullaniciAdiAG.getSelectedItem() != "Kullanýcý Adý Seçiniz")
						&& (comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz") && 
						(comboBoxBirimAG.getSelectedItem() != null && (String) comboBoxBirimAG.getSelectedItem() != "Birim Seçiniz") && 
					 (comboBoxRouterMarkaAG.getSelectedItem() != null && (String) comboBoxRouterMarkaAG.getSelectedItem() != "Router Markasý Seçiniz") 
					 && (comboBoxRouterModelAG.getSelectedItem() != null && (String) comboBoxRouterModelAG.getSelectedItem() != "Router Modeli Seçiniz")) {
					
					ceRouterModelNameAG = (String) comboBoxRouterModelAG.getSelectedItem();
					
					List<Text> texts = textRepository.findTextsByUserIdAndProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName(userIDAG, provinceIDAG, unitIDAG, ceRouterBrandNameAG, ceRouterModelNameAG);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();
			        
			        columns.add("TID");
			        columns.add("Kullanýcý Adý");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Router Marka");
			        columns.add("Router Model");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getUser().getUserName(), texts.get(i).getProvince().getProvinceName(),
			            						texts.get(i).getUnit().getUnitName(), texts.get(i).getRouter().getRouterBrand(), 
			            						texts.get(i).getRouter().getRouterModel(), texts.get(i).getSubject(), texts.get(i).getText(),   
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }			        
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
				}
				
				
				if((comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz") && 
						(comboBoxBirimAG.getSelectedItem() != null && (String) comboBoxBirimAG.getSelectedItem() != "Birim Seçiniz")) {
					
					ceProvinceNameAG = (String) comboBoxSehirAG.getSelectedItem();
					ceUnitNameAG = (String) comboBoxBirimAG.getSelectedItem();
					
					provinceIDAG = provinceRepository.findProvinceByProvinceName(ceProvinceNameAG).getProvinceId();
					unitIDAG = unitRepository.findUnitByUnitName(ceUnitNameAG).getUnitId();
					
					List<Text> texts = textRepository.findTextsByProvinceIdAndUnitId(provinceIDAG, unitIDAG);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();
					
			        columns.add("TID");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Kullanýcý Adý");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getProvince().getProvinceName(),texts.get(i).getUnit().getUnitName(), 
			            						texts.get(i).getUser().getUserName(), texts.get(i).getSubject(), texts.get(i).getText(),  
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
				}
				
				
				if((comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz") && 
						(comboBoxBirimAG.getSelectedItem() != null && (String) comboBoxBirimAG.getSelectedItem() != "Birim Seçiniz")
						&& (comboBoxRouterMarkaAG.getSelectedItem() != null && (String) comboBoxRouterMarkaAG.getSelectedItem() != "Router Markasý Seçiniz")) {
					
					ceProvinceNameAG = (String) comboBoxSehirAG.getSelectedItem();
					ceUnitNameAG = (String) comboBoxBirimAG.getSelectedItem();
					ceRouterBrandNameAG = (String) comboBoxRouterMarkaAG.getSelectedItem();
					
					provinceIDAG = provinceRepository.findProvinceByProvinceName(ceProvinceNameAG).getProvinceId();
					unitIDAG = unitRepository.findUnitByUnitName(ceUnitNameAG).getUnitId();
					routerIDAG = routerRepository.findRouterByRouterBrandName(ceRouterBrandNameAG).getRouterId();
					
					List<Text> texts = textRepository.findTextsByProvinceIdAndUnitIdAndRouterBrandName(provinceIDAG, unitIDAG, ceRouterBrandNameAG);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();
					
			        columns.add("TID");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Router Marka");
			        columns.add("Kullanýcý Adý");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getProvince().getProvinceName(),texts.get(i).getUnit().getUnitName(), 
			            						texts.get(i).getRouter().getRouterBrand() ,texts.get(i).getUser().getUserName(), 
			            						texts.get(i).getSubject(), texts.get(i).getText(),  
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
				}
				
				
				
				if((comboBoxSehirAG.getSelectedItem() != null && (String) comboBoxSehirAG.getSelectedItem() != "Þehir Seçiniz") && 
						(comboBoxBirimAG.getSelectedItem() != null && (String) comboBoxBirimAG.getSelectedItem() != "Birim Seçiniz")
						&& (comboBoxRouterMarkaAG.getSelectedItem() != null && (String) comboBoxRouterMarkaAG.getSelectedItem() != "Router Markasý Seçiniz")
						&& (comboBoxRouterModelAG.getSelectedItem() != null && (String) comboBoxRouterModelAG.getSelectedItem() != "Router Modeli Seçiniz")) {
					
					ceProvinceNameAG = (String) comboBoxSehirAG.getSelectedItem();
					ceUnitNameAG = (String) comboBoxBirimAG.getSelectedItem();
					ceRouterBrandNameAG = (String) comboBoxRouterMarkaAG.getSelectedItem();
					ceRouterModelNameAG = (String) comboBoxRouterModelAG.getSelectedItem();
					
					provinceIDAG = provinceRepository.findProvinceByProvinceName(ceProvinceNameAG).getProvinceId();
					unitIDAG = unitRepository.findUnitByUnitName(ceUnitNameAG).getUnitId();
					routerIDAG = routerRepository.findRouterByRouterBrandName(ceRouterBrandNameAG).getRouterId();
					
					List<Text> texts = textRepository.findTextsByProvinceIdAndUnitIdAndRouterBrandNameAndRouterModelName(provinceIDAG, unitIDAG, ceRouterBrandNameAG, ceRouterModelNameAG);
					
					List<String> columns = new ArrayList<String>();
			        List<Object[]> values = new ArrayList<Object[]>();
					
			        columns.add("TID");
			        columns.add("Þehir");
			        columns.add("Birim");
			        columns.add("Router Marka");
			        columns.add("Router Model");
			        columns.add("Kullanýcý Adý");
			        columns.add("Açýklama Konusu");
			        columns.add("Açýklama");
			        columns.add("Eklenme Trh");
			        columns.add("Güncellenme Trh");
			        
			        
			        for (int i = 0; i < texts.size(); i++) {
			            values.add(new Object[] {texts.get(i).getTextId(), texts.get(i).getProvince().getProvinceName(),texts.get(i).getUnit().getUnitName(), 
			            						texts.get(i).getRouter().getRouterBrand(), texts.get(i).getRouter().getRouterModel(), 
			            						texts.get(i).getUser().getUserName(), texts.get(i).getSubject(), texts.get(i).getText(),  
			            						texts.get(i).getAddDate(), texts.get(i).getUpdateDate()});
			        }
			        
			        DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
			        tableTextData = new JTable(tableModel){
			            private static final long serialVersionUID = 1L;

			            public boolean isCellEditable(int row, int column) {                
			                    return false;               
			            };
			        };
			        tableTextData.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			        scrollPaneTextData.setViewportView(tableTextData);
			        scrollPaneTextData.setVisible(true);
				}
				
			}
		});
		
		
		comboBoxSehirAG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ceProvinceNameAG = ((String)(comboBoxSehirAG.getSelectedItem()));
				provinceIDAG = provinceRepository.findProvinceByProvinceName(ceProvinceNameAG).getProvinceId();
				
				ArrayList<String> unitNames = new ArrayList<String>();
				
				unitNames.add(0, "Birim Seçiniz");
				unitNames.addAll(unitRepository.findUnitNamesByProvinceId(provinceIDAG));
				
				comboBoxBirimAG.setModel(new DefaultComboBoxModel(unitNames.toArray()));
				comboBoxBirimAG.setEnabled(true);
				
			}
		});
		
		
		comboBoxBirimAG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ceUnitNameAG = (String)(comboBoxBirimAG.getSelectedItem());
				unitIDAG = unitRepository.findUnitByUnitName(ceUnitNameAG).getUnitId();
				
				ArrayList<String> routerBrandNames = new ArrayList<String>();
				
				routerBrandNames.add(0, "Router Markasý Seçiniz");
				routerBrandNames.addAll(routerRepository.findRouterBrandsByProvinceIdAndUnitId(provinceIDAG, unitIDAG));

				comboBoxRouterMarkaAG.setModel(new DefaultComboBoxModel(routerBrandNames.toArray()));
				comboBoxRouterMarkaAG.setEnabled(true);
				
			}
		});
		
		comboBoxRouterMarkaAG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ceRouterBrandNameAG = (String) (comboBoxRouterMarkaAG.getSelectedItem());
				routerIDAG = routerRepository.findRouterByRouterBrandName(ceRouterBrandNameAG).getRouterId();
				
				ArrayList<String> routerModelNames = new ArrayList<String>();
				
				routerModelNames.add(0, "Router Modeli Seçiniz");
				routerModelNames.addAll(routerRepository.findRouterModelsByProvinceIdUnitIdRouterId(provinceIDAG, unitIDAG, routerIDAG));
				
				comboBoxRouterModelAG.setModel(new DefaultComboBoxModel(routerModelNames.toArray()));
				comboBoxRouterModelAG.setEnabled(true);
				
			}
		});
		
		
		comboBoxRouterModelAG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ceRouterModelNameAG = (String) (comboBoxRouterModelAG.getSelectedItem());

			}
		});
		
		
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
					
				TableModel model = tableTextData.getModel();
				
				int rowIndex = tableTextData.getSelectedRow();
				
				int textId = (int) model.getValueAt(rowIndex, 0);
				
				Text textTemp =  textRepository.findTextById(textId);
				
				if(textTemp.getUser().getUserId() == userID) {
					
					textRepository.deleteText(textRepository.findTextById(textId));
				
				}else {
					JOptionPane.showMessageDialog(null, " "+ "Bu açýklamayý silemezsiniz. \n\nSadece kendi yazdýðýnýz bir açýklamayý silebilirsiniz.");
				}
				
				
				//satýrý tablodan kaldýrýyoruz.
				DefaultTableModel model2 = (DefaultTableModel) tableTextData.getModel();
				model2.removeRow(rowIndex);
				
				JOptionPane.showMessageDialog(null, " "+ "Seçilen açýklama baþarýyla silinmiþtir.");
				
				
			}	 
		});
		
		
		mntmCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				System.exit(0);
			
			}
		});
	
		
		btnGuncelleAG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				layeredPaneGuncelleAG.setVisible(true);
				
				/*
				panelGuncelleAG.removeAll();
				panelGuncelleAG.add(panelGuncelleAG);
				panelGuncelleAG.repaint();
				panelGuncelleAG.revalidate();
				*/
				
				TableModel model = tableTextData.getModel();
				
				int rowIndex = tableTextData.getSelectedRow();
				
				textID = (int) model.getValueAt(rowIndex, 0);
				
				textAreaGuncelleAG.setText(textRepository.findTextById(textID).getText());
				
			}
		});
		
		
		btnKaydetAG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Text text = textRepository.findTextById(textID);

				String newText = textAreaGuncelleAG.getText();
				
				text.setText(newText);
				
				if(text.getUser().getUserId() == userID) {
					
					//veritabanýndaki veriyi guncelliyoruz.
					Text guncelText = textRepository.updateText(text);
					text.setUpdateDate(new Date());
				
					JOptionPane.showMessageDialog(null, " "+ "Açýklamanýz guncellenmistir. \nGüncellemeyi görmek için Göster butonuna basýnýz..");
				}else {
					JOptionPane.showMessageDialog(null, " "+ "Bu açýklamayý güncelleyemezsiniz. \n\nSadece kendi yazdýðýnýz bir açýklamayý güncelleyebilirsiniz.");
				}
			
			}
		});
		
	}

	
	public static void insertData(Role role, User user, Province province, Unit unit, Router router, Text text) {
		
		roleRepository.saveRole(role);
		userRepository.saveUser(user);
		provinceRepository.saveProvince(province);
		unitRepository.saveUnit(unit);
		routerRepository.saveRouter(router);
		textRepository.saveText(text);
		
	}
	
	public Role insertRoleToDb(String roleName) {
		
		role = new Role(roleName);
		role = roleRepository.saveRole(role);
		return role;
	}
	
	public User insertUserToDB(String firstName, String lastName, String userName, String password, String email, Role role) {
		
		user = new User(firstName, lastName, userName, password, email, role);
		user = userRepository.saveUser(user);
		return user;
		
	}
	
	public Province insertProvinceToDB(String provinceName) {
		
		province = new Province(provinceName);
		province = provinceRepository.saveProvince(province);
		return province;
	}
	
	public Unit insertUnitToDb(String unitName, Province province) {
		
		unit = new Unit(unitName, province);
		unit = unitRepository.saveUnit(unit);
		return unit;
	}
	
	public void insertRouterToDb(String routerBrand, String routerModel, Province province, Unit unit) {
		
		router = new Router(routerBrand, routerModel, province, unit);
		routerRepository.saveRouter(router);
	}
	
	
	public static String getCeProvinceName() {
		return ceProvinceName;
	}


	public static void setCeProvinceName(String ceProvinceName) {
		UserWindow.ceProvinceName = ceProvinceName;
	}


	public static String getCeUnitName() {
		return ceUnitName;
	}


	public static void setCeUnitName(String ceUnitName) {
		UserWindow.ceUnitName = ceUnitName;
	}


	public static String getCeRouterBrandName() {
		return ceRouterBrandName;
	}


	public static void setCeRouterBrandName(String ceRouterBrandName) {
		UserWindow.ceRouterBrandName = ceRouterBrandName;
	}


	public static String getCeRouterModelName() {
		return ceRouterModelName;
	}


	public static void setCeRouterModelName(String ceRouterModelName) {
		UserWindow.ceRouterModelName = ceRouterModelName;
	}


	public JFrame getFrame() {
		return frameUserWindow;
	}

	public void setFrame(JFrame frame) {
		this.frameUserWindow = frame;
	}


	public JButton getBtnKaydet() {
		return btnKaydet;
	}


	public void setBtnKaydet(JButton btnKaydet) {
		this.btnKaydet = btnKaydet;
	}
}
