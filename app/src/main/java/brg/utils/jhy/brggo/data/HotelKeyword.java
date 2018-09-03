package brg.utils.jhy.brggo.data;

/**
 * Created by hayoung on 2018. 8. 31..
 * gkduduu@naver.com
 */
//각 OTA검색시 들어갈 키워드
public class HotelKeyword {
    String official;
    String kayak;
    String trivago;
    String combine;
    String getaroom;

    public HotelKeyword(String[] keywords) {
        setOfficial(keywords[0]);
        setKayak(keywords[1]);
        setTrivago(keywords[2]);
        setCombine(keywords[3]);
        setGetaroom(keywords[4]);
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public String getKayak() {
        return kayak;
    }

    public void setKayak(String kayak) {
        this.kayak = kayak;
    }

    public String getTrivago() {
        return trivago;
    }

    public void setTrivago(String trivago) {
        this.trivago = trivago;
    }

    public String getCombine() {
        return combine;
    }

    public void setCombine(String combine) {
        this.combine = combine;
    }

    public String getGetaroom() {
        return getaroom;
    }

    public void setGetaroom(String getaroom) {
        this.getaroom = getaroom;
    }


}
