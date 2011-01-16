package de.purchasemgr.core.purchase;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import de.crhcomponents.components.CButton;
import de.purchasemgr.gui.Window;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.i18n.Strings;
import de.purchasemgr.logging.LogManager;

/**
 * View for the purchases contains different views for the different situations
 * 
 * @author croesch
 * @since Date: 15.01.2011 17:09:19
 */
public class PurchaseView {

  private final Window newPurchase;

  private final JTextField dayField = new JTextField();

  private final JTextField monthField = new JTextField();

  private final JTextField yearField = new JTextField();

  private final JComboBox shopField;

  private final PurchaseController controller;

  /**
   * Constructs the view for the purchases
   * 
   * @author croesch
   * @since Date: 15.01.2011 17:20:01
   * @param cont the controller of this view
   */
  public PurchaseView(PurchaseController cont) {
    this.controller = cont;
    //TODO let the ShopController generate this CB
    this.shopField = new JComboBox(/* this.model.getShops().toArray() */);
    this.newPurchase = createNewPurchaseFrame();
  }

  @SuppressWarnings("nls")
  private Window createNewPurchaseFrame() {

    final String empty = Strings.EMPTY_STRING.text();
    final String migEmpty = "[]";
    final String columConstraints = migEmpty + "[30lp][30lp][30lp][30lp][grow]";
    final String rowConstraints = migEmpty + migEmpty + "[grow]" + migEmpty;

    JLabel dateDesc = new JLabel(Messages.PURCHASE_NEW_DATE.text());

    JPanel pan = new JPanel();
    pan.setLayout(new MigLayout(empty, columConstraints, rowConstraints));

    pan.add(dateDesc, "cell 0 0, alignx left, aligny center");
    pan.add(this.dayField, "cell 2 0, growx, aligny center");
    pan.add(this.monthField, "cell 3 0, growx, aligny center");
    pan.add(this.yearField, "cell 4 0, growx, aligny center");
    JLabel shopDesc = new JLabel(Messages.PURCHASE_NEW_SHOP.text());
    pan.add(shopDesc, "cell 0 1, alignx left, aligny center");
    pan.add(this.shopField, "cell 2 1 3 1, growx, aligny center");

    JPanel panel = new JPanel();
    pan.add(panel, "cell 0 3 6 1,alignx right");
    panel.setLayout(new MigLayout(empty, migEmpty + migEmpty, migEmpty));

    JButton createPurch = new CButton(new PurchaseAction(PurchaseAction.NEW_SAVE));
    panel.add(createPurch, "cell 0 0, sg");
    JButton cancelNewPurch = new CButton(new PurchaseAction(PurchaseAction.NEW_CANCEL));
    panel.add(cancelNewPurch, "cell 1 0, sg");

    return new Window(pan, 400, 200, null, Messages.PURCHASE_NEW.text());
  }

  /**
   * Shows the frame for adding a new purchase attribute.
   * 
   * @since Date: 15.01.2011 17:21:53
   */
  public void showNewPurchaseFrame() {
    this.newPurchase.setVisible(true);
  }

  Window getNewPurchaseFrame() {
    return this.newPurchase;
  }

  void addPurchase() {
    //TODO get Shop from CB
    this.controller.createPurchase(this.dayField.getText(), this.monthField.getText(), this.yearField.getText(), null);
  }

  private class PurchaseAction extends AbstractAction {

    /** generated version UID */
    private static final long serialVersionUID = 1L;

    static final int NEW_CANCEL = 1;

    static final int NEW_SAVE = 2;

    private final int id;

    PurchaseAction(int id) {
      this.id = id;
      String name;
      switch (id) {
        case NEW_CANCEL:
          name = Messages.PURCHASE_NEW_CANC.text();
          break;
        case NEW_SAVE:
          name = Messages.PURCHASE_NEW_SAVE.text();
          break;
        default:
          throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String.valueOf(id)));
      }
      putValue(Action.NAME, name);
    }

    public void actionPerformed(ActionEvent e) {
      if (this.id == NEW_CANCEL) {
        PurchaseView.this.getNewPurchaseFrame().setVisible(false);
      } else if (this.id == NEW_SAVE) {
        PurchaseView.this.addPurchase();
        PurchaseView.this.getNewPurchaseFrame().setVisible(false);
      } else {
        LogManager.log(Messages.LOG_ACTION_ERROR.text(e.getActionCommand()));
      }
    }
  }
}
