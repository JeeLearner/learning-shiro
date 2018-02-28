package com.learn.chapter16.runas.entity;

import java.io.Serializable;

public class UserRunAs implements Serializable {
    private static final long serialVersionUID = 6153190499961771802L;

    private Long fromUserId;//授予身份帐号
    private Long toUserId;//被授予身份帐号

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        UserRunAs userRunAs = (UserRunAs) o;

        if (fromUserId != null ? !fromUserId.equals(userRunAs.fromUserId) : userRunAs.fromUserId != null) return false;
        return toUserId != null ? toUserId.equals(userRunAs.toUserId) : userRunAs.toUserId == null;
    }

    @Override
    public int hashCode() {
        int result = fromUserId != null ? fromUserId.hashCode() : 0;
        result = 31 * result + (toUserId != null ? toUserId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRunAs{" +
                "fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                '}';
    }
}
