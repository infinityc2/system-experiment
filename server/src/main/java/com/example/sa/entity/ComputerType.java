package com.example.sa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "computer_type")
@Setter @Getter
@SequenceGenerator(name = "computer_type_seq", initialValue = 1)
public class ComputerType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computer_type_seq")
    private Long computerTypeId;
    private String type;
}