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
 * This is the purchase controller, it controls all things that have to do with
 * {@link Purchase}s
 * 
 * @author croesch
 * @since Date: 15.01.2011 15:57:21
 */
public class PurchaseController {

  /** the model of this controller */
  private final PurchaseModel model = new PurchaseModel();

  /** the view of this controller */
  private final PurchaseView view;

  /** the controller for shops */
  private final ShopController sController;

  /** a calendar to generate dates for the purchase */
  private final Calendar cal = new GregorianCalendar();

  /**
   * Constructs a new PurchaseController
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:55:37
   * @param sCont the {@link ShopController} for this instance
   */
  public PurchaseController(final ShopController sCont) {
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
  final void createPurchase(final String day,
                            final String month,
                            final String year,
                            final Shop shop) {
    this.cal.set(Integer.valueOf(year).intValue(), Integer.valueOf(month)
      .intValue() - 1, Integer.valueOf(day).intValue());
    this.model.addPurchase(new Purchase(this.cal.getTimeInMillis(), shop));
    this.view.updatePurchaseList(this.model.getPurchases());
  }

  /**
   * Shows the window for adding a new purchase
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:26:01
   */
  public final void newPurchase() {
    this.view.showNewPurchaseFrame();
  }

  /**
   * Returns a list of the purchases
   * 
   * @author croesch
   * @since Date: 15.01.2011 16:22:35
   * @return a list of the purchases
   */
  final List<Purchase> getList() {
    return this.model.getPurchases();
  }

  /**
   * deletes the selected purchase, logs if that couldn't be done
   */
  public final void removeSelectedPurchase() {
    try {
      this.model.remove(this.view.getSelectedPurchaseIndex());
      this.view.updatePurchaseList(this.model.getPurchases());
    } catch (IndexOutOfBoundsException e) {
      LogManager.log(Messages.LOG_NOPURCHASETOEDIT.text(), true);
    }
  }

  /**
   * opens the editWindow for the selected purchase
   */
  public final void editSelectedPurchase() {
    Purchase selected = this.model.get(this.view.getSelectedPurchaseIndex());
    if (selected != null) {
      this.view.edit(selected);
    } else {
      LogManager.log(Messages.LOG_NOPURCHASETOEDIT.text(), true);
    }
  }

  /**
   * Calls {@link ShopController#getShopBox()}
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:31:20
   * @return returns {@link ShopController#getShopBox()}
   */
  final JComboBox getShopBox() {
    return this.sController.getShopBox();
  }

  /**
   * Returns the list of purchases to display
   * 
   * @author croesch
   * @since Date: 16.01.2011 19:21:45
   * @return a component that could be added to a frame to display the list
   */
  public final Component getPurchaseList() {
    return this.view.getPurchaseList(getList());
  }

  /**
   * Calls {@link ShopController#getSelectedShop()}
   * 
   * @author croesch
   * @since Date: 06.02.2011 16:31:20
   * @return returns {@link ShopController#getSelectedShop()}
   */
  final Shop getSelectedShop() {
    return this.sController.getSelectedShop();
  }
}
