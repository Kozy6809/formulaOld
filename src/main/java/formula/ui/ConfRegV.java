package formula.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import formula.*;
/**
 * 業務部での処方登録確認ビュー
 */
public class ConfRegV extends JFrame {
  private ConfRegC crc;
  private AbstractTableModel tm;
  private JScrollPane sp = null;
  private JTable table = null;
  /**
   * ConfRegV コンストラクター・コメント。
   */
  public ConfRegV(ConfRegC crc, AbstractTableModel tm) {
    super("業務部での登録の未確認品");
    this.crc = crc;
    this.tm = tm;
    init();
  }
  /**
   */
  private void init() {
    Container cp = getContentPane();
    JPanel p0, p1, p2, p3;
    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);
    JMenu m = new JMenu("ファイル(F)");
    m.setMnemonic('F');
    mb.add(m);
    JMenuItem mi = new JMenuItem("クリップボードへコピー(C)");
    mi.setMnemonic('C');
    mi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
	crc.copyToClip();
      }
    });
    m.add(mi);
    m = new JMenu("表示(V)");
    m.setMnemonic('V');
    mb.add(m);
    mi = new JMenuItem("最新表示に更新(U)");
    mi.setMnemonic('U');
    mi.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
	crc.load();
      }
    });
    m.add(mi);

    p0 = new JPanel(new BorderLayout());
    cp.add(p0, BorderLayout.CENTER);
    initTable();
    sp = new JScrollPane(table);
    p0.add(sp, BorderLayout.CENTER);
    p1 = new JPanel(new FlowLayout());
    p0.add(p1, BorderLayout.SOUTH);
    JButton b = new JButton("更新(U)");
    b.setMnemonic('U');
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
	crc.update();
      }
    });
    p1.add(b);
    b = new JButton("キャンセル(C)");
    b.setMnemonic('C');
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
	setVisible(false);
	crc.clearCheck();
      }
    });
    p1.add(b);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
	setVisible(false);
	crc.clearCheck();
      }
    });	
  }
  /**
   * このメソッドは VisualAge で作成されました。
   */
  private void initTable() {
    TableColumnModel tcm = new DefaultTableColumnModel();
    TableColumn tc = new TableColumn(0, 96);
    tc.setHeaderValue("確認済に変更");
    tcm.addColumn(tc);
    tc = new TableColumn(1, 80);
    tc.setHeaderValue("登録日");
    tcm.addColumn(tc);
    tc = new TableColumn(2, 256);
    tc.setHeaderValue("品名");
    tcm.addColumn(tc);
    tc = new TableColumn(3, 64);
    tc.setHeaderValue("登録者");
    tcm.addColumn(tc);
	
    table = new JTable(tm, tcm);
    table.setCellSelectionEnabled(true);
    table.setRowSelectionAllowed(false);
    table.setColumnSelectionAllowed(false);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setPreferredScrollableViewportSize(new Dimension(512, 64));
  }
}
