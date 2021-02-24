package sinhvien;

public class SinhVien {
    private String code;
    private String name;
    private String room;
    private String major;

    public SinhVien(){}

    public SinhVien(String code, String name, String room, String major) {
        this.code = code;
        this.name = name;
        this.room = room;
        this.major = major;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Mã sinh viên : "+ code + "\n"
                + "Tên : " + name + "\n"
                + "Lớp : " + room + "\n"
                + "Major : " + major;
    }
}
