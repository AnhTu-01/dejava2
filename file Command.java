import java.util.List;

interface Command {
    void execute();
}

class HienThiNVDuAnCmd implements Command {
    private List<NV> dsNV;

    public HienThiNVDuAnCmd(List<NV> dsNV) {
        this.dsNV = dsNV;
    }

    @Override
    public void execute() {
        for (NV nv : dsNV) {
            if (nv.getCachTra().equals("duan")) {
                System.out.println(nv.getHoTen() + " - " + nv.getMaNV());
            }
        }
    }
}

class HienThiNVSapXepLuongCmd implements Command {
    private List<NV> dsNV;

    public HienThiNVSapXepLuongCmd(List<NV> dsNV) {
        this.dsNV = dsNV;
    }

    @Override
    public void execute() {
        dsNV.stream()
            .sorted((nv1, nv2) -> Double.compare(nv1.getLuongKhoiDiem(), nv2.getLuongKhoiDiem()))
            .forEach(nv -> System.out.println(nv.getHoTen() + " - " + nv.getLuongKhoiDiem()));
    }
}

class XuLyLenh {
    public void xuLyLenh(String lenh, List<Command> commands) {
        switch (lenh) {
            case "1":
                commands.get(0).execute();
                break;
            case "2":
                commands.get(1).execute();
                break;
            default:
                System.out.println("Lệnh không hợp lệ");
                break;
        }
    }
}
