package Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ZhangTAO on 2017/12/8.
 */
@Entity
public class LishiBean {
    @Id
    private Long cid;
    private String edittext;
    public String getEdittext() {
        return this.edittext;
    }
    public void setEdittext(String edittext) {
        this.edittext = edittext;
    }
    public Long getCid() {
        return this.cid;
    }
    public void setCid(Long cid) {
        this.cid = cid;
    }
    @Generated(hash = 1953421754)
    public LishiBean(Long cid, String edittext) {
        this.cid = cid;
        this.edittext = edittext;
    }
    @Generated(hash = 782686426)
    public LishiBean() {
    }
}
