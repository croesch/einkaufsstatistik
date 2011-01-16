package de.purchasemgr.core;

import de.purchasemgr.core.purchase.PurchaseController;

/**
 * This is the controller for the whole program and is the layer that acts with the different controllers
 * 
 * @author croesch
 * @since Date: 16.01.2011 12:27:23
 */
public class MainController {

  PurchaseController pController = new PurchaseController();

  /**
   * Creates a new purchase and delegates the command to the purchase controller
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:34:08
   */
  public void newPurchase() {
    this.pController.newPurchase();
  }

}
