import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class NV {
    private String maNV;
    private String hoTen;
    private LocalDate ngayVaoLam;
    private double luongKhoiDiem;
    private String cachTra;

    // Constructor
    public NV(String maNV, String hoTen, LocalDate ngayVaoLam, double luongKhoiDiem, String cachTra) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongKhoiDiem = luongKhoiDiem;
        this.cachTra = cachTra;
    }

    // Getter and Setter methods
    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    public double getLuongKhoiDiem() {
        return luongKhoiDiem;
    }

    public String getCachTra() {
        return cachTra;
    }

    public static HashMap<String, NV> nhapNV() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, NV> dsNV = new HashMap<>();
        while (true) {
            System.out.println("Nhập mã nhân viên (hoặc nhập '#' để kết thúc): ");
            String maNV = scanner.nextLine();
            if (maNV.equals("#")) break;

            System.out.println("Nhập họ tên nhân viên: ");
            String hoTen = scanner.nextLine();

            LocalDate ngayVaoLam = null;
            while (true) {
                try {
                    System.out.println("Nhập ngày vào làm (yyyy-mm-dd): ");
                    ngayVaoLam = LocalDate.parse(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Ngày không hợp lệ, vui lòng nhập lại!");
                }
            }

            double luongKhoiDiem = 0;
            while (true) {
                try {
                    System.out.println("Nhập lương khởi điểm: ");
                    luongKhoiDiem = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Lương không hợp lệ, vui lòng nhập lại!");
                }
            }

            String cachTra = "";
            while (true) {
                System.out.println("Nhập cách trả lương (duan/ngay): ");
                cachTra = scanner.nextLine();
                if (cachTra.equals("duan") || cachTra.equals("ngay")) break;
                else System.out.println("Cách trả không hợp lệ, vui lòng nhập lại!");
            }

            NV nv = new NV(maNV, hoTen, ngayVaoLam, luongKhoiDiem, cachTra);
            dsNV.put(maNV, nv);
        }
        return dsNV;
    }
}
