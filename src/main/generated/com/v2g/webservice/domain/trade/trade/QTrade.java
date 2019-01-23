package com.v2g.webservice.domain.trade.trade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTrade is a Querydsl query type for Trade
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTrade extends EntityPathBase<Trade> {

    private static final long serialVersionUID = 1968804355L;

    public static final QTrade trade = new QTrade("trade");

    public final com.v2g.webservice.domain.QBaseTimeEntity _super = new com.v2g.webservice.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Integer> vcost = createNumber("vcost", Integer.class);

    public final NumberPath<Integer> velectric = createNumber("velectric", Integer.class);

    public final StringPath vflag = createString("vflag");

    public final StringPath vlocation = createString("vlocation");

    public final StringPath vtime = createString("vtime");

    public QTrade(String variable) {
        super(Trade.class, forVariable(variable));
    }

    public QTrade(Path<? extends Trade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrade(PathMetadata metadata) {
        super(Trade.class, metadata);
    }

}

