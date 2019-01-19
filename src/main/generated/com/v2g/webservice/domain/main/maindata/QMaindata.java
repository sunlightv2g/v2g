package com.v2g.webservice.domain.main.maindata;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaindata is a Querydsl query type for Maindata
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaindata extends EntityPathBase<Maindata> {

    private static final long serialVersionUID = 52113734L;

    public static final QMaindata maindata = new QMaindata("maindata");

    public final com.v2g.webservice.domain.QBaseTimeEntity _super = new com.v2g.webservice.domain.QBaseTimeEntity(this);

    public final NumberPath<Integer> carcnt = createNumber("carcnt", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath dayflag = createString("dayflag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath location = createString("location");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Integer> vaccure = createNumber("vaccure", Integer.class);

    public final NumberPath<Integer> vcar = createNumber("vcar", Integer.class);

    public final NumberPath<Integer> vcost = createNumber("vcost", Integer.class);

    public final NumberPath<Integer> velectric = createNumber("velectric", Integer.class);

    public QMaindata(String variable) {
        super(Maindata.class, forVariable(variable));
    }

    public QMaindata(Path<? extends Maindata> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaindata(PathMetadata metadata) {
        super(Maindata.class, metadata);
    }

}

