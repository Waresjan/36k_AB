package lanou.a36k_ab.FlowLayout;

/**
 * Created by dllo on 16/10/15.
 */
public class FlowLayoutBean {
    String titlelun;
    String imagelin;

    public FlowLayoutBean(String titlelun, String imagelin) {
        this.titlelun = titlelun;
        this.imagelin = imagelin;
    }
    public FlowLayoutBean(){

    }

    public String getTitlelun() {
        return titlelun;
    }

    public void setTitlelun(String titlelun) {
        this.titlelun = titlelun;
    }

    public String getImagelin() {
        return imagelin;
    }

    public void setImagelin(String imagelin) {
        this.imagelin = imagelin;
    }
}
