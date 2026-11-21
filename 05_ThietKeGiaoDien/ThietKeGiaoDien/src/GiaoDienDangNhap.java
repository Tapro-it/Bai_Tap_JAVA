import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class GiaoDienDangNhap {
    JFrame f = new JFrame("Register");

    JLabel lblUserName = new JLabel("Name");
    JTextField tfFistname = new JTextField(50);
    JTextField tfSurname = new JTextField(50);

    JLabel lblNgaySinh = new JLabel("Date of birth");
    JComboBox<String> cbDay;
    JComboBox<String> cbMonth;
    JComboBox<String> cbYear;

    JLabel lblGender = new JLabel("Gender");
    JComboBox<String> cbGender;

    JLabel lblMBoG = new JLabel("Mobile number or email address");
    JTextField tfMBoG;

    JLabel lblPassword = new JLabel("Password");
    JPasswordField tfPassword = new JPasswordField(20);

    JButton btnSubmit = new JButton("Submit");

    Connection conn;
    Statement stmt;

    public GiaoDienDangNhap() {
        f.setLocation(300, 300);
        f.setSize(600, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Khung chính chia 7 hàng dọc, 1 cột
        JPanel mainPanel = new JPanel(new GridLayout(11, 1, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // --- Hàng 1 & 2: Name (2 ô) ---
        mainPanel.add(lblUserName);

        JPanel pnlName = new JPanel(new GridLayout(1, 2, 10, 0));
        tfFistname = taoOChuaChuMo("First name");
        tfSurname = taoOChuaChuMo("Surname");
        pnlName.add(tfFistname);
        pnlName.add(tfSurname);
        mainPanel.add(pnlName);

        // --- Hàng 3 & 4: Date of birth (3 ô) ---
        mainPanel.add(lblNgaySinh);
        JPanel pnlDob = new JPanel(new GridLayout(1, 3, 10, 0));
        String[] days = new String[32];
        days[0] = "Day";
        for (int i = 1; i <= 31; i++) {
            days[i] = String.valueOf(i);
        }
        cbDay = new JComboBox<>(days);

        String[] months = new String[13];
        months[0] = "Month";
        for (int i = 1; i <= 12; i++){
            months[i] = String.valueOf(i);
        }
        cbMonth = new JComboBox<>(months);

        String[] years = new String[78];
        years[0] = "Year";
        for (int i = 0; i < 77; i++) {
            years[i + 1] = String.valueOf(2026 - i);
        }
        cbYear = new JComboBox<>(years);

        pnlDob.add(cbDay);
        pnlDob.add(cbMonth);
        pnlDob.add(cbYear);
        mainPanel.add(pnlDob);

        mainPanel.add(lblGender);
        JPanel pnlGender = new JPanel(new GridLayout(1, 1, 10, 0));
        String[] gender = {"Select your gender", "Male", "Female", "Other"};
        cbGender = new JComboBox<>(gender);
        pnlGender.add(cbGender);
        mainPanel.add(pnlGender);

        mainPanel.add(lblMBoG);
        JPanel pnlMBoG = new JPanel(new GridLayout(1, 1, 10, 0));
        tfMBoG = taoOChuaChuMo("NguyenVanA@gmail.com");
        pnlMBoG.add(tfMBoG);
        mainPanel.add(pnlMBoG);

        // --- Hàng 5 & 6: Password ---
        mainPanel.add(lblPassword);
        mainPanel.add(tfPassword);

        // --- Hàng 7: Nút Submit ---
        mainPanel.add(btnSubmit);

        // Xử lý sự kiện lưu vào MySQL khi bấm Submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydangnhap", "root", "tranvanta008");
                    stmt = conn.createStatement();

                    // Lấy dữ liệu từ các ô nhập
                    String fname = tfFistname.getText();
                    String sname = tfSurname.getText();

                    String dob = cbDay.getSelectedItem() + "-" + cbMonth.getSelectedItem() + "-" + cbYear.getSelectedItem();

                    String gender = cbGender.getSelectedItem().toString();
                    String mbog = tfMBoG.getText();

                    String pass = tfPassword.getText();

                    // Câu lệnh INSERT lưu toàn bộ vào MySQL
                    String sql = "INSERT INTO users (firstname, surname, dob, gender, mbog, password) VALUES ('" + fname + "', '" + sname + "', '" + dob + "', '" + gender + "', '" + mbog + "', '" + pass + "')";
                    int record = stmt.executeUpdate(sql);

                    if (record > 0) {
                        JOptionPane.showMessageDialog(null, "Đã lưu thành công vào MySQL!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });

        f.add(mainPanel);
        f.setVisible(true);
    }

    // Hàm tạo chữ mờ gợi ý cho First name và Surname
    private JTextField taoOChuaChuMo(String hint) {
        JTextField tf = new JTextField(hint);
        tf.setForeground(Color.GRAY);

        tf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf.getText().equals(hint)) {
                    tf.setText("");
                    tf.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf.getText().isEmpty()) {
                    tf.setText(hint);
                    tf.setForeground(Color.GRAY);
                }
            }
        });
        return tf;
    }

    public static void main(String[] args) {
        GiaoDienDangNhap gddn = new GiaoDienDangNhap();
    }
}
