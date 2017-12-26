package Bean;

import java.util.List;

/**
 * Created by ZhangTAO on 2017/12/20.
 */

public class SelectBean {

    /**
     * count : 10
     * error : false
     * results : [{"desc":"Android 代码热修复","ganhuo_id":"56cc6d23421aa95caa707993","publishedAt":"2015-11-12T13:46:23.459000","readability":"","type":"Android","url":"https://github.com/bunnyblue/DroidFix","who":"Dear宅学长"},{"desc":"美丽说热修复框架","ganhuo_id":"58ad46f2421aa93d376f7507","publishedAt":"2017-02-23T11:50:23.116000","readability":"","type":"Android","url":"https://github.com/meili/Aceso","who":"wuzheng"},{"desc":"一套新的 热修复 方案","ganhuo_id":"574b7cf56776592322c7d0b2","publishedAt":"2016-05-30T08:55:19.194000","readability":"","type":"Android","url":"https://github.com/dodola/RocooFix","who":"代码家"},{"desc":"Android App 线上热修复方案","ganhuo_id":"56cc6d23421aa95caa7079c2","publishedAt":"2015-11-19T03:57:22.169000","readability":"","type":"Android","url":"http://lirenlong.github.io/hotfix/","who":"MVP"},{"desc":"Android热修复实践应用--AndFix","ganhuo_id":"57c67e1e421aa9125fa3edc1","publishedAt":"2016-09-01T11:31:19.288000","readability":"","type":"Android","url":"http://www.jianshu.com/p/c36c9e0ca3fe","who":"郑铉"},{"desc":"论热修复实战心得\u2014很值得学习的热修复详解|强烈推荐","ganhuo_id":"5a0cfd99421aa90fe2f02c5e","publishedAt":"2017-11-16T12:01:05.619000","readability":"","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=100001255&idx=1&sn=6b1674c7578039b61b4c34825619c363&chksm=6b4769795c30e06fa1d02f89e7a3e230c2d9c5761b0256fd1ed33eee899803a95f574a144450#rd","who":"codeGoogler"},{"desc":"Android 热修复，没你想的那么难","ganhuo_id":"57308d9367765974f5e27ec8","publishedAt":"2016-05-10T12:14:26.447000","readability":"","type":"Android","url":"http://kymjs.com/code/2016/05/08/01","who":"张涛"},{"desc":"基于 InstantRun 实现的一个 Android 热修复方案","ganhuo_id":"57e082af421aa95bd05015e6","publishedAt":"2016-09-20T11:42:05.477000","readability":"","type":"Android","url":"https://github.com/dodola/AnoleFix","who":"代码家"},{"desc":"受微信热修复原理激发的Android热修复与增量升级框架，简单易用。","ganhuo_id":"57d2148b421aa90d3bea4a3f","publishedAt":"2016-09-09T11:53:48.777000","readability":"","type":"Android","url":"https://github.com/byteam/delta","who":"cey"},{"desc":" Android 热补丁动态修复框架小结","ganhuo_id":"56cc6d26421aa95caa707e62","publishedAt":"2015-11-17T04:00:01.757000","readability":"","type":"Android","url":"http://blog.csdn.net/lmj623565791/article/details/49883661","who":"MVP"}]
     */

    private int count;
    private boolean error;
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * desc : Android 代码热修复
         * ganhuo_id : 56cc6d23421aa95caa707993
         * publishedAt : 2015-11-12T13:46:23.459000
         * readability :
         * type : Android
         * url : https://github.com/bunnyblue/DroidFix
         * who : Dear宅学长
         */

        private String desc;
        private String ganhuo_id;
        private String publishedAt;
        private String readability;
        private String type;
        private String url;
        private String who;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getGanhuo_id() {
            return ganhuo_id;
        }

        public void setGanhuo_id(String ganhuo_id) {
            this.ganhuo_id = ganhuo_id;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getReadability() {
            return readability;
        }

        public void setReadability(String readability) {
            this.readability = readability;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
