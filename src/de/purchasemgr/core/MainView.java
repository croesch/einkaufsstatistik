package de.purchasemgr.core;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import de.crhcomponents.components.CButton;
import de.purchasemgr.ActionPool;
import de.purchasemgr.Main;
import de.purchasemgr.gui.Window;
import de.purchasemgr.i18n.Messages;

/**
 * Contains the view that is visible when the program starts.
 * 
 * @author croesch
 * @since Date: 16.01.2011 16:25:44
 */
public class MainView {

  /** the controller of this view. */
  private final MainController controller;

  /** the main frame of this view */
  private final Window mainWindow;

  /** the frame to show information about the program */
  private final Window aboutWindow;

  /** the width of this view */
  private static final int WIDTH = 400;

  /** the height of this view */
  private static final int HEIGHT = 400;

  /**
   * Constructs the view for the main program
   * 
   * @author croesch
   * @since Date: 16.01.2011 16:32:42
   * @param c the controller for the main program
   */
  public MainView(final MainController c) {
    this.controller = c;

    this.mainWindow = createMainWindow();
    this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.aboutWindow = createAboutWindow();
  }

  /**
   * Displays the main frame of this view / program
   * 
   * @author croesch
   * @since Date: 06.02.2011 14:49:10
   */
  final void displayMainWindow() {
    this.mainWindow.setVisible(true);
  }

  /**
   * Displays the about frame
   * 
   * @author croesch
   * @since Date: 06.02.2011 14:49:46
   */
  final void displayAboutWindow() {
    this.aboutWindow.setVisible(true);
  }

  /**
   * Creates the main frame and its components
   * 
   * @author croesch
   * @since Date: 06.02.2011 14:50:21
   * @return the created frame
   */
  @SuppressWarnings("nls")
  private Window createMainWindow() {

    final JPanel contentPanel = new JPanel();
    final JPanel buttonsPanel = new JPanel();
    contentPanel.setLayout(new MigLayout("", "[grow][]", "[grow]"));
    buttonsPanel.setLayout(new MigLayout());

    //Buttons
    CButton newPurch = new CButton(ActionPool.NEW_PURCHASE.getAction());
    CButton editPurch = new CButton(ActionPool.EDIT_PURCHASE.getAction());
    CButton deletePurch = new CButton(ActionPool.DEL_PURCHASE.getAction());

    buttonsPanel.add(newPurch, "cell 0 0,sg");
    buttonsPanel.add(editPurch, "cell 0 1,sg");
    buttonsPanel.add(deletePurch, "cell 0 2,sg");

    contentPanel.add(this.controller.getPurchaseList(), "cell 0 0, grow");
    contentPanel.add(buttonsPanel, "cell 1 0,alignx right,aligny center");

    Window.Builder b = new Window.Builder(WIDTH, HEIGHT);
    b = b.menuBar(new MainMenuBar()).title(Main.NAME).component(contentPanel);
    return b.build();
  }

  /**
   * Creates the about frame
   * 
   * @author croesch
   * @since Date: 06.02.2011 14:51:34
   * @return the created frame
   */
  private Window createAboutWindow() {
    final String descrAbout = Messages.PROGRAM_ABOUT_TEXT.text(Main.VERSION);
    final String titleAbout = Messages.PROGRAM_ABOUT_TITLE.text(Main.NAME);
    JLabel lab = new JLabel(descrAbout);

    final int width = 200;
    final int height = 100;

    Window.Builder b = new Window.Builder(width, height);
    b = b.title(titleAbout).component(lab);
    return b.build();
  }
}
