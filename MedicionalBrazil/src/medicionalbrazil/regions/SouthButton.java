/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicionalbrazil.regions;

import Forms.MainFrame;
import Interfaces.IRegionButton;
import Shell.ProjectController;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class SouthButton implements IRegionButton{
 
    private MainFrame application;
    private MouseAdapter defaultMouseAdapter;
    private JLabel label;
    private JPanel panel;
    private boolean menuRegionalMedicine = true;

    public MouseAdapter getDefaultMouseAdapter() {
        try {
            installButton(application);
        } catch (IOException ex) {
            Logger.getLogger(NortheastButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defaultMouseAdapter;
    }

    public JLabel getLabel() {
        return application.getjLabel5();
    }

    public JPanel getPanel() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void installButton(MainFrame application) throws IOException {

        this.application = application;
        JLabel lblNewLabel = application.getjLabel5();
        JPanel panel = application.getjPanel2();
        ImageIcon regular = new ImageIcon(getClass().getResource("/resources/south/sul-sozinho.png"));
        ImageIcon hovering = new ImageIcon(getClass().getResource("/resources/south/sul-sozinho.png"));
        ImageIcon clicking = new ImageIcon(getClass().getResource("/resources/south/sul-branco.png"));

        // File file = new File("/home/gabriel/NetBeansProjects/MedicionalBrazil/src/resources/northeast/nordeste-branco.png");
        final BufferedImage img = ImageIO.read(getClass().getResource("/resources/southeast/sudeste-branco.png"));

        lblNewLabel.setIcon(regular);

        defaultMouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
                if ((pixel >> 24) == 0x00) {
                    return;
                } else {
                    System.out.println("I was clicked! I really look like a button.");
                    try {
                        addContent(panel); //-----------------------------------------------------------------------Essa é a linha foco
                    } catch (IOException ex) {
                        Logger.getLogger(NortheastButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lblNewLabel.setIcon(clicking);
                }
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
                if ((pixel >> 24) == 0x00) {
                    lblNewLabel.setIcon(regular);
                } else {
                    lblNewLabel.setIcon(hovering);
                }
                super.mouseReleased(e);
            }
        };
        lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int pixel = img.getRGB(e.getPoint().x, e.getPoint().y);
                if ((pixel >> 24) == 0x00) {
                    lblNewLabel.setIcon(regular);
                    lblNewLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                } else {
                    lblNewLabel.setIcon(hovering);
                    lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                super.mouseMoved(e);
            }
        });

        addActionToButton(lblNewLabel, defaultMouseAdapter);

    }

    public void addActionToButton(JLabel lblNewLabel, MouseAdapter mouserAdapter) {
        application.getjPanel2().removeAll();
        lblNewLabel.addMouseListener(mouserAdapter);
    } // Assim, quando adicionar uma nova ação ao botão, só preciso passar o próprio label (com o get), e o mouse adaptar que eu criar, com a ação

    public void removeActionFromButton(JLabel lblNewLabel, MouseAdapter mouserAdapter) {
        lblNewLabel.removeMouseListener(mouserAdapter);
    }

    @Override
    public void addContent(JPanel pnl) throws IOException {
        application.getjPanel2().removeAll();
        if (menuRegionalMedicine) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1)); //2 linhas, 1 coluna             
            panel.setOpaque(false);
            panel.add(createNorthButton());
            panel.add(createSouthButton());
            application.getjPanel2().add(panel);
        } else {
            InputStream IS = ProjectController.class.getResourceAsStream("/resources/south/sul-info.png");

            Image image = ImageIO.read(IS);
            Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel(new ImageIcon(scaledImage));
            application.getjPanel2().setLayout(new BorderLayout());
            application.getjPanel2().add(labelImage);
        }
        application.getjPanel2().validate();
        application.getjPanel2().repaint();
        //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
        //application.getjPanel2().setLocation(50, 20);
        this.application.pack();
    }

    public JButton createNorthButton() {
        javax.swing.JButton newButton = new JButton();
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("resources/south/planta-1.png"))); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    application.getjPanel2().removeAll();
                   application.getjPanel2().setLayout(new BorderLayout());  

                    InputStream IS = NortheastButton.class.getResourceAsStream("/resources/south/estrutura-1.png");

                    Image image = null;
                    try {
                        image = ImageIO.read(IS);
                    } catch (IOException ex) {
                        Logger.getLogger(NorthButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
                    JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

                   //-------------------------------------- Criar clique
                    labelImage.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            // you can open a new frame here as
                            // i have assumed you have declared "frame" as instance variable
                            System.out.println("Entrou aqui!!!!!!");                                                   
                            application.getjPanel2().removeAll();
                    application.getjPanel2().setLayout(new BorderLayout());
                     InputStream IS = NortheastButton.class.getResourceAsStream("/resources/south/Cafeina.png");
                    Image image = null;
                    try {
                        image = ImageIO.read(IS);
                    } catch (IOException ex) {
                        Logger.getLogger(NorthButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
                    JLabel labelImage = new JLabel(new ImageIcon(scaledImage));
                    
                    application.getjPanel2().add(labelImage);
                    application.getjPanel2().validate();
                    application.getjPanel2().repaint();
                    //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
                    //application.getjPanel2().setLocation(50, 20);
                    application.pack();
                        }
                    
                    });
                    //-------------------------------------- Fim do clique
                   

                    application.getjPanel2().add(labelImage);
                    application.getjPanel2().validate();
                    application.getjPanel2().repaint();
                    //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
                    //application.getjPanel2().setLocation(50, 20);
                    application.pack();
                }
            }
            );
        }

        return newButton;
    }

    public JButton createSouthButton() {
        javax.swing.JButton newButton = new JButton();
        newButton.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("resources/south/planta-2.png"))); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    application.getjPanel2().removeAll();
                    application.getjPanel2().setLayout(new BorderLayout());         

                    InputStream IS = NortheastButton.class.getResourceAsStream("/resources/south/estrutura-2.png");

                    Image image = null;
                    try {
                        image = ImageIO.read(IS);
                    } catch (IOException ex) {
                        Logger.getLogger(NorthButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
                    JLabel labelImage = new JLabel(new ImageIcon(scaledImage));

                   //-------------------------------------- Criar clique
                    labelImage.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            // you can open a new frame here as
                            // i have assumed you have declared "frame" as instance variable
                            System.out.println("Entrou aqui!!!!!!");                                                   
                            application.getjPanel2().removeAll();
                    application.getjPanel2().setLayout(new BorderLayout());
                     InputStream IS = NortheastButton.class.getResourceAsStream("/resources/south/Sacarose.png");
                    Image image = null;
                    try {
                        image = ImageIO.read(IS);
                    } catch (IOException ex) {
                        Logger.getLogger(NorthButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Image scaledImage = image.getScaledInstance(application.getjPanel2().getWidth(), application.getjPanel2().getHeight(), Image.SCALE_SMOOTH);
                    JLabel labelImage = new JLabel(new ImageIcon(scaledImage));
                    
                    application.getjPanel2().add(labelImage);
                    application.getjPanel2().validate();
                    application.getjPanel2().repaint();
                    //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
                    //application.getjPanel2().setLocation(50, 20);
                    application.pack();
                        }
                    
                    });
                    //-------------------------------------- Fim do clique

                    application.getjPanel2().add(labelImage);
                    application.getjPanel2().validate();
                    application.getjPanel2().repaint();
                    //application.getjPanel2().setSize(application.getjPanel2().getPreferredSize());
                    //application.getjPanel2().setLocation(50, 20);
                    application.pack();
                }
            }
            );
        }

        return newButton;
    }

    public void saveNewImage(File selectedFile) {
        //File file = new File("../../resources/northeast/nordeste-branco.jpg");
        //File file = new File("../../resources/northeast/nordeste-branco.jpg");
        String path = "src/resources/northeast/northeast-medicines.jpg";

        try {
            Files.move(selectedFile.toPath(), new File(path).toPath(), REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(NortheastButton.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        selectedFile.renameTo(file);
        try {
            System.out.println("Salvei arquivo em " + selectedFile.getCanonicalPath());
            // PrintWriter writer = new PrintWriter(new File(this.getClass().getResource("/resources/northeast/nordeste-branco.jpg").getPath()));
        } catch (IOException ex) {
            Logger.getLogger(NortheastButton.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public void changeMenu(boolean bool) {
        menuRegionalMedicine = bool;
    }

}

