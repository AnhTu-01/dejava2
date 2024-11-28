interface QuanSat {
    void capNhat(String maNV, NV nv);
}

class ThongBaoHR implements QuanSat {
    @Override
    public void capNhat(String maNV, NV nv) {
        if (nv.getCachTra().equals("ngay")) {
            System.out.println("Thông báo cho HR về nhân viên mới: " + nv.getHoTen());
        }
    }
}

class ThongBaoPM implements QuanSat {
    @Override
    public void capNhat(String maNV, NV nv) {
        if (nv.getCachTra().equals("duan")) {
            System.out.println("Thông báo cho PM về nhân viên mới: " + nv.getHoTen());
        }
    }
}
