package com.dmm.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 培训表
 * </p>
 *
 * @author 杜敏敏
 * @since 2019-12-22
 */
public class Study implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "study_id", type = IdType.AUTO)
    private Integer studyId;
    /**
     * 培训标题
     */
    @TableField("study_title")
    private String studyTitle;
    /**
     * 培训内容
     */
    @TableField("study_content")
    private String studyContent;
    /**
     * 培训时间
     */
    @TableField("study_time")
    private String studyTime;
    /**
     * 培训人员id，逗号隔开
     */
    @TableField("study_user")
    private String studyUser;

    @TableField(exist = false)
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getStudyId() {
        return studyId;
    }

    public void setStudyId(Integer studyId) {
        this.studyId = studyId;
    }

    public String getStudyTitle() {
        return studyTitle;
    }

    public void setStudyTitle(String studyTitle) {
        this.studyTitle = studyTitle;
    }

    public String getStudyContent() {
        return studyContent;
    }

    public void setStudyContent(String studyContent) {
        this.studyContent = studyContent;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getStudyUser() {
        return studyUser;
    }

    public void setStudyUser(String studyUser) {
        this.studyUser = studyUser;
    }

    @Override
    public String toString() {
        return "Study{" +
                ", studyId=" + studyId +
                ", studyTitle=" + studyTitle +
                ", studyContent=" + studyContent +
                ", studyTime=" + studyTime +
                ", studyUser=" + studyUser +
                "}";
    }
}
