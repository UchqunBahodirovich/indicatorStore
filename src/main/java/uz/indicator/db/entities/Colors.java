package uz.indicator.db.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.indicator.db.entities.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "db_color")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Colors extends BaseEntity {

    @Column()
    private String Color;
}
