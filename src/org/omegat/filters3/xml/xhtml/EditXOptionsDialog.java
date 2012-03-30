/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
               2007-2008 Didier Briel, Martin Fleurke
               2009 Didier Briel
               2012 Martin Fleurke
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 **************************************************************************/

package org.omegat.filters3.xml.xhtml;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.omegat.util.OStrings;

/**
 * Modal dialog to edit (X)HTML filter options.
 * 
 * @author Maxym Mykhalchuk
 * @author Didier Briel
 * @author Martin Fleurke
 */
@SuppressWarnings("serial")
public class EditXOptionsDialog extends javax.swing.JDialog {
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    /** Creates new form EditOptionsDialog */
    public EditXOptionsDialog(java.awt.Dialog parent, Map<String, String> config) {
        super(parent, true);
        this.options = new XHTMLOptions(new TreeMap<String, String>(config));
        initComponents();

        translateHrefCB.setSelected(options.getTranslateHref());
        translateSrcCB.setSelected(options.getTranslateSrc());
        translateLangCB.setSelected(options.getTranslateLang());
        translateHreflangCB.setSelected(options.getTranslateHreflang());
        translateValueCB.setSelected(options.getTranslateValue());
        translateButtonValueCB.setSelected(options.getTranslateButtonValue());
        paragraphOnBrCB.setSelected(options.getParagraphOnBr());
        skipRegExpTF.setText(options.getSkipRegExp());
        skipMetaTF.setText(options.getSkipMeta());

        // Handle escape key to close the window
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    private XHTMLOptions options;

    public XHTMLOptions getOptions() {
        return options;
    }

    private int returnStatus = RET_CANCEL;

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        translateHrefCB = new javax.swing.JCheckBox();
        translateSrcCB = new javax.swing.JCheckBox();
        translateLangCB = new javax.swing.JCheckBox();
        translateHreflangCB = new javax.swing.JCheckBox();
        translateValueCB = new javax.swing.JCheckBox();
        translateButtonValueCB = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        paragraphOnBrCB = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        skipRegExpTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        skipMetaTF = new javax.swing.JTextField();

        setTitle(OStrings.getString("XHTML_Filter_Options"));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        org.openide.awt.Mnemonics.setLocalizedText(okButton, OStrings.getString("BUTTON_OK"));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(okButton);

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, OStrings.getString("BUTTON_CANCEL"));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.setMinimumSize(new java.awt.Dimension(167, 121));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, OStrings.getString("HTML_TRANSLATE_ATTRIBUTES"));
        jPanel1.add(jLabel2);

        translateHrefCB.setSelected(true);
        org.openide.awt.Mnemonics
                .setLocalizedText(translateHrefCB, OStrings.getString("HTML_TRANSLATE_HREF"));
        translateHrefCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateHrefCBradiosActionPerformed(evt);
            }
        });

        jPanel1.add(translateHrefCB);

        translateSrcCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateSrcCB, OStrings.getString("HTML_TRANSLATE_SRC"));
        translateSrcCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateSrcCBradiosActionPerformed(evt);
            }
        });

        jPanel1.add(translateSrcCB);

        translateLangCB.setSelected(true);
        org.openide.awt.Mnemonics
                .setLocalizedText(translateLangCB, OStrings.getString("HTML_TRANSLATE_LANG"));
        translateLangCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateLangCBradiosActionPerformed(evt);
            }
        });

        jPanel1.add(translateLangCB);

        translateHreflangCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateHreflangCB,
                OStrings.getString("HTML_TRANSLATE_HREFLANG"));
        translateHreflangCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateHreflangCBradiosActionPerformed(evt);
            }
        });

        jPanel1.add(translateHreflangCB);

        translateValueCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateValueCB,
                OStrings.getString("HTML_TRANSLATE_VALUE"));
        translateValueCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateValueCBradiosActionPerformed(evt);
            }
        });

        jPanel1.add(translateValueCB);

        translateButtonValueCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateButtonValueCB,
                OStrings.getString("HTML_TRANSLATE_BUTTON_VALUE"));
        translateButtonValueCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateButtonValueCBradiosActionPerformed(evt);
            }
        });

        jPanel1.add(translateButtonValueCB);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, OStrings.getString("HTML_PARAGRAPH_ON"));
        jPanel1.add(jLabel3);

        org.openide.awt.Mnemonics.setLocalizedText(paragraphOnBrCB,
                OStrings.getString("HTML_PARAGRAPH_ON_BR"));
        paragraphOnBrCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paragraphOnBrCBradiosActionPerformed(evt);
            }
        });

        jPanel1.add(paragraphOnBrCB);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, OStrings.getString("HTML_SKIPREGEXP"));
        jPanel1.add(jLabel4);

        skipRegExpTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipRegExpTFActionPerformed(evt);
            }
        });

        jPanel1.add(skipRegExpTF);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, OStrings.getString("HTML_SKIPMETA"));
        jPanel1.add(jLabel5);

        skipMetaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipMetaTFActionPerformed(evt);
            }
        });

        jPanel1.add(skipMetaTF);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);
    }// </editor-fold>//GEN-END:initComponents

    private void paragraphOnBrCBradiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_paragraphOnBrCBradiosActionPerformed
    // TODO add your handling code here:
    }// GEN-LAST:event_paragraphOnBrCBradiosActionPerformed

    private void translateValueCBradiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_translateValueCBradiosActionPerformed
    // TODO add your handling code here:
    }// GEN-LAST:event_translateValueCBradiosActionPerformed

    private void translateHreflangCBradiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_translateHreflangCBradiosActionPerformed
    // TODO add your handling code here:
    }// GEN-LAST:event_translateHreflangCBradiosActionPerformed

    private void translateButtonValueCBradiosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void translateLangCBradiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_translateLangCBradiosActionPerformed
    // TODO add your handling code here:
    }// GEN-LAST:event_translateLangCBradiosActionPerformed

    private void translateSrcCBradiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_translateSrcCBradiosActionPerformed
    // TODO add your handling code here:
    }// GEN-LAST:event_translateSrcCBradiosActionPerformed

    private void translateHrefCBradiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_translateHrefCBradiosActionPerformed
    }// GEN-LAST:event_translateHrefCBradiosActionPerformed

    private void skipRegExpTFActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void skipMetaTFActionPerformed(java.awt.event.ActionEvent evt) {
    }

    /**
     * Checks text value of JTextField if it is a valid regular expression. If not, focus is set to the text field and an alert is shown.
     * @param textfield the text field with the regular expression
     * @return true if regular expression is valid, false otherwise
     */
    private boolean checkRegExp(JTextField textfield) {
        try {
            Pattern.compile(textfield.getText());
        } catch (PatternSyntaxException e) {
            textfield.setCaretPosition(e.getIndex());
            JOptionPane.showMessageDialog(this,
                    e.getLocalizedMessage(), OStrings.getString("HTML_ERROR_CUSTOMREGEXP_TITLE"),
                    JOptionPane.ERROR_MESSAGE);
            textfield.grabFocus();
            return false;
        }
        return true;
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_okButtonActionPerformed
    {
        if (!checkRegExp(skipRegExpTF)) {
            return;
        }
        options.setTranslateHref(translateHrefCB.isSelected());
        options.setTranslateSrc(translateSrcCB.isSelected());
        options.setTranslateLang(translateLangCB.isSelected());
        options.setTranslateValue(translateValueCB.isSelected());
        options.setTranslateButtonValue(translateButtonValueCB.isSelected());
        options.setTranslateHreflang(translateHreflangCB.isSelected());
        options.setParagraphOnBr(paragraphOnBrCB.isSelected());
        options.setSkipRegExp(skipRegExpTF.getText());
        options.setSkipMeta(skipMetaTF.getText());

        doClose(RET_OK);
    }// GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_cancelButtonActionPerformed
    {
        doClose(RET_CANCEL);
    }// GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt)// GEN-FIRST:event_closeDialog
    {
        doClose(RET_CANCEL);
    }// GEN-LAST:event_closeDialog

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox paragraphOnBrCB;
    private javax.swing.JTextField skipRegExpTF;
    private javax.swing.JTextField skipMetaTF;
    private javax.swing.JCheckBox translateHrefCB;
    private javax.swing.JCheckBox translateHreflangCB;
    private javax.swing.JCheckBox translateLangCB;
    private javax.swing.JCheckBox translateSrcCB;
    private javax.swing.JCheckBox translateValueCB;
    private javax.swing.JCheckBox translateButtonValueCB;
    // End of variables declaration//GEN-END:variables
}
