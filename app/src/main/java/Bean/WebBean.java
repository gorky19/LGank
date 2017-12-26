package Bean;

import java.util.List;

/**
 * Created by ZhangTAO on 2017/12/18.
 */

public class WebBean {

    /**
     * error : false
     * results : [{"_id":"5a2e4b55421aa90fef203596","createdAt":"2017-12-11T17:09:41.797Z","desc":"前端每周清单第 43 期：2017 JavaScript 回顾、Rust 与 WebAssembly 开发游戏、Node.js 架构模式","publishedAt":"2017-12-15T08:59:11.361Z","source":"web","type":"前端","url":"https://zhuanlan.zhihu.com/p/31911981","used":true,"who":"王下邀月熊(Chevalier)"},{"_id":"5a27faaf421aa90fef20358a","createdAt":"2017-12-06T22:11:59.321Z","desc":"一只技术amazui实现的vue.js组件库","publishedAt":"2017-12-11T08:43:39.682Z","source":"web","type":"前端","url":"https://github.com/sunshineJi/amaze-vue","used":true,"who":"Xuecong"},{"_id":"5a289ff8421aa90fe50c0264","createdAt":"2017-12-07T09:57:12.869Z","desc":"fish-ui 一套基于vue2的桌面ui组件库，css借鉴semantic-ui","images":["http://img.gank.io/3fcd4763-30c7-4802-adcd-d546783a0d61"],"publishedAt":"2017-12-11T08:43:39.682Z","source":"web","type":"前端","url":"https://github.com/myliang/fish-ui","used":true,"who":"myliang"},{"_id":"5a2108c6421aa90fef203576","createdAt":"2017-12-01T15:46:14.719Z","desc":"從 CLI 操作 GitHub 得到公開的檔案網址","publishedAt":"2017-12-06T08:49:34.303Z","source":"web","type":"前端","url":"https://github.com/xxhomey19/github-uploader","used":true,"who":"Homer Chen"},{"_id":"5a2338af421aa90fe2f02ca8","createdAt":"2017-12-03T07:35:11.654Z","desc":"Node.js 粘包处理框架-升级版(带TCP通信demo)","publishedAt":"2017-12-06T08:49:34.303Z","source":"web","type":"前端","url":"https://cnodejs.org/topic/5a22bfbc8eab6ee92a694618","used":true,"who":"FlyAway"},{"_id":"5a251ba9421aa90fe725368c","createdAt":"2017-12-04T17:55:53.827Z","desc":"前端每周清单第 42 期：V8 的执行流与优化， Pinterest 的 PWA 实践， Rust 与 WebAssembly 应用","publishedAt":"2017-12-05T08:48:31.384Z","source":"web","type":"前端","url":"https://zhuanlan.zhihu.com/p/31684599","used":true,"who":"王下邀月熊(Chevalier)"},{"_id":"5a17904a421aa90fef20355d","createdAt":"2017-11-24T11:21:46.56Z","desc":" 💻 A modern CLI to get your favorite news. 📰 ","images":["http://img.gank.io/98b8e726-5f5f-450c-9368-6067488f1676"],"publishedAt":"2017-11-30T13:11:10.665Z","source":"web","type":"前端","url":"https://github.com/kpman/newsroom","used":true,"who":"Daniel Tseng"},{"_id":"5a1d250c421aa90fe50c0244","createdAt":"2017-11-28T16:57:48.285Z","desc":"Vue-Access-Control是一套基于Vue/Vue-Router/axios 实现的前端用户权限控制解决方案，通过对路由、视图、请求三个层面的控制，使开发者可以实现任意颗粒度的用户权限控制。","publishedAt":"2017-11-30T13:11:10.665Z","source":"web","type":"前端","url":"http://refined-x.com/2017/11/28/Vue2.0%E7%94%A8%E6%88%B7%E6%9D%83%E9%99%90%E6%8E%A7%E5%88%B6%E8%A7%A3%E5%86%B3%E6%96%B9%E6%A1%88/","used":true,"who":"zangtao"},{"_id":"5a1e1ec7421aa90fef203570","createdAt":"2017-11-29T10:43:19.438Z","desc":"第一本 PWA 中文书","images":["http://img.gank.io/0af00bb4-3868-40e3-801e-54e8c2ba40be"],"publishedAt":"2017-11-30T13:11:10.665Z","source":"web","type":"前端","url":"https://github.com/SangKa/PWA-Book-CN","used":true,"who":"Zhou Cong"},{"_id":"5a13bc32421aa90fe2f02c77","createdAt":"2017-11-21T13:40:02.220Z","desc":"從 CLI 分析網站技術小工具","images":["http://img.gank.io/2ac5d7c2-bbc8-4893-a5c0-4ca210d85b93"],"publishedAt":"2017-11-24T11:08:03.624Z","source":"web","type":"前端","url":"https://github.com/WeiChiaChang/stacks-cli","used":true,"who":"WesleyChang"}]
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
         * _id : 5a2e4b55421aa90fef203596
         * createdAt : 2017-12-11T17:09:41.797Z
         * desc : 前端每周清单第 43 期：2017 JavaScript 回顾、Rust 与 WebAssembly 开发游戏、Node.js 架构模式
         * publishedAt : 2017-12-15T08:59:11.361Z
         * source : web
         * type : 前端
         * url : https://zhuanlan.zhihu.com/p/31911981
         * used : true
         * who : 王下邀月熊(Chevalier)
         * images : ["http://img.gank.io/3fcd4763-30c7-4802-adcd-d546783a0d61"]
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
