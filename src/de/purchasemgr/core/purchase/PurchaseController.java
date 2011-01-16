package de.purchasemgr.core.purchase;

import java.awt.Component;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JComboBox;

import de.purchasemgr.core.shop.ShopController;
import de.purchasemgr.data.type.Purchase;
import de.purchasemgr.data.type.Shop;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.logging.LogManager;

/**
 * This is the purchase controller, it controls all things that have to do with {@link Purchase}s
 * 
 * @author croesch
 * @since Date: 15.01.2011 15:57:21
 */
public class PurchaseController {

  private final PurchaseModel model = new PurchaseModel();

  private final PurchaseView view;

  private final ShopController sController;

  /**
   * Constructs a new PurchaseController
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:55:37
   * @param sCont the {@link ShopController} for this instance
   */
  public PurchaseController(ShopController sCont) {
    this.sController = sCont;
    this.view = new PurchaseView(this);
  }

  /**
   * Creates a purchase with the given data and adds it to the intern model
   * 
   * @author croesch
   * @since Date: 15.01.2011 16:03:48
   * @param day the day of month of the purchase
   * @param month the month in the year of the purchase
   * @param year the year the purchase was done
   * @param shop the shop in that the purchase was
   */
  void createPurchase(String day, String month, String year, Shop shop) {
    Calendar cal = new GregorianCalendar();
    cal.set(Integer.valueOf(year).intValue(), Integer.valueOf(month).intValue() - 1, Integer.valueOf(day).intValue());
    this.model.addPurchase(new Purchase(cal.getTime(), shop));
  }

  /**
   * Shows the window for adding a new purchase
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:26:01
   */
  public void newPurchase() {
    this.view.showNewPurchaseFrame();
  }

  /**
   * Returns a list of the purchases
   * 
   * @author croesch
   * @since Date: 15.01.2011 16:22:35
   * @return a list of the purchases
   */
  List<Purchase> getList() {
    return this.model.getPurchases();
  }

  /**
   * deletes the selected purchase, logs if that couldn't be done
   */
  public void removeSelectedPurchase() {
    try {
      this.model.remove(this.view.getSelectedPurchaseIndex());
    } catch (IndexOutOfBoundsException e) {
      LogManager.log(Messages.LOG_NOPURCHASETOEDIT.text(), true);
    }
  }

  /**
   * opens the editWindow for the selected purchase
   */
  public void editSelectedPurchase() {
    Purchase selected = this.model.get(this.view.getSelectedPurchaseIndex());
    if (selected != null) {
      this.view.edit(selected);
    } else {
      LogManager.log(Messages.LOG_NOPURCHASETOEDIT.text(), true);
    }
  }

  JComboBox getShopBox() {
    return this.sController.getShopBox();
  }

  Shop getShopForIndex(int i) {
    return this.sController.getShopForIndex(i);
  }

  /**
   * Returns the list of purchases to display
   * 
   * @author croesch
   * @since Date: 16.01.2011 19:21:45
   * @return a component that could be added to a frame to display the list
   */
  public Component getPurchaseList() {
    return this.view.getPurchaseList(getList());
  }
}
