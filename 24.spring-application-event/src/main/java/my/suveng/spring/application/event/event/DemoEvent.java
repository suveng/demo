package my.suveng.spring.application.event.event;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

/**
 *
 * @author suwenguang
 **/
@Getter
@Setter
@ToString
public class DemoEvent extends ApplicationEvent {
	private String id;

	private int count;

	/**
	 *
	 * @param source spring context
	 * @param id 自定义id
	 * @param count 自定义count
	 */
	public DemoEvent(ApplicationContext source, String id, int count) {
		super(source);
		this.id = id;
		this.count = count;
	}
}
