package KKS_Rename;

public class DataItem {
    private String name;
    private String descr;
    private int typeID, HighBound, LowBound, Scale, IoAdr, Cycle, DeadBand;
    private String mapVarName;

    public DataItem() {
    }

    public DataItem(DataItem x) {
        this.name = x.getName();
        this.descr = x.getDescr();
        this.typeID = x.getTypeID();
        HighBound = x.getHighBound();
        LowBound = x.getLowBound();
        Scale = x.getScale();
        IoAdr = x.getIoAdr();
        Cycle = x.getCycle();
        DeadBand = x.getDeadBand();
        this.mapVarName = x.getMapVarName();
    }

    public DataItem(String name, String descr, int typeID, int highBound, int lowBound, int scale,
                    int ioAdr, int cycle, int deadBand, String mapVarName) {
        this.name = name;
        this.descr = descr;
        this.typeID = typeID;
        HighBound = highBound;
        LowBound = lowBound;
        Scale = scale;
        IoAdr = ioAdr;
        Cycle = cycle;
        DeadBand = deadBand;
        this.mapVarName = mapVarName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getHighBound() {
        return HighBound;
    }

    public void setHighBound(int highBound) {
        HighBound = highBound;
    }

    public int getLowBound() {
        return LowBound;
    }

    public void setLowBound(int lowBound) {
        LowBound = lowBound;
    }

    public int getScale() {
        return Scale;
    }

    public void setScale(int scale) {
        Scale = scale;
    }

    public int getIoAdr() {
        return IoAdr;
    }

    public void setIoAdr(int ioAdr) {
        IoAdr = ioAdr;
    }

    public int getCycle() {
        return Cycle;
    }

    public void setCycle(int cycle) {
        Cycle = cycle;
    }

    public int getDeadBand() {
        return DeadBand;
    }

    public void setDeadBand(int deadBand) {
        DeadBand = deadBand;
    }

    public String getMapVarName() {
        return mapVarName;
    }

    public void setMapVarName(String mapVarName) {
        this.mapVarName = mapVarName;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", typeID=" + typeID +
                ", HighBound=" + HighBound +
                ", LowBound=" + LowBound +
                ", Scale=" + Scale +
                ", IoAdr=" + IoAdr +
                ", mapVarName='" + mapVarName +
                ", Cycle=" + Cycle +
                ", DeadBand=" + DeadBand +
                 '\'' +
                '}' + "\n";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
