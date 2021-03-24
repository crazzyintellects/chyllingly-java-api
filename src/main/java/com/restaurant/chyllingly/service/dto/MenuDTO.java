package com.restaurant.chyllingly.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class MenuDTO implements Serializable {

    @NotNull
    private Integer menuID;

    @Size(max = 100)
    private String title;

    @Size(max = 2000)
    private String description;

    private List<MenuSectionDTO> menuSections;

}
