/*
 * Copyright (C) 2014 beatsleigher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package eu.m4gkbeatz.androidtoolkit.ui;


import JDroidLib.android.controllers.*;
import JDroidLib.android.device.*;

import eu.m4gkbeatz.androidtoolkit.logging.Logger;
import eu.m4gkbeatz.androidtoolkit.settings.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author beatsleigher
 */
public class Devices extends javax.swing.JFrame {
    
    private boolean debug = false;
    private Logger logger = null;
    private Logger.Level level = null;
    private ADBController adbController = null;
    private HashMap<Device, ImageIcon> deviceMap = new HashMap<>();
    private SettingsManager settings = null;
    private boolean ACTIVATED = false;
    private UAT instance = null;
    private static int SELECTED_DEVICE = 0;

    public Devices(boolean debug, Logger logger, Logger.Level level, ADBController adbController, SettingsManager settings, UAT uat) {
        this.logger = logger;
        this.level = level;
        this.debug = debug;
        this.adbController = adbController;
        this.settings = settings;
        initComponents();
        jList1.setCellRenderer(new DeviceListRenderer());
        instance = uat;
        this.setTitle("Universal Android Toolkit | Devices");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/eu/m4gkbeatz/androidtoolkit/resources/device-icon.png")).getImage());
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jButton2.setText("Reload (F5)");

        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                form_keyPressed(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("via ADB", jPanel1);

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                form_keyPressed(evt);
            }
        });

        jButton1.setText("Reload (F5)");

        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.addTab("via Fastboot", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void form_keyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_form_keyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5)
            try {
                reload();
            } catch (IOException ex) {
                logger.log(level.ERROR, "Error while loading devices! Stack trace will be printed to console...");
                JOptionPane.showMessageDialog(null, "An error occured while loading currently connected devices.\n"
                        + "Please terminate and re-run the erronious step to determine where the error has occurred.", "Error While Loading Devices.", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(System.err);
            }
    }//GEN-LAST:event_form_keyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (!ACTIVATED) {
            reloadTimer();
            ACTIVATED = true;
        }
    }//GEN-LAST:event_formWindowActivated

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if (debug && jList1.getSelectedValue() != null)
            logger.log(level.DEBUG, "New device selected: " + jList1.getSelectedValue().toString());
        if (jList1.getSelectedIndex() != -1 || jList1.getSelectedValue() != null) {
            instance.selectedDevice = new Device(jList1.getSelectedValue().toString().trim(), adbController);
            SELECTED_DEVICE = jList1.getSelectedIndex();
            instance.stopDMESG();
            instance.stopLogcat();
            instance.startDMESG(instance.selectedDevice);
            instance.startLogcat(instance.selectedDevice);
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void reloadTimer() {
        new Thread() {
            @Override
            public void run() {
                while (settings.refreshDevices()) {
                    try {
                        reload();
                        Thread.sleep(settings.getDeviceRefreshInterval());
                    } catch (InterruptedException | IOException ex) {
                        logger.log(level.ERROR, "Error occurred while reloading devices! Error stack trace will be printed to the console...");
                        ex.printStackTrace(System.err);
                        interrupt();
                    }
                }
                interrupt();
            }
        }.start();
    }
    
    private void reload() throws IOException {
        if (debug)
            logger.log(level.DEBUG, "Reloading devices...");
        
        // Load ADB devices
        deviceMap.clear();
        DefaultListModel model = new DefaultListModel();
        for (Device dev : adbController.getConnectedDevices()) {
            model.addElement(dev.toString());
            deviceMap.put(dev, new ImageIcon(this.getClass().getResource("/eu/m4gkbeatz/androidtoolkit/resources/device/status_" + String.valueOf(dev.getState()).toLowerCase() + ".png")));
        }
        jList1.setModel(model);
        
        // Load fastboot devices.
        model = new DefaultListModel();
        for (String str : adbController.getFastbootController().getConnectedDevices())
            model.addElement(str);
        jList2.setModel(model);
        
        jList1.setSelectedIndex(SELECTED_DEVICE);
        
        
        if (jList2.getSelectedValue() == null || jList2.getSelectedIndex() == -1 && jList2.getModel().getSize() != 0)
            jList2.setSelectedIndex(0);
    }
    
    public class DeviceListRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setIcon(deviceMap.get((String) value)); // TO-DO: Fix
            label.setHorizontalTextPosition(JLabel.RIGHT);
            return label;
        }

    }
    
    public Device getSelectedAndroidDevice() { return new Device(jList1.getSelectedValue().toString(), adbController); }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
