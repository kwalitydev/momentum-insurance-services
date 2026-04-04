package core.beans;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubMenuDTO {
    private int id;
    private String description;
    private String defaultPage;
    private Integer order;
}
