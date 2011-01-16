package de.purchasemgr.core.purchase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import de.purchasemgr.data.type.Purchase;
import de.purchasemgr.data.type.Shop;

/**
 * This is the main controller, it controls all data in the main frame
 * 
 * @author croesch
 * @since Date: 15.01.2011 15:57:21
 */
public class PurchaseController {

  private final PurchaseModel model = new PurchaseModel();

  private final PurchaseView view = new PurchaseView(this);

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
  public List<Purchase> getList() {
    return this.model.getPurchases();
  }
}