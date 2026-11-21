import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class QuanLySinhVien {
    JFrame f = new JFrame("Thông tin sinh viên");

    JLabel lblMaSV = new JLabel("Mã Sinh Viên");
    JTextField tfMaSV = new JTextField(7);

    JLabel lblTenSV = new JLabel("Tên sinh viên");
    JTextField tfTenSV = new JTextField(50);

    JLabel lblNgaySinh = new JLabel("Ngày sinh");
    JComboBox<String> cbDay;
    JComboBox<String> cbMonth;
    JComboBox<String> cbYear;

    JLabel lblGioitinh = new JLabel("Giới tính");
    JComboBox<String> cbGioiTinh;

    JLabel lblNNH = new JLabel("Năm nhập học");
    JComboBox<String> cbNNH;

    JLabel lblQueQuan = new JLabel("Quê quán");
    JTextField tfQueQuan = new JTextField(50);

    JLabel lblKhoa = new JLabel("Khoa");
    JComboBox<String> cbKhoa;

    JLabel lblLop = new JLabel("Lớp sinh hoạt");
    JTextField tfLop = new JTextField(10);

    JButton btnSubmit = new JButton("Gửi thông tin");

    Connection conn;
    Statement stm;

    QuanLySinhVien(){
        f.setLocation(300, 300);
        f.setSize(700, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(17, 1, 5, 5));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        mainPanel.add(lblMaSV);
        JPanel pnlMaSV =new JPanel(new GridLayout(1, 1, 10, 0));
        pnlMaSV.add(tfMaSV);
        mainPanel.add(pnlMaSV);

        mainPanel.add(lblTenSV);
        JPanel pnlTenSV = new JPanel(new GridLayout(1, 1, 10, 0));
        pnlTenSV.add(tfTenSV);
        mainPanel.add(pnlTenSV);

        mainPanel.add(lblNgaySinh);
        JPanel pnlNgaySinh = new JPanel(new GridLayout(1, 3, 10, 0));

        String[] days = new String[31];
        days[0] = "Day";
        for (int i = 1; i <= 30; i++){
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
        for (int i = 1; i <= 77; i++){
            years[i] = String.valueOf(2026 - i);
        }
        cbYear = new JComboBox<>(years);

        pnlNgaySinh.add(cbDay);
        pnlNgaySinh.add(cbMonth);
        pnlNgaySinh.add(cbYear);
        mainPanel.add(pnlNgaySinh);

        mainPanel.add(lblGioitinh);
        JPanel pnlGioiTinh = new JPanel(new GridLayout(1, 1, 10, 0));
        String[] gioitinh = {"Nam", "Nữ", "Khác"};
        cbGioiTinh = new JComboBox<>(gioitinh);
        pnlGioiTinh.add(cbGioiTinh);
        mainPanel.add(pnlGioiTinh);

        mainPanel.add(lblNNH);
        JPanel pnlNNH = new JPanel(new GridLayout(1, 1, 10, 0));
        String[] nnh = new String[78];
        nnh[0] = "Năm nhập học";
        for (int i = 1; i <= 77; i++){
            nnh[i] = String.valueOf(2027 - i);
        }
        cbNNH = new JComboBox<>(nnh);
        pnlNNH.add(cbNNH);
        mainPanel.add(pnlNNH);

        mainPanel.add(lblQueQuan);
        JPanel pnlQueQuan = new JPanel(new GridLayout(1, 1, 10, 0));
        pnlQueQuan.add(tfQueQuan);
        mainPanel.add(pnlQueQuan);

        mainPanel.add(lblKhoa);
        JPanel pnlKhoa = new JPanel(new GridLayout(1, 1, 10, 0));
        String[] khoa = {"Khoa", "Thể chất", "Khoa học máy tính", "Khoa học dữ liệu", "AI", "kinh tế"};
        cbKhoa = new JComboBox<>(khoa);
        mainPanel.add(cbKhoa);

        mainPanel.add(lblLop);
        JPanel pnlLop = new JPanel(new GridLayout(1, 1, 10, 0));
        pnlLop.add(tfLop);
        mainPanel.add(pnlLop);

        mainPanel.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlydangnhap", "root", "tranvanta008");
                    stm = conn.createStatement();

                    String masv = tfMaSV.getText();

                    String tensv = tfTenSV.getText();

                    String ngaysinh = cbDay.getSelectedItem() + "/" + cbMonth.getSelectedItem() + "/" + cbYear.getSelectedItem();

                    String gioitinh = cbGioiTinh.getSelectedItem().toString();

                    String nnh = cbNNH.getSelectedItem().toString();

                    String quequan = tfQueQuan.getText();

                    String khoa = cbKhoa.getSelectedItem().toString();

                    String lop = tfLop.getText();

                    String sql = "INSERT INTO sinhvien (masv, tensv, ngaysinh, gioitinh, namnhaphoc, quequan,  khoa, lop) VALUES ('" + masv + "', '" + tensv + "', '" + ngaysinh + "', '" + gioitinh + "', '" + nnh + "', '" + quequan + "', '" + khoa + "', '" + lop + "')";
                    int record = stm.executeUpdate(sql);
                    if (record > 0){
                        JOptionPane.showMessageDialog(null, "Đã lưu thành công vào MySQL!");
                    }
                    }catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
                }
            }
        });
        f.add(mainPanel);
        f.setVisible(true);
    }

    static void main() {
        QuanLySinhVien qlsv = new QuanLySinhVien();
    }
}
