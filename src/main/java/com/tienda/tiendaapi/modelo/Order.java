package com.tienda.tiendaapi.modelo;

import com.tienda.tiendaapi.enums.StatusOrderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private String id;
    private Long numberOrder;
    private Date registerDay;
    private StatusOrderEnum status;
  //  private User salesMan;
    private Map<String, CleaningProduct> products;
    private Map<String, Integer> quantities;
    private Integer total;
    private String cliente;
    private String vendedor;
}