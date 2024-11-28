import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class QLNV {
    private static QLNV instance;
    private HashMap<String, NV> dsNV;
    private List<QuanSat> dsQS;

    private QLNV() {
        dsNV = new HashMap<>();
        dsQS = new ArrayList<>();
    }

    public static QLNV getInstance() {
        if (instance == null) {
            instance = new QLNV();
        }
        return instance;
    }

    public void setDsNV(HashMap<String, NV> dsNV) {
        this.dsNV = dsNV;
    }

    public HashMap<String, NV> getDsNV() {
        return dsNV;
    }

    public void themNhanVien(NV nv) {
        dsNV.put(nv.getMaNV(), nv);
        for (QuanSat quanSat : dsQS) {
            quanSat.capNhat(nv.getMaNV(), nv);
        }
    }

    public void themQuanSat(QuanSat quanSat) {
        dsQS.add(quanSat);
    }
}
