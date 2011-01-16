package de.purchasemgr.core.shop;

import javax.swing.JComboBox;

import de.purchasemgr.data.type.Shop;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.logging.LogManager;

/**
 * This is the shop controller, it controls all things that have to do with {@link Shop}s
 * 
 * @author croesch
 * @since Date: 16.01.2011 12:47:28
 */
public class ShopController {

  private final ShopModel model = new ShopModel();

  private final ShopView view = new ShopView(this);

  private int editIndex = 0;

  /**
   * Returns a combobox that contains all available shops
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:51:13
   * @return a {@link JComboBox} that contains all {@link Shop}s available
   */
  public JComboBox getShopBox() {
    return this.view.getBox(this.model.getShops());
  }

  /**
   * Returns a Shop for the selected index of the list
   * 
   * @author croesch
   * @since Date: 16.01.2011 13:04:35
   * @param i the index of the shop
   * @return the shop on that index
   */
  public Shop getShopForIndex(int i) {
    return this.model.get(i);
  }

  /**
   * Returns the number of available shops
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:07:38
   * @return the number of shops that are available
   */
  public int getShopCount() {
    return this.model.getShopCount();
  }

  void createPurchase(String name, String postCode, String location) {
    this.model.addShop(new Shop(name, postCode, location));
  }

  void save(String name, String postCode, String location) {
    this.model.set(this.editIndex, new Shop(name, postCode, location));
  }

  /**
   * Opens the window for creating a {@link Shop}
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:08:25
   */
  public void newShop() {
    this.view.newShop();
  }

  /**
   * Opens the window to edit the available {@link Shop}s
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:08:58
   */
  public void editShops() {
    if (this.editIndex >= 0) {
      this.view.editShop(this.editIndex + 1, this.model.get(this.editIndex));
    } else {
      LogManager.log(Messages.LOG_NOSHOPSTOEDIT.text());
    }
  }

  void decrementEditingShop() {
    --this.editIndex;
    editShops();
  }

  void incrementEditingShop() {
    ++this.editIndex;
    editShops();
  }
}
