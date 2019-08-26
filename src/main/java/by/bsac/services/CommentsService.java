package by.bsac.services;

import by.bsac.models.nodes.CommentNode;
import by.bsac.models.nodes.PostNode;
import by.bsac.repositories.PostNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service(value = "CommentsService")
public class CommentsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentsService.class);

    private final PostNodeRepository post_repository;

    @Autowired
    public CommentsService(PostNodeRepository post_repository) {
        this.post_repository = post_repository;
    }

    @Transactional
    public void commentate(PostNode post, CommentNode comment) {
        LOGGER.info("Create new 'COMMENTS_ON' relationship.");
        this.post_repository.save(post.commentate(comment));
    }
}
