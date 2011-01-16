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

  /**
   * Returns a combobox that contains all available shops
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:51:13
   * @return a {@link JComboBox} that contains all {@link Shop}s available
   */
  public JComboBox getShopBox() {
    //TODO implement this
    return null;
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
    //TODO implement this
    return null;
  }

  int getShopCount() {
    return this.model.getShopCount();
  }

  public void editShops() {
    int nr = getShopCount();
    if (nr > 0) {
      this.view.editShop(--nr, this.model.get(nr));
    } else {
      LogManager.log(Messages.LOG_NOSHOPSTOEDIT.text());
    }
  }

}
