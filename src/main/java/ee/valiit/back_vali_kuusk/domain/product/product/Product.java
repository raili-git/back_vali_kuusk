package ee.valiit.back_vali_kuusk.domain.product.product;

import ee.valiit.back_vali_kuusk.domain.product.county.County;
import ee.valiit.back_vali_kuusk.domain.product.height.Height;
import ee.valiit.back_vali_kuusk.domain.product.type.Type;
import ee.valiit.back_vali_kuusk.domain.userrole.user.Address;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "height_id", nullable = false)
    private Height height;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

    @NotNull
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    @NotNull
    @Column(name = "price", nullable = false)
    private Integer price;


}