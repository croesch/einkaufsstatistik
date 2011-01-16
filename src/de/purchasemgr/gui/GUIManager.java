package de.purchasemgr.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import de.crhcomponents.components.CButton;
import de.crhcomponents.components.CMenu;
import de.crhcomponents.components.CMenuItem;
import de.purchasemgr.ActionPool;
import de.purchasemgr.Main;
import de.purchasemgr.MainAction;
import de.purchasemgr.data.DataModel;
import de.purchasemgr.i18n.KeyStrokes;
import de.purchasemgr.i18n.Messages;

/**
 * The manager for everything that has to do with GUI TODO change this and remove this central class
 * 
 * @author croesch
 * @since $Revision: 1.11 $ Date: 2010/12/19 12:56:24
 */
public class GUIManager {

  private final DataModel model;

  private static final int HSPACE = 20;

  private static final int VSPACE = 13;

  private final JComponent contentPanel = new JPanel();

  private final int width = 400, height = 400;

  private JScrollPane listScroller;

  private JButton newPurch, deletePurch, editPurch;

  private final JPanel buttons = new JPanel();

  //		private DataModel dataModel = new DataModel(this);
  static JLabel shopIndexLabel = new JLabel();

  private JButton createShopBtn, stopCreatingShopBtn;

  public int nr;

  int max;

  static Window ABOUT_FRAME;

  /** frame to edit the shops */
  public Window editShop;

  /** frame to add a new shop */
  public Window newShop;

  Window mainWindow;

  /**
   * show the about frame
   */
  public static void about() {
    final String descrAbout = Messages.PROGRAM_ABOUT_TEXT.text(Main.VERSION);
    final String titleAbout = Messages.PROGRAM_ABOUT_TITLE.text(Main.NAME);
    JLabel lab = new JLabel(descrAbout);
    if (ABOUT_FRAME == null) {
      ABOUT_FRAME = new Window(lab, 200, 100, null, titleAbout);
    }
    ABOUT_FRAME.setVisible(true);
  }

  private JMenuBar createMainMenuBar() {

    JMenuBar mb = new JMenuBar();
    JMenu menu, edit, stat, help, statPurchase, statExpenses;
    JMenuItem newFile, save, open, exit, items, shops, general;
    JMenuItem purchaseShop, purchaseWDay, purchaseMonth, purchaseYear, purchaseItems, expensesShop;
    JMenuItem expensesWDay, expensesMonth, expensesYear, expensesItems, options, about, version;
    @SuppressWarnings("hiding")
    JMenuItem newShop;

    menu = new CMenu(Messages.MB_MENU.text());
    edit = new CMenu(Messages.MB_EDIT.text());
    stat = new CMenu(Messages.MB_STAT.text());
    help = new CMenu(Messages.MB_HELP.text());
    statPurchase = new CMenu(Messages.MB_STAT_PURCHASE.text());
    statExpenses = new CMenu(Messages.MB_STAT_EXPENSES.text());

    // Menu - Items
    newFile = new CMenuItem(ActionPool.FILE_NEW.getAction());
    save = new CMenuItem(ActionPool.FILE_SAVE.getAction());
    open = new CMenuItem(ActionPool.FILE_OPEN.getAction());
    exit = new CMenuItem(ActionPool.EXIT.getAction());

    // Menu - Items - Keys
    newFile.setAccelerator(KeyStrokes.FILE_NEW.stroke());
    save.setAccelerator(KeyStrokes.FILE_SAVE.stroke());
    open.setAccelerator(KeyStrokes.FILE_OPEN.stroke());
    exit.setAccelerator(KeyStrokes.PROGRAM_EXIT.stroke());

    // Menu - add Items
    menu.add(newFile);
    menu.add(open);
    menu.addSeparator();
    menu.add(save);
    menu.addSeparator();
    menu.add(exit);

    //edit - Items
    items = new CMenuItem(ActionPool.EDIT_ITEMS.getAction());
    shops = new CMenuItem(ActionPool.EDIT_SHOPS.getAction());
    newShop = new CMenuItem(ActionPool.NEW_SHOP.getAction());

    //edit - items - keys
    items.setAccelerator(KeyStrokes.EDIT_ITEMS.stroke());
    newShop.setAccelerator(KeyStrokes.NEW_SHOP.stroke());
    shops.setAccelerator(KeyStrokes.EDIT_SHOPS.stroke());

    //edit - add items
    edit.add(items);
    edit.add(newShop);
    edit.add(shops);

    //statistic - expenses - items
    expensesItems = new CMenuItem(ActionPool.STAT_EXPENSES_ITEM.getAction());
    expensesShop = new CMenuItem(ActionPool.STAT_EXPENSES_SHOP.getAction());
    expensesWDay = new CMenuItem(ActionPool.STAT_EXPENSES_WDAY.getAction());
    expensesMonth = new CMenuItem(ActionPool.STAT_EXPENSES_MONT.getAction());
    expensesYear = new CMenuItem(ActionPool.STAT_EXPENSES_YEAR.getAction());

    //statistic - expenses - keys
    expensesItems.setAccelerator(KeyStrokes.STAT_EXPENSES_ITEM.stroke());
    expensesShop.setAccelerator(KeyStrokes.STAT_EXPENSES_SHOP.stroke());
    expensesWDay.setAccelerator(KeyStrokes.STAT_EXPENSES_WDAY.stroke());
    expensesMonth.setAccelerator(KeyStrokes.STAT_EXPENSES_MONT.stroke());
    expensesYear.setAccelerator(KeyStrokes.STAT_EXPENSES_YEAR.stroke());

    //statistic - expenses - add items
    statExpenses.add(expensesShop);
    statExpenses.add(expensesWDay);
    statExpenses.add(expensesMonth);
    statExpenses.add(expensesYear);
    statExpenses.add(expensesItems);

    //statistic - purchases - items
    purchaseItems = new CMenuItem(ActionPool.STAT_PURCHASE_ITEM.getAction());
    purchaseShop = new CMenuItem(ActionPool.STAT_PURCHASE_SHOP.getAction());
    purchaseWDay = new CMenuItem(ActionPool.STAT_PURCHASE_WDAY.getAction());
    purchaseMonth = new CMenuItem(ActionPool.STAT_PURCHASE_MONT.getAction());
    purchaseYear = new CMenuItem(ActionPool.STAT_PURCHASE_YEAR.getAction());

    //statistic - purchases - keys
    purchaseItems.setAccelerator(KeyStrokes.STAT_PURCHASE_ITEM.stroke());
    purchaseShop.setAccelerator(KeyStrokes.STAT_PURCHASE_SHOP.stroke());
    purchaseWDay.setAccelerator(KeyStrokes.STAT_PURCHASE_WDAY.stroke());
    purchaseMonth.setAccelerator(KeyStrokes.STAT_PURCHASE_MONT.stroke());
    purchaseYear.setAccelerator(KeyStrokes.STAT_PURCHASE_YEAR.stroke());

    //statistic - purchases - add items
    statPurchase.add(purchaseShop);
    statPurchase.add(purchaseWDay);
    statPurchase.add(purchaseMonth);
    statPurchase.add(purchaseYear);
    statPurchase.add(purchaseItems);

    //statistic - items
    general = new CMenuItem(ActionPool.STAT_GENERAL.getAction());

    //statistic - keys
    general.setAccelerator(KeyStrokes.STAT_GENERAL.stroke());

    //statistic - add items
    stat.add(general);
    stat.addSeparator();
    stat.add(statPurchase);
    stat.add(statExpenses);

    //help - items
    options = new CMenuItem(ActionPool.OPTIONS.getAction());
    version = new CMenuItem(ActionPool.VERSION_INFO.getAction());
    about = new CMenuItem(ActionPool.ABOUT.getAction());

    //help - keys
    options.setAccelerator(KeyStrokes.HELP_OPTIONS.stroke());
    version.setAccelerator(KeyStrokes.HELP_VERSION.stroke());
    about.setAccelerator(KeyStrokes.HELP_ABOUT.stroke());

    //help - add items
    help.add(options);
    help.addSeparator();
    help.add(version);
    help.addSeparator();
    help.add(about);

    mb.add(menu);
    mb.add(edit);
    mb.add(stat);
    mb.add(help);

    return mb;
  }

  private void initialize() {

    //Buttons
    this.newPurch = new CButton(ActionPool.NEW_PURCHASE.getAction());
    this.editPurch = new CButton(ActionPool.EDIT_PURCHASE.getAction());
    this.deletePurch = new CButton(ActionPool.DEL_PURCHASE.getAction());

    this.buttons.setLayout(new GridLayout(3, 1, 0, 10));

    this.buttons.add(this.newPurch);
    this.buttons.add(this.editPurch);
    this.buttons.add(this.deletePurch);

    this.contentPanel.add(this.listScroller);
    this.contentPanel.add(this.buttons);
  }

  public GUIManager(DataModel model) {
    MainAction.init(this);
    model.setGUI(this);
    this.model = model;
    initialize();
    this.mainWindow = new Window(this.contentPanel, this.width, this.height, createMainMenuBar(), Main.NAME);
    this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public DataModel getModel() {
    return this.model;
  }

  public void setVisible(boolean vis) {
    if (this.mainWindow != null) {
      this.mainWindow.setVisible(vis);
    }
  }
}
