package core.beans;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MenuDTO {
    private int id;
    private String description;
    private String defaultPage;
    private Integer order;
    private List<SubMenuDTO> submenus;

}
