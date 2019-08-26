package by.bsac.repositories;

import by.bsac.models.nodes.PostNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostNodeRepository extends Neo4jRepository<PostNode, Long> {
}
