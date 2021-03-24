package com.restaurant.chyllingly.service.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class OrderDTO implements Serializable {


    @NotNull(message = "Total Price is required")
    private BigDecimal totalPrice;

    @NotBlank(message = "Name is required")
    @Size(max = 100)
    private String customerName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String customerEmail;

    @NotEmpty(message = "No items selected to order")
    private List<MenuItemDTO> menuItems;
}
