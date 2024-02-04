package com.project.BlogApp.paylod;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    @NotNull(message =  "Id should not be NULL")
    private Integer category_id;
    @NotEmpty
    @Size(min = 3, message = "Size should of minimum 3 characters")
    private String title;
    @NotEmpty(message = "Description should not be empty")
    private String description;
}
