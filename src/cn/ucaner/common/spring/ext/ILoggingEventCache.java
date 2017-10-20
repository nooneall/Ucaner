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

import java.util.List;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Abstraction interface for defining a cache for Logback {@code ILoggingEvent} instances.
 *
 * @author Bryan Turner
 * @since 0.1
 */
public interface ILoggingEventCache {

	/**
	 * Retrieves a list containing 0 or more cached {@code ILoggingEvent}s.
	 * <p/>
	 * Note: Implementations of this method must return a non-{@code null} list, even if the list is empty, and the
	 * returned list must not contain any {@code null} elements. If the caching implementation has discarded any of
	 * the events that were passed to {@link #put(ILoggingEvent)}, they should be completely omitted from the event
	 * list returned.
	 *
	 * @return a non-{@code null} list containing 0 or more cached events
	 */
	List<ILoggingEvent> get();

	/**
	 * Stores the provided event in the cache.
	 * <p/>
	 * Note: Implementations are free to "store" the event in a destructive or potentially-destructive way. This means
	 * the "cache" may actually just discard any events it receives, or it may wrap them in a {@code SoftReference} or
	 * other {@code java.lang.ref} type which could potentially result in the event being garbage collected before the
	 * {@link #get()} method is called.
	 *
	 * @param event the event to cache
	 */
	void put(ILoggingEvent event);
}
