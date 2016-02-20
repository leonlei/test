<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人中心--我的简历</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/jsp/css/1.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/jsp/css/2.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/views/jsp/css/3.css">
</head>
<body class="p-job">
<!--添加livereload注释-->
<div class="g-header">
</div>

<div class="g-container">
    <div class="g-layout g-s5m0e4">
        <div class="col-main">
            <div class="main-wrap">

                <div>
                    <div id="profile-section" class="m-resume-section profile-section  ">
                        <div class="section-hd">
                            <h4>个人信息</h4>

                            <div class="handles">


                                <!--Regular if0-->
                            </div>
                        </div>
                        <div class="section-bd">
                            <!--Regular if55-->
                            <!--Regular list-->
                            <div class="J_item-0 profile">
                                <div class="avatar none"><img alt=""></div>
                                <div>
                                    <span class="name">雷宇</span>
                                    <span class="ico-gender male" title="男"></span>
                                </div>
                                <div class="contacts">
                                    <span class="phone">15557103066</span>
                                    <span class="email">leiyu8748@163.com</span>
                                </div>
                                <table class="others">
                                    <tbody>
                                    <tr>
                                        <td>出生日期：1991.11.07</td>
                                        <td>参加工作年月：2012.05</td>
                                    </tr>
                                    <tr>
                                        <td>居住地：杭州市</td>
                                        <td>婚姻状态：未婚</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>

                            <!--Regular if1-->


                            <div id="education-section" class="m-resume-section education-section  ">
                                <div class="section-hd">
                                    <h4>教育经历</h4>

                                </div>
                                <div class="section-bd">
                                    <!--Regular if56-->
                                    <div class="item-list item-list-s1">
                                        <!--Regular list-->
                                        <div class="J_item-0 item">
                                            <div class="date">2008.09-2012.06</div>
                                            <div class="cnt">
                                                <p>本科</p>

                                                <p>淮南师范学院</p>

                                                <p>电子信息科学与技术</p>
                                            </div>

                                        </div>

                                    </div>
                                    <!--Regular if12-->


                                </div>
                                <div id="experience-section" class="m-resume-section experience-section  ">
                                    <div class="section-hd">
                                        <h4>工作经历</h4>

                                    </div>
                                    <div class="section-bd">
                                        <!--Regular if57-->
                                        <div class="item-list item-list-s1">
                                            <!--Regular list-->
                                            <div class="J_item-0 item">
                                                <div class="date">2014.10-2016.01</div>
                                                <div class="cnt">
                                                    <p>全职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;翼信科技股份有限公司</p>

                                                    <p>服务端-Java开发</p>

                                                    <div class="desc">
                                                        工作职责：<span>主要参与易信企业版后台管理系统和给pc端及手机端接口的需求讨论，接口规范制定，以及接口开发。</span>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="J_item-1 item">
                                                <div class="date">2013.03-2014.10</div>
                                                <div class="cnt">
                                                    <p>全职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浙江网新恩普软件有限公司</p>

                                                    <p>Java开发</p>

                                                    <div class="desc">
                                                        工作职责：<span>主要负责社保网上申报系统，负责开发和上线的有海宁社保网上申报系统和吴江网上申报系统</span>
                                                    </div>
                                                </div>

                                            </div>

                                        </div>
                                        <!--Regular if18-->

                                    </div>
                                    <div id="expect-section" class="m-resume-section expect-section  ">
                                        <div class="section-hd">
                                            <h4>求职意向</h4>

                                        </div>
                                        <div class="section-bd">
                                            <!--Regular if58-->
                                            <!--Regular list-->
                                            <div class="J_item-0">
                                                <table>
                                                    <colgroup>
                                                        <col width="90">
                                                        <col>
                                                        <col width="90">
                                                        <col width="150">
                                                    </colgroup>
                                                    <tbody>
                                                    <tr>
                                                        <th align="right">目前薪资：</th>
                                                        <td>13K</td>
                                                        <th align="right">期望薪资：</th>
                                                        <td>15K</td>
                                                    </tr>
                                                    <tr>
                                                        <th align="right">期望地点：</th>
                                                        <td>杭州市</td>
                                                        <th align="right">到岗时间：</th>
                                                        <td>一个月内</td>
                                                    </tr>
                                                    <tr>
                                                        <th align="right">期望岗位：</th>
                                                        <td colspan="3">服务端开发</td>
                                                    </tr>
                                                    <tr>
                                                        <th valign="top" align="right">自我评价：</th>
                                                        <td colspan="3">熟悉Struts,Spring,Mybatis等常用框架技术，<br>掌握Java消息服务和并发，rabbitMQ，熟悉JVM原理。
                                                            <br>熟悉Redis, Memcache等缓存服务和Python脚本语言。<br>了解基本设计模式。<br>
                                                            强烈的责任心、主动性和团队合作精神,能很快融入公司项目组团队。
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>

                                            <!--Regular if26-->


                                        </div>
                                        <div id="project-section" class="m-resume-section project-section  ">
                                            <div class="section-hd">
                                                <h4>项目经历</h4>

                                            </div>
                                            <div class="section-bd">
                                                <!--Regular if59-->
                                                <div class="item-list item-list-s1">
                                                    <!--Regular list-->
                                                    <div class="J_item-0 item">
                                                        <div class="date">2014.10-2016.01</div>
                                                        <div class="cnt">
                                                            <p>易信企业版</p>

                                                            <div class="desc">
                                                                <label>项目职责：</label>

                                                                <p>负责企业企业版后台管理模块开发，接口开发。</p>
                                                            </div>
                                                            <div class="desc">
                                                                <label>项目描述：</label>

                                                                <p>易信企业版后台主要使用Spring,Spring
                                                                    MVC,Mybatis框架，使用网易ddb数据库，缓存用redis搭了个集群。接口调用监控原来使用的是网易monitor后使用哨兵系统了。<br>主要功能有企业管理平台和通讯录管理平台，后期与精灵平台合并成新的企业管理平台。主要有后台管理企业的常用功能及给前端(web端，手机端，pc端)提供相应的接口
                                                                </p>
                                                            </div>
                                                        </div>

                                                    </div>

                                                    <div class="J_item-1 item">
                                                        <div class="date">2013.03-2014.10</div>
                                                        <div class="cnt">
                                                            <p>社保网上申报系统和后台管理系统</p>

                                                            <div class="desc">
                                                                <label>项目职责：</label>

                                                                <p>主要负责是开发编码工作，相关视图的建立和优化以及oracle存储过程编写,以及后期的上线和升级</p>
                                                            </div>
                                                            <div class="desc">
                                                                <label>项目描述：</label>

                                                                <p>
                                                                    主要开发了项目里申报和查询模块。查询主要是企业在社保各种的参保和缴费信息，申报模块包括社保常见功能，包含身份证信息采集和照片上传处理,以及各种报表的打印（包含CA电子签章和JNI调用本地库生成二维码），调用市民卡中心webservice接口处理业务。也为公司自助终端系统提供公司注册码发放的接口和移动社保（微信和app）的数据查询接口。</p>
                                                            </div>
                                                        </div>

                                                    </div>

                                                </div>
                                                <!--Regular if33-->


                                            </div>

                                        </div>
</body>
</html>