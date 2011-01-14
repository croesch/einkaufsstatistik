package de.purchasemgr;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;

import de.purchasemgr.gui.GUIManager;
import de.purchasemgr.gui.Window;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.logging.LogManager;

/**
 * TODO Comment here!!!
 * 
 * @author $Author: croesch $
 * @version $Revision: 1.5 $ ($Date: 2010/12/19 10:41:42 $)
 */
public class MainAction extends AbstractAction {

  /** generated version UID */
  private static final long serialVersionUID = 2926281029596958445L;

  Window parentWindow;

  private static GUIManager gui;

  private void exit() {
    System.exit(0);
  }

  public void actionPerformed(ActionEvent e) {
    Action act = ((AbstractButton)e.getSource()).getAction();
    if (act.equals(ActionPool.EXIT.getAction())) {
      exit();
    } else if (act.equals(ActionPool.EDIT_SHOPS_NXT.getAction())) {
      gui.editShopsRefresh(++gui.nr);
    } else if (act.equals(ActionPool.EDIT_SHOPS_PRE.getAction())) {
      gui.editShopsRefresh(--gui.nr);
    } else if (act.equals(ActionPool.EDIT_SHOPS_NXT.getAction())) {
      gui.getModel().editShops(gui.nr);
    } else if (act.equals(ActionPool.EDIT_SHOPS_CAN.getAction())) {
      gui.editShop.setVisible(false);
    } else if (act.equals(ActionPool.NEW_PURCHASE_CAN.getAction())) {
      gui.newPurchase.setVisible(false);
    } else if (act.equals(ActionPool.ABOUT.getAction())) {
      GUIManager.about();
    } else if (act.equals(ActionPool.NEW_PURCHASE.getAction())) {
      if (gui.getModel().getShops().toArray().length == 0 || gui.getModel().getShops() == null) {
        LogManager.log(Messages.LOG_NOSHOPFORPURCHASE.text(), true);
      } else {
        gui.newPurchase();
      }
    } else if (act.equals(ActionPool.NEW_SHOP_CANCEL.getAction())) {
      gui.newShop.setVisible(false);
    } else if (act.equals(ActionPool.NEW_SHOP_OK.getAction())) {
      gui.getModel().addShop();
    } else if (act.equals(ActionPool.EDIT_SHOPS.getAction())) {
      gui.editShops(0);
    } else if (act.equals(ActionPool.NEW_SHOP.getAction())) {
      gui.editShops(1);
    } else if (act.equals(ActionPool.NEW_PURCHASE_SAVE.getAction())) {
      gui.getModel().addPurchase();
    } else if (act.equals(ActionPool.EDIT_PURCHASE.getAction())) {
      gui.editPurchase();
    } else if (act.equals(ActionPool.DEL_PURCHASE.getAction())) {
      gui.removeSelectedPurchase();
    } else {
      LogManager.log(Messages.LOG_ACTION_ERROR.text(e.getActionCommand()));
    }
  }

  MainAction(String s, Window f) {
    this(s);
    this.parentWindow = f;
  }

  MainAction(String s) {
    super(s);
  }

  /**
   * sets the GUIManager for the MainAction
   * 
   * @param guim the new GUIManager
   */
  public static void init(GUIManager guim) {
    MainAction.gui = guim;
  }

}