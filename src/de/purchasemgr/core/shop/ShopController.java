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
   * Returns the number of available shops
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:07:38
   * @return the number of shops that are available
   */
  public int getShopCount() {
    return this.model.getShopCount();
  }

  void createShop(String name, String postCode, String location) {
    this.model.addShop(new Shop(name, postCode, location));
    this.view.updateBox(this.model.getShops());
  }

  void save(String name, String postCode, String location) {
    Shop edited = this.model.get(this.editIndex);
    edited.setName(name);
    edited.setPostCode(postCode);
    edited.setLocation(location);
    this.model.set(this.editIndex, edited);
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

  /**
   * Returns the selected shop of the shop list
   * 
   * @author croesch
   * @since Date: 23.01.2011 14:56:20
   * @return the selected shop of the shop-box
   */
  public Shop getSelectedShop() {
    return this.model.get(this.view.getSelectedIndex());
  }
}
