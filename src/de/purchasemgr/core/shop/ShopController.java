package de.purchasemgr.core.shop;

import javax.swing.JComboBox;

import de.purchasemgr.data.type.Shop;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.logging.LogManager;

/**
 * This is the shop controller, it controls all things that have to do with
 * {@link Shop}s
 * 
 * @author croesch
 * @since Date: 16.01.2011 12:47:28
 */
public class ShopController {

  /** the model of this controller */
  private final ShopModel model = new ShopModel();

  /** the view of this controller */
  private final ShopView view = new ShopView(this);

  /** the index of the shop to edit */
  private int editIndex = 0;

  /**
   * Returns a combobox that contains all available shops
   * 
   * @author croesch
   * @since Date: 16.01.2011 12:51:13
   * @return a {@link JComboBox} that contains all {@link Shop}s available
   */
  public final JComboBox getShopBox() {
    return this.view.getBox(this.model.getShops());
  }

  /**
   * Returns the number of available shops
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:07:38
   * @return the number of shops that are available
   */
  public final int getShopCount() {
    return this.model.getShopCount();
  }

  /**
   * Performs the storage of a new shop
   * 
   * @author croesch
   * @since Date: 06.02.2011 19:56:34
   * @param n the name of the new shop
   * @param pc the post code of the new shop
   * @param loc the location of the new shop
   */
  final void createShop(final String n, final String pc, final String loc) {
    this.model.addShop(new Shop(n, pc, loc));
    this.view.updateBox(this.model.getShops());
  }

  /**
   * Performs the update of the edited shop
   * 
   * @author croesch
   * @since Date: 06.02.2011 19:57:37
   * @param n the new name for the shop
   * @param pc the new post code for the shop
   * @param loc the new location for the shop
   */
  final void save(final String n, final String pc, final String loc) {
    Shop edited = this.model.get(this.editIndex);
    edited.setName(n);
    edited.setPostCode(pc);
    edited.setLocation(loc);
    this.model.set(this.editIndex, edited);
  }

  /**
   * Opens the window for creating a {@link Shop}
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:08:25
   */
  public final void newShop() {
    this.view.newShop();
  }

  /**
   * Opens the window to edit the available {@link Shop}s
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:08:58
   */
  public final void editShops() {
    if (this.editIndex >= 0) {
      this.view.editShop(this.editIndex + 1, this.model.get(this.editIndex));
    } else {
      LogManager.log(Messages.LOG_NOSHOPSTOEDIT.text());
    }
  }

  /**
   * Changes the current editing shop to the one before the current one
   * 
   * @author croesch
   * @since Date: 06.02.2011 19:59:50
   * @see #incrementEditingShop()
   */
  final void decrementEditingShop() {
    --this.editIndex;
    editShops();
  }

  /**
   * Changes the current editing shop to the one after the current one
   * 
   * @author croesch
   * @since Date: 06.02.2011 20:00:37
   * @see #decrementEditingShop()
   */
  final void incrementEditingShop() {
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
  public final Shop getSelectedShop() {
    return this.model.get(this.view.getSelectedIndex());
  }
}
