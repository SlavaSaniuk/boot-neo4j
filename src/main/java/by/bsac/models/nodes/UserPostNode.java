package by.bsac.models.nodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "UserPost")
@Getter
@Setter
@NoArgsConstructor
public class UserPostNode extends PostNode {

    @Property(name = "user_owner")
    private String post_user_owner;
}
