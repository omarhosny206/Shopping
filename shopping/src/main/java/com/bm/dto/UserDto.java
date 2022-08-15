package com.bm.dto;

import com.bm.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
        // private Long id;
        private String firstName;
        private String lastName;
        private String email;
        // private List<Product> Products;
}
