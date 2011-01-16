package de.purchasemgr.core;

import de.purchasemgr.core.purchase.PurchaseController;
import de.purchasemgr.core.shop.ShopController;
import de.purchasemgr.data.type.Shop;

/**
 * This is the controller for the whole program and is the layer that acts with the different controllers
 * 
 * @author croesch
 * @since Date: 16.01.2011 12:27:23
 */
public class MainController {

  private final ShopController sController = new ShopController();

  private final PurchaseController pController = new PurchaseController(this.sController);

  /**
   * Creates a new purchase and delegates the command to the purchase controller
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:34:08
   */
  public void newPurchase() {
    this.pController.newPurchase();
  }

  /**
   * Edits the selected purchase in the list
   * 
   * @author croesch
   * @since Date: 16.01.2011 13:47:26
   */
  public void editSelectedPurchase() {
    this.pController.editSelectedPurchase();
  }

  /**
   * Deletes the selected purchase from the list
   * 
   * @author croesch
   * @since Date: 16.01.2011 13:47:44
   */
  public void removeSelectedPurchase() {
    this.pController.removeSelectedPurchase();
  }

  /**
   * Returns the number of available shops
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:05:21
   * @return the number of available {@link Shop}s
   */
  public int getShopCount() {
    return this.sController.getShopCount();
  }

  /**
   * Start creating a new {@link Shop}
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:05:55
   */
  public void newShop() {
    this.sController.newShop();
  }

  /**
   * Start editing the available {@link Shop}s
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:06:28
   */
  public void editShops() {
    this.sController.editShops();
  }
}
