package org.example.view.login_register.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.Animator;
import com.formdev.flatlaf.util.CubicBezierEasing;
import jakarta.persistence.EntityManager;
import net.miginfocom.swing.MigLayout;
import org.example.controller.RegisterController;

import org.example.view.login_register.components.EventHomeOverlay;
import org.example.view.login_register.components.HeaderButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class HomeOverlay extends JWindow {

    private final EntityManager em;

    private PanelOverlay overlay;

    public PanelOverlay getOverlay() {
        return overlay;
    }

    private List<ModelLocation> locations;


    public HomeOverlay(JFrame frame, List<ModelLocation> locations , EntityManager emP) {
        super(frame);
        this.em = emP;
        this.locations = locations;
        init();
    }

    private void init() {
        setBackground(new Color(0,0,0,0) );
        setLayout(new BorderLayout());
        overlay = new PanelOverlay();
        add(overlay);


    }

    public class PanelOverlay extends JPanel {

        // event change video
        private EventHomeOverlay eventHomeOverlay;

        public void setEventHomeOverlay(EventHomeOverlay eventHomeOverlay) {
            this.eventHomeOverlay = eventHomeOverlay;
        }

        private MigLayout migLayout;

        // props for animation button chuyen canh
        private AnimationType animationType = AnimationType.NONE;
        private Animator animator;
        // animation cho form login
        private Animator loginAnimator;
        private Animator registerAnimator;
        private float animate;
        private boolean showLogin ;
        private boolean showRegister ;
        // description in login
        private JPanel header;
        private JTextPane textTitle;
        private JTextPane textDescription;
        private JButton cmdReadMore;


        private int index;

        public void setIndex(int index) {
            this.index = index;
            ModelLocation location = locations.get(index);
            textTitle.setText(location.getTitle());
            textDescription.setText(location.getDescription());
        }

        public PanelOverlay() {

            init();

        }

        private void init() {
            // khoi tao cho register
            registerController = new RegisterController(em);
            //
            setOpaque(false);
            migLayout = new MigLayout("fill,insets 10 180 10 180",
                    "fill",
                    "[grow 0][]"
            );

            setLayout(migLayout);

            // create header
            createHeader();
            // create button controll page
            createPageButton();
            // form login
            createLogin();
            createRegister();
            // phan read more //
            JPanel panel = new JPanel(new MigLayout("wrap","","[]30[]"));
            panel.setOpaque(false);
            textTitle = new JTextPane();
            textDescription = new JTextPane();
            cmdReadMore = new JButton("Read More");

            textTitle.setOpaque(false);
            textTitle.setEditable(false);
            textTitle.putClientProperty(FlatClientProperties.STYLE,"" +
                        "font:bold +40;" +
                        "border:0,0,0,0"
                    );

            textDescription.setOpaque(false);
            textDescription.setEditable(false);
            textDescription.putClientProperty(FlatClientProperties.STYLE,"" +
                    "font:bold +2;" +
                    "border:0,0,0,0"
            );

            cmdReadMore.putClientProperty(FlatClientProperties.STYLE, "" +
                        "background:$Component.accentColor;" +
                        "borderWidth:0;" +
                        "margin:5,15,5,15;" +
                        "focusWidth:0;" +
                        "innerFocusWidth:0;" +
                        "arc:999;"
                    );
            panel.add(textTitle);
            panel.add(textDescription);
            panel.add(cmdReadMore);
            add(panel, "width 50%!");

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    runLoginAnimation(false);
                }
            });

            //button change video
            animator = new Animator(500, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    animate = v;
                    repaint();
                }

                @Override
                public void end() {
                    if(animationType == AnimationType.CLOSE_VIDEO) {
                        eventHomeOverlay.oChanged(index);
                        SwingUtilities.invokeLater(() -> {
                            sleep(500);
                            runAnimation(index, AnimationType.SHOW_VIDEO);
                        });

                    } else {
                        animationType = AnimationType.NONE;
                    }
                }
            });

            loginAnimator = new Animator(500, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    float f = showLogin ? v : 1f - v;
                    int x = (int) ((350 + 180) * f);
                    migLayout.setComponentConstraints(panelLogin, "pos 100%-" + x + " 0.5al, w 350");
                    revalidate();
                }
            });

            registerAnimator = new Animator(500 , new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    float f = showRegister ? v : 1f - v;
                    int x = (int) ((350 + 180) * f);
                    migLayout.setComponentConstraints(panelRegister, "pos 100%-" + x + " 0.5al, w 350");
                    revalidate();
                }
            });

            // hoatj anh cua login// register
            animator.setInterpolator(CubicBezierEasing.EASE_IN);
            loginAnimator.setInterpolator(CubicBezierEasing.EASE);
            registerAnimator.setInterpolator(CubicBezierEasing.EASE);
        }

        // user làm trễ hoạt anh
        private void sleep(long l) {
            try {
                Thread.sleep(l);
            } catch(Exception e) {
                System.err.print(e);
            }
        }

// set header
        private void createHeader() {
            header = new JPanel(new MigLayout("fill","[]push[][]"));
            header.setOpaque(false);
            JLabel title = new JLabel("GROUP12");
            title.putClientProperty(
                    FlatClientProperties.STYLE,
                    "" + "font:bold +10");
            HeaderButton home = new HeaderButton("Home");
            HeaderButton about = new HeaderButton("Team");
            HeaderButton explore = new HeaderButton("bonus");
            HeaderButton login = new HeaderButton("Login");
            //HeaderButton register = new HeaderButton("Register");
            //register.setForeground(new Color(115, 229, 241));
            JButton register = new JButton("Register");
            register.putClientProperty(FlatClientProperties.STYLE, "" +
                    "background:$Component.accentColor;" +
                    "borderWidth:0;" +
                    "margin:5,15,5,15;" +
                    "focusWidth:0;" +
                    "innerFocusWidth:0;" +
                    "arc:999;"
            );

            // create event button login
            login.addActionListener(e-> {
                runLoginAnimation(true);
            });

            // create even register
            register.addActionListener(e->{
                runRegisterAnimation(true);
            });

            header.add(title);
            header.add(home);
            header.add(about);
            header.add(explore);
            header.add(login);
            header.add(register);

            add(header, "wrap");
        }

        private void createLogin() {
            panelLogin = new LoginForm(em);
            JButton cmdExit = new JButton("Exit");

            cmdExit.putClientProperty(FlatClientProperties.STYLE, "" +
                    "margin:5,10,5,10;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;"
            );

            cmdExit.addActionListener(e->{
                runLoginAnimation(false);
            });

            panelLogin.add(cmdExit);
            add(panelLogin, "pos 100% 0.5al,w 350");
        }

        private void createRegister() {
            panelRegister = new RegisterForm();
            JButton cmdExit = new JButton("Exit");
            cmdExit.putClientProperty(FlatClientProperties.STYLE, "" +
                    "margin:5,10,5,10;"
                    + "borderWidth:0;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;"
            );
            cmdExit.addActionListener(e->{
                runLoginAnimation(false);
            });

            JButton cmdRegister = new JButton("Register");
            cmdRegister.putClientProperty(FlatClientProperties.STYLE, "" +
                            "margin:5,10,5,10;"
                            + "borderWidth:0;"
                            + "focusWidth:0;"
                            + "innerFocusWidth:0;"
                    );
            registerController = new RegisterController(em);
            cmdRegister.addActionListener(e ->{
                //registerController.register(panelRegister);
            });

            panelRegister.add(cmdExit);
            panelRegister.add(cmdRegister);
            add(panelRegister, "pos 100% 0.5al,w 350");
        }


        private void createPageButton() {
            JPanel panel = new JPanel(new MigLayout("gapx 20"));
            panel.setOpaque(false);
            for (int i = 0; i < locations.size(); i++) {
                JButton cmd = new JButton("");
                cmd.putClientProperty(FlatClientProperties.STYLE, "" +
                        "margin:5,5,5,5;" +
                        "arc:999;" +
                        "borderWidth:0;" +
                        "focusWidth:0;" +
                        "innerFocusWidth:0;" +
                        "selectedBackground:$Component.accentColor");
                cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));

                final int index = i;
                cmd.addActionListener(e -> {
                    if(this.index != index) {
                        boolean act = runAnimation(index, AnimationType.CLOSE_VIDEO);
                        if(act){
                            setSelectedButton(panel, index);
                        }
                    }
                });
                panel.add(cmd);
            }
            add(panel, "pos 0.5al 80%");
            setSelectedButton(panel, index);
        }

        private void setSelectedButton(JPanel panel, int index) {
            int count = panel.getComponentCount();
            for (int i = 0; i < count; i++) {
                JButton cmd = (JButton) panel.getComponent(i);
                if (i == index) {
                    cmd.setSelected(true);
                } else {
                    cmd.setSelected(false);
                }
            }
        }

        private boolean runAnimation(int index, AnimationType animationType) {
            if (!animator.isRunning()) {
                this.animate = 0;
                this.animationType = animationType;
                this.index = index;
                animator.start();
                return true;
            } else {
                return false;
            }
        }

        private void runLoginAnimation(boolean show) {
            if(showRegister) {
                runRegisterAnimation(false);
            }
            if (showLogin != show) {
                if (!loginAnimator.isRunning()) {
                    showLogin = show;
                    loginAnimator.start();
                }
            }
        }

        private void runRegisterAnimation(boolean show) {
            if(showLogin) {
                runLoginAnimation(false);
            }
            if (showRegister != show) {
                if (!registerAnimator.isRunning()) {
                    showRegister = show;
                    registerAnimator.start();
                }
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            if (animationType != AnimationType.NONE) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = getWidth();
                int height = getHeight();
                g2.setColor(UIManager.getColor("Component.accentColor"));
                Rectangle rec = new Rectangle(0, 0, width, height);
                if (animationType == AnimationType.CLOSE_VIDEO) {
                    g2.setComposite(AlphaComposite.SrcOver.derive(animate));
                    g2.fill(rec);
                } else {
                    Area area = new Area(rec);
                    area.subtract(new Area(createRec(rec)));
                    g2.fill(area);
                }
                g2.dispose();
            }
            super.paintComponent(g);
        }

        private Shape createRec(Rectangle rec) {
            int maxSize = Math.max(rec.width, rec.height);
            float size = maxSize * animate;
            float x = (rec.width - size) / 2;
            float y = (rec.height - size) / 2;
            Ellipse2D ell = new Ellipse2D.Double(x, y, size, size);
            return ell;
        }

        private LoginForm panelLogin;
        private RegisterForm panelRegister;
        private RegisterController registerController;


    }

    public enum AnimationType {
        CLOSE_VIDEO,SHOW_VIDEO,NONE
    }
}
