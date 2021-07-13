package zzzjoy.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "wx")
public class WxBaseConfig {
    private String appId;
    private String secret;
    private String token;
    private Integer limitTimes;
    private Integer frozenTime;
}
