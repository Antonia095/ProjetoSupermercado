package com.ifpb.projetoPoo.model;

import java.time.LocalDate;

public class Venda {
     private String codVenda;
      private LocalDate dataVenda;
      private ItemVenda[] vendido;
      private Funcionario vendidoPor;
      private double total;
}
