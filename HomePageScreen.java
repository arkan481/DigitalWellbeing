/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalwellebing;

import Illness.DentalDisorder;
import Illness.GeneralIllness;
import Illness.HeartDisease;
import Illness.IllnessModel;
import Illness.NutritionalDisorder;
import Illness.PhysicalInjury;
import Illness.VisualDisorder;
import Medicine.Benylin;
import Medicine.Betadine;
import Medicine.ChestalHoney;
import Medicine.Insto;
import Medicine.MedicineModel;
import Medicine.MultiVitamin;
import Medicine.Orajel;
import Medicine.Tylenol;
import People.DentalDoctor;
import People.GeneralDoctor;
import People.HDDoctor;
import People.NutritionalDoctor;
import People.Patient;
import People.PeopleModel;
import People.PhysicalDoctor;
import People.VisualDoctor;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.multi.MultiLabelUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arkan481
 */
public class HomePageScreen extends javax.swing.JFrame {

    /**
     * Creates new form HomePageScreen
     */
    
    private String username;
    private List<PeopleModel> people;
    private Patient patient1,patient2,patient3,patient4,patient5,patient6,patient7;
    private Patient user;
    private HDDoctor hDDoctor1,hDDoctor2;
    private DentalDoctor dentalDoctor1;
    private VisualDoctor visualDoctor1;
    private GeneralDoctor generalDoctor1;
    private NutritionalDoctor nutritionalDoctor;
    private PhysicalDoctor physicalDoctor1;
    private MedicineModel orajel,insto,benylin,betadine,chestalHoney,multiVitamin,tylenol;
    private HeartDisease heartDisease;
    private boolean newUser =true;
    private IllnessModel passIllnessModel;
    private int severity,type,duration;
    private List<Patient> patientarr = new ArrayList<>();
    
    
    
    
    public HomePageScreen(Patient patient) {
        initComponents();
        transparentButton();
        this.user = patient;
        this.username = user.getName();
        setSize(981,670);
        setResizable(false);
        labelname.setText("Hello "+this.username);
        labelgreetingconsult.setText("Hello "+this.username+" how do you feel today?");
        switchPanel(panelConsult);
        heartDisease = new HeartDisease();
        populatePatient();
        populatePatientArr();
        populateMedicine();
        populateHDDoctor();
        populateDentalDoctor();
        populateVisualDoctor();
        populateGeneralDoctor();
        populatePhysicalDoctor();
        populateNutritionalDoctor();
      
    }
    
    private void switchPanel(JPanel panel) {
        
        FragLayout.removeAll();
        FragLayout.add(panel);
        FragLayout.repaint();
        FragLayout.revalidate();
    }
    
    private void populatePatientArr() {
        patientarr.add(patient1);
        patientarr.add(patient2);
    }
    
    private void populatePatient() {
        patient1 = new Patient("jl 12.cibinong", 2280,"raka", 'm', 22);
        patient2 = new Patient("jl 13.Depok", 2262, "miko", 'f', 31);
    }
    
    private void populateMedicine() {
        this.betadine = new Betadine(20000, "Betadine", "/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/betadine.png", "physical injury medicine");
        ImageIcon imageIcon1 = new ImageIcon(betadine.getImage());
        imageMed1.setIcon(imageIcon1);
        labelMed1.setText(betadine.getName());
        labelPrice1.setText(String.valueOf(betadine.getPrice()));
        labelDesc1.setText(betadine.getDescription());
        
        btnBuy1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String betadinearr[] ={betadine.getName(),betadine.getDescription(),String.valueOf(betadine.getPrice())};
                addToCart(betadinearr);
                updatePrice(betadine.getPrice());
            }
        });
        
        this.tylenol = new Tylenol(30000, "Tylenol", "/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/tylenol.png", "Headache Reliefer");
        ImageIcon imageIcon2 = new ImageIcon(tylenol.getImage());
        imageMed2.setIcon(imageIcon2);
        labelMed2.setText(tylenol.getName());
        labelPrice2.setText(String.valueOf(tylenol.getPrice()));
        labelDesc2.setText(tylenol.getDescription());
        btnBuy2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data[] ={tylenol.getName(),tylenol.getDescription(),String.valueOf(tylenol.getPrice())};
                addToCart(data);
                updatePrice(tylenol.getPrice());
            }
        });
        
        this.insto = new Insto(10000,"Insto","/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/insto.png","Dry eyes reliefer");
        ImageIcon imageIcon3 = new ImageIcon(insto.getImage());
        imageMed3.setIcon(imageIcon3);
        labelMed3.setText(insto.getName());
        labelPrice3.setText(String.valueOf(insto.getPrice()));
        labelDesc3.setText(insto.getDescription());
        btnBuy3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data[] ={insto.getName(),insto.getDescription(),String.valueOf(insto.getPrice())};
                addToCart(data);
                updatePrice(insto.getPrice());
            }
        });
        
        this.orajel = new Orajel(25000, "orajel","/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/orajel.png" , "Oral Care");
        ImageIcon imageIcon4 = new ImageIcon(orajel.getImage());
        imageMed4.setIcon(imageIcon4);
        labelMed4.setText(orajel.getName());
        labelPrice4.setText(String.valueOf(orajel.getPrice()));
        labelDesc4.setText(orajel.getDescription());
        btnBuy4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data[] ={orajel.getName(),orajel.getDescription(),String.valueOf(orajel.getPrice())};
                addToCart(data);
                updatePrice(orajel.getPrice());
            }
        });
        
        this.benylin = new Benylin(27000,"Benylin","/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/benylin.png", "Flu reliefer");
        ImageIcon imageIcon5 = new ImageIcon(benylin.getImage());
        imageMed5.setIcon(imageIcon5);
        labelMed5.setText(benylin.getName());
        labelPrice5.setText(String.valueOf(benylin.getPrice()));
        labelDesc5.setText(benylin.getDescription());
        btnBuy5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data[] ={benylin.getName(),benylin.getDescription(),String.valueOf(benylin.getPrice())};
                addToCart(data);
                updatePrice(benylin.getPrice());
            }
        });
        
        this.chestalHoney = new ChestalHoney(33000,"Chestal Honey","/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/chestalhoney.png", "Chest Pain Reliefer");
        ImageIcon imageIcon6 = new ImageIcon(chestalHoney.getImage());
        imageMed6.setIcon(imageIcon6);
        labelMed6.setText(chestalHoney.getName());
        labelPrice6.setText(String.valueOf(chestalHoney.getPrice()));
        labelDesc6.setText(chestalHoney.getDescription());
        btnBuy6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data[] ={chestalHoney.getName(),chestalHoney.getDescription(),String.valueOf(chestalHoney.getPrice())};
                addToCart(data);
                updatePrice(chestalHoney.getPrice());
            }
        });
        
        this.multiVitamin = new MultiVitamin(45000,"Multi Vitamin","/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/multiVitamin.png", "Multi vitamin");
        ImageIcon imageIcon7 = new ImageIcon(multiVitamin.getImage());
        imageMed7.setIcon(imageIcon7);
        labelMed7.setText(multiVitamin.getName());
        labelPrice7.setText(String.valueOf(multiVitamin.getPrice()));
        labelDesc7.setText(multiVitamin.getDescription());
        btnBuy7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data[] ={multiVitamin.getName(),multiVitamin.getDescription(),String.valueOf(multiVitamin.getPrice())};
                addToCart(data);
                updatePrice(multiVitamin.getPrice());
            }
        });
    }
    
    private void addToAppointment(String [] data) {
        DefaultTableModel model =(DefaultTableModel) tblAppointment.getModel();
        model.addRow(data);
    }
    
    private void addToCart(String [] data) {
        DefaultTableModel model = (DefaultTableModel) tblCart.getModel();
        model.addRow(data);
    }
    
    private void updatePrice(float price) {
        float temp = Float.valueOf(labeltotalprice.getText());
        temp = temp+price;
        labeltotalprice.setText(String.valueOf(temp));
    }
    
    private void populateHDDoctor() {
        hDDoctor1 =new HDDoctor(patientarr, 5, "DR. Doni", 'm', 28,"/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/doctor1.png");
        labeldoctor1.setText(hDDoctor1.getName());
        ImageIcon imageIcon = new ImageIcon(hDDoctor1.getPhoto());
        imagedoctor1.setIcon(imageIcon);
        queue1.setText(hDDoctor1.getQueue()+" in queue");
        labelspecialist1.setText(hDDoctor1.specialist());
        btnbook1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IllnessModel illType = new HeartDisease();
                List<Patient> temp = hDDoctor1.getPatients();
                temp.add(user);
                hDDoctor1.setPatients(temp);
                queue1.setText(hDDoctor1.getQueue()+" in queue");
                String appointment[] = {hDDoctor1.getName(),hDDoctor1.specialist(),illType.illName(),String.valueOf(hDDoctor1.getQueue())};
                addToAppointment(appointment);
            }
        });
        hDDoctor2 =new HDDoctor(patientarr, 7, "DR. Albert", 'm', 25,"/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/doctor2.png");
        labeldoctor2.setText(hDDoctor2.getName());
        ImageIcon imageIcon2 = new ImageIcon(hDDoctor2.getPhoto());
        imagedoctor2.setIcon(imageIcon2);
        queue2.setText(hDDoctor2.getQueue()+" in queue");
        labelspecialist2.setText(hDDoctor2.specialist());
        btnbook2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IllnessModel illType = new HeartDisease();
                List<Patient> temp = hDDoctor2.getPatients();
                temp.add(user);
                hDDoctor2.setPatients(temp);
                queue2.setText(hDDoctor2.getQueue()+" in queue");
                String appointment[] = {hDDoctor2.getName(),hDDoctor2.specialist(),illType.illName(),String.valueOf(hDDoctor2.getQueue())};
                addToAppointment(appointment);
            }
        });
        
    }
    
    private void populateDentalDoctor() {
        dentalDoctor1 = new DentalDoctor(patientarr, 6, "DR. Irma", 'f', 22, "/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/doctor3.png");
        labeldoctor3.setText(dentalDoctor1.getName());
        ImageIcon imageIcon3 = new ImageIcon(dentalDoctor1.getPhoto());
        imagedoctor3.setIcon(imageIcon3);
        queue3.setText(dentalDoctor1.getQueue()+" in queue");
        labelspecialist3.setText(dentalDoctor1.specialist());
        btnbook3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IllnessModel illType = new DentalDisorder();
                List<Patient> temp = dentalDoctor1.getPatients();
                temp.add(user);
                dentalDoctor1.setPatients(temp);
                queue3.setText(dentalDoctor1.getQueue()+" in queue");
                String appointment[] = {dentalDoctor1.getName(),dentalDoctor1.specialist(),illType.illName(),String.valueOf(dentalDoctor1.getQueue())};
                addToAppointment(appointment);
            }
        });
    }
    private void populateVisualDoctor() {
        visualDoctor1 = new VisualDoctor(patientarr, 3, "DR. Henry", 'm', 33, "/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/doctor4.png");
        labeldoctor4.setText(visualDoctor1.getName());
        ImageIcon imageIcon3 = new ImageIcon(visualDoctor1.getPhoto());
        imagedoctor4.setIcon(imageIcon3);
        queue4.setText(visualDoctor1.getQueue()+" in queue");
        labelspecialist4.setText(visualDoctor1.specialist());
        btnbook4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IllnessModel illType = new VisualDisorder();
                List<Patient> temp = hDDoctor1.getPatients();
                temp.add(user);
                visualDoctor1.setPatients(temp);
                queue4.setText(visualDoctor1.getQueue()+" in queue");
                String appointment[] = {visualDoctor1.getName(),visualDoctor1.specialist(),illType.illName(),String.valueOf(visualDoctor1.getQueue())};
                addToAppointment(appointment);
            }
        });
    }
    
    private void populateGeneralDoctor() {
        generalDoctor1 = new GeneralDoctor(patientarr, 4, "DR.Frusciante", 'm', 31, "/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/doctor5.png");
        labeldoctor5.setText(generalDoctor1.getName());
        ImageIcon imageIcon3 = new ImageIcon(generalDoctor1.getPhoto());
        imagedoctor5.setIcon(imageIcon3);
        queue5.setText(generalDoctor1.getQueue()+" in queue");
        labelspecialist5.setText(generalDoctor1.specialist());
        btnbook5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IllnessModel illType = new GeneralIllness();
                List<Patient> temp = generalDoctor1.getPatients();
                temp.add(user);
                generalDoctor1.setPatients(temp);
                queue5.setText(generalDoctor1.getQueue()+" in queue");
                String appointment[] = {generalDoctor1.getName(),generalDoctor1.specialist(),illType.illName(),String.valueOf(generalDoctor1.getQueue())};
                addToAppointment(appointment);
            }
        });
    }
    
    private void populatePhysicalDoctor() {
        physicalDoctor1 = new PhysicalDoctor(patientarr, 5, "DR. Felder", 'm', 30, "/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/doctor6.png");
        labeldoctor6.setText(physicalDoctor1.getName());
        ImageIcon imageIcon3 = new ImageIcon(physicalDoctor1.getPhoto());
        imagedoctor6.setIcon(imageIcon3);
        queue6.setText(physicalDoctor1.getQueue()+" in queue");
        labelspecialist6.setText(physicalDoctor1.specialist());
        btnbook6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IllnessModel illType = new PhysicalInjury();
                List<Patient> temp = physicalDoctor1.getPatients();
                temp.add(user);
                physicalDoctor1.setPatients(temp);
                queue6.setText(physicalDoctor1.getQueue()+" in queue");
                String appointment[] = {physicalDoctor1.getName(),physicalDoctor1.specialist(),illType.illName(),String.valueOf(physicalDoctor1.getQueue())};
                addToAppointment(appointment);
            }
        });
    }
    
    private void populateNutritionalDoctor() {
        nutritionalDoctor = new NutritionalDoctor(patientarr, 6, "DR. Hudson", 'm', 32, "/Users/arkan481/Documents/CCIT/Project/SM2/1st/Digital Wellbeing/src/ImageSources/doctor7.png");
        labeldoctor7.setText(nutritionalDoctor.getName());
        ImageIcon imageIcon3 = new ImageIcon(nutritionalDoctor.getPhoto());
        imagedoctor7.setIcon(imageIcon3);
        queue7.setText(nutritionalDoctor.getQueue()+" in queue");
        labelspecialist7.setText(nutritionalDoctor.specialist());
        btnbook7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                IllnessModel illType = new NutritionalDisorder();
                List<Patient> temp = nutritionalDoctor.getPatients();
                temp.add(user);
                nutritionalDoctor.setPatients(temp);
                queue7.setText(nutritionalDoctor.getQueue()+" in queue");
                String appointment[] = {nutritionalDoctor.getName(),nutritionalDoctor.specialist(),illType.illName(),String.valueOf(nutritionalDoctor.getQueue())};
                addToAppointment(appointment);
            }
        });
       
    }
    
    private void transparentButton() {
        btnAppointment.setOpaque(true);
        btnAppointment.setBorderPainted(false);
        btnAppointment.setContentAreaFilled(false);
        btnConsult.setOpaque(true);
        btnConsult.setBorderPainted(false);
        btnConsult.setContentAreaFilled(false);
        btnDoctor.setOpaque(true);
        btnDoctor.setBorderPainted(false);
        btnDoctor.setContentAreaFilled(false);
        btnPharmacy.setOpaque(true);
        btnPharmacy.setBorderPainted(false);
        btnPharmacy.setContentAreaFilled(false);
        btnCart.setOpaque(true);
        btnCart.setBorderPainted(false);
        btnCart.setContentAreaFilled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelname = new javax.swing.JLabel();
        btnConsult = new javax.swing.JButton();
        btnDoctor = new javax.swing.JButton();
        btnPharmacy = new javax.swing.JButton();
        btnAppointment = new javax.swing.JButton();
        btnCart = new javax.swing.JButton();
        FragLayout = new javax.swing.JLayeredPane();
        panelCart = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelHD = new javax.swing.JPanel();
        labelSymptom = new javax.swing.JLabel();
        labelDisName = new javax.swing.JLabel();
        fraglayout2 = new javax.swing.JLayeredPane();
        panelsevere = new javax.swing.JPanel();
        labelpromptsevere = new javax.swing.JLabel();
        panelsevere1 = new javax.swing.JPanel();
        labelsevere1 = new javax.swing.JLabel();
        panelsevere2 = new javax.swing.JPanel();
        labelsevere2 = new javax.swing.JLabel();
        panelsevere3 = new javax.swing.JPanel();
        labelsevere3 = new javax.swing.JLabel();
        btnNext2 = new javax.swing.JButton();
        panelSuggestion = new javax.swing.JPanel();
        labelDiseasetype = new javax.swing.JLabel();
        pharmacyImage = new javax.swing.JLabel();
        labelDiseaseSevereness = new javax.swing.JLabel();
        labelDiseaseDuration = new javax.swing.JLabel();
        t4 = new javax.swing.JLabel();
        ImageDoctor = new javax.swing.JLabel();
        LabelDoctor = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panelType = new javax.swing.JPanel();
        labelprompttype = new javax.swing.JLabel();
        paneltype1 = new javax.swing.JPanel();
        labeltype1 = new javax.swing.JLabel();
        paneltype2 = new javax.swing.JPanel();
        labeltype2 = new javax.swing.JLabel();
        paneltype3 = new javax.swing.JPanel();
        labeltype3 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        panelDuration = new javax.swing.JPanel();
        labelpromptduration = new javax.swing.JLabel();
        panelduration1 = new javax.swing.JPanel();
        labelduration1 = new javax.swing.JLabel();
        panelduration2 = new javax.swing.JPanel();
        labelduration2 = new javax.swing.JLabel();
        panelduration3 = new javax.swing.JPanel();
        labelduration3 = new javax.swing.JLabel();
        btnNext1 = new javax.swing.JButton();
        panelAppointment = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        panelDoctor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        imagedoctor1 = new javax.swing.JLabel();
        labeldoctor1 = new javax.swing.JLabel();
        labelspecialist1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnbook1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        queue1 = new javax.swing.JLabel();
        imagedoctor2 = new javax.swing.JLabel();
        labeldoctor2 = new javax.swing.JLabel();
        labelspecialist2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        queue2 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnbook2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        imagedoctor3 = new javax.swing.JLabel();
        labeldoctor3 = new javax.swing.JLabel();
        labelspecialist3 = new javax.swing.JLabel();
        queue4 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnbook3 = new javax.swing.JButton();
        imagedoctor4 = new javax.swing.JLabel();
        labeldoctor4 = new javax.swing.JLabel();
        labelspecialist4 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnbook4 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        imagedoctor5 = new javax.swing.JLabel();
        labeldoctor5 = new javax.swing.JLabel();
        labelspecialist5 = new javax.swing.JLabel();
        btnbook5 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        queue5 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        labeldoctor7 = new javax.swing.JLabel();
        imagedoctor7 = new javax.swing.JLabel();
        labelspecialist7 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        queue7 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        btnbook7 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        imagedoctor6 = new javax.swing.JLabel();
        labeldoctor6 = new javax.swing.JLabel();
        labelspecialist6 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        queue6 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        btnbook6 = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        queue3 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        panelPharmacy = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        imageMed1 = new javax.swing.JLabel();
        labelMed1 = new javax.swing.JLabel();
        labelDesc1 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        labelPrice1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnBuy1 = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        imageMed2 = new javax.swing.JLabel();
        labelMed2 = new javax.swing.JLabel();
        labelDesc2 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        labelPrice2 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnBuy2 = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        imageMed3 = new javax.swing.JLabel();
        labelMed3 = new javax.swing.JLabel();
        labelDesc3 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        labelPrice3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnBuy3 = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        imageMed4 = new javax.swing.JLabel();
        labelMed4 = new javax.swing.JLabel();
        labelDesc4 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        labelPrice4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnBuy4 = new javax.swing.JButton();
        jSeparator22 = new javax.swing.JToolBar.Separator();
        imageMed5 = new javax.swing.JLabel();
        labelMed5 = new javax.swing.JLabel();
        labelDesc5 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JToolBar.Separator();
        labelPrice5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnBuy5 = new javax.swing.JButton();
        jSeparator24 = new javax.swing.JToolBar.Separator();
        imageMed6 = new javax.swing.JLabel();
        labelMed6 = new javax.swing.JLabel();
        labelDesc6 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JToolBar.Separator();
        labelPrice6 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnBuy6 = new javax.swing.JButton();
        jSeparator26 = new javax.swing.JToolBar.Separator();
        imageMed7 = new javax.swing.JLabel();
        labelMed7 = new javax.swing.JLabel();
        labelDesc7 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JToolBar.Separator();
        labelPrice7 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnBuy7 = new javax.swing.JButton();
        jSeparator28 = new javax.swing.JToolBar.Separator();
        panelConsult = new javax.swing.JPanel();
        labelgreetingconsult = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dentalImage = new javax.swing.JLabel();
        ImageVisual = new javax.swing.JLabel();
        imagePhysc = new javax.swing.JLabel();
        imageNutritional = new javax.swing.JLabel();
        ImageChest = new javax.swing.JLabel();
        imageGen = new javax.swing.JLabel();
        panelProfile = new javax.swing.JPanel();
        labelAddress = new javax.swing.JLabel();
        labelPhoneNum = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDisease = new javax.swing.JTable();
        labelUserAge = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelProccess = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        labeltotalprice = new javax.swing.JLabel();
        btnOrderNow = new javax.swing.JButton();
        panel1stProf = new javax.swing.JPanel();
        labelGreetings = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfGetAddress = new javax.swing.JTextField();
        tfGetName = new javax.swing.JTextField();
        tfGetAge = new javax.swing.JTextField();
        tfGetPN = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator31 = new javax.swing.JSeparator();
        jSeparator32 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 651));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        labelname.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labelname.setForeground(new java.awt.Color(255, 255, 255));
        labelname.setText("Hello + name");
        labelname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelnameMouseClicked(evt);
            }
        });

        btnConsult.setBackground(new java.awt.Color(51, 153, 255));
        btnConsult.setForeground(new java.awt.Color(255, 255, 255));
        btnConsult.setText("Consult");
        btnConsult.setBorder(null);
        btnConsult.setOpaque(true);
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });

        btnDoctor.setBackground(new java.awt.Color(51, 153, 255));
        btnDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnDoctor.setText("Doctor");
        btnDoctor.setBorder(null);
        btnDoctor.setOpaque(true);
        btnDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorActionPerformed(evt);
            }
        });

        btnPharmacy.setBackground(new java.awt.Color(51, 153, 255));
        btnPharmacy.setForeground(new java.awt.Color(255, 255, 255));
        btnPharmacy.setText("Pharmacy");
        btnPharmacy.setBorder(null);
        btnPharmacy.setOpaque(true);
        btnPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPharmacyActionPerformed(evt);
            }
        });

        btnAppointment.setBackground(new java.awt.Color(51, 153, 255));
        btnAppointment.setForeground(new java.awt.Color(255, 255, 255));
        btnAppointment.setText("My Appointment");
        btnAppointment.setBorder(null);
        btnAppointment.setOpaque(true);
        btnAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppointmentActionPerformed(evt);
            }
        });

        btnCart.setBackground(new java.awt.Color(51, 153, 255));
        btnCart.setForeground(new java.awt.Color(255, 255, 255));
        btnCart.setText("My Cart");
        btnCart.setBorder(null);
        btnCart.setOpaque(true);
        btnCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnCart, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnConsult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPharmacy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        FragLayout.setBackground(new java.awt.Color(255, 255, 255));
        FragLayout.setMaximumSize(new java.awt.Dimension(800, 600));
        FragLayout.setPreferredSize(new java.awt.Dimension(800, 600));
        FragLayout.setLayout(new java.awt.CardLayout());

        panelCart.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("cart");

        panelHD.setBackground(new java.awt.Color(255, 255, 255));

        labelSymptom.setText("Lorem Ipsum");

        labelDisName.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelDisName.setText("Heart Disorder");

        fraglayout2.setMaximumSize(new java.awt.Dimension(300, 300));
        fraglayout2.setPreferredSize(new java.awt.Dimension(300, 300));
        fraglayout2.setSize(new java.awt.Dimension(300, 300));
        fraglayout2.setLayout(new java.awt.CardLayout());

        panelsevere.setBackground(new java.awt.Color(255, 255, 255));

        labelpromptsevere.setText("Prompt Type");

        panelsevere1.setBackground(new java.awt.Color(255, 255, 255));
        panelsevere1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        panelsevere1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelsevere1MouseClicked(evt);
            }
        });

        labelsevere1.setText("prompt1");

        javax.swing.GroupLayout panelsevere1Layout = new javax.swing.GroupLayout(panelsevere1);
        panelsevere1.setLayout(panelsevere1Layout);
        panelsevere1Layout.setHorizontalGroup(
            panelsevere1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsevere1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelsevere1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelsevere1Layout.setVerticalGroup(
            panelsevere1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsevere1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelsevere1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelsevere2.setBackground(new java.awt.Color(255, 255, 255));
        panelsevere2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        panelsevere2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelsevere2MouseClicked(evt);
            }
        });

        labelsevere2.setText("prompt2");

        javax.swing.GroupLayout panelsevere2Layout = new javax.swing.GroupLayout(panelsevere2);
        panelsevere2.setLayout(panelsevere2Layout);
        panelsevere2Layout.setHorizontalGroup(
            panelsevere2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsevere2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelsevere2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelsevere2Layout.setVerticalGroup(
            panelsevere2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsevere2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelsevere2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelsevere3.setBackground(new java.awt.Color(255, 255, 255));
        panelsevere3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        panelsevere3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelsevere3MouseClicked(evt);
            }
        });

        labelsevere3.setText("prompt3");

        javax.swing.GroupLayout panelsevere3Layout = new javax.swing.GroupLayout(panelsevere3);
        panelsevere3.setLayout(panelsevere3Layout);
        panelsevere3Layout.setHorizontalGroup(
            panelsevere3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsevere3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelsevere3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelsevere3Layout.setVerticalGroup(
            panelsevere3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsevere3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelsevere3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNext2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/next.png"))); // NOI18N
        btnNext2.setBorderPainted(false);
        btnNext2.setOpaque(true);
        btnNext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelsevereLayout = new javax.swing.GroupLayout(panelsevere);
        panelsevere.setLayout(panelsevereLayout);
        panelsevereLayout.setHorizontalGroup(
            panelsevereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsevereLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelsevereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsevereLayout.createSequentialGroup()
                        .addGroup(panelsevereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelsevere1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelpromptsevere, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelsevereLayout.createSequentialGroup()
                        .addGroup(panelsevereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelsevere2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelsevere3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addComponent(btnNext2)
                        .addGap(136, 136, 136))))
        );
        panelsevereLayout.setVerticalGroup(
            panelsevereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsevereLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelpromptsevere, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelsevereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelsevereLayout.createSequentialGroup()
                        .addComponent(panelsevere1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelsevere2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelsevere3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNext2))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        fraglayout2.add(panelsevere, "card3");

        panelSuggestion.setBackground(new java.awt.Color(255, 255, 255));

        labelDiseasetype.setText("t1");

        pharmacyImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/pharmacy.png"))); // NOI18N

        labelDiseaseSevereness.setText("t2");

        labelDiseaseDuration.setText("t3");

        ImageDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor.jpg"))); // NOI18N

        LabelDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDoctor.setText("Book an appointment");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Go to pharmacy");

        javax.swing.GroupLayout panelSuggestionLayout = new javax.swing.GroupLayout(panelSuggestion);
        panelSuggestion.setLayout(panelSuggestionLayout);
        panelSuggestionLayout.setHorizontalGroup(
            panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuggestionLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSuggestionLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(ImageDoctor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(LabelDoctor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSuggestionLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(pharmacyImage)
                        .addGap(61, 61, 61))
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(297, 297, 297))
            .addGroup(panelSuggestionLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelDiseasetype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDiseaseSevereness, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDiseaseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSuggestionLayout.setVerticalGroup(
            panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuggestionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDiseasetype, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDiseaseSevereness, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(labelDiseaseDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ImageDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pharmacyImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSuggestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fraglayout2.add(panelSuggestion, "card5");

        panelType.setBackground(new java.awt.Color(255, 255, 255));

        labelprompttype.setText("Prompt Type");

        paneltype1.setBackground(new java.awt.Color(255, 255, 255));
        paneltype1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        paneltype1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneltype1MouseClicked(evt);
            }
        });

        labeltype1.setText("prompt1");

        javax.swing.GroupLayout paneltype1Layout = new javax.swing.GroupLayout(paneltype1);
        paneltype1.setLayout(paneltype1Layout);
        paneltype1Layout.setHorizontalGroup(
            paneltype1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltype1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltype1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneltype1Layout.setVerticalGroup(
            paneltype1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltype1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltype1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        paneltype2.setBackground(new java.awt.Color(255, 255, 255));
        paneltype2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        paneltype2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneltype2MouseClicked(evt);
            }
        });

        labeltype2.setText("prompt2");

        javax.swing.GroupLayout paneltype2Layout = new javax.swing.GroupLayout(paneltype2);
        paneltype2.setLayout(paneltype2Layout);
        paneltype2Layout.setHorizontalGroup(
            paneltype2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltype2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltype2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneltype2Layout.setVerticalGroup(
            paneltype2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltype2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltype2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        paneltype3.setBackground(new java.awt.Color(255, 255, 255));
        paneltype3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        paneltype3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneltype3MouseClicked(evt);
            }
        });

        labeltype3.setText("prompt3");

        javax.swing.GroupLayout paneltype3Layout = new javax.swing.GroupLayout(paneltype3);
        paneltype3.setLayout(paneltype3Layout);
        paneltype3Layout.setHorizontalGroup(
            paneltype3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltype3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltype3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneltype3Layout.setVerticalGroup(
            paneltype3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltype3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltype3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/next.png"))); // NOI18N
        btnNext.setBorderPainted(false);
        btnNext.setOpaque(true);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTypeLayout = new javax.swing.GroupLayout(panelType);
        panelType.setLayout(panelTypeLayout);
        panelTypeLayout.setHorizontalGroup(
            panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTypeLayout.createSequentialGroup()
                        .addGroup(panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneltype1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelprompttype, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTypeLayout.createSequentialGroup()
                        .addGroup(panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneltype2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paneltype3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(btnNext)
                        .addGap(121, 121, 121))))
        );
        panelTypeLayout.setVerticalGroup(
            panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNext)
                    .addGroup(panelTypeLayout.createSequentialGroup()
                        .addComponent(labelprompttype, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paneltype1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(paneltype2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(paneltype3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        fraglayout2.add(panelType, "card2");

        panelDuration.setBackground(new java.awt.Color(255, 255, 255));

        labelpromptduration.setText("Prompt Type");

        panelduration1.setBackground(new java.awt.Color(255, 255, 255));
        panelduration1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        panelduration1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelduration1MouseClicked(evt);
            }
        });

        labelduration1.setText("prompt1");

        javax.swing.GroupLayout panelduration1Layout = new javax.swing.GroupLayout(panelduration1);
        panelduration1.setLayout(panelduration1Layout);
        panelduration1Layout.setHorizontalGroup(
            panelduration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelduration1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelduration1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelduration1Layout.setVerticalGroup(
            panelduration1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelduration1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelduration1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelduration2.setBackground(new java.awt.Color(255, 255, 255));
        panelduration2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        panelduration2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelduration2MouseClicked(evt);
            }
        });

        labelduration2.setText("prompt2");

        javax.swing.GroupLayout panelduration2Layout = new javax.swing.GroupLayout(panelduration2);
        panelduration2.setLayout(panelduration2Layout);
        panelduration2Layout.setHorizontalGroup(
            panelduration2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelduration2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelduration2, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelduration2Layout.setVerticalGroup(
            panelduration2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelduration2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelduration2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelduration3.setBackground(new java.awt.Color(255, 255, 255));
        panelduration3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        panelduration3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelduration3MouseClicked(evt);
            }
        });

        labelduration3.setText("prompt3");

        javax.swing.GroupLayout panelduration3Layout = new javax.swing.GroupLayout(panelduration3);
        panelduration3.setLayout(panelduration3Layout);
        panelduration3Layout.setHorizontalGroup(
            panelduration3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelduration3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelduration3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelduration3Layout.setVerticalGroup(
            panelduration3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelduration3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelduration3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/next.png"))); // NOI18N
        btnNext1.setBorderPainted(false);
        btnNext1.setOpaque(true);
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDurationLayout = new javax.swing.GroupLayout(panelDuration);
        panelDuration.setLayout(panelDurationLayout);
        panelDurationLayout.setHorizontalGroup(
            panelDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDurationLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDurationLayout.createSequentialGroup()
                        .addComponent(labelpromptduration, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDurationLayout.createSequentialGroup()
                        .addGroup(panelDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelduration3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelduration2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelduration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                        .addComponent(btnNext1)
                        .addGap(135, 135, 135))))
        );
        panelDurationLayout.setVerticalGroup(
            panelDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDurationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDurationLayout.createSequentialGroup()
                        .addComponent(labelpromptduration, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(panelduration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelduration2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelduration3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNext1))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        fraglayout2.add(panelDuration, "card4");

        javax.swing.GroupLayout panelHDLayout = new javax.swing.GroupLayout(panelHD);
        panelHD.setLayout(panelHDLayout);
        panelHDLayout.setHorizontalGroup(
            panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHDLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSymptom, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDisName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelHDLayout.createSequentialGroup()
                .addComponent(fraglayout2, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14104, Short.MAX_VALUE))
        );
        panelHDLayout.setVerticalGroup(
            panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDisName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSymptom, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fraglayout2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(388, 388, 388))
        );

        javax.swing.GroupLayout panelCartLayout = new javax.swing.GroupLayout(panelCart);
        panelCart.setLayout(panelCartLayout);
        panelCartLayout.setHorizontalGroup(
            panelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCartLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(890, 890, 890)
                .addComponent(jLabel5)
                .addGap(15669, 15669, 15669))
        );
        panelCartLayout.setVerticalGroup(
            panelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCartLayout.createSequentialGroup()
                .addGroup(panelCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCartLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel5))
                    .addGroup(panelCartLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelHD, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FragLayout.add(panelCart, "card6");

        panelAppointment.setBackground(new java.awt.Color(255, 255, 255));

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor's Name", "Specialist", "Illness", "Queue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAppointment);
        if (tblAppointment.getColumnModel().getColumnCount() > 0) {
            tblAppointment.getColumnModel().getColumn(0).setResizable(false);
            tblAppointment.getColumnModel().getColumn(1).setResizable(false);
            tblAppointment.getColumnModel().getColumn(2).setResizable(false);
            tblAppointment.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout panelAppointmentLayout = new javax.swing.GroupLayout(panelAppointment);
        panelAppointment.setLayout(panelAppointmentLayout);
        panelAppointmentLayout.setHorizontalGroup(
            panelAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAppointmentLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelAppointmentLayout.setVerticalGroup(
            panelAppointmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAppointmentLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        FragLayout.add(panelAppointment, "card5");

        panelDoctor.setBackground(new java.awt.Color(255, 255, 255));

        imagedoctor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagedoctor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labeldoctor1.setText("jLabel16");

        labelspecialist1.setForeground(new java.awt.Color(102, 102, 102));
        labelspecialist1.setText("jLabel16");

        btnbook1.setBackground(new java.awt.Color(255, 0, 102));
        btnbook1.setText("Book Appointment");
        btnbook1.setFocusable(false);
        btnbook1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbook1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/suitcase.jpg"))); // NOI18N

        queue1.setText("jLabel21");

        imagedoctor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagedoctor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labeldoctor2.setText("jLabel16");

        labelspecialist2.setForeground(new java.awt.Color(102, 102, 102));
        labelspecialist2.setText("jLabel16");

        queue2.setText("jLabel21");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/suitcase.jpg"))); // NOI18N

        btnbook2.setBackground(new java.awt.Color(255, 0, 102));
        btnbook2.setText("Book Appointment");
        btnbook2.setFocusable(false);
        btnbook2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbook2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imagedoctor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagedoctor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labeldoctor3.setText("jLabel16");

        labelspecialist3.setForeground(new java.awt.Color(102, 102, 102));
        labelspecialist3.setText("jLabel16");

        queue4.setText("jLabel21");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/suitcase.jpg"))); // NOI18N

        btnbook3.setBackground(new java.awt.Color(255, 0, 102));
        btnbook3.setText("Book Appointment");
        btnbook3.setFocusable(false);
        btnbook3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbook3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imagedoctor4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagedoctor4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labeldoctor4.setText("jLabel16");

        labelspecialist4.setForeground(new java.awt.Color(102, 102, 102));
        labelspecialist4.setText("jLabel16");

        btnbook4.setBackground(new java.awt.Color(255, 0, 102));
        btnbook4.setText("Book Appointment");
        btnbook4.setFocusable(false);
        btnbook4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbook4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imagedoctor5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagedoctor5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labeldoctor5.setText("jLabel16");

        labelspecialist5.setForeground(new java.awt.Color(102, 102, 102));
        labelspecialist5.setText("jLabel16");

        btnbook5.setBackground(new java.awt.Color(255, 0, 102));
        btnbook5.setText("Book Appointment");
        btnbook5.setFocusable(false);
        btnbook5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbook5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        queue5.setText("jLabel21");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/suitcase.jpg"))); // NOI18N

        labeldoctor7.setText("jLabel16");

        imagedoctor7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagedoctor7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelspecialist7.setForeground(new java.awt.Color(102, 102, 102));
        labelspecialist7.setText("jLabel16");

        queue7.setText("jLabel21");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/suitcase.jpg"))); // NOI18N

        btnbook7.setBackground(new java.awt.Color(255, 0, 102));
        btnbook7.setText("Book Appointment");
        btnbook7.setFocusable(false);
        btnbook7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbook7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imagedoctor6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagedoctor6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labeldoctor6.setText("jLabel16");

        labelspecialist6.setForeground(new java.awt.Color(102, 102, 102));
        labelspecialist6.setText("jLabel16");

        queue6.setText("jLabel21");

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/suitcase.jpg"))); // NOI18N

        btnbook6.setBackground(new java.awt.Color(255, 0, 102));
        btnbook6.setText("Book Appointment");
        btnbook6.setFocusable(false);
        btnbook6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbook6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        queue3.setText("jLabel21");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/suitcase.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(imagedoctor2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(18, 18, 18)
                                        .addComponent(queue2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelspecialist2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labeldoctor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbook2))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(imagedoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelspecialist1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labeldoctor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnbook1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(18, 18, 18)
                                        .addComponent(queue1))))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(queue4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(968, 968, 968)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(imagedoctor3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(18, 18, 18)
                                        .addComponent(queue3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelspecialist3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labeldoctor3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbook3))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(imagedoctor5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addGap(18, 18, 18)
                                        .addComponent(queue5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelspecialist5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labeldoctor5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(imagedoctor4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelspecialist4, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labeldoctor4, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnbook4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(imagedoctor6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel51)
                                        .addGap(18, 18, 18)
                                        .addComponent(queue6))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelspecialist6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labeldoctor6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbook6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(imagedoctor7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel46)
                                        .addGap(18, 18, 18)
                                        .addComponent(queue7))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelspecialist7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labeldoctor7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbook7)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelspecialist1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnbook1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue1)))
                    .addComponent(imagedoctor1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagedoctor2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnbook2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldoctor2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelspecialist2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagedoctor3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnbook3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldoctor3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelspecialist3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue3))))
                .addGap(23, 23, 23)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagedoctor4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnbook4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldoctor4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelspecialist4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldoctor5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelspecialist5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnbook5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue5)))
                    .addComponent(imagedoctor5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldoctor6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelspecialist6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnbook6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue6)))
                    .addComponent(imagedoctor6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labeldoctor7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelspecialist7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnbook7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(queue7)))
                    .addComponent(imagedoctor7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout panelDoctorLayout = new javax.swing.GroupLayout(panelDoctor);
        panelDoctor.setLayout(panelDoctorLayout);
        panelDoctorLayout.setHorizontalGroup(
            panelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 993, Short.MAX_VALUE)
            .addGroup(panelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDoctorLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelDoctorLayout.setVerticalGroup(
            panelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
            .addGroup(panelDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDoctorLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        FragLayout.add(panelDoctor, "card3");

        panelPharmacy.setBackground(new java.awt.Color(255, 255, 255));

        imageMed1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageMed1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelMed1.setText("jLabel16");

        labelDesc1.setForeground(new java.awt.Color(102, 102, 102));
        labelDesc1.setText("jLabel16");

        labelPrice1.setText("jLabel21");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/rp.png"))); // NOI18N

        btnBuy1.setBackground(new java.awt.Color(255, 0, 102));
        btnBuy1.setText("Add to Cart");
        btnBuy1.setFocusable(false);
        btnBuy1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imageMed2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageMed2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelMed2.setText("jLabel16");

        labelDesc2.setForeground(new java.awt.Color(102, 102, 102));
        labelDesc2.setText("jLabel16");

        labelPrice2.setText("jLabel21");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/rp.png"))); // NOI18N

        btnBuy2.setBackground(new java.awt.Color(255, 0, 102));
        btnBuy2.setText("Add to Cart");
        btnBuy2.setFocusable(false);
        btnBuy2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imageMed3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageMed3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelMed3.setText("jLabel16");

        labelDesc3.setForeground(new java.awt.Color(102, 102, 102));
        labelDesc3.setText("jLabel16");

        labelPrice3.setText("jLabel21");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/rp.png"))); // NOI18N

        btnBuy3.setBackground(new java.awt.Color(255, 0, 102));
        btnBuy3.setText("Add to Cart");
        btnBuy3.setFocusable(false);
        btnBuy3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imageMed4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageMed4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelMed4.setText("jLabel16");

        labelDesc4.setForeground(new java.awt.Color(102, 102, 102));
        labelDesc4.setText("jLabel16");

        labelPrice4.setText("jLabel21");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/rp.png"))); // NOI18N

        btnBuy4.setBackground(new java.awt.Color(255, 0, 102));
        btnBuy4.setText("Add to Cart");
        btnBuy4.setFocusable(false);
        btnBuy4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imageMed5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageMed5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelMed5.setText("jLabel16");

        labelDesc5.setForeground(new java.awt.Color(102, 102, 102));
        labelDesc5.setText("jLabel16");

        labelPrice5.setText("jLabel21");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/rp.png"))); // NOI18N

        btnBuy5.setBackground(new java.awt.Color(255, 0, 102));
        btnBuy5.setText("Add to Cart");
        btnBuy5.setFocusable(false);
        btnBuy5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imageMed6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageMed6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelMed6.setText("jLabel16");

        labelDesc6.setForeground(new java.awt.Color(102, 102, 102));
        labelDesc6.setText("jLabel16");

        labelPrice6.setText("jLabel21");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/rp.png"))); // NOI18N

        btnBuy6.setBackground(new java.awt.Color(255, 0, 102));
        btnBuy6.setText("Add to Cart");
        btnBuy6.setFocusable(false);
        btnBuy6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        imageMed7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageMed7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/doctor1.png"))); // NOI18N

        labelMed7.setText("jLabel16");

        labelDesc7.setForeground(new java.awt.Color(102, 102, 102));
        labelDesc7.setText("jLabel16");

        labelPrice7.setText("jLabel21");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/rp.png"))); // NOI18N

        btnBuy7.setBackground(new java.awt.Color(255, 0, 102));
        btnBuy7.setText("Add to Cart");
        btnBuy7.setFocusable(false);
        btnBuy7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuy7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(imageMed2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDesc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMed2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBuy2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelPrice2))))
                                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(imageMed3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDesc3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMed3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBuy3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelPrice3))))
                                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(imageMed4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDesc4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMed4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBuy4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelPrice4))))
                                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(imageMed1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDesc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBuy1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelPrice1))))
                                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(imageMed5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDesc5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMed5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBuy5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel25)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelPrice5))))
                                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(imageMed6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDesc6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMed6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBuy6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelPrice6))))
                                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(imageMed7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(labelDesc7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelMed7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnBuy7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel28)
                                            .addGap(18, 18, 18)
                                            .addComponent(labelPrice7))))
                                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelMed1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(labelPrice1)))
                    .addComponent(imageMed1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelMed2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuy2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(labelPrice2)))
                    .addComponent(imageMed2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelMed3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDesc3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuy3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(labelPrice3)))
                    .addComponent(imageMed3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelMed4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDesc4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuy4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(labelPrice4)))
                    .addComponent(imageMed4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelMed5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDesc5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuy5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(labelPrice5)))
                    .addComponent(imageMed5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelMed6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDesc6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuy6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(labelPrice6)))
                    .addComponent(imageMed6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(labelMed7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDesc7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuy7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(labelPrice7)))
                    .addComponent(imageMed7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout panelPharmacyLayout = new javax.swing.GroupLayout(panelPharmacy);
        panelPharmacy.setLayout(panelPharmacyLayout);
        panelPharmacyLayout.setHorizontalGroup(
            panelPharmacyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPharmacyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPharmacyLayout.setVerticalGroup(
            panelPharmacyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPharmacyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FragLayout.add(panelPharmacy, "card4");

        panelConsult.setBackground(new java.awt.Color(255, 255, 255));

        labelgreetingconsult.setFont(new java.awt.Font("Al Nile", 1, 18)); // NOI18N
        labelgreetingconsult.setText("Hello Admin how do you feel today?");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel7.setText("I have a toothache");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setText("I feel hurt in my chest");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel9.setText("I have a visual disorder");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setText("I just don't feel well");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel11.setText("Dietary Disorder");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel12.setText("I have a physical injury");

        dentalImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/dentist.jpeg"))); // NOI18N
        dentalImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dentalImageMouseClicked(evt);
            }
        });

        ImageVisual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/vision.jpeg"))); // NOI18N
        ImageVisual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageVisualMouseClicked(evt);
            }
        });

        imagePhysc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/physical.jpeg"))); // NOI18N
        imagePhysc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagePhyscMouseClicked(evt);
            }
        });

        imageNutritional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/dietary.jpeg"))); // NOI18N
        imageNutritional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageNutritionalMouseClicked(evt);
            }
        });

        ImageChest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/heart.jpeg"))); // NOI18N
        ImageChest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageChestMouseClicked(evt);
            }
        });

        imageGen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageSources/general.jpeg"))); // NOI18N
        imageGen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageGenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelConsultLayout = new javax.swing.GroupLayout(panelConsult);
        panelConsult.setLayout(panelConsultLayout);
        panelConsultLayout.setHorizontalGroup(
            panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultLayout.createSequentialGroup()
                .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)))
                    .addGroup(panelConsultLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(imageGen, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelConsultLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel9))
                    .addGroup(panelConsultLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageNutritional, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultLayout.createSequentialGroup()
                                .addComponent(imagePhysc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))))
                .addGap(22, 22, 22))
            .addGroup(panelConsultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelgreetingconsult, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelConsultLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(dentalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237)
                .addComponent(ImageChest, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ImageVisual, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        panelConsultLayout.setVerticalGroup(
            panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelgreetingconsult, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dentalImage, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ImageVisual, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelConsultLayout.createSequentialGroup()
                        .addComponent(ImageChest, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePhysc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageGen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageNutritional, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelConsultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        FragLayout.add(panelConsult, "card2");

        panelProfile.setBackground(new java.awt.Color(255, 255, 255));

        labelAddress.setText("Address");

        labelPhoneNum.setText("phoneNumber");

        labelUserName.setText("name");

        tblDisease.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Disease", "Type", "Severeness", "Time of pain ocurring"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblDisease);
        if (tblDisease.getColumnModel().getColumnCount() > 0) {
            tblDisease.getColumnModel().getColumn(0).setResizable(false);
            tblDisease.getColumnModel().getColumn(1).setResizable(false);
            tblDisease.getColumnModel().getColumn(2).setResizable(false);
            tblDisease.getColumnModel().getColumn(3).setResizable(false);
        }

        labelUserAge.setText("age");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("History Of Disease");

        javax.swing.GroupLayout panelProfileLayout = new javax.swing.GroupLayout(panelProfile);
        panelProfile.setLayout(panelProfileLayout);
        panelProfileLayout.setHorizontalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfileLayout.createSequentialGroup()
                .addGroup(panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProfileLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelProfileLayout.createSequentialGroup()
                                .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelProfileLayout.createSequentialGroup()
                                    .addComponent(labelUserAge, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(460, 460, 460)
                                    .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelProfileLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelProfileLayout.setVerticalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProfileLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUserAge, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        FragLayout.add(panelProfile, "card8");

        panelProccess.setBackground(new java.awt.Color(255, 255, 255));

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine's Name", "Description", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setResizable(false);
            tblCart.getColumnModel().getColumn(1).setResizable(false);
            tblCart.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL");

        labeltotalprice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltotalprice.setText("0");

        btnOrderNow.setBackground(new java.awt.Color(51, 204, 0));
        btnOrderNow.setForeground(new java.awt.Color(255, 255, 255));
        btnOrderNow.setText("Order");
        btnOrderNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProccessLayout = new javax.swing.GroupLayout(panelProccess);
        panelProccess.setLayout(panelProccessLayout);
        panelProccessLayout.setHorizontalGroup(
            panelProccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProccessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProccessLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(panelProccessLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labeltotalprice, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                        .addComponent(btnOrderNow, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        panelProccessLayout.setVerticalGroup(
            panelProccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProccessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelProccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeltotalprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrderNow, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addContainerGap())
        );

        FragLayout.add(panelProccess, "card7");

        panel1stProf.setBackground(new java.awt.Color(255, 255, 255));

        labelGreetings.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        labelGreetings.setText("greetings");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Address");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PhoneNumber");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Name");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Age");

        tfGetAddress.setBorder(null);

        tfGetName.setBorder(null);

        tfGetAge.setBorder(null);

        tfGetPN.setBorder(null);

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit My Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator29.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator30.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator31.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator32.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panel1stProfLayout = new javax.swing.GroupLayout(panel1stProf);
        panel1stProf.setLayout(panel1stProfLayout);
        panel1stProfLayout.setHorizontalGroup(
            panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1stProfLayout.createSequentialGroup()
                .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1stProfLayout.createSequentialGroup()
                        .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1stProfLayout.createSequentialGroup()
                                .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                .addGap(44, 44, 44)
                                .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator29, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfGetAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                        .addComponent(jSeparator30, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(tfGetName, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74)
                                .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                            .addGroup(panel1stProfLayout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfGetAge, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(tfGetPN, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(jSeparator32)
                            .addComponent(jSeparator31)))
                    .addGroup(panel1stProfLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        panel1stProfLayout.setVerticalGroup(
            panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1stProfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1stProfLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfGetName, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1stProfLayout.createSequentialGroup()
                                .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1stProfLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1stProfLayout.createSequentialGroup()
                                        .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfGetAge, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)))
                                .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1stProfLayout.createSequentialGroup()
                                        .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tfGetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfGetPN, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1stProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(panel1stProfLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        FragLayout.add(panel1stProf, "card9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FragLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FragLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1149, 1149, 1149))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorActionPerformed
        // TODO add your handling code here:
        switchPanel(panelDoctor);
    }//GEN-LAST:event_btnDoctorActionPerformed

    private void btnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultActionPerformed
        // TODO add your handling code here:
        switchPanel(panelConsult);
    }//GEN-LAST:event_btnConsultActionPerformed

    private void btnPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPharmacyActionPerformed
        // TODO add your handling code here:
        switchPanel(panelPharmacy);
    }//GEN-LAST:event_btnPharmacyActionPerformed

    private void btnAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppointmentActionPerformed
        // TODO add your handling code here:
        switchPanel(panelAppointment);
    }//GEN-LAST:event_btnAppointmentActionPerformed

    private void btnCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartActionPerformed
        // TODO add your handling code here:
        switchPanel(panelProccess);
    }//GEN-LAST:event_btnCartActionPerformed

    private void ImageChestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageChestMouseClicked
        // TODO add your handling code here:
        reset();
        this.passIllnessModel = new HeartDisease();
        evokePanelType(this.passIllnessModel);
        blueLine(4);
        blueLine2(4);
        blueLine3(4);
    }//GEN-LAST:event_ImageChestMouseClicked

    private void reset() {
        this.severity=0;
        this.duration=0;
        this.type=0;
    }
    
    private void evokePanelSevere(IllnessModel illnessModel) {
        System.out.println("severe evoked");
        switchDialogPanel(panelsevere);
        labelpromptsevere.setText(illnessModel.sevPrompt());
        labelsevere1.setText(illnessModel.severity(0));
        labelsevere2.setText(illnessModel.severity(1));
        labelsevere3.setText(illnessModel.severity(2));
    }
    
    private void addToDiseaseTbl(String data[]) {
        DefaultTableModel model = (DefaultTableModel) tblDisease.getModel();
        model.addRow(data);
    }
    
    private void updateIllnes(IllnessModel illnessModel) {
        List<IllnessModel> temp = user.getIllness();
      
        illnessModel.setSeverity(severity);
        illnessModel.setDuration(duration);
        illnessModel.setType(type);
        temp.add(illnessModel);
        user.setIllness(temp);
        String disease[] ={illnessModel.illName(),illnessModel.getType(),illnessModel.getSeverity(),illnessModel.getDuration()};
        addToDiseaseTbl(disease);
      
        
    }
    
    private void evokePanelSuggestion(IllnessModel illnessModel) {
        switchPanel(panelSuggestion);
          labelDiseasetype.setText("Your are prescribed with: "+illnessModel.getType());
          labelDiseaseSevereness.setText("Severity: "+illnessModel.getSeverity());
          labelDiseaseDuration.setText("pain occuring: "+illnessModel.getDuration());
        if (severity==3||duration==3) {
            // evoke doctor suggestion
            t4.setText("It looks like your "+illnessModel.illName()+ " might get worse we suggest you to book an appointment "
                    + "with our doctor");
            ImageDoctor.setVisible(true);
            LabelDoctor.setVisible(true);
        }else {
            // evoke pharmacy suggestion
            ImageDoctor.setVisible(false);
            LabelDoctor.setVisible(false);
            t4.setText("<html><p align =justify style=\"width:500px\">"+"based on your submission we found that it's not necessary to book an appointment"
                    + " for a doctor but you might take a look at the pharmacy section for your medicine"+"</p></html>");
        }
        ImageDoctor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                switchPanel(panelDoctor);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                return;
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                return;
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                return;
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                return;
            }
        });
        pharmacyImage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                switchPanel(panelPharmacy);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
               return;
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                return;
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                return;
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                return;
            }
        });
    };
    
    
    private void evokePanelDuration(IllnessModel illnessModel) {
        final IllnessModel tempIllnessModel = illnessModel;
        switchDialogPanel(panelDuration);
        labelpromptduration.setText(illnessModel.durationPrompt());
        labelduration1.setText(illnessModel.illDuration(0));
        labelduration2.setText(illnessModel.illDuration(1));
        labelduration3.setText(illnessModel.illDuration(2)); 
        
    }
    
    private void switchDialogPanel(JPanel panel) {
        fraglayout2.removeAll();
        fraglayout2.add(panel);
        fraglayout2.repaint();
        fraglayout2.revalidate();
    }
    
    private void evokePanelType(IllnessModel illnessModel) {
        
        switchPanel(panelHD);
        switchDialogPanel(panelType);
        labelDisName.setText(illnessModel.illName());
        labelSymptom.setText("<html><p align =justify style=\"width:500px\">"+illnessModel.symptops()+"</p></html>");
        labelprompttype.setText(illnessModel.typePrompt());
        labeltype1.setText(illnessModel.types(0));
        labeltype2.setText(illnessModel.types(1));
        labeltype3.setText(illnessModel.types(2));
       
    }
    
    private void paneltype1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltype1MouseClicked
        // TODO add your handling code here:
        blueLine(1);
    }//GEN-LAST:event_paneltype1MouseClicked

    private void paneltype2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltype2MouseClicked
        // TODO add your handling code here:
        blueLine(2);
    }//GEN-LAST:event_paneltype2MouseClicked

    private void paneltype3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paneltype3MouseClicked
        // TODO add your handling code here:
        blueLine(3);
    }//GEN-LAST:event_paneltype3MouseClicked

    private void panelsevere1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsevere1MouseClicked
        // TODO add your handling code here:
        blueLine2(1);
    }//GEN-LAST:event_panelsevere1MouseClicked

    private void panelsevere2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsevere2MouseClicked
        // TODO add your handling code here:
        blueLine2(2);
    }//GEN-LAST:event_panelsevere2MouseClicked

    private void panelsevere3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelsevere3MouseClicked
        // TODO add your handling code here:
        blueLine2(3);
    }//GEN-LAST:event_panelsevere3MouseClicked

    private void panelduration1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelduration1MouseClicked
        // TODO add your handling code here:
        blueLine3(1);
    }//GEN-LAST:event_panelduration1MouseClicked

    private void panelduration2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelduration2MouseClicked
        // TODO add your handling code here:
        blueLine3(2);
    }//GEN-LAST:event_panelduration2MouseClicked

    private void panelduration3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelduration3MouseClicked
        // TODO add your handling code here:
        blueLine3(3);
    }//GEN-LAST:event_panelduration3MouseClicked

    private void dentalImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dentalImageMouseClicked
        // TODO add your handling code here:
        reset();
        this.passIllnessModel = null;
        this.passIllnessModel = new DentalDisorder();
        evokePanelType(this.passIllnessModel);
        blueLine(4);
        blueLine2(4);
        blueLine3(4);
    }//GEN-LAST:event_dentalImageMouseClicked

    private void ImageVisualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageVisualMouseClicked
        // TODO add your handling code here:
        reset();
        this.passIllnessModel = null;
        this.passIllnessModel = new VisualDisorder();
        evokePanelType(this.passIllnessModel);
        blueLine(4);
        blueLine2(4);
        blueLine3(4);
    }//GEN-LAST:event_ImageVisualMouseClicked

    private void labelnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelnameMouseClicked
        // TODO add your handling code here:
        if (this.newUser==true) {
            System.out.println("called");
            switchPanel(panel1stProf);
            
            labelGreetings.setText("<html><p align =justify style=\"width:450px\">"+"Hello it looks like it's your first time using digital wellbeing please fill "
                    + "these data so we can get to know each other better."+"</p></html>");
          
        }else {
        labelUserName.setText("Patient Name: "+user.getName());
        labelUserAge.setText(String.valueOf("Patient Age: "+user.getAge()));
        labelAddress.setText("Patient Address: "+user.getAddress());
        labelPhoneNum.setText("Patient Phone Number: "+String.valueOf(user.getPhoneNumber()));
        switchPanel(panelProfile);
        }
        
    }//GEN-LAST:event_labelnameMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        evokePanelSevere(this.passIllnessModel);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        // TODO add your handling code here:
         updateIllnes(this.passIllnessModel);
         evokePanelSuggestion(this.passIllnessModel);
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnNext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext2ActionPerformed
        // TODO add your handling code here:
        evokePanelDuration(this.passIllnessModel);
    }//GEN-LAST:event_btnNext2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (tfGetName.getText().equals("")||tfGetAddress.getText().equals("")||tfGetAge.getText().equals("")||tfGetPN.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill out all available fields");
        }else {
        user.setName(tfGetName.getText());
        user.setAddress(tfGetAddress.getText());
        user.setAge(Integer.valueOf(tfGetAge.getText()));
        user.setPhoneNumber(Integer.valueOf(tfGetPN.getText()));
        newUser = false;
        labelUserName.setText("Patient Name: "+user.getName());
        labelUserAge.setText(String.valueOf("Patient Age: "+user.getAge()));
        labelAddress.setText("Patient Address: "+user.getAddress());
        labelPhoneNum.setText("Patient Phone Number: "+String.valueOf(user.getPhoneNumber()));
        switchPanel(panelProfile);
        }
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void imageGenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageGenMouseClicked
        // TODO add your handling code here:
        reset();
        this.passIllnessModel = null;
        this.passIllnessModel = new GeneralIllness();
        evokePanelType(this.passIllnessModel);
        blueLine(4);
        blueLine2(4);
        blueLine3(4);
    }//GEN-LAST:event_imageGenMouseClicked

    private void imageNutritionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageNutritionalMouseClicked
        // TODO add your handling code here:
        reset();
        this.passIllnessModel = null;
        this.passIllnessModel = new NutritionalDisorder();
        evokePanelType(this.passIllnessModel);
        blueLine(4);
        blueLine2(4);
        blueLine3(4);
    }//GEN-LAST:event_imageNutritionalMouseClicked

    private void imagePhyscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagePhyscMouseClicked
        // TODO add your handling code here:
        reset();
        this.passIllnessModel = null;
        this.passIllnessModel = new PhysicalInjury();
        evokePanelType(this.passIllnessModel);
        blueLine(4);
        blueLine2(4);
        blueLine3(4);
    }//GEN-LAST:event_imagePhyscMouseClicked

    private void btnOrderNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderNowActionPerformed
        // TODO add your handling code here:
        if (this.newUser==true) {
            JOptionPane.showMessageDialog(this, "it looks like you haven't setup your address please setup your address before continuing");
           labelGreetings.setText("<html><p align =justify style=\"width:450px\">"+"Hello it looks like it's your first time using digital wellbeing please fill "
                    + "these data so we can get to know each other better."+"</p></html>");
            switchPanel(panel1stProf);
        }else if (labeltotalprice.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "You haven't added any single item");
        }else {
            int option = JOptionPane.showConfirmDialog(this,"Confirm your Order with the total of "+labeltotalprice.getText() ,"Confirm" , JOptionPane.YES_NO_OPTION);
            if (option==0) {
                JOptionPane.showMessageDialog(this, "Thank You Your Order Will Be Delievered at "+user.getAddress());
            }else {
                
            }
        }
    }//GEN-LAST:event_btnOrderNowActionPerformed

    
    
    
    private void blueLine2(int i) {
        Border blueBorder = new LineBorder(Color.BLUE, 3, true);
        Border grayBorder = new LineBorder(Color.gray, 3, true);
        switch (i) {
            case 1 :
                this.severity=1;
                panelsevere1.setBorder(blueBorder);
                panelsevere2.setBorder(grayBorder);
                panelsevere3.setBorder(grayBorder);
                break;
            case 2:
                this.severity=2;
                panelsevere1.setBorder(grayBorder);
                panelsevere2.setBorder(blueBorder);
                panelsevere3.setBorder(grayBorder);
                break;
            case 3:
                this.severity=3;
                panelsevere1.setBorder(grayBorder);
                panelsevere2.setBorder(grayBorder);
                panelsevere3.setBorder(blueBorder);
                break;
            case 4:
                panelsevere1.setBorder(grayBorder);
                panelsevere2.setBorder(grayBorder);
                panelsevere3.setBorder(grayBorder);
                break;
                    
        }
    }
    
    private void blueLine3(int i) {
        Border blueBorder = new LineBorder(Color.BLUE, 3, true);
        Border grayBorder = new LineBorder(Color.gray, 3, true);

        switch (i) {
            case 1 :
                this.duration=1;
                panelduration1.setBorder(blueBorder);
                panelduration2.setBorder(grayBorder);
                panelduration3.setBorder(grayBorder);
                break;
            case 2:
                this.duration=2;
                panelduration1.setBorder(grayBorder);
                panelduration2.setBorder(blueBorder);
                panelduration3.setBorder(grayBorder);
                break;
            case 3:
                this.duration=3;
                panelduration1.setBorder(grayBorder);
                panelduration2.setBorder(grayBorder);
                panelduration3.setBorder(blueBorder);
                break;
            case 4:
                panelduration1.setBorder(grayBorder);
                panelduration2.setBorder(grayBorder);
                panelduration3.setBorder(grayBorder);
                break;
                    
        }
    }
    
    
    private void blueLine(int i) {
        Border blueBorder = new LineBorder(Color.BLUE, 3, true);
        Border grayBorder = new LineBorder(Color.gray, 3, true);

        switch (i) {
            case 1 :
                this.type=1;
                paneltype1.setBorder(blueBorder);
                paneltype2.setBorder(grayBorder);
                paneltype3.setBorder(grayBorder);
                break;
            case 2:
                this.type=2;
                paneltype1.setBorder(grayBorder);
                paneltype2.setBorder(blueBorder);
                paneltype3.setBorder(grayBorder);
                break;
            case 3:
                this.type=3;
                paneltype1.setBorder(grayBorder);
                paneltype2.setBorder(grayBorder);
                paneltype3.setBorder(blueBorder);
                break;
            case 4:
                paneltype1.setBorder(grayBorder);
                paneltype2.setBorder(grayBorder);
                paneltype3.setBorder(grayBorder);
                break;
                    
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane FragLayout;
    private javax.swing.JLabel ImageChest;
    private javax.swing.JLabel ImageDoctor;
    private javax.swing.JLabel ImageVisual;
    private javax.swing.JLabel LabelDoctor;
    private javax.swing.JButton btnAppointment;
    private javax.swing.JButton btnBuy1;
    private javax.swing.JButton btnBuy2;
    private javax.swing.JButton btnBuy3;
    private javax.swing.JButton btnBuy4;
    private javax.swing.JButton btnBuy5;
    private javax.swing.JButton btnBuy6;
    private javax.swing.JButton btnBuy7;
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnDoctor;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnOrderNow;
    private javax.swing.JButton btnPharmacy;
    private javax.swing.JButton btnbook1;
    private javax.swing.JButton btnbook2;
    private javax.swing.JButton btnbook3;
    private javax.swing.JButton btnbook4;
    private javax.swing.JButton btnbook5;
    private javax.swing.JButton btnbook6;
    private javax.swing.JButton btnbook7;
    private javax.swing.JLabel dentalImage;
    private javax.swing.JLayeredPane fraglayout2;
    private javax.swing.JLabel imageGen;
    private javax.swing.JLabel imageMed1;
    private javax.swing.JLabel imageMed2;
    private javax.swing.JLabel imageMed3;
    private javax.swing.JLabel imageMed4;
    private javax.swing.JLabel imageMed5;
    private javax.swing.JLabel imageMed6;
    private javax.swing.JLabel imageMed7;
    private javax.swing.JLabel imageNutritional;
    private javax.swing.JLabel imagePhysc;
    private javax.swing.JLabel imagedoctor1;
    private javax.swing.JLabel imagedoctor2;
    private javax.swing.JLabel imagedoctor3;
    private javax.swing.JLabel imagedoctor4;
    private javax.swing.JLabel imagedoctor5;
    private javax.swing.JLabel imagedoctor6;
    private javax.swing.JLabel imagedoctor7;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator21;
    private javax.swing.JToolBar.Separator jSeparator22;
    private javax.swing.JToolBar.Separator jSeparator23;
    private javax.swing.JToolBar.Separator jSeparator24;
    private javax.swing.JToolBar.Separator jSeparator25;
    private javax.swing.JToolBar.Separator jSeparator26;
    private javax.swing.JToolBar.Separator jSeparator27;
    private javax.swing.JToolBar.Separator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JLabel labelAddress;
    private javax.swing.JLabel labelDesc1;
    private javax.swing.JLabel labelDesc2;
    private javax.swing.JLabel labelDesc3;
    private javax.swing.JLabel labelDesc4;
    private javax.swing.JLabel labelDesc5;
    private javax.swing.JLabel labelDesc6;
    private javax.swing.JLabel labelDesc7;
    private javax.swing.JLabel labelDisName;
    private javax.swing.JLabel labelDiseaseDuration;
    private javax.swing.JLabel labelDiseaseSevereness;
    private javax.swing.JLabel labelDiseasetype;
    private javax.swing.JLabel labelGreetings;
    private javax.swing.JLabel labelMed1;
    private javax.swing.JLabel labelMed2;
    private javax.swing.JLabel labelMed3;
    private javax.swing.JLabel labelMed4;
    private javax.swing.JLabel labelMed5;
    private javax.swing.JLabel labelMed6;
    private javax.swing.JLabel labelMed7;
    private javax.swing.JLabel labelPhoneNum;
    private javax.swing.JLabel labelPrice1;
    private javax.swing.JLabel labelPrice2;
    private javax.swing.JLabel labelPrice3;
    private javax.swing.JLabel labelPrice4;
    private javax.swing.JLabel labelPrice5;
    private javax.swing.JLabel labelPrice6;
    private javax.swing.JLabel labelPrice7;
    private javax.swing.JLabel labelSymptom;
    private javax.swing.JLabel labelUserAge;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel labeldoctor1;
    private javax.swing.JLabel labeldoctor2;
    private javax.swing.JLabel labeldoctor3;
    private javax.swing.JLabel labeldoctor4;
    private javax.swing.JLabel labeldoctor5;
    private javax.swing.JLabel labeldoctor6;
    private javax.swing.JLabel labeldoctor7;
    private javax.swing.JLabel labelduration1;
    private javax.swing.JLabel labelduration2;
    private javax.swing.JLabel labelduration3;
    private javax.swing.JLabel labelgreetingconsult;
    private javax.swing.JLabel labelname;
    private javax.swing.JLabel labelpromptduration;
    private javax.swing.JLabel labelpromptsevere;
    private javax.swing.JLabel labelprompttype;
    private javax.swing.JLabel labelsevere1;
    private javax.swing.JLabel labelsevere2;
    private javax.swing.JLabel labelsevere3;
    private javax.swing.JLabel labelspecialist1;
    private javax.swing.JLabel labelspecialist2;
    private javax.swing.JLabel labelspecialist3;
    private javax.swing.JLabel labelspecialist4;
    private javax.swing.JLabel labelspecialist5;
    private javax.swing.JLabel labelspecialist6;
    private javax.swing.JLabel labelspecialist7;
    private javax.swing.JLabel labeltotalprice;
    private javax.swing.JLabel labeltype1;
    private javax.swing.JLabel labeltype2;
    private javax.swing.JLabel labeltype3;
    private javax.swing.JPanel panel1stProf;
    private javax.swing.JPanel panelAppointment;
    private javax.swing.JPanel panelCart;
    private javax.swing.JPanel panelConsult;
    private javax.swing.JPanel panelDoctor;
    private javax.swing.JPanel panelDuration;
    private javax.swing.JPanel panelHD;
    private javax.swing.JPanel panelPharmacy;
    private javax.swing.JPanel panelProccess;
    private javax.swing.JPanel panelProfile;
    private javax.swing.JPanel panelSuggestion;
    private javax.swing.JPanel panelType;
    private javax.swing.JPanel panelduration1;
    private javax.swing.JPanel panelduration2;
    private javax.swing.JPanel panelduration3;
    private javax.swing.JPanel panelsevere;
    private javax.swing.JPanel panelsevere1;
    private javax.swing.JPanel panelsevere2;
    private javax.swing.JPanel panelsevere3;
    private javax.swing.JPanel paneltype1;
    private javax.swing.JPanel paneltype2;
    private javax.swing.JPanel paneltype3;
    private javax.swing.JLabel pharmacyImage;
    private javax.swing.JLabel queue1;
    private javax.swing.JLabel queue2;
    private javax.swing.JLabel queue3;
    private javax.swing.JLabel queue4;
    private javax.swing.JLabel queue5;
    private javax.swing.JLabel queue6;
    private javax.swing.JLabel queue7;
    private javax.swing.JLabel t4;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblDisease;
    private javax.swing.JTextField tfGetAddress;
    private javax.swing.JTextField tfGetAge;
    private javax.swing.JTextField tfGetName;
    private javax.swing.JTextField tfGetPN;
    // End of variables declaration//GEN-END:variables
}
