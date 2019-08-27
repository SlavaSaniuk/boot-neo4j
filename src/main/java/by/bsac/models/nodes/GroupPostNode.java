package by.bsac.models.nodes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label = "GroupPost")
@NoArgsConstructor
@Getter
@Setter
public class GroupPostNode extends PostNode {

    @Property(name = "group_owner")
    private String post_group_owner;
}
