package com.microideation.app.analyze.es.repository;

import com.microideation.app.analyze.es.domain.ActivityEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sandheepgr on 25/7/16.
 */

@Repository
public interface ActivityEventRepository extends ElasticsearchRepository<ActivityEvent,String> {}
