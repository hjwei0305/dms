package com.changhong.sei.mdms.commom.dto;

import java.io.Serializable;
import java.util.*;

/**
 * 实现功能：excel数据导入到出记录
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.00  2020-10-12 00:46
 */
public class ProcessResult<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 5441194279693602755L;

    /**
     * 文档id
     */
    private String docId;

    /**
     * 当前完成数量
     */
    private Long current = 0L;

    /**
     * 总数量
     */
    private Long total = 0L;

    /**
     * 进度说明
     */
    private String progressNote;

    /**
     * 批量处理失败的行项
     */
    private List<T> failedItems = new ArrayList<>();

    /**
     * 处理完成
     */
    private Boolean finished = Boolean.FALSE;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getProgressNote() {
        return progressNote;
    }

    public void setProgressNote(String progressNote) {
        this.progressNote = progressNote;
    }

    public List<T> getFailedItems() {
        return failedItems;
    }

    public void setFailedItems(List<T> failedItems) {
        this.failedItems = failedItems;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    /**
     * 添加一个处理失败的行项目
     *
     * @param item 行项目
     */
    public void addFailedItem(T item) {
        if (Objects.isNull(failedItems)) {
            failedItems = new ArrayList<>();
        }
        failedItems.add(item);
    }

    /**
     * 批量添加处理失败的行项目集合
     *
     * @param items 行项目集合
     */
    public void addFailedItems(Collection<T> items) {
        if (Objects.isNull(failedItems)) {
            failedItems = new ArrayList<>();
        }
        failedItems.addAll(items);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ")
                .add("状态:" + finished)
                .add("总数量:" + total)
                .add("成功数:" + current)
                .add("消息:'" + progressNote + "'")
                .add("文档id:'" + docId + "'")
                .toString();
    }
}
