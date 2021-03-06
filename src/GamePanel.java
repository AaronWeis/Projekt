/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author Leto
 */
public class GamePanel extends javax.swing.JPanel {


    private boolean click_on_start = false; //for graphical usage

    private boolean game_is_running = false;

    private Control ctr;
    //Ints for game purposes
    private int mouse_last_x = 0;
    private int mouse_last_y = 0;
    private Point current_pos_mouse = new Point(0,0);

    //Ints for drawing purposes
    private int w = getWidth();
    private int h = getHeight();
    private int w_tenth = w / 10;
    private int h_tenth = h / 10;

    private Point null_point = new Point(0,0);// wird auf die positionen addiert um die welt perr drag zu verschieben und so mehr von der Karte anzuschauen
    /**
     * Creates new form GamePanel
     */


    public GamePanel() {
        initComponents();
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getMousePosition().x > w/2 - w_tenth && getMousePosition().y > h/2 - h_tenth &&
                        getMousePosition().x < w/2 + w_tenth && getMousePosition().y < h/2){


                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(!game_is_running){
                    if(getMousePosition().x > w/2 - w_tenth && getMousePosition().y > h/2 - h_tenth &&
                            getMousePosition().x < w/2 + w_tenth && getMousePosition().y < h/2){
                        click_on_start = true;

                    }
                }else{
                    set_last_pressed(getMousePosition().x, getMousePosition().y );
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(!game_is_running) {
                    if (getMousePosition().x > w / 2 - w_tenth && getMousePosition().y > h / 2 - h_tenth &&
                            getMousePosition().x < w / 2 + w_tenth && getMousePosition().y < h / 2) {
                        game_is_running = true;
                    }
                }else{
                    null_point.x += getMousePosition().x - mouse_last_x; // verschieben der karte   |??ndert die Position der root-Posotion auf der Karte.
                    null_point.y += getMousePosition().y - mouse_last_y; // ---------"-----------   |
                }
                click_on_start = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseAdapter() {//https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseAdapter.html
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
        ctr = new Control();
    }

    private void set_last_pressed(int x, int y){
        mouse_last_x = x;
        mouse_last_y = y;
        }

    public void paintComponent(Graphics g){ //AB HIER NURNOCH ZEICHENMETHODEN, ANDRER FUNKTIONEN WEITER OBEN DEFINIEREN.
        w = getWidth();
        h = getHeight();
        w_tenth = w / 10;
        h_tenth = h / 10;
        draw_background(g);
      //  draw_all_citizen(g);
        draw_last_pressed(g);
        draw_cr_mouse_pos(g);
        if(!game_is_running) draw_start_menue(g);

        repaint();
    }

    private void draw_cr_mouse_pos(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString("current Mouse position (" + current_pos_mouse.x +"|"+current_pos_mouse.y+")", 200, 20);
    }

    private void draw_background(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.getWidth(), this.getHeight());
    }

 /*   private void draw_all_citizen(Graphics g){
        g.setColor(Color.GREEN);

        int f_size = ctr.get_families_amount();

        for (int i = 0; i < f_size; ++i){
            int c_size = ctr.families.get(i).get_member_count();

            for (int j = 0; j < c_size; ++j){
                g.fillRect(ctr.get_fam_member_x_pos(i, j) + null_point.x, ctr.get_fam_member_y_pos(i,j) + null_point.y, 10, 10);
            }
        }

    }
*/
    private void draw_start_menue(Graphics g){
        if(click_on_start){
            g.setColor(Color.DARK_GRAY);
            g.fillRect(w/2 - w_tenth, h/2 - h_tenth, 2*w_tenth, h_tenth );

        }
        g.setColor(Color.WHITE);
        g.drawRect(w/2 - w_tenth, h/2 - h_tenth, 2*w_tenth, h_tenth );
        g.drawString("START GAME", w/2 - 36, h/2 - (int)(h_tenth * .5));
    }

    private void draw_last_pressed(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString("LAST CLICK ON (" + mouse_last_x +"|"+mouse_last_y+")", 10, 20);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>


    // Variables declaration - do not modify
    // End of variables declaration
}
