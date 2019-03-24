package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 18-5-27 下午5:47
 */
public enum RestResponseEnum {

    /**
     * 标准http状态
     */

    SUCCESS(200, "成功"),

    INVALID_REQUEST(400, "无效的请求,请求参数错误"),

    UNAUTHORIZED(401, "未认证,请先登录"),

    FORBIDDEN(403, "无权限"),

    NOT_FOUND(404, "NOT　FOUND"),

    METHOD_NOT_ALLOWED(405, "请求方法错误"),

    ERROR(500, "SERVER ERROR"),


    /**
     * 以下为自定义异常:客户端自定义异常从460开始排列, 服务器端自定义异常从700开始排列
     */


    //原始密码不一致
    ORIGINAL_PASSWORD_ERROR(460, "原始密码不一致"),

    //账号或密码错误
    USERNAME_OR_PASSWORD_ERROR(461, "账号或密码错误"),

    //验证码错误
    VALIDATE_CODE_ERROR(462, "验证码错误"),

    //比赛报名密钥错误
    COMPETITION_PASSWORD_ERROR(463, "比赛报名密码错误"),



    //token校验失败
    TOKEN_ERROR(700, "token校验失败"),

    //用户名已被注册
    USERNAME_REPEATED_ERROR(701, "用户名已被注册"),

    //邮箱发送错误
    EMAIL_SEND_ERROR(702, "邮箱发送错误,请稍后再试"),

    //邮箱重复错误
    EMAIL_REPEATED_ERROR(703, "该邮箱已被注册"),

    //邮箱还未注册
    EMAIL_NOT_FOUND_ERROR(704, "该邮箱还未注册"),

    //文件格式错误
    FILE_TYPE_ERROR(705, "文件格式错误"),

    //文件权限错误
    FILE_PERMISSION_ERROR(706, "没有该文件操作权限"),

    //比赛重复报名
    COMPETITION_REPEATED_REGISTER_ERROR(707, "比赛重复报名"),

    //找不到该比赛
    COMPETITION_NOT_FOUND_ERROR(708, "找不到该比赛"),

    //比赛未开始
    COMPETITION_NOT_START_ERROR(709, "比赛未开始"),

    //比赛已开始
    COMPETITION_STARTED_ERROR(710, "比赛已开始"),

    //比赛已结束
    COMPETITION_CLOSED_ERROR(711, "比赛已结束"),

    //用户未报名比赛
    COMPETITION_NOT_REGISTER(712, "用户未报名比赛"),

    //昵称重复错误
    NAME_REPEATED_ERROR(713, "昵称重复错误"),

    //手机重复错误
    PHONE_REPEATED_ERROR(714, "手机重复错误");

    private Integer status;

    private String desc;

    RestResponseEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }


}
