<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)file:///home/luxj/Downloads/ditopn_xyz.ftl -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="zh-cn">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title>面含模板</title>
    <style>
        @page {
            size: A4;
            margin: 0.8cm 1.5cm;
        }

        * {
            font-family: 'SimSun';
        }

        .main {
            margin: auto;
            padding-top: 50px;
            padding-bottom: 200px;
        }

        .title {
            width: 100%;
        }

        .row-title {
            text-align: center;
            border-left: none;
            font-weight: 700;
        }

        table {
            width: 100%;
            border: solid 1px #666;
        }

        th {
            border-bottom: solid 1px #666;
            border-left: solid 1px #666;
        }

        thead th {
            line-height: 0px;
            border: none;
        }

        th.h-1 {
            width: 40px;
        }

        th.h-2 {
            width: 130px;
        }

        th.h-3 {
            width: 60px;
        }

        th.h-4 {
            width: 150px;
        }

        th.h-5 {
            width: 80px;
        }

        tbody tr:first-child td {
            border-top: none;
        }

        td {
            padding: 5px;
            border-top: solid 1px #666;
            border-left: solid 1px #666;
        }

        .part .text-block {
            min-height: 130px;
        }

        .block {
            font-weight: 700;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="title">
        <span>开证日期：${data.openDate?string("yyyy-MM-dd")}</span>
        <span style="margin-left: 30%;">信用证编号：${data.businessCode!}</span>
    </div>
    <table cellspacing="0" cellpadding="0" border="0">
        <thead>
        <tr>
            <th class="h-1"></th>
            <th class="h-2"></th>
            <th class="h-3"></th>
            <th class="h-4"></th>
            <th class="h-5"></th>
            <th class="h-6"></th>
        </tr>
        </thead>
        <tbody>
        <!-- 通知行 -->
        <tr>
            <td rowspan="4" class="row-title"><b>通知行</b></td>
            <td><b>名称</b></td>
            <td colspan="4">${data.parties.adv.pts.partyName!}</td>
        </tr>
        <tr>
            <td><b>行号</b></td>
            <td colspan="4">${data.parties.adv.pts.partyCode!}</td>
        </tr>
        <tr>
            <td><b>地址</b></td>
            <td colspan="4">${data.parties.adv.pts.address!}</td>
        </tr>
        <tr>
            <td><b>邮编</b></td>
            <td colspan="4">${data.parties.adv.pts.zipCode!}</td>
        </tr>

        <!-- 申请人 -->
        <tr>
            <td rowspan="3" class="row-title"><b>申请人</b></td>
            <td><b>全称</b></td>
            <td colspan="4">${data.parties.apl.pts.partyName!}</td>
        </tr>
        <tr>
            <td><b>地址</b></td>
            <td colspan="4">${data.parties.apl.pts.address!}</td>
        </tr>
        <tr>
            <td><b>邮编</b></td>
            <td colspan="2">${data.parties.apl.pts.zipCode!}</td>
            <td><b>电话</b></td>
            <td colspan="2">${data.parties.apl.pts.telephone!}</td>
        </tr>

        <!-- 受益人 -->
        <tr>
            <td rowspan="3" class="row-title"><b>受益人</b></td>
            <td><b>全称</b></td>
            <td colspan="4">${data.parties.ben.pts.partyName!}</td>
        </tr>
        <tr>
            <td><b>地址</b></td>
            <td colspan="4">${data.parties.ben.pts.address!}</td>
        </tr>
        <tr>
            <td><b>邮编</b></td>
            <td colspan="2">${data.parties.ben.pts.zipCode!}</td>
            <td><b>电话</b></td>
            <td colspan="2">${data.parties.ben.pts.telephone!}</td>
        </tr>

        <!-- 信用证信息 -->
        <tr>
            <td rowspan="3" class="row-title"><b>信用证信息</b></td>
            <td><b>金额</b></td>
            <td style="text-align: center;">CNY</td>
            <td>${data.amount?string(',###.00')}</td>
            <td style="text-align: center;">人民币<br/>（大写）</td>
            <td style="font-size: 14px;">${req.data.chineseAmount!}</td>
        </tr>
        <tr>
            <td><b>有效期</b></td>
            <td colspan="4">${data.expireDate?string("yyyy-MM-dd")}</td>
        </tr>
        <tr>
            <td><b>有效地点</b></td>
            <td colspan="4">${data.expirePlace!}</td>
        </tr>

        <!-- 议付 -->
        <tr>
            <td rowspan="3" class="row-title"><b>议付</b></td>
            <td><b>是否可议付</b></td>
            <td colspan="4">
                <input type="checkbox" name="neg_specify_bank"
                <#if (data.negotiationType!-1) == 0>
                       checked="checked"
                </#if>
                /> 以下银行可议付
                <input type="checkbox" name="neg_any_bank"
                <#if (data.negotiationType!-1) == 1>
                       checked="checked"
                </#if>
                /> 任意银行可议付
                <input type="checkbox" name="neg_not_allow"
                <#if (data.negotiationType!-1) == 2>
                       checked="checked"
                </#if>
                /> 不可议付
            </td>
        </tr>
        <tr>
            <td><b>议付行名称</b></td>
            <td colspan="4">${data.parties.neg.pts.partyName!}</td>
        </tr>
        <tr>
            <td><b>议付行行号</b></td>
            <td colspan="4">${data.parties.neg.pts.partyCode!}</td>
        </tr>

        <!-- 转让 -->
        <tr>
            <td rowspan="3" class="row-title"><b>转让</b></td>
            <td><b>是否可转让</b></td>
            <td colspan="4">
                <input type="checkbox" name="trans_allow"
                <#if (data.transferFlag!-1) == 1>
                       checked="checked"
                </#if>
                /> 可转让
                <input type="checkbox" name="trans_not_allow"
                <#if (data.transferFlag!-1) == 0>
                       checked="checked"
                </#if>
                /> 不可转让
            </td>
        </tr>
        <tr>
            <td><b>转让行名称</b></td>
            <td colspan="4">${data.parties.tri.pts.partyName!}</td>
        </tr>
        <tr>
            <td><b>转让行行号</b></td>
            <td colspan="4">${data.parties.tri.pts.partyCode!}</td>
        </tr>

        <!-- 保兑 -->
        <tr>
            <td rowspan="3" class="row-title"><b>保兑</b></td>
            <td><b>是否可保兑</b></td>
            <td colspan="4">
                <input type="checkbox" name="confirm_allow"
                <#if (data.confirmFlag!-1) == 1>
                       checked="checked"
                </#if>
                /> 可保兑
                <input type="checkbox" name="confirm_not_allow"
                <#if (data.confirmFlag!-1) == 0>
                       checked="checked"
                </#if>
                /> 不可保兑
            </td>
        </tr>
        <tr>
            <td><b>保兑行名称</b></td>
            <td colspan="4"></td>
        </tr>
        <tr>
            <td><b>保兑行行号</b></td>
            <td colspan="4"></td>
        </tr>
        </tbody>
    </table>

    <div style="margin-top: 50px;">
        <div class="part">
            <label><b>交单期：</b></label>
            <span class="text">${data.documentsPresentRequirement!}</span>
        </div>
        <div class="part">
            <label><b>付款期限：</b></label>
            <span class="text">
                <input type="checkbox" name="tenor_pay"
                <#if (data.sightPayFlag!-1) == 0>
                       checked="checked"
                </#if>
                /> 即期
                <input type="checkbox" name="tenor_sight"
                <#if (data.sightPayFlag!-1) == 1>
                       checked="checked"
                </#if>
                /> 远期
            </span>
        </div>
    </div>

    <div style="margin-top: 50px;">
        <div class="part">
            <label><b>转运：</b></label>
            <span class="text">
                <input type="checkbox" name="shipTrans_allow"
                <#if (data.shipTrans!-1) == 1>
                       checked="checked"
                </#if>
                /> 允许
                <input type="checkbox" name="shipTrans_not_allow"
                <#if (data.shipTrans!-1) == 0>
                       checked="checked"
                </#if>
                /> 不允许
            </span>
        </div>

        <div class="part">
            <label><b>货物运输或交货方式/服务方式：</b></label>
            <span class="text">${EnumUtils.getDesc('TransferType',data.transferType!-1)!}</span>
        </div>

        <div class="part">
            <label><b>分批装运货物/分次提供服务：</b></label>
            <span class="text">
                <input type="checkbox" name="shipPortion_allow"
                <#if (data.shipPortion!-1) == 1>
                       checked="checked"
                </#if>
                /> 允许
                <input type="checkbox" name="shipPortion_not_allow"
                <#if (data.shipPortion!-1) == 0>
                       checked="checked"
                </#if>
                /> 不允许
            </span>
        </div>

        <div>
            <span>
                <span class="part">
                    <label><b>货物装运地（港）：</b></label>
                    <span class="text">${data.shipFrom!}</span>
                </span>
            </span>
            <span style="margin-left: 20%;">
                <span class="part">
                    <label><b>货物目的地、交货地（港）：</b></label>
                    <span class="text">${data.shipTo!}</span>
                </span>
            </span>
        </div>

        <div class="part">
            <label><b>服务提供地点：</b></label>
            <span class="text">${data.servicePlace!}</span>
        </div>

        <div class="part">
            <label><b>最迟装运货物/服务提供日期：</b></label>
            <span class="text">${data.shipDate?string("yyyy-MM-dd")}</span>
        </div>

        <div class="part">
            <label><b>分期装运/提供服务：</b></label>
            <span class="text">
                <input type="checkbox" name="shipStage_allow"/> 允许
                <input type="checkbox" name="shipStage_not_allow"/> 不允许
            </span>
        </div>
    </div>

    <div class="part">
        <label><b>分期具体约定：</b></label>
        <span class="text">${data.shipText!}</span>
    </div>

    <div class="part">
        <label><b>货物/服务描述：</b></label>
        <div class="text-block">${data.goodsDesc!}</div>
    </div>

    <div class="part">
        <label><b>受益人应提交的单据：</b></label>
        <div class="text-block">${data.requiredDocs!}</div>
    </div>

    <div class="part">
        <label><b>其他条款：</b></label>
        <div class="text-block">${data.additionalCondition!}</div>
    </div>

    <div style="text-indent: 32px;">
        本信用证依据《国内信用证结算办法》开立，遵守《国内信用证审单规则》，适用《最高人民法院关于审理信用证纠纷案件若干问题的规定》。本信用证为不可撤销信用证。我行保证在收到相符单据后，履行付款的责任。如信用证为远期信用证，我行将在收到相符单据次日起五个营业日内确认付款，并在到期日付款；如信用证为即期信用证，我行将在收到相符单据次日起五个营业日内付款。议付行或交单行应将每次提交单据情况（交单日期、业务编号、交单金额、信用证余额、交单行/议付行名称、经办人签字）背书记录在正本信用证背面，并在交单面函中说明。
    </div>

    <div style="margin-top: 50px;">
        <div class="part">
            <label>开证行全称：</label>
            <span class="text">${data.parties.iss.pts.partyName!}</span>
        </div>
        <div class="part">
            <label>开证行行号：</label>
            <span class="text">${data.parties.iss.pts.partyCode!}</span>
        </div>
        <div class="part">
            <label>地址：</label>
            <span class="text">${data.parties.iss.pts.address!}</span>
        </div>
        <div class="part">
            <label>邮编：</label>
            <span class="text">${data.parties.iss.pts.zipCode!}</span>
        </div>
        <div class="part">
            <label>电话：</label>
            <span class="text">${data.parties.iss.pts.telephone!}</span>
        </div>
        <div class="part">
            <label>传真：</label>
            <span class="text">${data.parties.iss.pts.fax!}</span>
        </div>
    </div>

    <div style="margin-top: 150px; text-align: right;">开证行盖章</div>
</div>
</body>
</html>