package de.purchasemgr.core;

import java.awt.Component;

import de.purchasemgr.core.purchase.PurchaseController;
import de.purchasemgr.core.shop.ShopController;

/**
 * This is the controller for the whole program and is the layer that acts with the different controllers.
 * 
 * @author croesch
 * @since Date: 16.01.2011 12:27:23
 */
public class MainController {

  /** the view of this controller. */
  private MainView view;

  /** the controller for shops. */
  private final ShopController sController = new ShopController();

  /** the controller for purchases. */
  private final PurchaseController pController = new PurchaseController(this.sController);

  /**
   * Starts the program and displays the main frame.
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:42:26
   */
  public final void start() {
    this.view = new MainView(this);
    this.view.displayMainWindow();
  }

  /**
   * Displays the about frame.
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:42:48
   */
  public final void about() {
    this.view.displayAboutWindow();
  }

  /**
   * Creates a new purchase and delegates the command to the purchase controller.
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:34:08
   */
  public final void newPurchase() {
    this.pController.newPurchase();
  }

  /**
   * Edits the selected purchase in the list.
   * 
   * @author croesch
   * @since Date: 16.01.2011 13:47:26
   */
  public final void editSelectedPurchase() {
    this.pController.editSelectedPurchase();
  }

  /**
   * Deletes the selected purchase from the list.
   * 
   * @author croesch
   * @since Date: 16.01.2011 13:47:44
   */
  public final void removeSelectedPurchase() {
    this.pController.removeSelectedPurchase();
  }

  /**
   * Returns the number of available shops.
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:05:21
   * @return the number of available {@link de.purchasemgr.data.type.Shop}s
   */
  public final int getShopCount() {
    return this.sController.getShopCount();
  }

  /**
   * Start creating a new {@link de.purchasemgr.data.type.Shop}.
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:05:55
   */
  public final void newShop() {
    this.sController.newShop();
  }

  /**
   * Start editing the available {@link de.purchasemgr.data.type.Shop}s.
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:06:28
   */
  public final void editShops() {
    this.sController.editShops();
  }

  /**
   * Returns the list of purchases from the purchase controller.
   * 
   * @author croesch
   * @since Date: 30.01.2011 16:44:01
   * @return a component that displays the list of purchases
   */
  final Component getPurchaseList() {
    return this.pController.getPurchaseList();
  }
}
