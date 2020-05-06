package my.suveng.json.demo.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 *
 * @author suwenguang
 **/
@Data
@JsonIgnoreProperties(value = {"age", "houses"})
public class Bar<T> {
	private String name;
	private Integer age;
	private List<Long> houses;
	private T foo;
	private String testfilter;
}
