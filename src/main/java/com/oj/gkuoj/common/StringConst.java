package com.oj.gkuoj.common;

/**
 * @author m969130721@163.com
 * @date 18-12-23 下午3:48
 */
public final class StringConst {

    public static final String ADD_SUCCESS = "添加成功";

    public static final String ADD_FAIL = "添加失败";

    public static final String DEL_SUCCESS = "删除成功";

    public static final String DEL_FAIL = "删除失败";

    public static final String UPDATE_SUCCESS = "更新成功";

    public static final String UPDATE_FAIL = "更新失败";

    public static String getRegisterEmailContent(String href) {

        return "<div style=\"POSITION: relative; MARGIN: 0px auto; WIDTH: 600px; OVERFLOW: hidden\">" +
                "    <div><img src=\"https://www.luogu.org/images/logo_blue_3.png\" width=\"150\">" +
                "        <div style=\"DISPLAY: inline-block; FLOAT: right\">计算机程序在线性能测评系统-最有亲和力的信息学在线学习社区 <br><a href=\"https://www.luogu.org/\" rel=\"noopener\" target=\"_blank\">https://www.luogu.org </a>" +
                "        </div>" +
                "    </div>" +
                "    <hr>" +
                "    <div style=\"position:rerelative;z-index:2\">" +
                "        <h1>计算机程序在线性能测评系统 - 账号激活 </h1>" +
                "        <p><b></b> 同学： </p>" +
                "        <p>欢迎你注册，一起探求算法的奥秘！</p>" +
                "        <p>打开下面的地址即可完成注册： </p>" +
                "        <p>" +
                "            <a href=" + href + " rel=\"noopener\" target=\"_blank\">" +href+
                "            </a>" +
                "        </p>" +
                "        <p>祝你编程愉快！ </p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <hr>" +
                "        <small>这篇邮件是由计算机程序在线性能测评系统自动发送，请不要回复这封邮件。 <br>如果有任何问题，欢迎给管理员明哥发送邮件。</small>" +
                "    </div>" +
                "    <img src=\"https://www.luogu.org/images/stamp.png\" style=\"width: 300px;position: absolute;right: -5px;bottom: -30px;transform: rotate(-40deg);z-index:-1\">" +
                "</div>";

    }

    public static String getForgetPasswordEmailContent(String href) {

        return "<div style=\"POSITION: relative; MARGIN: 0px auto; WIDTH: 600px; OVERFLOW: hidden\">" +
                "    <div><img src=\"https://www.luogu.org/images/logo_blue_3.png\" width=\"150\">" +
                "        <div style=\"DISPLAY: inline-block; FLOAT: right\">计算机程序在线性能测评系统-最有亲和力的信息学在线学习社区 <br><a href=\"https://www.luogu.org/\" rel=\"noopener\" target=\"_blank\">https://www.luogu.org </a>" +
                "        </div>" +
                "    </div>" +
                "    <hr>" +
                "    <div style=\"position:rerelative;z-index:2\">" +
                "        <h1>计算机程序在线性能测评系统 - 重设密码 </h1>" +
                "        <p><b></b> 同学： </p>" +
                "        <p>忘记了密码？不要紧</p>" +
                "        <p>打开下面的地址即可重设密码： </p>" +
                "        <p>" +
                "            <a href=" + href + " rel=\"noopener\" target=\"_blank\">" + href +
                "            </a>" +
                "        </p>" +
                "        <p>如果你没有申请过忘记密码，请忽略这封邮件。</p>" +
                "        <p>祝你编程愉快！ </p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <p>&nbsp;</p>" +
                "        <hr>" +
                "        <small>这篇邮件是由计算机程序在线性能测评系统自动发送，请不要回复这封邮件。 <br>如果有任何问题，欢迎给管理员明哥发送邮件。</small>" +
                "    </div>" +
                "    <img src=\"https://www.luogu.org/images/stamp.png\" style=\"width: 300px;position: absolute;right: -5px;bottom: -30px;transform: rotate(-40deg);z-index:-1\">" +
                "</div>";

    }

}
