package my.suveng.app.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMale is a Querydsl query type for Male
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QMale extends BeanPath<Male> {

    private static final long serialVersionUID = -2115824287L;

    public static final QMale male = new QMale("male");

    public final StringPath age = createString("age");

    public final NumberPath<Integer> handsome = createNumber("handsome", Integer.class);

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> property = createNumber("property", Integer.class);

    public QMale(String variable) {
        super(Male.class, forVariable(variable));
    }

    public QMale(Path<? extends Male> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMale(PathMetadata metadata) {
        super(Male.class, metadata);
    }

}

