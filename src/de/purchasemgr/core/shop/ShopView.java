package de.purchasemgr.core.shop;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.crhcomponents.components.CButton;
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

  private final Window newShopFrame, editShopFrame;

  private ShopAction editNext, editPrevious;

  ShopView(ShopController cont) {
    this.controller = cont;
    this.newShopFrame = createNewShopFrame();
    this.editShopFrame = createEditShopFrame();

    initBox();
  }

  private void initBox() {
  //TODO
  }

  private Window createNewShopFrame() {
    JPanel pan = new JPanel();

    CButton createShopBtn = new CButton(new ShopAction(ShopAction.NEW_SAVE));
    CButton stopCreatingShopBtn = new CButton(new ShopAction(ShopAction.NEW_CANCEL));

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

  Window getNewShopFrame() {
    return this.newShopFrame;
  }

  Window getEditShopFrame() {
    return this.editShopFrame;
  }

  private Window createEditShopFrame() {
    JPanel pan = new JPanel();

    final JLabel shopIndexDescLbl = new JLabel(Messages.SHOP_EDIT_INDEX.text());
    final JLabel shopNameLbl = new JLabel(Messages.SHOP_NAME.text());
    final JLabel shopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());
    final JLabel shopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());
    this.editNext = new ShopAction(ShopAction.EDIT_NEXT);
    this.editPrevious = new ShopAction(ShopAction.EDIT_PREVIOUS);
    CButton cancelShopBtn = new CButton(new ShopAction(ShopAction.EDIT_CANCEL));
    CButton prevShopBtn = new CButton(this.editPrevious);
    CButton nextShopBtn = new CButton(this.editNext);
    CButton applyShopBtn = new CButton(new ShopAction(ShopAction.EDIT_SAVE));

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
    shopIndexLabel.setText(Messages.SHOP_EDIT_INDEX_VALUE.text(String.valueOf(ind), String.valueOf(this.controller
      .getShopCount())));

    this.editNext.setEnabled(ind < this.controller.getShopCount());
    this.editPrevious.setEnabled(ind > 1);

    this.shopName.setText(index.getName());
    this.shopPostCode.setText(index.getPostCode());
    this.shopLocation.setText(index.getLocation());

    this.editShopFrame.repaint();
    this.editShopFrame.setVisible(true);
  }

  void newShop() {
    this.newShopNumber
      .setText(Messages.SHOP_NEW_INDEX_VALUE.text(String.valueOf((this.controller.getShopCount() + 1))));

    this.newShopNameField.setText(Strings.EMPTY_STRING.text());
    this.newShopPostCodeField.setText(Strings.EMPTY_STRING.text());
    this.newShopLocationField.setText(Strings.EMPTY_STRING.text());

    this.newShopFrame.repaint();
    this.newShopFrame.setVisible(true);
  }

  void addShop() {
    String name = this.newShopNameField.getText();
    String postCode = this.newShopPostCodeField.getText();
    String location = this.newShopLocationField.getText();
    this.controller.createPurchase(name, postCode, location);
    this.newShopFrame.setVisible(false);
  }

  void saveShop() {
    String name = this.shopName.getText();
    String postCode = this.shopPostCode.getText();
    String location = this.shopLocation.getText();
    this.controller.save(name, postCode, location);
  }

  void changeEditingShop(boolean decrement) {
    saveShop();

    if (decrement) {
      this.controller.decrementEditingShop();
    } else {
      this.controller.incrementEditingShop();
    }
  }

  private class ShopAction extends AbstractAction {

    /** generated version UID */
    private static final long serialVersionUID = 1L;

    static final int NEW_CANCEL = 1;

    static final int NEW_SAVE = 2;

    static final int EDIT_NEXT = 3;

    static final int EDIT_PREVIOUS = 4;

    static final int EDIT_CANCEL = 5;

    static final int EDIT_SAVE = 6;

    private final int id;

    ShopAction(int id) {
      this.id = id;
      String name;
      switch (id) {
        case NEW_CANCEL:
          name = Messages.SHOP_NEW_CANCEL.text();
          break;
        case NEW_SAVE:
          name = Messages.SHOP_NEW_SAVE.text();
          break;
        case EDIT_NEXT:
          name = Messages.SHOP_EDIT_NEXT.text();
          break;
        case EDIT_PREVIOUS:
          name = Messages.SHOP_EDIT_PREV.text();
          break;
        case EDIT_CANCEL:
          name = Messages.SHOP_EDIT_CANC.text();
          break;
        case EDIT_SAVE:
          name = Messages.SHOP_EDIT_SAVE.text();
          break;
        default:
          throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String.valueOf(id)));
      }
      putValue(Action.NAME, name);
    }

    public void actionPerformed(ActionEvent e) {
      if (this.id == NEW_CANCEL) {
        ShopView.this.getNewShopFrame().setVisible(false);
      } else if (this.id == NEW_SAVE) {
        ShopView.this.addShop();
      } else if (this.id == EDIT_NEXT) {
        ShopView.this.changeEditingShop(false);
      } else if (this.id == EDIT_PREVIOUS) {
        ShopView.this.changeEditingShop(true);
      } else if (this.id == EDIT_CANCEL) {
        ShopView.this.getEditShopFrame().setVisible(false);
      } else if (this.id == EDIT_SAVE) {
        ShopView.this.saveShop();
        ShopView.this.getEditShopFrame().setVisible(false);
      } else {
        //TODO log error
      }
    }
  }
}
