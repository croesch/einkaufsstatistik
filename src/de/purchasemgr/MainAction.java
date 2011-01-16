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
    } else if (this.id == ActionPool.ABOUT.ordinal()) {
      GUIManager.about();
    } else if (this.id == ActionPool.NEW_PURCHASE.ordinal()) {
      if (controller.getShopCount() == 0) {
        LogManager.log(Messages.LOG_NOSHOPFORPURCHASE.text(), true);
      } else {
        controller.newPurchase();
      }
    } else if (this.id == ActionPool.EDIT_SHOPS.ordinal()) {
      controller.editShops();
    } else if (this.id == ActionPool.NEW_SHOP.ordinal()) {
      controller.newShop();
    } else if (this.id == ActionPool.EDIT_PURCHASE.ordinal()) {
      controller.editSelectedPurchase();
    } else if (this.id == ActionPool.DEL_PURCHASE.ordinal()) {
      controller.removeSelectedPurchase();
    } else {
      LogManager.log(Messages.LOG_ACTION_ERROR.text(e.getActionCommand()));
    }
  }
}