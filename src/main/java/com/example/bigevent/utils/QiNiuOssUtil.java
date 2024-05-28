package com.example.bigevent.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author Fickler
 * @date 2024/5/28 17:04
 */
public class QiNiuOssUtil {

    private static final String ACCESS_KEY = "Rd9_uTE__306pysd4JNL_kieY-tS_OMNWo1QJkK_";
    private static final String SECRET_KEY = "KliAs6jsdVK2xYH7lSlErwR3iEujAs8BBGnk5Y2_";
    private static final String BUCKET = "fickler-typora";


    /**
     * 文件上传
     * @param uploadBytes 字节数组
     * @param fileName 文件名
     * @return 上传成功url
     */
    public static String uploadFile(byte[] uploadBytes, String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region0());      //选择服务器所在的区
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        try {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET);
            try {
                Response response = uploadManager.put(uploadBytes, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//                System.out.println(putRet.key);
//                System.out.println(putRet.hash);
                return "http://qiniu.fickler.top/" + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return null;
    }

}
