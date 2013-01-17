package com.soccer.data.access;

import java.util.List;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.constructs.blocking.CacheEntryFactory;
import net.sf.ehcache.constructs.blocking.SelfPopulatingCache;

import com.soccer.entities.impl.TableRow;
import com.soccer.services.TableService;

public class StatsDA {
	private static StatsDA _inst = null;
	private static Ehcache _cache;

	private StatsDA() {
		CacheManager.create();
		Ehcache cache = CacheManager.getInstance().getCache("stats_cache");
		_cache = new SelfPopulatingCache(cache, new StatsEntryFactory());
	}

	static public synchronized StatsDA getInst() {
		if (_inst == null) {
			_inst = new StatsDA();

		}
		return _inst;
	}

	public void remove(String account) {
		_cache.remove(account);
	}

	/*
	 * read some data - notice the cache is treated as an SOR. the application
	 * code simply assumes the key will always be available
	 */
	@SuppressWarnings("unchecked")
	public List<TableRow> getPlayersTable(String account) {
		return (List<TableRow>) _cache.get(account).getObjectValue();
	}

	/**
	 * Implement the CacheEntryFactory that allows the cache to provide the
	 * read-through strategy
	 */
	private class StatsEntryFactory implements CacheEntryFactory {
		public Object createEntry(Object key) throws Exception {
			List<TableRow> table = TableService.getInstance().getPlayersTable(
					(String) key);
			return table;
		}
	}

}
