package by.bsac.models.nodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@NodeEntity(label = "Comment")
@NoArgsConstructor
public class CommentNode {

    @Id @GeneratedValue
    @Property(name = "comment_id")
    @Getter
    private Long comment_id;

    @Property(name = "comment_text")
    @Getter @Setter
    private String comment_text;

    @Property(name = "comment_owner")
    @Getter @Setter
    private String comment_owner;

}
