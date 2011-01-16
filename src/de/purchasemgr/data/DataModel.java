package de.purchasemgr.data;

import java.util.ArrayList;
import java.util.List;

import de.purchasemgr.data.type.Shop;
import de.purchasemgr.gui.GUIManager;

/**
 * TODO Comment here
 * 
 * @author croesch
 * @since Date: 2010/12/19 10:41:41
 */
public class DataModel {

  private final List<Shop> shops = new ArrayList<Shop>();

  private GUIManager gui;

  /**
   * @return a list of all shops that are available
   */
  public List<Shop> getShops() {
    return this.shops;
  }

  /**
   * changes one shop to the data stored in the fields
   * 
   * @param i the number of the shop to edit
   */
  public void editShops(int i) {
    String name = this.gui.getShopName();
    String postCode = this.gui.getShopPostCode();
    String location = this.gui.getShopLocation();
    this.shops.set(i, new Shop(name, postCode, location));
  }

  /**
   * creates a new shop with the data that will be read from the fields in the dialog to create a new shop
   */
  public void addShop() {
    String name = this.gui.getNewShopName();
    String postCode = this.gui.getNewShopPostCode();
    String location = this.gui.getNewShopLocation();
    this.shops.add(new Shop(name, postCode, location));
    this.gui.newShop.setVisible(false);
  }

  /**
   * stores the given GUI to the intern field
   * 
   * @param gui the new GUI the should be set
   */
  public void setGUI(GUIManager gui) {
    if (this.gui == null) {
      this.gui = gui;
    }
  }

}
