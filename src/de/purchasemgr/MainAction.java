package de.purchasemgr;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import de.purchasemgr.core.MainController;
import de.purchasemgr.gui.GUIManager;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.logging.LogManager;

/**
 * Class to provide the actions used in this program
 * 
 * @author croesch
 * @since Date: 2010/12/19 10:41:42
 */
public class MainAction extends AbstractAction {

  /** generated version UID */
  private static final long serialVersionUID = 1L;

  private static GUIManager gui;

  private static MainController controller = new MainController();

  private final int id;

  MainAction(ActionPool id) {
    super(id.text());
    this.id = id.ordinal();
  }

  private void exit() {
    System.exit(0);
  }

  public void actionPerformed(ActionEvent e) {
    if (this.id == ActionPool.EXIT.ordinal()) {
      exit();
    } else if (this.id == ActionPool.EDIT_SHOPS_NXT.ordinal()) {
      gui.editShopsRefresh(++gui.nr);
    } else if (this.id == ActionPool.EDIT_SHOPS_PRE.ordinal()) {
      gui.editShopsRefresh(--gui.nr);
    } else if (this.id == ActionPool.EDIT_SHOPS_NXT.ordinal()) {
      gui.getModel().editShops(gui.nr);
    } else if (this.id == ActionPool.EDIT_SHOPS_CAN.ordinal()) {
      gui.editShop.setVisible(false);
    } else if (this.id == ActionPool.ABOUT.ordinal()) {
      GUIManager.about();
    } else if (this.id == ActionPool.NEW_PURCHASE.ordinal()) {
      if (gui.getModel().getShops().toArray().length == 0 || gui.getModel().getShops() == null) {
        LogManager.log(Messages.LOG_NOSHOPFORPURCHASE.text(), true);
      } else {
        controller.newPurchase();
      }
    } else if (this.id == ActionPool.NEW_SHOP_CANCEL.ordinal()) {
      gui.newShop.setVisible(false);
    } else if (this.id == ActionPool.NEW_SHOP_OK.ordinal()) {
      gui.getModel().addShop();
    } else if (this.id == ActionPool.EDIT_SHOPS.ordinal()) {
      gui.editShops(0);
    } else if (this.id == ActionPool.NEW_SHOP.ordinal()) {
      gui.editShops(1);
    } else if (this.id == ActionPool.EDIT_PURCHASE.ordinal()) {
      gui.editPurchase();
    } else if (this.id == ActionPool.DEL_PURCHASE.ordinal()) {
      gui.removeSelectedPurchase();
    } else {
      LogManager.log(Messages.LOG_ACTION_ERROR.text(e.getActionCommand()));
    }
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