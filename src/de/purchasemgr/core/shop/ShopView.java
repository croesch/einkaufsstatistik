package de.purchasemgr.core.shop;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
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

  private final JTextField shopName = new JTextField();

  private final JTextField shopPostCode = new JTextField();

  private final JTextField shopLocation = new JTextField();

  private final JTextField newShopNameField = new JTextField();

  private final JTextField newShopPostCodeField = new JTextField();

  private final JTextField newShopLocationField = new JTextField();

  private final JLabel newShopNumber = new JLabel();

  private final JLabel editShopNumber = new JLabel();

  private final Window editShopFrame, newShopFrame;

  private final JComboBox shopBox = new JComboBox();

  private ShopAction editNext, editPrevious;

  ShopView(ShopController cont) {
    this.controller = cont;
    this.editShopFrame = createEditShopFrame();
    this.newShopFrame = createNewShopFrame();
  }

  private Window createNewShopFrame() {
    JPanel pan = new JPanel();
    JPanel buttonPanel = new JPanel();
    pan.setLayout(new MigLayout(new LC(),
                                new AC().grow(100l, 2).fill(2),
                                new AC().count(6).grow(100l, 5)));
    buttonPanel.setLayout(new MigLayout());

    final JLabel newShopLabel = new JLabel(Messages.SHOP_NEW_INDEX.text());
    final JLabel newShopNameLbl = new JLabel(Messages.SHOP_NAME.text());
    final JLabel newShopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());
    final JLabel newShopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());

    CButton createShopBtn = new CButton(new ShopAction(ShopAction.NEW_SAVE));
    CButton stopCreatingShopBtn = new CButton(new ShopAction(ShopAction.NEW_CANCEL));

    buttonPanel.add(createShopBtn, new CC().cell(0, 0)
      .sizeGroup(Strings.EMPTY_STRING.text()));
    buttonPanel.add(stopCreatingShopBtn, new CC().cell(1, 0)
      .sizeGroup(Strings.EMPTY_STRING.text()));

    pan.add(newShopLabel, new CC().cell(0, 0));
    pan.add(this.newShopNumber, new CC().cell(2, 0));
    pan.add(newShopNameLbl, new CC().cell(0, 2));
    pan.add(this.newShopNameField, new CC().cell(2, 2));
    pan.add(newShopPostCodeLbl, new CC().cell(0, 3));
    pan.add(this.newShopPostCodeField, new CC().cell(2, 3));
    pan.add(newShopLocationLbl, new CC().cell(0, 4));
    pan.add(this.newShopLocationField, new CC().cell(2, 4));
    pan
      .add(buttonPanel, new CC().cell(0, 6, 3, 1).alignX(Strings.RIGHT.text()));

    Window.Builder b = new Window.Builder(400, 300);
    b = b.title(Messages.SHOP_NEW.text()).component(pan);
    return b.build();
  }

  Window getNewShopFrame() {
    return this.newShopFrame;
  }

  Window getEditShopFrame() {
    return this.editShopFrame;
  }

  private Window createEditShopFrame() {
    JPanel pan = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    pan.setLayout(new MigLayout(new LC(),
                                new AC().grow(100l, 2).fill(2),
                                new AC().count(7).grow(100l, 6)));
    navPanel.setLayout(new MigLayout());
    buttonPanel.setLayout(new MigLayout());

    this.editNext = new ShopAction(ShopAction.EDIT_NEXT);
    this.editPrevious = new ShopAction(ShopAction.EDIT_PREVIOUS);

    final JLabel shopIndexDescLbl = new JLabel(Messages.SHOP_EDIT_INDEX.text());
    final JLabel shopNameLbl = new JLabel(Messages.SHOP_NAME.text());
    final JLabel shopPostCodeLbl = new JLabel(Messages.SHOP_POSTCODE.text());
    final JLabel shopLocationLbl = new JLabel(Messages.SHOP_LOCATION.text());

    CButton prevShopBtn = new CButton(this.editPrevious);
    CButton nextShopBtn = new CButton(this.editNext);

    CButton applyShopBtn = new CButton(new ShopAction(ShopAction.EDIT_SAVE));
    CButton cancelShopBtn = new CButton(new ShopAction(ShopAction.EDIT_CANCEL));

    navPanel.add(prevShopBtn, new CC().cell(0, 0)
      .sizeGroup(Strings.EMPTY_STRING.text()));
    navPanel.add(nextShopBtn, new CC().cell(1, 0)
      .sizeGroup(Strings.EMPTY_STRING.text()));

    buttonPanel.add(applyShopBtn, new CC().cell(0, 0));
    buttonPanel.add(cancelShopBtn, new CC().cell(1, 0));

    pan.add(shopIndexDescLbl, new CC().cell(0, 0));
    pan.add(this.editShopNumber, new CC().cell(2, 0));
    pan.add(shopNameLbl, new CC().cell(0, 2));
    pan.add(this.shopName, new CC().cell(2, 2));
    pan.add(shopPostCodeLbl, new CC().cell(0, 3));
    pan.add(this.shopPostCode, new CC().cell(2, 3));
    pan.add(shopLocationLbl, new CC().cell(0, 4));
    pan.add(this.shopLocation, new CC().cell(2, 4));
    pan.add(navPanel, new CC().cell(0, 5, 3, 1));
    pan
      .add(buttonPanel, new CC().cell(0, 7, 3, 1).alignX(Strings.RIGHT.text()));

    Window.Builder b = new Window.Builder(400, 300);
    b = b.title(Messages.SHOP_EDIT.text()).component(pan);
    return b.build();
  }

  void editShop(int ind, Shop index) {
    this.editShopNumber.setText(Messages.SHOP_EDIT_INDEX_VALUE.text(String
      .valueOf(ind), String.valueOf(this.controller.getShopCount())));

    this.editNext.setEnabled(ind < this.controller.getShopCount());
    this.editPrevious.setEnabled(ind > 1);

    this.shopName.setText(index.getName());
    this.shopPostCode.setText(index.getPostCode());
    this.shopLocation.setText(index.getLocation());

    this.editShopFrame.repaint();
    this.editShopFrame.setVisible(true);
  }

  void newShop() {
    this.newShopNumber.setText(Messages.SHOP_NEW_INDEX_VALUE.text(String
      .valueOf((this.controller.getShopCount() + 1))));

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
    this.controller.createShop(name, postCode, location);
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
          throw new IllegalArgumentException(Messages.EXC_ILLARG.text(String
            .valueOf(id)));
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

  void updateBox(List<Shop> data) {
    this.shopBox.removeAllItems();
    this.shopBox.setModel(new DefaultComboBoxModel(data.toArray()));
  }

  JComboBox getBox(List<Shop> shops) {
    updateBox(shops);
    return this.shopBox;
  }

  int getSelectedIndex() {
    return this.shopBox.getSelectedIndex();
  }
}
