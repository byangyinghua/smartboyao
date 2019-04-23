package com.guinong.lib_commom.api;

import com.google.gson.reflect.TypeToken;
import com.guinong.lib_commom.api.fresh.request.ApplyCashRequest;
import com.guinong.lib_commom.api.fresh.request.CashOutRequest;
import com.guinong.lib_commom.api.fresh.request.ClassDataRequest;
import com.guinong.lib_commom.api.fresh.request.ClassEditNameRequest;
import com.guinong.lib_commom.api.fresh.request.ClassSortRequest;
import com.guinong.lib_commom.api.fresh.request.CreateShopKeeperRequest;
import com.guinong.lib_commom.api.fresh.request.MyWalletDetailRequest;
import com.guinong.lib_commom.api.fresh.request.MyWalletRequest;
import com.guinong.lib_commom.api.fresh.request.OrdersDetailRequest;
import com.guinong.lib_commom.api.fresh.request.OrdersRequest;
import com.guinong.lib_commom.api.fresh.request.PhoneCodeRequest;
import com.guinong.lib_commom.api.fresh.request.PhoneRegisterRequest;
import com.guinong.lib_commom.api.fresh.request.PushTokenRequest;
import com.guinong.lib_commom.api.fresh.request.ReceiveOrdersRequest;
import com.guinong.lib_commom.api.fresh.request.RefuneBackRequest;
import com.guinong.lib_commom.api.fresh.request.SearchRequest;
import com.guinong.lib_commom.api.fresh.request.ShopStatusRequest;
import com.guinong.lib_commom.api.fresh.request.UpLoadDishDataRequest;
import com.guinong.lib_commom.api.fresh.request.UpdateBindALIRequest;
import com.guinong.lib_commom.api.fresh.request.UpdatePrinterUserRequest;
import com.guinong.lib_commom.api.fresh.request.UpdateShopPartRequest;
import com.guinong.lib_commom.api.fresh.request.UpdateShopStatusRequest;
import com.guinong.lib_commom.api.fresh.request.UpdateUserPhoneAddressRequest;
import com.guinong.lib_commom.api.fresh.request.UpdateUserRequest;
import com.guinong.lib_commom.api.fresh.request.VerifyCodeRequest;
import com.guinong.lib_commom.api.fresh.response.CashOutRespons;
import com.guinong.lib_commom.api.fresh.response.ClassDataResponse;
import com.guinong.lib_commom.api.fresh.response.LoginResponse;
import com.guinong.lib_commom.api.fresh.response.MyWalletDetailResponse;
import com.guinong.lib_commom.api.fresh.response.MyWalletResponse;
import com.guinong.lib_commom.api.fresh.response.OrdersDetailResponse;
import com.guinong.lib_commom.api.fresh.response.OrdersResponse;
import com.guinong.lib_commom.api.fresh.response.PhoneCodeResponse;
import com.guinong.lib_commom.api.fresh.response.PhoneRegisterResponse;
import com.guinong.lib_commom.api.fresh.response.PushTokenResponse;
import com.guinong.lib_commom.api.fresh.response.SearchResponse;
import com.guinong.lib_commom.api.fresh.response.ShopStatusResponse;
import com.guinong.lib_commom.api.fresh.response.UserDataResponse;
import com.guinong.net.print.PrintRequest;
import com.guinong.net.print.PrintResponse;
import com.guinong.lib_commom.api.test.DashEditRequest;
import com.guinong.lib_commom.api.test.FeatureRightContentRequest;
import com.guinong.lib_commom.api.test.FeatureShopLeftTitleResponse;
import com.guinong.lib_commom.api.update.UpdateAppRequest;
import com.guinong.lib_commom.api.update.UpdateAppResponse;
import com.guinong.lib_commom.api.upload.OssFileResponse;
import com.guinong.net.callback.IAsyncEmptyCallback;
import com.guinong.net.callback.IAsyncResultCallback;
import com.guinong.net.request.IAsyncRequestState;

public class BaseApiClient extends ApiClient {
    //版本更新
    public static final String GetUpdateApp = "/api/Public/GetUpdateApp";
    public static final String GET_OSS_FILE_URL = "/common/oss_auth/";    //获取上传文件凭证
    public static final String MODIFY_UESER_URL = "/shop/item";   //创建商家
    public static final String VERIFY_CODE = "/common/verify_code";   //验证码
    public static final String REGISTER = "/account/shop/register";   //注册
    public static final String LOGINT = "/account/shop/quick/login";   //登录
    public static final String SHOP_STATUS = "/shop/get/status/";   //店铺资料审核状态
    public static final String PUSH_TOKEN = "/chat/token";   //推送token

    /**
     * 获取升级App
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getUpdateApp(UpdateAppRequest request, IAsyncResultCallback<UpdateAppResponse> callback, Object userState) {
        return apiGetRequest(UpdateAppResponse.class, NEW_HOST + GetUpdateApp, request, callback, userState);
    }


    /**
     * 特色馆顶部title
     */
    public static final String GET_VENUEREGIONS = "/product/list/type/product";
    public static final String SHOP_CLASS_DATA = "/product/type/list";//店铺分类数据
    public static final String GET_DASH_UP_DOWN = "/product/update/item";
    public static final String GET_DASH_ADD_EDIT = "/product/item";//菜品的添加和修改接口
    public static final String CLASS_NAME_ADD_EDIT = "/product/type/item";//菜品分类名称的添加和修改接口
    public static final String CLASS_NAME_SORT = "/product/type/sort";//菜品分类排序
    public static final String SHOP_USER_DATA = "/shop/item/admin/";//店铺的用户数据
    public static final String USPATE_SHOP_DATA = "/shop/item";//更新店铺的数据
    public static final String USPATE_SHOP_SEARCH = "/product/list";//搜索

    /**
     * 钱包
     */
    public static final String GET_MYWALLET_ACCOUNT = "/wallet/account/";   //用户钱包
    public static final String GET_MYWALLET_LIST_DETAIL = "/wallet/list";   //钱包明细
    public static final String GET_WITHDRAW_PRE = "/wallet/withdraw_rebate/pre";   //申请提准备
    public static final String GET_WITHDRAW_WITHDRAW_REBATE = "/wallet/withdraw_rebate";   //申请提现


    /**
     * 订单
     */
    public static final String GET_ORDER_ORDER_INFO = "/order/info/";   //订单详情
    public static final String GET_ORDER_LIST_DATA = "/order/info/list";   //订单列表
    public static final String GET_ORDER_RECEIVER = "/order/info/take";   //接单
    public static final String GET_ORDER_CANCEL = "/order/info/cancel";   //拒绝接单
    public static final String GET_REFUND_BACK = "/order/refund/handle";   //退款操作

    /**
     * 特色馆右边内容数据
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getFeatureShopRightContent(FeatureRightContentRequest request, IAsyncResultCallback<FeatureShopLeftTitleResponse> callback, Object userState) {
        return apiGetRequest(FeatureShopLeftTitleResponse.class, NEW_HOST + GET_VENUEREGIONS, request, callback, userState);
    }

    public IAsyncRequestState getSearchGood(SearchRequest request, IAsyncResultCallback<SearchResponse> callback, Object userState) {
        return apiGetRequest(SearchResponse.class, NEW_HOST + USPATE_SHOP_SEARCH, request, callback, userState);
    }

    public IAsyncRequestState getClassData(ClassDataRequest request, IAsyncResultCallback<ClassDataResponse> callback, Object userState) {
        return apiGetRequest(ClassDataResponse.class, NEW_HOST + SHOP_CLASS_DATA, request, callback, userState);
    }

    public IAsyncRequestState getUserData(ShopStatusRequest request, IAsyncResultCallback<UserDataResponse> callback, Object userState) {
        return apiGetRequest(UserDataResponse.class, NEW_HOST + SHOP_USER_DATA + request.getUserid(), callback, userState);
    }

    public IAsyncRequestState updateUser(UpdateUserRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + USPATE_SHOP_DATA, request, callback, userState);
    }

    public IAsyncRequestState updatePrintUser(UpdatePrinterUserRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + USPATE_SHOP_DATA, request, callback, userState);
    }

    public IAsyncRequestState updateBindAli(UpdateBindALIRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + USPATE_SHOP_DATA, request, callback, userState);
    }

    public IAsyncRequestState updateUserPhone(UpdateUserPhoneAddressRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + USPATE_SHOP_DATA, request, callback, userState);
    }

    public IAsyncRequestState updateShopStaus(UpdateShopStatusRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + USPATE_SHOP_DATA, request, callback, userState);
    }

    public IAsyncRequestState updatePartUser(UpdateShopPartRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + USPATE_SHOP_DATA, request, callback, userState);
    }

    public IAsyncRequestState uploadEditDishData(UpLoadDishDataRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + GET_DASH_ADD_EDIT, request, callback, userState);
    }

    public IAsyncRequestState classEditName(ClassEditNameRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + CLASS_NAME_ADD_EDIT, request, callback, userState);
    }

    public IAsyncRequestState classSrot(ClassSortRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + CLASS_NAME_SORT, request, callback, userState);
    }

    /*  菜品编辑*/
    public IAsyncRequestState dashUpDown(DashEditRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + GET_DASH_UP_DOWN, request, callback, userState);
    }


    public IAsyncRequestState getOssFileUrl(String fileName, IAsyncResultCallback<OssFileResponse> callback, Object userState) {
        return apiGetRequest(OssFileResponse.class, IMAGEURL + GET_OSS_FILE_URL + fileName, callback, userState);
    }

    public IAsyncRequestState modifyUser(CreateShopKeeperRequest request, IAsyncResultCallback<Long> callback, Object userState) {
        return apiPostRequest(Long.class, NEW_HOST + MODIFY_UESER_URL, request, callback, userState);
    }

    /**
     * 获取验证码
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState verifyCode(PhoneCodeRequest request, IAsyncResultCallback<PhoneCodeResponse> callback, Object userState) {
        return apiGetRequest(PhoneCodeResponse.class, NEW_HOST + VERIFY_CODE, request, callback, userState);
    }

    public IAsyncRequestState verifyCode(VerifyCodeRequest request, IAsyncResultCallback<String> callback, Object userState) {
        return apiGetRequest(String.class, NEW_HOST + VERIFY_CODE, request, callback, userState);
    }

    public IAsyncRequestState getShopStatus(ShopStatusRequest request, IAsyncResultCallback<ShopStatusResponse> callback, Object userState) {
        return apiGetRequest(ShopStatusResponse.class, NEW_HOST + SHOP_STATUS + request.getUserid(), callback, userState);
    }

    public IAsyncRequestState getPushToken(PushTokenRequest request, IAsyncResultCallback<PushTokenResponse> callback, Object userState) {
        return apiPostRequest(PushTokenResponse.class, NEW_HOST + PUSH_TOKEN, request, callback, userState);
    }

    public IAsyncRequestState register(PhoneRegisterRequest request, IAsyncResultCallback<PhoneRegisterResponse> callback, Object userState) {
        return apiPostRequest(PhoneRegisterResponse.class, NEW_HOST + REGISTER, request, callback, userState);
    }

    public IAsyncRequestState login(PhoneRegisterRequest request, IAsyncResultCallback<LoginResponse> callback, Object userState) {
        return apiPostRequest(LoginResponse.class, NEW_HOST + LOGINT, request, callback, userState);
    }

    /**
     * 打印机
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getPrint(PrintRequest request, IAsyncResultCallback<PrintResponse> callback, Object userState) {
        return apiPostRequestYNW(PrintResponse.class, "http://api.zhongwuyun.com", request, callback, userState);
    }


    /**
     * 钱包
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getMyWallet(MyWalletRequest request, IAsyncResultCallback<MyWalletResponse> callback, Object userState) {
        return apiGetRequest(MyWalletResponse.class, NEW_HOST + GET_MYWALLET_ACCOUNT + request.getUserId(), callback, userState);
    }

    /**
     * 钱包明细
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getMyDetailWallet(MyWalletDetailRequest request, IAsyncResultCallback<MyWalletDetailResponse> callback, Object userState) {
        return apiGetRequest(MyWalletDetailResponse.class, NEW_HOST + GET_MYWALLET_LIST_DETAIL, request, callback, userState);
    }

    /**
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getCashOut(ApplyCashRequest request, IAsyncResultCallback<CashOutRespons> callback, Object userState) {
        return apiPostRequest(CashOutRespons.class, NEW_HOST + GET_WITHDRAW_PRE, request, callback, userState);
    }

    public IAsyncRequestState applyCashOut(CashOutRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + GET_WITHDRAW_WITHDRAW_REBATE, request, callback, userState);
    }

    /**
     * 获取订单列表
     *
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState getOrderList(OrdersRequest request, IAsyncResultCallback<OrdersResponse> callback, Object userState) {
        return apiGetRequest(new TypeToken<OrdersResponse>() {
        }.getType(), NEW_HOST + GET_ORDER_LIST_DATA, request, callback, userState);
    }

    /**
     * 接单
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState receiverOrderList(ReceiveOrdersRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + GET_ORDER_RECEIVER, request, callback, userState);
    }

    public IAsyncRequestState refuseOrder(ReceiveOrdersRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + GET_ORDER_CANCEL, request, callback, userState);
    }

    /**
     * 退款操作
     *
     * @param request
     * @param callback
     * @param userState
     * @return
     */
    public IAsyncRequestState refuseBackApi(RefuneBackRequest request, IAsyncEmptyCallback callback, Object userState) {
        return apiPostRequest(NEW_HOST + GET_REFUND_BACK, request, callback, userState);
    }

    public IAsyncRequestState getOrderDetail(OrdersDetailRequest request, IAsyncResultCallback<OrdersDetailResponse> callback, Object userState) {
        return apiGetRequest(new TypeToken<OrdersDetailResponse>() {
        }.getType(), NEW_HOST + GET_ORDER_ORDER_INFO + request.getSerialNum(), callback, userState);
    }
}
