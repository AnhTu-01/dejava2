import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Nhập danh sách nhân viên
        HashMap<String, NV> dsNV = NV.nhapNV();

        // Khởi tạo QLNV
        QLNV qlnv = QLNV.getInstance();
        qlnv.setDsNV(dsNV);

        // Thêm observer
        qlnv.themQuanSat(new ThongBaoHR());
        qlnv.themQuanSat(new ThongBaoPM());

        // Thêm nhân viên mới
        qlnv.themNhanVien(new NV("NV001", "Nguyen A", LocalDate.of(2023, 1, 1), 10000, "duan"));
        qlnv.themNhanVien(new NV("NV002", "Nguyen B", LocalDate.of(2023, 2, 1), 8000, "ngay"));

        // Sử dụng Command pattern
        List<Command> commands = new ArrayList<>();
        commands.add(new HienThiNVDuAnCmd(new ArrayList<>(qlnv.getDsNV().values())));
        commands.add(new HienThiNVSapXepLuongCmd(new ArrayList<>(qlnv.getDsNV().values())));

        XuLyLenh xuLyLenh = new XuLyLenh();
        xuLyLenh.xuLyLenh("1", commands); // Hiển thị nhân viên theo dự án
        xuLyLenh.xuLyLenh("2", commands); // Hiển thị nhân viên theo lương
    }
}
