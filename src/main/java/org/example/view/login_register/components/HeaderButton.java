package org.example.view.login_register.components;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import org.example.view.login_register.utils.RippleEffect;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class HeaderButton extends JButton {

    private RippleEffect rippleEffect;


    public HeaderButton(String string) {
        super(string);
        init();
    }

    private void init() {
        rippleEffect = new RippleEffect(this);
        setContentAreaFilled(false); // xoa vien button
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        // set font cho button
        //setForeground(Color.red); // set color cho tex button
        putClientProperty(FlatClientProperties.STYLE,
                "" +
                "font:bold +3");
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int arc = UIScale.scale(20);
        rippleEffect.reder(g, new RoundRectangle2D.Double(0,0 , getWidth(), getHeight(), arc, arc));

    }
}
