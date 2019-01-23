package com.v2g.webservice.domain.reservation.reservation;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QReservation is a Querydsl query type for Reservation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReservation extends EntityPathBase<Reservation> {

    private static final long serialVersionUID = -34509573L;

    public static final QReservation reservation = new QReservation("reservation");

    public final com.v2g.webservice.domain.QBaseTimeEntity _super = new com.v2g.webservice.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath place = createString("place");

    public final StringPath rcost = createString("rcost");

    public final StringPath rdate = createString("rdate");

    public final StringPath relectirc = createString("relectirc");

    public final StringPath residual = createString("residual");

    public final StringPath rflag = createString("rflag");

    public final StringPath rtime = createString("rtime");

    public final StringPath userid = createString("userid");

    public QReservation(String variable) {
        super(Reservation.class, forVariable(variable));
    }

    public QReservation(Path<? extends Reservation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReservation(PathMetadata metadata) {
        super(Reservation.class, metadata);
    }

}

