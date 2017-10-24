/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.spring.ext;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
* @Package：cn.ucaner.common.spring.ext   
* @ClassName：EventCacheMode   
* @Description：   <p> EventCacheMode   </p>
* @Author： - DaoDou 
* @CreatTime：2017年10月24日 上午11:50:29   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
public enum EventCacheMode {

	OFF {
		@Override
		public ILoggingEventCache createCache() {
			return new ILoggingEventCache() {

				@Override
				public List<ILoggingEvent> get() {
					return Collections.emptyList();
				}

				@Override
				public void put(ILoggingEvent event) {
					//当缓存关闭时,当事件被接收时就会被丢弃
				}
			};
		}
	},
	
	ON {
		@Override
		public ILoggingEventCache createCache() {
			return new ILoggingEventCache() {

				private List<ILoggingEvent> events = new ArrayList<ILoggingEvent>();

				@Override
				public List<ILoggingEvent> get() {
					List<ILoggingEvent> list = Collections.unmodifiableList(events);
					events = null;
					return list;
				}

				@Override
				public void put(ILoggingEvent event) {
					events.add(event);
				}
			};
		}
	},
	
	SOFT {
		@Override
		public ILoggingEventCache createCache() {
			return new ILoggingEventCache() {

				private List<SoftReference<ILoggingEvent>> references = new ArrayList<SoftReference<ILoggingEvent>>();

				@Override
				public List<ILoggingEvent> get() {
					List<ILoggingEvent> events = new ArrayList<ILoggingEvent>(references.size());
					for (SoftReference<ILoggingEvent> reference : references) {
						ILoggingEvent event = reference.get();
						if (event != null) {
							events.add(event);
						}
					}
					references = null;
					return Collections.unmodifiableList(events);
				}
				@Override
				public void put(ILoggingEvent event) {
					references.add(new SoftReference<ILoggingEvent>(event));
				}
			};
		}
	};

	public abstract ILoggingEventCache createCache();
}
