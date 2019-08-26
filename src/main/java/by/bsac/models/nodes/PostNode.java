package by.bsac.models.nodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Post")
@NoArgsConstructor
@Getter
@Setter
public class PostNode {

    @Id @GeneratedValue
    private Long post_id;

    @Property(name = "post_text")
    private String post_text;

    @Property(name = "post_owner")
    private String post_owner;

    @Relationship(type = "COMMENTS_ON", direction = "INCOMING")
    private final Set<CommentNode> post_comments = new HashSet<>();

    public PostNode commentate(CommentNode comment) {
        this.post_comments.add(comment);
        return this;
    }
}
