package com.restaurant.chyllingly.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class RestaurantDTO implements Serializable {

    @NotNull
    private Integer restaurantId;

    @Size(max = 50)
    private String name;

    @Size(max = 2000)
    private String location;
}
