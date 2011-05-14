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

import com.github.croesch.components.CButton;

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

  /** the frame for to add a new purchase */
  private final Window newPurchase;

  /** the text field to enter the day of the date, when adding a new purchase */
  private final JTextField dayField = new JTextField();

  /** the text field to enter the month of the date, when adding a new purchase */
  private final JTextField monthField = new JTextField();

  /** the text field to enter the year of the date, when adding a new purchase */
  private final JTextField yearField = new JTextField();

  /** the controller of this view */
  private final PurchaseController controller;

  /** the list that visualises the purchases stored in the model */
  private final JList purchaseList = new JList();

  /** the {@link java.awt.ScrollPane} that wraps the list of purchases */
  private JScrollPane scrollingPurchaseList;

  /**
   * Constructs the view for the purchases
   * 
   * @author croesch
   * @since Date: 15.01.2011 17:20:01
   * @param cont the controller of this view
   */
  public PurchaseView(final PurchaseController cont) {
    this.controller = cont;
    this.newPurchase = createNewPurchaseFrame();

    initList();
  }

  /**
   * Initialises the list of purchases
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:44:54
   */
  private void initList() {
    this.purchaseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.purchaseList.setLayoutOrientation(JList.VERTICAL);
    this.purchaseList.setVisibleRowCount(-1);

    this.scrollingPurchaseList = new JScrollPane(this.purchaseList);
  }

  /**
   * not implemented
   * 
   * @param toEdit the purchase to edit
   */
  final void edit(final Purchase toEdit) {
    //TODO implement
    LogManager.log("edit: " + toEdit); //$NON-NLS-1$
  }

  /**
   * Returns the index of the selected purchase in the list.
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:46:16
   * @see JList#getSelectedIndex()
   * @return the index of the selected purchase in the list
   */
  final int getSelectedPurchaseIndex() {
    return this.purchaseList.getSelectedIndex();
  }

  /**
   * Constructs the frame to add a new purchase
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:48:13
   * @return the constructed {@link Window}
   */
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

    final int width = 400;
    final int height = 200;

    Window.Builder b = new Window.Builder(width, height);
    b = b.title(Messages.PURCHASE_NEW.text()).component(pan);
    return b.build();
  }

  /**
   * Shows the frame for adding a new purchase attribute.
   * 
   * @since Date: 15.01.2011 17:21:53
   */
  public final void showNewPurchaseFrame() {

    this.newPurchase.setVisible(true);
  }

  /**
   * Returns the frame to add a new purchase
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:49:34
   * @return the {@link Window} to add a new {@link Purchase}
   */
  final Window getNewPurchaseFrame() {
    return this.newPurchase;
  }

  /**
   * Submits the data of creating a new purchase given from the frame to create a new purchase and the shop field, that
   * returns the selected shop
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:50:38
   */
  final void addPurchase() {
    final Shop selectedShop = this.controller.getSelectedShop();
    this.controller.createPurchase(this.dayField.getText(), this.monthField.getText(), this.yearField.getText(),
                                   selectedShop);
    this.newPurchase.setVisible(false);
  }

  /**
   * Updates the list of purchases and sets the given data to the model
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:55:35
   * @see JList#setListData(Object[])
   * @param data the new data for the list
   */
  final void updatePurchaseList(final List<Purchase> data) {
    this.purchaseList.setListData(data.toArray());
  }

  /**
   * Returns the visualised data. Normally a {@link JList} that represents the given data.
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:57:50
   * @param list the data to display in the list
   * @return the list of purchases
   */
  final Component getPurchaseList(final List<Purchase> list) {
    updatePurchaseList(list);
    return this.scrollingPurchaseList;
  }

  /**
   * Action that is used in this view, provides different actions
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:51:28
   */
  private class PurchaseAction extends AbstractAction {

    /** generated version UID */
    private static final long serialVersionUID = 1L;

    /** the constant for action cancel in frame for a new purchase */
    static final int NEW_CANCEL = 1;

    /** the constant for save cancel in frame for a new purchase */
    static final int NEW_SAVE = 2;

    /** the id of this action */
    private final int id;

    /**
     * Constructs a new default action. The behaviour is defined by the given id.
     * 
     * @author croesch
     * @since Date: 06.02.2011 16:52:53
     * @param actionID the id that defines the action
     * @throws IllegalArgumentException if the given id is invalid
     */
    PurchaseAction(final int actionID) throws IllegalArgumentException {
      this.id = actionID;
      String name;
      switch (this.id) {
        case NEW_CANCEL:
          name = Messages.PURCHASE_NEW_CANC.text();
          break;
        case NEW_SAVE:
          name = Messages.PURCHASE_NEW_SAVE.text();
          break;
        default:
          throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String.valueOf(this.id)));
      }
      putValue(Action.NAME, name);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
      if (this.id == NEW_CANCEL) {
        PurchaseView.this.getNewPurchaseFrame().setVisible(false);
      } else if (this.id == NEW_SAVE) {
        PurchaseView.this.addPurchase();
      } else {
        LogManager.log(Messages.LOG_ACTION_ERROR.text(e.getActionCommand()));
      }
    }
  }
}
