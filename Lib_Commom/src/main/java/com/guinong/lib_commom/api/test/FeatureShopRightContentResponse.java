package com.guinong.lib_commom.api.test;

import java.io.Serializable;
import java.util.List;

public class FeatureShopRightContentResponse implements Serializable {


    /**
     * total : 2
     * current : 0
     * list : [{"createTime":"2018-08-20 16:17:39","modifyTime":"2018-08-20 16:17:39","id":5,"name":"清镇馆","englishName":"QingZhen","data":{"front":"static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png","banner":["static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png","static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png"],"description":{"imgs":["static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg","static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg"],"text":"文本描述"}},"districtId":520181,"parentId":4},{"createTime":"2018-08-20 16:18:28","modifyTime":"2018-08-20 16:45:26","id":6,"name":"开阳馆","englishName":"KaiYang","data":{"front":"static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png","banner":["static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png","static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png"],"description":{"imgs":["static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg","static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg"],"text":"文本描述"}},"districtId":520121,"parentId":4}]
     */

    private int total;
    private int current;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable {
        /**
         * createTime : 2018-08-20 16:17:39
         * modifyTime : 2018-08-20 16:17:39
         * id : 5
         * name : 清镇馆
         * englishName : QingZhen
         * data : {"front":"static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png","banner":["static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png","static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png"],"description":{"imgs":["static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg","static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg"],"text":"文本描述"}}
         * districtId : 520181
         * parentId : 4
         */

        private String createTime;
        private String modifyTime;
        private int id;
        private String name;
        private String englishName;
        private DataBean data;
        private int districtId;
        private int parentId;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEnglishName() {
            return englishName;
        }

        public void setEnglishName(String englishName) {
            this.englishName = englishName;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public int getDistrictId() {
            return districtId;
        }

        public void setDistrictId(int districtId) {
            this.districtId = districtId;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public static class DataBean implements Serializable {
            /**
             * front : static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png
             * banner : ["static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png","static/201808/3b3ca1c0-9ea2-11e8-832b-a154ccb4ed47.png"]
             * description : {"imgs":["static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg","static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg"],"text":"文本描述"}
             */

            private String front;
            private DescriptionBean description;
            private List<String> banner;

            public String getFront() {
                return front;
            }

            public void setFront(String front) {
                this.front = front;
            }

            public DescriptionBean getDescription() {
                return description;
            }

            public void setDescription(DescriptionBean description) {
                this.description = description;
            }

            public List<String> getBanner() {
                return banner;
            }

            public void setBanner(List<String> banner) {
                this.banner = banner;
            }

            public static class DescriptionBean implements Serializable{
                /**
                 * imgs : ["static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg","static/201808/3a2dc150-a038-11e8-8b20-655e583bc716.jpg"]
                 * text : 文本描述
                 */

                private String text;
                private List<String> imgs;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public List<String> getImgs() {
                    return imgs;
                }

                public void setImgs(List<String> imgs) {
                    this.imgs = imgs;
                }
            }
        }
    }
}
