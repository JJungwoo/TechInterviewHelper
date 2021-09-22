package module.problem;

import java.sql.Date;

public class ProblemVO {
    private Long pid;
    private String title;
    private String answer;
    private Long likeCount;
    private Long unlikeCount;
    private Date enrollDate;
    private Date updateDate;
    private Long tid;

    public static class Builder {

        private Long pid = 0L;
        private String title        = null;
        private String answer       = null;
        private Long likeCount      = 0L;
        private Long unlikeCount    = 0L;
        private Date enrollDate     = null;
        private Date updateDate     = null;
        private Long tid            = 0L;

        public Builder() {

        }

        public ProblemVO.Builder pid(Long pid) {
            this.pid = pid;
            return this;
        }

        public ProblemVO.Builder title(String title) {
            this.title = title;
            return this;
        }

        public ProblemVO.Builder answer(String answer) {
            this.answer = answer;
            return this;
        }

        public ProblemVO.Builder likeCount(Long likeCount) {
            this.likeCount = likeCount;
            return this;
        }

        public ProblemVO.Builder unlikeCount(Long unlikeCount) {
            this.unlikeCount = unlikeCount;
            return this;
        }

        public ProblemVO.Builder enrollDate(Date enrollDate) {
            this.enrollDate = enrollDate;
            return this;
        }

        public ProblemVO.Builder updateDate(Date updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public ProblemVO.Builder tid(Long tid) {
            this.tid = tid;
            return this;
        }

        public ProblemVO build() {
            return new ProblemVO(this);
        }
    }

    public ProblemVO(ProblemVO.Builder builder) {
        this.pid = builder.pid;
        this.title = builder.title;
        this.answer = builder.answer;
        this.likeCount = builder.likeCount;
        this.unlikeCount = builder.unlikeCount;
        this.enrollDate = builder.enrollDate;
        this.updateDate = builder.updateDate;
        this.tid = builder.tid;
    }

    public Long getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getAnswer() {
        return answer;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public Long getUnlikeCount() {
        return unlikeCount;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Long getTid() {
        return tid;
    }

    @Override
    public String toString() {
        return "ProblemVO{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", answer='" + answer + '\'' +
                ", likeCount=" + likeCount +
                ", unlikeCount=" + unlikeCount +
                ", enrollDate=" + enrollDate +
                ", updateDate=" + updateDate +
                ", tid=" + tid +
                '}';
    }

}
