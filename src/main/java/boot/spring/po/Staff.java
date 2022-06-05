package boot.spring.po;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Staff implements Serializable {
	@TableId
	private Integer id;
	private String username;
	private String password;
}