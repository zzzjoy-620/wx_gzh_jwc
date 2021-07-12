package zzzjoy.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwc")
public class JwcConfig {
    // 保存在数据库的加密密钥
    private String aeskey;
    private String JwcService;
}
