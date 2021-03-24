package com.restaurant.chyllingly.controller;

import com.restaurant.chyllingly.service.RestaurantOrderService;
import com.restaurant.chyllingly.service.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path = "/chyllingly/v1/order")
@CrossOrigin("http://localhost:3000")
public class RestaurantOrderController {

    @Autowired
    private RestaurantOrderService restaurantOrderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantOrderController.class);

    /**
     * Create an Order.
     *
     * @param orderDTO
     */
    @Validated
    @PostMapping
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        try {
            String orderId = restaurantOrderService.createOrder(orderDTO);
            return new ResponseEntity<>(orderId.substring(0, 7), HttpStatus.CREATED);
        } catch (Exception ex) {
            LOGGER.error("Unable to create order ", ex);
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Backing up shortly !");
        }

    }

    /**
     * Handle all Bad request Exception.
     *
     * @param ex
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
