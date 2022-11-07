package net.javaguides.springboot.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name="measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="device",referencedColumnName="id",nullable = false)
    private Device device;
    @Column(name ="time",nullable = false)
    private Timestamp time;
    @Column(nullable = false,name ="energyConsumption")
    private int energyConsumption;
    @Column(nullable = false)
    private int consumption;






}
