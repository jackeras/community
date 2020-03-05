package life.my.community.mapper;

import life.my.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}