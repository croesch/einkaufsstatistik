package de.purchasemgr.core.purchase;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;
import de.crhcomponents.components.CButton;
import de.purchasemgr.data.type.Purchase;
import de.purchasemgr.data.type.Shop;
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

  private final PurchaseController controller;

  private final JList purchaseList = new JList();

  private JScrollPane scrollingPurchaseList;

  /**
   * Constructs the view for the purchases
   * 
   * @author croesch
   * @since Date: 15.01.2011 17:20:01
   * @param cont the controller of this view
   */
  public PurchaseView(PurchaseController cont) {
    this.controller = cont;
    this.newPurchase = createNewPurchaseFrame();

    initList();
  }

  private void initList() {
    this.purchaseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.purchaseList.setLayoutOrientation(JList.VERTICAL);
    this.purchaseList.setVisibleRowCount(-1);

    this.scrollingPurchaseList = new JScrollPane(this.purchaseList);
  }

  void edit(Purchase toEdit) {
    System.out.println(toEdit);
  }

  int getSelectedPurchaseIndex() {
    return this.purchaseList.getSelectedIndex();
  }

  @SuppressWarnings("nls")
  private Window createNewPurchaseFrame() {

    // constants to define the layout constraints
    final String empty = Strings.EMPTY_STRING.text();
    final String migEmpty = "[]";
    final String columConstraints = migEmpty + "[30lp][30lp][30lp][30lp][grow]";
    final String rowConstraints = migEmpty + migEmpty + "[grow]" + migEmpty;

    // panels used to group the content of the frame
    JPanel pan = new JPanel();
    pan.setLayout(new MigLayout(empty, columConstraints, rowConstraints));
    JPanel buttonsPan = new JPanel();
    buttonsPan.setLayout(new MigLayout(empty, migEmpty + migEmpty, migEmpty));

    // components of the frame
    JLabel dateDesc = new JLabel(Messages.PURCHASE_NEW_DATE.text());
    JLabel shopDesc = new JLabel(Messages.PURCHASE_NEW_SHOP.text());
    CButton savePurchase = new CButton(new PurchaseAction(PurchaseAction.NEW_SAVE));
    CButton cancel = new CButton(new PurchaseAction(PurchaseAction.NEW_CANCEL));

    //put the components to the labels
    buttonsPan.add(savePurchase, "cell 0 0, sg");
    buttonsPan.add(cancel, "cell 1 0, sg");

    pan.add(dateDesc, "cell 0 0, alignx left, aligny center");
    pan.add(this.dayField, "cell 2 0, growx, aligny center");
    pan.add(this.monthField, "cell 3 0, growx, aligny center");
    pan.add(this.yearField, "cell 4 0, growx, aligny center");
    pan.add(shopDesc, "cell 0 1, alignx left, aligny center");
    pan.add(this.controller.getShopBox(), "cell 2 1 3 1, growx, aligny center");
    pan.add(buttonsPan, "cell 0 3 6 1,alignx right");

    Window.Builder b = new Window.Builder(400, 200);
    b = b.title(Messages.PURCHASE_NEW.text()).component(pan);
    return b.build();
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
    final Shop selectedShop = this.controller.getSelectedShop();
    this.controller.createPurchase(this.dayField.getText(), this.monthField
      .getText(), this.yearField.getText(), selectedShop);
    this.newPurchase.setVisible(false);
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
          throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String
            .valueOf(id)));
      }
      putValue(Action.NAME, name);
    }

    public void actionPerformed(ActionEvent e) {
      if (this.id == NEW_CANCEL) {
        PurchaseView.this.getNewPurchaseFrame().setVisible(false);
      } else if (this.id == NEW_SAVE) {
        PurchaseView.this.addPurchase();
      } else {
        LogManager.log(Messages.LOG_ACTION_ERROR.text(e.getActionCommand()));
      }
    }
  }

  void updatePurchaseList(List<Purchase> data) {
    this.purchaseList.setListData(data.toArray());
  }

  Component getPurchaseList(List<Purchase> list) {
    updatePurchaseList(list);
    return this.scrollingPurchaseList;
  }
}
