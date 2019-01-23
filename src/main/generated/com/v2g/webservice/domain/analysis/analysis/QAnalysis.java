package com.v2g.webservice.domain.analysis.analysis;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAnalysis is a Querydsl query type for Analysis
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnalysis extends EntityPathBase<Analysis> {

    private static final long serialVersionUID = -1016228535L;

    public static final QAnalysis analysis = new QAnalysis("analysis");

    public final com.v2g.webservice.domain.QBaseTimeEntity _super = new com.v2g.webservice.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Integer> vcost = createNumber("vcost", Integer.class);

    public final NumberPath<Integer> velectric = createNumber("velectric", Integer.class);

    public final StringPath vflag = createString("vflag");

    public final NumberPath<Integer> vpcost = createNumber("vpcost", Integer.class);

    public final NumberPath<Integer> vpelectric = createNumber("vpelectric", Integer.class);

    public QAnalysis(String variable) {
        super(Analysis.class, forVariable(variable));
    }

    public QAnalysis(Path<? extends Analysis> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnalysis(PathMetadata metadata) {
        super(Analysis.class, metadata);
    }

}

