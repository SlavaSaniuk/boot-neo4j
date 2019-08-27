package by.bsac.models.nodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "Post")
@NoArgsConstructor
@Getter
public class PostNode {

    @Id @GeneratedValue
    private Long post_id;

    @Property(name = "post_text")
    @Setter
    private String post_text;

    @Relationship(type = "COMMENTS_ON", direction = "INCOMING")
    private Set<CommentNode> post_comments = new HashSet<>();

    public PostNode commentate(CommentNode comment) {
        this.post_comments.add(comment);
        return this;
    }

    @Override
    public String toString() {
        return "PostNode{" +
                "post_text:" +this.post_text +"\n" +
                "\t post: comments:" + this.post_comments.toString() +"\n" +
                "}";
    }
}
