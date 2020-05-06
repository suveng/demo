package my.suveng.json.demo.jackson;

import lombok.Data;

import java.util.List;

/**
 *
 * @author suwenguang
 **/
@Data
public class Bar<T> {
	private String name;
	private Integer age;
	private List<Long> houses;
	private T foo;
}
