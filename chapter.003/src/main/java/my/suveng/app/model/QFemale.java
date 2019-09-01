package my.suveng.app.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFemale is a Querydsl query type for Female
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFemale extends EntityPathBase<Female> {

    private static final long serialVersionUID = -1984289376L;

    public static final QFemale female = new QFemale("female");

    public final StringPath age = createString("age");

    public final ListPath<Male, QMale> boyFriends = this.<Male, QMale>createList("boyFriends", Male.class, QMale.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final ListPath<Male, QMale> dogs = this.<Male, QMale>createList("dogs", Male.class, QMale.class, PathInits.DIRECT2);

    public final ListPath<Male, QMale> dreamers = this.<Male, QMale>createList("dreamers", Male.class, QMale.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final DateTimePath<java.util.Date> modifiedTime = createDateTime("modifiedTime", java.util.Date.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QFemale(String variable) {
        super(Female.class, forVariable(variable));
    }

    public QFemale(Path<? extends Female> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFemale(PathMetadata metadata) {
        super(Female.class, metadata);
    }

}

