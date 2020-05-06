package my.suveng.json.demo.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 *
 * @author suwenguang
 **/
@Data
public class Foo {
	// 忽略字段
	@JsonIgnore
	private String name;
	private Integer age;
	private List<Long> houses;
}
