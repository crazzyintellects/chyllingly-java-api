package com.restaurant.chyllingly.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class MenuSectionDTO implements Serializable {
    @NotNull
    private Integer menuSectionId;

    @NotNull
    @Size(max = 100)
    private String title;

    @Size(max = 2000)
    private String description;

    private List<MenuItemDTO> menuItems;
}
