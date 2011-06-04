package distributed;

import java.io.Serializable;

@SuppressWarnings({ "serial", "unchecked" })
public class OrderWrapper<T> implements Comparable, Serializable {
	
	private Integer order;
	private T content;
	
	public OrderWrapper(int order, T content) {
		this.order = order;
		this.content = content;
	}
	
	@Override
	public int compareTo(Object other) {
		OrderWrapper ow = (OrderWrapper) other;		
		return order.compareTo(ow.getOrder());
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public T getContent() {
		return content;
	}

}
