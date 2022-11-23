package ee.valiit.back_vali_kuusk.domain.product.height;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@Entity
@Table(name = "height")
public class Height {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "gap", nullable = false)
    private String gap;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getGap() {
//        return gap;
//    }
//
//    public void setGap(String gap) {
//        this.gap = gap;
//    }

}