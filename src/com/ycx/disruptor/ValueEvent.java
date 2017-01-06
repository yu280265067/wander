package com.ycx.disruptor;
import com.lmax.disruptor.EventFactory;

public final class ValueEvent {
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int i) {
		this.value = i;
	}

	public final static EventFactory<ValueEvent> EVENT_FACTORY = new EventFactory<ValueEvent>() {
		public ValueEvent newInstance() {
			return new ValueEvent();
		}
	};
}