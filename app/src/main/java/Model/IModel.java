package Model;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public interface IModel {
    void getDatas1(String baseurl,String types,int num,int pages);
    void getDatas2(String baseurl,String types,int num,int pages);
    void getDatas3(String baseurl,String types,int num,int pages);
    void getDatas4(String baseurl,String types,int num,int pages);
    void getDatas5(String baseurl,String keyname,int num,int pages);
}
