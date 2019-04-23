package com.guinong.lib_utils;

/**
 * Created by wangyu on 2018/7/25 0025.
 */

public class Constants {

    public static final String TOKEN = "token";

    public static final String USERID = "userId";

    public static final String USER_PHONE = "phone";

    public static final String USER_NAME = "name";

    public static final String SEARCH_GOODS_NAME = "search_goods_name";

    public static final String CHAT_TOKEN = "chat_token";

    public static final String QQ_APP_ID = "1106158340";
    public static final String WX_APP_ID = "wx5e3f5b903e71e540";

    /*登录类型start*/
    public static final String CODE = "CODE";
    public static final String PASSWORD = "PASSWORD";
    public static final String OPEN_USER = "OPEN_USER";
    /*登录类型end*/

    public static final int UI_TYPE_HTWO = 1;
    public static final int UI_TYPE_GRID_FOUR = 2;
    public static final int UI_TYPE_FIVE = 3;
    public static final int UI_TYPE_H_AVERAGE_TWO = 4;
    public static final int UI_TYPE_THREE = 5;
    public static final int UI_TYPE_BANNER = 6;
    public static final int UI_TYPE_GROUP = 7;
    public static final int UI_TYPE_GROUP_LIST = 8;

    public static final String LIKE_DISCOVER = "DISCOVER";   //发现喜欢
    public static final String LIKE_PRODUCT = "PRODUCT";   //商品喜欢
    public static final String LIKE_SHOP = "SHOP";   //店铺喜欢

    public static final String PV = "PV";   //人气
    public static final String PRICE = "PRICE";   //价格

    /*跳转类型*/
    public static final String PRODUCT = "PRODUCT";
    public static final String PRODUCT_CATEGORY = "PRODUCT_CATEGORY";
    public static final String ZERO_BUY = "ZERO_BUY";
    public static final String GROUP_BUY = "GROUP_BUY";
    public static final String GROUP_LIST = "GROUP_LIST";
    public static final String ACTIVITY = "ACTIVITY";
    public static final String SHOP = "SHOP";

    public static final String SHARE = "share";
    public static final String GROUP = "group";
    //正在进行的
    public static final String GROUP_DOING = "DOING";

    /**
     * 支付类型
     */
    public static final String PAY_NEW_ORDER = "newOrder";//新订单
    public static final String PAY_OLD_ORDER = "oldOrder";//旧订单

    public static final String PAY_ALI_PAY = "ALI_PAY";//支付宝
    public static final String PAY_WX_PAY = "WX_PAY";//微信


    /**
     * 进入我的订单某一项
     */
    public static final int ORDER_TYPE_ALL = 0;
    public static final int ORDER_TYPE_WAITPAY = 1;
    public static final int ORDER_TYPE_WAITSEND = 2;
    public static final int ORDER_TYPE_WAITCHARGE = 3;
    public static final int ORDER_TYPE_EVALUATION = 4;
    public static final int ORDER_TYPE_AFTERSALES = 5;

    /**
     * 订单状态
     */
    public static final String ORDER_STATE_ALL = "ALL"; // 全部订单
    public static final String ORDER_STATE_WAIT_PAY = "PLACE_ORDER"; // 待付款
    public static final String ORDER_STATE_WAIT_PAY_GROUP = "PLACE_ORDER"; // 开团待付款的状态
    public static final String ORDER_STATE_WAIT_SEND = "PAY_SUCCESS_NOT_SEND"; // 待发货
    public static final String ORDER_WAIT_GROUP = "WAIT_GROUP"; // 待成团
    public static final String ORDER_STATE_WAIT_CHARGE = "PAY_SUCCESS_SEND"; // 确认收货
    public static final String ORDER_STATE_CANCEL = "CANCEL"; // 已关闭 取消也可以
    public static final String ORDER_STATE_CLOSE = "CLOSE"; // 已关闭 取消也可以
    public static final String ORDER_STATE_DONE = "SUCCESS"; // 已完成
    public static final String ORDER_STATE_EVALUATION = "NOT_COMMENT"; // 未评价 和
    /**
     * 支付状态
     */
    public static final String APPLY = "APPLY";//申请
    public static final String ACCEPT = "ACCEPTED";//受理
    public static final String REJECT = "REJECTED";//拒绝
    public static final String PAY_NOT_SEND = "PAY_SUCCESS_NOT_SEND";//0元购 没有售后
    public static final String SUCCESS = "SUCCESS";//受理后，处理成功
    public static final String WAIT_LOGISTICS = "WAIT_LOGISTICS";//受理后,等待退货
    public static final String WAIT_CONFIRM_RECEIVE = "WAIT_CONFIRM_RECEIVE";//受理后,等待退货

    public static final String PHONE_TYPE = "RECHARGE";//话费订单
    public static final String ZERO_TYPE = "ZERO";//0元购订单
    public static final String ORDER_GROUP = "GROUP";//拼团商品


    public static final String GOODS_TYEP_ENABLE = "ENABLE";//正常
    /**
     * 乡筹商品状态
     */
    public static final String SELLING = "SELLING";//热销
    public static final String BOOKING = "BOOKING";//预售
    /**
     * 乡筹商品评论类型
     */
    public static final String PRODUCTS = "PRODUCT";//商品
    public static final String SHOPS = "SHOP";//商铺
    public static final String DISCOVER = "DISCOVER";//发现
    public static final String COMMENT = "COMMENT";//评论  这是评论评论的 乡筹中回复

    /**
     * 优惠券
     */
    public static final String ENABLE = "ENABLE";//可用
    public static final String DISABLE = "DISABLE";//不可用
    public static final String PLATFORM_TYPE = "PLATFORM";//平台
    public static final String SHOP_TYPE = "SHOP";//店铺
    public static final String COUPONS_NOT_USE = "NOT_USE";//未使用
    public static final String COUPONS_USE = "USED";//使用了的
    public static final String COUPONS_TIME_OUT = "TIME_OUT";//过期的

    public static final String GO_COUPON = "COUPON";//领券
    public static final String GO_SHOP = "SHOP_BUY";//去凑单


    /**
     * 乡筹 type
     */
    public static final String HOMERAISE = "HOMERAISE";//乡筹banner
    /**
     * 支付类型
     */
    public static String ENTER_PAY_TYPE_GOODS = "goods";//商品支付
    public static String ENTER_PAY_TYPE_GROUP = "goodsgroup";//拼团商品支付
    public static String ENTER_PAY_TYPE_COUNTRY = "goodscountry";//乡筹商品支付
    public static String ENTER_PAY_TYPE_GROUP_JOIN = "goodsgroup_join";//进入拼团支付

    public static String ENTER_PAY_TYPE_COUNTRY_GOODS = "countrygoods";//乡筹商品支付
    public static String ENTER_PAY_TYPE_PHONE = "phone";//电话费
    public static String ENTER_PAY_TYPE_ORDER = "order";//订单号支付 再次支付
    /**
     * 刷新类型
     */
    public static final int LOAD_TYPE_1 = 1; // 普通加载

    public static final int LOAD_TYPE_2 = 2; // 下拉刷新
    public static final int LOAD_TYPE_3 = 3; // 上拉加载
    public static final int LOAD_TYPE_4 = 4; // 刷新 初始化适配器 但是是透明的
    public static final int LOAD_TYPE_5 = 5; // s删除购物车数据 在请求导数据是再初始化

    /**
     * 拼团筛选
     */
    public static final String GROUP_TYPE_VIEW_NUM = "VIEW_NUM"; // 浏览次数
    public static final String GROUP_TYPE_CREATE_NUM = "CREATE_NUM"; // 开团数
    public static final String GROUP_SOLD_PRICE = "SOLD_PRICE"; // 团购售价
    /**
     * 订单评价
     */
    public static final String ORDER_UP = "UP"; // 人气
    public static final String ORDER_DOWN = "DOWN"; // 人气


    public static final String GOODS_TYPE_PV = "PV"; // 人气
    public static final String GOODS_TYPE_PRICE = "PRICE"; // 价格
    public static final String GOODS_TYPE_TIME = "TIME"; // 新品


    public static final String SHOP_CART_TYPE_CART = "cart"; // 购物车有数据加载推荐
    public static final String SHOP_CART__TYPE_NODATA = "nodata"; // 购物车没数据加载推荐
    public static final String SHOP_CART__TYPE_NOLOGIN = "noLogin"; // 购物车没登录加载推荐

    public static final String AREASHOP_RECOMMEND = "RECOMMEND"; // 推荐商品
    /**
     * 友盟统计 个人中心 By yangmbin
     */
    /**
     * =============start===============
     */
    public static final String EVENT_CANCEL_ORDER = "event_cancel_order"; // 点击取消订单按钮
    public static final String EVENT_CANCEL_ORDER_CONFIRM = "event_cancel_order_confirm"; // 点击取消订单确认按钮
    public static final String EVENT_ORDER_PAY = "event_order_pay"; // 点击订单中付款按钮
    public static final String EVENT_ORDER_REFUND = "event_order_refund"; // 点击申请退款按钮
    public static final String EVENT_ORDER_REFUND_SUBMIT = "event_order_refund_submit"; // 提交申请退款
    public static final String EVENT_ORDER_EXTEND_TIME = "event_order_extend_time"; // 点击延长收货
    public static final String EVENT_ORDER_CONFIRM = "event_order_confirm"; // 点击确认收货
    public static final String EVENT_ORDER_CONFIRM_SUBMIT = "event_order_confirm_submit"; // 确认收货确定按钮
    public static final String EVENT_ME_CENTER_COMMISSION = "event_me_center_commission"; // 点击个人中心我的奖励按钮
    public static final String EVENT_COMMISSION_SUBMIT = "event_commission_submit"; // 点击提取奖励按钮
    public static final String EVENT_COMMISSION_RULE = "event_commission_rule"; // 点击奖励规则按钮
    public static final String EVENT_INVITE_SPOKESMAN = "event_invite_spokesman"; // 邀请代言人点击分享按钮

    /**
     * =============end===============
     */
    public static final String home_1 = "home_1";//搜索_new
    public static final String home_2 = "home_2";//楼层banner_new
    public static final String home_3 = "home_3";//商品推荐_new
    public static final String home_4 = "home_4";//首页-0元购_new
    public static final String home_5 = "home_5";//首页-拼团_new
    public static final String home_6 = "home_6";//首页-特色馆_new
    public static final String home_7 = "home_7";//首页-分类_new
    public static final String home_8 = "home_8";//首页-充值_new
    public static final String goods_1 = "goods_1";//商品-详情_new
    public static final String goods_2 = "goods_2";//商品-评价_new
    public static final String goods_3 = "goods_3";//商品-购物车_new
    public static final String goods_4 = "goods_4";//商品-客服_new
    public static final String goods_5 = "goods_5";//商品-加入购物车_new
    public static final String goods_6 = "goods_6";//商品-立即购买_new
    public static final String goods_7 = "goods_7";//商品-商品规格_new
    public static final String goods_8 = "goods_8";//商品-查看全部评价_new
    public static final String goods_9 = "goods_9";//商品-进入店铺_new
    public static final String goods_10 = "goods_10";//分类-类目_new
    public static final String goods_11 = "goods_11";//分类商品列表-销量_new
    public static final String goods_12 = "goods_12";//分类商品列表-价格_new
    public static final String goods_13 = "goods_13";//分类商品列表-筛选项_new
    public static final String phone_1 = "phone_1";//话费充值_new
    public static final String phone_2 = "phone_2";//话费充值-立即充值_new
    public static final String phone_3 = "phone_3";//话费充值-返回_new
    public static final String center_1 = "center_1";//头像_new
    public static final String center_2 = "center_2";//全部订单_new
    public static final String center_3 = "center_3";//待付款_new
    public static final String center_4 = "center_4";//待发货_new
    public static final String center_5 = "center_5";//待收货_new
    public static final String center_6 = "center_6";//待评价_new
    public static final String center_7 = "center_7";//全部订单-返回_new
    public static final String center_8 = "center_8";//售后_new
    public static final String center_9 = "center_9";//设置_new
    public static final String center_10 = "center_10";//设置-关于我们_new
    public static final String center_11 = "center_11";//设置-给我们的意见和建议_new
    public static final String center_12 = "center_12";//设置-意见和建议-提交_new
    public static final String center_13 = "center_13";//头像-个人信息_new
    public static final String center_14 = "center_14";//收货地址列表_new
    public static final String center_15 = "center_15";//收货地址-添加新地址_new
    public static final String center_16 = "center_16";//添加新地址-下一步_new
    public static final String center_17 = "center_17";//添加新地址-返回_new
    public static final String center_18 = "center_18";//放弃填写收货地址-确定/取消_new
    public static final String center_19 = "center_19";//头像-退出当前账户_new
    public static final String center_20 = "center_20";//账户安全-绑定手机_new
    public static final String center_21 = "center_21";//账户安全-绑定手机-发送验证码_new
    public static final String center_22 = "center_22";//账户安全-绑定手机-返回_new
    public static final String shopcart_1 = "shopcart_1";//购物车-结算_new
    public static final String shopcart_2 = "shopcart_2";//购物车-返回_new
    public static final String login_1 = "login_1";//登录-账号登录_new
    public static final String login_2 = "login_2";//登录-手机号快速登录_new
    public static final String login_3 = "login_3";//登录-手机号快速登录-发送验证码_new
    public static final String login_4 = "login_4";//登录-微信登录_new
    public static final String login_5 = "login_5";//登录-QQ登录_new
    public static final String login_6 = "login_6";//登录-新浪登录_new
    public static final String login_7 = "login_7";//登录-注册_new
    public static final String login_8 = "login_8";//注册-返回_new
    public static final String login_9 = "login_9";//注册-发送验证码_new
    public static final String login_10 = "login_10";//   登录-找回密码_new
    public static final String login_11 = "login_11";//找回密码-返回_new
    public static final String login_12 = "login_12";//找回密码-发送验证码_new
    public static final String login_13 = "login_13";//找回密码-手机验证码-返回_new
    public static final String login_14 = "login_14";//找回密码-手机验证密码-重置_new
    public static final String buy_1 = "buy_1";//确认订单-返回_new
    public static final String buy_2 = "buy_2";//确认订单-提交订单_new
    public static final String buy_3 = "buy_3";//支付界面-关闭_new
    public static final String buy_4 = "buy_4";//支付界面-去支付_new
    public static final String buy_5 = "buy_5";//支付方式-支付宝-取消
    public static final String buy_6 = "buy_6";//支付方式-支付宝-打开
    public static final String buy_7 = "buy_7";//支付方式-支付宝-未付款返回_new
    public static final String buy_8 = "buy_8";//支付方式-微信-取消
    public static final String buy_9 = "buy_9";//支付方式-微信-打开_new
    public static final String buy_10 = "buy_10";//支付方式-微信-未付款_new
    public static final String buy_11 = "buy_44";//绑定银行卡-下一步_new
    public static final String buy_12 = "buy_12";//绑定银行卡-返回_new
    public static final String buy_13 = "buy_13";//绑定银行卡-开通快捷支付_new
    public static final String buy_14 = "buy_14";//放弃支付-是/否_new
    public static final String buy_15 = "buy_15";//放弃支付-是/否_new
    public static final String buy_16 = "buy_16";//	放弃支付-是_new
    public static final String buy_17 = "buy_17";//放弃支付-否_new
    public static final String country_1 = "country_1";//乡筹主页-分享_new
    public static final String country_2 = "country_2";//商品-详情_new
    public static final String country_3 = "country_3";//商品-评价_new
    public static final String country_4 = "country_4";//商品-购买数量_new
    public static final String country_5 = "country_5";//商品-我要支持_new
    public static final String country_6 = "country_6";//商品-评价-点赞_new
    public static final String country_7 = "country_7";//商品-评价-发表评论_new
    public static final String country_8 = "country_8";//商品-评价-回复评论_new
    public static final String country_9 = "country_9";//商品-评价详情_new
    public static final String country_10 = "country_10";//商品-客服_new
    public static final String country_11 = "country_11";//商品-分享_new
    public static final String country_12 = "country_12";//商品-返回_new
    public static final String find_1 = "find_1";//发现-动态_new
    public static final String find_2 = "find_2";//发现-视频_new
    public static final String find_3 = "find_3";//发现-贵农之星_new
    public static final String find_4 = "find_4";//发现-发帖（卖家）_new
    public static final String find_5 = "find_5";//发现-动态-进入店铺_new
    public static final String find_6 = "find_6";//发现-动态-帖子详情_new
    public static final String find_7 = "find_7";//发现-动态-分享帖子_new
    public static final String find_8 = "find_8";//发现-动态-评论_new
    public static final String find_9 = "find_9";//发现-动态-点赞_new
    public static final String find_10 = "find_10";//发现-动态-推荐商品_new
    public static final String find_11 = "find_11";//发现-视频-进入店铺_new
    public static final String find_12 = "find_12";//发现-视频-观看视频_new
    public static final String find_13 = "find_13";//发现-视频-分享视频贴_new
    public static final String find_14 = "find_14";//发现-视频-评论_new
    public static final String find_15 = "find_15";//发现-视频-点赞_new
    public static final String find_16 = "find_16";//发现-贵农之星-进入店铺_new
    public static final String find_17 = "find_17";//贵农之星-店铺-返回_new
    public static final String find_18 = "find_18";//贵农之星-店铺-商品_new
    public static final String area_1 = "area_1";//地方馆-搜索_new
    public static final String area_2 = "area_2";//地方馆主页-分享_new
    public static final String area_3 = "area_3";//地方馆-场馆_new
    public static final String area_4 = "area_4";//场馆-分享_new
    public static final String area_5 = "area_5";//场馆-简介_new
    public static final String area_6 = "area_6";//场馆-商品_new
    public static final String area_7 = "area_7";//场馆-风物_new
    public static final String area_8 = "area_8";//场馆-商品-立即查看_new
    public static final String area_9 = "area_9";//场馆-风物-文章_new
    public static final String group_1 = "group_1";//拼团-活动分享_new
    public static final String group_2 = "group_2";//拼团-立即查看_new
    public static final String group_3 = "group_3";//拼团商品-查看更多团信息_new
    public static final String group_4 = "group_4";//拼团商品-详情_new
    public static final String group_5 = "group_5";//拼团商品-评价_new
    public static final String group_6 = "group_6";//拼团-自己开团_new
    public static final String group_7 = "group_7";//拼团-立即参团_new
    public static final String group_8 = "group_8";//拼团-单独购买_new
    public static final String group_9 = "group_9";//拼团商品-分享_new
    public static final String group_10 = "group_10";//拼团商品-返回_new
    public static final String feer_1 = "feer_1";//0元购-活动规则_new
    public static final String feer_2 = "feer_2";//0元购-全部0元购_new
    public static final String feer_3 = "feer_3";//0元购-我的砍价_new
    public static final String feer_4 = "feer_4";//全部0元购-我要购_new
    public static final String feer_5 = "feer_5";//全部0元购-砍价中_new
    public static final String feer_6 = "feer_6";//全部0元购-查看订单_new
    public static final String feer_7 = "feer_7";//我的砍价-请好友帮忙（分享）_new
    public static final String feer_8 = "feer_8";//我的砍价-重砍一次_new


    public static String[] images = new String[]{
            "http://himg2.huanqiu.com/attachment2010/2017/1102/20171102070437102.jpg"
            , "https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=f4eda2c00a3b5bb5aada28ac57babe5c/a2cc7cd98d1001e9e5d8b764b10e7bec55e797f1.jpg"
            , "https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=c6b4fc9adeca7bcb6976cf7ddf600006/6d81800a19d8bc3e058fc3938b8ba61ea9d345e0.jpg",
            "http://imgmini.eastday.com/pushimg/20171117/1510874297604232.jpg",
            "https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=99fd5adf6e061d95694b3f6a1a9d61b4/0b46f21fbe096b63c6d87db70c338744eaf8ac17.jpg",
            "http://images.china.cn/attachement/jpg/site1000/20161208/d02788e9b28a19b2e80924.jpg",
            "http://upload.cankaoxiaoxi.com/2017/0601/1496319083789.jpg"
            , "http://upload.cankaoxiaoxi.com/2017/0712/1499848728394.jpg", "http://imgmini.eastday.com/pushimg/20171117/1510874299537788.jpg"
            , "http://img5.pcpop.com/ArticleImages/730x547/3/3651/003651969.jpg"
            , "http://a.hiphotos.baidu.com/image/pic/item/e850352ac65c10384bfac6d1be119313b07e8918.jpg",
            "https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=f0334a2c43540923be646b2cf331ba6c/f703738da9773912ce99316ef2198618367ae206.jpg",
            "https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=4c5ed0afe7dde711f3df4ba4c686a57e/d01373f082025aaf3d331e61f9edab64034f1a12.jpg"
            , "http://himg2.huanqiu.com/attachment2010/2017/1102/20171102070437820.jpg"
            , "http://imgmini.eastday.com/pushimg/20171117/1510874297650928.jpg"
            , "http://img.mp.itc.cn/upload/20170523/4ea90c1526ca44b0a6ad54dc838aef02_th.jpg"
            , "http://c.hiphotos.baidu.com/image/pic/item/962bd40735fae6cd09ccfb7903b30f2442a70fa9.jpg"
    };
    public static String[] strins = new String[]{
            "爱的时候不辜负人  玩的时候不辜负风景 睡觉的时候不辜负床 一个人时不辜负自己 "
            , "食物会过期  幸福也会过期 "
            , "别把最好的留在最后"
            , "忙就是心和亡的组合  忙着忙着心就死了 "
            , "为什么我点的东西还没有到  你点了什么东西  我们的未来"
            , "你跑的快不  我追你"
            , "你知道什么糖最甜吗 什么糖  我和你的喜糖"
            , "想问你个路  什么路 去你心里的路"
            , "你今天有点怪怪的 怪可爱的  "
            , "你累不累呀 天天在我脑子里跑啊跑"
            , "活的越来越不像自己  像你老婆"
            , " 你活成了多少人喜欢的样子 "
            , "我爱你 像春风走了8千里  不问归期"
            , "爱不一定需要回报 但一定需要回应"
            , "想要遇到更好的人 或许首先要做的是努力成为根号的自己"
            , "她其实并不是很忙  只是不够爱你罢了  而是不会去爱你罢了",
            "真正能放下的人 不会花精力解释过去 而是面向当下 乐活现在",
            " 包容过去的情缘和关系 一场情缘 应该好心珍惜 怀着感恩说再见",
            "对待生命你不妨大胆冒险一点 因为好歹你要失去她 如果这世界上真有奇迹 那只是努力的另一个名字  生命中最难的阶段不是没有人懂你 而是你不懂你自己 ",
            "不知道接下来会遇到什么样的人 但能肯定的是 无论对方是什么样的人 他同样也渴望着我优秀 从容 美好 所以我不需要花大把时间拿来幻想未来如何而应该吧所有的等待都用来武装自己 只是为了有一天遇到你时 能够理直气壮的说 我知道你很好 但是我也不差",
            "一样东西 如果你太想要 就会把它看得很大 甚至大到成了整个世界 ",
            "占据了你的全部心思 我的劝告是 最后无论你是否如愿以偿 都要及时从中跳出来",
            " 如实地看清它在整个世界中的真实位置 亦即它在无限时空中的微不足道这样 你得到了不会忘乎所以 没有得到也不会痛不欲生 ",
            "人生最大的失败 其实是不开心 没有结婚的人 痛苦与形单影只  有了孩子的 痛苦与婚姻平淡  ",
            " 得不到和已失去成为我梦大部分痛苦的来源 接纳和活在当下并不容易  但是如果没有担当 无法勇敢地面对 忧愁就会一直环绕着你",
    };

    public static final String QUICK_LOGIN = "QUICK_LOGIN";//登录注册一个
    public static final String QUICK_REGISTER = "QUICK_REGISTER";//注册一个
    public static final String LOGIN_SHOP_SHOPSTATUS_ENABLE = "ENABLE";//审核成功
    public static final String LOGIN_SHOP_SHOPSTATUS_CLOSED = "CLOSED";//打烊
    public static final String LOGIN_SHOP_SHOPSTATUS_REFUSE = "AUDIT_REFUSE";//审核拒绝
    public static final String LOGIN_SHOP_SHOPSTATUS_WAIT = "WAIT_AUDIT";//审核等待

    public static final String DASH_TYPE_EDIT = "dash_type_edit";//菜品编辑
    public static final String DASH_TYPE_UPDOWN = "dash_type_updown";//菜品上下架
    public static final String DASH_TYPE_DELETE = "dash_type_delete";//菜品删除
    public static final String DASH_TYPE_UP = "ENABLE";//菜品上架
    public static final String DASH_TYPE_DOWN = "DISABLE";//菜品下架

    public static final String TIME_START = "start";//开始时间
    public static final String TIME_END = "end";//结束时间


    public static final String ORDER_SUCCESS = "SUCCESS";//订单成功
    public static final String ORDER_CANCEL = "CANCEL";//订单取消

    //订单类型
    public static final String ORDER_WAITING_TAKE = "WAITING_TAKE";//待接单
    public static final String ORDER_WAITING_SEND = "WAITING_SEND";//待配送
    public static final String ORDER_WAITING_REFUND = "REFUND";//售后 退款
    public static final String ORDER_WAITING_HISTORY = "SUCCESS,CANCEL";//历史
    //退款类型
    public static final String ORDER_REBACK_SUCCESS = "SUCCESS";//同意退款
    public static final String ORDER_REBACK_REJECT = "REJECT";//拒绝退款//退款类型
    public static final String ORDER_REBACK_APPLYING = "APPLYING";//退款申请

    public static final String ORDER_REBACK_MANUAL = "MANUAL";//人工退款
    public static final String ORDER_REBACK_SYSTEM = "SYSTEM";//系统自动退款


}
