package by.bsac.services;

import by.bsac.models.nodes.CommentNode;
import by.bsac.models.nodes.PostNode;
import by.bsac.repositories.PostNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private PostNodeRepository repository;

    @Transactional
    public PostNode createPost(PostNode post) {
        return this.repository.save(post);
    }

    @Transactional
    public PostNode commentate(PostNode post, CommentNode comment) {
        return this.repository.save(post.commentate(comment));
    }


    public @Nullable PostNode getPost(PostNode post) {
        return this.repository.findById(post.getPost_id()).get();
    }




    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public void setRepository(PostNodeRepository repository) {
        this.repository = repository;
    }
}
