package zzzjoy.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
public class DuplicateMessage {
    private String fromUserName;
    private String createTime;
    private Long curTime;

    public DuplicateMessage(String fromUserName, String createTime) {
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.curTime = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DuplicateMessage that = (DuplicateMessage) o;
        return Objects.equals(fromUserName, that.fromUserName) &&
                Objects.equals(createTime, that.createTime);
    }


}
