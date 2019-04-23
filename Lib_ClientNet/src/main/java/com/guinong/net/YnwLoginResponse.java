package com.guinong.net;

import java.io.Serializable;

public class YnwLoginResponse implements Serializable {
    /**
     * body : {"nickname":"15208328757","account":"15208328757"}
     */
    private BodyBean body;

    public static class BodyBean implements Serializable {
        /**
         * nickname : 15208328757
         * account : 15208328757
         */

        private String nickname;
        private String account;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }
}
