/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shell;

import Forms.BrazilPanel;
import Forms.GabrielPanel;
import Forms.MainFrame;
import Forms.ReferencesPanel;
import Forms.TablePanel;
import Interfaces.IMainFrame;

import Interfaces.IRegionButton;
import Interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import medicionalbrazil.regions.CenterWestButton;
import medicionalbrazil.regions.NorthButton;
import medicionalbrazil.regions.NortheastButton;
import medicionalbrazil.regions.SouthButton;
import medicionalbrazil.regions.SoutheastButton;

/**
 *
 * @author gabriel
 */
public class UiController implements IUiController {

    private List<IRegionButton> allButtons;
    private MainFrame application;
    private JPanel brazilPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    public UiController() throws IOException {
        application = new MainFrame();
        application.setVisible(true);
    }

    public void initializeComponents() {
        allButtons = new ArrayList<>();

        NortheastButton northeast = new NortheastButton();
        allButtons.add(northeast);
        CenterWestButton centerwest = new CenterWestButton();
        allButtons.add(centerwest);
        NorthButton north = new NorthButton();
        allButtons.add(north);
        SoutheastButton southEast = new SoutheastButton();
        allButtons.add(southEast);
        SouthButton south = new SouthButton();
        allButtons.add(south);
        //Aqui, adiciono outros botões

        addBackgroundPhoto(application.getjPanel4(), getClass().getClassLoader().getResource("resources/icons/background.png"));
        application.getjPanel4().setBackground(new Color(0, 0, 0, 100));
        addBackgroundPhoto(application.getjPanel3(), getClass().getClassLoader().getResource("resources/icons/barra.png"));

        try {
            installAllButtons();
        } catch (IOException ex) {
            Logger.getLogger(UiController.class.getName()).log(Level.SEVERE, null, ex);
        }

        brazilPanel = application.getjPanel1();
        label1 = application.getjLabel1();
        label2 = application.getjLabel2();
        label3 = application.getjLabel3();
        label4 = application.getjLabel4();
        label5 = application.getjLabel5();

        try {
            installInitialScreen();
        } catch (IOException ex) {
            Logger.getLogger(UiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void installAllButtons() throws IOException {
        for (int i = 0; i < allButtons.size(); i++) {
            allButtons.get(i).installButton(application);
        }
    }

    public List<IRegionButton> getAllButtons() {
        return allButtons;
    }

    @Override
    public void init() throws IOException {
    }

    public void addBackgroundPhoto(JPanel panel, URL address) {
        javax.swing.ImageIcon img = new javax.swing.ImageIcon(address);

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);

        panel.revalidate();
        panel.repaint();
    }

    private void installInitialScreen() throws IOException {
        //------------------------------------------Construir Tela Inicial -------------------
        InputStream IS = ProjectController.class.getResourceAsStream("/resources/funcoes/Introducao.png");

        Image image = ImageIO.read(IS);
        Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
        JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

        application.getjPanel2().removeAll();
        application.getjPanel2().setLayout(new BorderLayout());
        application.getjPanel2().add(labelImage);

        InputStream IS2 = ProjectController.class.getResourceAsStream("/resources/logo/green.png");

        Image image2 = ImageIO.read(IS2);
        Image scaledImage2 = image2.getScaledInstance(application.getjPanel1().getWidth(), application.getjPanel1().getHeight(), Image.SCALE_SMOOTH);
        JLabel labelImage2 = new JLabel(new ImageIcon(scaledImage2));

        application.getjPanel1().removeAll();
        application.getjPanel1().setLayout(new BorderLayout());
        application.getjPanel1().add(labelImage2);
        application.getjPanel1().validate();
        application.getjPanel1().repaint();
        this.application.pack();

        //------------------------------------------Construir Botão Home -------------------
        javax.swing.JButton newButton = application.getjButton2();
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("resources/icons/home.png"))); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        InputStream IS = ProjectController.class.getResourceAsStream("/resources/funcoes/Introducao.png");

                        Image image = ImageIO.read(IS);
                        Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
                        JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

                        application.getjPanel2().removeAll();
                        application.getjPanel2().setLayout(new BorderLayout());
                        application.getjPanel2().add(labelImage);
                        application.getjPanel2().validate();
                        application.getjPanel2().repaint();

                        InputStream IS2 = ProjectController.class.getResourceAsStream("/resources/logo/green.png");

                        Image image2 = ImageIO.read(IS2);
                        Image scaledImage2 = image2.getScaledInstance(application.getjPanel1().getWidth(), application.getjPanel1().getHeight(), Image.SCALE_SMOOTH);
                        JLabel labelImage2 = new JLabel(new ImageIcon(scaledImage2));

                        application.getjPanel1().removeAll();
                        application.getjPanel1().setLayout(new BorderLayout());
                        application.getjPanel1().add(labelImage2);
                        application.getjPanel1().validate();
                        application.getjPanel1().repaint();
                        application.pack();
                    } catch (IOException ex) {
                        Logger.getLogger(UiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            );
        }

        //------------------------------------------Construir Botão Medicinas Regionais -------------------
        newButton = application.getjButton3();
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("resources/icons/regional.png"))); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        InputStream IS = ProjectController.class.getResourceAsStream("/resources/icons/pick-a-region.png");

                        Image image = ImageIO.read(IS);
                        Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
                        JLabel labelImage = new JLabel(new ImageIcon(scaledImage));
                        
                        for(IRegionButton r : allButtons){
                            r.changeMenu(true);
                        }

                        application.getjPanel1().removeAll();
                        application.getjPanel1().setLayout(brazilPanel.getLayout());
                        application.getjPanel1().add(label1);
                        application.getjPanel1().add(label2);
                        application.getjPanel1().add(label3);
                        application.getjPanel1().add(label4);
                        application.getjPanel1().add(label5);
                        application.getjPanel1().add(new JLabel());
                        application.getjPanel1().validate();
                        application.getjPanel1().repaint();

                        application.getjPanel2().removeAll();
                        application.getjPanel2().setLayout(new BorderLayout());
                        application.getjPanel2().add(labelImage);
                        application.getjPanel2().validate();
                        application.getjPanel2().repaint();
                        //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
                        //application.getjPanel2().setLocation(50, 20);
                        application.pack();
                    } catch (IOException ex) {
                        Logger.getLogger(UiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            );
        }

        //------------------------------------------Construir Botão As Regioes -------------------
        newButton = application.getjButton4();
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("resources/icons/regioes.png"))); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        InputStream IS = ProjectController.class.getResourceAsStream("/resources/funcoes/Introducao-regioes.png");

                        Image image = ImageIO.read(IS);
                        Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
                        JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

                        for(IRegionButton r : allButtons){
                            r.changeMenu(false);
                        }

                        application.getjPanel1().removeAll();
                        application.getjPanel1().setLayout(brazilPanel.getLayout());
                        application.getjPanel1().add(label1);
                        application.getjPanel1().add(label2);
                        application.getjPanel1().add(label3);
                        application.getjPanel1().add(label4);
                        application.getjPanel1().add(label5);
                        application.getjPanel1().add(new JLabel());
                        application.getjPanel1().validate();
                        application.getjPanel1().repaint();

                        application.getjPanel2().removeAll();
                        application.getjPanel2().setLayout(new BorderLayout());
                        application.getjPanel2().add(labelImage);
                        application.getjPanel2().validate();
                        application.getjPanel2().repaint();
                        //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
                        //application.getjPanel2().setLocation(50, 20);
                        application.pack();
                    } catch (IOException ex) {
                        Logger.getLogger(UiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            );
        }

        //------------------------------------------Construir Botão Funções -------------------
        newButton = application.getjButton1();
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("resources/icons/funcoes.png"))); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    application.getjButton1().addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            //-------------------------- Display intro
                            InputStream IS2 = ProjectController.class.getResourceAsStream("/resources/funcoes/Intro.png");

                            Image image2 = null;
                            try {
                                image2 = ImageIO.read(IS2);
                            } catch (IOException ex) {
                                Logger.getLogger(UiController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Image scaledImage2 = image2.getScaledInstance(application.getjPanel1().getWidth(), application.getjPanel1().getHeight(), Image.SCALE_SMOOTH);
                            JLabel labelImage2 = new JLabel(new ImageIcon(scaledImage2));

                            application.getjPanel1().removeAll();
                            application.getjPanel1().setLayout(new BorderLayout());
                            application.getjPanel1().add(labelImage2);
                            application.getjPanel1().validate();
                            application.getjPanel1().repaint();
                            application.pack();

                            //---------------------------Build Functions
                            TablePanel panel = new TablePanel();

                            panel.getjButton1().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    Object selected = panel.getjComboBox1().getSelectedItem();

                                    if (selected.toString().equals("Hidrocarbonetos")) {
                                        DefaultListModel listModel = new DefaultListModel();
                                        listModel.addElement("Alcano");
                                        listModel.addElement("Alceno");
                                        listModel.addElement("Alcino");
                                        listModel.addElement("Alcadieno");
                                        listModel.addElement("Aromático");

                                        panel.getjList1().setModel(listModel);
                                    } else if (selected.toString().equals("Funções oxigenadas")) {
                                        DefaultListModel listModel = new DefaultListModel();
                                        listModel.addElement("Álcool");
                                        listModel.addElement("Fenol");
                                        listModel.addElement("Éter");
                                        listModel.addElement("Aldeído");
                                        listModel.addElement("Cetona");
                                        listModel.addElement("Ácido carboxílico");
                                        listModel.addElement("Éster");

                                        panel.getjList1().setModel(listModel);
                                    } else if (selected.toString().equals("Funções nitrogenadas")) {
                                        DefaultListModel listModel = new DefaultListModel();
                                        listModel.addElement("Amina");
                                        listModel.addElement("Amida");
                                        listModel.addElement("Nitrocomposto");
                                        listModel.addElement("Nitrila");

                                        panel.getjList1().setModel(listModel);
                                    } else if (selected.toString().equals("Funções halogenadas")) {
                                        DefaultListModel listModel = new DefaultListModel();
                                        listModel.addElement("Haleto de alquila");
                                        listModel.addElement("Haleto de arila");
                                        listModel.addElement("Haleto de acila");

                                        panel.getjList1().setModel(listModel);
                                    }
                                }

                            });

                            application.getjPanel2().removeAll();
                            application.getjPanel2().setLayout(new BorderLayout());
                            application.getjPanel2().add(panel);
                            application.getjPanel2().validate();
                            application.getjPanel2().repaint();
                            application.pack();

                            MouseListener mouseListener = new MouseAdapter() {
                                public void mouseClicked(MouseEvent mouseEvent) {
                                    JList theList = (JList) mouseEvent.getSource();
                                    if (mouseEvent.getClickCount() == 2) {
                                        int index = theList.locationToIndex(mouseEvent.getPoint());
                                        if (index >= 0) {
                                            try {
                                                Object o = theList.getModel().getElementAt(index);

                                                InputStream IS = UiController.class.getResourceAsStream("/resources/funcoes/" + o.toString() + ".png");
                                                Image image = ImageIO.read(IS);
                                                Image scaledImage = image.getScaledInstance(panel.getjPanel1().getWidth(), panel.getjPanel1().getHeight(), Image.SCALE_SMOOTH);

                                                JLabel labelImage = new JLabel(new ImageIcon(scaledImage));
                                                panel.getjPanel1().removeAll();
                                                panel.getjPanel1().setLayout(new BorderLayout());
                                                panel.getjPanel1().add(labelImage);
                                                panel.getjPanel1().validate();
                                                panel.getjPanel1().repaint();
                                                application.pack();

                                                System.out.println("Double-clicked on: " + o.toString());
                                            } catch (IOException ex) {
                                                Logger.getLogger(UiController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            };
                            panel.getjList1().addMouseListener(mouseListener);
                            //panel.getjList1()
                        }
                    });
                }

            }
            );
        }

        //------------------------------------------Construir Botão Info -------------------
        newButton = application.getjButton5();
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("resources/icons/info.png"))); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    application.getjPanel1().removeAll();
                    application.getjPanel1().setLayout(new BorderLayout());                    
                    GabrielPanel gabrielPanel = new GabrielPanel();
                    gabrielPanel.setOpaque(false);
                    application.getjPanel1().add(gabrielPanel);
                    application.getjPanel1().validate();
                    application.getjPanel1().repaint();
                    
                    
                    application.getjPanel2().removeAll();
                    application.getjPanel2().setLayout(new BorderLayout());
                    ReferencesPanel referencesPanel = new ReferencesPanel();
                     referencesPanel.setOpaque(false);
                    application.getjPanel2().add(referencesPanel);
                    application.getjPanel2().validate();
                    application.getjPanel2().repaint();
                    //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
                    //application.getjPanel2().setLocation(50, 20);
                    application.pack();
                }

            }
            );
        }

    }

    @Override
    public JToolBar getToolBar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
