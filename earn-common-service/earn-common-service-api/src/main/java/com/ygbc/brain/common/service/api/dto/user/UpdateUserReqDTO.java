package com.ygbc.brain.common.service.api.dto.user;

import com.ygbc.brain.base.dto.BaseDTO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UpdateUserReqDTO extends BaseDTO {
    @NotBlank(message = "请输入登录名称")
    private String loginName;

    @NotBlank(message = "请输入用户姓名")
    private String userName;

    @NotBlank(message = "请输入登录密码")
    private String password;

    @NotBlank(message = "请输入证件号码")
    private String identityCode;

    @NotBlank(message = "请输入手机号码")
    private String mobile;

    private String telephone;

    private String mail;

    private String jobNo;

    @NotNull(message = "请选择用户状态")
    private Byte status;


    /**
     * 注册时间
     */
    private Date registTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 密码到期日
     */
    private Date passwordExpireDate;

    /**
     * 最后密码修改时间
     */
    private Date passwordChangeTime;

    /**
     * 用户类型 0:超级管理员 1:管理员 2:总控端 3:判读端
     */
    private String type;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 左/右利手 L:左手 R:右手
     */
    private String leftOrRight;

    /**
     * 近视度数（矫正前）
     */
    private Integer eyesightBefore;

    /**
     * 散光度数（矫正前）
     */
    private Integer cylBefore;

    /**
     * 远视度数（矫正前）
     */
    private Integer hyperopiaDegreeBefore;

    /**
     * 近视度数（矫正后）
     */
    private Integer eyesightAfter;

    /**
     * 散光度数（矫正后）
     */
    private Integer cylAfter;

    /**
     * 远视度数（矫正后）
     */
    private Integer hyperopiaDegreeAfter;

    /**
     * 最优通道排序向量（64个数字）
     */
    private String optimalPathRankingVector;

    /**
     * 最优通道
     */
    private String optimalChannel;

    /**
     * 最优通道数
     */
    private Integer optimalChannelNumber;

    /**
     * A类脑电幅值均值和标准差
     */
    private String classA;

    /**
     * B类脑电幅值均值和标准差
     */
    private String classB;

    /**
     * A类脑电峰值出现时刻的均值和标准差
     */
    private String classAPeek;

    /**
     * A类脑电峰值无显著下降的最小可持续工作时间
     */
    private Double classAPeekMinTime;

    /**
     * A类脑电峰值缩减但准确率无显著下降的最大可持续工作时间
     */
    private Double classAPeekMaxTime;

    /**
     * 位点1
     */
    private String f5;

    /**
     * 位点2
     */
    private String f3;

    /**
     * 位点3
     */
    private String f1;

    /**
     * 位点4
     */
    private String fz;

    /**
     * 位点5
     */
    private String f2;

    /**
     * 位点6
     */
    private String f4;

    /**
     * 位点7
     */
    private String f6;

    /**
     * 位点8
     */
    private String fc3;

    /**
     * 位点9
     */
    private String fc1;

    /**
     * 位点10
     */
    private String fcz;

    /**
     * 位点11
     */
    private String fc2;

    /**
     * 位点12
     */
    private String fc4;

    /**
     * 位点13
     */
    private String c5;

    /**
     * 位点14
     */
    private String c3;

    /**
     * 位点15
     */
    private String c1;

    /**
     * 位点16
     */
    private String cz;

    /**
     * 位点17
     */
    private String c2;

    /**
     * 位点18
     */
    private String c4;

    /**
     * 位点19
     */
    private String c6;

    /**
     * 位点20
     */
    private String cp1;

    /**
     * 位点21
     */
    private String cpz;

    /**
     * 位点22
     */
    private String cp2;

    /**
     * 位点23
     */
    private String p5;

    /**
     * 位点24
     */
    private String p3;

    /**
     * 位点25
     */
    private String p1;

    /**
     * 位点26
     */
    private String pz;

    /**
     * 位点27
     */
    private String p2;

    /**
     * 位点28
     */
    private String p4;

    /**
     * 位点29
     */
    private String p6;

    /**
     * 位点30
     */
    private String oz;

    /**
     * 位点31
     */
    private String m1;

    /**
     * 位点32
     */
    private String m2;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode == null ? null : identityCode.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo == null ? null : jobNo.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getPasswordExpireDate() {
        return passwordExpireDate;
    }

    public void setPasswordExpireDate(Date passwordExpireDate) {
        this.passwordExpireDate = passwordExpireDate;
    }

    public Date getPasswordChangeTime() {
        return passwordChangeTime;
    }

    public void setPasswordChangeTime(Date passwordChangeTime) {
        this.passwordChangeTime = passwordChangeTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLeftOrRight() {
        return leftOrRight;
    }

    public void setLeftOrRight(String leftOrRight) {
        this.leftOrRight = leftOrRight == null ? null : leftOrRight.trim();
    }

    public Integer getEyesightBefore() {
        return eyesightBefore;
    }

    public void setEyesightBefore(Integer eyesightBefore) {
        this.eyesightBefore = eyesightBefore;
    }

    public Integer getCylBefore() {
        return cylBefore;
    }

    public void setCylBefore(Integer cylBefore) {
        this.cylBefore = cylBefore;
    }

    public Integer getHyperopiaDegreeBefore() {
        return hyperopiaDegreeBefore;
    }

    public void setHyperopiaDegreeBefore(Integer hyperopiaDegreeBefore) {
        this.hyperopiaDegreeBefore = hyperopiaDegreeBefore;
    }

    public Integer getEyesightAfter() {
        return eyesightAfter;
    }

    public void setEyesightAfter(Integer eyesightAfter) {
        this.eyesightAfter = eyesightAfter;
    }

    public Integer getCylAfter() {
        return cylAfter;
    }

    public void setCylAfter(Integer cylAfter) {
        this.cylAfter = cylAfter;
    }

    public Integer getHyperopiaDegreeAfter() {
        return hyperopiaDegreeAfter;
    }

    public void setHyperopiaDegreeAfter(Integer hyperopiaDegreeAfter) {
        this.hyperopiaDegreeAfter = hyperopiaDegreeAfter;
    }

    public String getOptimalPathRankingVector() {
        return optimalPathRankingVector;
    }

    public void setOptimalPathRankingVector(String optimalPathRankingVector) {
        this.optimalPathRankingVector = optimalPathRankingVector == null ? null : optimalPathRankingVector.trim();
    }

    public String getOptimalChannel() {
        return optimalChannel;
    }

    public void setOptimalChannel(String optimalChannel) {
        this.optimalChannel = optimalChannel == null ? null : optimalChannel.trim();
    }

    public Integer getOptimalChannelNumber() {
        return optimalChannelNumber;
    }

    public void setOptimalChannelNumber(Integer optimalChannelNumber) {
        this.optimalChannelNumber = optimalChannelNumber;
    }

    public String getClassA() {
        return classA;
    }

    public void setClassA(String classA) {
        this.classA = classA == null ? null : classA.trim();
    }

    public String getClassB() {
        return classB;
    }

    public void setClassB(String classB) {
        this.classB = classB == null ? null : classB.trim();
    }

    public String getClassAPeek() {
        return classAPeek;
    }

    public void setClassAPeek(String classAPeek) {
        this.classAPeek = classAPeek == null ? null : classAPeek.trim();
    }

    public Double getClassAPeekMinTime() {
        return classAPeekMinTime;
    }

    public void setClassAPeekMinTime(Double classAPeekMinTime) {
        this.classAPeekMinTime = classAPeekMinTime;
    }

    public Double getClassAPeekMaxTime() {
        return classAPeekMaxTime;
    }

    public void setClassAPeekMaxTime(Double classAPeekMaxTime) {
        this.classAPeekMaxTime = classAPeekMaxTime;
    }

    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 = f5 == null ? null : f5.trim();
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3 == null ? null : f3.trim();
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1 == null ? null : f1.trim();
    }

    public String getFz() {
        return fz;
    }

    public void setFz(String fz) {
        this.fz = fz == null ? null : fz.trim();
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2 == null ? null : f2.trim();
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4 == null ? null : f4.trim();
    }

    public String getF6() {
        return f6;
    }

    public void setF6(String f6) {
        this.f6 = f6 == null ? null : f6.trim();
    }

    public String getFc3() {
        return fc3;
    }

    public void setFc3(String fc3) {
        this.fc3 = fc3 == null ? null : fc3.trim();
    }

    public String getFc1() {
        return fc1;
    }

    public void setFc1(String fc1) {
        this.fc1 = fc1 == null ? null : fc1.trim();
    }

    public String getFcz() {
        return fcz;
    }

    public void setFcz(String fcz) {
        this.fcz = fcz == null ? null : fcz.trim();
    }

    public String getFc2() {
        return fc2;
    }

    public void setFc2(String fc2) {
        this.fc2 = fc2 == null ? null : fc2.trim();
    }

    public String getFc4() {
        return fc4;
    }

    public void setFc4(String fc4) {
        this.fc4 = fc4 == null ? null : fc4.trim();
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5 == null ? null : c5.trim();
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3 == null ? null : c3.trim();
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz == null ? null : cz.trim();
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4 == null ? null : c4.trim();
    }

    public String getC6() {
        return c6;
    }

    public void setC6(String c6) {
        this.c6 = c6 == null ? null : c6.trim();
    }

    public String getCp1() {
        return cp1;
    }

    public void setCp1(String cp1) {
        this.cp1 = cp1 == null ? null : cp1.trim();
    }

    public String getCpz() {
        return cpz;
    }

    public void setCpz(String cpz) {
        this.cpz = cpz == null ? null : cpz.trim();
    }

    public String getCp2() {
        return cp2;
    }

    public void setCp2(String cp2) {
        this.cp2 = cp2 == null ? null : cp2.trim();
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5 == null ? null : p5.trim();
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3 == null ? null : p3.trim();
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1 == null ? null : p1.trim();
    }

    public String getPz() {
        return pz;
    }

    public void setPz(String pz) {
        this.pz = pz == null ? null : pz.trim();
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2 == null ? null : p2.trim();
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4 == null ? null : p4.trim();
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6 == null ? null : p6.trim();
    }

    public String getOz() {
        return oz;
    }

    public void setOz(String oz) {
        this.oz = oz == null ? null : oz.trim();
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1 == null ? null : m1.trim();
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2 == null ? null : m2.trim();
    }
}
