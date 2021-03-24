package com.restaurant.chyllingly.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class MenuItemDTO implements Serializable {

    @NotNull
    private Integer menuItemId;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Size(max = 2000)
    private String description;
    @NotNull
    private BigDecimal price;

    @NotNull
    private Boolean isAvailable;

    private Integer quantity;

}
