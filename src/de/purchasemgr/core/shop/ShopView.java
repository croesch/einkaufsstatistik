package de.purchasemgr.core.shop;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.crhcomponents.components.CButton;
import de.purchasemgr.ActionPool;
import de.purchasemgr.data.type.Shop;
import de.purchasemgr.gui.Window;
import de.purchasemgr.i18n.Messages;
import de.purchasemgr.i18n.Strings;

/**
 * TODO Comment here ...
 * 
 * @author croesch
 * @since Date: 16.01.2011 12:47:38
 */
class ShopView {

  private final ShopController controller;

  private JComboBox shopBox;

  private final JTextField shopName = new JTextField();

  private final JTextField shopPostCode = new JTextField();

  private final JTextField shopLocation = new JTextField();

  private final JTextField newShopNameField = new JTextField();

  private final JTextField newShopPostCodeField = new JTextField();

  private final JTextField newShopLocationField = new JTextField();

  private final JLabel newShopNumber = new JLabel();

  private static JLabel shopIndexLabel = new JLabel();

  private final Window newShop, editShop;

  public ShopView(ShopController cont) {
    this.controller = cont;
    this.newShop = createNewShopFrame();
    this.editShop = createEditShopFrame();

    initBox();
  }

  private void initBox() {
  //TODO
  }

  private Window createNewShopFrame() {
    JPanel pan = new JPanel();

    CButton createShopBtn = new CButton(ActionPool.NEW_SHOP_OK.getAction());
    CButton stopCreatingShopBtn = new CButton(ActionPool.NEW_SHOP_CANCEL.getAction());

    final JLabel newShopNameLbl = new JLabel(Messages.SHOP_NAME.text());
    final JLabel newShopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());
    final JLabel newShopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());
    final JLabel newShopLabel = new JLabel(Messages.SHOP_NEW_INDEX.text());

    pan.add(newShopLabel);
    pan.add(this.newShopNumber);
    pan.add(newShopNameLbl);
    pan.add(this.newShopNameField);
    pan.add(newShopPostCodeLbl);
    pan.add(this.newShopPostCodeField);
    pan.add(newShopLocationLbl);
    pan.add(this.newShopLocationField);
    pan.add(createShopBtn);
    pan.add(stopCreatingShopBtn);

    return new Window(pan, 400, 300, null, Messages.SHOP_NEW.text());
  }

  private Window createEditShopFrame() {
    JPanel pan = new JPanel();

    final JLabel shopIndexDescLbl = new JLabel(Messages.SHOP_EDIT_INDEX.text());
    final JLabel shopNameLbl = new JLabel(Messages.SHOP_NAME.text());
    final JLabel shopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());
    final JLabel shopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());
    CButton cancelShopBtn = new CButton(ActionPool.EDIT_SHOPS_CAN.getAction());
    CButton prevShopBtn = new CButton(ActionPool.EDIT_SHOPS_PRE.getAction());
    CButton nextShopBtn = new CButton(ActionPool.EDIT_SHOPS_NXT.getAction());
    CButton applyShopBtn = new CButton(ActionPool.EDIT_SHOPS_SAV.getAction());

    pan.add(shopIndexDescLbl);
    pan.add(shopIndexLabel);
    pan.add(shopNameLbl);
    pan.add(this.shopName);
    pan.add(shopPostCodeLbl);
    pan.add(this.shopPostCode);
    pan.add(shopLocationLbl);
    pan.add(this.shopLocation);
    pan.add(prevShopBtn);
    pan.add(nextShopBtn);
    pan.add(applyShopBtn);
    pan.add(cancelShopBtn);

    return new Window(pan, 400, 300, null, Messages.SHOP_EDIT.text());
  }

  void editShop(int ind, Shop index) {
    shopIndexLabel.setText(Messages.SHOP_EDIT_INDEX_VALUE.text(String.valueOf((ind + 1)), String
      .valueOf(this.controller.getShopCount())));
    if (ind >= this.controller.getShopCount() - 1) {
      ActionPool.EDIT_SHOPS_NXT.getAction().setEnabled(false);
    } else {
      ActionPool.EDIT_SHOPS_NXT.getAction().setEnabled(true);
    }
    if (ind <= 0) {
      ActionPool.EDIT_SHOPS_PRE.getAction().setEnabled(false);
    } else {
      ActionPool.EDIT_SHOPS_PRE.getAction().setEnabled(true);
    }

    this.shopName.setText(index.getName());
    this.shopPostCode.setText(index.getPostCode());
    this.shopLocation.setText(index.getLocation());

    this.editShop.repaint();
    this.editShop.setVisible(true);
  }

  void newShop() {
    //#################### ==> new shop <== ####################
    this.newShopNumber
      .setText(Messages.SHOP_NEW_INDEX_VALUE.text(String.valueOf((this.controller.getShopCount() + 1))));

    this.newShopNameField.setText(Strings.EMPTY_STRING.text());
    this.newShopPostCodeField.setText(Strings.EMPTY_STRING.text());
    this.newShopLocationField.setText(Strings.EMPTY_STRING.text());

    this.newShop.repaint();
    this.newShop.setVisible(true);

  }
}
