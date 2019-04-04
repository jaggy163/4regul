package HandlersCall;

public class Handler {
    private String kks, iec104, comment;
    private int modulNum, cnNum, index;

    public Handler() {
    }

    public Handler(String kks, String iec104, String comment, int modulNum, int cnNum, int index) {
        this.kks = kks;
        this.iec104 = iec104;
        this.comment = comment;
        this.modulNum = modulNum;
        this.cnNum = cnNum;
        this.index = index;
    }

    public String getKks() {
        return kks;
    }

    public void setKks(String kks) {
        this.kks = kks;
    }

    public String getIec104() {
        return kks + "_104";
    }

    public String getComment() {
        return comment;
    }

    public String getClearComment() {
        String result = comment;
        result = result.replaceAll("\"", "");
        return result;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getModulNum() {
        return modulNum;
    }

    public void setModulNum(int modulNum) {
        this.modulNum = modulNum;
    }

    public int getCnNum() {
        return cnNum;
    }

    public void setCnNum(int cnNum) {
        this.cnNum = cnNum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Handler{" +
                "kks='" + kks + '\'' +
                ", iec104='" + getIec104() + '\'' +
                ", comment='" + comment + '\'' +
                ", modulNum=" + modulNum +
                ", cnNum=" + cnNum +
                ", index=" + index +
                "}\n";
    }
}
