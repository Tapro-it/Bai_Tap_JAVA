import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class QuanLyQuanCafe extends JFrame {
    JFrame f = new JFrame("Thông tin đồ uống");

    JLabel lblName = new JLabel("Tên đồ uống");
    JTextField tfName = new JTextField(30);

    JLabel lblPrice = new JLabel("Giá bán (VNĐ)");
    JTextField tfPrice = new JTextField(100000);

    JLabel lblType = new JLabel("Loại đồ uống");
    JComboBox<String> cbType;

    JLabel lblSize = new JLabel("Kích cỡ");
    JComboBox<String> cbSize;

    JLabel lblMT =new JLabel("Mô tả chi tiết (nếu có)");
    JTextField tfMT = new JTextField(300);

    JButton btnSubmit = new JButton("Gửi");

    Connection conn;
    Statement stm;

    QuanLyQuanCafe(){
        f.setLocation(300, 300);
        f.setSize(500, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(11, 1, 5, 5));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        mainPanel.add(lblName);
        JPanel pnlName = new JPanel(new GridLayout(1, 2, 10, 0));
        pnlName.add(tfName);
        mainPanel.add(pnlName);

        mainPanel.add(lblPrice);
        JPanel pnlPrice = new JPanel(new GridLayout(1, 2, 10, 0));
        pnlPrice.add(tfPrice);
        mainPanel.add(pnlPrice);

        mainPanel.add(lblType);
        JPanel pnlType = new JPanel(new GridLayout(1, 2, 10, 0));
        String[] type = {"Chọn loại đồ uống","Cafe", "Soda", "Trà", "Nước giải khát", "Sinh tố", "Nước ép"};
        cbType = new JComboBox<>(type);
        mainPanel.add(cbType);

        mainPanel.add(lblSize);
        JPanel pnlSize = new JPanel(new GridLayout(1, 2, 10, 0));
        String[] size = {"Chọn kích cỡ đồ uống", "Nhỏ(S)", "Vừa(M)", "Lớn(L)"};
        cbSize = new JComboBox<>(size);
        mainPanel.add(cbSize);

        mainPanel.add(lblMT);
        JPanel pnlMT = new JPanel(new GridLayout(1, 2, 10, 0));
        pnlMT.add(tfMT);
        mainPanel.add(pnlMT);

        mainPanel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydangnhap", "root", "tranvanta008");
                    stm = conn.createStatement();

                    String name = tfName.getText();

                    String price = tfPrice.getText();

                    String type = cbType.getSelectedItem().toString();

                    String size = cbSize.getSelectedItem().toString();

                    String mota = tfMT.getText();

                    String sql = "INSERT INTO quannuoc (ten, gia, loai, kichco, mota) VALUES ('" + name + "', '" + price + "', '" + type + "', '" + price + "', '" + mota +"')";
                    int record = stm.executeUpdate(sql);
                    if (record > 0){
                        JOptionPane.showMessageDialog(null, "Đã lưu thành công vào MySQL!");
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });
        f.add(mainPanel);
        f.setVisible(true);
    }

    static void main() {
        QuanLyQuanCafe qlcf = new QuanLyQuanCafe();
    }
}
