package com.v2g.webservice.domain.customer.customer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 1003743243L;

    public static final QCustomer customer = new QCustomer("customer");

    public final com.v2g.webservice.domain.QBaseTimeEntity _super = new com.v2g.webservice.domain.QBaseTimeEntity(this);

    public final StringPath accrue = createString("accrue");

    public final StringPath accruecal = createString("accruecal");

    public final StringPath addr = createString("addr");

    public final StringPath contact = createString("contact");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath nowcal = createString("nowcal");

    public final StringPath nowday = createString("nowday");

    public final StringPath userid = createString("userid");

    public final StringPath userno = createString("userno");

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

