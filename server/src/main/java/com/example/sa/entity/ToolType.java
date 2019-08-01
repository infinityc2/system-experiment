package com.example.sa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tool_type")
@Data
@NoArgsConstructor
@Setter @Getter
@SequenceGenerator(name = "tool_type_seq", initialValue = 1)
public class ToolType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tool_type_seq")
    private Long toolTypeId;

    @NotNull
    private String name;
}