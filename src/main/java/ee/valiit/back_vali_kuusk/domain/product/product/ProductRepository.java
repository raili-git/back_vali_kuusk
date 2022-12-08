package ee.valiit.back_vali_kuusk.domain.product.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.user.id = ?1 and p.status = ?2")
    List<Product> findTreesBy(Integer userId, String status);

    @Query("select p from Product p where p.status = ?1")
    List<Product> findAllByStatus(String status);




    @Query( // Toob andmebaasist välja aktiivse staatusega  puud, mis on filtreeritud puutüübi, puu kõrguse ja maakonna järgi
            value = "SELECT *\n" +
                    "FROM product\n" +
                    "WHERE(\n" +
                    "        ( CASE\n" +
                    "              WHEN ?1 = 0 THEN type_id\n" +
                    "              ELSE 1\n" +
                    "            END\n" +
                    "            ) > 0\n" +
                    "  AND\n" +
                    "        ( CASE\n" +
                    "              WHEN ?1 <> 0 THEN ?1\n" +
                    "              ELSE type_id\n" +
                    "            END\n" +
                    "            ) = type_id)\n" +
                    "\n" +
                    "  AND\n" +
                    "\n" +
                    "(\n" +
                    "        ( CASE\n" +
                    "              WHEN ?2 = 0 THEN height_id\n" +
                    "              ELSE 1\n" +
                    "            END\n" +
                    "            ) > 0\n" +
                    "  AND\n" +
                    "        ( CASE\n" +
                    "              WHEN ?2 <> 0 THEN ?2\n" +
                    "              ELSE height_id\n" +
                    "            END\n" +
                    "            ) = height_id)\n" +
                    "\n" +
                    "  AND\n" +
                    "\n" +
                    "(\n" +
                    "        ( CASE\n" +
                    "              WHEN ?3 = 0 THEN county_id\n" +
                    "              ELSE 1\n" +
                    "            END\n" +
                    "            ) > 0\n" +
                    "  AND\n" +
                    "        ( CASE\n" +
                    "              WHEN ?3 <> 0 THEN ?3\n" +
                    "              ELSE county_id\n" +
                    "            END\n" +
                    "            ) = county_id)\n" +
                    "AND status = ?4", nativeQuery = true)
    List<Product> findProductBy(Integer typeId, Integer heightId, Integer countyId, String status);




}