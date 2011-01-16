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
