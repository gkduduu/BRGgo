package brg.utils.jhy.brggo.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by hayoung on 2018. 9. 6..
 * gkduduu@naver.com
 */
public class Hotels extends RealmObject {

    @PrimaryKey
    @Required
    private String NAME;
    @Required
    private String BRAND;
    @Required
    private String COUNTRY;
    @Required
    private String CITY;
    private String LINK_OFFICIAL;
    private String LINK_KAYAK;
    private String LINK_TRIVAGO;
    private String LINK_COMBINE;
    private String LINK_GETAROOM;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getBRAND() {
        return BRAND;
    }

    public void setBRAND(String BRAND) {
        this.BRAND = BRAND;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getLINK_OFFICIAL() {
        return LINK_OFFICIAL;
    }

    public void setLINK_OFFICIAL(String LINK_OFFICIAL) {
        this.LINK_OFFICIAL = LINK_OFFICIAL;
    }

    public String getLINK_KAYA() {
        return LINK_KAYAK;
    }

    public void setLINK_KAYAK(String LINK_KAYA) {
        this.LINK_KAYAK = LINK_KAYA;
    }

    public String getLINK_TRIVAGO() {
        return LINK_TRIVAGO;
    }

    public void setLINK_TRIVAGO(String LINK_TRIVAGO) {
        this.LINK_TRIVAGO = LINK_TRIVAGO;
    }

    public String getLINK_COMBINE() {
        return LINK_COMBINE;
    }

    public void setLINK_COMBINE(String LINK_COMBINE) {
        this.LINK_COMBINE = LINK_COMBINE;
    }

    public String getLINK_GETAROOM() {
        return LINK_GETAROOM;
    }

    public void setLINK_GETAROOM(String LINK_GETAROOM) {
        this.LINK_GETAROOM = LINK_GETAROOM;
    }
}
