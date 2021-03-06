package de.purchasemgr;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import de.purchasemgr.core.MainController;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.logging.LogManager;

/**
 * Class to provide the actions used in this program.
 * 
 * @author croesch
 * @since Date: 2010/12/19 10:41:42
 */
public class MainAction extends AbstractAction {

  /** generated version UID. */
  private static final long serialVersionUID = 1L;

  /** the controller of the main program. */
  private static MainController controller = new MainController();

  /** the id of the action. */
  private final int id;

  /**
   * Creates the Action for the given information.
   * 
   * @author croesch
   * @since Date: 30.01.2011 16:34:44
   * @param actionInfo the info of the action.
   */
  MainAction(final ActionPool actionInfo) {
    super(actionInfo.text());
    this.id = actionInfo.ordinal();
  }

  /**
   * Starts the program and displays the main window.
   * 
   * @author croesch
   * @since Date: 30.01.2011 16:35:22
   */
  static void start() {
    controller.start();
  }

  /**
   * Exits the program.
   * 
   * @author croesch
   * @since Date: 30.01.2011 16:35:38
   */
  private void exit() {
    System.exit(0);
  }

  @Override
  public final void actionPerformed(final ActionEvent e) {
    if (this.id == ActionPool.EXIT.ordinal()) {
      exit();
    } else if (this.id == ActionPool.ABOUT.ordinal()) {
      controller.about();
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
