package com.jiale.netty.core.model;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MoSessionImpl extends MoSession {

	public MoSessionImpl(Channel channel) {
		super(channel);
	}

	@Override
	public Object getAttribute(String name) {
		
		Object obj = this.getAttachment();
		if(obj == null || !(obj instanceof Map<?, ?>)){
			return null;
		}
		return ((Map<?, ?>)obj).get(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<String> getAttributeNames() {
		
		Object obj = this.getAttachment();
		if(obj == null || !(obj instanceof Map<?, ?>)){
			return null;
		}
		
		return (Set<String>) ((Map<?, ?>)obj).keySet();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setAttribute(String name, Object value) {
		
		Object obj = this.getAttachment();
		if(obj == null || !(obj instanceof Map<?, ?>)){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(name, value);
			this.setAttachment(map);
		}else{
			((Map<String, Object>)obj).put(name, value);
		}
		
	}

	@Override
	public void removeAttribute(String name) {
		
		Object obj = this.getAttachment();
		if(obj == null || !(obj instanceof Map<?, ?>)){
			return;
		}else{
			((Map<?, ?>)obj).remove(name);
		}
	}

	@Override
	public void removeAll() {
		
		this.removeAttachment();
	}

}
