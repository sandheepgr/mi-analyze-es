package com.microideation.app.analyze.es.repository;

import com.microideation.app.analyze.es.domain.CardTransactionEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sandheepgr on 25/7/16.
 */
@Repository
public interface CardTransactionEventRepository extends ElasticsearchRepository<CardTransactionEvent,String> {

    public List<CardTransactionEvent> findByParentIdAndActor(String parentId, String actor);


}
