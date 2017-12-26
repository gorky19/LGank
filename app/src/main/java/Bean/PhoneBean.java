package Bean;

import java.util.List;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public class PhoneBean {

    /**
     * error : false
     * results : [{"_id":"5a0baf54421aa90fe50c0207","createdAt":"2017-11-15T11:07:00.679Z","desc":"史上最便捷的 JSON 模型解析","publishedAt":"2017-11-16T12:01:05.619Z","source":"web","type":"iOS","url":"https://github.com/CNKCQ/AlamofireCodable","used":true,"who":"CNKCQ"},{"_id":"5a0d0311421aa90fe2f02c5f","createdAt":"2017-11-16T11:16:33.514Z","desc":"Airbnb 放出了 Lottie iOS 版本动画库。","publishedAt":"2017-11-16T12:01:05.619Z","source":"chrome","type":"iOS","url":"https://github.com/airbnb/lottie-ios","used":true,"who":"代码家"},{"_id":"59fe94a1421aa90fe2f02c20","createdAt":"2017-11-05T12:33:37.641Z","desc":"惊，有这么一款好用的空气 APP，我竟然不知道","images":["http://img.gank.io/5a5212d2-bd3c-4642-9fb8-8342ec70ac66"],"publishedAt":"2017-11-14T10:43:36.180Z","source":"web","type":"iOS","url":"https://github.com/AKTeam/AirKnow","used":true,"who":"Super邦"},{"_id":"5a0a5627421aa90fe2f02c54","createdAt":"2017-11-14T10:34:15.180Z","desc":"Swift 实现类似 Facebook 加载时的背景框架效果。","images":["http://img.gank.io/e94b401e-abc5-4643-b7dc-051406beda51"],"publishedAt":"2017-11-14T10:43:36.180Z","source":"chrome","type":"iOS","url":"https://github.com/Juanpe/SkeletonView","used":true,"who":"代码家"},{"_id":"5a091a6c421aa90fe7253629","createdAt":"2017-11-13T12:07:08.438Z","desc":"类似 iOS 本身的 Pull Up 控制器效果。","images":["http://img.gank.io/e28303d0-e4af-461a-b1e2-2405f81658db"],"publishedAt":"2017-11-13T12:10:58.643Z","source":"chrome","type":"iOS","url":"https://github.com/MarioIannotta/PullUpController","used":true,"who":"代码家"},{"_id":"5a091abd421aa90fe50c01fa","createdAt":"2017-11-13T12:08:29.438Z","desc":"可以制作 emoji 人脸动画的 App，跟官方的效果一样","images":["http://img.gank.io/dc574021-8029-4e4f-afe7-c26fde301e84"],"publishedAt":"2017-11-13T12:10:58.643Z","source":"chrome","type":"iOS","url":"https://github.com/insidegui/AnimojiStudio","used":true,"who":"代码家"},{"_id":"5a0010ce421aa90fe2f02c2b","createdAt":"2017-11-06T15:35:42.778Z","desc":"在实际项目中经常会遇到因方法调用频繁而导致的 UI 闪动问题和性能问题，这时用某种策略需要控制调用频率，以达到节流和防抖的效果。MessageThrottle 是我实现的一个 Objective-C 消息节流和防抖的轻量级工具库，使用便捷且业务无关。","images":["http://img.gank.io/1e0ec318-2d54-4967-beb8-2d894206feec"],"publishedAt":"2017-11-10T08:10:02.838Z","source":"web","type":"iOS","url":"http://yulingtianxia.com/blog/2017/11/05/Objective-C-Message-Throttle-and-Debounce/","used":true,"who":"杨萧玉"},{"_id":"5a026ff4421aa90fe725360b","createdAt":"2017-11-08T10:46:12.345Z","desc":"利用苹果的 AvatarKit 实现的表情移植功能。","images":["http://img.gank.io/c4c8915e-8e9d-446d-b2a1-8da6a3a62051"],"publishedAt":"2017-11-08T11:00:50.559Z","source":"chrome","type":"iOS","url":"https://github.com/simonbs/SBSAnimoji","used":true,"who":"代码家"},{"_id":"5a02723f421aa90fe725360d","createdAt":"2017-11-08T10:55:59.312Z","desc":"优化 Swift 编译时间。","images":["http://img.gank.io/365b4d67-6291-415f-ba38-30900f22b8ba"],"publishedAt":"2017-11-08T11:00:50.559Z","source":"chrome","type":"iOS","url":"https://github.com/fastred/Optimizing-Swift-Build-Times","used":true,"who":"代码家"},{"_id":"59fe7efb421aa90fef2034fc","createdAt":"2017-11-05T11:01:15.42Z","desc":"GitMan：基于Git的网盘式文件同步工具","images":["http://img.gank.io/1197cac6-34c2-4105-a473-c988d34e6574"],"publishedAt":"2017-11-06T12:40:39.976Z","source":"web","type":"iOS","url":"https://github.com/amoblin/gitman","used":true,"who":null}]
     */

    private boolean error;
    private List<ResultsBean> results;

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
         * _id : 5a0baf54421aa90fe50c0207
         * createdAt : 2017-11-15T11:07:00.679Z
         * desc : 史上最便捷的 JSON 模型解析
         * publishedAt : 2017-11-16T12:01:05.619Z
         * source : web
         * type : iOS
         * url : https://github.com/CNKCQ/AlamofireCodable
         * used : true
         * who : CNKCQ
         * images : ["http://img.gank.io/5a5212d2-bd3c-4642-9fb8-8342ec70ac66"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    ", images=" + images +
                    '}';
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
