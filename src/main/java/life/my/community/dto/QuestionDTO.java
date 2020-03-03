package life.my.community.dto;

import life.my.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer viewCount;
    private Integer creator;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
